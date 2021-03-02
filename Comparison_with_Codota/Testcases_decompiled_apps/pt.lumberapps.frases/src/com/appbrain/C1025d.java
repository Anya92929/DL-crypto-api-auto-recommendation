package com.appbrain;

import java.io.Serializable;

/* renamed from: com.appbrain.d */
public class C1025d implements Serializable {

    /* renamed from: a */
    private transient C0982ac f2672a;

    /* renamed from: b */
    private C1099g f2673b = C1099g.SMART;

    /* renamed from: c */
    private C1033f f2674c = C1033f.SMART;

    /* renamed from: d */
    private String f2675d;

    /* renamed from: e */
    private C1027e f2676e = C1027e.DIALOG;

    /* renamed from: f */
    private C0783a f2677f;

    /* renamed from: a */
    public C1025d mo4031a(C0982ac acVar) {
        this.f2672a = acVar;
        return this;
    }

    /* renamed from: a */
    public C1025d mo4032a(C1027e eVar) {
        this.f2676e = eVar;
        return this;
    }

    /* renamed from: a */
    public C1025d mo4033a(String str) {
        this.f2675d = str;
        return this;
    }

    /* renamed from: a */
    public C1099g mo4034a() {
        return this.f2673b;
    }

    /* renamed from: a */
    public void mo4035a(C0783a aVar) {
        this.f2677f = aVar;
    }

    /* renamed from: b */
    public C1033f mo4036b() {
        return this.f2674c;
    }

    /* renamed from: c */
    public boolean mo4037c() {
        return this.f2673b == C1099g.SMART && this.f2674c == C1033f.SMART;
    }

    /* renamed from: d */
    public String mo4038d() {
        return this.f2675d;
    }

    /* renamed from: e */
    public C0982ac mo4039e() {
        return this.f2672a;
    }

    /* renamed from: f */
    public C1027e mo4040f() {
        return this.f2676e;
    }

    /* renamed from: g */
    public C0783a mo4041g() {
        return this.f2677f;
    }
}
