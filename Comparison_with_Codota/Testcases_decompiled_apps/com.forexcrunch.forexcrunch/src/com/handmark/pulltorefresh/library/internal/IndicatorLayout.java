package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.handmark.pulltorefresh.library.C0836R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

@SuppressLint({"ViewConstructor"})
public class IndicatorLayout extends FrameLayout implements Animation.AnimationListener {

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    private static /* synthetic */ int[] f1755x57a4d715 = null;
    static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
    private ImageView mArrowImageView;
    private Animation mInAnim;
    private Animation mOutAnim;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    static /* synthetic */ int[] m2142x57a4d715() {
        int[] iArr = f1755x57a4d715;
        if (iArr == null) {
            iArr = new int[PullToRefreshBase.Mode.values().length];
            try {
                iArr[PullToRefreshBase.Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PullToRefreshBase.Mode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            f1755x57a4d715 = iArr;
        }
        return iArr;
    }

    public IndicatorLayout(Context context, PullToRefreshBase.Mode mode) {
        super(context);
        int inAnimResId;
        int outAnimResId;
        this.mArrowImageView = new ImageView(context);
        Drawable arrowD = getResources().getDrawable(C0836R.drawable.indicator_arrow);
        this.mArrowImageView.setImageDrawable(arrowD);
        int padding = getResources().getDimensionPixelSize(C0836R.dimen.indicator_internal_padding);
        this.mArrowImageView.setPadding(padding, padding, padding, padding);
        addView(this.mArrowImageView);
        switch (m2142x57a4d715()[mode.ordinal()]) {
            case 3:
                inAnimResId = C0836R.anim.slide_in_from_bottom;
                outAnimResId = C0836R.anim.slide_out_to_bottom;
                setBackgroundResource(C0836R.drawable.indicator_bg_bottom);
                this.mArrowImageView.setScaleType(ImageView.ScaleType.MATRIX);
                Matrix matrix = new Matrix();
                matrix.setRotate(180.0f, ((float) arrowD.getIntrinsicWidth()) / 2.0f, ((float) arrowD.getIntrinsicHeight()) / 2.0f);
                this.mArrowImageView.setImageMatrix(matrix);
                break;
            default:
                inAnimResId = C0836R.anim.slide_in_from_top;
                outAnimResId = C0836R.anim.slide_out_to_top;
                setBackgroundResource(C0836R.drawable.indicator_bg_top);
                break;
        }
        this.mInAnim = AnimationUtils.loadAnimation(context, inAnimResId);
        this.mInAnim.setAnimationListener(this);
        this.mOutAnim = AnimationUtils.loadAnimation(context, outAnimResId);
        this.mOutAnim.setAnimationListener(this);
        Interpolator interpolator = new LinearInterpolator();
        this.mRotateAnimation = new RotateAnimation(BitmapDescriptorFactory.HUE_RED, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setInterpolator(interpolator);
        this.mRotateAnimation.setDuration(150);
        this.mRotateAnimation.setFillAfter(true);
        this.mResetRotateAnimation = new RotateAnimation(-180.0f, BitmapDescriptorFactory.HUE_RED, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation.setInterpolator(interpolator);
        this.mResetRotateAnimation.setDuration(150);
        this.mResetRotateAnimation.setFillAfter(true);
    }

    public final boolean isVisible() {
        Animation currentAnim = getAnimation();
        if (currentAnim != null) {
            if (this.mInAnim == currentAnim) {
                return true;
            }
            return false;
        } else if (getVisibility() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void hide() {
        startAnimation(this.mOutAnim);
    }

    public void show() {
        this.mArrowImageView.clearAnimation();
        startAnimation(this.mInAnim);
    }

    public void onAnimationEnd(Animation animation) {
        if (animation == this.mOutAnim) {
            this.mArrowImageView.clearAnimation();
            setVisibility(8);
        } else if (animation == this.mInAnim) {
            setVisibility(0);
        }
        clearAnimation();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        setVisibility(0);
    }

    public void releaseToRefresh() {
        this.mArrowImageView.startAnimation(this.mRotateAnimation);
    }

    public void pullToRefresh() {
        this.mArrowImageView.startAnimation(this.mResetRotateAnimation);
    }
}
