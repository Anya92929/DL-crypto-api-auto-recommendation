package com.google.firebase.iid;

import android.text.TextUtils;

/* renamed from: com.google.firebase.iid.h */
public class C1986h {

    /* renamed from: a */
    private static final Object f7531a = new Object();

    /* renamed from: b */
    private final C1989k f7532b;

    C1986h(C1989k kVar) {
        this.f7532b = kVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo9886a() {
        String str = null;
        synchronized (f7531a) {
            String string = this.f7532b.mo9898a().getString("topic_operaion_queue", (String) null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9887a(String str) {
        boolean z;
        synchronized (f7531a) {
            String string = this.f7532b.mo9898a().getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                String valueOf3 = String.valueOf(",");
                String valueOf4 = String.valueOf(str);
                this.f7532b.mo9898a().edit().putString("topic_operaion_queue", string.substring((valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
