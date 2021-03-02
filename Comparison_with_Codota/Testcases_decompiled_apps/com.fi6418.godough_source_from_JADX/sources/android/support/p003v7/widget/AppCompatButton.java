package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.TintableBackgroundView;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.TintManager;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* renamed from: android.support.v7.widget.AppCompatButton */
public class AppCompatButton extends Button implements TintableBackgroundView {

    /* renamed from: a */
    private final TintManager f2658a;

    /* renamed from: b */
    private final AppCompatBackgroundHelper f2659b;

    /* renamed from: c */
    private final AppCompatTextHelper f2660c;

    public AppCompatButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2658a = TintManager.get(getContext());
        this.f2659b = new AppCompatBackgroundHelper(this, this.f2658a);
        this.f2659b.mo5106a(attributeSet, i);
        this.f2660c = new AppCompatTextHelper(this);
        this.f2660c.mo5186a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2659b != null) {
            this.f2659b.mo5109c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2659b != null) {
            return this.f2659b.mo5101a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2659b != null) {
            return this.f2659b.mo5107b();
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

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2659b != null) {
            this.f2659b.mo5105a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2659b != null) {
            this.f2659b.mo5102a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f2660c != null) {
            this.f2660c.mo5187a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2659b != null) {
            this.f2659b.mo5103a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f2659b != null) {
            this.f2659b.mo5104a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2660c != null) {
            this.f2660c.mo5185a(context, i);
        }
    }
}
