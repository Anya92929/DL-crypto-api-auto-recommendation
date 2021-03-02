package android.support.p009v4.view;

import android.view.KeyEvent;

/* renamed from: android.support.v4.view.ab */
class C0197ab {
    /* renamed from: a */
    public static int m757a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    /* renamed from: a */
    public static boolean m758a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    /* renamed from: a */
    public static boolean m759a(KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    /* renamed from: b */
    public static boolean m760b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
