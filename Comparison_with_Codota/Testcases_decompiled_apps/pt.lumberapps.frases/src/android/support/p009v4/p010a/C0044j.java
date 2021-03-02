package android.support.p009v4.p010a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

/* renamed from: android.support.v4.a.j */
public final class C0044j {

    /* renamed from: a */
    private static final C0045k f146a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 15) {
            f146a = new C0048n();
        } else if (i >= 11) {
            f146a = new C0047m();
        } else {
            f146a = new C0046l();
        }
    }

    /* renamed from: a */
    public static Intent m160a(ComponentName componentName) {
        return f146a.mo131a(componentName);
    }
}
