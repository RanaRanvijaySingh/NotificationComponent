package com.notificationcomponent.component.styles;

import android.support.v7.app.NotificationCompat;

import com.notificationcomponent.component.models.NotificationMessage;
import com.notificationcomponent.component.models.NotificationRequest;

class MessagingStyleNotification implements BaseNotificationStyle {

    @Override
    public NotificationCompat.Style getStyle(final NotificationRequest notificationRequest) {
        final NotificationCompat.MessagingStyle style =
                new NotificationCompat.MessagingStyle("Reply");
        for (int i = 0; i < notificationRequest.getMessages().size(); i++) {
            final NotificationMessage message = notificationRequest.getMessages().get(i);
            style.addMessage(message.getMessage(),
                    message.getTime(), message.getSender());
        }
        return style;
    }
}
