package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p003v7.preference.C0268R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* renamed from: android.support.v7.internal.widget.PreferenceImageView */
public class PreferenceImageView extends ImageView {

    /* renamed from: a */
    private int f2331a;

    /* renamed from: b */
    private int f2332b;

    public PreferenceImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2331a = Integer.MAX_VALUE;
        this.f2332b = Integer.MAX_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0268R.styleable.PreferenceImageView, i, 0);
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(C0268R.styleable.PreferenceImageView_maxWidth, Integer.MAX_VALUE));
        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(C0268R.styleable.PreferenceImageView_maxHeight, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }

    public int getMaxHeight() {
        return this.f2332b;
    }

    public int getMaxWidth() {
        return this.f2331a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i2);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i2 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        this.f2332b = i;
        super.setMaxHeight(i);
    }

    public void setMaxWidth(int i) {
        this.f2331a = i;
        super.setMaxWidth(i);
    }
}
