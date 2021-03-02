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
import org.achartengine.tools.ZoomListener;

public class TouchHandlerOld implements ITouchHandler {
    private GraphicalView graphicalView;
    private Pan mPan;
    private DefaultRenderer mRenderer;
    private float oldX;
    private float oldY;
    private RectF zoomR = new RectF();

    public TouchHandlerOld(GraphicalView view, AbstractChart chart) {
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
    }

    public boolean handleTouch(MotionEvent event) {
        int action = event.getAction();
        if (this.mRenderer == null || action != 2) {
            if (action == 0) {
                this.oldX = event.getX();
                this.oldY = event.getY();
                if (this.mRenderer != null && this.mRenderer.isZoomEnabled() && this.zoomR.contains(this.oldX, this.oldY)) {
                    if (this.oldX < this.zoomR.left + (this.zoomR.width() / 3.0f)) {
                        this.graphicalView.zoomIn();
                        return true;
                    } else if (this.oldX < this.zoomR.left + ((this.zoomR.width() * 2.0f) / 3.0f)) {
                        this.graphicalView.zoomOut();
                        return true;
                    } else {
                        this.graphicalView.zoomReset();
                        return true;
                    }
                }
            } else if (action == 1) {
                this.oldX = BitmapDescriptorFactory.HUE_RED;
                this.oldY = BitmapDescriptorFactory.HUE_RED;
            }
        } else if (this.oldX >= BitmapDescriptorFactory.HUE_RED || this.oldY >= BitmapDescriptorFactory.HUE_RED) {
            float newX = event.getX();
            float newY = event.getY();
            if (this.mRenderer.isPanEnabled()) {
                this.mPan.apply(this.oldX, this.oldY, newX, newY);
            }
            this.oldX = newX;
            this.oldY = newY;
            this.graphicalView.repaint();
            return true;
        }
        if (this.mRenderer.isClickEnabled()) {
            return false;
        }
        return true;
    }

    public void addZoomListener(ZoomListener listener) {
    }

    public void removeZoomListener(ZoomListener listener) {
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
