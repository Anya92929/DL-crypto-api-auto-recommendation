package com.jackhenry.godough.core.login;

import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.login.ba */
public class C1656ba {

    /* renamed from: a */
    static ArrayList<C1657bb> f6395a = new ArrayList<>();

    /* renamed from: a */
    public static void m6416a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < f6395a.size()) {
                f6395a.get(i2).mo9601a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m6417a(C1657bb bbVar) {
        f6395a.add(bbVar);
    }
}
