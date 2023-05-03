package com.atmosferpoc.shared.model.dto;

import java.util.List;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.model.type.LovType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LovDto extends BaseEntityDto{
	private Long id;
    private String displayName;
    private String term;
    private LovType type;
    private LovDto parent;
    private List<LovDto> children;
}
