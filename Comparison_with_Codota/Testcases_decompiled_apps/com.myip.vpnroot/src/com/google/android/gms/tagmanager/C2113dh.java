package com.google.android.gms.tagmanager;

/* renamed from: com.google.android.gms.tagmanager.dh */
class C2113dh extends Number implements Comparable<C2113dh> {
    private double arG;
    private long arH;
    private boolean arI = false;

    private C2113dh(double d) {
        this.arG = d;
    }

    private C2113dh(long j) {
        this.arH = j;
    }

    /* renamed from: a */
    public static C2113dh m7092a(Double d) {
        return new C2113dh(d.doubleValue());
    }

    /* renamed from: cT */
    public static C2113dh m7093cT(String str) throws NumberFormatException {
        try {
            return new C2113dh(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new C2113dh(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    /* renamed from: z */
    public static C2113dh m7094z(long j) {
        return new C2113dh(j);
    }

    /* renamed from: a */
    public int compareTo(C2113dh dhVar) {
        return (!mo11745py() || !dhVar.mo11745py()) ? Double.compare(doubleValue(), dhVar.doubleValue()) : new Long(this.arH).compareTo(Long.valueOf(dhVar.arH));
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public double doubleValue() {
        return mo11745py() ? (double) this.arH : this.arG;
    }

    public boolean equals(Object other) {
        return (other instanceof C2113dh) && compareTo((C2113dh) other) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return mo11742pA();
    }

    public long longValue() {
        return mo11746pz();
    }

    /* renamed from: pA */
    public int mo11742pA() {
        return (int) longValue();
    }

    /* renamed from: pB */
    public short mo11743pB() {
        return (short) ((int) longValue());
    }

    /* renamed from: px */
    public boolean mo11744px() {
        return !mo11745py();
    }

    /* renamed from: py */
    public boolean mo11745py() {
        return this.arI;
    }

    /* renamed from: pz */
    public long mo11746pz() {
        return mo11745py() ? this.arH : (long) this.arG;
    }

    public short shortValue() {
        return mo11743pB();
    }

    public String toString() {
        return mo11745py() ? Long.toString(this.arH) : Double.toString(this.arG);
    }
}
