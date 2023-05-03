package com.atmosferpoc.shared.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SsoSessionCancelNotificationDto {
    private Long tenantId;

    private Long userId;

    private String email;

    private String msisdn;

    private String sessionId;

    private String status;
}
