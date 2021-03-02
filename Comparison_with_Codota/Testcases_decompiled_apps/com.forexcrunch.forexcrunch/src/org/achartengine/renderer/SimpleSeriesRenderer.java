package org.achartengine.renderer;

import android.graphics.Paint;
import java.io.Serializable;
import java.text.NumberFormat;

public class SimpleSeriesRenderer implements Serializable {
    private NumberFormat mChartValuesFormat;
    private float mChartValuesSpacing = 5.0f;
    private Paint.Align mChartValuesTextAlign = Paint.Align.CENTER;
    private float mChartValuesTextSize = 10.0f;
    private int mColor = -16776961;
    private boolean mDisplayBoundingPoints = true;
    private boolean mDisplayChartValues;
    private int mDisplayChartValuesDistance = 100;
    private boolean mGradientEnabled = false;
    private int mGradientStartColor;
    private double mGradientStartValue;
    private int mGradientStopColor;
    private double mGradientStopValue;
    private boolean mHighlighted;
    private boolean mShowLegendItem = true;
    private BasicStroke mStroke;

    public int getColor() {
        return this.mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public boolean isDisplayChartValues() {
        return this.mDisplayChartValues;
    }

    public void setDisplayChartValues(boolean display) {
        this.mDisplayChartValues = display;
    }

    public int getDisplayChartValuesDistance() {
        return this.mDisplayChartValuesDistance;
    }

    public void setDisplayChartValuesDistance(int distance) {
        this.mDisplayChartValuesDistance = distance;
    }

    public float getChartValuesTextSize() {
        return this.mChartValuesTextSize;
    }

    public void setChartValuesTextSize(float textSize) {
        this.mChartValuesTextSize = textSize;
    }

    public Paint.Align getChartValuesTextAlign() {
        return this.mChartValuesTextAlign;
    }

    public void setChartValuesTextAlign(Paint.Align align) {
        this.mChartValuesTextAlign = align;
    }

    public float getChartValuesSpacing() {
        return this.mChartValuesSpacing;
    }

    public void setChartValuesSpacing(float spacing) {
        this.mChartValuesSpacing = spacing;
    }

    public BasicStroke getStroke() {
        return this.mStroke;
    }

    public void setStroke(BasicStroke stroke) {
        this.mStroke = stroke;
    }

    public boolean isGradientEnabled() {
        return this.mGradientEnabled;
    }

    public void setGradientEnabled(boolean enabled) {
        this.mGradientEnabled = enabled;
    }

    public double getGradientStartValue() {
        return this.mGradientStartValue;
    }

    public int getGradientStartColor() {
        return this.mGradientStartColor;
    }

    public void setGradientStart(double start, int color) {
        this.mGradientStartValue = start;
        this.mGradientStartColor = color;
    }

    public double getGradientStopValue() {
        return this.mGradientStopValue;
    }

    public int getGradientStopColor() {
        return this.mGradientStopColor;
    }

    public void setGradientStop(double start, int color) {
        this.mGradientStopValue = start;
        this.mGradientStopColor = color;
    }

    public boolean isShowLegendItem() {
        return this.mShowLegendItem;
    }

    public void setShowLegendItem(boolean showLegend) {
        this.mShowLegendItem = showLegend;
    }

    public boolean isHighlighted() {
        return this.mHighlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.mHighlighted = highlighted;
    }

    public boolean isDisplayBoundingPoints() {
        return this.mDisplayBoundingPoints;
    }

    public void setDisplayBoundingPoints(boolean display) {
        this.mDisplayBoundingPoints = display;
    }

    public NumberFormat getChartValuesFormat() {
        return this.mChartValuesFormat;
    }

    public void setChartValuesFormat(NumberFormat format) {
        this.mChartValuesFormat = format;
    }
}
