package com.google.android.gms.internal;

import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.bv */
public final class C0963bv implements C0974by {

    /* renamed from: pz */
    private final C0964bw f2941pz;

    public C0963bv(C0964bw bwVar) {
        this.f2941pz = bwVar;
    }

    /* renamed from: a */
    public void mo7942a(C1232gv gvVar, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            C1229gs.m4679W("App event with no name parameter.");
        } else {
            this.f2941pz.onAppEvent(str, map.get("info"));
        }
    }
}
