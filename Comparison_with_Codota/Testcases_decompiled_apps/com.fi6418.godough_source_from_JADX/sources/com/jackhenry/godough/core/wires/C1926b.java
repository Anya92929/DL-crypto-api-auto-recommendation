package com.jackhenry.godough.core.wires;

import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.Wire;

/* renamed from: com.jackhenry.godough.core.wires.b */
public class C1926b extends C1757n<Wire> {

    /* renamed from: e */
    private String f6901e;

    public C1926b(Wire wire, String str, C1759p<Wire> pVar) {
        super(wire, pVar);
        this.f6901e = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Wire mo9592a(Void... voidArr) {
        this.f6512c = new C1925a().mo11201a((Wire) this.f6512c, this.f6901e);
        return (Wire) this.f6512c;
    }
}
