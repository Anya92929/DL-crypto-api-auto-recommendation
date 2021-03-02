package com.tapcrowd.app.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String p = "";
        try {
            if (intent.hasExtra("package")) {
                try {
                    p = intent.getStringExtra("package");
                } catch (Exception e) {
                }
                if (p.equals(context.getPackageName())) {
                    String title = intent.getStringExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                    String message = intent.getStringExtra("message");
                    int icon = intent.getIntExtra(C1216LO.icon, 0);
                    String id = intent.getStringExtra(DBFavorites.KEY_EVENT_ID);
                    Notification notification = new Notification(icon, title, System.currentTimeMillis());
                    notification.setLatestEventInfo(context, title, message, PendingIntent.getActivity(context, Integer.parseInt(id), (Intent) intent.getParcelableExtra("intent"), 0));
                    notification.flags |= 16;
                    notification.defaults |= 2;
                    ((NotificationManager) context.getSystemService("notification")).notify(Integer.parseInt(id), notification);
                }
            }
        } catch (Exception e2) {
        }
    }
}
