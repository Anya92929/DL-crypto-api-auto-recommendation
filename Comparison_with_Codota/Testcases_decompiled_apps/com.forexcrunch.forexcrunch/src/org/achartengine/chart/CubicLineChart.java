package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class CubicLineChart extends LineChart {
    public static final String TYPE = "Cubic";
    private float firstMultiplier;

    /* renamed from: p1 */
    private Point f1765p1;

    /* renamed from: p2 */
    private Point f1766p2;

    /* renamed from: p3 */
    private Point f1767p3;
    private float secondMultiplier;

    public CubicLineChart() {
        this.f1765p1 = new Point();
        this.f1766p2 = new Point();
        this.f1767p3 = new Point();
        this.firstMultiplier = 0.33f;
        this.secondMultiplier = 1.0f - this.firstMultiplier;
    }

    public CubicLineChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, float smoothness) {
        super(dataset, renderer);
        this.f1765p1 = new Point();
        this.f1766p2 = new Point();
        this.f1767p3 = new Point();
        this.firstMultiplier = smoothness;
        this.secondMultiplier = 1.0f - this.firstMultiplier;
    }

    /* access modifiers changed from: protected */
    public void drawPath(Canvas canvas, List<Float> points, Paint paint, boolean circular) {
        int nextIndex;
        int nextNextIndex;
        Path p = new Path();
        p.moveTo(points.get(0).floatValue(), points.get(1).floatValue());
        int length = points.size();
        if (circular) {
            length -= 4;
        }
        for (int i = 0; i < length; i += 2) {
            if (i + 2 < length) {
                nextIndex = i + 2;
            } else {
                nextIndex = i;
            }
            if (i + 4 < length) {
                nextNextIndex = i + 4;
            } else {
                nextNextIndex = nextIndex;
            }
            calc(points, this.f1765p1, i, nextIndex, this.secondMultiplier);
            this.f1766p2.setX(points.get(nextIndex).floatValue());
            this.f1766p2.setY(points.get(nextIndex + 1).floatValue());
            calc(points, this.f1767p3, nextIndex, nextNextIndex, this.firstMultiplier);
            p.cubicTo(this.f1765p1.getX(), this.f1765p1.getY(), this.f1766p2.getX(), this.f1766p2.getY(), this.f1767p3.getX(), this.f1767p3.getY());
        }
        if (circular) {
            for (int i2 = length; i2 < length + 4; i2 += 2) {
                p.lineTo(points.get(i2).floatValue(), points.get(i2 + 1).floatValue());
            }
            p.lineTo(points.get(0).floatValue(), points.get(1).floatValue());
        }
        canvas.drawPath(p, paint);
    }

    private void calc(List<Float> points, Point result, int index1, int index2, float multiplier) {
        float p1x = points.get(index1).floatValue();
        float p1y = points.get(index1 + 1).floatValue();
        result.setX(((points.get(index2).floatValue() - p1x) * multiplier) + p1x);
        result.setY(((points.get(index2 + 1).floatValue() - p1y) * multiplier) + p1y);
    }

    public String getChartType() {
        return TYPE;
    }
}
