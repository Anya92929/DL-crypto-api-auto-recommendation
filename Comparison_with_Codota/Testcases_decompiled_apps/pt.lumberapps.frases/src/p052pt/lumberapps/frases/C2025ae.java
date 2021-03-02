package p052pt.lumberapps.frases;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.ae */
class C2025ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7681a;

    /* renamed from: b */
    final /* synthetic */ C2076w f7682b;

    C2025ae(C2076w wVar, String str) {
        this.f7682b = wVar;
        this.f7681a = str;
    }

    public void run() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("sms_body", this.f7681a);
        try {
            this.f7682b.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            this.f7682b.mo10212a(this.f7682b.mo10240c(C1204R.string.erro_sms));
        }
    }
}
