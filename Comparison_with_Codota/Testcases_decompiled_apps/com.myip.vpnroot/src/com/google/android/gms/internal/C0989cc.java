package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.cc */
public class C0989cc implements C0974by {

    /* renamed from: pK */
    static final Map<String, Integer> f3011pK = new HashMap();

    static {
        f3011pK.put("resize", 1);
        f3011pK.put("playVideo", 2);
        f3011pK.put("storePicture", 3);
        f3011pK.put("createCalendarEvent", 4);
    }

    /* renamed from: a */
    public void mo7942a(C1232gv gvVar, Map<String, String> map) {
        switch (f3011pK.get(map.get("a")).intValue()) {
            case 1:
                new C1045dd(gvVar, map).execute();
                return;
            case 3:
                new C1046de(gvVar, map).execute();
                return;
            case 4:
                new C1042dc(gvVar, map).execute();
                return;
            default:
                C1229gs.m4677U("Unknown MRAID command called.");
                return;
        }
    }
}
