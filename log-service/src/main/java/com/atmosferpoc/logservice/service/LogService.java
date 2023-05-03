package com.atmosferpoc.logservice.service;

import com.atmosferpoc.logservice.model.Log;
import com.atmosferpoc.logservice.model.LogNotificationDto;

public interface LogService {
    Log createLog(LogNotificationDto log);
}
