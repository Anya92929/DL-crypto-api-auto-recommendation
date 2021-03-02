package org.achartengine.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MathHelper {
    private static final NumberFormat FORMAT = NumberFormat.getNumberInstance();
    public static final double NULL_VALUE = Double.MAX_VALUE;

    private MathHelper() {
    }

    public static double[] minmax(List<Double> values) {
        if (values.size() == 0) {
            return new double[2];
        }
        double min = values.get(0).doubleValue();
        double max = min;
        int length = values.size();
        for (int i = 1; i < length; i++) {
            double value = values.get(i).doubleValue();
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return new double[]{min, max};
    }

    public static List<Double> getLabels(double start, double end, int approxNumLabels) {
        List<Double> labels = new ArrayList<>();
        if (approxNumLabels > 0) {
            FORMAT.setMaximumFractionDigits(5);
            double[] labelParams = computeLabels(start, end, approxNumLabels);
            int numLabels = ((int) ((labelParams[1] - labelParams[0]) / labelParams[2])) + 1;
            for (int i = 0; i < numLabels; i++) {
                double z = labelParams[0] + (((double) i) * labelParams[2]);
                try {
                    z = FORMAT.parse(FORMAT.format(z)).doubleValue();
                } catch (ParseException e) {
                }
                labels.add(Double.valueOf(z));
            }
        }
        return labels;
    }

    private static double[] computeLabels(double start, double end, int approxNumLabels) {
        if (Math.abs(start - end) < 1.0000000116860974E-7d) {
            return new double[]{start, start, 0.0d};
        }
        double s = start;
        double e = end;
        boolean switched = false;
        if (s > e) {
            switched = true;
            double tmp = s;
            s = e;
            e = tmp;
        }
        double xStep = roundUp(Math.abs(s - e) / ((double) approxNumLabels));
        double xStart = xStep * Math.ceil(s / xStep);
        double xEnd = xStep * Math.floor(e / xStep);
        if (switched) {
            return new double[]{xEnd, xStart, -1.0d * xStep};
        }
        return new double[]{xStart, xEnd, xStep};
    }

    private static double roundUp(double val) {
        int exponent = (int) Math.floor(Math.log10(val));
        double rval = val * Math.pow(10.0d, (double) (-exponent));
        if (rval > 5.0d) {
            rval = 10.0d;
        } else if (rval > 2.0d) {
            rval = 5.0d;
        } else if (rval > 1.0d) {
            rval = 2.0d;
        }
        return rval * Math.pow(10.0d, (double) exponent);
    }
}
