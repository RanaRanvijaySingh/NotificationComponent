package com.notificationcomponent.component.styles;

import android.support.v7.app.NotificationCompat;

import com.notificationcomponent.component.models.NotificationRequest;

class InboxStyleNotification implements BaseNotificationStyle {

    @Override
    public NotificationCompat.Style getStyle(final NotificationRequest notificationRequest) {
        final NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        for (int i = 0; i < notificationRequest.getInboxMessages().size(); i++) {
            style.addLine(notificationRequest.getInboxMessages().get(i));
        }
        return style;
    }
}
