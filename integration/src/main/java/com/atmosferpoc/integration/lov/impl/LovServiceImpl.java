package com.atmosferpoc.integration.lov.impl;

import com.atmosferpoc.integration.lov.LovService;
import com.atmosferpoc.shared.model.dto.LovSearchDto;
import com.atmosferpoc.core.model.type.LovType;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.Lov;
import com.atmosferpoc.integration.lov.repository.LovRepository;
import com.atmosferpoc.integration.lov.repository.specifications.LovSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LovServiceImpl extends AbstractEntityService<Lov, Long> implements LovService {
	private final LovRepository lovRepository;

	@Override
	public List<Lov> searchLovs(LovSearchDto lovSearchDto) {
		return getJpaRepository().findAll(Specification
				.where(LovSpecification.type(lovSearchDto.getLovType()))
				.and(LovSpecification.parent(lovSearchDto.getParentId())));
		
	}
	
	@Override
	public BaseJpaRepository<Lov, Long> getJpaRepository() {
		return lovRepository;
	}

	@Transactional
	@Override
	public void deleteAllByLoveType(List<LovType> lovType) {
		lovRepository.deleteAllByTypeIn(lovType);
		
	}

	@Override
	public String getDisplayValuesFromTerm(String term) {
		Optional<Lov> lovOpt = lovRepository.findTopByTermAndType(term, LovType.TRANSLATION_TR);

		if (lovOpt.isPresent()) {
			return lovOpt.get().getDisplayName();
		}

		return term;
	}
}
