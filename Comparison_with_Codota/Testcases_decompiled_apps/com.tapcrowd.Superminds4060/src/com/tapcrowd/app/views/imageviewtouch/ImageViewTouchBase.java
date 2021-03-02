package com.tapcrowd.app.views.imageviewtouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tapcrowd.app.views.imageviewtouch.utils.Cubic;
import com.tapcrowd.app.views.imageviewtouch.utils.Easing;
import com.tapcrowd.app.views.imageviewtouch.utils.FastBitmapDrawable;
import com.tapcrowd.app.views.imageviewtouch.utils.IDisposable;
import twitter4j.internal.http.HttpResponseCode;

public class ImageViewTouchBase extends ImageView implements IDisposable {
    protected static final float MIN_ZOOM = 0.9f;
    protected final int DEFAULT_ANIMATION_DURATION = HttpResponseCode.f2160OK;
    protected final float MAX_ZOOM = 2.0f;
    protected Matrix mBaseMatrix = new Matrix();
    protected RectF mBitmapRect = new RectF();
    protected RectF mCenterRect = new RectF();
    protected final Matrix mDisplayMatrix = new Matrix();
    protected Easing mEasing = new Cubic();
    protected boolean mFitToScreen = false;
    protected Handler mHandler = new Handler();
    private OnBitmapChangedListener mListener;
    protected final float[] mMatrixValues = new float[9];
    protected float mMaxZoom;
    protected float mMinZoom = -1.0f;
    protected Runnable mOnLayoutRunnable = null;
    protected RectF mScrollRect = new RectF();
    protected Matrix mSuppMatrix = new Matrix();
    protected int mThisHeight = -1;
    protected int mThisWidth = -1;
    private OnMatrixChangedListener matrixChangedListener;
    private OnZoomChangedListener zoomChangedListener;

    public interface OnBitmapChangedListener {
        void onBitmapChanged(Drawable drawable);
    }

    public interface OnMatrixChangedListener {
        void onMatrixChanged(Matrix matrix);
    }

    public interface OnZoomChangedListener {
        void onZoomChanged(float f);
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setOnBitmapChangedListener(OnBitmapChangedListener listener) {
        this.mListener = listener;
    }

    /* access modifiers changed from: protected */
    public void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void clear() {
        setImageBitmap((Bitmap) null, true);
    }

    public void setFitToScreen(boolean value) {
        if (value != this.mFitToScreen) {
            this.mFitToScreen = value;
            requestLayout();
        }
    }

    public void setMinZoom(float value) {
        this.mMinZoom = value;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mThisWidth = right - left;
        this.mThisHeight = bottom - top;
        Runnable r = this.mOnLayoutRunnable;
        if (r != null) {
            this.mOnLayoutRunnable = null;
            r.run();
        }
        if (getDrawable() != null) {
            if (this.mFitToScreen) {
                getProperBaseMatrix2(getDrawable(), this.mBaseMatrix);
                setMinZoom(1.0f);
            } else {
                getProperBaseMatrix(getDrawable(), this.mBaseMatrix);
                setMinZoom(getMinZoom());
            }
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void setImageBitmap(Bitmap bm) {
        setImageBitmap(bm, true);
    }

    public void setImageResource(int resId) {
        setImageDrawable(getContext().getResources().getDrawable(resId));
    }

    public void setImageBitmap(Bitmap bitmap, boolean reset) {
        setImageBitmap(bitmap, reset, (Matrix) null);
    }

    public void setImageBitmap(Bitmap bitmap, boolean reset, Matrix matrix) {
        setImageBitmap(bitmap, reset, matrix, -1.0f);
    }

    public void setImageBitmap(Bitmap bitmap, boolean reset, Matrix matrix, float maxZoom) {
        if (bitmap != null) {
            setImageDrawable(new FastBitmapDrawable(bitmap), reset, matrix, maxZoom);
        } else {
            setImageDrawable((Drawable) null, reset, matrix, maxZoom);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, true, (Matrix) null, -1.0f);
    }

    public void setImageDrawable(Drawable drawable, boolean reset, Matrix initial_matrix, float maxZoom) {
        if (getWidth() <= 0) {
            final Drawable drawable2 = drawable;
            final boolean z = reset;
            final Matrix matrix = initial_matrix;
            final float f = maxZoom;
            this.mOnLayoutRunnable = new Runnable() {
                public void run() {
                    ImageViewTouchBase.this.setImageDrawable(drawable2, z, matrix, f);
                }
            };
            return;
        }
        _setImageDrawable(drawable, reset, initial_matrix, maxZoom);
    }

    /* access modifiers changed from: protected */
    public void _setImageDrawable(Drawable drawable, boolean reset, Matrix initial_matrix, float maxZoom) {
        if (drawable != null) {
            if (this.mFitToScreen) {
                getProperBaseMatrix2(drawable, this.mBaseMatrix);
                if (getResources().getConfiguration().orientation == 2) {
                    setMinZoom(getScale(this.mBaseMatrix));
                } else {
                    setMinZoom(getMinZoom());
                }
            } else {
                getProperBaseMatrix(drawable, this.mBaseMatrix);
                setMinZoom(getMinZoom());
            }
            super.setImageDrawable(drawable);
        } else {
            this.mBaseMatrix.reset();
            super.setImageDrawable((Drawable) null);
        }
        if (reset) {
            this.mSuppMatrix.reset();
            if (initial_matrix != null) {
                this.mSuppMatrix = new Matrix(initial_matrix);
            }
        }
        setImageMatrix(getImageViewMatrix());
        if (maxZoom < 1.0f) {
            this.mMaxZoom = maxZoom();
        } else {
            this.mMaxZoom = maxZoom;
        }
        onBitmapChanged(drawable);
    }

    /* access modifiers changed from: protected */
    public void onBitmapChanged(Drawable bitmap) {
        if (this.mListener != null) {
            this.mListener.onBitmapChanged(bitmap);
        }
    }

    /* access modifiers changed from: protected */
    public float maxZoom() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 1.0f;
        }
        return Math.max(((float) drawable.getIntrinsicWidth()) / ((float) this.mThisWidth), ((float) drawable.getIntrinsicHeight()) / ((float) this.mThisHeight)) * 4.0f;
    }

    /* access modifiers changed from: protected */
    public float minZoom() {
        return 1.0f;
    }

    public float getMaxZoom() {
        if (this.mMaxZoom < 1.0f) {
            this.mMaxZoom = maxZoom();
        }
        return this.mMaxZoom;
    }

    public float getMinZoom() {
        if (this.mMinZoom < BitmapDescriptorFactory.HUE_RED) {
            this.mMinZoom = minZoom();
        }
        return this.mMinZoom;
    }

    public Matrix getImageViewMatrix() {
        return getImageViewMatrix(this.mSuppMatrix);
    }

    public Matrix getImageViewMatrix(Matrix supportMatrix) {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(supportMatrix);
        return this.mDisplayMatrix;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.mSuppMatrix);
    }

    /* access modifiers changed from: protected */
    public void getProperBaseMatrix(Drawable drawable, Matrix matrix) {
        float viewWidth = (float) getWidth();
        float viewHeight = (float) getHeight();
        float w = (float) drawable.getIntrinsicWidth();
        float h = (float) drawable.getIntrinsicHeight();
        matrix.reset();
        if (w > viewWidth || h > viewHeight) {
            float scale = Math.min(Math.min(viewWidth / w, 2.0f), Math.min(viewHeight / h, 2.0f));
            matrix.postScale(scale, scale);
            matrix.postTranslate((viewWidth - (w * scale)) / 2.0f, (viewHeight - (h * scale)) / 2.0f);
            return;
        }
        matrix.postTranslate((viewWidth - w) / 2.0f, (viewHeight - h) / 2.0f);
    }

    /* access modifiers changed from: protected */
    public void getProperBaseMatrix2(Drawable bitmap, Matrix matrix) {
        float viewWidth = (float) getWidth();
        float viewHeight = (float) getHeight();
        float w = (float) bitmap.getIntrinsicWidth();
        float h = (float) bitmap.getIntrinsicHeight();
        matrix.reset();
        float scale = Math.max(Math.min(viewWidth / w, 2.0f), Math.min(viewHeight / h, 2.0f));
        matrix.postScale(scale, scale);
    }

    /* access modifiers changed from: protected */
    public float getValue(Matrix matrix, int whichValue) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[whichValue];
    }

    /* access modifiers changed from: protected */
    public RectF getBitmapRect() {
        return getBitmapRect(this.mSuppMatrix);
    }

    /* access modifiers changed from: protected */
    public RectF getBitmapRect(Matrix supportMatrix) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        Matrix m = getImageViewMatrix(supportMatrix);
        this.mBitmapRect.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        m.mapRect(this.mBitmapRect);
        return this.mBitmapRect;
    }

    /* access modifiers changed from: protected */
    public float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    public float getRotation() {
        return BitmapDescriptorFactory.HUE_RED;
    }

    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    /* access modifiers changed from: protected */
    public void center(boolean horizontal, boolean vertical) {
        if (getDrawable() != null) {
            RectF rect = getCenter(this.mSuppMatrix, horizontal, vertical);
            if (rect.left != BitmapDescriptorFactory.HUE_RED || rect.top != BitmapDescriptorFactory.HUE_RED) {
                postTranslate(rect.left, rect.top);
            }
        }
    }

    /* access modifiers changed from: protected */
    public RectF getCenter(Matrix supportMatrix, boolean horizontal, boolean vertical) {
        if (getDrawable() == null) {
            return new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        }
        this.mCenterRect.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        RectF rect = getBitmapRect(supportMatrix);
        float height = rect.height();
        float width = rect.width();
        float deltaX = BitmapDescriptorFactory.HUE_RED;
        float deltaY = BitmapDescriptorFactory.HUE_RED;
        if (vertical) {
            int viewHeight = getHeight();
            if (height < ((float) viewHeight)) {
                deltaY = ((((float) viewHeight) - height) / 2.0f) - rect.top;
            } else if (rect.top > BitmapDescriptorFactory.HUE_RED) {
                deltaY = -rect.top;
            } else if (rect.bottom < ((float) viewHeight)) {
                deltaY = ((float) getHeight()) - rect.bottom;
            }
        }
        if (horizontal) {
            int viewWidth = getWidth();
            if (width < ((float) viewWidth)) {
                deltaX = ((((float) viewWidth) - width) / 2.0f) - rect.left;
            } else if (rect.left > BitmapDescriptorFactory.HUE_RED) {
                deltaX = -rect.left;
            } else if (rect.right < ((float) viewWidth)) {
                deltaX = ((float) viewWidth) - rect.right;
            }
        }
        this.mCenterRect.set(deltaX, deltaY, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        return this.mCenterRect;
    }

    /* access modifiers changed from: protected */
    public void postTranslate(float deltaX, float deltaY) {
        this.mSuppMatrix.postTranslate(deltaX, deltaY);
        setImageMatrix(getImageViewMatrix());
        if (this.matrixChangedListener != null) {
            this.matrixChangedListener.onMatrixChanged(this.mDisplayMatrix);
        }
    }

    /* access modifiers changed from: protected */
    public void postScale(float scale, float centerX, float centerY) {
        this.mSuppMatrix.postScale(scale, scale, centerX, centerY);
        setImageMatrix(getImageViewMatrix());
        if (this.matrixChangedListener != null) {
            this.matrixChangedListener.onMatrixChanged(this.mDisplayMatrix);
        }
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float scale) {
        zoomTo(scale, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public void zoomTo(float scale, float durationMs) {
        zoomTo(scale, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, durationMs);
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float scale, float centerX, float centerY) {
        if (scale > this.mMaxZoom) {
            scale = this.mMaxZoom;
        }
        postScale(scale / getScale(), centerX, centerY);
        onZoom(getScale());
        center(true, true);
    }

    /* access modifiers changed from: protected */
    public void onZoom(float scale) {
        if (this.zoomChangedListener != null) {
            this.zoomChangedListener.onZoomChanged(scale);
        }
    }

    /* access modifiers changed from: protected */
    public void onZoomAnimationCompleted(float scale) {
    }

    public void scrollBy(float x, float y) {
        panBy((double) x, (double) y);
    }

    /* access modifiers changed from: protected */
    public void panBy(double dx, double dy) {
        RectF rect = getBitmapRect();
        this.mScrollRect.set((float) dx, (float) dy, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        updateRect(rect, this.mScrollRect);
        postTranslate(this.mScrollRect.left, this.mScrollRect.top);
        center(true, true);
    }

    /* access modifiers changed from: protected */
    public void updateRect(RectF bitmapRect, RectF scrollRect) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (bitmapRect.top >= BitmapDescriptorFactory.HUE_RED && bitmapRect.bottom <= height) {
            scrollRect.top = BitmapDescriptorFactory.HUE_RED;
        }
        if (bitmapRect.left >= BitmapDescriptorFactory.HUE_RED && bitmapRect.right <= width) {
            scrollRect.left = BitmapDescriptorFactory.HUE_RED;
        }
        if (bitmapRect.top + scrollRect.top >= BitmapDescriptorFactory.HUE_RED && bitmapRect.bottom > height) {
            scrollRect.top = (float) ((int) (BitmapDescriptorFactory.HUE_RED - bitmapRect.top));
        }
        if (bitmapRect.bottom + scrollRect.top <= height - BitmapDescriptorFactory.HUE_RED && bitmapRect.top < BitmapDescriptorFactory.HUE_RED) {
            scrollRect.top = (float) ((int) ((height - BitmapDescriptorFactory.HUE_RED) - bitmapRect.bottom));
        }
        if (bitmapRect.left + scrollRect.left >= BitmapDescriptorFactory.HUE_RED) {
            scrollRect.left = (float) ((int) (BitmapDescriptorFactory.HUE_RED - bitmapRect.left));
        }
        if (bitmapRect.right + scrollRect.left <= width - BitmapDescriptorFactory.HUE_RED) {
            scrollRect.left = (float) ((int) ((width - BitmapDescriptorFactory.HUE_RED) - bitmapRect.right));
        }
    }

    public void scrollBy(float distanceX, float distanceY, double durationMs) {
        final double dx = (double) distanceX;
        final double dy = (double) distanceY;
        final long startTime = System.currentTimeMillis();
        final double d = durationMs;
        this.mHandler.post(new Runnable() {
            double old_x = 0.0d;
            double old_y = 0.0d;

            public void run() {
                double currentMs = Math.min(d, (double) (System.currentTimeMillis() - startTime));
                double x = ImageViewTouchBase.this.mEasing.easeOut(currentMs, 0.0d, dx, d);
                double y = ImageViewTouchBase.this.mEasing.easeOut(currentMs, 0.0d, dy, d);
                ImageViewTouchBase.this.panBy(x - this.old_x, y - this.old_y);
                this.old_x = x;
                this.old_y = y;
                if (currentMs < d) {
                    ImageViewTouchBase.this.mHandler.post(this);
                    return;
                }
                RectF centerRect = ImageViewTouchBase.this.getCenter(ImageViewTouchBase.this.mSuppMatrix, true, true);
                if (centerRect.left != BitmapDescriptorFactory.HUE_RED || centerRect.top != BitmapDescriptorFactory.HUE_RED) {
                    ImageViewTouchBase.this.scrollBy(centerRect.left, centerRect.top);
                }
            }
        });
    }

    public void zoomTo(float scale, float centerX, float centerY, float durationMs) {
        if (scale > getMaxZoom()) {
            scale = getMaxZoom();
        }
        final long startTime = System.currentTimeMillis();
        final float oldScale = getScale();
        final float deltaScale = scale - oldScale;
        Matrix m = new Matrix(this.mSuppMatrix);
        m.postScale(scale, scale, centerX, centerY);
        RectF rect = getCenter(m, true, true);
        final float destX = centerX + (rect.left * scale);
        final float destY = centerY + (rect.top * scale);
        final float f = durationMs;
        this.mHandler.post(new Runnable() {
            public void run() {
                float currentMs = Math.min(f, (float) (System.currentTimeMillis() - startTime));
                ImageViewTouchBase.this.zoomTo(oldScale + ((float) ImageViewTouchBase.this.mEasing.easeInOut((double) currentMs, 0.0d, (double) deltaScale, (double) f)), destX, destY);
                if (currentMs < f) {
                    ImageViewTouchBase.this.mHandler.post(this);
                    return;
                }
                ImageViewTouchBase.this.onZoomAnimationCompleted(ImageViewTouchBase.this.getScale());
                ImageViewTouchBase.this.center(true, true);
            }
        });
    }

    public void dispose() {
        clear();
    }

    public void setOnMatrixChangedListener(OnMatrixChangedListener listener) {
        this.matrixChangedListener = listener;
    }

    public void setOnZoomChangedListener(OnZoomChangedListener listener) {
        this.zoomChangedListener = listener;
    }
}
