package com.notificationcomponent.component.styles;

import android.support.v4.app.NotificationCompat;

import com.notificationcomponent.component.models.NotificationRequest;

public interface BaseNotificationStyle {

    NotificationCompat.Style getStyle(NotificationRequest notificationRequest);
}
