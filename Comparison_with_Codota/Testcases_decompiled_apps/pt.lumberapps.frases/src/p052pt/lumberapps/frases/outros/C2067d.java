package p052pt.lumberapps.frases.outros;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

/* renamed from: pt.lumberapps.frases.outros.d */
final class C2067d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences.Editor f7770a;

    /* renamed from: b */
    final /* synthetic */ Context f7771b;

    C2067d(SharedPreferences.Editor editor, Context context) {
        this.f7770a = editor;
        this.f7771b = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f7770a != null) {
            this.f7770a.putBoolean("dontshowagain", true);
            this.f7770a.commit();
        }
        this.f7771b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=pt.lumberapps.frases")));
        dialogInterface.dismiss();
        C2064a.f7768b.finish();
    }
}
