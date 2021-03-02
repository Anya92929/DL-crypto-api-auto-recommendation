package com.jackhenry.godough.core.model;

public class ImageTextArrowRow {
    private int clickId;
    private int drawableId;
    private String text;

    public ImageTextArrowRow(int i, String str, int i2) {
        this.clickId = i;
        this.drawableId = i2;
        this.text = str;
    }

    public int getDrawableId() {
        return this.drawableId;
    }

    public int getId() {
        return this.clickId;
    }

    public String getText() {
        return this.text;
    }
}
