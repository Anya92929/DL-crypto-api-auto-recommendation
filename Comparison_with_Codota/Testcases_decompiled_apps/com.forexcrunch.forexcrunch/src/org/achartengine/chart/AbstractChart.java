package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public abstract class AbstractChart implements Serializable {
    public abstract void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint);

    public abstract void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint);

    public abstract int getLegendShapeWidth(int i);

    /* access modifiers changed from: protected */
    public void drawBackground(DefaultRenderer renderer, Canvas canvas, int x, int y, int width, int height, Paint paint, boolean newColor, int color) {
        if (renderer.isApplyBackgroundColor() || newColor) {
            if (newColor) {
                paint.setColor(color);
            } else {
                paint.setColor(renderer.getBackgroundColor());
            }
            paint.setStyle(Paint.Style.FILL);
            Canvas canvas2 = canvas;
            canvas2.drawRect((float) x, (float) y, (float) (x + width), (float) (y + height), paint);
        }
    }

    /* access modifiers changed from: protected */
    public int drawLegend(Canvas canvas, DefaultRenderer renderer, String[] titles, int left, int right, int y, int width, int height, int legendSize, Paint paint, boolean calculate) {
        float size = 32.0f;
        if (renderer.isShowLegend()) {
            float currentX = (float) left;
            float currentY = ((float) ((y + height) - legendSize)) + 32.0f;
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(renderer.getLegendTextSize());
            int sLength = Math.min(titles.length, renderer.getSeriesRendererCount());
            for (int i = 0; i < sLength; i++) {
                SimpleSeriesRenderer r = renderer.getSeriesRendererAt(i);
                float lineSize = (float) getLegendShapeWidth(i);
                if (r.isShowLegendItem()) {
                    String text = titles[i];
                    if (titles.length == renderer.getSeriesRendererCount()) {
                        paint.setColor(r.getColor());
                    } else {
                        paint.setColor(DefaultRenderer.TEXT_COLOR);
                    }
                    float[] widths = new float[text.length()];
                    paint.getTextWidths(text, widths);
                    float sum = BitmapDescriptorFactory.HUE_RED;
                    float[] arr$ = widths;
                    int len$ = arr$.length;
                    for (int i$ = 0; i$ < len$; i$++) {
                        sum += arr$[i$];
                    }
                    float extraSize = 10.0f + lineSize + sum;
                    float currentWidth = currentX + extraSize;
                    if (i > 0 && getExceed(currentWidth, renderer, right, width)) {
                        currentX = (float) left;
                        currentY += renderer.getLegendTextSize();
                        size += renderer.getLegendTextSize();
                        currentWidth = currentX + extraSize;
                    }
                    if (getExceed(currentWidth, renderer, right, width)) {
                        float maxWidth = ((((float) right) - currentX) - lineSize) - 10.0f;
                        if (isVertical(renderer)) {
                            maxWidth = ((((float) width) - currentX) - lineSize) - 10.0f;
                        }
                        text = text.substring(0, paint.breakText(text, true, maxWidth, widths)) + "...";
                    }
                    if (!calculate) {
                        drawLegendShape(canvas, r, currentX, currentY, i, paint);
                        drawString(canvas, text, currentX + lineSize + 5.0f, currentY + 5.0f, paint);
                    }
                    currentX += extraSize;
                }
            }
        }
        return Math.round(renderer.getLegendTextSize() + size);
    }

    /* access modifiers changed from: protected */
    public void drawString(Canvas canvas, String text, float x, float y, Paint paint) {
        if (text != null) {
            String[] lines = text.split("\n");
            Rect rect = new Rect();
            int yOff = 0;
            for (int i = 0; i < lines.length; i++) {
                canvas.drawText(lines[i], x, ((float) yOff) + y, paint);
                paint.getTextBounds(lines[i], 0, lines[i].length(), rect);
                yOff = rect.height() + yOff + 5;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean getExceed(float currentWidth, DefaultRenderer renderer, int right, int width) {
        boolean exceed;
        if (currentWidth > ((float) right)) {
            exceed = true;
        } else {
            exceed = false;
        }
        if (!isVertical(renderer)) {
            return exceed;
        }
        if (currentWidth > ((float) width)) {
            return true;
        }
        return false;
    }

    public boolean isVertical(DefaultRenderer renderer) {
        return (renderer instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer) renderer).getOrientation() == XYMultipleSeriesRenderer.Orientation.VERTICAL;
    }

    /* access modifiers changed from: protected */
    public String getLabel(NumberFormat format, double label) {
        if (format != null) {
            return format.format(label);
        }
        if (label == ((double) Math.round(label))) {
            return Math.round(label) + "";
        }
        return label + "";
    }

    private static float[] calculateDrawPoints(float p1x, float p1y, float p2x, float p2y, int screenHeight, int screenWidth) {
        float drawP1x;
        float drawP1y;
        float drawP2x;
        float drawP2y;
        if (p1y > ((float) screenHeight)) {
            float m = (p2y - p1y) / (p2x - p1x);
            drawP1x = ((((float) screenHeight) - p1y) + (m * p1x)) / m;
            drawP1y = (float) screenHeight;
            if (drawP1x < BitmapDescriptorFactory.HUE_RED) {
                drawP1x = BitmapDescriptorFactory.HUE_RED;
                drawP1y = p1y - (m * p1x);
            } else if (drawP1x > ((float) screenWidth)) {
                drawP1x = (float) screenWidth;
                drawP1y = ((((float) screenWidth) * m) + p1y) - (m * p1x);
            }
        } else if (p1y < BitmapDescriptorFactory.HUE_RED) {
            float m2 = (p2y - p1y) / (p2x - p1x);
            drawP1x = ((-p1y) + (m2 * p1x)) / m2;
            drawP1y = BitmapDescriptorFactory.HUE_RED;
            if (drawP1x < BitmapDescriptorFactory.HUE_RED) {
                drawP1x = BitmapDescriptorFactory.HUE_RED;
                drawP1y = p1y - (m2 * p1x);
            } else if (drawP1x > ((float) screenWidth)) {
                drawP1x = (float) screenWidth;
                drawP1y = ((((float) screenWidth) * m2) + p1y) - (m2 * p1x);
            }
        } else {
            drawP1x = p1x;
            drawP1y = p1y;
        }
        if (p2y > ((float) screenHeight)) {
            float m3 = (p2y - p1y) / (p2x - p1x);
            drawP2x = ((((float) screenHeight) - p1y) + (m3 * p1x)) / m3;
            drawP2y = (float) screenHeight;
            if (drawP2x < BitmapDescriptorFactory.HUE_RED) {
                drawP2x = BitmapDescriptorFactory.HUE_RED;
                drawP2y = p1y - (m3 * p1x);
            } else if (drawP2x > ((float) screenWidth)) {
                drawP2x = (float) screenWidth;
                drawP2y = ((((float) screenWidth) * m3) + p1y) - (m3 * p1x);
            }
        } else if (p2y < BitmapDescriptorFactory.HUE_RED) {
            float m4 = (p2y - p1y) / (p2x - p1x);
            drawP2x = ((-p1y) + (m4 * p1x)) / m4;
            drawP2y = BitmapDescriptorFactory.HUE_RED;
            if (drawP2x < BitmapDescriptorFactory.HUE_RED) {
                drawP2x = BitmapDescriptorFactory.HUE_RED;
                drawP2y = p1y - (m4 * p1x);
            } else if (drawP2x > ((float) screenWidth)) {
                drawP2x = (float) screenWidth;
                drawP2y = ((((float) screenWidth) * m4) + p1y) - (m4 * p1x);
            }
        } else {
            drawP2x = p2x;
            drawP2y = p2y;
        }
        return new float[]{drawP1x, drawP1y, drawP2x, drawP2y};
    }

    /* access modifiers changed from: protected */
    public void drawPath(Canvas canvas, List<Float> points, Paint paint, boolean circular) {
        Path path = new Path();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        if (points.size() >= 4) {
            float[] tempDrawPoints = calculateDrawPoints(points.get(0).floatValue(), points.get(1).floatValue(), points.get(2).floatValue(), points.get(3).floatValue(), height, width);
            path.moveTo(tempDrawPoints[0], tempDrawPoints[1]);
            path.lineTo(tempDrawPoints[2], tempDrawPoints[3]);
            int length = points.size();
            for (int i = 4; i < length; i += 2) {
                if ((points.get(i - 1).floatValue() >= BitmapDescriptorFactory.HUE_RED || points.get(i + 1).floatValue() >= BitmapDescriptorFactory.HUE_RED) && (points.get(i - 1).floatValue() <= ((float) height) || points.get(i + 1).floatValue() <= ((float) height))) {
                    float[] tempDrawPoints2 = calculateDrawPoints(points.get(i - 2).floatValue(), points.get(i - 1).floatValue(), points.get(i).floatValue(), points.get(i + 1).floatValue(), height, width);
                    if (!circular) {
                        path.moveTo(tempDrawPoints2[0], tempDrawPoints2[1]);
                    }
                    path.lineTo(tempDrawPoints2[2], tempDrawPoints2[3]);
                }
            }
            if (circular) {
                path.lineTo(points.get(0).floatValue(), points.get(1).floatValue());
            }
            canvas.drawPath(path, paint);
        }
    }

    /* access modifiers changed from: protected */
    public void drawPath(Canvas canvas, float[] points, Paint paint, boolean circular) {
        Path path = new Path();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        if (points.length >= 4) {
            float[] tempDrawPoints = calculateDrawPoints(points[0], points[1], points[2], points[3], height, width);
            path.moveTo(tempDrawPoints[0], tempDrawPoints[1]);
            path.lineTo(tempDrawPoints[2], tempDrawPoints[3]);
            int length = points.length;
            for (int i = 4; i < length; i += 2) {
                if ((points[i - 1] >= BitmapDescriptorFactory.HUE_RED || points[i + 1] >= BitmapDescriptorFactory.HUE_RED) && (points[i - 1] <= ((float) height) || points[i + 1] <= ((float) height))) {
                    float[] tempDrawPoints2 = calculateDrawPoints(points[i - 2], points[i - 1], points[i], points[i + 1], height, width);
                    if (!circular) {
                        path.moveTo(tempDrawPoints2[0], tempDrawPoints2[1]);
                    }
                    path.lineTo(tempDrawPoints2[2], tempDrawPoints2[3]);
                }
            }
            if (circular) {
                path.lineTo(points[0], points[1]);
            }
            canvas.drawPath(path, paint);
        }
    }

    private String getFitText(String text, float width, Paint paint) {
        String newText = text;
        int length = text.length();
        int diff = 0;
        while (paint.measureText(newText) > width && diff < length) {
            diff++;
            newText = text.substring(0, length - diff) + "...";
        }
        if (diff == length) {
            return "...";
        }
        return newText;
    }

    /* access modifiers changed from: protected */
    public int getLegendSize(DefaultRenderer renderer, int defaultHeight, float extraHeight) {
        int legendSize = renderer.getLegendHeight();
        if (renderer.isShowLegend() && legendSize == 0) {
            legendSize = defaultHeight;
        }
        if (renderer.isShowLegend() || !renderer.isShowLabels()) {
            return legendSize;
        }
        return (int) (((renderer.getLabelsTextSize() * 4.0f) / 3.0f) + extraHeight);
    }

    /* access modifiers changed from: protected */
    public void drawLabel(Canvas canvas, String labelText, DefaultRenderer renderer, List<RectF> prevLabelsBounds, int centerX, int centerY, float shortRadius, float longRadius, float currentAngle, float angle, int left, int right, int color, Paint paint, boolean line, boolean display) {
        boolean intersects;
        if (renderer.isShowLabels() || display) {
            paint.setColor(color);
            double rAngle = Math.toRadians((double) (90.0f - ((angle / 2.0f) + currentAngle)));
            double sinValue = Math.sin(rAngle);
            double cosValue = Math.cos(rAngle);
            int x1 = Math.round(((float) centerX) + ((float) (((double) shortRadius) * sinValue)));
            int y1 = Math.round(((float) centerY) + ((float) (((double) shortRadius) * cosValue)));
            int x2 = Math.round(((float) centerX) + ((float) (((double) longRadius) * sinValue)));
            int y2 = Math.round(((float) centerY) + ((float) (((double) longRadius) * cosValue)));
            float size = renderer.getLabelsTextSize();
            float extra = Math.max(size / 2.0f, 10.0f);
            paint.setTextAlign(Paint.Align.LEFT);
            if (x1 > x2) {
                extra = -extra;
                paint.setTextAlign(Paint.Align.RIGHT);
            }
            float xLabel = ((float) x2) + extra;
            float yLabel = (float) y2;
            float width = ((float) right) - xLabel;
            if (x1 > x2) {
                width = xLabel - ((float) left);
            }
            String labelText2 = getFitText(labelText, width, paint);
            float widthLabel = paint.measureText(labelText2);
            for (boolean okBounds = false; !okBounds && line; okBounds = !intersects) {
                intersects = false;
                int length = prevLabelsBounds.size();
                for (int j = 0; j < length && !intersects; j++) {
                    RectF prevLabelBounds = prevLabelsBounds.get(j);
                    if (prevLabelBounds.intersects(xLabel, yLabel, xLabel + widthLabel, yLabel + size)) {
                        intersects = true;
                        yLabel = Math.max(yLabel, prevLabelBounds.bottom);
                    }
                }
            }
            if (line) {
                int y22 = (int) (yLabel - (size / 2.0f));
                canvas.drawLine((float) x1, (float) y1, (float) x2, (float) y22, paint);
                canvas.drawLine((float) x2, (float) y22, ((float) x2) + extra, (float) y22, paint);
            } else {
                paint.setTextAlign(Paint.Align.CENTER);
            }
            canvas.drawText(labelText2, xLabel, yLabel, paint);
            if (line) {
                prevLabelsBounds.add(new RectF(xLabel, yLabel, xLabel + widthLabel, yLabel + size));
            }
        }
    }

    public boolean isNullValue(double value) {
        return Double.isNaN(value) || Double.isInfinite(value) || value == Double.MAX_VALUE;
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point screenPoint) {
        return null;
    }
}
