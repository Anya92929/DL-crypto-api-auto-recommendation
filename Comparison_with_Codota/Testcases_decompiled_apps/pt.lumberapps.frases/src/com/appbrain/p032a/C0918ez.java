package com.appbrain.p032a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.appbrain.p033b.C1015s;
import com.appbrain.p037f.C1056av;

@TargetApi(11)
/* renamed from: com.appbrain.a.ez */
public final class C0918ez extends DialogFragment {

    /* renamed from: a */
    private C0920fa f2407a;

    /* renamed from: b */
    private C1056av f2408b;

    /* renamed from: c */
    private String f2409c;

    /* renamed from: a */
    static /* synthetic */ void m3907a(Activity activity, C1056av avVar, String str, C0920fa faVar) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("Alert", avVar.mo3915b());
        bundle.putString("AlertProviderName", str);
        C0918ez ezVar = new C0918ez();
        ezVar.setArguments(bundle);
        ezVar.f2407a = faVar;
        C0911es.m3892a(activity.getFragmentManager(), (DialogFragment) ezVar, "appbrain.internal.AppAlertWebViewManager");
    }

    public final void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        C0912et.m3899a(this.f2408b, this.f2409c);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        try {
            this.f2408b = C1056av.m4690a(getArguments().getByteArray("Alert"));
            this.f2409c = getArguments().getString("AlertProviderName");
            if (this.f2407a != null) {
                C0912et.f2394c.remove(this.f2407a);
                return this.f2407a;
            }
            C0920fa faVar = new C0920fa(getActivity(), this.f2408b, (byte) 0);
            C0920fa.m3912b(faVar);
            return faVar;
        } catch (C1015s e) {
            throw new IllegalStateException(e);
        }
    }

    public final void onPause() {
        if (getActivity().isChangingConfigurations()) {
            dismiss();
        }
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        if (!((C0920fa) getDialog()).f2415e) {
            C0917ey eyVar = (C0917ey) C0912et.f2393b.get(this.f2409c);
            if (eyVar != null && eyVar.mo3787a(this.f2408b)) {
                return;
            }
        }
        dismiss();
    }
}
