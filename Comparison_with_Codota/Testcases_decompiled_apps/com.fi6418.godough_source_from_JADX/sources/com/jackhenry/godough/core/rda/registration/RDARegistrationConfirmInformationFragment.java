package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.RDAUserRegistrationData;
import com.jackhenry.godough.core.widgets.ActionButton;

public class RDARegistrationConfirmInformationFragment extends C1802r {
    public static final String TAG = RDARegistrationConfirmInformationFragment.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f6713a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f6714b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f6715c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EditText f6716d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public RDAUserRegistrationData f6717e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ActionButton f6718f;

    /* renamed from: a */
    private void m6777a(EditText editText) {
        editText.setEnabled(true);
        editText.addTextChangedListener(new C1867r(this, editText));
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6788n() {
        if (this.f6717e != null) {
            m6777a(this.f6713a);
            m6777a(this.f6714b);
            m6777a(this.f6715c);
            this.f6715c.setText(this.f6717e.getEmail());
            m6777a(this.f6716d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6789o() {
        C1866q qVar = new C1866q(this, this, new C1863n(this));
        if (this.f6717e == null) {
            mo10988l();
            getActivity().getSupportLoaderManager().initLoader(RDARegistrationFragmentActivity.USER_INFORMATION_LOADER, (Bundle) null, qVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean m6790p() {
        return !this.f6713a.getText().toString().equals("") && !this.f6714b.getText().toString().equals("") && !this.f6715c.getText().toString().equals("") && !this.f6716d.getText().toString().equals("") && this.f6715c.getText().toString().equals(this.f6716d.getText().toString()) && C1364k.m5592c(this.f6716d.getText().toString()) && C1364k.m5592c(this.f6715c.getText().toString());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.rda_confirm_information_fragment, viewGroup, false);
        this.f6713a = (EditText) inflate.findViewById(C1494ai.edtFirstName);
        this.f6714b = (EditText) inflate.findViewById(C1494ai.edtLastName);
        this.f6715c = (EditText) inflate.findViewById(C1494ai.edtEmail);
        this.f6716d = (EditText) inflate.findViewById(C1494ai.edtConfirmEmail);
        this.f6718f = (ActionButton) inflate.findViewById(C1494ai.btn_continue);
        this.f6718f.setEnabled(false);
        this.f6718f.setOnClickListener(new C1861l(this));
        ((ActionButton) inflate.findViewById(C1494ai.btn_cancel)).setOnClickListener(new C1862m(this));
        if (this.f6717e == null) {
            m6789o();
        } else {
            m6788n();
        }
        ((AbstractActivity) getActivity()).getSupportActionBar().setSubtitle((CharSequence) getString(C1506am.lbl_rda_user_info_title));
        return inflate;
    }

    public void onResume() {
        super.onResume();
        ((AbstractActivity) getActivity()).setActionBarNavigationOn(true);
    }
}
