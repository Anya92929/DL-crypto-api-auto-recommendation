package com.jackhenry.godough.core.p2p;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
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
import com.jackhenry.godough.core.login.C1629aa;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.P2PPayee;
import com.jackhenry.godough.core.model.P2PPayment;
import com.jackhenry.godough.core.model.P2PPaymentDate;
import com.jackhenry.godough.core.p034b.p035a.C1510a;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.DollarAmountEditText;
import com.jackhenry.godough.core.widgets.JhaEditText;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class P2PFragment extends C1802r implements View.OnClickListener, DollarAmountEditText.OnValueChanged {
    public static final int ADD_PAYEE = 2;
    public static final int MFA_REDIRECT = 0;

    /* renamed from: a */
    private ActionButton f6529a;
    /* access modifiers changed from: private */

    /* renamed from: aA */
    public C1772al f6530aA;

    /* renamed from: aj */
    private View f6531aj;

    /* renamed from: ak */
    private View f6532ak;

    /* renamed from: al */
    private RelativeLayout f6533al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public P2PPayee f6534am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public Account f6535an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public P2PPaymentDate f6536ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public List<P2PPayee> f6537ap = new ArrayList();

    /* renamed from: aq */
    private ArrayAdapter<P2PPayee> f6538aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public List<Account> f6539ar;

    /* renamed from: as */
    private C1895t<List<P2PPayee>> f6540as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public AtomicInteger f6541at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public List<P2PPaymentDate> f6542au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public List<Calendar> f6543av;
    /* access modifiers changed from: private */

    /* renamed from: aw */
    public C1512c f6544aw;

    /* renamed from: ax */
    private TextView f6545ax;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public C1760a f6546ay;
    /* access modifiers changed from: private */

    /* renamed from: az */
    public C1629aa f6547az;

    /* renamed from: b */
    private ActionButton f6548b;

    /* renamed from: c */
    private TextView f6549c;

    /* renamed from: d */
    private TextView f6550d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DollarAmountEditText f6551e;

    /* renamed from: f */
    private TextView f6552f;

    /* renamed from: g */
    private TextView f6553g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public JhaEditText f6554h;

    /* renamed from: i */
    private View f6555i;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6561a(P2PPayee p2PPayee) {
        mo10986b(getString(C1506am.ellipse_loading_payment_dates));
        this.f6546ay = new C1760a(p2PPayee, new C1769ai(this, this, new C1789r(this, p2PPayee)));
        this.f6546ay.execute(new Void[0]);
    }

    /* renamed from: n */
    private synchronized void m6580n() {
        int i;
        m6581o();
        if (this.f6537ap != null && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            this.f6538aq = new ArrayAdapter<>(getActivity(), C1496ak.selection_dialog_list_item, this.f6537ap);
            this.f6538aq.setDropDownViewResource(17367055);
            this.f6544aw = new C1512c();
            if (this.f6534am != null) {
                i = 0;
                while (true) {
                    if (i >= this.f6537ap.size()) {
                        break;
                    } else if (this.f6537ap.get(i).equals(this.f6534am)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            i = -1;
            LinearLayout linearLayout = (LinearLayout) getLayoutInflater((Bundle) null).inflate(C1496ak.p2p_select_person_dialog_footer, (ViewGroup) null);
            linearLayout.setOnClickListener(new C1797z(this));
            this.f6544aw.mo9713b(getString(C1506am.lbl_select_person));
            this.f6544aw.mo9712a(this.f6538aq, i, new C1761aa(this));
            this.f6544aw.mo9711a(linearLayout);
            this.f6544aw.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* renamed from: o */
    private void m6581o() {
        if (this.f6533al != null) {
            this.f6533al.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m6584p() {
        mo10988l();
        this.f6541at = new AtomicInteger(2);
        C1762ab abVar = new C1762ab(this);
        this.f6540as = new C1785n(this, this, abVar);
        getActivity().getSupportLoaderManager().initLoader(1, (Bundle) null, new C1786o(this, this, abVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m6585q() {
        if (this.f6541at.get() == 0) {
            mo10989m();
            if (this.f6537ap != null && !this.f6537ap.isEmpty()) {
                if (this.f6539ar == null || this.f6539ar.isEmpty()) {
                    ((GodoughTransactionActivity) getActivity()).onNoData(C1766af.PAY_FROM);
                }
            }
        } else if (this.f6541at.get() == 1) {
            getActivity().getSupportLoaderManager().initLoader(0, (Bundle) null, this.f6540as);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m6587r() {
        if (this.f6534am == null) {
            this.f6549c.setText(getString(C1506am.lbl_select_payee));
            this.f6549c.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            return;
        }
        this.f6549c.setText(this.f6534am.getNickname());
        this.f6549c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m6590s() {
        if (this.f6535an == null) {
            this.f6550d.setText(getString(C1506am.lbl_select_account));
            this.f6550d.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            this.f6553g.setText(getString(C1506am.balance_value, ""));
            this.f6553g.setVisibility(8);
            return;
        }
        this.f6550d.setText(this.f6535an.getName());
        this.f6550d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6553g.setText(getString(C1506am.balance_value, this.f6535an.getFiDefinedBalanceFormatted()));
        if (this.f6535an.isShowBalance()) {
            this.f6553g.setVisibility(0);
        } else {
            this.f6553g.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m6592t() {
        this.f6545ax.setVisibility(8);
        if (this.f6536ao == null) {
            this.f6552f.setText(getString(C1506am.lbl_select_date));
            this.f6552f.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            this.f6545ax.setText(GoDoughApp.getUserSettings().getP2PDeliveryDateLabelText());
            return;
        }
        this.f6552f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6552f.setText(this.f6536ao.getProcessedDateFormatted());
        if (GoDoughApp.getUserSettings().isP2PEstimatedArrivalCalendarEnabled()) {
            this.f6545ax.setVisibility(0);
            this.f6545ax.setText(GoDoughApp.getUserSettings().getP2PDeliveryDateLabelText() + " " + this.f6536ao.getDeliveredDateFormatted());
        }
    }

    /* renamed from: u */
    private synchronized void m6593u() {
        m6581o();
        if (this.f6534am == null) {
            ((GodoughTransactionActivity) getActivity()).onNoData(C1766af.PAYEE_NOT_SELECTED);
        } else if (this.f6542au == null || this.f6542au.isEmpty()) {
            ((GodoughTransactionActivity) getActivity()).onNoData(C1766af.DATE);
        } else if (getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            C1510a aVar = new C1510a();
            aVar.mo9709b(getString(C1506am.select_date));
            if (this.f6536ao != null) {
                aVar.mo9707a(this.f6536ao.getProcessedDate());
            }
            aVar.mo9710b(Calendar.getInstance());
            aVar.mo9708a(this.f6543av);
            aVar.mo9706a((OnDateChosen) new C1787p(this, aVar));
            aVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m6595v() {
        if (this.f6551e.getCents() <= 0 || this.f6534am == null || this.f6535an == null || this.f6536ao == null) {
            this.f6548b.setEnabled(false);
        } else {
            this.f6548b.setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m6597w() {
        this.f6554h.setHint(getString(C1506am.lbl_memo_hint));
        this.f6551e.setHint(getString(C1506am.amount_hint));
    }

    /* renamed from: x */
    private synchronized void m6599x() {
        int i;
        m6581o();
        if (this.f6539ar != null && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            if (this.f6535an != null) {
                i = 0;
                while (true) {
                    if (i >= this.f6539ar.size()) {
                        break;
                    } else if (this.f6539ar.get(i) == this.f6535an) {
                        break;
                    } else {
                        i++;
                    }
                }
                C1783l lVar = new C1783l(getActivity(), C1496ak.selection_dialog_list_item, this.f6539ar, i);
                lVar.setDropDownViewResource(C1496ak.selection_dialog_list_item);
                C1512c cVar = new C1512c();
                cVar.mo9713b(getString(C1506am.select_account));
                cVar.mo9712a(lVar, i, new C1788q(this));
                cVar.show(getFragmentManager(), "SELECT_DIALOG");
            }
            i = -1;
            C1783l lVar2 = new C1783l(getActivity(), C1496ak.selection_dialog_list_item, this.f6539ar, i);
            lVar2.setDropDownViewResource(C1496ak.selection_dialog_list_item);
            C1512c cVar2 = new C1512c();
            cVar2.mo9713b(getString(C1506am.select_account));
            cVar2.mo9712a(lVar2, i, new C1788q(this));
            cVar2.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m6601y() {
        this.f6547az = new C1629aa(new C1764ad(this, this, new C1791t(this)));
        this.f6547az.execute(new Void[0]);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (i2 == -1) {
                submitData();
            } else if (i2 == 0) {
                ((GodoughTransactionActivity) getActivity()).setResetFields(false);
            }
        } else if (2 == i) {
            ((GodoughTransactionActivity) getActivity()).setResetFields(false);
            if (-1 == i2) {
                mo10988l();
                this.f6541at = new AtomicInteger(1);
                getActivity().getSupportLoaderManager().restartLoader(0, (Bundle) null, this.f6540as);
                this.f6534am = (P2PPayee) intent.getSerializableExtra(P2PAddPersonFragmentActivity.EXTRA_PERSON);
                m6587r();
                m6595v();
                m6561a(this.f6534am);
            }
        }
    }

    public void onClick(View view) {
        if (view == this.f6529a.getButton()) {
            payAnother();
        } else if (view == this.f6548b.getButton()) {
            submitData();
        } else if (view == this.f6555i) {
            m6580n();
        } else if (view == this.f6531aj) {
            m6599x();
        } else if (view == this.f6532ak) {
            m6593u();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6533al = (RelativeLayout) layoutInflater.inflate(C1496ak.p2p_fragment, viewGroup);
        this.f6551e = (DollarAmountEditText) this.f6533al.findViewById(C1494ai.amount_edit);
        this.f6551e.setOnValueChanged(this);
        this.f6549c = (TextView) this.f6533al.findViewById(C1494ai.person);
        this.f6550d = (TextView) this.f6533al.findViewById(C1494ai.account);
        this.f6553g = (TextView) this.f6533al.findViewById(C1494ai.balance);
        this.f6552f = (TextView) this.f6533al.findViewById(C1494ai.date);
        this.f6554h = (JhaEditText) this.f6533al.findViewById(C1494ai.memo_edit);
        this.f6545ax = (TextView) this.f6533al.findViewById(C1494ai.est_arrival);
        this.f6545ax.setText(GoDoughApp.getUserSettings().getP2PDeliveryDateLabelText());
        ((TextView) this.f6533al.findViewById(C1494ai.date_label)).setText(GoDoughApp.getUserSettings().getP2PUserDateLabelText());
        this.f6555i = this.f6533al.findViewById(C1494ai.person_panel);
        this.f6531aj = this.f6533al.findViewById(C1494ai.pay_from_panel);
        this.f6532ak = this.f6533al.findViewById(C1494ai.date_panel);
        this.f6529a = (ActionButton) this.f6533al.findViewById(C1494ai.btn_cancel);
        this.f6548b = (ActionButton) this.f6533al.findViewById(C1494ai.btn_submit);
        this.f6555i.setOnClickListener(this);
        this.f6531aj.setOnClickListener(this);
        this.f6532ak.setOnClickListener(this);
        this.f6529a.setOnClickListener(this);
        this.f6548b.setOnClickListener(this);
        m6597w();
        this.f6554h.setOnFocusChangeListener(new C1784m(this));
        this.f6554h.setOnBackKeyPressedListener(new C1792u(this));
        this.f6554h.setOnEditorActionListener(new C1793v(this));
        this.f6551e.setOnFocusChangeListener(new C1794w(this, this.f6551e.getOnFocusChangeListener()));
        this.f6551e.setOnBackKeyPressedListener(new C1795x(this));
        this.f6551e.setOnEditorActionListener(new C1796y(this));
        m6587r();
        m6590s();
        m6592t();
        m6595v();
        m6584p();
        return this.f6533al;
    }

    public void onStart() {
        super.onStart();
        if (this.f6530aA != null || this.f6547az != null || this.f6546ay != null) {
            if (this.f6530aA == null || !this.f6530aA.mo10926c()) {
                if (this.f6547az == null || !this.f6547az.mo10926c()) {
                    if (this.f6546ay == null) {
                        mo10986b(getString(C1506am.ellipse_payment_processing));
                    } else if (!this.f6546ay.mo10926c()) {
                        mo10986b(getString(C1506am.ellipse_loading_payment_dates));
                    } else if (this.f6546ay.mo10929e()) {
                        this.f6546ay.mo10922a().mo9589a(this.f6546ay.mo10927d());
                    } else {
                        this.f6546ay.mo10922a().mo9588a(this.f6546ay.mo10925b());
                    }
                } else if (this.f6547az.mo10929e()) {
                    this.f6547az.mo10922a().mo9589a(this.f6547az.mo10927d());
                } else {
                    this.f6547az.mo10922a().mo9588a(this.f6547az.mo10925b());
                }
            } else if (this.f6530aA.mo10929e()) {
                this.f6530aA.mo10922a().mo9589a(this.f6530aA.mo10927d());
            } else {
                this.f6530aA.mo10922a().mo9588a(this.f6530aA.mo10925b());
            }
        }
    }

    public void onValueChanged(DollarAmountEditText dollarAmountEditText) {
        m6595v();
    }

    public void payAnother() {
        this.f6534am = null;
        this.f6535an = null;
        this.f6536ao = null;
        this.f6551e.setText("");
        this.f6554h.setText("");
        m6581o();
        m6587r();
        m6590s();
        m6592t();
    }

    public void submitData() {
        P2PPayment p2PPayment = new P2PPayment(this.f6534am, this.f6535an, this.f6536ao.getProcessedDate(), this.f6551e.getCents(), this.f6554h.getText().toString());
        mo10986b(getString(C1506am.ellipse_payment_processing));
        this.f6530aA = new C1772al(p2PPayment, new C1767ag(this, this, new C1790s(this)));
        this.f6530aA.execute(new Void[0]);
    }
}
