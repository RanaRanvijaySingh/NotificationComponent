package com.notificationcomponent.component;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.NotificationCompat;

import com.notificationcomponent.NotificationReplyAction;
import com.notificationcomponent.R;
import com.notificationcomponent.component.models.NotificationRequest;
import com.notificationcomponent.component.styles.NotificationStyleFactory;

import static android.app.PendingIntent.getActivity;

public class NotificationUtil {

    private static final String REPLY_ACTION = "action";
    private static final String KEY_NOTIFICATION_ID = "isadlkf";
    private static final String KEY_MESSAGE_ID = "messageid";
    private final Context mContext;

    public NotificationUtil(final Context context) {
        this.mContext = context;
    }

    /**
     * Function to trigger simple notification.
     *
     * @param notificationRequest @{@link NotificationRequest}
     */
    public void triggerNotification(final NotificationRequest notificationRequest) {
        /** Initialize basic components */
        final NotificationManager notificationManager = (NotificationManager)
                mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = new NotificationCompat
                .Builder(mContext);

        /** Set notification channel */
        setChannel(notificationRequest, notificationManager);

        /** Set notification group */
        setGroup(notificationRequest, notificationManager);

        /** Set pending intent for the notification */
        setPendingIntent(notificationRequest, builder);

        /** Set basic notification components */
        builder.setSmallIcon(notificationRequest.getIconId())
                .setContentTitle(notificationRequest.getContentTitle())
                .setAutoCancel(notificationRequest.isAutoCancel())
                .setContentText(notificationRequest.getContentText());

        /** Set notification style */
        builder.setStyle(new NotificationStyleFactory(notificationRequest).getStyle());

        /** Set input action */
        setReplyAction(builder, notificationRequest.getReplyAction());

        /** Trigger notification */
        final Notification notification = builder.build();
        notificationManager.notify(notificationRequest.getNotificationId(), notification);
    }

    /**
     * Function to set reply action
     *
     * @param builder           @{@link NotificationCompat.Builder}
     * @param notifyReplyAction @{@link NotificationReplyAction}
     */
    private void setReplyAction(final NotificationCompat.Builder builder,
                                final NotificationReplyAction notifyReplyAction) {
        if (notifyReplyAction == null) {
            return;
        }
        final RemoteInput remoteInput = new RemoteInput.Builder(notifyReplyAction.getResultKey())
                .setLabel(notifyReplyAction.getReplyLabel())
                .build();
        final NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                R.mipmap.ic_launcher, notifyReplyAction.getReplyLabel(),
                getReplyPendingIntent(notifyReplyAction))
                .addRemoteInput(remoteInput)
                .setAllowGeneratedReplies(true)
                .build();
        builder.setShowWhen(true);
        builder.addAction(replyAction);
    }

    /**
     * Function to get pending intent for the notification action.
     *
     * @param notificationReplyAction @{@link NotificationReplyAction}
     * @return @{@link PendingIntent}
     */
    private PendingIntent getReplyPendingIntent(final NotificationReplyAction notificationReplyAction) {
        if (notificationReplyAction.getReplyActionClass() == null) {
            return null;
        }
        final Intent intent = new Intent(mContext, notificationReplyAction.getReplyActionClass());
        intent.setAction(notificationReplyAction.getAction());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        notificationReplyAction.setIntent(intent);
        final PendingIntent pendingIntent = PendingIntent.getActivity(mContext, notificationReplyAction
                .getRequestCode(), intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notificationReplyAction.setPendingIntent(pendingIntent);
        return pendingIntent;
    }

    /**
     * Function to set pending intent.
     *
     * @param notificationRequest @{@link NotificationRequest}
     * @param builder             @{@link NotificationCompat.Builder}
     */
    private void setPendingIntent(final NotificationRequest notificationRequest,
                                  final NotificationCompat.Builder builder) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && notificationRequest.getLauncherActivity() != null) {
            final Intent intent = new Intent(mContext, notificationRequest.getLauncherActivity());
            final TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
            stackBuilder.addParentStack(notificationRequest.getLauncherActivity());
            stackBuilder.addNextIntent(intent);
            final PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
        }
    }

    /**
     * Function to set notification channel.
     *
     * @param notificationRequest @{@link NotificationRequest}
     * @param notificationManager @{@link NotificationManager}
     */
    private void setChannel(final NotificationRequest notificationRequest,
                            final NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            final NotificationChannel notificationChannel =
                    getNotificationChannel(notificationRequest);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }


    /**
     * Function to set notification group.
     *
     * @param notificationRequest @{@link NotificationRequest}
     * @param notificationManager @{@link NotificationManager}
     */
    private void setGroup(final NotificationRequest notificationRequest,
                          final NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            final NotificationChannelGroup channelGroup =
                    getNotificationChannelGroup(notificationRequest);
            notificationManager.createNotificationChannelGroup(channelGroup);
        }
    }

    /**
     * Function to create a new notification channel group.
     *
     * @param request @{@link NotificationRequest}
     * @return @{@link NotificationChannelGroup}
     */
    private NotificationChannelGroup getNotificationChannelGroup(final NotificationRequest request) {
        return new NotificationChannelGroup(request.getGroupId(), request.getGroupName());
    }

    /**
     * Function to create a new notification channel.
     *
     * @param notificationRequest @{@link NotificationRequest}
     * @return @{@link NotificationChannel}
     */
    private NotificationChannel getNotificationChannel(final NotificationRequest notificationRequest) {
        final NotificationChannel notificationChannel = new
                NotificationChannel(notificationRequest.getChannelId(),
                notificationRequest.getChannelTitle(), notificationRequest.getNotificationImportance());
        notificationChannel.setDescription(notificationRequest.getChannelDescription());
        notificationChannel.enableLights(notificationRequest.isEnableLight());
        notificationChannel.enableVibration(notificationRequest.isEnableVibration());
        notificationChannel.setVibrationPattern(notificationRequest.getVibrationPattern());
        return notificationChannel;
    }
}
