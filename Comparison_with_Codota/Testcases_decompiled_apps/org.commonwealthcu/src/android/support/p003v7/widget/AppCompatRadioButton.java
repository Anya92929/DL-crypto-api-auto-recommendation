package android.support.p003v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p003v7.appcompat.C0137R;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* renamed from: android.support.v7.widget.AppCompatRadioButton */
public class AppCompatRadioButton extends RadioButton {
    private static final int[] TINT_ATTRS = {16843015};
    private Drawable mButtonDrawable;
    private TintManager mTintManager;

    public AppCompatRadioButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0137R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (TintManager.SHOULD_BE_USED) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, TINT_ATTRS, i, 0);
            setButtonDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            this.mTintManager = obtainStyledAttributes.getTintManager();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return (Build.VERSION.SDK_INT >= 17 || this.mButtonDrawable == null) ? compoundPaddingLeft : compoundPaddingLeft + this.mButtonDrawable.getIntrinsicWidth();
    }

    public void setButtonDrawable(int i) {
        if (this.mTintManager != null) {
            setButtonDrawable(this.mTintManager.getDrawable(i));
        } else {
            super.setButtonDrawable(i);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        this.mButtonDrawable = drawable;
    }
}
