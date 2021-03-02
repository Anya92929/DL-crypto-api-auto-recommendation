package android.support.p003v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatTextView */
public class AppCompatTextView extends TextView {

    /* renamed from: a */
    private AppCompatTextHelper f2711a;

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2711a = new AppCompatTextHelper(this);
        this.f2711a.mo5186a(attributeSet, i);
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2711a != null) {
            this.f2711a.mo5185a(context, i);
        }
    }
}
