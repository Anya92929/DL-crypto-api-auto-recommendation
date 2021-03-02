package cmn;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;

@TargetApi(11)
/* renamed from: cmn.d */
public class C0742d extends C0705a {
    /* renamed from: a */
    public Notification mo3374a(Context context, String str, String str2, PendingIntent pendingIntent) {
        return new Notification.Builder(context).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).getNotification();
    }

    /* renamed from: a */
    public final void mo3376a(Activity activity) {
        activity.getWindow().setFlags(16777216, 16777216);
    }

    /* renamed from: a */
    public final void mo3377a(View view) {
        view.setLayerType(1, (Paint) null);
    }
}
