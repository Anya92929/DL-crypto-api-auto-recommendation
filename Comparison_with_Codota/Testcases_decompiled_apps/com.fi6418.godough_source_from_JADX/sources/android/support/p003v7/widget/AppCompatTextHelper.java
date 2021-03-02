package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.text.AllCapsTransformationMethod;
import android.support.p003v7.internal.widget.ThemeUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatTextHelper */
class AppCompatTextHelper {

    /* renamed from: a */
    private static final int[] f2708a = {16842804};

    /* renamed from: b */
    private static final int[] f2709b = {C0235R.attr.textAllCaps};

    /* renamed from: c */
    private final TextView f2710c;

    AppCompatTextHelper(TextView textView) {
        this.f2710c = textView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5185a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f2709b);
        if (obtainStyledAttributes.hasValue(0)) {
            mo5187a(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5186a(AttributeSet attributeSet, int i) {
        Context context = this.f2710c.getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2708a, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0235R.styleable.TextAppearance);
            if (obtainStyledAttributes2.hasValue(C0235R.styleable.TextAppearance_textAllCaps)) {
                mo5187a(obtainStyledAttributes2.getBoolean(C0235R.styleable.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes2.recycle();
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f2709b, i, 0);
        if (obtainStyledAttributes3.hasValue(0)) {
            mo5187a(obtainStyledAttributes3.getBoolean(0, false));
        }
        obtainStyledAttributes3.recycle();
        ColorStateList textColors = this.f2710c.getTextColors();
        if (textColors != null && !textColors.isStateful()) {
            this.f2710c.setTextColor(ThemeUtils.createDisabledStateList(textColors.getDefaultColor(), Build.VERSION.SDK_INT < 21 ? ThemeUtils.getDisabledThemeAttrColor(context, 16842808) : ThemeUtils.getThemeAttrColor(context, 16842808)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5187a(boolean z) {
        this.f2710c.setTransformationMethod(z ? new AllCapsTransformationMethod(this.f2710c.getContext()) : null);
    }
}
