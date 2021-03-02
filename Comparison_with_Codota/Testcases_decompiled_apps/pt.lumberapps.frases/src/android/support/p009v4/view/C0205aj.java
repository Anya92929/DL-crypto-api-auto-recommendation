package android.support.p009v4.view;

import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.view.aj */
class C0205aj {

    /* renamed from: a */
    private static Field f340a;

    /* renamed from: b */
    private static boolean f341b;

    /* renamed from: a */
    static void m771a(LayoutInflater layoutInflater, C0208am amVar) {
        C0206ak akVar = amVar != null ? new C0206ak(amVar) : null;
        layoutInflater.setFactory2(akVar);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            m772a(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            m772a(layoutInflater, (LayoutInflater.Factory2) akVar);
        }
    }

    /* renamed from: a */
    static void m772a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f341b) {
            try {
                f340a = LayoutInflater.class.getDeclaredField("mFactory2");
                f340a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f341b = true;
        }
        if (f340a != null) {
            try {
                f340a.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
