package p052pt.lumberapps.frases;

import android.content.Intent;
import android.net.Uri;
import java.io.File;

/* renamed from: pt.lumberapps.frases.j */
class C2058j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2057i f7752a;

    C2058j(C2057i iVar) {
        this.f7752a = iVar;
    }

    public void run() {
        Uri fromFile = Uri.fromFile(new File(this.f7752a.f7747a));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/jpeg");
        intent.putExtra("android.intent.extra.STREAM", fromFile);
        this.f7752a.startActivity(Intent.createChooser(intent, "Share Image With"));
    }
}
