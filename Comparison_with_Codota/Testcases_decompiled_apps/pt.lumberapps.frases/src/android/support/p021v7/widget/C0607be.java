package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.widget.RatingBar;

/* renamed from: android.support.v7.widget.be */
public class C0607be extends RatingBar {

    /* renamed from: a */
    private C0605bc f1437a;

    /* renamed from: b */
    private C0591ap f1438b;

    public C0607be(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.ratingBarStyle);
    }

    public C0607be(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1438b = C0591ap.m2736a();
        this.f1437a = new C0605bc(this, this.f1438b);
        this.f1437a.mo3017a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f1437a.mo3016a();
        if (a != null) {
            setMeasuredDimension(C0247by.m887a(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
