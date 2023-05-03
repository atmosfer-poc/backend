package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.IBaseDto;
import com.atmosferpoc.core.model.type.ChannelType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
public class UserGetParamsDto implements IBaseDto {
    private List< String> mailList = new ArrayList<>();
    private List<String> msisdnList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();
    private List<String> surnameList = new ArrayList<>();
    private TenantInfo tenantInfo;
    private List<String> statusList = new ArrayList<>();
    private boolean pageable;
    private int pageSize = 10;
    private int pageCount = 0;
    private UserSortDto sort;
    private String searchKey;
    private List<ChannelType> channels = new ArrayList<>();

    @Override
    public void validate() {
        if(Objects.nonNull(tenantInfo)){
            tenantInfo.validate();
        }
    }
}
