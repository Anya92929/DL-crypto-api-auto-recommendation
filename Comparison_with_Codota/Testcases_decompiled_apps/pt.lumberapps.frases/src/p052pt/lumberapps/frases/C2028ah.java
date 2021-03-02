package p052pt.lumberapps.frases;

import android.content.ClipData;
import android.os.Build;
import android.text.ClipboardManager;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.ah */
class C2028ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7686a;

    /* renamed from: b */
    final /* synthetic */ boolean f7687b;

    /* renamed from: c */
    final /* synthetic */ String f7688c;

    /* renamed from: d */
    final /* synthetic */ C2076w f7689d;

    C2028ah(C2076w wVar, String str, boolean z, String str2) {
        this.f7689d = wVar;
        this.f7686a = str;
        this.f7687b = z;
        this.f7688c = str2;
    }

    public void run() {
        if (Build.VERSION.SDK_INT < 11) {
            ((ClipboardManager) this.f7689d.getSystemService("clipboard")).setText(!this.f7687b ? this.f7688c : this.f7686a);
        } else {
            ((android.content.ClipboardManager) this.f7689d.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label", !this.f7687b ? this.f7688c : this.f7686a));
        }
        if (!this.f7687b) {
            this.f7689d.mo10212a(this.f7689d.mo10240c(C1204R.string.frase_p_a_transferencia));
        }
    }
}
