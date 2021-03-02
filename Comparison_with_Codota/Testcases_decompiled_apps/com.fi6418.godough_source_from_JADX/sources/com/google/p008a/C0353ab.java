package com.google.p008a;

import com.google.p008a.p010b.C0366a;
import com.google.p008a.p010b.C0462v;
import java.math.BigInteger;

/* renamed from: com.google.a.ab */
public final class C0353ab extends C0493w {

    /* renamed from: a */
    private static final Class<?>[] f3365a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b */
    private Object f3366b;

    public C0353ab(Boolean bool) {
        mo6297a((Object) bool);
    }

    public C0353ab(Number number) {
        mo6297a((Object) number);
    }

    public C0353ab(String str) {
        mo6297a((Object) str);
    }

    /* renamed from: a */
    private static boolean m2485a(C0353ab abVar) {
        if (!(abVar.f3366b instanceof Number)) {
            return false;
        }
        Number number = (Number) abVar.f3366b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    /* renamed from: b */
    private static boolean m2486b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> isAssignableFrom : f3365a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public Number mo6296a() {
        return this.f3366b instanceof String ? new C0462v((String) this.f3366b) : (Number) this.f3366b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6297a(Object obj) {
        if (obj instanceof Character) {
            this.f3366b = String.valueOf(((Character) obj).charValue());
            return;
        }
        C0366a.m2512a((obj instanceof Number) || m2486b(obj));
        this.f3366b = obj;
    }

    /* renamed from: b */
    public String mo6298b() {
        return mo6307p() ? mo6296a().toString() : mo6306o() ? mo6305n().toString() : (String) this.f3366b;
    }

    /* renamed from: c */
    public double mo6299c() {
        return mo6307p() ? mo6296a().doubleValue() : Double.parseDouble(mo6298b());
    }

    /* renamed from: d */
    public long mo6300d() {
        return mo6307p() ? mo6296a().longValue() : Long.parseLong(mo6298b());
    }

    /* renamed from: e */
    public int mo6301e() {
        return mo6307p() ? mo6296a().intValue() : Integer.parseInt(mo6298b());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0353ab abVar = (C0353ab) obj;
        if (this.f3366b == null) {
            return abVar.f3366b == null;
        }
        if (m2485a(this) && m2485a(abVar)) {
            return mo6296a().longValue() == abVar.mo6296a().longValue();
        }
        if (!(this.f3366b instanceof Number) || !(abVar.f3366b instanceof Number)) {
            return this.f3366b.equals(abVar.f3366b);
        }
        double doubleValue = mo6296a().doubleValue();
        double doubleValue2 = abVar.mo6296a().doubleValue();
        if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public boolean mo6303f() {
        return mo6306o() ? mo6305n().booleanValue() : Boolean.parseBoolean(mo6298b());
    }

    public int hashCode() {
        if (this.f3366b == null) {
            return 31;
        }
        if (m2485a(this)) {
            long longValue = mo6296a().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f3366b instanceof Number)) {
            return this.f3366b.hashCode();
        } else {
            long doubleToLongBits = Double.doubleToLongBits(mo6296a().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public Boolean mo6305n() {
        return (Boolean) this.f3366b;
    }

    /* renamed from: o */
    public boolean mo6306o() {
        return this.f3366b instanceof Boolean;
    }

    /* renamed from: p */
    public boolean mo6307p() {
        return this.f3366b instanceof Number;
    }

    /* renamed from: q */
    public boolean mo6308q() {
        return this.f3366b instanceof String;
    }
}
