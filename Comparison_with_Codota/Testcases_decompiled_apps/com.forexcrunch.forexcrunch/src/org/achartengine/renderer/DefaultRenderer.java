package org.achartengine.renderer;

import android.graphics.Typeface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DefaultRenderer implements Serializable {
    public static final int BACKGROUND_COLOR = -16777216;
    public static final int NO_COLOR = 0;
    private static final Typeface REGULAR_TEXT_FONT = Typeface.create(Typeface.SERIF, 0);
    public static final int TEXT_COLOR = -3355444;
    private boolean mAntialiasing = true;
    private boolean mApplyBackgroundColor;
    private int mAxesColor = TEXT_COLOR;
    private int mBackgroundColor;
    private String mChartTitle = "";
    private float mChartTitleTextSize = 15.0f;
    private boolean mClickEnabled = false;
    private boolean mDisplayValues;
    private boolean mExternalZoomEnabled = false;
    private boolean mFitLegend = false;
    private boolean mInScroll;
    private int mLabelsColor = TEXT_COLOR;
    private float mLabelsTextSize = 10.0f;
    private int mLegendHeight = 0;
    private float mLegendTextSize = 12.0f;
    private int[] mMargins = {20, 30, 10, 20};
    private float mOriginalScale = this.mScale;
    private boolean mPanEnabled = true;
    private List<SimpleSeriesRenderer> mRenderers = new ArrayList();
    private float mScale = 1.0f;
    private boolean mShowAxes = true;
    private boolean mShowCustomTextGrid = false;
    private boolean mShowGridX = false;
    private boolean mShowGridY = false;
    private boolean mShowLabels = true;
    private boolean mShowLegend = true;
    private float mStartAngle = BitmapDescriptorFactory.HUE_RED;
    private Typeface mTextTypeface;
    private String mTextTypefaceName = REGULAR_TEXT_FONT.toString();
    private int mTextTypefaceStyle = 0;
    private boolean mZoomButtonsVisible = false;
    private boolean mZoomEnabled = true;
    private float mZoomRate = 1.5f;
    private int selectableBuffer = 15;

    public String getChartTitle() {
        return this.mChartTitle;
    }

    public void setChartTitle(String title) {
        this.mChartTitle = title;
    }

    public float getChartTitleTextSize() {
        return this.mChartTitleTextSize;
    }

    public void setChartTitleTextSize(float textSize) {
        this.mChartTitleTextSize = textSize;
    }

    public void addSeriesRenderer(SimpleSeriesRenderer renderer) {
        this.mRenderers.add(renderer);
    }

    public void addSeriesRenderer(int index, SimpleSeriesRenderer renderer) {
        this.mRenderers.add(index, renderer);
    }

    public void removeSeriesRenderer(SimpleSeriesRenderer renderer) {
        this.mRenderers.remove(renderer);
    }

    public void removeAllRenderers() {
        this.mRenderers.clear();
    }

    public SimpleSeriesRenderer getSeriesRendererAt(int index) {
        return this.mRenderers.get(index);
    }

    public int getSeriesRendererCount() {
        return this.mRenderers.size();
    }

    public SimpleSeriesRenderer[] getSeriesRenderers() {
        return (SimpleSeriesRenderer[]) this.mRenderers.toArray(new SimpleSeriesRenderer[0]);
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setBackgroundColor(int color) {
        this.mBackgroundColor = color;
    }

    public boolean isApplyBackgroundColor() {
        return this.mApplyBackgroundColor;
    }

    public void setApplyBackgroundColor(boolean apply) {
        this.mApplyBackgroundColor = apply;
    }

    public int getAxesColor() {
        return this.mAxesColor;
    }

    public void setAxesColor(int color) {
        this.mAxesColor = color;
    }

    public int getLabelsColor() {
        return this.mLabelsColor;
    }

    public void setLabelsColor(int color) {
        this.mLabelsColor = color;
    }

    public float getLabelsTextSize() {
        return this.mLabelsTextSize;
    }

    public void setLabelsTextSize(float textSize) {
        this.mLabelsTextSize = textSize;
    }

    public boolean isShowAxes() {
        return this.mShowAxes;
    }

    public void setShowAxes(boolean showAxes) {
        this.mShowAxes = showAxes;
    }

    public boolean isShowLabels() {
        return this.mShowLabels;
    }

    public void setShowLabels(boolean showLabels) {
        this.mShowLabels = showLabels;
    }

    public boolean isShowGridX() {
        return this.mShowGridX;
    }

    public boolean isShowGridY() {
        return this.mShowGridY;
    }

    public void setShowGridX(boolean showGrid) {
        this.mShowGridX = showGrid;
    }

    public void setShowGridY(boolean showGrid) {
        this.mShowGridY = showGrid;
    }

    public void setShowGrid(boolean showGrid) {
        setShowGridX(showGrid);
        setShowGridY(showGrid);
    }

    public boolean isShowCustomTextGrid() {
        return this.mShowCustomTextGrid;
    }

    public void setShowCustomTextGrid(boolean showGrid) {
        this.mShowCustomTextGrid = showGrid;
    }

    public boolean isShowLegend() {
        return this.mShowLegend;
    }

    public void setShowLegend(boolean showLegend) {
        this.mShowLegend = showLegend;
    }

    public boolean isFitLegend() {
        return this.mFitLegend;
    }

    public void setFitLegend(boolean fit) {
        this.mFitLegend = fit;
    }

    public String getTextTypefaceName() {
        return this.mTextTypefaceName;
    }

    public int getTextTypefaceStyle() {
        return this.mTextTypefaceStyle;
    }

    public Typeface getTextTypeface() {
        return this.mTextTypeface;
    }

    public float getLegendTextSize() {
        return this.mLegendTextSize;
    }

    public void setLegendTextSize(float textSize) {
        this.mLegendTextSize = textSize;
    }

    public void setTextTypeface(String typefaceName, int style) {
        this.mTextTypefaceName = typefaceName;
        this.mTextTypefaceStyle = style;
    }

    public void setTextTypeface(Typeface typeface) {
        this.mTextTypeface = typeface;
    }

    public boolean isAntialiasing() {
        return this.mAntialiasing;
    }

    public void setAntialiasing(boolean antialiasing) {
        this.mAntialiasing = antialiasing;
    }

    public float getScale() {
        return this.mScale;
    }

    public float getOriginalScale() {
        return this.mOriginalScale;
    }

    public void setScale(float scale) {
        this.mScale = scale;
    }

    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    public void setZoomEnabled(boolean enabled) {
        this.mZoomEnabled = enabled;
    }

    public boolean isZoomButtonsVisible() {
        return this.mZoomButtonsVisible;
    }

    public void setZoomButtonsVisible(boolean visible) {
        this.mZoomButtonsVisible = visible;
    }

    public boolean isExternalZoomEnabled() {
        return this.mExternalZoomEnabled;
    }

    public void setExternalZoomEnabled(boolean enabled) {
        this.mExternalZoomEnabled = enabled;
    }

    public float getZoomRate() {
        return this.mZoomRate;
    }

    public boolean isPanEnabled() {
        return this.mPanEnabled;
    }

    public void setPanEnabled(boolean enabled) {
        this.mPanEnabled = enabled;
    }

    public void setZoomRate(float rate) {
        this.mZoomRate = rate;
    }

    public boolean isClickEnabled() {
        return this.mClickEnabled;
    }

    public void setClickEnabled(boolean enabled) {
        this.mClickEnabled = enabled;
    }

    public int getSelectableBuffer() {
        return this.selectableBuffer;
    }

    public void setSelectableBuffer(int buffer) {
        this.selectableBuffer = buffer;
    }

    public int getLegendHeight() {
        return this.mLegendHeight;
    }

    public void setLegendHeight(int height) {
        this.mLegendHeight = height;
    }

    public int[] getMargins() {
        return this.mMargins;
    }

    public void setMargins(int[] margins) {
        this.mMargins = margins;
    }

    public boolean isInScroll() {
        return this.mInScroll;
    }

    public void setInScroll(boolean inScroll) {
        this.mInScroll = inScroll;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public void setStartAngle(float startAngle) {
        this.mStartAngle = startAngle;
    }

    public boolean isDisplayValues() {
        return this.mDisplayValues;
    }

    public void setDisplayValues(boolean display) {
        this.mDisplayValues = display;
    }
}
