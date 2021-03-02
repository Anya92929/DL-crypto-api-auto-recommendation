package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.view.TintableBackgroundView;
import android.support.p003v7.appcompat.C0137R;
import android.support.p003v7.internal.text.AllCapsTransformationMethod;
import android.support.p003v7.internal.widget.ThemeUtils;
import android.support.p003v7.internal.widget.TintInfo;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* renamed from: android.support.v7.widget.AppCompatButton */
public class AppCompatButton extends Button implements TintableBackgroundView {
    private static final int[] TINT_ATTRS = {16842964};
    private TintInfo mBackgroundTint;
    private TintInfo mInternalBackgroundTint;
    private TintManager mTintManager;

    public AppCompatButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0137R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ColorStateList tintList;
        if (TintManager.SHOULD_BE_USED) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, TINT_ATTRS, i, 0);
            if (obtainStyledAttributes.hasValue(0) && (tintList = obtainStyledAttributes.getTintManager().getTintList(obtainStyledAttributes.getResourceId(0, -1))) != null) {
                setInternalBackgroundTint(tintList);
            }
            this.mTintManager = obtainStyledAttributes.getTintManager();
            obtainStyledAttributes.recycle();
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C0137R.styleable.AppCompatTextView, i, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(C0137R.styleable.AppCompatTextView_android_textAppearance, -1);
        obtainStyledAttributes2.recycle();
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(resourceId, C0137R.styleable.TextAppearance);
            if (obtainStyledAttributes3.hasValue(C0137R.styleable.TextAppearance_textAllCaps)) {
                setAllCaps(obtainStyledAttributes3.getBoolean(C0137R.styleable.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes3.recycle();
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, C0137R.styleable.AppCompatTextView, i, 0);
        if (obtainStyledAttributes4.hasValue(C0137R.styleable.AppCompatTextView_textAllCaps)) {
            setAllCaps(obtainStyledAttributes4.getBoolean(C0137R.styleable.AppCompatTextView_textAllCaps, false));
        }
        obtainStyledAttributes4.recycle();
        ColorStateList textColors = getTextColors();
        if (textColors != null && !textColors.isStateful()) {
            setTextColor(ThemeUtils.createDisabledStateList(textColors.getDefaultColor(), Build.VERSION.SDK_INT < 21 ? ThemeUtils.getDisabledThemeAttrColor(context, 16842808) : ThemeUtils.getThemeAttrColor(context, 16842808)));
        }
    }

    private void applySupportBackgroundTint() {
        if (getBackground() == null) {
            return;
        }
        if (this.mBackgroundTint != null) {
            TintManager.tintViewBackground(this, this.mBackgroundTint);
        } else if (this.mInternalBackgroundTint != null) {
            TintManager.tintViewBackground(this, this.mInternalBackgroundTint);
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new TintInfo();
            }
            this.mInternalBackgroundTint.mTintList = colorStateList;
            this.mInternalBackgroundTint.mHasTintList = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        applySupportBackgroundTint();
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.mBackgroundTint != null) {
            return this.mBackgroundTint.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.mBackgroundTint != null) {
            return this.mBackgroundTint.mTintMode;
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new AllCapsTransformationMethod(getContext()) : null);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint((ColorStateList) null);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setInternalBackgroundTint(this.mTintManager != null ? this.mTintManager.getTintList(i) : null);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        this.mBackgroundTint.mTintList = colorStateList;
        this.mBackgroundTint.mHasTintList = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        this.mBackgroundTint.mTintMode = mode;
        this.mBackgroundTint.mHasTintMode = true;
        applySupportBackgroundTint();
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
