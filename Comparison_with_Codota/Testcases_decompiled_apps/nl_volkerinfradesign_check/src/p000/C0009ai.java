package p000;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* renamed from: ai */
public class C0009ai {
    /* renamed from: a */
    public static PendingIntent m18a(Context context, int i, Intent[] intentArr, int i2) {
        return PendingIntent.getActivities(context, i, intentArr, i2);
    }
}
