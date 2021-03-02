package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompatLollipop */
class DrawableCompatLollipop {
    DrawableCompatLollipop() {
    }

    public static void setHotspot(Drawable drawable, float x, float y) {
        drawable.setHotspot(x, y);
    }

    public static void setHotspotBounds(Drawable drawable, int left, int top, int right, int bottom) {
        drawable.setHotspotBounds(left, top, right, bottom);
    }

    public static void setTint(Drawable drawable, int tint) {
        drawable.setTint(tint);
    }

    public static void setTintList(Drawable drawable, ColorStateList tint) {
        drawable.setTintList(tint);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode tintMode) {
        drawable.setTintMode(tintMode);
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        if (!(drawable instanceof DrawableWrapperLollipop)) {
            return new DrawableWrapperLollipop(drawable);
        }
        return drawable;
    }

    public static void applyTheme(Drawable drawable, Resources.Theme t) {
        drawable.applyTheme(t);
    }

    public static boolean canApplyTheme(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void inflate(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme t) throws IOException, XmlPullParserException {
        drawable.inflate(res, parser, attrs, t);
    }
}
