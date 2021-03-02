package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p000v4.app.NotificationCompatBase;
import android.support.p000v4.app.RemoteInputCompatBase;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompatKitKat */
class NotificationCompatKitKat {

    /* renamed from: android.support.v4.app.NotificationCompatKitKat$Builder */
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {

        /* renamed from: a */
        private Notification.Builder f657a;

        /* renamed from: b */
        private Bundle f658b;

        /* renamed from: c */
        private List<Bundle> f659c = new ArrayList();

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            this.f657a = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f658b = new Bundle();
            if (bundle != null) {
                this.f658b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f658b.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f658b.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str != null) {
                this.f658b.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                if (z5) {
                    this.f658b.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    this.f658b.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str2 != null) {
                this.f658b.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
            }
        }

        public void addAction(NotificationCompatBase.Action action) {
            this.f659c.add(NotificationCompatJellybean.writeActionAndGetExtras(this.f657a, action));
        }

        public Notification build() {
            SparseArray<Bundle> buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.f659c);
            if (buildActionExtrasMap != null) {
                this.f658b.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap);
            }
            this.f657a.setExtras(this.f658b);
            return this.f657a.build();
        }

        public Notification.Builder getBuilder() {
            return this.f657a;
        }
    }

    NotificationCompatKitKat() {
    }

    public static NotificationCompatBase.Action getAction(Notification notification, int i, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        Notification.Action action = notification.actions[i];
        Bundle bundle = null;
        SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        if (sparseParcelableArray != null) {
            bundle = (Bundle) sparseParcelableArray.get(i);
        }
        return NotificationCompatJellybean.readAction(factory, factory2, action.icon, action.title, action.actionIntent, bundle);
    }

    public static int getActionCount(Notification notification) {
        if (notification.actions != null) {
            return notification.actions.length;
        }
        return 0;
    }

    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static String getGroup(Notification notification) {
        return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    }

    public static boolean getLocalOnly(Notification notification) {
        return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    }

    public static String getSortKey(Notification notification) {
        return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    }

    public static boolean isGroupSummary(Notification notification) {
        return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    }
}
