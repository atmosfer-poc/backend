package com.atmosferpoc.logservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LogNotificationDto {
    private String message;
    private String level;
    private String timestamp;
}
