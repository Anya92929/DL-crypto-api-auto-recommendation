package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1722pq;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ni */
public class C1604ni {
    private int akA;
    private final ArrayList<C1606a> akz;

    /* renamed from: com.google.android.gms.internal.ni$a */
    public static class C1606a {
        public final C1609nl akB;
        public final C1603nh akC;
        public final C1722pq.C1725c akD;

        private C1606a(C1609nl nlVar, C1603nh nhVar) {
            this.akB = (C1609nl) C0348n.m861i(nlVar);
            this.akC = (C1603nh) C0348n.m861i(nhVar);
            this.akD = null;
        }
    }

    public C1604ni() {
        this(100);
    }

    public C1604ni(int i) {
        this.akz = new ArrayList<>();
        this.akA = i;
    }

    /* renamed from: mV */
    private void m5694mV() {
        while (getSize() > getCapacity()) {
            this.akz.remove(0);
        }
    }

    /* renamed from: a */
    public void mo9518a(C1609nl nlVar, C1603nh nhVar) {
        this.akz.add(new C1606a(nlVar, nhVar));
        m5694mV();
    }

    public void clear() {
        this.akz.clear();
    }

    public int getCapacity() {
        return this.akA;
    }

    public int getSize() {
        return this.akz.size();
    }

    public boolean isEmpty() {
        return this.akz.isEmpty();
    }

    /* renamed from: mU */
    public ArrayList<C1606a> mo9523mU() {
        return this.akz;
    }
}
