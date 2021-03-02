package p000;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: di */
public class C1047di {

    /* renamed from: a */
    private static Method f4060a;

    /* renamed from: a */
    public static boolean m4654a(View view) {
        return view.isOpaque();
    }

    /* renamed from: a */
    public static void m4653a(ViewGroup viewGroup, boolean z) {
        if (f4060a == null) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f4060a = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            f4060a.setAccessible(true);
        }
        try {
            f4060a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (IllegalAccessException e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (IllegalArgumentException e3) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (InvocationTargetException e4) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e4);
        }
    }
}
