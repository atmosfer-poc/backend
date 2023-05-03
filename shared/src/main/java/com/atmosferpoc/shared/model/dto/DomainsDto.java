package com.atmosferpoc.shared.model.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DomainsDto {
    private List<String> domains = new ArrayList<>();
}
