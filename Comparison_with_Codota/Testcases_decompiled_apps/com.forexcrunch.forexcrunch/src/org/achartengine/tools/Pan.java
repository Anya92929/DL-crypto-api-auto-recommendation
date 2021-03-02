package org.achartengine.tools;

import java.util.ArrayList;
import java.util.List;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;

public class Pan extends AbstractTool {
    private boolean limitsReachedX = false;
    private boolean limitsReachedY = false;
    private List<PanListener> mPanListeners = new ArrayList();

    public Pan(AbstractChart chart) {
        super(chart);
    }

    public void apply(float oldX, float oldY, float newX, float newY) {
        boolean notLimitedUp = true;
        boolean notLimitedBottom = true;
        boolean notLimitedLeft = true;
        boolean notLimitedRight = true;
        if (this.mChart instanceof XYChart) {
            int scales = this.mRenderer.getScalesCount();
            double[] limits = this.mRenderer.getPanLimits();
            boolean limited = limits != null && limits.length == 4;
            XYChart chart = (XYChart) this.mChart;
            for (int i = 0; i < scales; i++) {
                double[] range = getRange(i);
                double[] calcRange = chart.getCalcRange(i);
                if (this.limitsReachedX && this.limitsReachedY) {
                    if (range[0] != range[1] || calcRange[0] != calcRange[1]) {
                        if (range[2] == range[3] && calcRange[2] == calcRange[3]) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                checkRange(range, i);
                double[] realPoint = chart.toRealPoint(oldX, oldY, i);
                double[] realPoint2 = chart.toRealPoint(newX, newY, i);
                double deltaX = realPoint[0] - realPoint2[0];
                double deltaY = realPoint[1] - realPoint2[1];
                double ratio = getAxisRatio(range);
                if (chart.isVertical(this.mRenderer)) {
                    double newDeltaY = deltaX / ratio;
                    deltaX = (-deltaY) * ratio;
                    deltaY = newDeltaY;
                }
                if (this.mRenderer.isPanXEnabled()) {
                    if (limits != null) {
                        if (notLimitedLeft) {
                            notLimitedLeft = limits[0] <= range[0] + deltaX;
                        }
                        if (notLimitedRight) {
                            notLimitedRight = limits[1] >= range[1] + deltaX;
                        }
                    }
                    if (!limited || (notLimitedLeft && notLimitedRight)) {
                        setXRange(range[0] + deltaX, range[1] + deltaX, i);
                        this.limitsReachedX = false;
                    } else {
                        this.limitsReachedX = true;
                    }
                }
                if (this.mRenderer.isPanYEnabled()) {
                    if (limits != null) {
                        if (notLimitedBottom) {
                            notLimitedBottom = limits[2] <= range[2] + deltaY;
                        }
                        if (notLimitedUp) {
                            notLimitedUp = limits[3] >= range[3] + deltaY;
                        }
                    }
                    if (!limited || (notLimitedBottom && notLimitedUp)) {
                        setYRange(range[2] + deltaY, range[3] + deltaY, i);
                        this.limitsReachedY = false;
                    } else {
                        this.limitsReachedY = true;
                    }
                }
            }
        } else {
            RoundChart chart2 = (RoundChart) this.mChart;
            chart2.setCenterX(chart2.getCenterX() + ((int) (newX - oldX)));
            chart2.setCenterY(chart2.getCenterY() + ((int) (newY - oldY)));
        }
        notifyPanListeners();
    }

    private double getAxisRatio(double[] range) {
        return Math.abs(range[1] - range[0]) / Math.abs(range[3] - range[2]);
    }

    private synchronized void notifyPanListeners() {
        for (PanListener listener : this.mPanListeners) {
            listener.panApplied();
        }
    }

    public synchronized void addPanListener(PanListener listener) {
        this.mPanListeners.add(listener);
    }

    public synchronized void removePanListener(PanListener listener) {
        this.mPanListeners.remove(listener);
    }
}
