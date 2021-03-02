package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.aa */
class C0151aa {

    /* renamed from: AU */
    private final Map<String, Integer> f133AU = new HashMap();

    /* renamed from: AV */
    private final Map<String, String> f134AV = new HashMap();

    /* renamed from: AW */
    private final boolean f135AW;

    /* renamed from: AX */
    private final String f136AX;

    C0151aa(String str, boolean z) {
        this.f135AW = z;
        this.f136AX = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo3598e(String str, int i) {
        if (this.f135AW) {
            Integer num = this.f133AU.get(str);
            if (num == null) {
                num = 0;
            }
            this.f133AU.put(str, Integer.valueOf(num.intValue() + i));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eM */
    public String mo3599eM() {
        if (!this.f135AW) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f136AX);
        for (String next : this.f133AU.keySet()) {
            sb.append("&").append(next).append("=").append(this.f133AU.get(next));
        }
        for (String next2 : this.f134AV.keySet()) {
            sb.append("&").append(next2).append("=").append(this.f134AV.get(next2));
        }
        return sb.toString();
    }
}
