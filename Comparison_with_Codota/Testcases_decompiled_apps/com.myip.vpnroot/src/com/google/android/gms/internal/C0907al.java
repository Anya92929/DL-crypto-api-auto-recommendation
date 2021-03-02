package com.google.android.gms.internal;

import android.support.p000v4.widget.ExploreByTouchHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@C1130ez
/* renamed from: com.google.android.gms.internal.al */
public class C0907al {

    /* renamed from: mw */
    private final Object f2571mw = new Object();

    /* renamed from: np */
    private int f2572np;

    /* renamed from: nq */
    private List<C0906ak> f2573nq = new LinkedList();

    /* renamed from: a */
    public boolean mo7973a(C0906ak akVar) {
        boolean z;
        synchronized (this.f2571mw) {
            z = this.f2573nq.contains(akVar);
        }
        return z;
    }

    /* renamed from: aU */
    public C0906ak mo7974aU() {
        int i;
        C0906ak akVar;
        C0906ak akVar2 = null;
        synchronized (this.f2571mw) {
            if (this.f2573nq.size() == 0) {
                C1229gs.m4675S("Queue empty");
                return null;
            } else if (this.f2573nq.size() >= 2) {
                int i2 = ExploreByTouchHelper.INVALID_ID;
                for (C0906ak next : this.f2573nq) {
                    int score = next.getScore();
                    if (score > i2) {
                        int i3 = score;
                        akVar = next;
                        i = i3;
                    } else {
                        i = i2;
                        akVar = akVar2;
                    }
                    i2 = i;
                    akVar2 = akVar;
                }
                this.f2573nq.remove(akVar2);
                return akVar2;
            } else {
                C0906ak akVar3 = this.f2573nq.get(0);
                akVar3.mo7961aP();
                return akVar3;
            }
        }
    }

    /* renamed from: b */
    public boolean mo7975b(C0906ak akVar) {
        boolean z;
        synchronized (this.f2571mw) {
            Iterator<C0906ak> it = this.f2573nq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                C0906ak next = it.next();
                if (akVar != next && next.mo7960aO().equals(akVar.mo7960aO())) {
                    this.f2573nq.remove(akVar);
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    public void mo7976c(C0906ak akVar) {
        synchronized (this.f2571mw) {
            if (this.f2573nq.size() >= 10) {
                C1229gs.m4675S("Queue is full, current size = " + this.f2573nq.size());
                this.f2573nq.remove(0);
            }
            int i = this.f2572np;
            this.f2572np = i + 1;
            akVar.mo7966c(i);
            this.f2573nq.add(akVar);
        }
    }
}
