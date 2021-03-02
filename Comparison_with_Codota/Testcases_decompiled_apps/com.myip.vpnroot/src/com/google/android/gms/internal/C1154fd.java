package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.C1196fz;

@C1130ez
/* renamed from: com.google.android.gms.internal.fd */
public final class C1154fd {

    /* renamed from: com.google.android.gms.internal.fd$a */
    public interface C1155a {
        /* renamed from: a */
        void mo8484a(C1196fz fzVar);
    }

    /* renamed from: a */
    public static C1206gg m4429a(Context context, C1735u uVar, C1196fz.C1197a aVar, C1232gv gvVar, C1013ct ctVar, C1155a aVar2) {
        C1206gg feVar;
        if (aVar.f3692vw.f3572tS) {
            feVar = new C1176fn(context, uVar, new C0899ai(), aVar, aVar2);
        } else {
            feVar = new C1156fe(context, aVar, gvVar, ctVar, aVar2);
        }
        feVar.start();
        return feVar;
    }
}
