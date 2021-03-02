package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public abstract class RoundChart extends AbstractChart {
    protected static final int NO_VALUE = Integer.MAX_VALUE;
    protected static final int SHAPE_WIDTH = 10;
    protected int mCenterX = Integer.MAX_VALUE;
    protected int mCenterY = Integer.MAX_VALUE;
    protected CategorySeries mDataset;
    protected DefaultRenderer mRenderer;

    public RoundChart(CategorySeries dataset, DefaultRenderer renderer) {
        this.mDataset = dataset;
        this.mRenderer = renderer;
    }

    public void drawTitle(Canvas canvas, int x, int y, int width, Paint paint) {
        if (this.mRenderer.isShowLabels()) {
            paint.setColor(this.mRenderer.getLabelsColor());
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(this.mRenderer.getChartTitleTextSize());
            drawString(canvas, this.mRenderer.getChartTitle(), (float) ((width / 2) + x), ((float) y) + this.mRenderer.getChartTitleTextSize(), paint);
        }
    }

    public int getLegendShapeWidth(int seriesIndex) {
        return 10;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y, int seriesIndex, Paint paint) {
        canvas.drawRect(x, y - 5.0f, x + 10.0f, y + 5.0f, paint);
    }

    public DefaultRenderer getRenderer() {
        return this.mRenderer;
    }

    public int getCenterX() {
        return this.mCenterX;
    }

    public int getCenterY() {
        return this.mCenterY;
    }

    public void setCenterX(int centerX) {
        this.mCenterX = centerX;
    }

    public void setCenterY(int centerY) {
        this.mCenterY = centerY;
    }
}
