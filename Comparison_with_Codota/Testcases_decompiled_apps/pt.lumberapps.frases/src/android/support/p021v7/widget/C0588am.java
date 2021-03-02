package android.support.p021v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.am */
public class C0588am extends CheckedTextView {

    /* renamed from: a */
    private static final int[] f1384a = {16843016};

    /* renamed from: b */
    private C0591ap f1385b;

    /* renamed from: c */
    private C0617bo f1386c;

    public C0588am(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0588am(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        this.f1386c = C0617bo.m2797a((TextView) this);
        this.f1386c.mo3075a(attributeSet, i);
        this.f1386c.mo3072a();
        this.f1385b = C0591ap.m2736a();
        C0670dn a = C0670dn.m3014a(getContext(), attributeSet, f1384a, i, 0);
        setCheckMarkDrawable(a.mo3318a(0));
        a.mo3319a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1386c != null) {
            this.f1386c.mo3072a();
        }
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f1385b != null) {
            setCheckMarkDrawable(this.f1385b.mo2982a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1386c != null) {
            this.f1386c.mo3073a(context, i);
        }
    }
}
