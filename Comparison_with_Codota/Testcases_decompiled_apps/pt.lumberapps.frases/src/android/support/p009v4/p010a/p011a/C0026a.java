package android.support.p009v4.p010a.p011a;

import android.content.res.Resources;
import android.os.Build;

/* renamed from: android.support.v4.a.a.a */
public final class C0026a {

    /* renamed from: a */
    private static final C0028c f145a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            f145a = new C0031f();
        } else if (i >= 13) {
            f145a = new C0030e();
        } else {
            f145a = new C0029d();
        }
    }

    /* renamed from: a */
    public static int m123a(Resources resources) {
        return f145a.mo128a(resources);
    }

    /* renamed from: b */
    public static int m124b(Resources resources) {
        return f145a.mo129b(resources);
    }

    /* renamed from: c */
    public static int m125c(Resources resources) {
        return f145a.mo130c(resources);
    }
}
