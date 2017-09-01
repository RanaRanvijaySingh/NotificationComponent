package com.notificationcomponent;

import android.app.PendingIntent;
import android.content.Intent;

@SuppressWarnings("ALL")
public class NotificationReplyAction {
    private static final String DEFAULT_REPLY_LABEL = "Reply";
    private static final String DEFAULT_INPUT_ACTION = "input_action";
    private static final String DEFAULT_RESULT_KEY = "result_key";
    private final Class<?> mReplyActionClass;
    private final int mRequestCode;
    private final String mIntentAction;
    private String replyLabel = DEFAULT_REPLY_LABEL;
    private String action = DEFAULT_INPUT_ACTION;
    private Intent intent;
    private PendingIntent pendingIntent;
    private String resultKey = DEFAULT_RESULT_KEY;

    public NotificationReplyAction(final Class<?> aClass,
                                   final String intentAction, final int requestCode) {
        this.mReplyActionClass = aClass;
        this.mIntentAction = intentAction;
        this.mRequestCode = requestCode;
    }

    public Class<?> getReplyActionClass() {
        return mReplyActionClass;
    }

    public int getRequestCode() {
        return mRequestCode;
    }

    public String getIntentAction() {
        return mIntentAction;
    }

    public String getReplyLabel() {
        return replyLabel;
    }

    public void setReplyLabel(String replyLabel) {
        this.replyLabel = replyLabel;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    public PendingIntent getPendingIntent() {
        return pendingIntent;
    }

    public String getResultKey() {
        return resultKey;
    }

    public void setResultKey(String resultKey) {
        this.resultKey = resultKey;
    }
}
