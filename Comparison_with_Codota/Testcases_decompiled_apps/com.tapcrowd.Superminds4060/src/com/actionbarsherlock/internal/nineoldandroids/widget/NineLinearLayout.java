package com.actionbarsherlock.internal.nineoldandroids.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;

public class NineLinearLayout extends LinearLayout {
    private final AnimatorProxy mProxy;

    public NineLinearLayout(Context context) {
        super(context);
        this.mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }

    public NineLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }

    public NineLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }

    public void setVisibility(int visibility) {
        if (this.mProxy != null) {
            if (visibility == 8) {
                clearAnimation();
            } else if (visibility == 0) {
                setAnimation(this.mProxy);
            }
        }
        super.setVisibility(visibility);
    }

    public float getAlpha() {
        if (AnimatorProxy.NEEDS_PROXY) {
            return this.mProxy.getAlpha();
        }
        return super.getAlpha();
    }

    public void setAlpha(float alpha) {
        if (AnimatorProxy.NEEDS_PROXY) {
            this.mProxy.setAlpha(alpha);
        } else {
            super.setAlpha(alpha);
        }
    }

    public float getTranslationX() {
        if (AnimatorProxy.NEEDS_PROXY) {
            return this.mProxy.getTranslationX();
        }
        return super.getTranslationX();
    }

    public void setTranslationX(float translationX) {
        if (AnimatorProxy.NEEDS_PROXY) {
            this.mProxy.setTranslationX(translationX);
        } else {
            super.setTranslationX(translationX);
        }
    }
}
