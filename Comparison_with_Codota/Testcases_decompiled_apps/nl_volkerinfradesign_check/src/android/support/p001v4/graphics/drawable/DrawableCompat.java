package android.support.p001v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompat */
public class DrawableCompat {

    /* renamed from: a */
    static final C0135b f490a;

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$b */
    interface C0135b {
        /* renamed from: a */
        void mo867a(Drawable drawable);

        /* renamed from: a */
        void mo868a(Drawable drawable, float f, float f2);

        /* renamed from: a */
        void mo869a(Drawable drawable, int i);

        /* renamed from: a */
        void mo870a(Drawable drawable, int i, int i2, int i3, int i4);

        /* renamed from: a */
        void mo871a(Drawable drawable, ColorStateList colorStateList);

        /* renamed from: a */
        void mo872a(Drawable drawable, PorterDuff.Mode mode);

        /* renamed from: a */
        void mo873a(Drawable drawable, boolean z);

        /* renamed from: b */
        void mo874b(Drawable drawable, int i);

        /* renamed from: b */
        boolean mo875b(Drawable drawable);

        /* renamed from: c */
        Drawable mo876c(Drawable drawable);

        /* renamed from: d */
        int mo877d(Drawable drawable);
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$a */
    static class C0134a implements C0135b {
        C0134a() {
        }

        /* renamed from: a */
        public void mo867a(Drawable drawable) {
        }

        /* renamed from: a */
        public void mo873a(Drawable drawable, boolean z) {
        }

        /* renamed from: b */
        public boolean mo875b(Drawable drawable) {
            return false;
        }

        /* renamed from: a */
        public void mo868a(Drawable drawable, float f, float f2) {
        }

        /* renamed from: a */
        public void mo870a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        /* renamed from: a */
        public void mo869a(Drawable drawable, int i) {
            C0611bc.m3417a(drawable, i);
        }

        /* renamed from: a */
        public void mo871a(Drawable drawable, ColorStateList colorStateList) {
            C0611bc.m3418a(drawable, colorStateList);
        }

        /* renamed from: a */
        public void mo872a(Drawable drawable, PorterDuff.Mode mode) {
            C0611bc.m3419a(drawable, mode);
        }

        /* renamed from: c */
        public Drawable mo876c(Drawable drawable) {
            return C0611bc.m3416a(drawable);
        }

        /* renamed from: b */
        public void mo874b(Drawable drawable, int i) {
        }

        /* renamed from: d */
        public int mo877d(Drawable drawable) {
            return 0;
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$c */
    static class C0136c extends C0134a {
        C0136c() {
        }

        /* renamed from: a */
        public void mo867a(Drawable drawable) {
            C0612bd.m3420a(drawable);
        }

        /* renamed from: c */
        public Drawable mo876c(Drawable drawable) {
            return C0612bd.m3421b(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$d */
    static class C0137d extends C0136c {
        C0137d() {
        }

        /* renamed from: b */
        public void mo874b(Drawable drawable, int i) {
            C0613be.m3423a(drawable, i);
        }

        /* renamed from: d */
        public int mo877d(Drawable drawable) {
            int a = C0613be.m3422a(drawable);
            if (a >= 0) {
                return a;
            }
            return 0;
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$e */
    static class C0138e extends C0137d {
        C0138e() {
        }

        /* renamed from: a */
        public void mo873a(Drawable drawable, boolean z) {
            C0614bf.m3424a(drawable, z);
        }

        /* renamed from: b */
        public boolean mo875b(Drawable drawable) {
            return C0614bf.m3425a(drawable);
        }

        /* renamed from: c */
        public Drawable mo876c(Drawable drawable) {
            return C0614bf.m3426b(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$f */
    static class C0139f extends C0138e {
        C0139f() {
        }

        /* renamed from: a */
        public void mo868a(Drawable drawable, float f, float f2) {
            C0615bg.m3428a(drawable, f, f2);
        }

        /* renamed from: a */
        public void mo870a(Drawable drawable, int i, int i2, int i3, int i4) {
            C0615bg.m3430a(drawable, i, i2, i3, i4);
        }

        /* renamed from: a */
        public void mo869a(Drawable drawable, int i) {
            C0615bg.m3429a(drawable, i);
        }

        /* renamed from: a */
        public void mo871a(Drawable drawable, ColorStateList colorStateList) {
            C0615bg.m3431a(drawable, colorStateList);
        }

        /* renamed from: a */
        public void mo872a(Drawable drawable, PorterDuff.Mode mode) {
            C0615bg.m3432a(drawable, mode);
        }

        /* renamed from: c */
        public Drawable mo876c(Drawable drawable) {
            return C0615bg.m3427a(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$g */
    static class C0140g extends C0139f {
        C0140g() {
        }

        /* renamed from: c */
        public Drawable mo876c(Drawable drawable) {
            return C0609ba.m3413a(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$h */
    static class C0141h extends C0140g {
        C0141h() {
        }

        /* renamed from: b */
        public void mo874b(Drawable drawable, int i) {
            C0610bb.m3415a(drawable, i);
        }

        /* renamed from: d */
        public int mo877d(Drawable drawable) {
            return C0610bb.m3414a(drawable);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f490a = new C0141h();
        } else if (i >= 22) {
            f490a = new C0140g();
        } else if (i >= 21) {
            f490a = new C0139f();
        } else if (i >= 19) {
            f490a = new C0138e();
        } else if (i >= 17) {
            f490a = new C0137d();
        } else if (i >= 11) {
            f490a = new C0136c();
        } else {
            f490a = new C0134a();
        }
    }

    public static void jumpToCurrentState(Drawable drawable) {
        f490a.mo867a(drawable);
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        f490a.mo873a(drawable, z);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return f490a.mo875b(drawable);
    }

    public static void setHotspot(Drawable drawable, float f, float f2) {
        f490a.mo868a(drawable, f, f2);
    }

    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        f490a.mo870a(drawable, i, i2, i3, i4);
    }

    public static void setTint(Drawable drawable, int i) {
        f490a.mo869a(drawable, i);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        f490a.mo871a(drawable, colorStateList);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        f490a.mo872a(drawable, mode);
    }

    public static Drawable wrap(Drawable drawable) {
        return f490a.mo876c(drawable);
    }

    public static <T extends Drawable> T unwrap(Drawable drawable) {
        if (drawable instanceof DrawableWrapper) {
            return ((DrawableWrapper) drawable).getWrappedDrawable();
        }
        return drawable;
    }

    public static void setLayoutDirection(Drawable drawable, int i) {
        f490a.mo874b(drawable, i);
    }

    public static int getLayoutDirection(Drawable drawable) {
        return f490a.mo877d(drawable);
    }
}
