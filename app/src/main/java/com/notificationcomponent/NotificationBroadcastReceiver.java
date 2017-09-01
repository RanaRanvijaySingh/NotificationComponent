package com.notificationcomponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.widget.Toast;

@SuppressWarnings("ALL")
public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if ("input_action".equals(intent.getAction())) {
//            final CharSequence message = getReplyMessage(intent);
//            final int messageId = intent.getIntExtra(KEY_MESSAGE_ID, 0);
            Toast.makeText(context, "Clicked on notification",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private CharSequence getReplyMessage(Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            return remoteInput.getCharSequence("Reply");
        }
        return null;
    }
}
