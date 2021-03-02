package com.tapcrowd.app.views.imageviewtouch;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.p000v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

public class ImageViewTouch extends ImageViewTouchBase {
    static final float SCROLL_DELTA_THRESHOLD = 1.0f;
    protected float mCurrentScaleFactor;
    protected int mDoubleTapDirection;
    protected boolean mDoubleTapEnabled = true;
    /* access modifiers changed from: private */
    public OnImageViewTouchDoubleTapListener mDoubleTapListener;
    protected GestureDetector mGestureDetector;
    protected GestureDetector.OnGestureListener mGestureListener;
    private OnImageViewTouchLayout mOnlayoutListener;
    protected ScaleGestureDetector mScaleDetector;
    protected boolean mScaleEnabled = true;
    protected float mScaleFactor;
    protected ScaleGestureDetector.OnScaleGestureListener mScaleListener;
    protected boolean mScrollEnabled = true;
    protected int mTouchSlop;

    public interface OnImageViewTouchDoubleTapListener {
        void onDoubleTap();
    }

    public interface OnImageViewTouchLayout {
        void onLayout();
    }

    public ImageViewTouch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mGestureListener = getGestureListener();
        this.mScaleListener = getScaleListener();
        this.mScaleDetector = new ScaleGestureDetector(getContext(), this.mScaleListener);
        this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener, (Handler) null, true);
        this.mCurrentScaleFactor = 1.0f;
        this.mDoubleTapDirection = 1;
    }

    public void setDoubleTapListener(OnImageViewTouchDoubleTapListener listener) {
        this.mDoubleTapListener = listener;
    }

    public void setOnLayoutListener(OnImageViewTouchLayout listener) {
        this.mOnlayoutListener = listener;
    }

    public void setDoubleTapEnabled(boolean value) {
        this.mDoubleTapEnabled = value;
    }

    public void setScaleEnabled(boolean value) {
        this.mScaleEnabled = value;
    }

    public void setScrollEnabled(boolean value) {
        this.mScrollEnabled = value;
    }

    public boolean getDoubleTapEnabled() {
        return this.mDoubleTapEnabled;
    }

    /* access modifiers changed from: protected */
    public GestureDetector.OnGestureListener getGestureListener() {
        return new GestureListener();
    }

    /* access modifiers changed from: protected */
    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new ScaleListener();
    }

    /* access modifiers changed from: protected */
    public void onBitmapChanged(Drawable drawable) {
        super.onBitmapChanged(drawable);
        float[] v = new float[9];
        this.mSuppMatrix.getValues(v);
        this.mCurrentScaleFactor = v[0];
    }

    /* access modifiers changed from: protected */
    public void _setImageDrawable(Drawable drawable, boolean reset, Matrix initial_matrix, float maxZoom) {
        super._setImageDrawable(drawable, reset, initial_matrix, maxZoom);
        this.mScaleFactor = getMaxZoom() / 3.0f;
    }

    public boolean onTouchEvent(MotionEvent event) {
        this.mScaleDetector.onTouchEvent(event);
        if (!this.mScaleDetector.isInProgress()) {
            this.mGestureDetector.onTouchEvent(event);
        }
        switch (event.getAction() & MotionEventCompat.ACTION_MASK) {
            case 1:
                if (getScale() >= getMinZoom()) {
                    return true;
                }
                zoomTo(getMinZoom(), 50.0f);
                return true;
            default:
                return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onZoom(float scale) {
        super.onZoom(scale);
        if (!this.mScaleDetector.isInProgress()) {
            this.mCurrentScaleFactor = scale;
        }
    }

    /* access modifiers changed from: protected */
    public void onZoomAnimationCompleted(float scale) {
        super.onZoomAnimationCompleted(scale);
        if (!this.mScaleDetector.isInProgress()) {
            this.mCurrentScaleFactor = scale;
        }
        if (scale < getMinZoom()) {
            zoomTo(getMinZoom(), 50.0f);
        }
    }

    /* access modifiers changed from: protected */
    public float onDoubleTapPost(float scale, float maxZoom) {
        if (this.mDoubleTapDirection != 1) {
            this.mDoubleTapDirection = 1;
            return 1.0f;
        } else if ((this.mScaleFactor * 2.0f) + scale <= maxZoom) {
            return scale + this.mScaleFactor;
        } else {
            this.mDoubleTapDirection = -1;
            return maxZoom;
        }
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (!this.mScrollEnabled || e1 == null || e2 == null || e1.getPointerCount() > 1 || e2.getPointerCount() > 1 || this.mScaleDetector.isInProgress()) {
            return false;
        }
        scrollBy(-distanceX, -distanceY);
        invalidate();
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (!this.mScrollEnabled || e1.getPointerCount() > 1 || e2.getPointerCount() > 1 || this.mScaleDetector.isInProgress()) {
            return false;
        }
        float diffX = e2.getX() - e1.getX();
        float diffY = e2.getY() - e1.getY();
        if (Math.abs(velocityX) <= 800.0f && Math.abs(velocityY) <= 800.0f) {
            return false;
        }
        scrollBy(diffX / 2.0f, diffY / 2.0f, 300.0d);
        invalidate();
        return true;
    }

    public boolean canScroll(int direction) {
        RectF bitmapRect = getBitmapRect();
        updateRect(bitmapRect, this.mScrollRect);
        Rect imageViewRect = new Rect();
        getGlobalVisibleRect(imageViewRect);
        if (bitmapRect.right < ((float) imageViewRect.right) || direction >= 0) {
            if (((double) Math.abs(bitmapRect.left - this.mScrollRect.left)) <= 1.0d) {
                return false;
            }
            return true;
        } else if (Math.abs(bitmapRect.right - ((float) imageViewRect.right)) > 1.0f) {
            return true;
        } else {
            return false;
        }
    }

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        public boolean onDoubleTap(MotionEvent e) {
            if (ImageViewTouch.this.mDoubleTapEnabled) {
                float scale = ImageViewTouch.this.getScale();
                float f = scale;
                float targetScale = Math.min(ImageViewTouch.this.getMaxZoom(), Math.max(ImageViewTouch.this.onDoubleTapPost(scale, ImageViewTouch.this.getMaxZoom()), ImageViewTouch.this.getMinZoom()));
                ImageViewTouch.this.mCurrentScaleFactor = targetScale;
                ImageViewTouch.this.zoomTo(targetScale, e.getX(), e.getY(), 200.0f);
                ImageViewTouch.this.invalidate();
            }
            if (ImageViewTouch.this.mDoubleTapListener != null) {
                ImageViewTouch.this.mDoubleTapListener.onDoubleTap();
            }
            return super.onDoubleTap(e);
        }

        public void onLongPress(MotionEvent e) {
            if (ImageViewTouch.this.isLongClickable() && !ImageViewTouch.this.mScaleDetector.isInProgress()) {
                ImageViewTouch.this.setPressed(true);
                ImageViewTouch.this.performLongClick();
            }
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return ImageViewTouch.this.onScroll(e1, e2, distanceX, distanceY);
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return ImageViewTouch.this.onFling(e1, e2, velocityX, velocityY);
        }
    }

    public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector detector) {
            float currentSpan = detector.getCurrentSpan() - detector.getPreviousSpan();
            float targetScale = ImageViewTouch.this.mCurrentScaleFactor * detector.getScaleFactor();
            if (!ImageViewTouch.this.mScaleEnabled) {
                return false;
            }
            float targetScale2 = Math.min(ImageViewTouch.this.getMaxZoom(), Math.max(targetScale, ImageViewTouch.this.getMinZoom() - 0.1f));
            ImageViewTouch.this.zoomTo(targetScale2, detector.getFocusX(), detector.getFocusY());
            ImageViewTouch.this.mCurrentScaleFactor = Math.min(ImageViewTouch.this.getMaxZoom(), Math.max(targetScale2, ImageViewTouch.this.getMinZoom() - 1.0f));
            ImageViewTouch.this.mDoubleTapDirection = 1;
            ImageViewTouch.this.invalidate();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mOnlayoutListener != null) {
            this.mOnlayoutListener.onLayout();
        }
    }
}
