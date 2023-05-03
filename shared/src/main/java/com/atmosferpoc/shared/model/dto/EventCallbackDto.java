package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.type.ChannelType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EventCallbackDto {
    private String transactionId;
    private ChannelType platform;
    private int result;
    private long errorCode;
    private String errorMessage;
}
