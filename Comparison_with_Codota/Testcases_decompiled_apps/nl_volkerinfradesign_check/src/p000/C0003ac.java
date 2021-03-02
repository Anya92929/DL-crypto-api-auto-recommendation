package p000;

import android.app.Notification;
import android.app.NotificationManager;

/* renamed from: ac */
public class C0003ac {
    /* renamed from: a */
    public static void m4a(NotificationManager notificationManager, String str, int i) {
        notificationManager.cancel(str, i);
    }

    /* renamed from: a */
    public static void m5a(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(str, i, notification);
    }
}
