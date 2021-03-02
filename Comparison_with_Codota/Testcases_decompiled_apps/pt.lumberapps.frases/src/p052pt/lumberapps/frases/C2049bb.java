package p052pt.lumberapps.frases;

import android.util.Log;

/* renamed from: pt.lumberapps.frases.bb */
public class C2049bb {

    /* renamed from: a */
    public static boolean f7736a = false;

    /* renamed from: a */
    public static boolean m8325a(String str) {
        return str != null && !str.isEmpty();
    }

    /* renamed from: b */
    public static void m8326b(String str) {
        if (m8325a(str)) {
            Log.e("DEBUG", str);
        } else {
            Log.e("DEBUG", "Msg vazia catchada!");
        }
    }
}
