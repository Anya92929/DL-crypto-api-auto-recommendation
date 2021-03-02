package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.MultipleCategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class DoughnutChart extends RoundChart {
    private MultipleCategorySeries mDataset;
    private int mStep;

    public DoughnutChart(MultipleCategorySeries dataset, DefaultRenderer renderer) {
        super((CategorySeries) null, renderer);
        this.mDataset = dataset;
    }

    public void draw(Canvas canvas, int x, int y, int width, int height, Paint paint) {
        paint.setAntiAlias(this.mRenderer.isAntialiasing());
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(this.mRenderer.getLabelsTextSize());
        int legendSize = getLegendSize(this.mRenderer, height / 5, BitmapDescriptorFactory.HUE_RED);
        int left = x;
        int top = y;
        int right = x + width;
        int cLength = this.mDataset.getCategoriesCount();
        String[] categories = new String[cLength];
        for (int category = 0; category < cLength; category++) {
            categories[category] = this.mDataset.getCategory(category);
        }
        if (this.mRenderer.isFitLegend()) {
            legendSize = drawLegend(canvas, this.mRenderer, categories, left, right, y, width, height, legendSize, paint, true);
        }
        int bottom = (y + height) - legendSize;
        drawBackground(this.mRenderer, canvas, x, y, width, height, paint, false, 0);
        this.mStep = 7;
        int mRadius = Math.min(Math.abs(right - left), Math.abs(bottom - top));
        double decCoef = 0.2d / ((double) cLength);
        int radius = (int) (((double) mRadius) * 0.35d * ((double) this.mRenderer.getScale()));
        if (this.mCenterX == Integer.MAX_VALUE) {
            this.mCenterX = (left + right) / 2;
        }
        if (this.mCenterY == Integer.MAX_VALUE) {
            this.mCenterY = (bottom + top) / 2;
        }
        float shortRadius = ((float) radius) * 0.9f;
        float longRadius = ((float) radius) * 1.1f;
        List<RectF> prevLabelsBounds = new ArrayList<>();
        for (int category2 = 0; category2 < cLength; category2++) {
            int sLength = this.mDataset.getItemCount(category2);
            double total = 0.0d;
            String[] titles = new String[sLength];
            for (int i = 0; i < sLength; i++) {
                total += this.mDataset.getValues(category2)[i];
                titles[i] = this.mDataset.getTitles(category2)[i];
            }
            float currentAngle = this.mRenderer.getStartAngle();
            RectF oval = new RectF((float) (this.mCenterX - radius), (float) (this.mCenterY - radius), (float) (this.mCenterX + radius), (float) (this.mCenterY + radius));
            for (int i2 = 0; i2 < sLength; i2++) {
                paint.setColor(this.mRenderer.getSeriesRendererAt(i2).getColor());
                float angle = (float) ((((double) ((float) this.mDataset.getValues(category2)[i2])) / total) * 360.0d);
                canvas.drawArc(oval, currentAngle, angle, true, paint);
                drawLabel(canvas, this.mDataset.getTitles(category2)[i2], this.mRenderer, prevLabelsBounds, this.mCenterX, this.mCenterY, shortRadius, longRadius, currentAngle, angle, left, right, this.mRenderer.getLabelsColor(), paint, true, false);
                currentAngle += angle;
            }
            int radius2 = (int) (((double) radius) - (((double) mRadius) * decCoef));
            shortRadius = (float) (((double) shortRadius) - ((((double) mRadius) * decCoef) - 2.0d));
            if (this.mRenderer.getBackgroundColor() != 0) {
                paint.setColor(this.mRenderer.getBackgroundColor());
            } else {
                paint.setColor(-1);
            }
            paint.setStyle(Paint.Style.FILL);
            canvas.drawArc(new RectF((float) (this.mCenterX - radius2), (float) (this.mCenterY - radius2), (float) (this.mCenterX + radius2), (float) (this.mCenterY + radius2)), BitmapDescriptorFactory.HUE_RED, 360.0f, true, paint);
            radius = radius2 - 1;
        }
        prevLabelsBounds.clear();
        drawLegend(canvas, this.mRenderer, categories, left, right, y, width, height, legendSize, paint, false);
        drawTitle(canvas, x, y, width, paint);
    }

    public int getLegendShapeWidth(int seriesIndex) {
        return 10;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y, int seriesIndex, Paint paint) {
        this.mStep--;
        canvas.drawCircle((10.0f + x) - ((float) this.mStep), y, (float) this.mStep, paint);
    }
}
