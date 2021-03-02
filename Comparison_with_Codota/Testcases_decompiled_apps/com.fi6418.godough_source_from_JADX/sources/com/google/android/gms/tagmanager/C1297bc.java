package com.google.android.gms.tagmanager;

/* renamed from: com.google.android.gms.tagmanager.bc */
class C1297bc extends Number implements Comparable<C1297bc> {

    /* renamed from: a */
    private double f5365a;

    /* renamed from: b */
    private long f5366b;

    /* renamed from: c */
    private boolean f5367c = true;

    private C1297bc(long j) {
        this.f5366b = j;
    }

    /* renamed from: a */
    public static C1297bc m5344a(long j) {
        return new C1297bc(j);
    }

    /* renamed from: a */
    public int compareTo(C1297bc bcVar) {
        return (!mo9126b() || !bcVar.mo9126b()) ? Double.compare(doubleValue(), bcVar.doubleValue()) : new Long(this.f5366b).compareTo(Long.valueOf(bcVar.f5366b));
    }

    /* renamed from: a */
    public boolean mo9125a() {
        return !mo9126b();
    }

    /* renamed from: b */
    public boolean mo9126b() {
        return this.f5367c;
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    /* renamed from: c */
    public long mo9128c() {
        return mo9126b() ? this.f5366b : (long) this.f5365a;
    }

    /* renamed from: d */
    public int mo9130d() {
        return (int) longValue();
    }

    public double doubleValue() {
        return mo9126b() ? (double) this.f5366b : this.f5365a;
    }

    /* renamed from: e */
    public short mo9132e() {
        return (short) ((int) longValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1297bc) && compareTo((C1297bc) obj) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return mo9130d();
    }

    public long longValue() {
        return mo9128c();
    }

    public short shortValue() {
        return mo9132e();
    }

    public String toString() {
        return mo9126b() ? Long.toString(this.f5366b) : Double.toString(this.f5365a);
    }
}
