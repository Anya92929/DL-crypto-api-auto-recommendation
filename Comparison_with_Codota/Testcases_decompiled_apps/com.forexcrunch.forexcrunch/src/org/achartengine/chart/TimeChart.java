package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class TimeChart extends LineChart {
    public static final long DAY = 86400000;
    public static final String TYPE = "Time";
    private String mDateFormat;
    private Double mStartPoint;

    TimeChart() {
    }

    public TimeChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        super(dataset, renderer);
    }

    public String getDateFormat() {
        return this.mDateFormat;
    }

    public void setDateFormat(String format) {
        this.mDateFormat = format;
    }

    /* access modifiers changed from: protected */
    public void drawXLabels(List<Double> xLabels, Double[] xTextLabelLocations, Canvas canvas, Paint paint, int left, int top, int bottom, double xPixelsPerUnit, double minX, double maxX) {
        int length = xLabels.size();
        if (length > 0) {
            boolean showLabels = this.mRenderer.isShowLabels();
            boolean showGridY = this.mRenderer.isShowGridY();
            DateFormat format = getDateFormat(xLabels.get(0).doubleValue(), xLabels.get(length - 1).doubleValue());
            for (int i = 0; i < length; i++) {
                long label = Math.round(xLabels.get(i).doubleValue());
                float xLabel = (float) (((double) left) + ((((double) label) - minX) * xPixelsPerUnit));
                if (showLabels) {
                    paint.setColor(this.mRenderer.getXLabelsColor());
                    canvas.drawLine(xLabel, (float) bottom, xLabel, ((float) bottom) + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                    Canvas canvas2 = canvas;
                    float f = xLabel;
                    Paint paint2 = paint;
                    drawText(canvas2, format.format(new Date(label)), f, ((float) bottom) + ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + this.mRenderer.getXLabelsPadding(), paint2, this.mRenderer.getXLabelsAngle());
                }
                if (showGridY) {
                    paint.setColor(this.mRenderer.getGridColor());
                    canvas.drawLine(xLabel, (float) bottom, xLabel, (float) top, paint);
                }
            }
        }
        drawXTextLabels(xTextLabelLocations, canvas, paint, true, left, top, bottom, xPixelsPerUnit, minX, maxX);
    }

    private DateFormat getDateFormat(double start, double end) {
        if (this.mDateFormat != null) {
            try {
                return new SimpleDateFormat(this.mDateFormat);
            } catch (Exception e) {
            }
        }
        DateFormat dateInstance = SimpleDateFormat.getDateInstance(2);
        double diff = end - start;
        if (diff > 8.64E7d && diff < 4.32E8d) {
            return SimpleDateFormat.getDateTimeInstance(3, 3);
        }
        if (diff < 8.64E7d) {
            return SimpleDateFormat.getTimeInstance(2);
        }
        return dateInstance;
    }

    public String getChartType() {
        return TYPE;
    }

    /* access modifiers changed from: protected */
    public List<Double> getXLabels(double min, double max, int count) {
        List<Double> result = new ArrayList<>();
        if (this.mRenderer.isXRoundedLabels()) {
            if (this.mStartPoint == null) {
                this.mStartPoint = Double.valueOf((min - (min % 8.64E7d)) + 8.64E7d + ((double) (new Date(Math.round(min)).getTimezoneOffset() * 60 * 1000)));
            }
            if (count > 25) {
                count = 25;
            }
            double cycleMath = (max - min) / ((double) count);
            if (cycleMath <= 0.0d) {
                return result;
            }
            double cycle = 8.64E7d;
            if (cycleMath <= 8.64E7d) {
                while (cycleMath < cycle / 2.0d) {
                    cycle /= 2.0d;
                }
            } else {
                while (cycleMath > cycle) {
                    cycle *= 2.0d;
                }
            }
            double val = this.mStartPoint.doubleValue() - (Math.floor((this.mStartPoint.doubleValue() - min) / cycle) * cycle);
            int i = 0;
            while (true) {
                int i2 = i;
                if (val < max) {
                    i = i2 + 1;
                    if (i2 > count) {
                        return result;
                    }
                    result.add(Double.valueOf(val));
                    val += cycle;
                } else {
                    int i3 = i2;
                    return result;
                }
            }
        } else if (this.mDataset.getSeriesCount() <= 0) {
            return super.getXLabels(min, max, count);
        } else {
            XYSeries series = this.mDataset.getSeriesAt(0);
            int length = series.getItemCount();
            int intervalLength = 0;
            int startIndex = -1;
            for (int i4 = 0; i4 < length; i4++) {
                double value = series.getX(i4);
                if (min <= value && value <= max) {
                    intervalLength++;
                    if (startIndex < 0) {
                        startIndex = i4;
                    }
                }
            }
            if (intervalLength < count) {
                for (int i5 = startIndex; i5 < startIndex + intervalLength; i5++) {
                    result.add(Double.valueOf(series.getX(i5)));
                }
                return result;
            }
            float step = ((float) intervalLength) / ((float) count);
            int intervalCount = 0;
            for (int i6 = 0; i6 < length && intervalCount < count; i6++) {
                double value2 = series.getX(Math.round(((float) i6) * step));
                if (min <= value2 && value2 <= max) {
                    result.add(Double.valueOf(value2));
                    intervalCount++;
                }
            }
            return result;
        }
    }
}
