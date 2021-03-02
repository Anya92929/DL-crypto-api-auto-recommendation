package com.viewpagerindicator;

/* renamed from: com.viewpagerindicator.j */
public enum C2016j {
    None(0),
    Triangle(1),
    Underline(2);
    

    /* renamed from: d */
    public final int f7642d;

    private C2016j(int i) {
        this.f7642d = i;
    }

    /* renamed from: a */
    public static C2016j m8264a(int i) {
        for (C2016j jVar : values()) {
            if (jVar.f7642d == i) {
                return jVar;
            }
        }
        return null;
    }
}
