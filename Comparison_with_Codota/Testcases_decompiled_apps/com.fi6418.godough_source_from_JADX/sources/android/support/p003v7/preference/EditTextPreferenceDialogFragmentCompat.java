package android.support.p003v7.preference;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;

/* renamed from: android.support.v7.preference.EditTextPreferenceDialogFragmentCompat */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* renamed from: aj */
    private EditText f2434aj;

    /* renamed from: m */
    private EditTextPreference m1551m() {
        return (EditTextPreference) getPreference();
    }

    public static EditTextPreferenceDialogFragmentCompat newInstance(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4758a(View view) {
        super.mo4758a(view);
        this.f2434aj = new EditText(view.getContext());
        this.f2434aj.setId(16908291);
        this.f2434aj.setText(m1551m().getText());
        ViewParent parent = this.f2434aj.getParent();
        if (parent != view) {
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.f2434aj);
            }
            mo4759a(view, this.f2434aj);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4759a(View view, EditText editText) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(C0268R.C0270id.edittext_container);
        if (viewGroup != null) {
            viewGroup.addView(editText, -1, -2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public boolean mo4760l() {
        return true;
    }

    public void onDialogClosed(boolean z) {
        if (z) {
            String obj = this.f2434aj.getText().toString();
            if (m1551m().callChangeListener(obj)) {
                m1551m().setText(obj);
            }
        }
    }
}
