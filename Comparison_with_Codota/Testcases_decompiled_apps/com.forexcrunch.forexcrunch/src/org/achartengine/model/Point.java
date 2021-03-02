package org.achartengine.model;

import java.io.Serializable;

public final class Point implements Serializable {

    /* renamed from: mX */
    private float f1770mX;

    /* renamed from: mY */
    private float f1771mY;

    public Point() {
    }

    public Point(float x, float y) {
        this.f1770mX = x;
        this.f1771mY = y;
    }

    public float getX() {
        return this.f1770mX;
    }

    public float getY() {
        return this.f1771mY;
    }

    public void setX(float x) {
        this.f1770mX = x;
    }

    public void setY(float y) {
        this.f1771mY = y;
    }
}
