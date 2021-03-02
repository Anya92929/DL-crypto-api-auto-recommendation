package p000;

/* renamed from: hm */
public class C1210hm {
    /* renamed from: a */
    public static double m5290a(double d, double d2, double d3) {
        if (d < d2) {
            return d2;
        }
        return d > d3 ? d3 : d;
    }

    /* renamed from: b */
    public static double m5293b(double d, double d2, double d3) {
        return (d < d2 || d >= d3) ? m5289a(d - d2, d3 - d2) + d2 : d;
    }

    /* renamed from: a */
    static double m5289a(double d, double d2) {
        return ((d % d2) + d2) % d2;
    }

    /* renamed from: a */
    public static double m5288a(double d) {
        return Math.log(Math.tan((0.5d * d) + 0.7853981633974483d));
    }

    /* renamed from: b */
    public static double m5291b(double d) {
        return (2.0d * Math.atan(Math.exp(d))) - 1.5707963267948966d;
    }

    /* renamed from: c */
    public static double m5294c(double d) {
        double sin = Math.sin(0.5d * d);
        return sin * sin;
    }

    /* renamed from: d */
    public static double m5296d(double d) {
        return 2.0d * Math.asin(Math.sqrt(d));
    }

    /* renamed from: e */
    public static double m5297e(double d) {
        return 2.0d * Math.sqrt((1.0d - d) * d);
    }

    /* renamed from: f */
    public static double m5298f(double d) {
        double d2 = d * d;
        return (d2 / (Math.sqrt(1.0d - d2) + 1.0d)) * 0.5d;
    }

    /* renamed from: b */
    public static double m5292b(double d, double d2) {
        double sqrt = Math.sqrt((1.0d - d) * d);
        double sqrt2 = Math.sqrt((1.0d - d2) * d2);
        return ((sqrt + sqrt2) - (((sqrt * d2) + (sqrt2 * d)) * 2.0d)) * 2.0d;
    }

    /* renamed from: c */
    public static double m5295c(double d, double d2, double d3) {
        return m5294c(d - d2) + (m5294c(d3) * Math.cos(d) * Math.cos(d2));
    }
}
