package com.google.p008a;

import com.google.p008a.p010b.p011a.C0410j;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;
import java.io.IOException;

/* renamed from: com.google.a.al */
public abstract class C0363al<T> {
    /* renamed from: a */
    public final C0493w mo6312a(T t) {
        try {
            C0410j jVar = new C0410j();
            mo6309a(jVar, t);
            return jVar.mo6398a();
        } catch (IOException e) {
            throw new C0494x((Throwable) e);
        }
    }

    /* renamed from: a */
    public abstract void mo6309a(C0473d dVar, T t);

    /* renamed from: b */
    public abstract T mo6310b(C0470a aVar);
}
