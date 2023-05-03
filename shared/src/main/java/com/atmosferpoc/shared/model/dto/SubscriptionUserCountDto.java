package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.shared.model.type.PeriodType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubscriptionUserCountDto extends BaseEntityDto {
    private PeriodType period;
}
