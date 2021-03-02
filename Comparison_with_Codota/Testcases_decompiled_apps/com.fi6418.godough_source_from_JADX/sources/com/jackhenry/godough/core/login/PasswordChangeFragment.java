package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.CredentialsChangeSettings;
import com.jackhenry.godough.core.model.PasswordResetData;
import com.jackhenry.godough.core.widgets.ActionButton;

public class PasswordChangeFragment extends C1802r implements View.OnClickListener {
    public static final int DIALOG_CREDENTIAL_RESULTS = 6033;
    public static final String TAG = PasswordChangeFragment.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f6342a;

    /* renamed from: b */
    private EditText f6343b;

    /* renamed from: c */
    private EditText f6344c;

    /* renamed from: d */
    private EditText f6345d;

    /* renamed from: e */
    private ActionButton f6346e;

    /* renamed from: f */
    private ActionButton f6347f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CredentialsChangeSettings f6348g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1718di f6349h;

    /* renamed from: i */
    private C1691ci f6350i;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6362a(EditText editText) {
        this.f6348g.validateInput(m6372o(), editText);
        if (editText.getTag() == CredentialsChangeSettings.ViewTag.NEW_PASSWORD_VIEW_TAG) {
            if (this.f6344c.getText() != null && !TextUtils.isEmpty(this.f6344c.getText().toString())) {
                this.f6348g.validateInput(m6372o(), this.f6344c);
            }
            if (this.f6343b.getError() != null || TextUtils.isEmpty(editText.getText().toString())) {
                this.f6344c.setEnabled(false);
            } else {
                if (m6372o().doPasswordsMatch()) {
                    this.f6344c.setError((CharSequence) null);
                }
                this.f6344c.setEnabled(true);
            }
        }
        this.f6346e.setEnabled(this.f6348g.areFieldsValid(m6372o()));
    }

    /* renamed from: n */
    private void m6371n() {
        if (this.f6343b != null) {
            m6362a(this.f6343b);
        }
        if (this.f6342a != null) {
            m6362a(this.f6342a);
        }
        if (this.f6344c != null) {
            m6362a(this.f6344c);
        }
        if (this.f6345d != null) {
            m6362a(this.f6345d);
        }
    }

    /* renamed from: o */
    private PasswordResetData m6372o() {
        PasswordResetData passwordResetData = new PasswordResetData();
        if (!(this.f6343b == null || this.f6343b.getText() == null)) {
            passwordResetData.setNewPassword(this.f6343b.getText().toString());
        }
        if (!(this.f6344c == null || this.f6344c.getText() == null)) {
            passwordResetData.setNewPasswordRepeated(this.f6344c.getText().toString());
        }
        if (!(this.f6342a == null || this.f6342a.getText() == null)) {
            passwordResetData.setCurrentPassword(this.f6342a.getText().toString());
        }
        if (!(this.f6345d == null || this.f6345d.getText() == null)) {
            if (TextUtils.isEmpty(this.f6345d.getText().toString())) {
                passwordResetData.setNewUserName("");
            } else {
                passwordResetData.setNewUserName(this.f6345d.getText().toString());
            }
        }
        return passwordResetData;
    }

    public void onClick(View view) {
        if (view == this.f6346e.getButton()) {
            submitData(false);
        } else {
            submitData(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f6348g == null) {
            this.f6348g = ((PasswordChangeFragmentActivity) getActivity()).getCredentialsChangeSettings();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.password_change_fragment, (ViewGroup) null, false);
        this.f6346e = (ActionButton) inflate.findViewById(C1494ai.btn_submit);
        this.f6346e.setOnClickListener(this);
        this.f6347f = (ActionButton) inflate.findViewById(C1494ai.btn_skip);
        this.f6347f.setOnClickListener(this);
        this.f6347f.setVisibility(8);
        if (!this.f6348g.statusContains(1) && !this.f6348g.statusContains(4)) {
            this.f6347f.setVisibility(0);
        }
        ((RelativeLayout) inflate.findViewById(C1494ai.password_change_instructions_panel)).setOnClickListener(new C1692cj(this));
        String shortPasswordLabel = GoDoughApp.getSettings().getShortPasswordLabel();
        ((TextView) inflate.findViewById(C1494ai.tv_password_change_detail)).setText(this.f6348g.getChangeMessage());
        if (!this.f6348g.statusContains(1)) {
            ((LinearLayout) inflate.findViewById(C1494ai.password_section)).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(C1494ai.current_password_label)).setText(getString(C1506am.current_password_label, shortPasswordLabel));
            ((TextView) inflate.findViewById(C1494ai.new_password_label)).setText(getString(C1506am.new_password_label, shortPasswordLabel));
            ((TextView) inflate.findViewById(C1494ai.re_enter_password_label)).setText(getString(C1506am.re_enter_password_label, shortPasswordLabel));
            this.f6342a = (EditText) inflate.findViewById(C1494ai.current_password);
            this.f6342a.addTextChangedListener(new C1698cp(this, this.f6342a));
            this.f6342a.setTag(CredentialsChangeSettings.ViewTag.CURRENT_PASSWORD_VIEW_TAG);
            this.f6343b = (EditText) inflate.findViewById(C1494ai.new_password);
            this.f6343b.addTextChangedListener(new C1698cp(this, this.f6343b));
            this.f6343b.setTag(CredentialsChangeSettings.ViewTag.NEW_PASSWORD_VIEW_TAG);
            this.f6344c = (EditText) inflate.findViewById(C1494ai.re_enter_password);
            this.f6344c.addTextChangedListener(new C1698cp(this, this.f6344c));
            this.f6344c.setTag(CredentialsChangeSettings.ViewTag.REENTER_PASSWORD_VIEW_TAG);
            this.f6344c.setEnabled(false);
        }
        if (!this.f6348g.statusContains(2)) {
            ((LinearLayout) inflate.findViewById(C1494ai.username_section)).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(C1494ai.current_username)).setText(this.f6348g.getCurrentUserName());
            this.f6345d = (EditText) inflate.findViewById(C1494ai.new_username);
            this.f6345d.addTextChangedListener(new C1699cq(this, this.f6345d));
            this.f6345d.setTag(CredentialsChangeSettings.ViewTag.NEW_USERNAME_VIEW_TAG);
        }
        if (this.f6348g.getPasswordMaximumLength() > 0 && this.f6348g.statusContains(1)) {
            InputFilter[] inputFilterArr = {new InputFilter.LengthFilter(this.f6348g.getPasswordMaximumLength() + 1)};
            this.f6343b.setFilters(inputFilterArr);
            this.f6344c.setFilters(inputFilterArr);
        }
        if (this.f6348g.getUserNameMaximumLength() > 0 && this.f6348g.statusContains(2)) {
            this.f6345d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f6348g.getUserNameMaximumLength() + 1)});
        }
        m6371n();
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.f6349h == null) {
            return;
        }
        if (this.f6349h == null || !this.f6349h.mo10926c()) {
            mo10986b(getString(C1506am.dg_processing));
        } else if (this.f6349h.mo10929e()) {
            this.f6349h.mo10922a().mo9589a(this.f6349h.mo10927d());
        } else {
            this.f6349h.mo10922a().mo9588a(this.f6349h.mo10925b());
        }
    }

    public void reloadSettings() {
        mo10986b(getString(C1506am.dg_loading));
        this.f6350i = new C1691ci(new C1695cm(this, this, new C1694cl(this)));
        this.f6350i.execute(new Void[0]);
    }

    public void submitData(boolean z) {
        mo10986b(getString(C1506am.dg_processing));
        C1696cn cnVar = new C1696cn(this, this, new C1693ck(this, z));
        PasswordResetData o = m6372o();
        if (z) {
            o.setNewUserName("");
        }
        this.f6349h = new C1718di(o, cnVar, this.f6348g);
        this.f6349h.execute(new Void[0]);
    }
}
