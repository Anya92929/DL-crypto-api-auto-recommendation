package com.appbrain.p033b;

import java.util.Arrays;
import java.util.Stack;

/* renamed from: com.appbrain.b.ad */
final class C0989ad {

    /* renamed from: a */
    private final Stack f2605a;

    private C0989ad() {
        this.f2605a = new Stack();
    }

    /* synthetic */ C0989ad(byte b) {
        this();
    }

    /* renamed from: a */
    private static int m4126a(int i) {
        int binarySearch = Arrays.binarySearch(C0988ac.f2598c, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* renamed from: a */
    static /* synthetic */ C1002f m4127a(C0989ad adVar, C1002f fVar, C1002f fVar2) {
        adVar.m4128a(fVar);
        adVar.m4128a(fVar2);
        C0988ac acVar = (C1002f) adVar.f2605a.pop();
        while (!adVar.f2605a.isEmpty()) {
            acVar = new C0988ac((C1002f) adVar.f2605a.pop(), acVar, (byte) 0);
        }
        return acVar;
    }

    /* renamed from: a */
    private void m4128a(C1002f fVar) {
        C1002f fVar2 = fVar;
        while (!fVar2.mo3930i()) {
            if (fVar2 instanceof C0988ac) {
                C0988ac acVar = (C0988ac) fVar2;
                m4128a(acVar.f2600e);
                fVar2 = acVar.f2601f;
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + fVar2.getClass());
            }
        }
        int a = m4126a(fVar2.mo3919a());
        int i = C0988ac.f2598c[a + 1];
        if (this.f2605a.isEmpty() || ((C1002f) this.f2605a.peek()).mo3919a() >= i) {
            this.f2605a.push(fVar2);
            return;
        }
        int i2 = C0988ac.f2598c[a];
        C0988ac acVar2 = (C1002f) this.f2605a.pop();
        while (!this.f2605a.isEmpty() && ((C1002f) this.f2605a.peek()).mo3919a() < i2) {
            acVar2 = new C0988ac((C1002f) this.f2605a.pop(), acVar2, (byte) 0);
        }
        C0988ac acVar3 = new C0988ac(acVar2, fVar2, (byte) 0);
        while (!this.f2605a.isEmpty()) {
            if (((C1002f) this.f2605a.peek()).mo3919a() >= C0988ac.f2598c[m4126a(acVar3.mo3919a()) + 1]) {
                break;
            }
            acVar3 = new C0988ac((C1002f) this.f2605a.pop(), acVar3, (byte) 0);
        }
        this.f2605a.push(acVar3);
    }
}
