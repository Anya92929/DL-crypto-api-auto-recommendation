package com.parse;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.google.analytics.tracking.android.ModelFields;
import org.json.JSONObject;

public class StandardPushCallback extends PushCallback {
    static boolean disableNotifications = false;
    static int totalNotifications = 0;

    private Bundle makeBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("com.parse.Data", this.pushData.toString());
        bundle.putString("com.parse.Channel", this.channel);
        return bundle;
    }

    public void run() {
        totalNotifications++;
        if (!disableNotifications) {
            if (this.pushData == null) {
                this.pushData = new JSONObject();
            }
            if (this.pushData.has("action")) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.putExtras(makeBundle());
                broadcastIntent.setAction(this.pushData.optString("action"));
                this.service.getBaseContext().sendBroadcast(broadcastIntent);
                if (!this.pushData.has("alert") && !this.pushData.has("title")) {
                    return;
                }
            }
            String text = this.pushData.optString("alert", "Notification received.");
            String title = this.pushData.optString("title", this.localData.optString(ModelFields.APP_NAME));
            long when = System.currentTimeMillis();
            ComponentName componentName = new ComponentName(this.localData.optString("activityPackage"), this.localData.optString("activityClass"));
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.setFlags(268435456);
            intent.putExtras(makeBundle());
            PendingIntent contentIntent = PendingIntent.getActivity(this.service, (int) when, intent, 0);
            Notification notif = new Notification(this.localData.optInt("icon"), text, when);
            notif.flags |= 16;
            notif.defaults |= -1;
            notif.setLatestEventInfo(this.service, title, text, contentIntent);
            NotificationManager nm = (NotificationManager) this.service.getSystemService("notification");
            int notificationId = (int) when;
            try {
                nm.notify(notificationId, notif);
            } catch (SecurityException e) {
                notif.defaults = 5;
                nm.notify(notificationId, notif);
            }
        }
    }
}
