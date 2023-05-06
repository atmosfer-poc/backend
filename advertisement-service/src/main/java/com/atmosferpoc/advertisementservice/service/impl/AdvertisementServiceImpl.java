package com.atmosferpoc.advertisementservice.service.impl;

import com.atmosferpoc.advertisementservice.converter.AdvertisementApplicationConverter;
import com.atmosferpoc.advertisementservice.repository.AdvertisementApplicationRepository;
import com.atmosferpoc.advertisementservice.repository.AdvertisementRepository;
import com.atmosferpoc.advertisementservice.service.AdvertisementService;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.core.util.SecurityUtil;
import com.atmosferpoc.entity.JobAdvertisementApplication;
import com.atmosferpoc.entity.JobAdvertisements;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.shared.model.dto.AdvertisementApplyDto;
import com.atmosferpoc.shared.model.resource.ApplicationResource;
import com.atmosferpoc.shared.model.resource.IdTitleResource;
import com.atmosferpoc.shared.model.type.JobAdvertisementStatus;
import com.atmosferpoc.shared.util.IOHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdvertisementServiceImpl extends AbstractEntityService<JobAdvertisements, Long> implements AdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementApplicationRepository advertisementApplicationRepository;

    @Override
    protected JobAdvertisements preSave(JobAdvertisements entity) {
        if (advertisementRepository.existsByTitle(entity.getTitle())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Title already exist");
        }

        return super.preSave(entity);
    }

    @Override
    public BaseJpaRepository<JobAdvertisements, Long> getJpaRepository() {
        return advertisementRepository;
    }

    @Override
    public List<IdTitleResource> getOpenSummaries() {
        return advertisementRepository.findAllByStatus(JobAdvertisementStatus.OPEN).stream().map(a -> {
            IdTitleResource item = new IdTitleResource();
            item.setId(a.getId());
            item.setTitle(a.getTitle());

            return item;
        }).toList();
    }

    @Override
    public void apply(Long advertisementId, AdvertisementApplyDto dto, String folderPath) {
        if (!Objects.equals(SecurityUtil.getRole(), RoleType.APPLIER)) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Unauthorize");
        }

        if (Objects.isNull(dto.getCv())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "CV must be not null");
        }

        JobAdvertisements advertisement = getEntity(advertisementId);

        if (!Objects.equals(advertisement.getStatus(), JobAdvertisementStatus.OPEN)) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Advertisement is not open.");
        }

        Long loggedUserId = SecurityUtil.getLoggedUserId();

        String cvName = "application-".concat(String.valueOf(advertisementId)).concat(String.valueOf(loggedUserId));

        String fileFullPath = IOHelper.save(dto.getCv(), folderPath, cvName);

        User user = new User();
        user.setId(loggedUserId);

        JobAdvertisementApplication application = new JobAdvertisementApplication();
        application.setCity(dto.getCity());
        application.setJob(advertisement);
        application.setCvPath(fileFullPath);
        application.setUser(user);
        application.setName(dto.getName());
        application.setSurname(dto.getSurname());
        application.setTckn(dto.getTckn());
        application.setPhoneNumber(dto.getPhoneNumber());
        application.setWorkType(dto.getWorkType());

        advertisementApplicationRepository.save(application);
    }

    @Override
    public List<ApplicationResource> getApplications(Long id) {
        return advertisementApplicationRepository
                .findAllByJobId(id)
                .stream()
                .map(AdvertisementApplicationConverter::toResource)
                .toList();
    }
}
