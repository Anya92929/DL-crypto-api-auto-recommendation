package p000;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* renamed from: an */
public class C0014an {
    /* renamed from: a */
    public static void m29a(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }

    /* renamed from: a */
    public static File m28a(Context context) {
        return context.getObbDir();
    }
}
