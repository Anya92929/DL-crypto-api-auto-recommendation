package android.support.p009v4.p010a;

import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: android.support.v4.a.v */
public final class C0056v {

    /* renamed from: a */
    private static C0056v f155a;

    /* renamed from: b */
    private final C0059y f156b;

    private C0056v() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.f156b = new C0057w();
        } else {
            this.f156b = new C0058x();
        }
    }

    /* renamed from: a */
    public static C0056v m183a() {
        if (f155a == null) {
            f155a = new C0056v();
        }
        return f155a;
    }

    /* renamed from: a */
    public void mo149a(SharedPreferences.Editor editor) {
        this.f156b.mo150a(editor);
    }
}
