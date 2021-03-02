package android.support.p003v7.widget;

import android.content.Context;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/* renamed from: android.support.v7.widget.AppCompatCheckedTextView */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: a */
    private static final int[] f2663a = {16843016};

    /* renamed from: b */
    private TintManager f2664b;

    public AppCompatCheckedTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (TintManager.SHOULD_BE_USED) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, f2663a, i, 0);
            setCheckMarkDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            this.f2664b = obtainStyledAttributes.getTintManager();
        }
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f2664b != null) {
            setCheckMarkDrawable(this.f2664b.getDrawable(i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }
}
