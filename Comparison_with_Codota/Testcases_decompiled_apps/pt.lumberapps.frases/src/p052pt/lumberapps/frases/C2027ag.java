package p052pt.lumberapps.frases;

import android.content.Context;
import android.content.DialogInterface;

/* renamed from: pt.lumberapps.frases.ag */
class C2027ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String[] f7684a;

    /* renamed from: b */
    final /* synthetic */ C2076w f7685b;

    C2027ag(C2076w wVar, String[] strArr) {
        this.f7685b = wVar;
        this.f7684a = strArr;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new C2056h(this.f7685b).mo10204a((Context) this.f7685b, this.f7684a[i]);
        this.f7685b.mo10252r();
    }
}
