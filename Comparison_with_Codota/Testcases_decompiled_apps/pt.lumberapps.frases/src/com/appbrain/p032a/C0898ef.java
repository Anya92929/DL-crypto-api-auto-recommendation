package com.appbrain.p032a;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.appbrain.p033b.C1015s;
import com.appbrain.p037f.C1056av;

@TargetApi(11)
/* renamed from: com.appbrain.a.ef */
public final class C0898ef extends DialogFragment {

    /* renamed from: a */
    private C1056av f2372a;

    /* renamed from: a */
    public static void m3867a(FragmentManager fragmentManager, C1056av avVar) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("Alert", avVar.mo3915b());
        C0898ef efVar = new C0898ef();
        efVar.setArguments(bundle);
        C0911es.m3892a(fragmentManager, (DialogFragment) efVar, C0891dz.m3862b(avVar));
    }

    public final void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        C0891dz.m3861a(this.f2372a, false);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        try {
            this.f2372a = C1056av.m4690a(getArguments().getByteArray("Alert"));
        } catch (C1015s e) {
        }
        return C0891dz.m3866e(getActivity(), this.f2372a);
    }

    public final void onResume() {
        super.onResume();
        if (!C0902ej.m3875a(this.f2372a)) {
            dismiss();
        }
    }
}
