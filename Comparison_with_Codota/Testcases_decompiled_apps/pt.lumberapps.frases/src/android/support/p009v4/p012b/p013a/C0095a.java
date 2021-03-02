package android.support.p009v4.p012b.p013a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.b.a.a */
public final class C0095a {

    /* renamed from: a */
    static final C0099c f167a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f167a = new C0105i();
        } else if (i >= 21) {
            f167a = new C0104h();
        } else if (i >= 19) {
            f167a = new C0103g();
        } else if (i >= 17) {
            f167a = new C0102f();
        } else if (i >= 11) {
            f167a = new C0101e();
        } else if (i >= 5) {
            f167a = new C0100d();
        } else {
            f167a = new C0098b();
        }
    }

    /* renamed from: a */
    public static void m194a(Drawable drawable) {
        f167a.mo963a(drawable);
    }

    /* renamed from: a */
    public static void m195a(Drawable drawable, float f, float f2) {
        f167a.mo964a(drawable, f, f2);
    }

    /* renamed from: a */
    public static void m196a(Drawable drawable, int i) {
        f167a.mo965a(drawable, i);
    }

    /* renamed from: a */
    public static void m197a(Drawable drawable, int i, int i2, int i3, int i4) {
        f167a.mo966a(drawable, i, i2, i3, i4);
    }

    /* renamed from: a */
    public static void m198a(Drawable drawable, ColorStateList colorStateList) {
        f167a.mo967a(drawable, colorStateList);
    }

    /* renamed from: a */
    public static void m199a(Drawable drawable, Resources.Theme theme) {
        f167a.mo968a(drawable, theme);
    }

    /* renamed from: a */
    public static void m200a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        f167a.mo969a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    /* renamed from: a */
    public static void m201a(Drawable drawable, PorterDuff.Mode mode) {
        f167a.mo970a(drawable, mode);
    }

    /* renamed from: a */
    public static void m202a(Drawable drawable, boolean z) {
        f167a.mo971a(drawable, z);
    }

    /* renamed from: b */
    public static void m203b(Drawable drawable, int i) {
        f167a.mo972b(drawable, i);
    }

    /* renamed from: b */
    public static boolean m204b(Drawable drawable) {
        return f167a.mo973b(drawable);
    }

    /* renamed from: c */
    public static int m205c(Drawable drawable) {
        return f167a.mo976e(drawable);
    }

    /* renamed from: d */
    public static boolean m206d(Drawable drawable) {
        return f167a.mo977f(drawable);
    }

    /* renamed from: e */
    public static ColorFilter m207e(Drawable drawable) {
        return f167a.mo978g(drawable);
    }

    /* renamed from: f */
    public static Drawable m208f(Drawable drawable) {
        return f167a.mo974c(drawable);
    }

    /* renamed from: g */
    public static int m209g(Drawable drawable) {
        return f167a.mo975d(drawable);
    }
}
