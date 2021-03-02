package p052pt.lumberapps.frases;

import android.widget.Toast;

/* renamed from: pt.lumberapps.frases.l */
class C2060l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7754a;

    /* renamed from: b */
    final /* synthetic */ C2057i f7755b;

    C2060l(C2057i iVar, String str) {
        this.f7755b = iVar;
        this.f7754a = str;
    }

    public void run() {
        Toast.makeText(this.f7755b, this.f7754a, 0).show();
    }
}
