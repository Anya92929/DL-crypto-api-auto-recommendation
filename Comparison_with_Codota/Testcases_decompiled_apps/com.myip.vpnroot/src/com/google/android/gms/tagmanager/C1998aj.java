package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1026d;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.aj */
abstract class C1998aj {
    private final Set<String> aoY;
    private final String aoZ;

    public C1998aj(String str, String... strArr) {
        this.aoZ = str;
        this.aoY = new HashSet(strArr.length);
        for (String add : strArr) {
            this.aoY.add(add);
        }
    }

    /* renamed from: C */
    public abstract C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo11548a(Set<String> set) {
        return set.containsAll(this.aoY);
    }

    /* renamed from: nL */
    public abstract boolean mo11538nL();

    /* renamed from: op */
    public String mo11549op() {
        return this.aoZ;
    }

    /* renamed from: oq */
    public Set<String> mo11550oq() {
        return this.aoY;
    }
}
