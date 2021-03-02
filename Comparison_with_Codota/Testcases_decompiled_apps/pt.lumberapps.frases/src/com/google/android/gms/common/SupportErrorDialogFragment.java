package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p009v4.app.DialogFragment;
import android.support.p009v4.app.FragmentManager;
import com.google.android.gms.common.internal.zzab;

public class SupportErrorDialogFragment extends DialogFragment {

    /* renamed from: a */
    private Dialog f4283a = null;

    /* renamed from: b */
    private DialogInterface.OnCancelListener f4284b = null;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, (DialogInterface.OnCancelListener) null);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) zzab.zzb((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        supportErrorDialogFragment.f4283a = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.f4284b = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f4284b != null) {
            this.f4284b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f4283a == null) {
            setShowsDialog(false);
        }
        return this.f4283a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
