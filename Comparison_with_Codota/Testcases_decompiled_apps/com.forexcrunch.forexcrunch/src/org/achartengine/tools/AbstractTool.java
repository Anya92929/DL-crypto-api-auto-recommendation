package org.achartengine.tools;

import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public abstract class AbstractTool {
    protected AbstractChart mChart;
    protected XYMultipleSeriesRenderer mRenderer;

    public AbstractTool(AbstractChart chart) {
        this.mChart = chart;
        if (chart instanceof XYChart) {
            this.mRenderer = ((XYChart) chart).getRenderer();
        }
    }

    public double[] getRange(int scale) {
        return new double[]{this.mRenderer.getXAxisMin(scale), this.mRenderer.getXAxisMax(scale), this.mRenderer.getYAxisMin(scale), this.mRenderer.getYAxisMax(scale)};
    }

    public void checkRange(double[] range, int scale) {
        double[] calcRange;
        if ((this.mChart instanceof XYChart) && (calcRange = ((XYChart) this.mChart).getCalcRange(scale)) != null) {
            if (!this.mRenderer.isMinXSet(scale)) {
                range[0] = calcRange[0];
                this.mRenderer.setXAxisMin(range[0], scale);
            }
            if (!this.mRenderer.isMaxXSet(scale)) {
                range[1] = calcRange[1];
                this.mRenderer.setXAxisMax(range[1], scale);
            }
            if (!this.mRenderer.isMinYSet(scale)) {
                range[2] = calcRange[2];
                this.mRenderer.setYAxisMin(range[2], scale);
            }
            if (!this.mRenderer.isMaxYSet(scale)) {
                range[3] = calcRange[3];
                this.mRenderer.setYAxisMax(range[3], scale);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setXRange(double min, double max, int scale) {
        this.mRenderer.setXAxisMin(min, scale);
        this.mRenderer.setXAxisMax(max, scale);
    }

    /* access modifiers changed from: protected */
    public void setYRange(double min, double max, int scale) {
        this.mRenderer.setYAxisMin(min, scale);
        this.mRenderer.setYAxisMax(max, scale);
    }
}
