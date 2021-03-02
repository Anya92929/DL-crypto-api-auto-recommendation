package p000;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

/* renamed from: aa */
public class C0001aa {
    /* renamed from: a */
    public static Notification m2a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        return notification;
    }
}
