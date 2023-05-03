package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.shared.model.type.SortType;
import com.atmosferpoc.shared.model.type.UserSortFieldType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.Objects;

@Getter
@Setter
public class UserSortDto extends BaseSortDto {
    private UserSortFieldType field;

    public Sort toSort() {
        return Sort.by(Objects.equals(getType(), SortType.ASC) ? Sort.Direction.ASC : Sort.Direction.DESC, field.getPropertyPath());
    }
}
