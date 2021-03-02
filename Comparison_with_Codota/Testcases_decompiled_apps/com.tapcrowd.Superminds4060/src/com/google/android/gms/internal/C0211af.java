package com.google.android.gms.internal;

import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.af */
public final class C0211af implements C0221ai {

    /* renamed from: ey */
    private final C0212ag f562ey;

    public C0211af(C0212ag agVar) {
        this.f562ey = agVar;
    }

    /* renamed from: a */
    public void mo4037a(C0347cq cqVar, Map<String, String> map) {
        String str = map.get(DBFavorites.KEY_NAME);
        if (str == null) {
            C0344cn.m737q("App event with no name parameter.");
        } else {
            this.f562ey.mo4038a(str, map.get("info"));
        }
    }
}
