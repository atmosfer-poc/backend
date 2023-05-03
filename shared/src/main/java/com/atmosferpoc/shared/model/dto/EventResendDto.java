package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.type.ChannelType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class EventResendDto {
    @NotNull
    @Positive
    private Long eventId;

    @NotEmpty
    private List<ChannelType> effectedPlatforms = new ArrayList<>();
}
