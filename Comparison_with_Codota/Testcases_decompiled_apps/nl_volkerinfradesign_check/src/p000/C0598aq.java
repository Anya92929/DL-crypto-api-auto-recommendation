package p000;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/* renamed from: aq */
public class C0598aq {
    /* renamed from: a */
    public static void m3398a(@NonNull SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (AbstractMethodError e) {
            editor.commit();
        }
    }
}
