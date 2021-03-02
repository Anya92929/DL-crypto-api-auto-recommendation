package p000;

import android.view.KeyEvent;

/* renamed from: cu */
public class C1027cu {
    /* renamed from: a */
    public static int m4602a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    /* renamed from: a */
    public static boolean m4603a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    /* renamed from: b */
    public static boolean m4604b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
