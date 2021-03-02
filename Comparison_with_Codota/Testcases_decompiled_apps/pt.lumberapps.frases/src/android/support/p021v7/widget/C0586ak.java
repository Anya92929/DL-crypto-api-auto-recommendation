package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0241bs;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.ak */
public class C0586ak extends Button implements C0241bs {

    /* renamed from: a */
    private final C0591ap f1379a;

    /* renamed from: b */
    private final C0585aj f1380b;

    /* renamed from: c */
    private final C0617bo f1381c;

    public C0586ak(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.buttonStyle);
    }

    public C0586ak(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        this.f1379a = C0591ap.m2736a();
        this.f1380b = new C0585aj(this, this.f1379a);
        this.f1380b.mo2954a(attributeSet, i);
        this.f1381c = C0617bo.m2797a((TextView) this);
        this.f1381c.mo3075a(attributeSet, i);
        this.f1381c.mo3072a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1380b != null) {
            this.f1380b.mo2957c();
        }
        if (this.f1381c != null) {
            this.f1381c.mo3072a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1380b != null) {
            return this.f1380b.mo2949a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1380b != null) {
            return this.f1380b.mo2955b();
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
        if (this.f1380b != null) {
            this.f1380b.mo2953a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1380b != null) {
            this.f1380b.mo2950a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f1381c != null) {
            this.f1381c.mo3076a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1380b != null) {
            this.f1380b.mo2951a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1380b != null) {
            this.f1380b.mo2952a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1381c != null) {
            this.f1381c.mo3073a(context, i);
        }
    }
}
