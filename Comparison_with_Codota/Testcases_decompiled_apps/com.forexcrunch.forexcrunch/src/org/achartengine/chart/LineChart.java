package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class LineChart extends XYChart {
    private static final int SHAPE_WIDTH = 30;
    public static final String TYPE = "Line";
    private ScatterChart pointsChart;

    LineChart() {
    }

    public LineChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        super(dataset, renderer);
        this.pointsChart = new ScatterChart(dataset, renderer);
    }

    /* access modifiers changed from: protected */
    public void setDatasetRenderer(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        super.setDatasetRenderer(dataset, renderer);
        this.pointsChart = new ScatterChart(dataset, renderer);
    }

    public void drawSeries(Canvas canvas, Paint paint, List<Float> points, SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, int startIndex) {
        float referencePoint;
        XYSeriesRenderer renderer = (XYSeriesRenderer) seriesRenderer;
        float lineWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(renderer.getLineWidth());
        for (XYSeriesRenderer.FillOutsideLine fill : renderer.getFillOutsideLine()) {
            if (fill.getType() != XYSeriesRenderer.FillOutsideLine.Type.NONE) {
                paint.setColor(fill.getColor());
                List<Float> fillPoints = new ArrayList<>();
                int[] range = fill.getFillRange();
                if (range == null) {
                    fillPoints.addAll(points);
                } else {
                    fillPoints.addAll(points.subList(range[0] * 2, range[1] * 2));
                }
                switch (fill.getType()) {
                    case BOUNDS_ALL:
                        referencePoint = yAxisValue;
                        break;
                    case BOUNDS_BELOW:
                        referencePoint = yAxisValue;
                        break;
                    case BOUNDS_ABOVE:
                        referencePoint = yAxisValue;
                        break;
                    case BELOW:
                        referencePoint = (float) canvas.getHeight();
                        break;
                    case ABOVE:
                        referencePoint = BitmapDescriptorFactory.HUE_RED;
                        break;
                    default:
                        throw new RuntimeException("You have added a new type of filling but have not implemented.");
                }
                if (fill.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE || fill.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW) {
                    List<Float> boundsPoints = new ArrayList<>();
                    boolean add = false;
                    if ((fill.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE && fillPoints.get(1).floatValue() < referencePoint) || (fill.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW && fillPoints.get(1).floatValue() > referencePoint)) {
                        boundsPoints.add(fillPoints.get(0));
                        boundsPoints.add(fillPoints.get(1));
                        add = true;
                    }
                    int i = 3;
                    while (i < fillPoints.size()) {
                        float prevValue = fillPoints.get(i - 2).floatValue();
                        float value = fillPoints.get(i).floatValue();
                        if ((prevValue < referencePoint && value > referencePoint) || (prevValue > referencePoint && value < referencePoint)) {
                            float prevX = fillPoints.get(i - 3).floatValue();
                            float x = fillPoints.get(i - 1).floatValue();
                            boundsPoints.add(Float.valueOf((((x - prevX) * (referencePoint - prevValue)) / (value - prevValue)) + prevX));
                            boundsPoints.add(Float.valueOf(referencePoint));
                            if ((fill.getType() != XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE || value <= referencePoint) && (fill.getType() != XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW || value >= referencePoint)) {
                                boundsPoints.add(Float.valueOf(x));
                                boundsPoints.add(Float.valueOf(value));
                                add = true;
                            } else {
                                i += 2;
                                add = false;
                            }
                        } else if (add || ((fill.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE && value < referencePoint) || (fill.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW && value > referencePoint))) {
                            boundsPoints.add(fillPoints.get(i - 1));
                            boundsPoints.add(Float.valueOf(value));
                        }
                        i += 2;
                    }
                    fillPoints.clear();
                    fillPoints.addAll(boundsPoints);
                }
                int length = fillPoints.size();
                fillPoints.set(0, Float.valueOf(fillPoints.get(0).floatValue() + 1.0f));
                fillPoints.add(fillPoints.get(length - 2));
                fillPoints.add(Float.valueOf(referencePoint));
                fillPoints.add(fillPoints.get(0));
                fillPoints.add(fillPoints.get(length + 1));
                for (int i2 = 0; i2 < length + 4; i2 += 2) {
                    if (fillPoints.get(i2 + 1).floatValue() < BitmapDescriptorFactory.HUE_RED) {
                        fillPoints.set(i2 + 1, Float.valueOf(BitmapDescriptorFactory.HUE_RED));
                    }
                }
                paint.setStyle(Paint.Style.FILL);
                drawPath(canvas, fillPoints, paint, true);
            }
        }
        paint.setColor(seriesRenderer.getColor());
        paint.setStyle(Paint.Style.STROKE);
        drawPath(canvas, points, paint, false);
        paint.setStrokeWidth(lineWidth);
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
        return 30;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y, int seriesIndex, Paint paint) {
        canvas.drawLine(x, y, x + 30.0f, y, paint);
        if (isRenderPoints(renderer)) {
            this.pointsChart.drawLegendShape(canvas, renderer, x + 5.0f, y, seriesIndex, paint);
        }
    }

    public boolean isRenderPoints(SimpleSeriesRenderer renderer) {
        return ((XYSeriesRenderer) renderer).getPointStyle() != PointStyle.POINT;
    }

    public ScatterChart getPointsChart() {
        return this.pointsChart;
    }

    public String getChartType() {
        return TYPE;
    }
}
