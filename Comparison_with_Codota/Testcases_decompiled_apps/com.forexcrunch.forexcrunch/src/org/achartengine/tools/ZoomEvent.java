package org.achartengine.tools;

public class ZoomEvent {
    private boolean mZoomIn;
    private float mZoomRate;

    public ZoomEvent(boolean in, float rate) {
        this.mZoomIn = in;
        this.mZoomRate = rate;
    }

    public boolean isZoomIn() {
        return this.mZoomIn;
    }

    public float getZoomRate() {
        return this.mZoomRate;
    }
}
