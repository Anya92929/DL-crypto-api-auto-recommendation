package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p003v7.appcompat.C0137R;
import android.support.p003v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatTextView */
public class AppCompatTextView extends TextView {
    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0137R.styleable.AppCompatTextView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(C0137R.styleable.AppCompatTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0137R.styleable.TextAppearance);
            if (obtainStyledAttributes2.hasValue(C0137R.styleable.TextAppearance_textAllCaps)) {
                setAllCaps(obtainStyledAttributes2.getBoolean(C0137R.styleable.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes2.recycle();
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, C0137R.styleable.AppCompatTextView, i, 0);
        if (obtainStyledAttributes3.hasValue(C0137R.styleable.AppCompatTextView_textAllCaps)) {
            setAllCaps(obtainStyledAttributes3.getBoolean(C0137R.styleable.AppCompatTextView_textAllCaps, false));
        }
        obtainStyledAttributes3.recycle();
    }

    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new AllCapsTransformationMethod(getContext()) : null);
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0137R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0137R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(C0137R.styleable.TextAppearance_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
    }
}
