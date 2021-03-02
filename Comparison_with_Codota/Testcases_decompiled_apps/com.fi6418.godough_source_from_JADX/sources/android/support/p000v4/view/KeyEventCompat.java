package android.support.p000v4.view;

import android.os.Build;
import android.view.KeyEvent;
import android.view.View;

/* renamed from: android.support.v4.view.KeyEventCompat */
public class KeyEventCompat {

    /* renamed from: a */
    static final KeyEventVersionImpl f1184a;

    /* renamed from: android.support.v4.view.KeyEventCompat$BaseKeyEventVersionImpl */
    class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        BaseKeyEventVersionImpl() {
        }

        /* renamed from: a */
        private static int m858a(int i, int i2, int i3, int i4, int i5) {
            boolean z = true;
            boolean z2 = (i2 & i3) != 0;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                z = false;
            }
            if (!z2) {
                return z ? i & (i3 ^ -1) : i;
            }
            if (!z) {
                return i & (i6 ^ -1);
            }
            throw new IllegalArgumentException("bad arguments");
        }

        public boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
            return keyEvent.dispatch(callback);
        }

        public Object getKeyDispatcherState(View view) {
            return null;
        }

        public boolean isTracking(KeyEvent keyEvent) {
            return false;
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            return m858a(m858a(normalizeMetaState(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2;
        }

        public boolean metaStateHasNoModifiers(int i) {
            return (normalizeMetaState(i) & 247) == 0;
        }

        public int normalizeMetaState(int i) {
            int i2 = (i & 192) != 0 ? i | 1 : i;
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public void startTracking(KeyEvent keyEvent) {
        }
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$EclairKeyEventVersionImpl */
    class EclairKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        EclairKeyEventVersionImpl() {
        }

        public boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
            return KeyEventCompatEclair.dispatch(keyEvent, callback, obj, obj2);
        }

        public Object getKeyDispatcherState(View view) {
            return KeyEventCompatEclair.getKeyDispatcherState(view);
        }

        public boolean isTracking(KeyEvent keyEvent) {
            return KeyEventCompatEclair.isTracking(keyEvent);
        }

        public void startTracking(KeyEvent keyEvent) {
            KeyEventCompatEclair.startTracking(keyEvent);
        }
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$HoneycombKeyEventVersionImpl */
    class HoneycombKeyEventVersionImpl extends EclairKeyEventVersionImpl {
        HoneycombKeyEventVersionImpl() {
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            return KeyEventCompatHoneycomb.metaStateHasModifiers(i, i2);
        }

        public boolean metaStateHasNoModifiers(int i) {
            return KeyEventCompatHoneycomb.metaStateHasNoModifiers(i);
        }

        public int normalizeMetaState(int i) {
            return KeyEventCompatHoneycomb.normalizeMetaState(i);
        }
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$KeyEventVersionImpl */
    interface KeyEventVersionImpl {
        boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2);

        Object getKeyDispatcherState(View view);

        boolean isTracking(KeyEvent keyEvent);

        boolean metaStateHasModifiers(int i, int i2);

        boolean metaStateHasNoModifiers(int i);

        int normalizeMetaState(int i);

        void startTracking(KeyEvent keyEvent);
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f1184a = new HoneycombKeyEventVersionImpl();
        } else {
            f1184a = new BaseKeyEventVersionImpl();
        }
    }

    public static boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
        return f1184a.dispatch(keyEvent, callback, obj, obj2);
    }

    public static Object getKeyDispatcherState(View view) {
        return f1184a.getKeyDispatcherState(view);
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i) {
        return f1184a.metaStateHasModifiers(keyEvent.getMetaState(), i);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return f1184a.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public static boolean isTracking(KeyEvent keyEvent) {
        return f1184a.isTracking(keyEvent);
    }

    public static boolean metaStateHasModifiers(int i, int i2) {
        return f1184a.metaStateHasModifiers(i, i2);
    }

    public static boolean metaStateHasNoModifiers(int i) {
        return f1184a.metaStateHasNoModifiers(i);
    }

    public static int normalizeMetaState(int i) {
        return f1184a.normalizeMetaState(i);
    }

    public static void startTracking(KeyEvent keyEvent) {
        f1184a.startTracking(keyEvent);
    }
}
