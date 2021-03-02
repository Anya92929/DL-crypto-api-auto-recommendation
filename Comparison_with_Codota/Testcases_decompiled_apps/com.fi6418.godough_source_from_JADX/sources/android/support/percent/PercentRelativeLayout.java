package android.support.percent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class PercentRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private final C0079a f226a = new C0079a(this);

    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public C0082d generateLayoutParams(AttributeSet attributeSet) {
        return new C0082d(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f226a.mo326a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f226a.mo327a(i, i2);
        super.onMeasure(i, i2);
        if (this.f226a.mo328b()) {
            super.onMeasure(i, i2);
        }
    }
}
