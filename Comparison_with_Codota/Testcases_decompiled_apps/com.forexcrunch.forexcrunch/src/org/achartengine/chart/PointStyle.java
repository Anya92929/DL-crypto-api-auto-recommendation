package org.achartengine.chart;

public enum PointStyle {
    X("x"),
    CIRCLE("circle"),
    TRIANGLE("triangle"),
    SQUARE("square"),
    DIAMOND("diamond"),
    POINT("point");
    
    private String mName;

    private PointStyle(String name) {
        this.mName = name;
    }

    public String getName() {
        return this.mName;
    }

    public String toString() {
        return getName();
    }

    public static PointStyle getPointStyleForName(String name) {
        PointStyle pointStyle = null;
        PointStyle[] styles = values();
        int length = styles.length;
        for (int i = 0; i < length && pointStyle == null; i++) {
            if (styles[i].mName.equals(name)) {
                pointStyle = styles[i];
            }
        }
        return pointStyle;
    }

    public static int getIndexForName(String name) {
        int index = -1;
        PointStyle[] styles = values();
        int length = styles.length;
        for (int i = 0; i < length && index < 0; i++) {
            if (styles[i].mName.equals(name)) {
                index = i;
            }
        }
        return Math.max(0, index);
    }
}
