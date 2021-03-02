package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYValueSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class BubbleChart extends XYChart {
    private static final int MAX_BUBBLE_SIZE = 20;
    private static final int MIN_BUBBLE_SIZE = 2;
    private static final int SHAPE_WIDTH = 10;
    public static final String TYPE = "Bubble";

    BubbleChart() {
    }

    public BubbleChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        super(dataset, renderer);
    }

    public void drawSeries(Canvas canvas, Paint paint, List<Float> points, SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, int startIndex) {
        paint.setColor(((XYSeriesRenderer) seriesRenderer).getColor());
        paint.setStyle(Paint.Style.FILL);
        int length = points.size();
        XYValueSeries series = (XYValueSeries) this.mDataset.getSeriesAt(seriesIndex);
        double coef = 20.0d / series.getMaxValue();
        for (int i = 0; i < length; i += 2) {
            List<Float> list = points;
            Canvas canvas2 = canvas;
            Paint paint2 = paint;
            drawCircle(canvas2, paint2, points.get(i).floatValue(), list.get(i + 1).floatValue(), (float) ((series.getValue((i / 2) + startIndex) * coef) + 2.0d));
        }
    }

    /* access modifiers changed from: protected */
    public ClickableArea[] clickableAreasForPoints(List<Float> points, List<Double> values, float yAxisValue, int seriesIndex, int startIndex) {
        int length = points.size();
        XYValueSeries series = (XYValueSeries) this.mDataset.getSeriesAt(seriesIndex);
        double coef = 20.0d / series.getMaxValue();
        ClickableArea[] ret = new ClickableArea[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            double size = (series.getValue((i / 2) + startIndex) * coef) + 2.0d;
            ret[i / 2] = new ClickableArea(new RectF(points.get(i).floatValue() - ((float) size), points.get(i + 1).floatValue() - ((float) size), ((float) size) + points.get(i).floatValue(), points.get(i + 1).floatValue() + ((float) size)), values.get(i).doubleValue(), values.get(i + 1).doubleValue());
        }
        return ret;
    }

    public int getLegendShapeWidth(int seriesIndex) {
        return 10;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y, int seriesIndex, Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        drawCircle(canvas, paint, x + 10.0f, y, 3.0f);
    }

    private void drawCircle(Canvas canvas, Paint paint, float x, float y, float radius) {
        canvas.drawCircle(x, y, radius, paint);
    }

    public String getChartType() {
        return TYPE;
    }
}
