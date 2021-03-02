package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.BasicStroke;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.util.MathHelper;

public abstract class XYChart extends AbstractChart {
    private Map<Integer, List<ClickableArea>> clickableAreas = new HashMap();
    private final Map<Integer, double[]> mCalcRange = new HashMap();
    private Point mCenter;
    protected XYMultipleSeriesDataset mDataset;
    protected XYMultipleSeriesRenderer mRenderer;
    private float mScale;
    private Rect mScreenR;
    private float mTranslate;

    /* access modifiers changed from: protected */
    public abstract ClickableArea[] clickableAreasForPoints(List<Float> list, List<Double> list2, float f, int i, int i2);

    public abstract void drawSeries(Canvas canvas, Paint paint, List<Float> list, SimpleSeriesRenderer simpleSeriesRenderer, float f, int i, int i2);

    public abstract String getChartType();

    protected XYChart() {
    }

    public XYChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        this.mDataset = dataset;
        this.mRenderer = renderer;
    }

    /* access modifiers changed from: protected */
    public void setDatasetRenderer(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        this.mDataset = dataset;
        this.mRenderer = renderer;
    }

    public void draw(Canvas canvas, int x, int y, int width, int height, Paint paint) {
        paint.setAntiAlias(this.mRenderer.isAntialiasing());
        int legendSize = getLegendSize(this.mRenderer, height / 5, this.mRenderer.getAxisTitleTextSize());
        int[] margins = this.mRenderer.getMargins();
        int left = x + margins[1];
        int top = y + margins[0];
        int right = (x + width) - margins[3];
        int sLength = this.mDataset.getSeriesCount();
        String[] titles = new String[sLength];
        for (int i = 0; i < sLength; i++) {
            titles[i] = this.mDataset.getSeriesAt(i).getTitle();
        }
        if (this.mRenderer.isFitLegend() && this.mRenderer.isShowLegend()) {
            legendSize = drawLegend(canvas, this.mRenderer, titles, left, right, y, width, height, legendSize, paint, true);
        }
        int bottom = ((y + height) - margins[2]) - legendSize;
        if (this.mScreenR == null) {
            this.mScreenR = new Rect();
        }
        this.mScreenR.set(left, top, right, bottom);
        drawBackground(this.mRenderer, canvas, x, y, width, height, paint, false, 0);
        if (paint.getTypeface() == null || ((this.mRenderer.getTextTypeface() != null && paint.getTypeface().equals(this.mRenderer.getTextTypeface())) || !paint.getTypeface().toString().equals(this.mRenderer.getTextTypefaceName()) || paint.getTypeface().getStyle() != this.mRenderer.getTextTypefaceStyle())) {
            if (this.mRenderer.getTextTypeface() != null) {
                paint.setTypeface(this.mRenderer.getTextTypeface());
            } else {
                paint.setTypeface(Typeface.create(this.mRenderer.getTextTypefaceName(), this.mRenderer.getTextTypefaceStyle()));
            }
        }
        XYMultipleSeriesRenderer.Orientation or = this.mRenderer.getOrientation();
        if (or == XYMultipleSeriesRenderer.Orientation.VERTICAL) {
            right -= legendSize;
            bottom += legendSize - 20;
        }
        int angle = or.getAngle();
        boolean rotate = angle == 90;
        this.mScale = ((float) height) / ((float) width);
        this.mTranslate = (float) (Math.abs(width - height) / 2);
        if (this.mScale < 1.0f) {
            this.mTranslate *= -1.0f;
        }
        this.mCenter = new Point((float) ((x + width) / 2), (float) ((y + height) / 2));
        if (rotate) {
            transform(canvas, (float) angle, false);
        }
        int maxScaleNumber = -2147483647;
        for (int i2 = 0; i2 < sLength; i2++) {
            maxScaleNumber = Math.max(maxScaleNumber, this.mDataset.getSeriesAt(i2).getScaleNumber());
        }
        int maxScaleNumber2 = maxScaleNumber + 1;
        if (maxScaleNumber2 >= 0) {
            double[] minX = new double[maxScaleNumber2];
            double[] maxX = new double[maxScaleNumber2];
            double[] minY = new double[maxScaleNumber2];
            double[] maxY = new double[maxScaleNumber2];
            boolean[] isMinXSet = new boolean[maxScaleNumber2];
            boolean[] isMaxXSet = new boolean[maxScaleNumber2];
            boolean[] isMinYSet = new boolean[maxScaleNumber2];
            boolean[] isMaxYSet = new boolean[maxScaleNumber2];
            for (int i3 = 0; i3 < maxScaleNumber2; i3++) {
                minX[i3] = this.mRenderer.getXAxisMin(i3);
                maxX[i3] = this.mRenderer.getXAxisMax(i3);
                minY[i3] = this.mRenderer.getYAxisMin(i3);
                maxY[i3] = this.mRenderer.getYAxisMax(i3);
                isMinXSet[i3] = this.mRenderer.isMinXSet(i3);
                isMaxXSet[i3] = this.mRenderer.isMaxXSet(i3);
                isMinYSet[i3] = this.mRenderer.isMinYSet(i3);
                isMaxYSet[i3] = this.mRenderer.isMaxYSet(i3);
                if (this.mCalcRange.get(Integer.valueOf(i3)) == null) {
                    this.mCalcRange.put(Integer.valueOf(i3), new double[4]);
                }
            }
            double[] xPixelsPerUnit = new double[maxScaleNumber2];
            double[] yPixelsPerUnit = new double[maxScaleNumber2];
            for (int i4 = 0; i4 < sLength; i4++) {
                XYSeries series = this.mDataset.getSeriesAt(i4);
                int scale = series.getScaleNumber();
                if (series.getItemCount() != 0) {
                    if (!isMinXSet[scale]) {
                        minX[scale] = Math.min(minX[scale], series.getMinX());
                        this.mCalcRange.get(Integer.valueOf(scale))[0] = minX[scale];
                    }
                    if (!isMaxXSet[scale]) {
                        maxX[scale] = Math.max(maxX[scale], series.getMaxX());
                        this.mCalcRange.get(Integer.valueOf(scale))[1] = maxX[scale];
                    }
                    if (!isMinYSet[scale]) {
                        minY[scale] = Math.min(minY[scale], (double) ((float) series.getMinY()));
                        this.mCalcRange.get(Integer.valueOf(scale))[2] = minY[scale];
                    }
                    if (!isMaxYSet[scale]) {
                        maxY[scale] = Math.max(maxY[scale], (double) ((float) series.getMaxY()));
                        this.mCalcRange.get(Integer.valueOf(scale))[3] = maxY[scale];
                    }
                }
            }
            for (int i5 = 0; i5 < maxScaleNumber2; i5++) {
                if (maxX[i5] - minX[i5] != 0.0d) {
                    xPixelsPerUnit[i5] = ((double) (right - left)) / (maxX[i5] - minX[i5]);
                }
                if (maxY[i5] - minY[i5] != 0.0d) {
                    yPixelsPerUnit[i5] = (double) ((float) (((double) (bottom - top)) / (maxY[i5] - minY[i5])));
                }
            }
            boolean hasValues = false;
            this.clickableAreas = new HashMap();
            for (int i6 = 0; i6 < sLength; i6++) {
                XYSeries series2 = this.mDataset.getSeriesAt(i6);
                int scale2 = series2.getScaleNumber();
                if (series2.getItemCount() != 0) {
                    hasValues = true;
                    SimpleSeriesRenderer seriesRenderer = this.mRenderer.getSeriesRendererAt(i6);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    float yAxisValue = Math.min((float) bottom, (float) (((double) bottom) + (yPixelsPerUnit[scale2] * minY[scale2])));
                    LinkedList<ClickableArea> clickableArea = new LinkedList<>();
                    this.clickableAreas.put(Integer.valueOf(i6), clickableArea);
                    synchronized (series2) {
                        int startIndex = -1;
                        for (Map.Entry<Double, Double> value : series2.getRange(minX[scale2], maxX[scale2], seriesRenderer.isDisplayBoundingPoints()).entrySet()) {
                            double xValue = value.getKey().doubleValue();
                            double yValue = value.getValue().doubleValue();
                            if (startIndex < 0 && (!isNullValue(yValue) || isRenderNullValues())) {
                                startIndex = series2.getIndexForKey(xValue);
                            }
                            arrayList2.add(value.getKey());
                            arrayList2.add(value.getValue());
                            if (!isNullValue(yValue)) {
                                arrayList.add(Float.valueOf((float) (((double) left) + (xPixelsPerUnit[scale2] * (xValue - minX[scale2])))));
                                arrayList.add(Float.valueOf((float) (((double) bottom) - (yPixelsPerUnit[scale2] * (yValue - minY[scale2])))));
                            } else if (isRenderNullValues()) {
                                arrayList.add(Float.valueOf((float) (((double) left) + (xPixelsPerUnit[scale2] * (xValue - minX[scale2])))));
                                arrayList.add(Float.valueOf((float) (((double) bottom) - (yPixelsPerUnit[scale2] * (-minY[scale2])))));
                            } else {
                                if (arrayList.size() > 0) {
                                    drawSeries(series2, canvas, paint, arrayList, seriesRenderer, yAxisValue, i6, or, startIndex);
                                    clickableArea.addAll(Arrays.asList(clickableAreasForPoints(arrayList, arrayList2, yAxisValue, i6, startIndex)));
                                    arrayList.clear();
                                    arrayList2.clear();
                                    startIndex = -1;
                                }
                                clickableArea.add((Object) null);
                            }
                        }
                        int count = series2.getAnnotationCount();
                        if (count > 0) {
                            paint.setColor(this.mRenderer.getLabelsColor());
                            Rect bound = new Rect();
                            for (int j = 0; j < count; j++) {
                                float xS = (float) (((double) left) + (xPixelsPerUnit[scale2] * (series2.getAnnotationX(j) - minX[scale2])));
                                float yS = (float) (((double) bottom) - (yPixelsPerUnit[scale2] * (series2.getAnnotationY(j) - minY[scale2])));
                                paint.getTextBounds(series2.getAnnotationAt(j), 0, series2.getAnnotationAt(j).length(), bound);
                                if (xS < ((float) bound.width()) + xS && yS < ((float) canvas.getHeight())) {
                                    drawString(canvas, series2.getAnnotationAt(j), xS, yS, paint);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            drawSeries(series2, canvas, paint, arrayList, seriesRenderer, yAxisValue, i6, or, startIndex);
                            clickableArea.addAll(Arrays.asList(clickableAreasForPoints(arrayList, arrayList2, yAxisValue, i6, startIndex)));
                        }
                    }
                }
            }
            drawBackground(this.mRenderer, canvas, x, bottom, width, height - bottom, paint, true, this.mRenderer.getMarginsColor());
            drawBackground(this.mRenderer, canvas, x, y, width, margins[0], paint, true, this.mRenderer.getMarginsColor());
            if (or == XYMultipleSeriesRenderer.Orientation.HORIZONTAL) {
                drawBackground(this.mRenderer, canvas, x, y, left - x, height - y, paint, true, this.mRenderer.getMarginsColor());
                drawBackground(this.mRenderer, canvas, right, y, margins[3], height - y, paint, true, this.mRenderer.getMarginsColor());
            } else if (or == XYMultipleSeriesRenderer.Orientation.VERTICAL) {
                drawBackground(this.mRenderer, canvas, right, y, width - right, height - y, paint, true, this.mRenderer.getMarginsColor());
                drawBackground(this.mRenderer, canvas, x, y, left - x, height - y, paint, true, this.mRenderer.getMarginsColor());
            }
            boolean showLabels = this.mRenderer.isShowLabels() && hasValues;
            boolean showGridX = this.mRenderer.isShowGridX();
            boolean showCustomTextGrid = this.mRenderer.isShowCustomTextGrid();
            if (showLabels || showGridX) {
                List<Double> xLabels = getValidLabels(getXLabels(minX[0], maxX[0], this.mRenderer.getXLabels()));
                Map<Integer, List<Double>> allYLabels = getYLabels(minY, maxY, maxScaleNumber2);
                int xLabelsLeft = left;
                if (showLabels) {
                    paint.setColor(this.mRenderer.getXLabelsColor());
                    paint.setTextSize(this.mRenderer.getLabelsTextSize());
                    paint.setTextAlign(this.mRenderer.getXLabelsAlign());
                }
                drawXLabels(xLabels, this.mRenderer.getXTextLabelLocations(), canvas, paint, xLabelsLeft, top, bottom, xPixelsPerUnit[0], minX[0], maxX[0]);
                drawYLabels(allYLabels, canvas, paint, maxScaleNumber2, left, right, bottom, yPixelsPerUnit, minY);
                if (showLabels) {
                    paint.setColor(this.mRenderer.getLabelsColor());
                    for (int i7 = 0; i7 < maxScaleNumber2; i7++) {
                        Paint.Align axisAlign = this.mRenderer.getYAxisAlign(i7);
                        Double[] arr$ = this.mRenderer.getYTextLabelLocations(i7);
                        int len$ = arr$.length;
                        for (int i$ = 0; i$ < len$; i$++) {
                            Double location = arr$[i$];
                            if (minY[i7] <= location.doubleValue() && location.doubleValue() <= maxY[i7]) {
                                float yLabel = (float) (((double) bottom) - (yPixelsPerUnit[i7] * (location.doubleValue() - minY[i7])));
                                String label = this.mRenderer.getYTextLabel(location, i7);
                                paint.setColor(this.mRenderer.getYLabelsColor(i7));
                                paint.setTextAlign(this.mRenderer.getYLabelsAlign(i7));
                                if (or == XYMultipleSeriesRenderer.Orientation.HORIZONTAL) {
                                    if (axisAlign == Paint.Align.LEFT) {
                                        canvas.drawLine((float) (getLabelLinePos(axisAlign) + left), yLabel, (float) left, yLabel, paint);
                                        drawText(canvas, label, (float) left, yLabel - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                                    } else {
                                        canvas.drawLine((float) right, yLabel, (float) (getLabelLinePos(axisAlign) + right), yLabel, paint);
                                        drawText(canvas, label, (float) right, yLabel - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                                    }
                                    if (showCustomTextGrid) {
                                        paint.setColor(this.mRenderer.getGridColor());
                                        canvas.drawLine((float) left, yLabel, (float) right, yLabel, paint);
                                    }
                                } else {
                                    canvas.drawLine((float) (right - getLabelLinePos(axisAlign)), yLabel, (float) right, yLabel, paint);
                                    drawText(canvas, label, (float) (right + 10), yLabel - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                                    if (showCustomTextGrid) {
                                        paint.setColor(this.mRenderer.getGridColor());
                                        canvas.drawLine((float) right, yLabel, (float) left, yLabel, paint);
                                    }
                                }
                            }
                        }
                    }
                }
                if (showLabels) {
                    paint.setColor(this.mRenderer.getLabelsColor());
                    float size = this.mRenderer.getAxisTitleTextSize();
                    paint.setTextSize(size);
                    paint.setTextAlign(Paint.Align.CENTER);
                    if (or == XYMultipleSeriesRenderer.Orientation.HORIZONTAL) {
                        drawText(canvas, this.mRenderer.getXTitle(), (float) ((width / 2) + x), ((float) bottom) + ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + this.mRenderer.getXLabelsPadding() + size, paint, BitmapDescriptorFactory.HUE_RED);
                        for (int i8 = 0; i8 < maxScaleNumber2; i8++) {
                            if (this.mRenderer.getYAxisAlign(i8) == Paint.Align.LEFT) {
                                drawText(canvas, this.mRenderer.getYTitle(i8), ((float) x) + size, (float) ((height / 2) + y), paint, -90.0f);
                            } else {
                                drawText(canvas, this.mRenderer.getYTitle(i8), (float) (x + width), (float) ((height / 2) + y), paint, -90.0f);
                            }
                        }
                        paint.setTextSize(this.mRenderer.getChartTitleTextSize());
                        drawText(canvas, this.mRenderer.getChartTitle(), (float) ((width / 2) + x), ((float) y) + this.mRenderer.getChartTitleTextSize(), paint, BitmapDescriptorFactory.HUE_RED);
                    } else if (or == XYMultipleSeriesRenderer.Orientation.VERTICAL) {
                        drawText(canvas, this.mRenderer.getXTitle(), (float) ((width / 2) + x), (((float) (y + height)) - size) + this.mRenderer.getXLabelsPadding(), paint, -90.0f);
                        drawText(canvas, this.mRenderer.getYTitle(), (float) (right + 20), (float) ((height / 2) + y), paint, BitmapDescriptorFactory.HUE_RED);
                        paint.setTextSize(this.mRenderer.getChartTitleTextSize());
                        drawText(canvas, this.mRenderer.getChartTitle(), ((float) x) + size, (float) ((height / 2) + top), paint, BitmapDescriptorFactory.HUE_RED);
                    }
                }
            }
            if (or == XYMultipleSeriesRenderer.Orientation.HORIZONTAL) {
                drawLegend(canvas, this.mRenderer, titles, left, right, y + ((int) this.mRenderer.getXLabelsPadding()), width, height, legendSize, paint, false);
            } else if (or == XYMultipleSeriesRenderer.Orientation.VERTICAL) {
                transform(canvas, (float) angle, true);
                drawLegend(canvas, this.mRenderer, titles, left, right, y + ((int) this.mRenderer.getXLabelsPadding()), width, height, legendSize, paint, false);
                transform(canvas, (float) angle, false);
            }
            if (this.mRenderer.isShowAxes()) {
                paint.setColor(this.mRenderer.getAxesColor());
                canvas.drawLine((float) left, (float) bottom, (float) right, (float) bottom, paint);
                boolean rightAxis = false;
                for (int i9 = 0; i9 < maxScaleNumber2 && !rightAxis; i9++) {
                    rightAxis = this.mRenderer.getYAxisAlign(i9) == Paint.Align.RIGHT;
                }
                if (or == XYMultipleSeriesRenderer.Orientation.HORIZONTAL) {
                    canvas.drawLine((float) left, (float) top, (float) left, (float) bottom, paint);
                    if (rightAxis) {
                        canvas.drawLine((float) right, (float) top, (float) right, (float) bottom, paint);
                    }
                } else if (or == XYMultipleSeriesRenderer.Orientation.VERTICAL) {
                    canvas.drawLine((float) right, (float) top, (float) right, (float) bottom, paint);
                }
            }
            if (rotate) {
                transform(canvas, (float) angle, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<Double> getXLabels(double min, double max, int count) {
        return MathHelper.getLabels(min, max, count);
    }

    /* access modifiers changed from: protected */
    public Map<Integer, List<Double>> getYLabels(double[] minY, double[] maxY, int maxScaleNumber) {
        Map<Integer, List<Double>> allYLabels = new HashMap<>();
        for (int i = 0; i < maxScaleNumber; i++) {
            allYLabels.put(Integer.valueOf(i), getValidLabels(MathHelper.getLabels(minY[i], maxY[i], this.mRenderer.getYLabels())));
        }
        return allYLabels;
    }

    /* access modifiers changed from: protected */
    public Rect getScreenR() {
        return this.mScreenR;
    }

    /* access modifiers changed from: protected */
    public void setScreenR(Rect screenR) {
        this.mScreenR = screenR;
    }

    private List<Double> getValidLabels(List<Double> labels) {
        List<Double> result = new ArrayList<>(labels);
        for (Double label : labels) {
            if (label.isNaN()) {
                result.remove(label);
            }
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public void drawSeries(XYSeries series, Canvas canvas, Paint paint, List<Float> pointsList, SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, XYMultipleSeriesRenderer.Orientation or, int startIndex) {
        ScatterChart pointsChart;
        BasicStroke stroke = seriesRenderer.getStroke();
        Paint.Cap cap = paint.getStrokeCap();
        Paint.Join join = paint.getStrokeJoin();
        float miter = paint.getStrokeMiter();
        PathEffect pathEffect = paint.getPathEffect();
        Paint.Style style = paint.getStyle();
        if (stroke != null) {
            PathEffect effect = null;
            if (stroke.getIntervals() != null) {
                effect = new DashPathEffect(stroke.getIntervals(), stroke.getPhase());
            }
            setStroke(stroke.getCap(), stroke.getJoin(), stroke.getMiter(), Paint.Style.FILL_AND_STROKE, effect, paint);
        }
        drawSeries(canvas, paint, pointsList, seriesRenderer, yAxisValue, seriesIndex, startIndex);
        if (isRenderPoints(seriesRenderer) && (pointsChart = getPointsChart()) != null) {
            pointsChart.drawSeries(canvas, paint, pointsList, seriesRenderer, yAxisValue, seriesIndex, startIndex);
        }
        paint.setTextSize(seriesRenderer.getChartValuesTextSize());
        if (or == XYMultipleSeriesRenderer.Orientation.HORIZONTAL) {
            paint.setTextAlign(Paint.Align.CENTER);
        } else {
            paint.setTextAlign(Paint.Align.LEFT);
        }
        if (seriesRenderer.isDisplayChartValues()) {
            paint.setTextAlign(seriesRenderer.getChartValuesTextAlign());
            drawChartValuesText(canvas, series, seriesRenderer, paint, pointsList, seriesIndex, startIndex);
        }
        if (stroke != null) {
            setStroke(cap, join, miter, style, pathEffect, paint);
        }
    }

    private void setStroke(Paint.Cap cap, Paint.Join join, float miter, Paint.Style style, PathEffect pathEffect, Paint paint) {
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(miter);
        paint.setPathEffect(pathEffect);
        paint.setStyle(style);
    }

    /* access modifiers changed from: protected */
    public void drawChartValuesText(Canvas canvas, XYSeries series, SimpleSeriesRenderer renderer, Paint paint, List<Float> points, int seriesIndex, int startIndex) {
        if (points.size() > 1) {
            float previousPointX = points.get(0).floatValue();
            float previousPointY = points.get(1).floatValue();
            for (int k = 0; k < points.size(); k += 2) {
                if (k == 2) {
                    if (Math.abs(points.get(2).floatValue() - points.get(0).floatValue()) > ((float) renderer.getDisplayChartValuesDistance()) || Math.abs(points.get(3).floatValue() - points.get(1).floatValue()) > ((float) renderer.getDisplayChartValuesDistance())) {
                        drawText(canvas, getLabel(renderer.getChartValuesFormat(), series.getY(startIndex)), points.get(0).floatValue(), points.get(1).floatValue() - renderer.getChartValuesSpacing(), paint, BitmapDescriptorFactory.HUE_RED);
                        drawText(canvas, getLabel(renderer.getChartValuesFormat(), series.getY(startIndex + 1)), points.get(2).floatValue(), points.get(3).floatValue() - renderer.getChartValuesSpacing(), paint, BitmapDescriptorFactory.HUE_RED);
                        previousPointX = points.get(2).floatValue();
                        previousPointY = points.get(3).floatValue();
                    }
                } else if (k > 2) {
                    if (Math.abs(points.get(k).floatValue() - previousPointX) <= ((float) renderer.getDisplayChartValuesDistance())) {
                        if (Math.abs(points.get(k + 1).floatValue() - previousPointY) <= ((float) renderer.getDisplayChartValuesDistance())) {
                        }
                    }
                    drawText(canvas, getLabel(renderer.getChartValuesFormat(), series.getY((k / 2) + startIndex)), points.get(k).floatValue(), points.get(k + 1).floatValue() - renderer.getChartValuesSpacing(), paint, BitmapDescriptorFactory.HUE_RED);
                    previousPointX = points.get(k).floatValue();
                    previousPointY = points.get(k + 1).floatValue();
                }
            }
            return;
        }
        for (int k2 = 0; k2 < points.size(); k2 += 2) {
            drawText(canvas, getLabel(renderer.getChartValuesFormat(), series.getY((k2 / 2) + startIndex)), points.get(k2).floatValue(), points.get(k2 + 1).floatValue() - renderer.getChartValuesSpacing(), paint, BitmapDescriptorFactory.HUE_RED);
        }
    }

    /* access modifiers changed from: protected */
    public void drawText(Canvas canvas, String text, float x, float y, Paint paint, float extraAngle) {
        float angle = ((float) (-this.mRenderer.getOrientation().getAngle())) + extraAngle;
        if (angle != BitmapDescriptorFactory.HUE_RED) {
            canvas.rotate(angle, x, y);
        }
        drawString(canvas, text, x, y, paint);
        if (angle != BitmapDescriptorFactory.HUE_RED) {
            canvas.rotate(-angle, x, y);
        }
    }

    private void transform(Canvas canvas, float angle, boolean inverse) {
        if (inverse) {
            canvas.scale(1.0f / this.mScale, this.mScale);
            canvas.translate(this.mTranslate, -this.mTranslate);
            canvas.rotate(-angle, this.mCenter.getX(), this.mCenter.getY());
            return;
        }
        canvas.rotate(angle, this.mCenter.getX(), this.mCenter.getY());
        canvas.translate(-this.mTranslate, this.mTranslate);
        canvas.scale(this.mScale, 1.0f / this.mScale);
    }

    /* access modifiers changed from: protected */
    public void drawXLabels(List<Double> xLabels, Double[] xTextLabelLocations, Canvas canvas, Paint paint, int left, int top, int bottom, double xPixelsPerUnit, double minX, double maxX) {
        int length = xLabels.size();
        boolean showLabels = this.mRenderer.isShowLabels();
        boolean showGridY = this.mRenderer.isShowGridY();
        for (int i = 0; i < length; i++) {
            double label = xLabels.get(i).doubleValue();
            float xLabel = (float) (((double) left) + ((label - minX) * xPixelsPerUnit));
            if (showLabels) {
                paint.setColor(this.mRenderer.getXLabelsColor());
                canvas.drawLine(xLabel, (float) bottom, xLabel, ((float) bottom) + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                Canvas canvas2 = canvas;
                float f = xLabel;
                Paint paint2 = paint;
                drawText(canvas2, getLabel(this.mRenderer.getLabelFormat(), label), f, ((float) bottom) + ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + this.mRenderer.getXLabelsPadding(), paint2, this.mRenderer.getXLabelsAngle());
            }
            if (showGridY) {
                paint.setColor(this.mRenderer.getGridColor());
                canvas.drawLine(xLabel, (float) bottom, xLabel, (float) top, paint);
            }
        }
        drawXTextLabels(xTextLabelLocations, canvas, paint, showLabels, left, top, bottom, xPixelsPerUnit, minX, maxX);
    }

    /* access modifiers changed from: protected */
    public void drawYLabels(Map<Integer, List<Double>> allYLabels, Canvas canvas, Paint paint, int maxScaleNumber, int left, int right, int bottom, double[] yPixelsPerUnit, double[] minY) {
        XYMultipleSeriesRenderer.Orientation or = this.mRenderer.getOrientation();
        boolean showGridX = this.mRenderer.isShowGridX();
        boolean showLabels = this.mRenderer.isShowLabels();
        for (int i = 0; i < maxScaleNumber; i++) {
            paint.setTextAlign(this.mRenderer.getYLabelsAlign(i));
            List<Double> yLabels = allYLabels.get(Integer.valueOf(i));
            int length = yLabels.size();
            for (int j = 0; j < length; j++) {
                double label = yLabels.get(j).doubleValue();
                Paint.Align axisAlign = this.mRenderer.getYAxisAlign(i);
                boolean textLabel = this.mRenderer.getYTextLabel(Double.valueOf(label), i) != null;
                float yLabel = (float) (((double) bottom) - (yPixelsPerUnit[i] * (label - minY[i])));
                if (or == XYMultipleSeriesRenderer.Orientation.HORIZONTAL) {
                    if (showLabels && !textLabel) {
                        paint.setColor(this.mRenderer.getYLabelsColor(i));
                        if (axisAlign == Paint.Align.LEFT) {
                            canvas.drawLine((float) (getLabelLinePos(axisAlign) + left), yLabel, (float) left, yLabel, paint);
                            drawText(canvas, getLabel(this.mRenderer.getLabelFormat(), label), ((float) left) - this.mRenderer.getYLabelsPadding(), yLabel - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                        } else {
                            canvas.drawLine((float) right, yLabel, (float) (getLabelLinePos(axisAlign) + right), yLabel, paint);
                            drawText(canvas, getLabel(this.mRenderer.getLabelFormat(), label), ((float) right) + this.mRenderer.getYLabelsPadding(), yLabel - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                        }
                    }
                    if (showGridX) {
                        paint.setColor(this.mRenderer.getGridColor());
                        canvas.drawLine((float) left, yLabel, (float) right, yLabel, paint);
                    }
                } else if (or == XYMultipleSeriesRenderer.Orientation.VERTICAL) {
                    if (showLabels && !textLabel) {
                        paint.setColor(this.mRenderer.getYLabelsColor(i));
                        canvas.drawLine((float) (right - getLabelLinePos(axisAlign)), yLabel, (float) right, yLabel, paint);
                        drawText(canvas, getLabel(this.mRenderer.getLabelFormat(), label), ((float) (right + 10)) + this.mRenderer.getYLabelsPadding(), yLabel - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                    }
                    if (showGridX) {
                        paint.setColor(this.mRenderer.getGridColor());
                        canvas.drawLine((float) right, yLabel, (float) left, yLabel, paint);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawXTextLabels(Double[] xTextLabelLocations, Canvas canvas, Paint paint, boolean showLabels, int left, int top, int bottom, double xPixelsPerUnit, double minX, double maxX) {
        boolean showCustomTextGrid = this.mRenderer.isShowCustomTextGrid();
        if (showLabels) {
            paint.setColor(this.mRenderer.getXLabelsColor());
            for (Double location : xTextLabelLocations) {
                if (minX <= location.doubleValue() && location.doubleValue() <= maxX) {
                    float xLabel = (float) (((double) left) + ((location.doubleValue() - minX) * xPixelsPerUnit));
                    paint.setColor(this.mRenderer.getXLabelsColor());
                    canvas.drawLine(xLabel, (float) bottom, xLabel, ((float) bottom) + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                    drawText(canvas, this.mRenderer.getXTextLabel(location), xLabel, ((float) bottom) + ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f), paint, this.mRenderer.getXLabelsAngle());
                    if (showCustomTextGrid) {
                        paint.setColor(this.mRenderer.getGridColor());
                        canvas.drawLine(xLabel, (float) bottom, xLabel, (float) top, paint);
                    }
                }
            }
        }
    }

    public XYMultipleSeriesRenderer getRenderer() {
        return this.mRenderer;
    }

    public XYMultipleSeriesDataset getDataset() {
        return this.mDataset;
    }

    public double[] getCalcRange(int scale) {
        return this.mCalcRange.get(Integer.valueOf(scale));
    }

    public void setCalcRange(double[] range, int scale) {
        this.mCalcRange.put(Integer.valueOf(scale), range);
    }

    public double[] toRealPoint(float screenX, float screenY) {
        return toRealPoint(screenX, screenY, 0);
    }

    public double[] toScreenPoint(double[] realPoint) {
        return toScreenPoint(realPoint, 0);
    }

    private int getLabelLinePos(Paint.Align align) {
        if (align == Paint.Align.LEFT) {
            return -4;
        }
        return 4;
    }

    public double[] toRealPoint(float screenX, float screenY, int scale) {
        double realMinX = this.mRenderer.getXAxisMin(scale);
        double realMaxX = this.mRenderer.getXAxisMax(scale);
        double realMinY = this.mRenderer.getYAxisMin(scale);
        double realMaxY = this.mRenderer.getYAxisMax(scale);
        if (this.mScreenR != null) {
            return new double[]{((((double) (screenX - ((float) this.mScreenR.left))) * (realMaxX - realMinX)) / ((double) this.mScreenR.width())) + realMinX, ((((double) (((float) (this.mScreenR.top + this.mScreenR.height())) - screenY)) * (realMaxY - realMinY)) / ((double) this.mScreenR.height())) + realMinY};
        }
        return new double[]{(double) screenX, (double) screenY};
    }

    public double[] toScreenPoint(double[] realPoint, int scale) {
        double realMinX = this.mRenderer.getXAxisMin(scale);
        double realMaxX = this.mRenderer.getXAxisMax(scale);
        double realMinY = this.mRenderer.getYAxisMin(scale);
        double realMaxY = this.mRenderer.getYAxisMax(scale);
        if (!this.mRenderer.isMinXSet(scale) || !this.mRenderer.isMaxXSet(scale) || !this.mRenderer.isMinXSet(scale) || !this.mRenderer.isMaxYSet(scale)) {
            double[] calcRange = getCalcRange(scale);
            realMinX = calcRange[0];
            realMaxX = calcRange[1];
            realMinY = calcRange[2];
            realMaxY = calcRange[3];
        }
        if (this.mScreenR == null) {
            return realPoint;
        }
        return new double[]{(((realPoint[0] - realMinX) * ((double) this.mScreenR.width())) / (realMaxX - realMinX)) + ((double) this.mScreenR.left), (((realMaxY - realPoint[1]) * ((double) this.mScreenR.height())) / (realMaxY - realMinY)) + ((double) this.mScreenR.top)};
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point screenPoint) {
        RectF rectangle;
        if (this.clickableAreas != null) {
            for (int seriesIndex = this.clickableAreas.size() - 1; seriesIndex >= 0; seriesIndex--) {
                int pointIndex = 0;
                if (this.clickableAreas.get(Integer.valueOf(seriesIndex)) != null) {
                    for (ClickableArea area : this.clickableAreas.get(Integer.valueOf(seriesIndex))) {
                        if (area != null && (rectangle = area.getRect()) != null && rectangle.contains(screenPoint.getX(), screenPoint.getY())) {
                            return new SeriesSelection(seriesIndex, pointIndex, area.getX(), area.getY());
                        }
                        pointIndex++;
                    }
                    continue;
                }
            }
        }
        return super.getSeriesAndPointForScreenCoordinate(screenPoint);
    }

    /* access modifiers changed from: protected */
    public boolean isRenderNullValues() {
        return false;
    }

    public boolean isRenderPoints(SimpleSeriesRenderer renderer) {
        return false;
    }

    public double getDefaultMinimum() {
        return Double.MAX_VALUE;
    }

    public ScatterChart getPointsChart() {
        return null;
    }
}
