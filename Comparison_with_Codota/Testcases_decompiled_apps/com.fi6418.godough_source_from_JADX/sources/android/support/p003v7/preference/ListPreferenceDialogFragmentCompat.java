package android.support.p003v7.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p003v7.app.AlertDialog;

/* renamed from: android.support.v7.preference.ListPreferenceDialogFragmentCompat */
public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public int f2441aj;

    /* renamed from: m */
    private ListPreference m1561m() {
        return (ListPreference) getPreference();
    }

    public static ListPreferenceDialogFragmentCompat newInstance(String str) {
        ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = new ListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragmentCompat.setArguments(bundle);
        return listPreferenceDialogFragmentCompat;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4778a(AlertDialog.Builder builder) {
        super.mo4778a(builder);
        ListPreference m = m1561m();
        if (m.getEntries() == null || m.getEntryValues() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f2441aj = m.findIndexOfValue(m.getValue());
        builder.setSingleChoiceItems(m.getEntries(), this.f2441aj, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                int unused = ListPreferenceDialogFragmentCompat.this.f2441aj = i;
                ListPreferenceDialogFragmentCompat.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    public void onDialogClosed(boolean z) {
        ListPreference m = m1561m();
        if (z && this.f2441aj >= 0 && m.getEntryValues() != null) {
            String charSequence = m.getEntryValues()[this.f2441aj].toString();
            if (m.callChangeListener(charSequence)) {
                m.setValue(charSequence);
            }
        }
    }
}
