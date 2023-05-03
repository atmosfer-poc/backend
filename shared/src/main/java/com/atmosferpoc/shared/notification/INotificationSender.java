package com.atmosferpoc.shared.notification;

import com.atmosferpoc.shared.notification.model.BaseNotificationModel;

public interface INotificationSender {
    void sendNotification(BaseNotificationModel model);
}
