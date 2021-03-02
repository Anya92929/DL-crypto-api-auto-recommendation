package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

@C1130ez
/* renamed from: com.google.android.gms.internal.ae */
public final class C0887ae implements C0896ag {

    /* renamed from: mw */
    private final Object f2511mw = new Object();

    /* renamed from: mx */
    private final WeakHashMap<C1196fz, C0888af> f2512mx = new WeakHashMap<>();

    /* renamed from: my */
    private final ArrayList<C0888af> f2513my = new ArrayList<>();

    /* renamed from: a */
    public C0888af mo7902a(Context context, C0927ay ayVar, C1196fz fzVar, View view, C1230gt gtVar) {
        C0888af afVar;
        synchronized (this.f2511mw) {
            if (mo7905c(fzVar)) {
                afVar = this.f2512mx.get(fzVar);
            } else {
                afVar = new C0888af(context, ayVar, fzVar, view, gtVar);
                afVar.mo7913a((C0896ag) this);
                this.f2512mx.put(fzVar, afVar);
                this.f2513my.add(afVar);
            }
        }
        return afVar;
    }

    /* renamed from: a */
    public C0888af mo7903a(C0927ay ayVar, C1196fz fzVar) {
        return mo7902a(fzVar.f3672rN.getContext(), ayVar, fzVar, fzVar.f3672rN, fzVar.f3672rN.mo8634dy());
    }

    /* renamed from: a */
    public void mo7904a(C0888af afVar) {
        synchronized (this.f2511mw) {
            if (!afVar.mo7921aH()) {
                this.f2513my.remove(afVar);
            }
        }
    }

    /* renamed from: c */
    public boolean mo7905c(C1196fz fzVar) {
        boolean z;
        synchronized (this.f2511mw) {
            C0888af afVar = this.f2512mx.get(fzVar);
            z = afVar != null && afVar.mo7921aH();
        }
        return z;
    }

    /* renamed from: d */
    public void mo7906d(C1196fz fzVar) {
        synchronized (this.f2511mw) {
            C0888af afVar = this.f2512mx.get(fzVar);
            if (afVar != null) {
                afVar.mo7919aF();
            }
        }
    }

    public void pause() {
        synchronized (this.f2511mw) {
            Iterator<C0888af> it = this.f2513my.iterator();
            while (it.hasNext()) {
                it.next().pause();
            }
        }
    }

    public void resume() {
        synchronized (this.f2511mw) {
            Iterator<C0888af> it = this.f2513my.iterator();
            while (it.hasNext()) {
                it.next().resume();
            }
        }
    }

    public void stop() {
        synchronized (this.f2511mw) {
            Iterator<C0888af> it = this.f2513my.iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }
}
