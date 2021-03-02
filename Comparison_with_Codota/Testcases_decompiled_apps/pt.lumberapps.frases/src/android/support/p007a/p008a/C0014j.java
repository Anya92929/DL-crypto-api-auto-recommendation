package android.support.p007a.p008a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.a.a.j */
class C0014j {
    /* renamed from: a */
    public static float m67a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !m70a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    /* renamed from: a */
    public static int m68a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m70a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: a */
    public static boolean m69a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m70a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    /* renamed from: a */
    public static boolean m70a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: b */
    public static int m71b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m70a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
