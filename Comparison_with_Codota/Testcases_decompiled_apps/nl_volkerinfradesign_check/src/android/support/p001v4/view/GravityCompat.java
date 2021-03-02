package android.support.p001v4.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

/* renamed from: android.support.v4.view.GravityCompat */
public class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    /* renamed from: a */
    static final C0269a f928a;

    /* renamed from: android.support.v4.view.GravityCompat$a */
    interface C0269a {
        /* renamed from: a */
        int mo1757a(int i, int i2);

        /* renamed from: a */
        void mo1758a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6);

        /* renamed from: a */
        void mo1759a(int i, int i2, int i3, Rect rect, Rect rect2, int i4);

        /* renamed from: a */
        void mo1760a(int i, Rect rect, Rect rect2, int i2);
    }

    /* renamed from: android.support.v4.view.GravityCompat$b */
    static class C0270b implements C0269a {
        C0270b() {
        }

        /* renamed from: a */
        public int mo1757a(int i, int i2) {
            return -8388609 & i;
        }

        /* renamed from: a */
        public void mo1759a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }

        /* renamed from: a */
        public void mo1758a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
            Gravity.apply(i, i2, i3, rect, i4, i5, rect2);
        }

        /* renamed from: a */
        public void mo1760a(int i, Rect rect, Rect rect2, int i2) {
            Gravity.applyDisplay(i, rect, rect2);
        }
    }

    /* renamed from: android.support.v4.view.GravityCompat$c */
    static class C0271c implements C0269a {
        C0271c() {
        }

        /* renamed from: a */
        public int mo1757a(int i, int i2) {
            return C1025cs.m4594a(i, i2);
        }

        /* renamed from: a */
        public void mo1759a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            C1025cs.m4596a(i, i2, i3, rect, rect2, i4);
        }

        /* renamed from: a */
        public void mo1758a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
            C1025cs.m4595a(i, i2, i3, rect, i4, i5, rect2, i6);
        }

        /* renamed from: a */
        public void mo1760a(int i, Rect rect, Rect rect2, int i2) {
            C1025cs.m4597a(i, rect, rect2, i2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f928a = new C0271c();
        } else {
            f928a = new C0270b();
        }
    }

    public static void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f928a.mo1759a(i, i2, i3, rect, rect2, i4);
    }

    public static void apply(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
        f928a.mo1758a(i, i2, i3, rect, i4, i5, rect2, i6);
    }

    public static void applyDisplay(int i, Rect rect, Rect rect2, int i2) {
        f928a.mo1760a(i, rect, rect2, i2);
    }

    public static int getAbsoluteGravity(int i, int i2) {
        return f928a.mo1757a(i, i2);
    }
}
