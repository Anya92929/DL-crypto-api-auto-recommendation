package android.support.p009v4.p010a;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* renamed from: android.support.v4.a.f */
class C0040f {
    /* renamed from: a */
    public static File m153a(Context context) {
        return context.getObbDir();
    }

    /* renamed from: a */
    static void m154a(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }
}
