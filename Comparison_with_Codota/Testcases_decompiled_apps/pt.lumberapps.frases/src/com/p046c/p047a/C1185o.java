package com.p046c.p047a;

/* renamed from: com.c.a.o */
class C1185o extends C1184n {

    /* renamed from: d */
    float f3297d;

    C1185o(float f) {
        this.f3293a = f;
        this.f3294b = Float.TYPE;
    }

    C1185o(float f, float f2) {
        this.f3293a = f;
        this.f3297d = f2;
        this.f3294b = Float.TYPE;
        this.f3295c = true;
    }

    /* renamed from: a */
    public void mo4573a(Object obj) {
        if (obj != null && obj.getClass() == Float.class) {
            this.f3297d = ((Float) obj).floatValue();
            this.f3295c = true;
        }
    }

    /* renamed from: b */
    public Object mo4575b() {
        return Float.valueOf(this.f3297d);
    }

    /* renamed from: f */
    public float mo4580f() {
        return this.f3297d;
    }

    /* renamed from: g */
    public C1185o mo4579e() {
        C1185o oVar = new C1185o(mo4576c(), this.f3297d);
        oVar.mo4572a(mo4578d());
        return oVar;
    }
}
