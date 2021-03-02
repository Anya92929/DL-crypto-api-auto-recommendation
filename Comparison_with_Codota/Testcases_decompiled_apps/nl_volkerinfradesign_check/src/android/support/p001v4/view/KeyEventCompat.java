package android.support.p001v4.view;

import android.os.Build;
import android.view.KeyEvent;
import android.view.View;

/* renamed from: android.support.v4.view.KeyEventCompat */
public class KeyEventCompat {

    /* renamed from: a */
    static final C0275d f929a;

    /* renamed from: android.support.v4.view.KeyEventCompat$d */
    interface C0275d {
        /* renamed from: a */
        int mo1761a(int i);

        /* renamed from: a */
        Object mo1762a(View view);

        /* renamed from: a */
        void mo1763a(KeyEvent keyEvent);

        /* renamed from: a */
        boolean mo1764a(int i, int i2);

        /* renamed from: a */
        boolean mo1765a(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2);

        /* renamed from: b */
        boolean mo1766b(int i);

        /* renamed from: b */
        boolean mo1767b(KeyEvent keyEvent);
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$a */
    static class C0272a implements C0275d {
        C0272a() {
        }

        /* renamed from: a */
        private static int m1081a(int i, int i2, int i3, int i4, int i5) {
            boolean z = true;
            boolean z2 = (i2 & i3) != 0;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                z = false;
            }
            if (z2) {
                if (!z) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (z) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        /* renamed from: a */
        public int mo1761a(int i) {
            int i2;
            if ((i & 192) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        /* renamed from: a */
        public boolean mo1764a(int i, int i2) {
            if (m1081a(m1081a(mo1761a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        /* renamed from: b */
        public boolean mo1766b(int i) {
            return (mo1761a(i) & 247) == 0;
        }

        /* renamed from: a */
        public void mo1763a(KeyEvent keyEvent) {
        }

        /* renamed from: b */
        public boolean mo1767b(KeyEvent keyEvent) {
            return false;
        }

        /* renamed from: a */
        public Object mo1762a(View view) {
            return null;
        }

        /* renamed from: a */
        public boolean mo1765a(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
            return keyEvent.dispatch(callback);
        }
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$b */
    static class C0273b extends C0272a {
        C0273b() {
        }

        /* renamed from: a */
        public void mo1763a(KeyEvent keyEvent) {
            C1026ct.m4599a(keyEvent);
        }

        /* renamed from: b */
        public boolean mo1767b(KeyEvent keyEvent) {
            return C1026ct.m4601b(keyEvent);
        }

        /* renamed from: a */
        public Object mo1762a(View view) {
            return C1026ct.m4598a(view);
        }

        /* renamed from: a */
        public boolean mo1765a(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
            return C1026ct.m4600a(keyEvent, callback, obj, obj2);
        }
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$c */
    static class C0274c extends C0273b {
        C0274c() {
        }

        /* renamed from: a */
        public int mo1761a(int i) {
            return C1027cu.m4602a(i);
        }

        /* renamed from: a */
        public boolean mo1764a(int i, int i2) {
            return C1027cu.m4603a(i, i2);
        }

        /* renamed from: b */
        public boolean mo1766b(int i) {
            return C1027cu.m4604b(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f929a = new C0274c();
        } else {
            f929a = new C0272a();
        }
    }

    public static int normalizeMetaState(int i) {
        return f929a.mo1761a(i);
    }

    public static boolean metaStateHasModifiers(int i, int i2) {
        return f929a.mo1764a(i, i2);
    }

    public static boolean metaStateHasNoModifiers(int i) {
        return f929a.mo1766b(i);
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i) {
        return f929a.mo1764a(keyEvent.getMetaState(), i);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return f929a.mo1766b(keyEvent.getMetaState());
    }

    public static void startTracking(KeyEvent keyEvent) {
        f929a.mo1763a(keyEvent);
    }

    public static boolean isTracking(KeyEvent keyEvent) {
        return f929a.mo1767b(keyEvent);
    }

    public static Object getKeyDispatcherState(View view) {
        return f929a.mo1762a(view);
    }

    public static boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
        return f929a.mo1765a(keyEvent, callback, obj, obj2);
    }
}
