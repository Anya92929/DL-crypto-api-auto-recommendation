package android.support.p001v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p001v4.app.NotificationCompatBase;
import android.support.p001v4.app.RemoteInputCompatBase;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompatKitKat */
class NotificationCompatKitKat {

    /* renamed from: android.support.v4.app.NotificationCompatKitKat$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, C2018z {

        /* renamed from: a */
        private Notification.Builder f358a;

        /* renamed from: b */
        private Bundle f359b;

        /* renamed from: c */
        private List<Bundle> f360c = new ArrayList();

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            Notification.Builder lights = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            Notification.Builder ongoing = lights.setOngoing(z6);
            if ((notification.flags & 8) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z7);
            if ((notification.flags & 16) != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z8).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            this.f358a = deleteIntent.setFullScreenIntent(pendingIntent2, z9).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f359b = new Bundle();
            if (bundle != null) {
                this.f359b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f359b.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f359b.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str != null) {
                this.f359b.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                if (z5) {
                    this.f359b.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    this.f359b.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str2 != null) {
                this.f359b.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
            }
        }

        public void addAction(NotificationCompatBase.Action action) {
            this.f360c.add(NotificationCompatJellybean.m344a(this.f358a, action));
        }

        public Notification.Builder getBuilder() {
            return this.f358a;
        }

        public Notification build() {
            SparseArray<Bundle> a = NotificationCompatJellybean.m350a(this.f360c);
            if (a != null) {
                this.f359b.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a);
            }
            this.f358a.setExtras(this.f359b);
            return this.f358a.build();
        }
    }

    /* renamed from: a */
    public static Bundle m363a(Notification notification) {
        return notification.extras;
    }

    /* renamed from: b */
    public static int m365b(Notification notification) {
        if (notification.actions != null) {
            return notification.actions.length;
        }
        return 0;
    }

    /* renamed from: a */
    public static NotificationCompatBase.Action m364a(Notification notification, int i, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        Notification.Action action = notification.actions[i];
        Bundle bundle = null;
        SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        if (sparseParcelableArray != null) {
            bundle = (Bundle) sparseParcelableArray.get(i);
        }
        return NotificationCompatJellybean.m349a(factory, factory2, action.icon, action.title, action.actionIntent, bundle);
    }

    /* renamed from: c */
    public static boolean m366c(Notification notification) {
        return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    }

    /* renamed from: d */
    public static String m367d(Notification notification) {
        return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    }

    /* renamed from: e */
    public static boolean m368e(Notification notification) {
        return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    }

    /* renamed from: f */
    public static String m369f(Notification notification) {
        return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    }
}
