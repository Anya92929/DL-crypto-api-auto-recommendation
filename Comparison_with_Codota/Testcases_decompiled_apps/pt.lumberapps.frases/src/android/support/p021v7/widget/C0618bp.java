package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.bp */
class C0618bp extends C0617bo {

    /* renamed from: b */
    private static final int[] f1478b = {16843666, 16843667};

    /* renamed from: c */
    private C0668dl f1479c;

    /* renamed from: d */
    private C0668dl f1480d;

    C0618bp(TextView textView) {
        super(textView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3072a() {
        super.mo3072a();
        if (this.f1479c != null || this.f1480d != null) {
            Drawable[] compoundDrawablesRelative = this.f1473a.getCompoundDrawablesRelative();
            mo3074a(compoundDrawablesRelative[0], this.f1479c);
            mo3074a(compoundDrawablesRelative[2], this.f1480d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3075a(AttributeSet attributeSet, int i) {
        super.mo3075a(attributeSet, i);
        Context context = this.f1473a.getContext();
        C0591ap a = C0591ap.m2736a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1478b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f1479c = m2798a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f1480d = m2798a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
