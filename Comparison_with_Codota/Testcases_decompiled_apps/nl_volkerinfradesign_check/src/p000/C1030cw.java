package p000;

import android.content.Context;
import android.support.p001v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;
import p000.C1028cv;

/* renamed from: cw */
public class C1030cw {

    /* renamed from: a */
    private static Field f4052a;

    /* renamed from: b */
    private static boolean f4053b;

    /* renamed from: cw$a */
    static class C1031a extends C1028cv.C1029a implements LayoutInflater.Factory2 {
        C1031a(LayoutInflaterFactory layoutInflaterFactory) {
            super(layoutInflaterFactory);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f4051a.onCreateView(view, str, context, attributeSet);
        }
    }

    /* renamed from: a */
    public static void m4606a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        C1031a aVar;
        if (layoutInflaterFactory != null) {
            aVar = new C1031a(layoutInflaterFactory);
        } else {
            aVar = null;
        }
        layoutInflater.setFactory2(aVar);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            m4607a(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            m4607a(layoutInflater, (LayoutInflater.Factory2) aVar);
        }
    }

    /* renamed from: a */
    static void m4607a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f4053b) {
            try {
                f4052a = LayoutInflater.class.getDeclaredField("mFactory2");
                f4052a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f4053b = true;
        }
        if (f4052a != null) {
            try {
                f4052a.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
