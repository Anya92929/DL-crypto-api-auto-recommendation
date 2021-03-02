package android.support.p009v4.p010a;

import android.content.SharedPreferences;

/* renamed from: android.support.v4.a.i */
class C0043i {
    /* renamed from: a */
    public static void m159a(SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (AbstractMethodError e) {
            editor.commit();
        }
    }
}
