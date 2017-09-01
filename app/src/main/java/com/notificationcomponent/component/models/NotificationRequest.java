package com.notificationcomponent.component.models;

import android.graphics.Bitmap;

import com.notificationcomponent.NotificationReplyAction;
import com.notificationcomponent.R;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class NotificationRequest {
    private static final String DEFAULT_CONTENT_TITLE = "Content title";
    private static final int DEFAULT_NOTIFICATION_IMAGE_ID = R.mipmap.ic_launcher;
    private static final String DEFAULT_NOTIFICATION_CONTENT = "Content text";
    private static final long[] DEFAULT_NOTIFICATION_VIBRATION_PATTERN =
            new long[]{100, 200, 300, 400, 500, 300, 200, 400};
    private static final String DEFAULT_CHANNEL_TITLE = "Channel title";
    private static final String DEFAULT_CHANNEL_DESCRIPTION = "Channel description";
    private static final int DEFAULT_NOTIFICATION_IMPORTANCE = 3;
    private static final String DEFAULT_CHANNEL_ID = String.valueOf(System.currentTimeMillis());
    private static final String DEFAULT_GROUP_ID = String.valueOf(System.currentTimeMillis());
    private static final String DEFAULT_GROUP_NAME = "Group name";
    private static final String DEFAULT_INPUT_LABEL = "Reply";

    private String contentTitle = DEFAULT_CONTENT_TITLE;
    private int iconId = DEFAULT_NOTIFICATION_IMAGE_ID;
    private String contentText = DEFAULT_NOTIFICATION_CONTENT;
    private long[] vibrationPattern = DEFAULT_NOTIFICATION_VIBRATION_PATTERN;
    private String channelId = DEFAULT_CHANNEL_ID;
    private String channelTitle = DEFAULT_CHANNEL_TITLE;
    private String channelDescription = DEFAULT_CHANNEL_DESCRIPTION;
    private int notificationImportance = DEFAULT_NOTIFICATION_IMPORTANCE;
    private String groupId = DEFAULT_GROUP_ID;
    private String groupName = DEFAULT_GROUP_NAME;
    private int notificationId;
    private Class<?> launcherActivity;
    private boolean enableLight = true;
    private boolean isAutoCancel = true;
    private boolean enableVibration = true;
    private int notificationStyle;
    private Bitmap bigPicture;
    private List<String> inboxMessages = new ArrayList<>();
    private List<NotificationMessage> messages = new ArrayList<NotificationMessage>();
    private String inputLabel = DEFAULT_INPUT_LABEL;
    private NotificationReplyAction replyAction;

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public long[] getVibrationPattern() {
        return vibrationPattern;
    }

    public void setVibrationPattern(long[] vibrationPattern) {
        this.vibrationPattern = vibrationPattern;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public int getNotificationImportance() {
        return notificationImportance;
    }

    public void setNotificationImportance(int notificationImportance) {
        this.notificationImportance = notificationImportance;
    }

    public boolean isEnableLight() {
        return enableLight;
    }

    public void setEnableLight(boolean enableLight) {
        this.enableLight = enableLight;
    }

    public boolean isEnableVibration() {
        return enableVibration;
    }

    public void setEnableVibration(boolean enableVibration) {
        this.enableVibration = enableVibration;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getNotificationId() {
        if (notificationId == 0) {
            notificationId = (int) (System.currentTimeMillis() % 1000L);
        }
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public void setLauncherActivity(Class<?> launcherActivity) {
        this.launcherActivity = launcherActivity;
    }

    public Class<?> getLauncherActivity() {
        return launcherActivity;
    }

    public boolean isAutoCancel() {
        return isAutoCancel;
    }

    public void setAutoCancel(boolean isAutoCancel) {
        this.isAutoCancel = isAutoCancel;
    }

    public int getNotificationStyle() {
        return notificationStyle;
    }

    public void setNotificationStyle(int notificationStyle) {
        this.notificationStyle = notificationStyle;
    }

    public Bitmap getBigPicture() {
        return bigPicture;
    }

    public void setBigPicture(Bitmap bigPicture) {
        this.bigPicture = bigPicture;
    }

    public List<String> getInboxMessages() {
        return inboxMessages;
    }

    public void setInboxMessages(List<String> inboxMessages) {
        this.inboxMessages = inboxMessages;
    }

    public List<NotificationMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<NotificationMessage> messages) {
        this.messages = messages;
    }

    public String getInputLabel() {
        return inputLabel;
    }

    public void setInputLabel(String inputLabel) {
        this.inputLabel = inputLabel;
    }

    public void setReplyAction(NotificationReplyAction replyAction) {
        this.replyAction = replyAction;
    }

    public NotificationReplyAction getReplyAction() {
        return replyAction;
    }

    public class Style {
        public static final int SIMPLE = 11;
        public static final int BIG_TEXT = SIMPLE + 1;
        public static final int BIG_PICTURE = BIG_TEXT + 1;
        public static final int INBOX = BIG_PICTURE + 1;
        public static final int MESSAGING = INBOX + 1;
        public static final int REPLY = MESSAGING + 1;
    }
}
