package org.achartengine.tools;

import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;

public class FitZoom extends AbstractTool {
    public FitZoom(AbstractChart chart) {
        super(chart);
    }

    public void apply() {
        if (!(this.mChart instanceof XYChart)) {
            DefaultRenderer renderer = ((RoundChart) this.mChart).getRenderer();
            renderer.setScale(renderer.getOriginalScale());
        } else if (((XYChart) this.mChart).getDataset() != null) {
            int scales = this.mRenderer.getScalesCount();
            if (this.mRenderer.isInitialRangeSet()) {
                for (int i = 0; i < scales; i++) {
                    if (this.mRenderer.isInitialRangeSet(i)) {
                        this.mRenderer.setRange(this.mRenderer.getInitialRange(i), i);
                    }
                }
                return;
            }
            XYSeries[] series = ((XYChart) this.mChart).getDataset().getSeries();
            int length = series.length;
            if (length > 0) {
                for (int i2 = 0; i2 < scales; i2++) {
                    double[] range = {Double.MAX_VALUE, -1.7976931348623157E308d, Double.MAX_VALUE, -1.7976931348623157E308d};
                    for (int j = 0; j < length; j++) {
                        if (i2 == series[j].getScaleNumber()) {
                            range[0] = Math.min(range[0], series[j].getMinX());
                            range[1] = Math.max(range[1], series[j].getMaxX());
                            range[2] = Math.min(range[2], series[j].getMinY());
                            range[3] = Math.max(range[3], series[j].getMaxY());
                        }
                    }
                    double marginX = Math.abs(range[1] - range[0]) / 40.0d;
                    double marginY = Math.abs(range[3] - range[2]) / 40.0d;
                    this.mRenderer.setRange(new double[]{range[0] - marginX, range[1] + marginX, range[2] - marginY, range[3] + marginY}, i2);
                }
            }
        }
    }
}
