package com.atmosferpoc.integration.lov;


import java.util.List;

import com.atmosferpoc.shared.model.dto.LovSearchDto;
import com.atmosferpoc.core.model.type.LovType;
import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.Lov;

public interface LovService extends BaseEntityService<Lov, Long> {
	List<Lov> searchLovs(LovSearchDto lovSearchDto);

	void deleteAllByLoveType(List<LovType> lovType);

	String getDisplayValuesFromTerm(String term);
}
