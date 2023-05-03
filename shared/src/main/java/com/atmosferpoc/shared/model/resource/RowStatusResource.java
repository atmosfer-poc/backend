package com.atmosferpoc.shared.model.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RowStatusResource {
    private long errorCount;
    private long successCount;
    private long pendingCount;
    private String fileName;
}
