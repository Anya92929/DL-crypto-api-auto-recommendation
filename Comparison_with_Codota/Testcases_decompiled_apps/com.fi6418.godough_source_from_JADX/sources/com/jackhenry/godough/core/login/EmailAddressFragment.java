package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.EmailAddressData;
import com.jackhenry.godough.core.widgets.ActionButton;

public class EmailAddressFragment extends C1802r implements View.OnClickListener {
    public static final String TAG = EmailAddressFragment.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f6267a;

    /* renamed from: b */
    private ActionButton f6268b;

    /* renamed from: c */
    private ActionButton f6269c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1714de f6270d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1715df f6271e;

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6292n() {
        if (C1364k.m5592c(this.f6267a.getText().toString()) || this.f6267a.getText().toString().trim().length() == 0) {
            this.f6268b.setEnabled(true);
        } else {
            this.f6268b.setEnabled(false);
        }
    }

    public void cancelEmailSubmit() {
        mo10986b(getString(C1506am.dg_processing));
        this.f6271e = new C1715df(new C1734i(this, this, new C1733h(this)));
        this.f6271e.execute(new Void[0]);
    }

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.email_address_fragment, (ViewGroup) null, false);
        this.f6269c = (ActionButton) inflate.findViewById(C1494ai.btn_not_now);
        this.f6268b = (ActionButton) inflate.findViewById(C1494ai.btn_submit);
        this.f6267a = (EditText) inflate.findViewById(C1494ai.email_address);
        this.f6267a.addTextChangedListener(new C1709d(this));
        this.f6268b.setOnClickListener(new C1730e(this));
        this.f6269c.setOnClickListener(new C1731f(this));
        m6292n();
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.f6270d != null) {
            if (this.f6270d == null || !this.f6270d.mo10926c()) {
                mo10986b(getString(C1506am.dg_processing));
            } else if (this.f6270d.mo10929e()) {
                this.f6270d.mo10922a().mo9589a(this.f6270d.mo10927d());
            } else {
                this.f6270d.mo10922a().mo9588a(this.f6270d.mo10925b());
            }
        } else if (this.f6271e == null) {
        } else {
            if (this.f6271e == null || !this.f6271e.mo10926c()) {
                mo10986b(getString(C1506am.dg_processing));
            } else if (this.f6271e.mo10929e()) {
                this.f6271e.mo10922a().mo9589a(this.f6271e.mo10927d());
            } else {
                this.f6271e.mo10922a().mo9588a(this.f6271e.mo10925b());
            }
        }
    }

    public void setEmailAddress(String str) {
        if (str == null) {
            str = "";
        }
        this.f6267a.setText(str);
    }

    public void submitEmail(String str) {
        EmailAddressData emailAddressData = ((EmailAddressFragmentActivity) getActivity()).getEmailAddressData();
        emailAddressData.setCustomerEmail(str);
        mo10986b(getString(C1506am.dg_processing));
        this.f6270d = new C1714de(emailAddressData, new C1735j(this, this, new C1732g(this, str)));
        this.f6270d.execute(new Void[0]);
    }
}
