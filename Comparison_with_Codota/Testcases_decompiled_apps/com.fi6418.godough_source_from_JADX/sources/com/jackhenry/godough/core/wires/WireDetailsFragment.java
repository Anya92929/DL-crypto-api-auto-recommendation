package com.jackhenry.godough.core.wires;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Wire;
import com.jackhenry.godough.core.p038e.C1582k;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.JhaEditText;

public class WireDetailsFragment extends C1802r {
    public static final int DIALOG_WIRE_FAIL = 5024;
    public static final int DIALOG_WIRE_SUCCESS = 5023;
    public static final String EXTRA_ACTION = "EXTRA_ACTION";
    public static final String EXTRA_WIRE = "EXTRA_WIRE";
    public static final String OUT_PIN = "OUT_PIN";

    /* renamed from: a */
    C1926b f6886a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Wire f6887b;

    /* renamed from: c */
    private ActionButton f6888c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public JhaEditText f6889d;

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6964n() {
        if (getResources().getConfiguration().hardKeyboardHidden == 2 && getResources().getConfiguration().keyboardHidden == 1 && getResources().getConfiguration().orientation == 2) {
            this.f6889d.setHint(this.f6889d.hasFocus() ? getString(C1506am.lbl_pin) : "");
        } else {
            this.f6889d.setHint("");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6965o() {
        if (C1364k.m5589a(this.f6889d.getText().toString())) {
            this.f6888c.setEnabled(false);
        } else {
            this.f6888c.setEnabled(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6887b = (Wire) getActivity().getIntent().getSerializableExtra(EXTRA_WIRE);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.wire_detail_fragment, (ViewGroup) null);
        ((TextView) inflate.findViewById(C1494ai.header)).setText(this.f6887b.getName());
        this.f6889d = (JhaEditText) inflate.findViewById(C1494ai.pin_value);
        m6964n();
        this.f6889d.addTextChangedListener(new C1927c(this));
        this.f6889d.setOnFocusChangeListener(new C1928d(this));
        this.f6889d.setOnBackKeyPressedListener(new C1929e(this));
        this.f6889d.setOnEditorActionListener(new C1930f(this));
        TableLayout tableLayout = (TableLayout) inflate.findViewById(C1494ai.table);
        C1582k.m6160a(C1506am.lbl_debit_account, this.f6887b.getDebitAccountName(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_credit_account, this.f6887b.getCreditAccountNumber(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_receiving_fi, this.f6887b.getReceivingFi(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_amount, this.f6887b.getAmountFormatted(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_repetitive, this.f6887b.isRepetitive() ? getString(C1506am.lbl_yes) : getString(C1506am.lbl_no), tableLayout, layoutInflater);
        ((ActionButton) inflate.findViewById(C1494ai.btn_cancel)).setOnClickListener(new C1931g(this));
        this.f6888c = (ActionButton) inflate.findViewById(C1494ai.btn_action);
        this.f6888c.setOnClickListener(new C1932h(this));
        if (!GoDoughApp.getUserSettings().isHasDualControlWires() || !this.f6887b.getStatus().equals(Wire.STATUS_NEED_APPROVAL)) {
            this.f6888c.setText(C1506am.btn_transmit);
        } else {
            this.f6888c.setText(C1506am.btn_approve);
        }
        m6965o();
        return inflate;
    }

    public void onPerformAction() {
        String obj = this.f6889d.getText().toString();
        mo10986b(getString(C1506am.dg_processing));
        this.f6886a = new C1926b(this.f6887b, obj, new C1934j(this, this, new C1933i(this)));
        this.f6886a.execute(new Void[0]);
    }

    public void onStart() {
        super.onStart();
        if (this.f6886a != null) {
            if (this.f6886a == null || !this.f6886a.mo10926c()) {
                mo10986b(getString(C1506am.dg_processing));
            } else if (this.f6886a.mo10929e()) {
                this.f6886a.mo10922a().mo9589a(this.f6886a.mo10927d());
            } else {
                this.f6886a.mo10922a().mo9588a(this.f6886a.mo10925b());
            }
        }
        if (this.f6887b != null && this.f6887b.getResponseStatus() != null && this.f6887b.getResponseStatus().isSuccessful()) {
            getActivity().setResult(-1, getActivity().getIntent());
        }
    }

    public void resetFields() {
        this.f6889d.setText("");
    }
}
