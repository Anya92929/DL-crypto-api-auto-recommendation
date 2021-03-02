package android.support.p003v7.internal.app;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.p000v4.app.NotificationBuilderWithBuilderAccessor;

/* renamed from: android.support.v7.internal.app.NotificationCompatImpl21 */
public class NotificationCompatImpl21 {
    public static void addMediaStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, int[] iArr, Object obj) {
        Notification.MediaStyle mediaStyle = new Notification.MediaStyle(notificationBuilderWithBuilderAccessor.getBuilder());
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        if (obj != null) {
            mediaStyle.setMediaSession((MediaSession.Token) obj);
        }
    }
}
