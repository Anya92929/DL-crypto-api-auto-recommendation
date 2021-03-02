package com.tapcrowd.app.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;

public class Notifications {
    public static void createNotification(Intent intent, String id, String title, String message, int icon, long when) {
        Intent broadcastintent = new Intent();
        broadcastintent.setAction("com.tapcrowd.app.action.notify");
        broadcastintent.putExtra("intent", intent);
        broadcastintent.putExtra(DBFavorites.KEY_EVENT_ID, id);
        broadcastintent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, title);
        broadcastintent.putExtra("message", message);
        broadcastintent.putExtra(C1216LO.icon, icon);
        ((AlarmManager) App.act.getSystemService("alarm")).set(0, when, PendingIntent.getBroadcast(App.act, Integer.parseInt(id), broadcastintent, 134217728));
    }

    public static void createNotification(Context c, Intent intent, String id, String title, String message, int icon, long when) {
        Intent broadcastintent = new Intent();
        broadcastintent.setAction("com.tapcrowd.app.action.notify");
        broadcastintent.putExtra("package", c.getPackageName());
        broadcastintent.putExtra("intent", intent);
        broadcastintent.putExtra(DBFavorites.KEY_EVENT_ID, id);
        broadcastintent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, title);
        broadcastintent.putExtra("message", message);
        broadcastintent.putExtra(C1216LO.icon, icon);
        ((AlarmManager) c.getSystemService("alarm")).set(0, when, PendingIntent.getBroadcast(c, Integer.parseInt(id), broadcastintent, 1073741824));
    }

    public static void cancelNotification(Intent intent, String id, String title, String message, int icon, long when) {
        Intent broadcastintent = new Intent();
        broadcastintent.setAction("com.tapcrowd.app.action.notify");
        broadcastintent.putExtra("intent", intent);
        broadcastintent.putExtra(DBFavorites.KEY_EVENT_ID, id);
        broadcastintent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, title);
        broadcastintent.putExtra("message", message);
        broadcastintent.putExtra(C1216LO.icon, icon);
        ((AlarmManager) App.act.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(App.act, Integer.parseInt(id), broadcastintent, 134217728));
    }
}
