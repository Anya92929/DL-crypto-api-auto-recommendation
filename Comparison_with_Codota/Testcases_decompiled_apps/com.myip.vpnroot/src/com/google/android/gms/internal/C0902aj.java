package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import com.google.android.gms.internal.C0897ah;
import com.google.android.gms.internal.C1234gw;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.aj */
public class C0902aj implements C0897ah {
    /* access modifiers changed from: private */

    /* renamed from: md */
    public final C1232gv f2552md;

    public C0902aj(Context context, C1230gt gtVar) {
        this.f2552md = C1232gv.m4688a(context, new C0927ay(), false, false, (C1391k) null, gtVar);
    }

    private void runOnUiThread(Runnable runnable) {
        if (C1228gr.m4673dt()) {
            runnable.run();
        } else {
            C1228gr.f3776wC.post(runnable);
        }
    }

    /* renamed from: a */
    public void mo7943a(final C0897ah.C0898a aVar) {
        this.f2552md.mo8631dv().mo8649a((C1234gw.C1236a) new C1234gw.C1236a() {
            /* renamed from: a */
            public void mo7957a(C1232gv gvVar) {
                aVar.mo7938aM();
            }
        });
    }

    /* renamed from: a */
    public void mo7944a(C1734t tVar, C1063dn dnVar, C0964bw bwVar, C1068dq dqVar, boolean z, C0975bz bzVar) {
        this.f2552md.mo8631dv().mo8651a(tVar, dnVar, bwVar, dqVar, z, bzVar, new C1741v(false));
    }

    /* renamed from: a */
    public void mo7945a(String str, C0974by byVar) {
        this.f2552md.mo8631dv().mo8652a(str, byVar);
    }

    /* renamed from: a */
    public void mo7946a(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable() {
            public void run() {
                C0902aj.this.f2552md.mo8623a(str, jSONObject);
            }
        });
    }

    public void destroy() {
        this.f2552md.destroy();
    }

    /* renamed from: f */
    public void mo7948f(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                C0902aj.this.f2552md.loadUrl(str);
            }
        });
    }

    /* renamed from: g */
    public void mo7949g(String str) {
        this.f2552md.mo8631dv().mo8652a(str, (C0974by) null);
    }

    public void pause() {
        C1213gj.m4622a((WebView) this.f2552md);
    }

    public void resume() {
        C1213gj.m4627b(this.f2552md);
    }
}
