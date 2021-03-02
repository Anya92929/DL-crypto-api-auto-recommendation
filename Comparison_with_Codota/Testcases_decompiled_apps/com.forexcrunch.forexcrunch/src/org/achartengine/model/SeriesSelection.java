package org.achartengine.model;

public class SeriesSelection {
    private int mPointIndex;
    private int mSeriesIndex;
    private double mValue;
    private double mXValue;

    public SeriesSelection(int seriesIndex, int pointIndex, double xValue, double value) {
        this.mSeriesIndex = seriesIndex;
        this.mPointIndex = pointIndex;
        this.mXValue = xValue;
        this.mValue = value;
    }

    public int getSeriesIndex() {
        return this.mSeriesIndex;
    }

    public int getPointIndex() {
        return this.mPointIndex;
    }

    public double getXValue() {
        return this.mXValue;
    }

    public double getValue() {
        return this.mValue;
    }
}
