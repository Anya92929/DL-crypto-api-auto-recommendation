package android.support.p000v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* renamed from: android.support.v4.content.ContextCompatHoneycomb */
class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
    }

    /* renamed from: a */
    static void m620a(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }

    public static File getObbDir(Context context) {
        return context.getObbDir();
    }
}
