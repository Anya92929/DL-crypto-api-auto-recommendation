package org.achartengine;

import android.graphics.RectF;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.tools.Pan;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.Zoom;
import org.achartengine.tools.ZoomListener;

public class TouchHandler implements ITouchHandler {
    private GraphicalView graphicalView;
    private Pan mPan;
    private Zoom mPinchZoom;
    private DefaultRenderer mRenderer;
    private float oldX;
    private float oldX2;
    private float oldY;
    private float oldY2;
    private RectF zoomR = new RectF();

    public TouchHandler(GraphicalView view, AbstractChart chart) {
        this.graphicalView = view;
        this.zoomR = this.graphicalView.getZoomRectangle();
        if (chart instanceof XYChart) {
            this.mRenderer = ((XYChart) chart).getRenderer();
        } else {
            this.mRenderer = ((RoundChart) chart).getRenderer();
        }
        if (this.mRenderer.isPanEnabled()) {
            this.mPan = new Pan(chart);
        }
        if (this.mRenderer.isZoomEnabled()) {
            this.mPinchZoom = new Zoom(chart, true, 1.0f);
        }
    }

    public boolean handleTouch(MotionEvent event) {
        float zoomRate;
        int action = event.getAction();
        if (this.mRenderer == null || action != 2) {
            if (action == 0) {
                this.oldX = event.getX(0);
                this.oldY = event.getY(0);
                if (this.mRenderer != null && this.mRenderer.isZoomEnabled() && this.zoomR.contains(this.oldX, this.oldY)) {
                    if (this.oldX < this.zoomR.left + (this.zoomR.width() / 3.0f)) {
                        this.graphicalView.zoomIn();
                    } else if (this.oldX < this.zoomR.left + ((this.zoomR.width() * 2.0f) / 3.0f)) {
                        this.graphicalView.zoomOut();
                    } else {
                        this.graphicalView.zoomReset();
                    }
                    return true;
                }
            } else if (action == 1 || action == 6) {
                this.oldX = BitmapDescriptorFactory.HUE_RED;
                this.oldY = BitmapDescriptorFactory.HUE_RED;
                this.oldX2 = BitmapDescriptorFactory.HUE_RED;
                this.oldY2 = BitmapDescriptorFactory.HUE_RED;
                if (action == 6) {
                    this.oldX = -1.0f;
                    this.oldY = -1.0f;
                }
            }
        } else if (this.oldX >= BitmapDescriptorFactory.HUE_RED || this.oldY >= BitmapDescriptorFactory.HUE_RED) {
            float newX = event.getX(0);
            float newY = event.getY(0);
            if (event.getPointerCount() > 1 && ((this.oldX2 >= BitmapDescriptorFactory.HUE_RED || this.oldY2 >= BitmapDescriptorFactory.HUE_RED) && this.mRenderer.isZoomEnabled())) {
                float newX2 = event.getX(1);
                float newY2 = event.getY(1);
                float newDeltaX = Math.abs(newX - newX2);
                float newDeltaY = Math.abs(newY - newY2);
                float oldDeltaX = Math.abs(this.oldX - this.oldX2);
                float oldDeltaY = Math.abs(this.oldY - this.oldY2);
                float tan1 = Math.abs(newY - this.oldY) / Math.abs(newX - this.oldX);
                float tan2 = Math.abs(newY2 - this.oldY2) / Math.abs(newX2 - this.oldX2);
                if (((double) tan1) <= 0.25d && ((double) tan2) <= 0.25d) {
                    applyZoom(newDeltaX / oldDeltaX, 1);
                } else if (((double) tan1) < 3.73d || ((double) tan2) < 3.73d) {
                    if (Math.abs(newX - this.oldX) >= Math.abs(newY - this.oldY)) {
                        zoomRate = newDeltaX / oldDeltaX;
                    } else {
                        zoomRate = newDeltaY / oldDeltaY;
                    }
                    applyZoom(zoomRate, 0);
                } else {
                    applyZoom(newDeltaY / oldDeltaY, 2);
                }
                this.oldX2 = newX2;
                this.oldY2 = newY2;
            } else if (this.mRenderer.isPanEnabled()) {
                this.mPan.apply(this.oldX, this.oldY, newX, newY);
                this.oldX2 = BitmapDescriptorFactory.HUE_RED;
                this.oldY2 = BitmapDescriptorFactory.HUE_RED;
            }
            this.oldX = newX;
            this.oldY = newY;
            this.graphicalView.repaint();
            return true;
        }
        return !this.mRenderer.isClickEnabled();
    }

    private void applyZoom(float zoomRate, int axis) {
        float zoomRate2 = Math.min(Math.max(zoomRate, 0.9f), 1.1f);
        if (((double) zoomRate2) > 0.9d && ((double) zoomRate2) < 1.1d) {
            this.mPinchZoom.setZoomRate(zoomRate2);
            this.mPinchZoom.apply(axis);
        }
    }

    public void addZoomListener(ZoomListener listener) {
        if (this.mPinchZoom != null) {
            this.mPinchZoom.addZoomListener(listener);
        }
    }

    public void removeZoomListener(ZoomListener listener) {
        if (this.mPinchZoom != null) {
            this.mPinchZoom.removeZoomListener(listener);
        }
    }

    public void addPanListener(PanListener listener) {
        if (this.mPan != null) {
            this.mPan.addPanListener(listener);
        }
    }

    public void removePanListener(PanListener listener) {
        if (this.mPan != null) {
            this.mPan.removePanListener(listener);
        }
    }
}
