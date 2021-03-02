package android.support.p009v4.p012b.p013a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.b.a.k */
class C0107k {
    /* renamed from: a */
    public static Drawable m268a(Drawable drawable) {
        return !(drawable instanceof C0114r) ? new C0114r(drawable) : drawable;
    }

    /* renamed from: a */
    public static void m269a(Drawable drawable, int i) {
        if (drawable instanceof C0113q) {
            ((C0113q) drawable).mo980a(i);
        }
    }

    /* renamed from: a */
    public static void m270a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0113q) {
            ((C0113q) drawable).mo981a(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m271a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    /* renamed from: a */
    public static void m272a(Drawable drawable, PorterDuff.Mode mode) {
        if (drawable instanceof C0113q) {
            ((C0113q) drawable).mo982a(mode);
        }
    }
}
