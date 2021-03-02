package org.achartengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.view.MotionEvent;
import android.view.View;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.tools.FitZoom;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.Zoom;
import org.achartengine.tools.ZoomListener;

public class GraphicalView extends View {
    private static final int ZOOM_BUTTONS_COLOR = Color.argb(175, 150, 150, 150);
    private Bitmap fitZoomImage;
    private AbstractChart mChart;
    private boolean mDrawn;
    private FitZoom mFitZoom;
    private Handler mHandler;
    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private DefaultRenderer mRenderer;
    private ITouchHandler mTouchHandler;
    private Zoom mZoomIn;
    private Zoom mZoomOut;
    private RectF mZoomR = new RectF();
    private float oldX;
    private float oldY;
    private Bitmap zoomInImage;
    private Bitmap zoomOutImage;
    private int zoomSize = 50;

    public GraphicalView(Context context, AbstractChart chart) {
        super(context);
        this.mChart = chart;
        this.mHandler = new Handler();
        if (this.mChart instanceof XYChart) {
            this.mRenderer = ((XYChart) this.mChart).getRenderer();
        } else {
            this.mRenderer = ((RoundChart) this.mChart).getRenderer();
        }
        if (this.mRenderer.isZoomButtonsVisible()) {
            this.zoomInImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom_in.png"));
            this.zoomOutImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom_out.png"));
            this.fitZoomImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom-1.png"));
        }
        if ((this.mRenderer instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer) this.mRenderer).getMarginsColor() == 0) {
            ((XYMultipleSeriesRenderer) this.mRenderer).setMarginsColor(this.mPaint.getColor());
        }
        if ((this.mRenderer.isZoomEnabled() && this.mRenderer.isZoomButtonsVisible()) || this.mRenderer.isExternalZoomEnabled()) {
            this.mZoomIn = new Zoom(this.mChart, true, this.mRenderer.getZoomRate());
            this.mZoomOut = new Zoom(this.mChart, false, this.mRenderer.getZoomRate());
            this.mFitZoom = new FitZoom(this.mChart);
        }
        int version = 7;
        try {
            version = Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (Exception e) {
        }
        if (version < 7) {
            this.mTouchHandler = new TouchHandlerOld(this, this.mChart);
        } else {
            this.mTouchHandler = new TouchHandler(this, this.mChart);
        }
    }

    public SeriesSelection getCurrentSeriesAndPoint() {
        return this.mChart.getSeriesAndPointForScreenCoordinate(new Point(this.oldX, this.oldY));
    }

    public double[] toRealPoint(int scale) {
        if (this.mChart instanceof XYChart) {
            return ((XYChart) this.mChart).toRealPoint(this.oldX, this.oldY, scale);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mRect);
        int top = this.mRect.top;
        int left = this.mRect.left;
        int width = this.mRect.width();
        int height = this.mRect.height();
        if (this.mRenderer.isInScroll()) {
            top = 0;
            left = 0;
            width = getMeasuredWidth();
            height = getMeasuredHeight();
        }
        this.mChart.draw(canvas, left, top, width, height, this.mPaint);
        if (this.mRenderer != null && this.mRenderer.isZoomEnabled() && this.mRenderer.isZoomButtonsVisible()) {
            this.mPaint.setColor(ZOOM_BUTTONS_COLOR);
            this.zoomSize = Math.max(this.zoomSize, Math.min(width, height) / 7);
            this.mZoomR.set((float) ((left + width) - (this.zoomSize * 3)), ((float) (top + height)) - (((float) this.zoomSize) * 0.775f), (float) (left + width), (float) (top + height));
            canvas.drawRoundRect(this.mZoomR, (float) (this.zoomSize / 3), (float) (this.zoomSize / 3), this.mPaint);
            float buttonY = ((float) (top + height)) - (((float) this.zoomSize) * 0.625f);
            canvas.drawBitmap(this.zoomInImage, ((float) (left + width)) - (((float) this.zoomSize) * 2.75f), buttonY, (Paint) null);
            canvas.drawBitmap(this.zoomOutImage, ((float) (left + width)) - (((float) this.zoomSize) * 1.75f), buttonY, (Paint) null);
            canvas.drawBitmap(this.fitZoomImage, ((float) (left + width)) - (((float) this.zoomSize) * 0.75f), buttonY, (Paint) null);
        }
        this.mDrawn = true;
    }

    public void setZoomRate(float rate) {
        if (this.mZoomIn != null && this.mZoomOut != null) {
            this.mZoomIn.setZoomRate(rate);
            this.mZoomOut.setZoomRate(rate);
        }
    }

    public void zoomIn() {
        if (this.mZoomIn != null) {
            this.mZoomIn.apply(0);
            repaint();
        }
    }

    public void zoomOut() {
        if (this.mZoomOut != null) {
            this.mZoomOut.apply(0);
            repaint();
        }
    }

    public void zoomReset() {
        if (this.mFitZoom != null) {
            this.mFitZoom.apply();
            this.mZoomIn.notifyZoomResetListeners();
            repaint();
        }
    }

    public void addZoomListener(ZoomListener listener, boolean onButtons, boolean onPinch) {
        if (onButtons) {
            if (this.mZoomIn != null) {
                this.mZoomIn.addZoomListener(listener);
                this.mZoomOut.addZoomListener(listener);
            }
            if (onPinch) {
                this.mTouchHandler.addZoomListener(listener);
            }
        }
    }

    public synchronized void removeZoomListener(ZoomListener listener) {
        if (this.mZoomIn != null) {
            this.mZoomIn.removeZoomListener(listener);
            this.mZoomOut.removeZoomListener(listener);
        }
        this.mTouchHandler.removeZoomListener(listener);
    }

    public void addPanListener(PanListener listener) {
        this.mTouchHandler.addPanListener(listener);
    }

    public void removePanListener(PanListener listener) {
        this.mTouchHandler.removePanListener(listener);
    }

    /* access modifiers changed from: protected */
    public RectF getZoomRectangle() {
        return this.mZoomR;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            this.oldX = event.getX();
            this.oldY = event.getY();
        }
        if (this.mRenderer == null || !this.mDrawn || ((!this.mRenderer.isPanEnabled() && !this.mRenderer.isZoomEnabled()) || !this.mTouchHandler.handleTouch(event))) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    public void repaint() {
        this.mHandler.post(new Runnable() {
            public void run() {
                GraphicalView.this.invalidate();
            }
        });
    }

    public void repaint(int left, int top, int right, int bottom) {
        final int i = left;
        final int i2 = top;
        final int i3 = right;
        final int i4 = bottom;
        this.mHandler.post(new Runnable() {
            public void run() {
                GraphicalView.this.invalidate(i, i2, i3, i4);
            }
        });
    }

    public Bitmap toBitmap() {
        setDrawingCacheEnabled(false);
        if (!isDrawingCacheEnabled()) {
            setDrawingCacheEnabled(true);
        }
        if (this.mRenderer.isApplyBackgroundColor()) {
            setDrawingCacheBackgroundColor(this.mRenderer.getBackgroundColor());
        }
        setDrawingCacheQuality(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
        return getDrawingCache(true);
    }
}
