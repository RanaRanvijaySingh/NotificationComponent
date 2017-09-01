package com.notificationcomponent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.notificationcomponent.component.models.NotificationMessage;
import com.notificationcomponent.component.models.NotificationRequest;
import com.notificationcomponent.component.NotificationUtil;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String NEW_LINE = "\n";
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        initComponents();
    }

    private void initComponents() {
        findViewById(R.id.buttonSimpleNotification).setOnClickListener(this);
        findViewById(R.id.buttonBigNotification).setOnClickListener(this);
        findViewById(R.id.buttonBigPictureNotification).setOnClickListener(this);
        findViewById(R.id.buttonInboxNotification).setOnClickListener(this);
        findViewById(R.id.buttonMessagingNotification).setOnClickListener(this);
        findViewById(R.id.buttonReplyNotification).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSimpleNotification:
                onClickSimpleNotification();
                break;
            case R.id.buttonBigNotification:
                onClickBigNotification();
                break;
            case R.id.buttonBigPictureNotification:
                onClickPictureNotification();
                break;
            case R.id.buttonInboxNotification:
                onClickInboxNotification();
                break;
            case R.id.buttonMessagingNotification:
                onClickMessagingNotification();
                break;
            case R.id.buttonReplyNotification:
                onClickReplyNotification();
                break;
        }
    }

    /**
     * Simple notification.
     */
    private void onClickSimpleNotification() {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setContentTitle("Simple notification");
        new NotificationUtil(this).triggerNotification(notificationRequest);
    }

    /**
     * Big notification
     */
    private void onClickBigNotification() {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setLauncherActivity(MainActivity.class);
        notificationRequest.setContentTitle("Big notification");
        notificationRequest.setContentText("Helper class for generating large-format " +
                "notifications that include multiple back-and-forth messages of varying " +
                "types between any number of people. ");
        notificationRequest.setNotificationStyle(NotificationRequest.Style.BIG_TEXT);
        new NotificationUtil(this).triggerNotification(notificationRequest);
    }

    /**
     * Picture notification
     */
    private void onClickPictureNotification() {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setLauncherActivity(MainActivity.class);
        notificationRequest.setContentTitle("Picture notification");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nfs);
        notificationRequest.setBigPicture(bitmap);
        notificationRequest.setNotificationStyle(NotificationRequest.Style.BIG_PICTURE);
        new NotificationUtil(this).triggerNotification(notificationRequest);
    }

    /**
     * Inbox notification
     */
    private void onClickInboxNotification() {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setContentTitle("Inbox notification");
        List<String> inboxMessages = new ArrayList<>();
        inboxMessages.add("First message");
        inboxMessages.add("Second message");
        inboxMessages.add("Third message");
        inboxMessages.add("+ more");
        notificationRequest.setInboxMessages(inboxMessages);
        notificationRequest.setNotificationStyle(NotificationRequest.Style.INBOX);
        new NotificationUtil(this).triggerNotification(notificationRequest);
    }

    /**
     * Messaging notification
     */
    private void onClickMessagingNotification() {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setContentTitle("Messaging notification");
        NotificationMessage message = new NotificationMessage();
        message.setMessage("This is message");
        message.setTime(System.currentTimeMillis());
        message.setSender("sender@gmail.com");
        List<NotificationMessage> messages = new ArrayList<>();
        messages.add(message);
        notificationRequest.setMessages(messages);
        notificationRequest.setNotificationStyle(NotificationRequest.Style.MESSAGING);
        new NotificationUtil(this).triggerNotification(notificationRequest);
    }

    /**
     * Reply notification
     */
    private void onClickReplyNotification() {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setContentTitle("Reply notification");
        NotificationReplyAction replyAction = new NotificationReplyAction(
                NotificationBroadcastReceiver.class, "Action 1", 12);
        notificationRequest.setReplyAction(replyAction);
        new NotificationUtil(this).triggerNotification(notificationRequest);
    }

    private void showCommingSoonMessage() {
        Toast.makeText(MainActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
    }

    private void log(String log) {
        String message = mTextMessage.getText().toString() + NEW_LINE + log;
        mTextMessage.setText(message);
    }
}
