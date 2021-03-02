package com.jackhenry.godough.core.login;

import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.login.av */
public class C1650av {

    /* renamed from: a */
    static ArrayList<C1653ay> f6393a = new ArrayList<>();

    /* renamed from: a */
    public static void m6405a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < f6393a.size()) {
                f6393a.get(i2).mo9961a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m6406a(C1653ay ayVar) {
        f6393a.add(ayVar);
    }

    /* renamed from: b */
    public static void m6407b() {
        m6406a(new C1651aw());
        m6406a(new C1652ax());
    }
}
