package android.support.p007a.p008a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.a.a.o */
class C0019o extends C0021q {

    /* renamed from: a */
    int f87a = 0;

    /* renamed from: b */
    float f88b = 0.0f;

    /* renamed from: c */
    int f89c = 0;

    /* renamed from: d */
    float f90d = 1.0f;

    /* renamed from: e */
    int f91e;

    /* renamed from: f */
    float f92f = 1.0f;

    /* renamed from: g */
    float f93g = 0.0f;

    /* renamed from: h */
    float f94h = 1.0f;

    /* renamed from: i */
    float f95i = 0.0f;

    /* renamed from: j */
    Paint.Cap f96j = Paint.Cap.BUTT;

    /* renamed from: k */
    Paint.Join f97k = Paint.Join.MITER;

    /* renamed from: l */
    float f98l = 4.0f;

    /* renamed from: p */
    private int[] f99p;

    public C0019o() {
    }

    public C0019o(C0019o oVar) {
        super(oVar);
        this.f99p = oVar.f99p;
        this.f87a = oVar.f87a;
        this.f88b = oVar.f88b;
        this.f90d = oVar.f90d;
        this.f89c = oVar.f89c;
        this.f91e = oVar.f91e;
        this.f92f = oVar.f92f;
        this.f93g = oVar.f93g;
        this.f94h = oVar.f94h;
        this.f95i = oVar.f95i;
        this.f96j = oVar.f96j;
        this.f97k = oVar.f97k;
        this.f98l = oVar.f98l;
    }

    /* renamed from: a */
    private Paint.Cap m87a(int i, Paint.Cap cap) {
        switch (i) {
            case 0:
                return Paint.Cap.BUTT;
            case 1:
                return Paint.Cap.ROUND;
            case 2:
                return Paint.Cap.SQUARE;
            default:
                return cap;
        }
    }

    /* renamed from: a */
    private Paint.Join m88a(int i, Paint.Join join) {
        switch (i) {
            case 0:
                return Paint.Join.MITER;
            case 1:
                return Paint.Join.ROUND;
            case 2:
                return Paint.Join.BEVEL;
            default:
                return join;
        }
    }

    /* renamed from: a */
    private void m89a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.f99p = null;
        if (C0014j.m70a(xmlPullParser, "pathData")) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f114n = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.f113m = C0010f.m59a(string2);
            }
            this.f89c = C0014j.m71b(typedArray, xmlPullParser, "fillColor", 1, this.f89c);
            this.f92f = C0014j.m67a(typedArray, xmlPullParser, "fillAlpha", 12, this.f92f);
            this.f96j = m87a(C0014j.m68a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f96j);
            this.f97k = m88a(C0014j.m68a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f97k);
            this.f98l = C0014j.m67a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f98l);
            this.f87a = C0014j.m71b(typedArray, xmlPullParser, "strokeColor", 3, this.f87a);
            this.f90d = C0014j.m67a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f90d);
            this.f88b = C0014j.m67a(typedArray, xmlPullParser, "strokeWidth", 4, this.f88b);
            this.f94h = C0014j.m67a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f94h);
            this.f95i = C0014j.m67a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f95i);
            this.f93g = C0014j.m67a(typedArray, xmlPullParser, "trimPathStart", 5, this.f93g);
        }
    }

    /* renamed from: a */
    public void mo101a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray b = C0015k.m72b(resources, theme, attributeSet, C0005a.f58c);
        m89a(b, xmlPullParser);
        b.recycle();
    }
}
