package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.type.LovType;

import lombok.Data;

@Data
public class LovSearchDto {
	private LovType lovType;
    private Long parentId;
    private boolean withChildren;
}
