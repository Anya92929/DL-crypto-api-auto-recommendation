package android.support.p004v7.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatCheckedTextView */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: a */
    private static final int[] f2000a = {16843016};

    /* renamed from: b */
    private TintManager f2001b;

    /* renamed from: c */
    private C1177gu f2002c;

    public AppCompatCheckedTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2002c = C1177gu.m5217a((TextView) this);
        this.f2002c.mo8205a(attributeSet, i);
        this.f2002c.mo8202a();
        if (TintManager.SHOULD_BE_USED) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, f2000a, i, 0);
            setCheckMarkDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            this.f2001b = obtainStyledAttributes.getTintManager();
        }
    }

    public void setCheckMarkDrawable(@DrawableRes int i) {
        if (this.f2001b != null) {
            setCheckMarkDrawable(this.f2001b.getDrawable(i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2002c != null) {
            this.f2002c.mo8203a(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2002c != null) {
            this.f2002c.mo8202a();
        }
    }
}
