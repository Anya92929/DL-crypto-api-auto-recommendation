package android.support.p009v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* renamed from: android.support.v4.app.NotificationCompatIceCreamSandwich */
class NotificationCompatIceCreamSandwich {

    /* renamed from: android.support.v4.app.NotificationCompatIceCreamSandwich$Builder */
    public class Builder implements NotificationBuilderWithBuilderAccessor {

        /* renamed from: b */
        private Notification.Builder f161b;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
            this.f161b = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0).setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
        }

        public Notification build() {
            return this.f161b.getNotification();
        }

        public Notification.Builder getBuilder() {
            return this.f161b;
        }
    }

    NotificationCompatIceCreamSandwich() {
    }
}
