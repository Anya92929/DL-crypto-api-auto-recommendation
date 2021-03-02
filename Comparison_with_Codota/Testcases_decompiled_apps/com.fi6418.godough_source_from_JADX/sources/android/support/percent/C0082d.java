package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* renamed from: android.support.percent.d */
public class C0082d extends RelativeLayout.LayoutParams implements C0081c {

    /* renamed from: a */
    private C0080b f237a;

    public C0082d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f237a = C0079a.m367a(context, attributeSet);
    }

    /* renamed from: a */
    public C0080b mo334a() {
        if (this.f237a == null) {
            this.f237a = new C0080b();
        }
        return this.f237a;
    }

    /* access modifiers changed from: protected */
    public void setBaseAttributes(TypedArray typedArray, int i, int i2) {
        C0079a.m368a(this, typedArray, i, i2);
    }
}
