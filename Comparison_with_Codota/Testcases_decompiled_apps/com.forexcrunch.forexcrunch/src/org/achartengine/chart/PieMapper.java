package org.achartengine.chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;

public class PieMapper implements Serializable {
    private int mCenterX;
    private int mCenterY;
    private int mPieChartRadius;
    private List<PieSegment> mPieSegmentList = new ArrayList();

    public void setDimensions(int pieRadius, int centerX, int centerY) {
        this.mPieChartRadius = pieRadius;
        this.mCenterX = centerX;
        this.mCenterY = centerY;
    }

    public boolean areAllSegmentPresent(int datasetSize) {
        return this.mPieSegmentList.size() == datasetSize;
    }

    public void addPieSegment(int dataIndex, float value, float startAngle, float angle) {
        this.mPieSegmentList.add(new PieSegment(dataIndex, value, startAngle, angle));
    }

    public void clearPieSegments() {
        this.mPieSegmentList.clear();
    }

    public double getAngle(Point screenPoint) {
        double inRads;
        double inRads2 = Math.atan2((double) (-(screenPoint.getY() - ((float) this.mCenterY))), (double) (screenPoint.getX() - ((float) this.mCenterX)));
        if (inRads2 < 0.0d) {
            inRads = Math.abs(inRads2);
        } else {
            inRads = 6.283185307179586d - inRads2;
        }
        return Math.toDegrees(inRads);
    }

    public boolean isOnPieChart(Point screenPoint) {
        return Math.pow((double) (((float) this.mCenterX) - screenPoint.getX()), 2.0d) + Math.pow((double) (((float) this.mCenterY) - screenPoint.getY()), 2.0d) <= ((double) (this.mPieChartRadius * this.mPieChartRadius));
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point screenPoint) {
        if (isOnPieChart(screenPoint)) {
            double angleFromPieCenter = getAngle(screenPoint);
            for (PieSegment pieSeg : this.mPieSegmentList) {
                if (pieSeg.isInSegment(angleFromPieCenter)) {
                    return new SeriesSelection(0, pieSeg.getDataIndex(), (double) pieSeg.getValue(), (double) pieSeg.getValue());
                }
            }
        }
        return null;
    }
}
