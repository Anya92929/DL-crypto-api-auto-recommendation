package org.achartengine.renderer;

import android.graphics.Paint;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.Serializable;

public class BasicStroke implements Serializable {
    public static final BasicStroke DASHED = new BasicStroke(Paint.Cap.ROUND, Paint.Join.BEVEL, 10.0f, new float[]{10.0f, 10.0f}, 1.0f);
    public static final BasicStroke DOTTED = new BasicStroke(Paint.Cap.ROUND, Paint.Join.BEVEL, 5.0f, new float[]{2.0f, 10.0f}, 1.0f);
    public static final BasicStroke SOLID = new BasicStroke(Paint.Cap.BUTT, Paint.Join.MITER, 4.0f, (float[]) null, BitmapDescriptorFactory.HUE_RED);
    private Paint.Cap mCap;
    private float[] mIntervals;
    private Paint.Join mJoin;
    private float mMiter;
    private float mPhase;

    public BasicStroke(Paint.Cap cap, Paint.Join join, float miter, float[] intervals, float phase) {
        this.mCap = cap;
        this.mJoin = join;
        this.mMiter = miter;
        this.mIntervals = intervals;
    }

    public Paint.Cap getCap() {
        return this.mCap;
    }

    public Paint.Join getJoin() {
        return this.mJoin;
    }

    public float getMiter() {
        return this.mMiter;
    }

    public float[] getIntervals() {
        return this.mIntervals;
    }

    public float getPhase() {
        return this.mPhase;
    }
}
