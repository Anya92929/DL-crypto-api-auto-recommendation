package org.p004a.p005a;

import java.io.Serializable;

/* renamed from: org.a.a.v */
public final class C0573v extends C0241ac implements Serializable {

    /* renamed from: a */
    public static final C0573v f644a = new C0573v(1, 0);

    /* renamed from: b */
    public static final C0573v f645b = new C0573v(1, 1);

    /* renamed from: e */
    private static C0573v f646e = new C0573v(0, 9);

    private C0573v(int i, int i2) {
        super("HTTP", i, i2);
    }

    /* renamed from: a */
    public final C0241ac mo4855a(int i, int i2) {
        if (i == this.f48c && i2 == this.f49d) {
            return this;
        }
        if (i == 1) {
            if (i2 == 0) {
                return f644a;
            }
            if (i2 == 1) {
                return f645b;
            }
        }
        return (i == 0 && i2 == 9) ? f646e : new C0573v(i, i2);
    }
}
