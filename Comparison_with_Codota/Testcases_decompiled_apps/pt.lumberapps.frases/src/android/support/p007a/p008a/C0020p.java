package android.support.p007a.p008a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.support.p009v4.p019f.C0136a;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.a.a.p */
class C0020p {

    /* renamed from: a */
    final ArrayList f100a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Matrix f101b = new Matrix();

    /* renamed from: c */
    private float f102c = 0.0f;

    /* renamed from: d */
    private float f103d = 0.0f;

    /* renamed from: e */
    private float f104e = 0.0f;

    /* renamed from: f */
    private float f105f = 1.0f;

    /* renamed from: g */
    private float f106g = 1.0f;

    /* renamed from: h */
    private float f107h = 0.0f;

    /* renamed from: i */
    private float f108i = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Matrix f109j = new Matrix();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f110k;

    /* renamed from: l */
    private int[] f111l;

    /* renamed from: m */
    private String f112m = null;

    public C0020p() {
    }

    public C0020p(C0020p pVar, C0136a aVar) {
        C0021q nVar;
        this.f102c = pVar.f102c;
        this.f103d = pVar.f103d;
        this.f104e = pVar.f104e;
        this.f105f = pVar.f105f;
        this.f106g = pVar.f106g;
        this.f107h = pVar.f107h;
        this.f108i = pVar.f108i;
        this.f111l = pVar.f111l;
        this.f112m = pVar.f112m;
        this.f110k = pVar.f110k;
        if (this.f112m != null) {
            aVar.put(this.f112m, this);
        }
        this.f109j.set(pVar.f109j);
        ArrayList arrayList = pVar.f100a;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                Object obj = arrayList.get(i2);
                if (obj instanceof C0020p) {
                    this.f100a.add(new C0020p((C0020p) obj, aVar));
                } else {
                    if (obj instanceof C0019o) {
                        nVar = new C0019o((C0019o) obj);
                    } else if (obj instanceof C0018n) {
                        nVar = new C0018n((C0018n) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f100a.add(nVar);
                    if (nVar.f114n != null) {
                        aVar.put(nVar.f114n, nVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m92a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.f111l = null;
        this.f102c = C0014j.m67a(typedArray, xmlPullParser, "rotation", 5, this.f102c);
        this.f103d = typedArray.getFloat(1, this.f103d);
        this.f104e = typedArray.getFloat(2, this.f104e);
        this.f105f = C0014j.m67a(typedArray, xmlPullParser, "scaleX", 3, this.f105f);
        this.f106g = C0014j.m67a(typedArray, xmlPullParser, "scaleY", 4, this.f106g);
        this.f107h = C0014j.m67a(typedArray, xmlPullParser, "translateX", 6, this.f107h);
        this.f108i = C0014j.m67a(typedArray, xmlPullParser, "translateY", 7, this.f108i);
        String string = typedArray.getString(0);
        if (string != null) {
            this.f112m = string;
        }
        m94b();
    }

    /* renamed from: b */
    private void m94b() {
        this.f109j.reset();
        this.f109j.postTranslate(-this.f103d, -this.f104e);
        this.f109j.postScale(this.f105f, this.f106g);
        this.f109j.postRotate(this.f102c, 0.0f, 0.0f);
        this.f109j.postTranslate(this.f107h + this.f103d, this.f108i + this.f104e);
    }

    /* renamed from: a */
    public String mo102a() {
        return this.f112m;
    }

    /* renamed from: a */
    public void mo103a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray b = C0015k.m72b(resources, theme, attributeSet, C0005a.f57b);
        m92a(b, xmlPullParser);
        b.recycle();
    }
}
