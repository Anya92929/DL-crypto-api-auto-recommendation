package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Map;
import org.apache.cordova.Globalization;

/* renamed from: com.google.android.gms.internal.cb */
public final class C0325cb {
    /* access modifiers changed from: private */

    /* renamed from: eJ */
    public final Object f944eJ = new Object();

    /* renamed from: fG */
    private C0347cq f945fG;
    /* access modifiers changed from: private */

    /* renamed from: gT */
    public String f946gT;

    /* renamed from: gU */
    public final C0221ai f947gU = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            synchronized (C0325cb.this.f944eJ) {
                C0344cn.m737q("Invalid " + map.get(Globalization.TYPE) + " request error: " + map.get("errors"));
                int unused = C0325cb.this.f949gw = 1;
                C0325cb.this.f944eJ.notify();
            }
        }
    };

    /* renamed from: gV */
    public final C0221ai f948gV = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            synchronized (C0325cb.this.f944eJ) {
                String str = map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (str == null) {
                    C0344cn.m737q("URL missing in loadAdUrl GMSG.");
                    return;
                }
                String unused = C0325cb.this.f946gT = str;
                C0325cb.this.f944eJ.notify();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: gw */
    public int f949gw = -2;

    /* renamed from: aj */
    public String mo4186aj() {
        String str;
        synchronized (this.f944eJ) {
            while (this.f946gT == null && this.f949gw == -2) {
                try {
                    this.f944eJ.wait();
                } catch (InterruptedException e) {
                    C0344cn.m737q("Ad request service was interrupted.");
                    str = null;
                }
            }
            str = this.f946gT;
        }
        return str;
    }

    /* renamed from: b */
    public void mo4187b(C0347cq cqVar) {
        synchronized (this.f944eJ) {
            this.f945fG = cqVar;
        }
    }

    public int getErrorCode() {
        int i;
        synchronized (this.f944eJ) {
            i = this.f949gw;
        }
        return i;
    }
}
