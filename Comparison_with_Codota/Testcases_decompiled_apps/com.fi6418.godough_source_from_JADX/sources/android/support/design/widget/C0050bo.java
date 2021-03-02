package android.support.design.widget;

import android.os.Build;

/* renamed from: android.support.design.widget.bo */
class C0050bo {

    /* renamed from: a */
    static final C0032ax f193a = new C0051bp();

    /* renamed from: b */
    private static final C0052bq f194b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f194b = new C0054bs((C0051bp) null);
        } else {
            f194b = new C0053br((C0051bp) null);
        }
    }

    /* renamed from: a */
    static C0026ar m298a() {
        return f193a.mo238a();
    }
}
