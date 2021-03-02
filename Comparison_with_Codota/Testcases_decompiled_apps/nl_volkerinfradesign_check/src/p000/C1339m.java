package p000;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* renamed from: m */
public class C1339m {
    /* renamed from: a */
    public static void m5762a(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    /* renamed from: a */
    public static void m5761a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    /* renamed from: a */
    public static void m5760a(Activity activity) {
        activity.finishAffinity();
    }
}
