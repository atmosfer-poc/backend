package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.core.model.type.ActivityType;

import lombok.Data;

@Data
public class UserActivityResource extends BaseEntityResource{
	private ActivityType activity;
	private Long id;
	private String description;
	private String date;
	private Long relatedEntityId;
}
