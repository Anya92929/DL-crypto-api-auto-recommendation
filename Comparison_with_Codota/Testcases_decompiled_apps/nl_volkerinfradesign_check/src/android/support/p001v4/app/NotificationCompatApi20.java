package android.support.p001v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.app.NotificationCompatBase;
import android.support.p001v4.app.RemoteInputCompatBase;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.NotificationCompatApi20 */
class NotificationCompatApi20 {

    /* renamed from: android.support.v4.app.NotificationCompatApi20$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, C2018z {

        /* renamed from: a */
        private Notification.Builder f341a;

        /* renamed from: b */
        private Bundle f342b;

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
            this.f341a = deleteIntent.setFullScreenIntent(pendingIntent2, z9).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f342b = new Bundle();
            if (bundle != null) {
                this.f342b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f342b.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }

        public void addAction(NotificationCompatBase.Action action) {
            NotificationCompatApi20.m333a(this.f341a, action);
        }

        public Notification.Builder getBuilder() {
            return this.f341a;
        }

        public Notification build() {
            this.f341a.setExtras(this.f342b);
            return this.f341a.build();
        }
    }

    /* renamed from: a */
    public static void m333a(Notification.Builder builder, NotificationCompatBase.Action action) {
        Notification.Action.Builder builder2 = new Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (RemoteInput addRemoteInput : C0004ad.m8a(action.getRemoteInputs())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (action.getExtras() != null) {
            builder2.addExtras(action.getExtras());
        }
        builder.addAction(builder2.build());
    }

    /* renamed from: a */
    public static NotificationCompatBase.Action m331a(Notification notification, int i, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return m330a(notification.actions[i], factory, factory2);
    }

    /* renamed from: a */
    private static NotificationCompatBase.Action m330a(Notification.Action action, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return factory.build(action.icon, action.title, action.actionIntent, action.getExtras(), C0004ad.m9a(action.getRemoteInputs(), factory2));
    }

    /* renamed from: a */
    private static Notification.Action m329a(NotificationCompatBase.Action action) {
        Notification.Action.Builder addExtras = new Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent()).addExtras(action.getExtras());
        RemoteInputCompatBase.RemoteInput[] remoteInputs = action.getRemoteInputs();
        if (remoteInputs != null) {
            for (RemoteInput addRemoteInput : C0004ad.m8a(remoteInputs)) {
                addExtras.addRemoteInput(addRemoteInput);
            }
        }
        return addExtras.build();
    }

    /* renamed from: a */
    public static NotificationCompatBase.Action[] m335a(ArrayList<Parcelable> arrayList, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        if (arrayList == null) {
            return null;
        }
        NotificationCompatBase.Action[] newArray = factory.newArray(arrayList.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= newArray.length) {
                return newArray;
            }
            newArray[i2] = m330a((Notification.Action) arrayList.get(i2), factory, factory2);
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public static ArrayList<Parcelable> m332a(NotificationCompatBase.Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList<>(actionArr.length);
        for (NotificationCompatBase.Action a : actionArr) {
            arrayList.add(m329a(a));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m334a(Notification notification) {
        return (notification.flags & 256) != 0;
    }

    /* renamed from: b */
    public static String m336b(Notification notification) {
        return notification.getGroup();
    }

    /* renamed from: c */
    public static boolean m337c(Notification notification) {
        return (notification.flags & 512) != 0;
    }

    /* renamed from: d */
    public static String m338d(Notification notification) {
        return notification.getSortKey();
    }
}
