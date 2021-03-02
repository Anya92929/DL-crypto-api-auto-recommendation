package com.viewpagerindicator;

/* renamed from: com.viewpagerindicator.k */
public enum C2017k {
    Bottom(0),
    Top(1);
    

    /* renamed from: c */
    public final int f7646c;

    private C2017k(int i) {
        this.f7646c = i;
    }

    /* renamed from: a */
    public static C2017k m8265a(int i) {
        for (C2017k kVar : values()) {
            if (kVar.f7646c == i) {
                return kVar;
            }
        }
        return null;
    }
}
