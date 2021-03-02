package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.C0897ah;
import java.util.concurrent.Future;

@C1130ez
/* renamed from: com.google.android.gms.internal.ai */
public class C0899ai {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0897ah mo7952a(Context context, C1230gt gtVar, final C1216gk<C0897ah> gkVar) {
        final C0902aj ajVar = new C0902aj(context, gtVar);
        ajVar.mo7943a(new C0897ah.C0898a() {
            /* renamed from: aM */
            public void mo7938aM() {
                gkVar.mo8592a(ajVar);
            }
        });
        return ajVar;
    }

    /* renamed from: a */
    public Future<C0897ah> mo7953a(Context context, C1230gt gtVar, String str) {
        final C1216gk gkVar = new C1216gk();
        final Context context2 = context;
        final C1230gt gtVar2 = gtVar;
        final String str2 = str;
        C1228gr.f3776wC.post(new Runnable() {
            public void run() {
                C0899ai.this.mo7952a(context2, gtVar2, (C1216gk<C0897ah>) gkVar).mo7948f(str2);
            }
        });
        return gkVar;
    }
}
