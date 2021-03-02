package android.support.p021v7.p022a;

/* renamed from: android.support.v7.a.bs */
class C0472bs {

    /* renamed from: d */
    private static C0472bs f697d;

    /* renamed from: a */
    public long f698a;

    /* renamed from: b */
    public long f699b;

    /* renamed from: c */
    public int f700c;

    C0472bs() {
    }

    /* renamed from: a */
    static C0472bs m2008a() {
        if (f697d == null) {
            f697d = new C0472bs();
        }
        return f697d;
    }

    /* renamed from: a */
    public void mo2073a(long j, double d, double d2) {
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        float f2 = 6.24006f + (0.01720197f * f);
        double sin = ((double) f2) + (0.03341960161924362d * Math.sin((double) f2)) + (3.4906598739326E-4d * Math.sin((double) (2.0f * f2))) + (5.236000106378924E-6d * Math.sin((double) (3.0f * f2))) + 1.796593063d + 3.141592653589793d;
        double d3 = (-d2) / 360.0d;
        double sin2 = (Math.sin((double) f2) * 0.0053d) + d3 + ((double) (((float) Math.round(((double) (f - 9.0E-4f)) - d3)) + 9.0E-4f)) + (-0.0069d * Math.sin(2.0d * sin));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * d;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(asin))) / (Math.cos(asin) * Math.cos(d4));
        if (sin3 >= 1.0d) {
            this.f700c = 1;
            this.f698a = -1;
            this.f699b = -1;
        } else if (sin3 <= -1.0d) {
            this.f700c = 0;
            this.f698a = -1;
            this.f699b = -1;
        } else {
            float acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.f698a = Math.round((((double) acos) + sin2) * 8.64E7d) + 946728000000L;
            this.f699b = Math.round((sin2 - ((double) acos)) * 8.64E7d) + 946728000000L;
            if (this.f699b >= j || this.f698a <= j) {
                this.f700c = 1;
            } else {
                this.f700c = 0;
            }
        }
    }
}
