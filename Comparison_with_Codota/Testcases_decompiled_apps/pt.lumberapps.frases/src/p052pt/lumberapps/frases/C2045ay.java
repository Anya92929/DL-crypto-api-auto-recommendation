package p052pt.lumberapps.frases;

import android.content.DialogInterface;
import android.content.Intent;

/* renamed from: pt.lumberapps.frases.ay */
class C2045ay implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7717a;

    /* renamed from: b */
    final /* synthetic */ C2044ax f7718b;

    C2045ay(C2044ax axVar, int i) {
        this.f7718b = axVar;
        this.f7717a = i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2038ar a = this.f7718b.f7716a.f7713a.mo10197a(((C2038ar) this.f7718b.f7716a.f7714b.get(this.f7717a)).mo10181b());
        switch (i) {
            case 0:
                Intent intent = new Intent(this.f7718b.f7716a.getActivity().getApplicationContext(), MainActivity.class);
                MApp.m8271a(intent, a, 5);
                this.f7718b.f7716a.getActivity().setResult(-1, intent);
                this.f7718b.f7716a.getActivity().finish();
                return;
            case 1:
                this.f7718b.f7716a.m8314a(a.mo10181b(), a.mo10179a());
                return;
            case 2:
                this.f7718b.f7716a.f7713a.mo10199b(a);
                this.f7718b.f7716a.mo10185a();
                return;
            default:
                return;
        }
    }
}
