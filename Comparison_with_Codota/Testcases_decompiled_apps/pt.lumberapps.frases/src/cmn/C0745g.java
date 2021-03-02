package cmn;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

@TargetApi(16)
/* renamed from: cmn.g */
public class C0745g extends C0744f {
    /* renamed from: a */
    public final Notification mo3374a(Context context, String str, String str2, PendingIntent pendingIntent) {
        return new Notification.Builder(context).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).build();
    }

    /* renamed from: a */
    public final void mo3378a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }
}
