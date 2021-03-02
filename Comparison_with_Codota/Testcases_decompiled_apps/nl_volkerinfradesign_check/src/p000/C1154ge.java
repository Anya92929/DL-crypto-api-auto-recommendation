package p000;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.p001v4.app.NotificationBuilderWithBuilderAccessor;

/* renamed from: ge */
public class C1154ge {
    /* renamed from: a */
    public static void m5165a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, int[] iArr, Object obj) {
        Notification.MediaStyle mediaStyle = new Notification.MediaStyle(notificationBuilderWithBuilderAccessor.getBuilder());
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        if (obj != null) {
            mediaStyle.setMediaSession((MediaSession.Token) obj);
        }
    }
}
