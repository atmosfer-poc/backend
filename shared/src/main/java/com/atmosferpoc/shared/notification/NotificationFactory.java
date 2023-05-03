package com.atmosferpoc.shared.notification;

import com.atmosferpoc.shared.notification.model.BaseNotificationModel;
import com.atmosferpoc.shared.notification.model.MailNotificationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationFactory {
    private final INotificationSender mailSenderImpl;

    @Async
    public void sendNotification(NotificationType type, BaseNotificationModel model) {
        if (type == NotificationType.EMAIL) {
            if (!(model instanceof MailNotificationModel)) {
                throw new IllegalArgumentException("This model not supported for this notification type.");
            }
            mailSenderImpl.sendNotification(model);
        } else {
            throw new UnsupportedOperationException("Unsupported notification type.");
        }
    }
}
