package com.atmosferpoc.shared.notification.implemantation;

import com.atmosferpoc.shared.notification.INotificationSender;
import com.atmosferpoc.shared.notification.model.BaseNotificationModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class SmsSenderImpl implements INotificationSender {
    @Override
    public void sendNotification(BaseNotificationModel model) {
        System.out.println("test");
    }
}
