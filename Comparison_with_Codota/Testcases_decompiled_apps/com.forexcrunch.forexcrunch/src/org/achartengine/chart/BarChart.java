package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class BarChart extends XYChart {
    private static final int SHAPE_WIDTH = 12;
    public static final String TYPE = "Bar";
    protected Type mType = Type.DEFAULT;

    public enum Type {
        DEFAULT,
        STACKED
    }

    BarChart() {
    }

    BarChart(Type type) {
        this.mType = type;
    }

    public BarChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, Type type) {
        super(dataset, renderer);
        this.mType = type;
    }

    /* access modifiers changed from: protected */
    public ClickableArea[] clickableAreasForPoints(List<Float> points, List<Double> values, float yAxisValue, int seriesIndex, int startIndex) {
        int seriesNr = this.mDataset.getSeriesCount();
        int length = points.size();
        ClickableArea[] ret = new ClickableArea[(length / 2)];
        float halfDiffX = getHalfDiffX(points, length, seriesNr);
        for (int i = 0; i < length; i += 2) {
            float x = points.get(i).floatValue();
            float y = points.get(i + 1).floatValue();
            if (this.mType == Type.STACKED) {
                ret[i / 2] = new ClickableArea(new RectF(x - halfDiffX, Math.min(y, yAxisValue), x + halfDiffX, Math.max(y, yAxisValue)), values.get(i).doubleValue(), values.get(i + 1).doubleValue());
            } else {
                float startX = (x - (((float) seriesNr) * halfDiffX)) + (((float) (seriesIndex * 2)) * halfDiffX);
                ret[i / 2] = new ClickableArea(new RectF(startX, Math.min(y, yAxisValue), (2.0f * halfDiffX) + startX, Math.max(y, yAxisValue)), values.get(i).doubleValue(), values.get(i + 1).doubleValue());
            }
        }
        return ret;
    }

    public void drawSeries(Canvas canvas, Paint paint, List<Float> points, SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, int startIndex) {
        int seriesNr = this.mDataset.getSeriesCount();
        int length = points.size();
        paint.setColor(seriesRenderer.getColor());
        paint.setStyle(Paint.Style.FILL);
        float halfDiffX = getHalfDiffX(points, length, seriesNr);
        for (int i = 0; i < length; i += 2) {
            float x = points.get(i).floatValue();
            drawBar(canvas, x, yAxisValue, x, points.get(i + 1).floatValue(), halfDiffX, seriesNr, seriesIndex, paint);
        }
        paint.setColor(seriesRenderer.getColor());
    }

    /* access modifiers changed from: protected */
    public void drawBar(Canvas canvas, float xMin, float yMin, float xMax, float yMax, float halfDiffX, int seriesNr, int seriesIndex, Paint paint) {
        int scale = this.mDataset.getSeriesAt(seriesIndex).getScaleNumber();
        if (this.mType == Type.STACKED) {
            drawBar(canvas, xMin - halfDiffX, yMax, xMax + halfDiffX, yMin, scale, seriesIndex, paint);
            return;
        }
        float startX = (xMin - (((float) seriesNr) * halfDiffX)) + (((float) (seriesIndex * 2)) * halfDiffX);
        drawBar(canvas, startX, yMax, startX + (2.0f * halfDiffX), yMin, scale, seriesIndex, paint);
    }

    private void drawBar(Canvas canvas, float xMin, float yMin, float xMax, float yMax, int scale, int seriesIndex, Paint paint) {
        SimpleSeriesRenderer renderer = this.mRenderer.getSeriesRendererAt(seriesIndex);
        if (renderer.isGradientEnabled()) {
            float minY = (float) toScreenPoint(new double[]{0.0d, renderer.getGradientStopValue()}, scale)[1];
            float maxY = (float) toScreenPoint(new double[]{0.0d, renderer.getGradientStartValue()}, scale)[1];
            float gradientMinY = Math.max(minY, Math.min(yMin, yMax));
            float gradientMaxY = Math.min(maxY, Math.max(yMin, yMax));
            int gradientMinColor = renderer.getGradientStopColor();
            int gradientMaxColor = renderer.getGradientStartColor();
            int gradientStartColor = gradientMaxColor;
            int gradientStopColor = gradientMinColor;
            if (yMin < minY) {
                paint.setColor(gradientMinColor);
                canvas.drawRect((float) Math.round(xMin), (float) Math.round(yMin), (float) Math.round(xMax), (float) Math.round(gradientMinY), paint);
            } else {
                gradientStopColor = getGradientPartialColor(gradientMinColor, gradientMaxColor, (maxY - gradientMinY) / (maxY - minY));
            }
            if (yMax > maxY) {
                paint.setColor(gradientMaxColor);
                canvas.drawRect((float) Math.round(xMin), (float) Math.round(gradientMaxY), (float) Math.round(xMax), (float) Math.round(yMax), paint);
            } else {
                gradientStartColor = getGradientPartialColor(gradientMaxColor, gradientMinColor, (gradientMaxY - minY) / (maxY - minY));
            }
            GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{gradientStartColor, gradientStopColor});
            gradient.setBounds(Math.round(xMin), Math.round(gradientMinY), Math.round(xMax), Math.round(gradientMaxY));
            gradient.draw(canvas);
            return;
        }
        if (Math.abs(yMin - yMax) < 1.0f) {
            if (yMin < yMax) {
                yMax = yMin + 1.0f;
            } else {
                yMax = yMin - 1.0f;
            }
        }
        canvas.drawRect((float) Math.round(xMin), (float) Math.round(yMin), (float) Math.round(xMax), (float) Math.round(yMax), paint);
    }

    private int getGradientPartialColor(int minColor, int maxColor, float fraction) {
        return Color.argb(Math.round((((float) Color.alpha(minColor)) * fraction) + ((1.0f - fraction) * ((float) Color.alpha(maxColor)))), Math.round((((float) Color.red(minColor)) * fraction) + ((1.0f - fraction) * ((float) Color.red(maxColor)))), Math.round((((float) Color.green(minColor)) * fraction) + ((1.0f - fraction) * ((float) Color.green(maxColor)))), Math.round((((float) Color.blue(minColor)) * fraction) + ((1.0f - fraction) * ((float) Color.blue(maxColor)))));
    }

    /* access modifiers changed from: protected */
    public void drawChartValuesText(Canvas canvas, XYSeries series, SimpleSeriesRenderer renderer, Paint paint, List<Float> points, int seriesIndex, int startIndex) {
        int seriesNr = this.mDataset.getSeriesCount();
        int length = points.size();
        float halfDiffX = getHalfDiffX(points, length, seriesNr);
        for (int i = 0; i < length; i += 2) {
            double value = series.getY(startIndex + (i / 2));
            if (!isNullValue(value)) {
                float x = points.get(i).floatValue();
                if (this.mType == Type.DEFAULT) {
                    x += (((float) (seriesIndex * 2)) * halfDiffX) - ((((float) seriesNr) - 1.5f) * halfDiffX);
                }
                if (value >= 0.0d) {
                    drawText(canvas, getLabel(renderer.getChartValuesFormat(), value), x, points.get(i + 1).floatValue() - renderer.getChartValuesSpacing(), paint, BitmapDescriptorFactory.HUE_RED);
                } else {
                    drawText(canvas, getLabel(renderer.getChartValuesFormat(), value), x, ((points.get(i + 1).floatValue() + renderer.getChartValuesTextSize()) + renderer.getChartValuesSpacing()) - 3.0f, paint, BitmapDescriptorFactory.HUE_RED);
                }
            }
        }
    }

    public int getLegendShapeWidth(int seriesIndex) {
        return 12;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y, int seriesIndex, Paint paint) {
        canvas.drawRect(x, y - 6.0f, x + 12.0f, y + 6.0f, paint);
    }

    /* access modifiers changed from: protected */
    public float getHalfDiffX(List<Float> points, int length, int seriesNr) {
        float barWidth = this.mRenderer.getBarWidth();
        if (barWidth > BitmapDescriptorFactory.HUE_RED) {
            return barWidth / 2.0f;
        }
        int div = length;
        if (length > 2) {
            div = length - 2;
        }
        float halfDiffX = (points.get(length - 2).floatValue() - points.get(0).floatValue()) / ((float) div);
        if (halfDiffX == BitmapDescriptorFactory.HUE_RED) {
            halfDiffX = 10.0f;
        }
        if (this.mType != Type.STACKED) {
            halfDiffX /= (float) seriesNr;
        }
        return (float) (((double) halfDiffX) / (((double) getCoeficient()) * (1.0d + this.mRenderer.getBarSpacing())));
    }

    /* access modifiers changed from: protected */
    public float getCoeficient() {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public boolean isRenderNullValues() {
        return true;
    }

    public double getDefaultMinimum() {
        return 0.0d;
    }

    public String getChartType() {
        return TYPE;
    }
}
