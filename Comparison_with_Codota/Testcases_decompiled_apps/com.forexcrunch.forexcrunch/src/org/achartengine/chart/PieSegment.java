package org.achartengine.chart;

import java.io.Serializable;

public class PieSegment implements Serializable {
    private int mDataIndex;
    private float mEndAngle;
    private float mStartAngle;
    private float mValue;

    public PieSegment(int dataIndex, float value, float startAngle, float angle) {
        this.mStartAngle = startAngle;
        this.mEndAngle = angle + startAngle;
        this.mDataIndex = dataIndex;
        this.mValue = value;
    }

    public boolean isInSegment(double angle) {
        if (angle >= ((double) this.mStartAngle) && angle <= ((double) this.mEndAngle)) {
            return true;
        }
        double cAngle = angle % 360.0d;
        double startAngle = (double) this.mStartAngle;
        double stopAngle = (double) this.mEndAngle;
        while (stopAngle > 360.0d) {
            startAngle -= 360.0d;
            stopAngle -= 360.0d;
        }
        if (cAngle < startAngle || cAngle > stopAngle) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public float getStartAngle() {
        return this.mStartAngle;
    }

    /* access modifiers changed from: protected */
    public float getEndAngle() {
        return this.mEndAngle;
    }

    /* access modifiers changed from: protected */
    public int getDataIndex() {
        return this.mDataIndex;
    }

    /* access modifiers changed from: protected */
    public float getValue() {
        return this.mValue;
    }

    public String toString() {
        return "mDataIndex=" + this.mDataIndex + ",mValue=" + this.mValue + ",mStartAngle=" + this.mStartAngle + ",mEndAngle=" + this.mEndAngle;
    }
}
