package com.notificationcomponent.component.styles;

import android.support.v7.app.NotificationCompat;

import com.notificationcomponent.component.models.NotificationRequest;

public class NotificationStyleFactory {
    private final NotificationRequest mNotificationRequest;

    public NotificationStyleFactory(final NotificationRequest notificationRequest) {
        this.mNotificationRequest = notificationRequest;
    }

    public NotificationCompat.Style getStyle() {
        switch (mNotificationRequest.getNotificationStyle()) {
            case NotificationRequest.Style.BIG_TEXT:
                return new BigTestStyleNotification().getStyle(mNotificationRequest);

            case NotificationRequest.Style.BIG_PICTURE:
                return new BigPictureStyleNotification().getStyle(mNotificationRequest);

            case NotificationRequest.Style.INBOX:
                return new InboxStyleNotification().getStyle(mNotificationRequest);

            case NotificationRequest.Style.MESSAGING:
                return new MessagingStyleNotification().getStyle(mNotificationRequest);

            default:
                return null;
        }
    }
}
