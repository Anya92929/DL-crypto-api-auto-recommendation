package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.FragmentManager;
import com.google.android.gms.common.internal.C1009bf;

/* renamed from: com.google.android.gms.common.f */
public class C0880f extends DialogFragment {

    /* renamed from: aj */
    private Dialog f4611aj = null;

    /* renamed from: ak */
    private DialogInterface.OnCancelListener f4612ak = null;

    /* renamed from: a */
    public static C0880f m4275a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        C0880f fVar = new C0880f();
        Dialog dialog2 = (Dialog) C1009bf.m4529a(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        fVar.f4611aj = dialog2;
        if (onCancelListener != null) {
            fVar.f4612ak = onCancelListener;
        }
        return fVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f4612ak != null) {
            this.f4612ak.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f4611aj == null) {
            setShowsDialog(false);
        }
        return this.f4611aj;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
