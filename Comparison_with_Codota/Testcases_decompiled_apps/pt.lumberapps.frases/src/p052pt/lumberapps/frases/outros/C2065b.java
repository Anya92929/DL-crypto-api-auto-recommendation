package p052pt.lumberapps.frases.outros;

import android.content.DialogInterface;
import android.content.SharedPreferences;

/* renamed from: pt.lumberapps.frases.outros.b */
final class C2065b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences.Editor f7769a;

    C2065b(SharedPreferences.Editor editor) {
        this.f7769a = editor;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f7769a != null) {
            this.f7769a.putBoolean("dontshowagain", true);
            this.f7769a.commit();
        }
        dialogInterface.dismiss();
        C2064a.f7768b.finish();
    }
}
