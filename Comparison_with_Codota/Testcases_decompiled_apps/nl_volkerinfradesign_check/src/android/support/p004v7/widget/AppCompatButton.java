package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p001v4.view.TintableBackgroundView;
import android.support.p004v7.appcompat.C0505R;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatButton */
public class AppCompatButton extends Button implements TintableBackgroundView {

    /* renamed from: a */
    private final TintManager f1995a;

    /* renamed from: b */
    private final C1172gp f1996b;

    /* renamed from: c */
    private final C1177gu f1997c;

    public AppCompatButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1995a = TintManager.get(getContext());
        this.f1996b = new C1172gp(this, this.f1995a);
        this.f1996b.mo8186a(attributeSet, i);
        this.f1997c = C1177gu.m5217a((TextView) this);
        this.f1997c.mo8205a(attributeSet, i);
        this.f1997c.mo8202a();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.f1996b != null) {
            this.f1996b.mo8182a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1996b != null) {
            this.f1996b.mo8185a(drawable);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f1996b != null) {
            this.f1996b.mo8183a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1996b != null) {
            return this.f1996b.mo8181a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f1996b != null) {
            this.f1996b.mo8184a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1996b != null) {
            return this.f1996b.mo8187b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1996b != null) {
            this.f1996b.mo8189c();
        }
        if (this.f1997c != null) {
            this.f1997c.mo8202a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1997c != null) {
            this.f1997c.mo8203a(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f1997c != null) {
            this.f1997c.mo8206a(z);
        }
    }
}
