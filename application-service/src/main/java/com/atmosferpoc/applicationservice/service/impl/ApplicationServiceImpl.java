package com.atmosferpoc.applicationservice.service.impl;

import com.atmosferpoc.applicationservice.repository.JobApplicationCommentRepository;
import com.atmosferpoc.applicationservice.service.ApplicationService;
import com.atmosferpoc.applicationservice.repository.JobApplicationRepository;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.core.util.SecurityUtil;
import com.atmosferpoc.entity.JobAdvertisementApplication;
import com.atmosferpoc.entity.JobAdvertisementApplicationComment;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.shared.model.dto.CommentDto;
import com.atmosferpoc.shared.model.resource.ResourceDTO;
import com.atmosferpoc.shared.model.type.ApplicationAction;
import com.atmosferpoc.shared.model.type.ApplicationStatus;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl extends AbstractEntityService<JobAdvertisementApplication, Long> implements ApplicationService {
    private final JobApplicationRepository applicationRepository;
    private final JobApplicationCommentRepository applicationCommentRepository;

    @SneakyThrows
    @Override
    public ResourceDTO getCV(Long id) {
        JobAdvertisementApplication application = getEntity(id);

        byte[] bytes = Files.readAllBytes(Paths.get(application.getCvPath()));

        return ResourceDTO
                .builder()
                .resource(new ByteArrayResource(bytes))
                .mediaType(MediaType.APPLICATION_PDF)
                .name(application.getName().concat("-").concat(application.getSurname()).concat("-cv.pdf"))
                .build();
    }

    @Override
    public void action(Long id, ApplicationAction action, CommentDto commentDto) {
        JobAdvertisementApplication application = getEntity(id);

        if (!Objects.equals(getExpectedUserRole(application), SecurityUtil.getRole())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Unauthorize !");
        }

        JobAdvertisementApplicationComment comment = prepareComment(application, action, commentDto);

        applicationCommentRepository.save(comment);

        ApplicationStatus nextStatus = getNextStatus(application, action);

        application.setStatus(nextStatus);

        put(application.getId(), application);
    }

    private ApplicationStatus getNextStatus(JobAdvertisementApplication application, ApplicationAction action) {
        if (Objects.equals(action, ApplicationAction.REJECT)) {
            return ApplicationStatus.REJECTED;
        }

        if (Objects.equals(application.getStatus(), ApplicationStatus.PENDING_HR)) {
            return ApplicationStatus.PENDING_TECH;
        } else if (Objects.equals(application.getStatus(), ApplicationStatus.PENDING_TECH)) {
            return ApplicationStatus.PENDING_FINANCE;
        }

        throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Unexpected application status !");
    }

    private JobAdvertisementApplicationComment prepareComment(JobAdvertisementApplication application, ApplicationAction action, CommentDto commentDto) {
        Long loggedUserId = SecurityUtil.getLoggedUserId();
        User user = new User();
        user.setId(loggedUserId);

        JobAdvertisementApplicationComment comment = new JobAdvertisementApplicationComment();
        comment.setUser(user);
        comment.setApplication(application);
        comment.setComment(commentDto.getComment());
        comment.setAction(action);

        return comment;
    }

    private RoleType getExpectedUserRole(JobAdvertisementApplication application) {
        if (Objects.equals(application.getStatus(), ApplicationStatus.PENDING_HR)) {
            return RoleType.HR;
        } else if (Objects.equals(application.getStatus(), ApplicationStatus.PENDING_TECH)) {
            return RoleType.TECHNICAL;
        } else if (Objects.equals(application.getStatus(), ApplicationStatus.PENDING_FINANCE)) {
            return RoleType.FINANCE;
        }

        throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Unexpected application status !");
    }

    @Override
    public BaseJpaRepository<JobAdvertisementApplication, Long> getJpaRepository() {
        return applicationRepository;
    }
}
