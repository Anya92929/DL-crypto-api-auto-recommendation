package android.support.p021v7.p022a;

import android.app.Activity;
import android.content.Context;
import android.support.p021v7.p024c.p025a.C0517b;

/* renamed from: android.support.v7.a.i */
class C0487i extends C0517b implements C0488j {

    /* renamed from: a */
    private final Activity f764a;

    public C0487i(Activity activity, Context context) {
        super(context);
        this.f764a = activity;
    }

    /* renamed from: a */
    public void mo2115a(float f) {
        if (f == 1.0f) {
            mo2176b(true);
        } else if (f == 0.0f) {
            mo2176b(false);
        }
        mo2178d(f);
    }
}
