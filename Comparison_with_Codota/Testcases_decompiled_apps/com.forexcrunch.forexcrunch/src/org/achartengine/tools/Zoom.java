package org.achartengine.tools;

import java.util.ArrayList;
import java.util.List;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;

public class Zoom extends AbstractTool {
    public static final int ZOOM_AXIS_X = 1;
    public static final int ZOOM_AXIS_XY = 0;
    public static final int ZOOM_AXIS_Y = 2;
    private boolean limitsReachedX = false;
    private boolean limitsReachedY = false;
    private boolean mZoomIn;
    private List<ZoomListener> mZoomListeners = new ArrayList();
    private float mZoomRate;

    public Zoom(AbstractChart chart, boolean in, float rate) {
        super(chart);
        this.mZoomIn = in;
        setZoomRate(rate);
    }

    public void setZoomRate(float rate) {
        this.mZoomRate = rate;
    }

    public void apply(int zoom_axis) {
        double minX;
        double minY;
        if (this.mChart instanceof XYChart) {
            int scales = this.mRenderer.getScalesCount();
            for (int i = 0; i < scales; i++) {
                double[] range = getRange(i);
                checkRange(range, i);
                double[] limits = this.mRenderer.getZoomLimits();
                double centerX = (range[0] + range[1]) / 2.0d;
                double centerY = (range[2] + range[3]) / 2.0d;
                double newWidth = range[1] - range[0];
                double newHeight = range[3] - range[2];
                double newXMin = centerX - (newWidth / 2.0d);
                double newXMax = centerX + (newWidth / 2.0d);
                double newYMin = centerY - (newHeight / 2.0d);
                double newYMax = centerY + (newHeight / 2.0d);
                if (i == 0) {
                    this.limitsReachedX = limits != null && (newXMin <= limits[0] || newXMax >= limits[1]);
                    this.limitsReachedY = limits != null && (newYMin <= limits[2] || newYMax >= limits[3]);
                }
                if (this.mZoomIn) {
                    if (this.mRenderer.isZoomXEnabled() && ((zoom_axis == 1 || zoom_axis == 0) && (!this.limitsReachedX || this.mZoomRate >= 1.0f))) {
                        newWidth /= (double) this.mZoomRate;
                    }
                    if (this.mRenderer.isZoomYEnabled() && ((zoom_axis == 2 || zoom_axis == 0) && (!this.limitsReachedY || this.mZoomRate >= 1.0f))) {
                        newHeight /= (double) this.mZoomRate;
                    }
                } else {
                    if (this.mRenderer.isZoomXEnabled() && !this.limitsReachedX && (zoom_axis == 1 || zoom_axis == 0)) {
                        newWidth *= (double) this.mZoomRate;
                    }
                    if (this.mRenderer.isZoomYEnabled() && !this.limitsReachedY && (zoom_axis == 2 || zoom_axis == 0)) {
                        newHeight *= (double) this.mZoomRate;
                    }
                }
                if (limits != null) {
                    minX = Math.min(this.mRenderer.getZoomInLimitX(), limits[1] - limits[0]);
                    minY = Math.min(this.mRenderer.getZoomInLimitY(), limits[3] - limits[2]);
                } else {
                    minX = this.mRenderer.getZoomInLimitX();
                    minY = this.mRenderer.getZoomInLimitY();
                }
                double newWidth2 = Math.max(newWidth, minX);
                double newHeight2 = Math.max(newHeight, minY);
                if (this.mRenderer.isZoomXEnabled() && (zoom_axis == 1 || zoom_axis == 0)) {
                    setXRange(centerX - (newWidth2 / 2.0d), centerX + (newWidth2 / 2.0d), i);
                }
                if (this.mRenderer.isZoomYEnabled() && (zoom_axis == 2 || zoom_axis == 0)) {
                    setYRange(centerY - (newHeight2 / 2.0d), centerY + (newHeight2 / 2.0d), i);
                }
            }
        } else {
            DefaultRenderer renderer = ((RoundChart) this.mChart).getRenderer();
            if (this.mZoomIn) {
                renderer.setScale(renderer.getScale() * this.mZoomRate);
            } else {
                renderer.setScale(renderer.getScale() / this.mZoomRate);
            }
        }
        notifyZoomListeners(new ZoomEvent(this.mZoomIn, this.mZoomRate));
    }

    private synchronized void notifyZoomListeners(ZoomEvent e) {
        for (ZoomListener listener : this.mZoomListeners) {
            listener.zoomApplied(e);
        }
    }

    public synchronized void notifyZoomResetListeners() {
        for (ZoomListener listener : this.mZoomListeners) {
            listener.zoomReset();
        }
    }

    public synchronized void addZoomListener(ZoomListener listener) {
        this.mZoomListeners.add(listener);
    }

    public synchronized void removeZoomListener(ZoomListener listener) {
        this.mZoomListeners.remove(listener);
    }
}
