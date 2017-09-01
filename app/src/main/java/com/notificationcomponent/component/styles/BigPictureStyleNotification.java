package com.notificationcomponent.component.styles;

import android.support.v7.app.NotificationCompat;

import com.notificationcomponent.component.models.NotificationRequest;

class BigPictureStyleNotification implements BaseNotificationStyle {

    @Override
    public NotificationCompat.Style getStyle(final NotificationRequest notificationRequest) {
        return new NotificationCompat.BigPictureStyle()
                .bigPicture(notificationRequest.getBigPicture());
    }
}
