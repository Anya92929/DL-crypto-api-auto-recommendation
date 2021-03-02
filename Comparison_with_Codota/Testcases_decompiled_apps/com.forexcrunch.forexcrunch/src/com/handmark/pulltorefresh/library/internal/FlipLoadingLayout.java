package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.handmark.pulltorefresh.library.C0836R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout extends LoadingLayout {

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    private static /* synthetic */ int[] f1754x57a4d715 = null;
    static final int FLIP_ANIMATION_DURATION = 150;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    static /* synthetic */ int[] m2141x57a4d715() {
        int[] iArr = f1754x57a4d715;
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
            f1754x57a4d715 = iArr;
        }
        return iArr;
    }

    public FlipLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
        int rotateAngle = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.mRotateAnimation = new RotateAnimation(BitmapDescriptorFactory.HUE_RED, (float) rotateAngle, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mRotateAnimation.setDuration(150);
        this.mRotateAnimation.setFillAfter(true);
        this.mResetRotateAnimation = new RotateAnimation((float) rotateAngle, BitmapDescriptorFactory.HUE_RED, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mResetRotateAnimation.setDuration(150);
        this.mResetRotateAnimation.setFillAfter(true);
    }

    /* access modifiers changed from: protected */
    public void onLoadingDrawableSet(Drawable imageDrawable) {
        if (imageDrawable != null) {
            int dHeight = imageDrawable.getIntrinsicHeight();
            int dWidth = imageDrawable.getIntrinsicWidth();
            ViewGroup.LayoutParams lp = this.mHeaderImage.getLayoutParams();
            int max = Math.max(dHeight, dWidth);
            lp.height = max;
            lp.width = max;
            this.mHeaderImage.requestLayout();
            this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(((float) (lp.width - dWidth)) / 2.0f, ((float) (lp.height - dHeight)) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), ((float) lp.width) / 2.0f, ((float) lp.height) / 2.0f);
            this.mHeaderImage.setImageMatrix(matrix);
        }
    }

    /* access modifiers changed from: protected */
    public void onPullImpl(float scaleOfLayout) {
    }

    /* access modifiers changed from: protected */
    public void pullToRefreshImpl() {
        if (this.mRotateAnimation == this.mHeaderImage.getAnimation()) {
            this.mHeaderImage.startAnimation(this.mResetRotateAnimation);
        }
    }

    /* access modifiers changed from: protected */
    public void refreshingImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderImage.setVisibility(4);
        this.mHeaderProgress.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void releaseToRefreshImpl() {
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    /* access modifiers changed from: protected */
    public void resetImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public int getDefaultDrawableResId() {
        return C0836R.drawable.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (m2141x57a4d715()[this.mMode.ordinal()]) {
            case 2:
                if (this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 270.0f;
                }
                return BitmapDescriptorFactory.HUE_RED;
            case 3:
                if (this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            default:
                return BitmapDescriptorFactory.HUE_RED;
        }
    }
}
