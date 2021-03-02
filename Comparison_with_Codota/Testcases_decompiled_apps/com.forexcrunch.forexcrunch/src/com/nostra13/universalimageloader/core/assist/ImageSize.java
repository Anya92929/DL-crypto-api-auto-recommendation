package com.nostra13.universalimageloader.core.assist;

public class ImageSize {
    private static final String TO_STRING_PATTERN = "%sx%s";
    private final int height;
    private final int width;

    public ImageSize(int width2, int height2) {
        this.width = width2;
        this.height = height2;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String toString() {
        return String.format(TO_STRING_PATTERN, new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }
}
