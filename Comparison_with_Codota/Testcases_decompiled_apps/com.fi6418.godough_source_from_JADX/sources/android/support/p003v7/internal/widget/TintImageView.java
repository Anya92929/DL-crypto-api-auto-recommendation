package android.support.p003v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.internal.widget.TintImageView */
public class TintImageView extends ImageView {

    /* renamed from: a */
    private static final int[] f2379a = {16842964, 16843033};

    /* renamed from: b */
    private final TintManager f2380b;

    public TintImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, f2379a, i, 0);
        if (obtainStyledAttributes.length() > 0) {
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            if (obtainStyledAttributes.hasValue(1)) {
                setImageDrawable(obtainStyledAttributes.getDrawable(1));
            }
        }
        obtainStyledAttributes.recycle();
        this.f2380b = obtainStyledAttributes.getTintManager();
    }

    public void setImageResource(int i) {
        setImageDrawable(this.f2380b.getDrawable(i));
    }
}
