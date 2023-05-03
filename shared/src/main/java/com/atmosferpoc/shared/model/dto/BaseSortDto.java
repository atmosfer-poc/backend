package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.shared.model.type.SortType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public abstract class BaseSortDto {
    private SortType type;

    public abstract Sort toSort();
}
