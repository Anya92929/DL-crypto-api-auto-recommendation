package org.achartengine.chart;

import android.graphics.RectF;

public class ClickableArea {
    private RectF rect;

    /* renamed from: x */
    private double f1763x;

    /* renamed from: y */
    private double f1764y;

    public ClickableArea(RectF rect2, double x, double y) {
        this.rect = rect2;
        this.f1763x = x;
        this.f1764y = y;
    }

    public RectF getRect() {
        return this.rect;
    }

    public double getX() {
        return this.f1763x;
    }

    public double getY() {
        return this.f1764y;
    }
}
