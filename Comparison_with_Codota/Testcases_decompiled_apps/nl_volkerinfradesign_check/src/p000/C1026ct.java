package p000;

import android.view.KeyEvent;
import android.view.View;

/* renamed from: ct */
public class C1026ct {
    /* renamed from: a */
    public static Object m4598a(View view) {
        return view.getKeyDispatcherState();
    }

    /* renamed from: a */
    public static boolean m4600a(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
        return keyEvent.dispatch(callback, (KeyEvent.DispatcherState) obj, obj2);
    }

    /* renamed from: a */
    public static void m4599a(KeyEvent keyEvent) {
        keyEvent.startTracking();
    }

    /* renamed from: b */
    public static boolean m4601b(KeyEvent keyEvent) {
        return keyEvent.isTracking();
    }
}
