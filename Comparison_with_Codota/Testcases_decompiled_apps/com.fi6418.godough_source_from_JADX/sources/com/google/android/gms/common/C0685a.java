package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.C1009bf;

/* renamed from: com.google.android.gms.common.a */
public class C0685a extends DialogFragment {

    /* renamed from: a */
    private Dialog f4402a = null;

    /* renamed from: b */
    private DialogInterface.OnCancelListener f4403b = null;

    /* renamed from: a */
    public static C0685a m3946a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        C0685a aVar = new C0685a();
        Dialog dialog2 = (Dialog) C1009bf.m4529a(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        aVar.f4402a = dialog2;
        if (onCancelListener != null) {
            aVar.f4403b = onCancelListener;
        }
        return aVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f4403b != null) {
            this.f4403b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f4402a == null) {
            setShowsDialog(false);
        }
        return this.f4402a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
