package p052pt.lumberapps.lumbliv;

import android.content.DialogInterface;

/* renamed from: pt.lumberapps.lumbliv.f */
class C2085f implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C2082c f7848a;

    C2085f(C2082c cVar) {
        this.f7848a = cVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f7848a.dismiss();
    }
}
