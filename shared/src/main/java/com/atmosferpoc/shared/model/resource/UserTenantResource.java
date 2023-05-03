package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserTenantResource extends BaseEntityResource {
    private List<UserItemTenantResource> userList = new ArrayList<>();
    private Long totalCount = 0L;
    private int currentPage = 0;
    private int totalPage = 0;
    private int pageSize = 0;
}
