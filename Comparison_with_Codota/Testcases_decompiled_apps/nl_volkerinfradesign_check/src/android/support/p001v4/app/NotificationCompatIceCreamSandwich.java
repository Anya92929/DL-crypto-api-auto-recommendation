package android.support.p001v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* renamed from: android.support.v4.app.NotificationCompatIceCreamSandwich */
class NotificationCompatIceCreamSandwich {

    /* renamed from: android.support.v4.app.NotificationCompatIceCreamSandwich$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor {

        /* renamed from: a */
        private Notification.Builder f344a;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            Notification.Builder lights = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Notification.Builder ongoing = lights.setOngoing(z2);
            if ((notification.flags & 8) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z3);
            if ((notification.flags & 16) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z4).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f344a = deleteIntent.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
        }

        public Notification.Builder getBuilder() {
            return this.f344a;
        }

        public Notification build() {
            return this.f344a.getNotification();
        }
    }
}
