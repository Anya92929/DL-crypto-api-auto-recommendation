package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.handmark.pulltorefresh.library.C0836R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

public class RotateLoadingLayout extends LoadingLayout {
    static final int ROTATION_ANIMATION_DURATION = 1200;
    private final Matrix mHeaderImageMatrix = new Matrix();
    private final Animation mRotateAnimation;
    private final boolean mRotateDrawableWhilePulling;
    private float mRotationPivotX;
    private float mRotationPivotY;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
        this.mRotateDrawableWhilePulling = attrs.getBoolean(15, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
        this.mRotateAnimation = new RotateAnimation(BitmapDescriptorFactory.HUE_RED, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mRotateAnimation.setDuration(1200);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
    }

    public void onLoadingDrawableSet(Drawable imageDrawable) {
        if (imageDrawable != null) {
            this.mRotationPivotX = (float) Math.round(((float) imageDrawable.getIntrinsicWidth()) / 2.0f);
            this.mRotationPivotY = (float) Math.round(((float) imageDrawable.getIntrinsicHeight()) / 2.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void onPullImpl(float scaleOfLayout) {
        float angle;
        if (this.mRotateDrawableWhilePulling) {
            angle = scaleOfLayout * 90.0f;
        } else {
            angle = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(180.0f, (360.0f * scaleOfLayout) - 180.0f));
        }
        this.mHeaderImageMatrix.setRotate(angle, this.mRotationPivotX, this.mRotationPivotY);
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
    }

    /* access modifiers changed from: protected */
    public void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    /* access modifiers changed from: protected */
    public void resetImpl() {
        this.mHeaderImage.clearAnimation();
        resetImageRotation();
    }

    private void resetImageRotation() {
        if (this.mHeaderImageMatrix != null) {
            this.mHeaderImageMatrix.reset();
            this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
        }
    }

    /* access modifiers changed from: protected */
    public void pullToRefreshImpl() {
    }

    /* access modifiers changed from: protected */
    public void releaseToRefreshImpl() {
    }

    /* access modifiers changed from: protected */
    public int getDefaultDrawableResId() {
        return C0836R.drawable.default_ptr_rotate;
    }
}
