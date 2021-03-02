package org.p004a.p005a.p007b.p012e;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/* renamed from: org.a.a.b.e.c */
final class C0283c extends ThreadLocal {
    C0283c() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return new SoftReference(new HashMap());
    }
}
