package com.atmosferpoc.integration.lov.repository;

import java.util.List;
import java.util.Optional;

import com.atmosferpoc.core.model.type.LovType;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.Lov;

public interface LovRepository extends BaseJpaRepository<Lov, Long>{
	void deleteAllByTypeIn(List<LovType> lovType);

	Optional<Lov> findTopByTermAndType(String term, LovType type);
}
