package android.support.p007a.p008a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.a.a.n */
class C0018n extends C0021q {
    public C0018n() {
    }

    public C0018n(C0018n nVar) {
        super(nVar);
    }

    /* renamed from: a */
    private void m84a(TypedArray typedArray) {
        String string = typedArray.getString(0);
        if (string != null) {
            this.f114n = string;
        }
        String string2 = typedArray.getString(1);
        if (string2 != null) {
            this.f113m = C0010f.m59a(string2);
        }
    }

    /* renamed from: a */
    public void mo99a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        if (C0014j.m70a(xmlPullParser, "pathData")) {
            TypedArray b = C0015k.m72b(resources, theme, attributeSet, C0005a.f59d);
            m84a(b);
            b.recycle();
        }
    }

    /* renamed from: a */
    public boolean mo100a() {
        return true;
    }
}
