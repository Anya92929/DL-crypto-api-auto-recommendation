package p052pt.lumberapps.frases;

import android.content.Intent;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.ad */
class C2024ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7679a;

    /* renamed from: b */
    final /* synthetic */ C2076w f7680b;

    C2024ad(C2076w wVar, String str) {
        this.f7680b = wVar;
        this.f7679a = str;
    }

    public void run() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", this.f7679a);
        this.f7680b.startActivity(Intent.createChooser(intent, this.f7680b.mo10240c(C1204R.string.partilhar_frase)));
    }
}
