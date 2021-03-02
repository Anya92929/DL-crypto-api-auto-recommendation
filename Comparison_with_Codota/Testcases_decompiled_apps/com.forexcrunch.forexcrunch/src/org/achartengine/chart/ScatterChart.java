package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class ScatterChart extends XYChart {
    private static final int SHAPE_WIDTH = 10;
    private static final float SIZE = 3.0f;
    public static final String TYPE = "Scatter";
    private float size = SIZE;

    ScatterChart() {
    }

    public ScatterChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        super(dataset, renderer);
        this.size = renderer.getPointSize();
    }

    /* access modifiers changed from: protected */
    public void setDatasetRenderer(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        super.setDatasetRenderer(dataset, renderer);
        this.size = renderer.getPointSize();
    }

    public void drawSeries(Canvas canvas, Paint paint, List<Float> points, SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, int startIndex) {
        XYSeriesRenderer renderer = (XYSeriesRenderer) seriesRenderer;
        paint.setColor(renderer.getColor());
        float stroke = paint.getStrokeWidth();
        if (renderer.isFillPoints()) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStrokeWidth(renderer.getPointStrokeWidth());
            paint.setStyle(Paint.Style.STROKE);
        }
        int length = points.size();
        switch (renderer.getPointStyle()) {
            case X:
                paint.setStrokeWidth(renderer.getPointStrokeWidth());
                for (int i = 0; i < length; i += 2) {
                    drawX(canvas, paint, points.get(i).floatValue(), points.get(i + 1).floatValue());
                }
                break;
            case CIRCLE:
                for (int i2 = 0; i2 < length; i2 += 2) {
                    drawCircle(canvas, paint, points.get(i2).floatValue(), points.get(i2 + 1).floatValue());
                }
                break;
            case TRIANGLE:
                float[] path = new float[6];
                for (int i3 = 0; i3 < length; i3 += 2) {
                    drawTriangle(canvas, paint, path, points.get(i3).floatValue(), points.get(i3 + 1).floatValue());
                }
                break;
            case SQUARE:
                for (int i4 = 0; i4 < length; i4 += 2) {
                    drawSquare(canvas, paint, points.get(i4).floatValue(), points.get(i4 + 1).floatValue());
                }
                break;
            case DIAMOND:
                float[] path2 = new float[8];
                for (int i5 = 0; i5 < length; i5 += 2) {
                    drawDiamond(canvas, paint, path2, points.get(i5).floatValue(), points.get(i5 + 1).floatValue());
                }
                break;
            case POINT:
                for (int i6 = 0; i6 < length; i6 += 2) {
                    canvas.drawPoint(points.get(i6).floatValue(), points.get(i6 + 1).floatValue(), paint);
                }
                break;
        }
        paint.setStrokeWidth(stroke);
    }

    /* access modifiers changed from: protected */
    public ClickableArea[] clickableAreasForPoints(List<Float> points, List<Double> values, float yAxisValue, int seriesIndex, int startIndex) {
        int length = points.size();
        ClickableArea[] ret = new ClickableArea[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            int selectableBuffer = this.mRenderer.getSelectableBuffer();
            ret[i / 2] = new ClickableArea(new RectF(points.get(i).floatValue() - ((float) selectableBuffer), points.get(i + 1).floatValue() - ((float) selectableBuffer), ((float) selectableBuffer) + points.get(i).floatValue(), points.get(i + 1).floatValue() + ((float) selectableBuffer)), values.get(i).doubleValue(), values.get(i + 1).doubleValue());
        }
        return ret;
    }

    public int getLegendShapeWidth(int seriesIndex) {
        return 10;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y, int seriesIndex, Paint paint) {
        if (((XYSeriesRenderer) renderer).isFillPoints()) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStyle(Paint.Style.STROKE);
        }
        switch (((XYSeriesRenderer) renderer).getPointStyle()) {
            case X:
                drawX(canvas, paint, x + 10.0f, y);
                return;
            case CIRCLE:
                drawCircle(canvas, paint, x + 10.0f, y);
                return;
            case TRIANGLE:
                drawTriangle(canvas, paint, new float[6], x + 10.0f, y);
                return;
            case SQUARE:
                drawSquare(canvas, paint, x + 10.0f, y);
                return;
            case DIAMOND:
                drawDiamond(canvas, paint, new float[8], x + 10.0f, y);
                return;
            case POINT:
                canvas.drawPoint(x + 10.0f, y, paint);
                return;
            default:
                return;
        }
    }

    private void drawX(Canvas canvas, Paint paint, float x, float y) {
        canvas.drawLine(x - this.size, y - this.size, x + this.size, y + this.size, paint);
        canvas.drawLine(x + this.size, y - this.size, x - this.size, y + this.size, paint);
    }

    private void drawCircle(Canvas canvas, Paint paint, float x, float y) {
        canvas.drawCircle(x, y, this.size, paint);
    }

    private void drawTriangle(Canvas canvas, Paint paint, float[] path, float x, float y) {
        path[0] = x;
        path[1] = (y - this.size) - (this.size / 2.0f);
        path[2] = x - this.size;
        path[3] = this.size + y;
        path[4] = this.size + x;
        path[5] = path[3];
        drawPath(canvas, path, paint, true);
    }

    private void drawSquare(Canvas canvas, Paint paint, float x, float y) {
        canvas.drawRect(x - this.size, y - this.size, x + this.size, y + this.size, paint);
    }

    private void drawDiamond(Canvas canvas, Paint paint, float[] path, float x, float y) {
        path[0] = x;
        path[1] = y - this.size;
        path[2] = x - this.size;
        path[3] = y;
        path[4] = x;
        path[5] = this.size + y;
        path[6] = this.size + x;
        path[7] = y;
        drawPath(canvas, path, paint, true);
    }

    public String getChartType() {
        return TYPE;
    }
}
