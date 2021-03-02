package com.appbrain.p038g;

import com.appbrain.p039h.C1109b;
import com.appbrain.p039h.C1113f;

/* renamed from: com.appbrain.g.f */
public final class C1105f {

    /* renamed from: a */
    private final C1106g f3080a;

    /* renamed from: b */
    private final C1101b f3081b = new C1101b();

    public C1105f(C1106g gVar) {
        this.f3080a = gVar;
    }

    /* renamed from: a */
    public final C1109b mo4381a(C1109b bVar) {
        return this.f3080a.mo4375a(bVar);
    }

    /* renamed from: b */
    public final void mo4382b(C1109b bVar) {
        if (bVar.mo4405q() == C1113f.INTEGRITY_ONLY) {
            this.f3081b.mo4376b(bVar);
        } else {
            this.f3080a.mo4376b(bVar);
        }
    }
}
