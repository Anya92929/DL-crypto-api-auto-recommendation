package android.support.p003v7.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.preference.DialogPreference;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* renamed from: android.support.v7.preference.PreferenceDialogFragmentCompat */
public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: aj */
    private DialogPreference f2474aj;

    /* renamed from: ak */
    private int f2475ak;

    /* renamed from: a */
    private void m1593a(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo4858a(Context context) {
        int dialogLayoutResource = this.f2474aj.getDialogLayoutResource();
        if (dialogLayoutResource == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(dialogLayoutResource, (ViewGroup) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4778a(AlertDialog.Builder builder) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4758a(View view) {
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence dialogMessage = this.f2474aj.getDialogMessage();
            int i = 8;
            if (!TextUtils.isEmpty(dialogMessage)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(dialogMessage);
                }
                i = 0;
            }
            if (findViewById.getVisibility() != i) {
                findViewById.setVisibility(i);
            }
        }
    }

    public DialogPreference getPreference() {
        return this.f2474aj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public boolean mo4760l() {
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2475ak = i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.TargetFragment)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        this.f2474aj = (DialogPreference) ((DialogPreference.TargetFragment) targetFragment).findPreference(getArguments().getString("key"));
    }

    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.f2475ak = -2;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity).setTitle(this.f2474aj.getDialogTitle()).setIcon(this.f2474aj.getDialogIcon()).setPositiveButton(this.f2474aj.getPositiveButtonText(), (DialogInterface.OnClickListener) this).setNegativeButton(this.f2474aj.getNegativeButtonText(), (DialogInterface.OnClickListener) this);
        View a = mo4858a((Context) activity);
        if (a != null) {
            mo4758a(a);
            negativeButton.setView(a);
        } else {
            negativeButton.setMessage(this.f2474aj.getDialogMessage());
        }
        mo4778a(negativeButton);
        AlertDialog create = negativeButton.create();
        if (mo4760l()) {
            m1593a((Dialog) create);
        }
        return negativeButton.create();
    }

    public abstract void onDialogClosed(boolean z);

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        onDialogClosed(this.f2475ak == -1);
    }
}
