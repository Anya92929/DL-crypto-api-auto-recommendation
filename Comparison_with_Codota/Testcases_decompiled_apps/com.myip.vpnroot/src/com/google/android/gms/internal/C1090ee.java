package com.google.android.gms.internal;

import android.content.Intent;

@C1130ez
/* renamed from: com.google.android.gms.internal.ee */
public class C1090ee {

    /* renamed from: oA */
    private final String f3246oA;

    public C1090ee(String str) {
        this.f3246oA = str;
    }

    /* renamed from: a */
    public boolean mo8417a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String e = C1089ed.m4324e(intent);
        String f = C1089ed.m4325f(intent);
        if (e == null || f == null) {
            return false;
        }
        if (!str.equals(C1089ed.m4320D(e))) {
            C1229gs.m4679W("Developer payload not match.");
            return false;
        } else if (this.f3246oA == null || C1091ef.m4330b(this.f3246oA, e, f)) {
            return true;
        } else {
            C1229gs.m4679W("Fail to verify signature.");
            return false;
        }
    }

    /* renamed from: cu */
    public String mo8418cu() {
        return C1213gj.m4636dp();
    }
}
