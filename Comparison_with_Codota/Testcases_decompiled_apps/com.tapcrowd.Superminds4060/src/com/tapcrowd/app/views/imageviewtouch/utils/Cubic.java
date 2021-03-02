package com.tapcrowd.app.views.imageviewtouch.utils;

public class Cubic implements Easing {
    public double easeOut(double time, double start, double end, double duration) {
        double time2 = (time / duration) - 1.0d;
        return (((time2 * time2 * time2) + 1.0d) * end) + start;
    }

    public double easeIn(double time, double start, double end, double duration) {
        double time2 = time / duration;
        return (end * time2 * time2 * time2) + start;
    }

    public double easeInOut(double time, double start, double end, double duration) {
        double time2 = time / (duration / 2.0d);
        if (time2 < 1.0d) {
            return ((end / 2.0d) * time2 * time2 * time2) + start;
        }
        double time3 = time2 - 2.0d;
        return ((end / 2.0d) * ((time3 * time3 * time3) + 2.0d)) + start;
    }
}
