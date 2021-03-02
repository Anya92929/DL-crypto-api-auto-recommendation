package com.jackhenry.godough.core.billpay;

import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.android.widget.calendar.OnDateChosen;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.BillPayPayee;
import com.jackhenry.godough.core.model.BillPayPaymentDate;
import com.jackhenry.godough.core.model.BillPayment;
import com.jackhenry.godough.core.p034b.p035a.C1510a;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.DollarAmountEditText;
import com.jackhenry.godough.core.widgets.JhaEditText;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BillPayFragment extends C1802r implements View.OnClickListener, DollarAmountEditText.OnValueChanged {
    public static final int DIALOG_BILL_PAY_SUCCESS = 5014;

    /* renamed from: a */
    private ActionButton f6013a;

    /* renamed from: aj */
    private View f6014aj;

    /* renamed from: ak */
    private View f6015ak;

    /* renamed from: al */
    private View f6016al;

    /* renamed from: am */
    private RelativeLayout f6017am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public BillPayPayee f6018an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public Account f6019ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public BillPayPaymentDate f6020ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public List<BillPayPayee> f6021aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public List<Account> f6022ar;
    /* access modifiers changed from: private */

    /* renamed from: as */
    public List<BillPayPaymentDate> f6023as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public List<Calendar> f6024at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public AtomicInteger f6025au;

    /* renamed from: av */
    private BillPayFragment f6026av;

    /* renamed from: aw */
    private C1895t<List<Account>> f6027aw;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public C1543y f6028ax;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public C1541w f6029ay;

    /* renamed from: b */
    private ActionButton f6030b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DollarAmountEditText f6031c;

    /* renamed from: d */
    private TextView f6032d;

    /* renamed from: e */
    private TextView f6033e;

    /* renamed from: f */
    private TextView f6034f;

    /* renamed from: g */
    private TextView f6035g;

    /* renamed from: h */
    private TextView f6036h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public JhaEditText f6037i;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6008a(BillPayPayee billPayPayee) {
        mo10986b(getString(C1506am.ellipse_loading_payment_dates));
        this.f6029ay = new C1541w(billPayPayee, new C1538t(this, this, new C1524f(this, billPayPayee)));
        this.f6029ay.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6025n() {
        this.f6037i.setHint(getString(C1506am.lbl_memo_hint));
        this.f6031c.setHint(getString(C1506am.amount_hint));
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6028o() {
        mo10988l();
        this.f6025au = new AtomicInteger(2);
        C1531m mVar = new C1531m(this);
        this.f6027aw = new C1533o(this, this.f6026av, mVar);
        getActivity().getSupportLoaderManager().initLoader(1, (Bundle) null, new C1534p(this, this.f6026av, mVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m6029p() {
        if (this.f6025au.get() == 0) {
            mo10989m();
            if (this.f6021aq == null || this.f6021aq.isEmpty()) {
                ((GodoughTransactionActivity) getActivity()).onNoData(C1539u.PAYEE);
            } else if (this.f6022ar == null || this.f6022ar.isEmpty()) {
                ((GodoughTransactionActivity) getActivity()).onNoData(C1539u.PAY_FROM);
            }
        } else if (this.f6025au.get() == 1) {
            getActivity().getSupportLoaderManager().initLoader(2, (Bundle) null, this.f6027aw);
        }
    }

    /* renamed from: q */
    private synchronized void m6031q() {
        int i;
        m6037t();
        if (this.f6021aq != null && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), C1496ak.selection_dialog_list_item, this.f6021aq);
            arrayAdapter.setDropDownViewResource(C1496ak.selection_dialog_list_item);
            if (this.f6018an != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f6021aq.size()) {
                        break;
                    } else if (this.f6021aq.get(i2).equals(this.f6018an)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            i = -1;
            C1512c cVar = new C1512c();
            cVar.mo9713b(getString(C1506am.select_payee));
            cVar.mo9712a(arrayAdapter, i, new C1521c(this));
            cVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* renamed from: r */
    private synchronized void m6034r() {
        int i;
        m6037t();
        if (this.f6022ar != null && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            if (this.f6019ao != null) {
                i = 0;
                while (true) {
                    if (i >= this.f6022ar.size()) {
                        break;
                    } else if (this.f6022ar.get(i) == this.f6019ao) {
                        break;
                    } else {
                        i++;
                    }
                }
                C1535q qVar = new C1535q(this, getActivity(), C1496ak.selection_dialog_list_item, this.f6022ar, i);
                qVar.setDropDownViewResource(C1496ak.selection_dialog_list_item);
                C1512c cVar = new C1512c();
                cVar.mo9713b(getString(C1506am.select_account));
                cVar.mo9712a(qVar, i, new C1522d(this));
                cVar.show(getFragmentManager(), "SELECT_DIALOG");
            }
            i = -1;
            C1535q qVar2 = new C1535q(this, getActivity(), C1496ak.selection_dialog_list_item, this.f6022ar, i);
            qVar2.setDropDownViewResource(C1496ak.selection_dialog_list_item);
            C1512c cVar2 = new C1512c();
            cVar2.mo9713b(getString(C1506am.select_account));
            cVar2.mo9712a(qVar2, i, new C1522d(this));
            cVar2.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* renamed from: s */
    private synchronized void m6036s() {
        m6037t();
        if (this.f6018an == null) {
            ((GodoughTransactionActivity) getActivity()).onNoData(C1539u.PAYEE_NOT_SELECTED);
        } else if (this.f6023as == null || this.f6023as.isEmpty()) {
            ((GodoughTransactionActivity) getActivity()).onNoData(C1539u.DATE);
        } else if (getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            C1510a aVar = new C1510a();
            aVar.mo9709b(getString(C1506am.select_date));
            if (this.f6020ap != null) {
                aVar.mo9707a(this.f6020ap.getProcessedDate());
            }
            aVar.mo9710b(Calendar.getInstance());
            aVar.mo9708a(this.f6024at);
            aVar.mo9706a((OnDateChosen) new C1523e(this, aVar));
            aVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* renamed from: t */
    private void m6037t() {
        if (this.f6017am != null) {
            this.f6017am.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m6039u() {
        this.f6035g.setVisibility(8);
        if (this.f6020ap == null) {
            this.f6034f.setText(getString(C1506am.lbl_select_date));
            this.f6034f.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            this.f6035g.setText(GoDoughApp.getUserSettings().getBillPayDeliveryDateLabelText());
            return;
        }
        this.f6034f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6034f.setText(this.f6020ap.getProcessedDateFormatted());
        if (GoDoughApp.getUserSettings().getIsBillPayEstimatedArrivalCalendarEnabled()) {
            this.f6035g.setVisibility(0);
            this.f6035g.setText(GoDoughApp.getUserSettings().getBillPayDeliveryDateLabelText() + " " + this.f6020ap.getDeliveredDateFormatted());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m6041v() {
        if (this.f6019ao == null) {
            this.f6033e.setText(getString(C1506am.lbl_select_account));
            this.f6033e.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            this.f6036h.setText(getString(C1506am.balance_value, ""));
            this.f6036h.setVisibility(8);
            return;
        }
        this.f6033e.setText(this.f6019ao.getName());
        this.f6033e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6036h.setText(getString(C1506am.balance_value, this.f6019ao.getFiDefinedBalanceFormatted()));
        if (this.f6019ao.isShowBalance()) {
            this.f6036h.setVisibility(0);
        } else {
            this.f6036h.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m6043w() {
        if (this.f6018an == null) {
            this.f6032d.setText(getString(C1506am.lbl_select_payee));
            this.f6032d.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            return;
        }
        this.f6032d.setText(this.f6018an.getNickname());
        this.f6032d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m6044x() {
        if (this.f6031c.getCents() <= 0 || this.f6018an == null || this.f6019ao == null || this.f6020ap == null) {
            this.f6030b.setEnabled(false);
        } else {
            this.f6030b.setEnabled(true);
        }
    }

    public void onClick(View view) {
        if (view == this.f6013a.getButton()) {
            payAnother();
        } else if (view == this.f6030b.getButton()) {
            submitData(new BillPayment(this.f6018an, this.f6019ao, this.f6020ap.getProcessedDate(), this.f6031c.getCents(), this.f6037i.getText().toString()));
        } else if (view == this.f6014aj) {
            m6031q();
        } else if (view == this.f6015ak) {
            m6034r();
        } else if (view == this.f6016al) {
            m6036s();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6026av = this;
        this.f6017am = (RelativeLayout) layoutInflater.inflate(C1496ak.bill_pay_fragment, viewGroup);
        this.f6031c = (DollarAmountEditText) this.f6017am.findViewById(C1494ai.amount_edit);
        this.f6031c.setOnValueChanged(this);
        this.f6032d = (TextView) this.f6017am.findViewById(C1494ai.payee);
        this.f6033e = (TextView) this.f6017am.findViewById(C1494ai.account);
        this.f6036h = (TextView) this.f6017am.findViewById(C1494ai.balance);
        this.f6034f = (TextView) this.f6017am.findViewById(C1494ai.date);
        this.f6035g = (TextView) this.f6017am.findViewById(C1494ai.est_arrival);
        this.f6037i = (JhaEditText) this.f6017am.findViewById(C1494ai.memo_edit);
        ((TextView) this.f6017am.findViewById(C1494ai.date_label)).setText(GoDoughApp.getUserSettings().getBillPayUserDateLabelText());
        this.f6035g.setText(GoDoughApp.getUserSettings().getBillPayDeliveryDateLabelText());
        this.f6014aj = this.f6017am.findViewById(C1494ai.payee_panel);
        this.f6015ak = this.f6017am.findViewById(C1494ai.pay_from_panel);
        this.f6016al = this.f6017am.findViewById(C1494ai.date_panel);
        this.f6013a = (ActionButton) this.f6017am.findViewById(C1494ai.btn_cancel);
        this.f6030b = (ActionButton) this.f6017am.findViewById(C1494ai.btn_submit);
        this.f6014aj.setOnClickListener(this);
        this.f6015ak.setOnClickListener(this);
        this.f6016al.setOnClickListener(this);
        this.f6013a.setOnClickListener(this);
        this.f6030b.setOnClickListener(this);
        m6025n();
        this.f6037i.setOnFocusChangeListener(new C1520b(this));
        this.f6037i.setOnBackKeyPressedListener(new C1526h(this));
        this.f6037i.setOnEditorActionListener(new C1527i(this));
        this.f6031c.setOnFocusChangeListener(new C1528j(this, this.f6031c.getOnFocusChangeListener()));
        this.f6031c.setOnBackKeyPressedListener(new C1529k(this));
        this.f6031c.setOnEditorActionListener(new C1530l(this));
        m6043w();
        m6041v();
        m6039u();
        m6044x();
        m6028o();
        return this.f6017am;
    }

    public void onStart() {
        super.onStart();
        if (this.f6028ax != null) {
            if (!this.f6028ax.mo10926c()) {
                mo10986b(getString(C1506am.ellipse_payment_processing));
            } else if (this.f6028ax.mo10929e()) {
                this.f6028ax.mo10922a().mo9589a(this.f6028ax.mo10927d());
            } else {
                this.f6028ax.mo10922a().mo9588a(this.f6028ax.mo10925b());
            }
        } else if (this.f6029ay == null) {
        } else {
            if (!this.f6029ay.mo10926c()) {
                mo10986b(getString(C1506am.ellipse_loading_payment_dates));
            } else if (this.f6029ay.mo10929e()) {
                this.f6029ay.mo10922a().mo9589a(this.f6029ay.mo10927d());
            } else {
                this.f6029ay.mo10922a().mo9588a(this.f6029ay.mo10925b());
            }
        }
    }

    public void onValueChanged(DollarAmountEditText dollarAmountEditText) {
        m6044x();
    }

    public void payAnother() {
        this.f6018an = null;
        this.f6019ao = null;
        this.f6020ap = null;
        this.f6031c.setText("");
        this.f6037i.setText("");
        m6037t();
        m6043w();
        m6041v();
        m6039u();
    }

    public void submitData(Object obj) {
        BillPayment billPayment = (BillPayment) obj;
        mo10986b(getString(C1506am.ellipse_payment_processing));
        this.f6028ax = new C1543y(billPayment, new C1536r(this, this, new C1525g(this, billPayment)));
        this.f6028ax.execute(new Void[0]);
    }
}
