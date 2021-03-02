package android.support.p009v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p009v4.app.NotificationCompatBase;
import android.support.p009v4.app.RemoteInputCompatBase;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.NotificationCompatApi20 */
class NotificationCompatApi20 {

    /* renamed from: android.support.v4.app.NotificationCompatApi20$Builder */
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {

        /* renamed from: b */
        private Notification.Builder f159b;
        private Bundle mExtras;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList arrayList, Bundle bundle, String str, boolean z5, String str2) {
            this.f159b = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.mExtras = new Bundle();
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.mExtras.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }

        public void addAction(NotificationCompatBase.Action action) {
            NotificationCompatApi20.addAction(this.f159b, action);
        }

        public Notification build() {
            this.f159b.setExtras(this.mExtras);
            return this.f159b.build();
        }

        public Notification.Builder getBuilder() {
            return this.f159b;
        }
    }

    NotificationCompatApi20() {
    }

    public static void addAction(Notification.Builder builder, NotificationCompatBase.Action action) {
        Notification.Action.Builder builder2 = new Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (RemoteInput addRemoteInput : RemoteInputCompatApi20.fromCompat(action.getRemoteInputs())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (action.getExtras() != null) {
            builder2.addExtras(action.getExtras());
        }
        builder.addAction(builder2.build());
    }

    public static NotificationCompatBase.Action getAction(Notification notification, int i, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return getActionCompatFromAction(notification.actions[i], factory, factory2);
    }

    private static NotificationCompatBase.Action getActionCompatFromAction(Notification.Action action, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return factory.build(action.icon, action.title, action.actionIntent, action.getExtras(), RemoteInputCompatApi20.toCompat(action.getRemoteInputs(), factory2));
    }

    private static Notification.Action getActionFromActionCompat(NotificationCompatBase.Action action) {
        Notification.Action.Builder addExtras = new Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent()).addExtras(action.getExtras());
        RemoteInputCompatBase.RemoteInput[] remoteInputs = action.getRemoteInputs();
        if (remoteInputs != null) {
            for (RemoteInput addRemoteInput : RemoteInputCompatApi20.fromCompat(remoteInputs)) {
                addExtras.addRemoteInput(addRemoteInput);
            }
        }
        return addExtras.build();
    }

    public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList arrayList, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
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
            newArray[i2] = getActionCompatFromAction((Notification.Action) arrayList.get(i2), factory, factory2);
            i = i2 + 1;
        }
    }

    public static String getGroup(Notification notification) {
        return notification.getGroup();
    }

    public static boolean getLocalOnly(Notification notification) {
        return (notification.flags & NotificationCompat.FLAG_LOCAL_ONLY) != 0;
    }

    public static ArrayList getParcelableArrayListForActions(NotificationCompatBase.Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(actionArr.length);
        for (NotificationCompatBase.Action actionFromActionCompat : actionArr) {
            arrayList.add(getActionFromActionCompat(actionFromActionCompat));
        }
        return arrayList;
    }

    public static String getSortKey(Notification notification) {
        return notification.getSortKey();
    }

    public static boolean isGroupSummary(Notification notification) {
        return (notification.flags & 512) != 0;
    }
}
