package p000;

import java.io.IOException;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;

/* renamed from: ir */
public class C1286ir {

    /* renamed from: a */
    private final IOException f4496a;

    /* renamed from: b */
    private final Root f4497b;

    public C1286ir(IOException iOException) {
        this.f4496a = iOException;
        this.f4497b = null;
    }

    public C1286ir(Root root) {
        this.f4497b = root;
        this.f4496a = null;
    }

    /* renamed from: a */
    public IOException mo8640a() {
        return this.f4496a;
    }

    /* renamed from: b */
    public Root mo8641b() {
        return this.f4497b;
    }

    /* renamed from: c */
    public boolean mo8642c() {
        return this.f4496a != null;
    }

    /* renamed from: d */
    public boolean mo8643d() {
        return this.f4497b != null;
    }
}
