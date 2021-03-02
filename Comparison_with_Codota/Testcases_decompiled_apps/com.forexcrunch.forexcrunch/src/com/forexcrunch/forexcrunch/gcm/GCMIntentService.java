package com.forexcrunch.forexcrunch.gcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.util.Log;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.TabsActivity;
import com.google.android.gcm.GCMBaseIntentService;
import com.parse.ParseFacebookUtils;
import java.util.logging.Logger;

public class GCMIntentService extends GCMBaseIntentService {
    private static final String GCM_INTENT_FILTER = "com.forexcrunch.forexcrunch.GCM_MESSAGE";
    private static final String GCM_SENDER_ID = "591045420173";
    private static final Object LOCK = GCMIntentService.class;
    private static final String MESSAGE_CONTENT = "Body";
    private static final String MESSAGE_TYPE = "Type";
    private static final String TAG = "GCMIntentService";
    private static Logger log = Logger.getLogger(GCMIntentService.class.getName());
    private static PowerManager.WakeLock sWakeLock;

    public GCMIntentService() {
        super("591045420173");
    }

    /* access modifiers changed from: protected */
    public void onRegistered(final Context context, final String registrationId) {
        Log.i(TAG, "Device registered: regId = " + registrationId);
        CommonUtilities.displayMessage(context, "Your device registred with GCM");
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... params) {
                ServerUtilities.register(context, "name", ParseFacebookUtils.Permissions.User.EMAIL, registrationId);
                return null;
            }
        }.execute(new Void[0]);
    }

    /* access modifiers changed from: protected */
    public void onUnregistered(Context context, String registrationId) {
        Log.i(TAG, "Device unregistered");
        CommonUtilities.displayMessage(context, getString(C0089R.string.gcm_unregistered));
        ServerUtilities.unregister(context, registrationId);
    }

    /* access modifiers changed from: protected */
    public void onMessage(Context context, Intent intent) {
        Log.e(TAG, "***********Received message*******");
        String message = intent.getExtras().getString("price");
        CommonUtilities.displayMessage(context, message);
        if (message != null && !message.equals("")) {
            generateNotification(context, message);
        }
    }

    /* access modifiers changed from: protected */
    public void onDeletedMessages(Context context, int total) {
        Log.i(TAG, "Received deleted messages notification");
    }

    public void onError(Context context, String errorId) {
        Log.i(TAG, "Received error: " + errorId);
    }

    /* access modifiers changed from: protected */
    public boolean onRecoverableError(Context context, String errorId) {
        Log.i(TAG, "Received recoverable error: " + errorId);
        return super.onRecoverableError(context, errorId);
    }

    private static void generateNotification(Context context, String message) {
        Notification notification = new Notification(C0089R.drawable.iconnoti, message, System.currentTimeMillis());
        String title = context.getString(C0089R.string.app_name);
        Intent notificationIntent = new Intent(context, TabsActivity.class);
        notificationIntent.setFlags(603979776);
        notification.setLatestEventInfo(context, title, message, PendingIntent.getActivity(context, 0, notificationIntent, 0));
        notification.flags |= 16;
        notification.defaults |= 1;
        notification.defaults |= 2;
        ((NotificationManager) context.getSystemService("notification")).notify(0, notification);
    }
}
