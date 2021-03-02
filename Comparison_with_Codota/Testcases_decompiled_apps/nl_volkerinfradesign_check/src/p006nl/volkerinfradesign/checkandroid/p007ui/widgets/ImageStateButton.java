package p006nl.volkerinfradesign.checkandroid.p007ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;
import p006nl.volkerinfradesign.checkandroid.C1352R;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.ImageStateButton */
public class ImageStateButton extends ImageButton {

    /* renamed from: a */
    private boolean f5631a = false;

    public ImageStateButton(Context context) {
        super(context);
        m6449a(context, (AttributeSet) null, 0);
    }

    public ImageStateButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6449a(context, attributeSet, 0);
    }

    public ImageStateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6449a(context, attributeSet, i);
    }

    public boolean isRequired() {
        return this.f5631a;
    }

    public void setRequired(boolean z) {
        this.f5631a = z;
        refreshDrawableState();
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (!this.f5631a) {
            return onCreateDrawableState;
        }
        return mergeDrawableStates(onCreateDrawableState, new int[]{C1352R.attr.required});
    }

    /* renamed from: a */
    private void m6449a(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        int i2 = C1352R.styleable.ImageStateButton_required;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1352R.styleable.ImageStateButton, 0, i);
        if (obtainStyledAttributes.hasValue(i2) && obtainStyledAttributes.getBoolean(i2, false)) {
            z = true;
        }
        this.f5631a = z;
    }
}
