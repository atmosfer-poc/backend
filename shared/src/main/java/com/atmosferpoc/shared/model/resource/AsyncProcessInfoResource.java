package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.type.AsyncProcessType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsyncProcessInfoResource {
    private AsyncProcessType type;
    private boolean isContinue;
    private long successCount;
    private long errorCount;
    private long pendingCount;
    private int processRate;
    private String fileName;

    public void calculateRate() {
        processRate = (int) ((100 * (successCount + errorCount)) / (successCount + errorCount + pendingCount));
    }
}
