package com.jackhenry.godough.core.billpay;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.BillPayment;

public class BillPayFragmentActivity extends GodoughTransactionActivity {
    public static final int DIALOG_BILL_PAY_FAILED = 5015;

    /* renamed from: m */
    private BillPayFragment f6038m;

    /* renamed from: n */
    private C1539u f6039n;

    /* renamed from: o */
    private BillPayment f6040o;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6038m;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.bill_pay_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getBillPay().getText());
        this.f6038m = (BillPayFragment) getSupportFragmentManager().findFragmentById(C1494ai.bill_pay);
        setTransactionFragment(this.f6038m);
    }

    public void onNoData(Object obj) {
        String string;
        this.f6039n = (C1539u) obj;
        String string2 = getString(C1506am.dg_error_title);
        if (obj == C1539u.PAYEE_NOT_SELECTED) {
            string = getString(C1506am.lbl_no_payee_selected);
            string2 = getString(C1506am.lbl_no_payee_selected_title);
        } else {
            string = obj == C1539u.PAYEE ? getString(C1506am.lbl_no_payees) : obj == C1539u.PAY_FROM ? getString(C1506am.lbl_no_payees) : getString(C1506am.lbl_no_dates);
        }
        showDialog(string2, string);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("EXTRA_BILL_PAYMENT", this.f6040o);
    }

    public void resetFields() {
        this.f6038m.payAnother();
    }
}
