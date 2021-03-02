package org.achartengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import org.achartengine.util.IndexXYMap;
import org.achartengine.util.XYEntry;

public class XYSeries implements Serializable {
    private static final double PADDING = 1.0E-12d;
    private List<String> mAnnotations;
    private double mMaxX;
    private double mMaxY;
    private double mMinX;
    private double mMinY;
    private final int mScaleNumber;
    private final IndexXYMap<Double, Double> mStringXY;
    private String mTitle;
    private final IndexXYMap<Double, Double> mXY;

    public XYSeries(String title) {
        this(title, 0);
    }

    public XYSeries(String title, int scaleNumber) {
        this.mXY = new IndexXYMap<>();
        this.mMinX = Double.MAX_VALUE;
        this.mMaxX = -1.7976931348623157E308d;
        this.mMinY = Double.MAX_VALUE;
        this.mMaxY = -1.7976931348623157E308d;
        this.mAnnotations = new ArrayList();
        this.mStringXY = new IndexXYMap<>();
        this.mTitle = title;
        this.mScaleNumber = scaleNumber;
        initRange();
    }

    public int getScaleNumber() {
        return this.mScaleNumber;
    }

    private void initRange() {
        this.mMinX = Double.MAX_VALUE;
        this.mMaxX = -1.7976931348623157E308d;
        this.mMinY = Double.MAX_VALUE;
        this.mMaxY = -1.7976931348623157E308d;
        int length = getItemCount();
        for (int k = 0; k < length; k++) {
            updateRange(getX(k), getY(k));
        }
    }

    private void updateRange(double x, double y) {
        this.mMinX = Math.min(this.mMinX, x);
        this.mMaxX = Math.max(this.mMaxX, x);
        this.mMinY = Math.min(this.mMinY, y);
        this.mMaxY = Math.max(this.mMaxY, y);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public synchronized void add(double x, double y) {
        while (this.mXY.get(Double.valueOf(x)) != null) {
            x += getPadding();
        }
        this.mXY.put(Double.valueOf(x), Double.valueOf(y));
        updateRange(x, y);
    }

    public synchronized void add(int index, double x, double y) {
        while (this.mXY.get(Double.valueOf(x)) != null) {
            x += getPadding();
        }
        this.mXY.put(index, Double.valueOf(x), Double.valueOf(y));
        updateRange(x, y);
    }

    /* access modifiers changed from: protected */
    public double getPadding() {
        return PADDING;
    }

    public synchronized void remove(int index) {
        XYEntry<Double, Double> removedEntry = this.mXY.removeByIndex(index);
        double removedX = removedEntry.getKey().doubleValue();
        double removedY = removedEntry.getValue().doubleValue();
        if (removedX == this.mMinX || removedX == this.mMaxX || removedY == this.mMinY || removedY == this.mMaxY) {
            initRange();
        }
    }

    public synchronized void clear() {
        this.mXY.clear();
        this.mStringXY.clear();
        initRange();
    }

    public synchronized double getX(int index) {
        return this.mXY.getXByIndex(index).doubleValue();
    }

    public synchronized double getY(int index) {
        return this.mXY.getYByIndex(index).doubleValue();
    }

    public void addAnnotation(String annotation, double x, double y) {
        this.mAnnotations.add(annotation);
        this.mStringXY.put(Double.valueOf(x), Double.valueOf(y));
    }

    public void removeAnnotation(int index) {
        this.mAnnotations.remove(index);
        this.mStringXY.removeByIndex(index);
    }

    public double getAnnotationX(int index) {
        return this.mStringXY.getXByIndex(index).doubleValue();
    }

    public double getAnnotationY(int index) {
        return this.mStringXY.getYByIndex(index).doubleValue();
    }

    public int getAnnotationCount() {
        return this.mAnnotations.size();
    }

    public String getAnnotationAt(int index) {
        return this.mAnnotations.get(index);
    }

    public synchronized SortedMap<Double, Double> getRange(double start, double stop, boolean beforeAfterPoints) {
        if (beforeAfterPoints) {
            SortedMap<Double, Double> headMap = this.mXY.headMap(Double.valueOf(start));
            if (!headMap.isEmpty()) {
                start = headMap.lastKey().doubleValue();
            }
            SortedMap<Double, Double> tailMap = this.mXY.tailMap(Double.valueOf(stop));
            if (!tailMap.isEmpty()) {
                Iterator<Double> tailIterator = tailMap.keySet().iterator();
                Double next = tailIterator.next();
                if (tailIterator.hasNext()) {
                    stop = tailIterator.next().doubleValue();
                } else {
                    stop += next.doubleValue();
                }
            }
        }
        return this.mXY.subMap(Double.valueOf(start), Double.valueOf(stop));
    }

    public int getIndexForKey(double key) {
        return this.mXY.getIndexForKey(Double.valueOf(key));
    }

    public synchronized int getItemCount() {
        return this.mXY.size();
    }

    public double getMinX() {
        return this.mMinX;
    }

    public double getMinY() {
        return this.mMinY;
    }

    public double getMaxX() {
        return this.mMaxX;
    }

    public double getMaxY() {
        return this.mMaxY;
    }
}
