package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.type.ChannelType;
import com.atmosferpoc.core.model.type.EventAction;
import com.atmosferpoc.core.model.type.EventCallbackStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlatformStateResource {
    private EventCallbackStatus state;
    private EventAction action;
    private ChannelType platform;

}
