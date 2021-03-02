package org.achartengine.renderer;

import android.graphics.Color;
import android.graphics.Paint;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class XYMultipleSeriesRenderer extends DefaultRenderer {
    private Map<Integer, double[]> initialRange;
    private float mAxisTitleTextSize;
    private double mBarSpacing;
    private float mBarWidth;
    private int mGridColor;
    private NumberFormat mLabelFormat;
    private int mMarginsColor;
    private double[] mMaxX;
    private double[] mMaxY;
    private double[] mMinX;
    private double[] mMinY;
    private Orientation mOrientation;
    private double[] mPanLimits;
    private boolean mPanXEnabled;
    private boolean mPanYEnabled;
    private float mPointSize;
    private int mXLabels;
    private float mXLabelsAngle;
    private int mXLabelsColor;
    private float mXLabelsPadding;
    private boolean mXRoundedLabels;
    private Map<Double, String> mXTextLabels;
    private String mXTitle;
    private int mYLabels;
    private float mYLabelsAngle;
    private int[] mYLabelsColor;
    private float mYLabelsPadding;
    private float mYLabelsVerticalPadding;
    private Map<Integer, Map<Double, String>> mYTextLabels;
    private String[] mYTitle;
    private double mZoomInLimitX;
    private double mZoomInLimitY;
    private double[] mZoomLimits;
    private boolean mZoomXEnabled;
    private boolean mZoomYEnabled;
    private int scalesCount;
    private Paint.Align xLabelsAlign;
    private Paint.Align[] yAxisAlign;
    private Paint.Align[] yLabelsAlign;

    public enum Orientation {
        HORIZONTAL(0),
        VERTICAL(90);
        
        private int mAngle;

        private Orientation(int angle) {
            this.mAngle = 0;
            this.mAngle = angle;
        }

        public int getAngle() {
            return this.mAngle;
        }
    }

    public XYMultipleSeriesRenderer() {
        this(1);
    }

    public XYMultipleSeriesRenderer(int scaleNumber) {
        this.mXTitle = "";
        this.mAxisTitleTextSize = 12.0f;
        this.mXLabels = 5;
        this.mYLabels = 5;
        this.mOrientation = Orientation.HORIZONTAL;
        this.mXTextLabels = new HashMap();
        this.mYTextLabels = new LinkedHashMap();
        this.mPanXEnabled = true;
        this.mPanYEnabled = true;
        this.mZoomXEnabled = true;
        this.mZoomYEnabled = true;
        this.mBarSpacing = 0.0d;
        this.mMarginsColor = 0;
        this.initialRange = new LinkedHashMap();
        this.mPointSize = 3.0f;
        this.mGridColor = Color.argb(75, 200, 200, 200);
        this.xLabelsAlign = Paint.Align.CENTER;
        this.mXLabelsPadding = BitmapDescriptorFactory.HUE_RED;
        this.mYLabelsPadding = BitmapDescriptorFactory.HUE_RED;
        this.mYLabelsVerticalPadding = 2.0f;
        this.mXLabelsColor = DefaultRenderer.TEXT_COLOR;
        this.mYLabelsColor = new int[]{-3355444};
        this.mXRoundedLabels = true;
        this.mBarWidth = -1.0f;
        this.mZoomInLimitX = 0.0d;
        this.mZoomInLimitY = 0.0d;
        this.scalesCount = scaleNumber;
        initAxesRange(scaleNumber);
    }

    public void initAxesRange(int scales) {
        this.mYTitle = new String[scales];
        this.yLabelsAlign = new Paint.Align[scales];
        this.yAxisAlign = new Paint.Align[scales];
        this.mYLabelsColor = new int[scales];
        this.mMinX = new double[scales];
        this.mMaxX = new double[scales];
        this.mMinY = new double[scales];
        this.mMaxY = new double[scales];
        for (int i = 0; i < scales; i++) {
            this.mYLabelsColor[i] = -3355444;
            initAxesRangeForScale(i);
        }
    }

    public void initAxesRangeForScale(int i) {
        this.mMinX[i] = Double.MAX_VALUE;
        this.mMaxX[i] = -1.7976931348623157E308d;
        this.mMinY[i] = Double.MAX_VALUE;
        this.mMaxY[i] = -1.7976931348623157E308d;
        this.initialRange.put(Integer.valueOf(i), new double[]{this.mMinX[i], this.mMaxX[i], this.mMinY[i], this.mMaxY[i]});
        this.mYTitle[i] = "";
        this.mYTextLabels.put(Integer.valueOf(i), new HashMap());
        this.yLabelsAlign[i] = Paint.Align.CENTER;
        this.yAxisAlign[i] = Paint.Align.LEFT;
    }

    public Orientation getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(Orientation orientation) {
        this.mOrientation = orientation;
    }

    public String getXTitle() {
        return this.mXTitle;
    }

    public void setXTitle(String title) {
        this.mXTitle = title;
    }

    public String getYTitle() {
        return getYTitle(0);
    }

    public String getYTitle(int scale) {
        return this.mYTitle[scale];
    }

    public void setYTitle(String title) {
        setYTitle(title, 0);
    }

    public void setYTitle(String title, int scale) {
        this.mYTitle[scale] = title;
    }

    public float getAxisTitleTextSize() {
        return this.mAxisTitleTextSize;
    }

    public void setAxisTitleTextSize(float textSize) {
        this.mAxisTitleTextSize = textSize;
    }

    public double getXAxisMin() {
        return getXAxisMin(0);
    }

    public void setXAxisMin(double min) {
        setXAxisMin(min, 0);
    }

    public boolean isMinXSet() {
        return isMinXSet(0);
    }

    public double getXAxisMax() {
        return getXAxisMax(0);
    }

    public void setXAxisMax(double max) {
        setXAxisMax(max, 0);
    }

    public boolean isMaxXSet() {
        return isMaxXSet(0);
    }

    public double getYAxisMin() {
        return getYAxisMin(0);
    }

    public void setYAxisMin(double min) {
        setYAxisMin(min, 0);
    }

    public boolean isMinYSet() {
        return isMinYSet(0);
    }

    public double getYAxisMax() {
        return getYAxisMax(0);
    }

    public void setYAxisMax(double max) {
        setYAxisMax(max, 0);
    }

    public boolean isMaxYSet() {
        return isMaxYSet(0);
    }

    public double getXAxisMin(int scale) {
        return this.mMinX[scale];
    }

    public void setXAxisMin(double min, int scale) {
        if (!isMinXSet(scale)) {
            this.initialRange.get(Integer.valueOf(scale))[0] = min;
        }
        this.mMinX[scale] = min;
    }

    public boolean isMinXSet(int scale) {
        return this.mMinX[scale] != Double.MAX_VALUE;
    }

    public double getXAxisMax(int scale) {
        return this.mMaxX[scale];
    }

    public void setXAxisMax(double max, int scale) {
        if (!isMaxXSet(scale)) {
            this.initialRange.get(Integer.valueOf(scale))[1] = max;
        }
        this.mMaxX[scale] = max;
    }

    public boolean isMaxXSet(int scale) {
        return this.mMaxX[scale] != -1.7976931348623157E308d;
    }

    public double getYAxisMin(int scale) {
        return this.mMinY[scale];
    }

    public void setYAxisMin(double min, int scale) {
        if (!isMinYSet(scale)) {
            this.initialRange.get(Integer.valueOf(scale))[2] = min;
        }
        this.mMinY[scale] = min;
    }

    public boolean isMinYSet(int scale) {
        return this.mMinY[scale] != Double.MAX_VALUE;
    }

    public double getYAxisMax(int scale) {
        return this.mMaxY[scale];
    }

    public void setYAxisMax(double max, int scale) {
        if (!isMaxYSet(scale)) {
            this.initialRange.get(Integer.valueOf(scale))[3] = max;
        }
        this.mMaxY[scale] = max;
    }

    public boolean isMaxYSet(int scale) {
        return this.mMaxY[scale] != -1.7976931348623157E308d;
    }

    public int getXLabels() {
        return this.mXLabels;
    }

    public void setXLabels(int xLabels) {
        this.mXLabels = xLabels;
    }

    public void addTextLabel(double x, String text) {
        addXTextLabel(x, text);
    }

    public synchronized void addXTextLabel(double x, String text) {
        this.mXTextLabels.put(Double.valueOf(x), text);
    }

    public synchronized void removeXTextLabel(double x) {
        this.mXTextLabels.remove(Double.valueOf(x));
    }

    public synchronized String getXTextLabel(Double x) {
        return this.mXTextLabels.get(x);
    }

    public synchronized Double[] getXTextLabelLocations() {
        return (Double[]) this.mXTextLabels.keySet().toArray(new Double[0]);
    }

    public void clearTextLabels() {
        clearXTextLabels();
    }

    public synchronized void clearXTextLabels() {
        this.mXTextLabels.clear();
    }

    public boolean isXRoundedLabels() {
        return this.mXRoundedLabels;
    }

    public void setXRoundedLabels(boolean rounded) {
        this.mXRoundedLabels = rounded;
    }

    public void addYTextLabel(double y, String text) {
        addYTextLabel(y, text, 0);
    }

    public void removeYTextLabel(double y) {
        removeYTextLabel(y, 0);
    }

    public synchronized void addYTextLabel(double y, String text, int scale) {
        this.mYTextLabels.get(Integer.valueOf(scale)).put(Double.valueOf(y), text);
    }

    public synchronized void removeYTextLabel(double y, int scale) {
        this.mYTextLabels.get(Integer.valueOf(scale)).remove(Double.valueOf(y));
    }

    public String getYTextLabel(Double y) {
        return getYTextLabel(y, 0);
    }

    public synchronized String getYTextLabel(Double y, int scale) {
        return (String) this.mYTextLabels.get(Integer.valueOf(scale)).get(y);
    }

    public Double[] getYTextLabelLocations() {
        return getYTextLabelLocations(0);
    }

    public synchronized Double[] getYTextLabelLocations(int scale) {
        return (Double[]) this.mYTextLabels.get(Integer.valueOf(scale)).keySet().toArray(new Double[0]);
    }

    public void clearYTextLabels() {
        clearYTextLabels(0);
    }

    public synchronized void clearYTextLabels(int scale) {
        this.mYTextLabels.get(Integer.valueOf(scale)).clear();
    }

    public int getYLabels() {
        return this.mYLabels;
    }

    public void setYLabels(int yLabels) {
        this.mYLabels = yLabels;
    }

    public void setDisplayChartValues(boolean display) {
        for (SimpleSeriesRenderer renderer : getSeriesRenderers()) {
            renderer.setDisplayChartValues(display);
        }
    }

    public void setChartValuesTextSize(float textSize) {
        for (SimpleSeriesRenderer renderer : getSeriesRenderers()) {
            renderer.setChartValuesTextSize(textSize);
        }
    }

    public float getBarWidth() {
        return this.mBarWidth;
    }

    public void setBarWidth(float width) {
        this.mBarWidth = width;
    }

    public boolean isPanEnabled() {
        return isPanXEnabled() || isPanYEnabled();
    }

    public boolean isPanXEnabled() {
        return this.mPanXEnabled;
    }

    public boolean isPanYEnabled() {
        return this.mPanYEnabled;
    }

    public void setPanEnabled(boolean enabledX, boolean enabledY) {
        this.mPanXEnabled = enabledX;
        this.mPanYEnabled = enabledY;
    }

    public void setPanEnabled(boolean enabled) {
        setPanEnabled(enabled, enabled);
    }

    public boolean isZoomEnabled() {
        return isZoomXEnabled() || isZoomYEnabled();
    }

    public boolean isZoomXEnabled() {
        return this.mZoomXEnabled;
    }

    public boolean isZoomYEnabled() {
        return this.mZoomYEnabled;
    }

    public void setZoomEnabled(boolean enabledX, boolean enabledY) {
        this.mZoomXEnabled = enabledX;
        this.mZoomYEnabled = enabledY;
    }

    public double getBarsSpacing() {
        return getBarSpacing();
    }

    public double getBarSpacing() {
        return this.mBarSpacing;
    }

    public void setBarSpacing(double spacing) {
        this.mBarSpacing = spacing;
    }

    public int getMarginsColor() {
        return this.mMarginsColor;
    }

    public void setMarginsColor(int color) {
        this.mMarginsColor = color;
    }

    public int getGridColor() {
        return this.mGridColor;
    }

    public void setGridColor(int color) {
        this.mGridColor = color;
    }

    public double[] getPanLimits() {
        return this.mPanLimits;
    }

    public void setPanLimits(double[] panLimits) {
        this.mPanLimits = panLimits;
    }

    public double[] getZoomLimits() {
        return this.mZoomLimits;
    }

    public void setZoomLimits(double[] zoomLimits) {
        this.mZoomLimits = zoomLimits;
    }

    public float getXLabelsAngle() {
        return this.mXLabelsAngle;
    }

    public void setXLabelsAngle(float angle) {
        this.mXLabelsAngle = angle;
    }

    public float getYLabelsAngle() {
        return this.mYLabelsAngle;
    }

    public void setYLabelsAngle(float angle) {
        this.mYLabelsAngle = angle;
    }

    public float getPointSize() {
        return this.mPointSize;
    }

    public void setPointSize(float size) {
        this.mPointSize = size;
    }

    public void setRange(double[] range) {
        setRange(range, 0);
    }

    public void setRange(double[] range, int scale) {
        setXAxisMin(range[0], scale);
        setXAxisMax(range[1], scale);
        setYAxisMin(range[2], scale);
        setYAxisMax(range[3], scale);
    }

    public boolean isInitialRangeSet() {
        return isInitialRangeSet(0);
    }

    public boolean isInitialRangeSet(int scale) {
        return this.initialRange.get(Integer.valueOf(scale)) != null;
    }

    public double[] getInitialRange() {
        return getInitialRange(0);
    }

    public double[] getInitialRange(int scale) {
        return this.initialRange.get(Integer.valueOf(scale));
    }

    public void setInitialRange(double[] range) {
        setInitialRange(range, 0);
    }

    public void setInitialRange(double[] range, int scale) {
        this.initialRange.put(Integer.valueOf(scale), range);
    }

    public int getXLabelsColor() {
        return this.mXLabelsColor;
    }

    public int getYLabelsColor(int scale) {
        return this.mYLabelsColor[scale];
    }

    public void setXLabelsColor(int color) {
        this.mXLabelsColor = color;
    }

    public void setYLabelsColor(int scale, int color) {
        this.mYLabelsColor[scale] = color;
    }

    public Paint.Align getXLabelsAlign() {
        return this.xLabelsAlign;
    }

    public void setXLabelsAlign(Paint.Align align) {
        this.xLabelsAlign = align;
    }

    public Paint.Align getYLabelsAlign(int scale) {
        return this.yLabelsAlign[scale];
    }

    public void setYLabelsAlign(Paint.Align align) {
        setYLabelsAlign(align, 0);
    }

    public Paint.Align getYAxisAlign(int scale) {
        return this.yAxisAlign[scale];
    }

    public void setYAxisAlign(Paint.Align align, int scale) {
        this.yAxisAlign[scale] = align;
    }

    public void setYLabelsAlign(Paint.Align align, int scale) {
        this.yLabelsAlign[scale] = align;
    }

    public float getXLabelsPadding() {
        return this.mXLabelsPadding;
    }

    public void setXLabelsPadding(float padding) {
        this.mXLabelsPadding = padding;
    }

    public float getYLabelsPadding() {
        return this.mYLabelsPadding;
    }

    public void setYLabelsVerticalPadding(float padding) {
        this.mYLabelsVerticalPadding = padding;
    }

    public float getYLabelsVerticalPadding() {
        return this.mYLabelsVerticalPadding;
    }

    public void setYLabelsPadding(float padding) {
        this.mYLabelsPadding = padding;
    }

    public NumberFormat getLabelFormat() {
        return this.mLabelFormat;
    }

    public void setLabelFormat(NumberFormat format) {
        this.mLabelFormat = format;
    }

    public double getZoomInLimitX() {
        return this.mZoomInLimitX;
    }

    public void setZoomInLimitX(double zoomInLimitX) {
        this.mZoomInLimitX = zoomInLimitX;
    }

    public double getZoomInLimitY() {
        return this.mZoomInLimitY;
    }

    public void setZoomInLimitY(double zoomInLimitY) {
        this.mZoomInLimitY = zoomInLimitY;
    }

    public int getScalesCount() {
        return this.scalesCount;
    }
}
