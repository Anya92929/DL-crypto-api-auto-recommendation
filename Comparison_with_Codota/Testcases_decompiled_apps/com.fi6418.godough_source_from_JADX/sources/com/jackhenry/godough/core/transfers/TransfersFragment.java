package com.jackhenry.godough.core.transfers;

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
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.accounts.C1418a;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.Transfer;
import com.jackhenry.godough.core.model.TransferOption;
import com.jackhenry.godough.core.model.TransferToAccount;
import com.jackhenry.godough.core.p034b.p035a.C1510a;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.DollarAmountEditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class TransfersFragment extends C1802r implements View.OnClickListener, DollarAmountEditText.OnValueChanged {
    public static final Object ACCOUNT_NO_FROM_DATA = "ACCOUNT_NO_FROM_DATA";
    public static final Object ACCOUNT_NO_TO_DATA = "ACCOUNT_NO_TO_DATA";
    public static final int DIALOG_TRANSFER_FAILED = 5017;
    public static final int DIALOG_TRANSFER_SUCCESS = 5016;

    /* renamed from: a */
    private ActionButton f6794a;

    /* renamed from: aj */
    private View f6795aj;

    /* renamed from: ak */
    private View f6796ak;

    /* renamed from: al */
    private View f6797al;

    /* renamed from: am */
    private View f6798am;

    /* renamed from: an */
    private RelativeLayout f6799an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public Account f6800ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public TransferToAccount f6801ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public TransferOption f6802aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public Calendar f6803ar;
    /* access modifiers changed from: private */

    /* renamed from: as */
    public List<Account> f6804as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public List<TransferToAccount> f6805at;

    /* renamed from: au */
    private AtomicInteger f6806au;

    /* renamed from: av */
    private C1895t<List<Account>> f6807av;

    /* renamed from: aw */
    private TransfersFragment f6808aw;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public C1898c f6809ax;

    /* renamed from: b */
    private ActionButton f6810b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DollarAmountEditText f6811c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f6812d;

    /* renamed from: e */
    private TextView f6813e;

    /* renamed from: f */
    private TextView f6814f;

    /* renamed from: g */
    private TextView f6815g;

    /* renamed from: h */
    private TextView f6816h;

    /* renamed from: i */
    private TextView f6817i;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6878a(Account account) {
        mo10986b(getString(C1506am.dg_loading_accounts));
        new C1896a(account, new C1912q(this, this, new C1908m(this, account))).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6882a(boolean z) {
        this.f6798am.setVisibility(z ? 0 : 8);
        if (!z) {
            this.f6802aq = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6897n() {
        if (getResources().getConfiguration().hardKeyboardHidden == 2 && getResources().getConfiguration().keyboardHidden == 1 && getResources().getConfiguration().orientation == 2) {
            this.f6811c.setHint(this.f6811c.hasFocus() ? getString(C1506am.lbl_amount) : getString(C1506am.amount_hint));
        } else {
            this.f6811c.setHint(C1506am.amount_hint);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6899o() {
        mo10988l();
        this.f6806au = new AtomicInteger(1);
        this.f6807av = new C1907l(this, this.f6808aw, new C1905j(this));
        getActivity().getSupportLoaderManager().initLoader(1, (Bundle) null, this.f6807av);
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m6901p() {
        if (this.f6806au.decrementAndGet() == 0) {
            mo10989m();
        }
    }

    /* renamed from: q */
    private synchronized void m6903q() {
        int i;
        m6910u();
        if (this.f6804as.size() != 0) {
            if (this.f6804as != null && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
                if (this.f6800ao != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.f6804as.size()) {
                            break;
                        } else if (this.f6804as.get(i2).equals(this.f6800ao)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                i = -1;
                C1418a aVar = new C1418a(getActivity(), C1496ak.selection_dialog_list_item, this.f6804as, i);
                C1512c cVar = new C1512c();
                cVar.mo9713b(getString(C1506am.lbl_transfer_from));
                cVar.mo9712a(aVar, i, new C1909n(this));
                cVar.show(getFragmentManager(), "SELECT_DIALOG");
            }
        }
    }

    /* renamed from: r */
    private synchronized void m6905r() {
        int i;
        m6910u();
        if (this.f6805at == null || this.f6805at.isEmpty()) {
            ((GodoughTransactionActivity) getActivity()).onNoData(ACCOUNT_NO_TO_DATA);
        } else if (getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            if (this.f6801ap != null) {
                i = 0;
                while (true) {
                    if (i >= this.f6805at.size()) {
                        break;
                    } else if (this.f6805at.get(i).equals(this.f6801ap)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            i = -1;
            C1915t tVar = new C1915t(this, getActivity(), C1496ak.list_item_2_single_choice, this.f6805at, i);
            C1512c cVar = new C1512c();
            cVar.mo9713b(getString(C1506am.lbl_transfer_to));
            cVar.mo9712a(tVar, i, new C1910o(this));
            cVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* renamed from: s */
    private synchronized void m6907s() {
        m6910u();
        if (getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            C1510a aVar = new C1510a();
            aVar.mo9709b(getString(C1506am.select_date));
            aVar.mo9707a(this.f6803ar);
            aVar.mo9710b(Calendar.getInstance());
            aVar.mo9706a((OnDateChosen) new C1911p(this, aVar));
            aVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* renamed from: t */
    private synchronized void m6909t() {
        int i;
        m6910u();
        List<TransferOption> transferOptions = this.f6801ap == null ? null : this.f6801ap.getTransferOptions();
        if (transferOptions != null && this.f6801ap.hasTransferOptions() && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            if (this.f6802aq != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= transferOptions.size()) {
                        break;
                    } else if (transferOptions.get(i2).equals(this.f6802aq)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            i = -1;
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), C1496ak.selection_dialog_list_item, transferOptions);
            C1512c cVar = new C1512c();
            cVar.mo9713b(getString(C1506am.lbl_payment_type));
            cVar.mo9712a(arrayAdapter, i, new C1901f(this, transferOptions));
            cVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* renamed from: u */
    private void m6910u() {
        if (this.f6799an != null) {
            this.f6799an.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m6911v() {
        long cents = this.f6811c.getCents();
        if (this.f6800ao == null || this.f6801ap == null || this.f6803ar == null || cents <= 0) {
            this.f6810b.setEnabled(false);
        } else if (!this.f6801ap.hasTransferOptions() || this.f6802aq != null) {
            this.f6810b.setEnabled(true);
        } else {
            this.f6810b.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m6912w() {
        if (this.f6803ar == null) {
            this.f6816h.setText(getString(C1506am.tap_select));
            this.f6816h.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            return;
        }
        this.f6816h.setText(new SimpleDateFormat("MM/dd/yyyy", Locale.US).format(this.f6803ar.getTime()));
        this.f6816h.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m6913x() {
        boolean z = true;
        this.f6813e.setVisibility(8);
        if (this.f6800ao != null) {
            this.f6812d.setText(this.f6800ao.getName());
            this.f6812d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            if (this.f6800ao.isShowBalance()) {
                this.f6813e.setText(getString(C1506am.balance_value, this.f6800ao.getFiDefinedBalanceFormatted()));
                this.f6813e.setVisibility(0);
            } else {
                this.f6813e.setText("");
            }
        } else {
            this.f6812d.setText(getString(C1506am.tap_select));
            this.f6812d.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            this.f6813e.setText(getString(C1506am.balance_value, ""));
        }
        this.f6815g.setVisibility(8);
        if (this.f6801ap != null) {
            Account account = this.f6801ap.getAccount();
            this.f6814f.setText(account.getName());
            this.f6814f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            if (account.isShowBalance()) {
                this.f6815g.setText(getString(C1506am.balance_value, account.getFiDefinedBalanceFormatted()));
                this.f6815g.setVisibility(0);
            } else {
                this.f6815g.setText("");
            }
            m6882a(this.f6801ap.hasTransferOptions());
        } else {
            this.f6814f.setText(getString(C1506am.tap_select));
            this.f6814f.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            this.f6815g.setText(getString(C1506am.balance_value, ""));
            this.f6802aq = null;
            m6882a(false);
            m6914y();
        }
        View view = this.f6796ak;
        if (this.f6800ao == null) {
            z = false;
        }
        view.setEnabled(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m6914y() {
        if (this.f6802aq == null) {
            this.f6817i.setText(getString(C1506am.tap_select));
            this.f6817i.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            return;
        }
        this.f6817i.setText(this.f6802aq.getDescription());
        this.f6817i.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void onClick(View view) {
        if (view == this.f6794a.getButton()) {
            transferAnother();
        } else if (view == this.f6810b.getButton()) {
            submitData();
        } else if (view == this.f6795aj) {
            getActivity().getSupportLoaderManager().restartLoader(1, (Bundle) null, this.f6807av);
            m6903q();
        } else if (view == this.f6796ak) {
            m6905r();
        } else if (view == this.f6797al) {
            m6907s();
        } else if (view == this.f6798am) {
            m6909t();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f6803ar == null) {
            this.f6803ar = Calendar.getInstance();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6799an = (RelativeLayout) layoutInflater.inflate(C1496ak.transfers_fragment, viewGroup);
        this.f6795aj = this.f6799an.findViewById(C1494ai.transfer_from_zone);
        this.f6796ak = this.f6799an.findViewById(C1494ai.transfer_to_zone);
        this.f6798am = this.f6799an.findViewById(C1494ai.type_zone);
        this.f6797al = this.f6799an.findViewById(C1494ai.date_zone);
        this.f6808aw = this;
        this.f6811c = (DollarAmountEditText) this.f6799an.findViewById(C1494ai.amount_edit);
        this.f6811c.setOnValueChanged(this);
        m6897n();
        this.f6811c.setOnFocusChangeListener(new C1900e(this, this.f6811c.getOnFocusChangeListener()));
        this.f6811c.setOnBackKeyPressedListener(new C1903h(this));
        this.f6811c.setOnEditorActionListener(new C1904i(this));
        this.f6812d = (TextView) this.f6799an.findViewById(C1494ai.from_account);
        this.f6813e = (TextView) this.f6799an.findViewById(C1494ai.from_balance);
        this.f6814f = (TextView) this.f6799an.findViewById(C1494ai.to_account);
        this.f6815g = (TextView) this.f6799an.findViewById(C1494ai.to_balance);
        this.f6817i = (TextView) this.f6799an.findViewById(C1494ai.transfer_type);
        this.f6816h = (TextView) this.f6799an.findViewById(C1494ai.transfer_date);
        this.f6794a = (ActionButton) this.f6799an.findViewById(C1494ai.btn_cancel);
        this.f6810b = (ActionButton) this.f6799an.findViewById(C1494ai.btn_submit);
        this.f6795aj.setOnClickListener(this);
        this.f6796ak.setOnClickListener(this);
        this.f6798am.setOnClickListener(this);
        this.f6797al.setOnClickListener(this);
        this.f6794a.setOnClickListener(this);
        this.f6810b.setOnClickListener(this);
        m6913x();
        m6914y();
        m6912w();
        m6911v();
        m6899o();
        return this.f6799an;
    }

    public void onStart() {
        super.onStart();
        if (this.f6809ax == null) {
            return;
        }
        if (this.f6809ax == null || !this.f6809ax.mo10926c()) {
            mo10986b(getString(C1506am.ellipse_transferring));
        } else if (this.f6809ax.mo10929e()) {
            this.f6809ax.mo10922a().mo9589a(this.f6809ax.mo10927d());
        } else {
            this.f6809ax.mo10922a().mo9588a(this.f6809ax.mo10925b());
        }
    }

    public void onValueChanged(DollarAmountEditText dollarAmountEditText) {
        m6911v();
    }

    public void submitData() {
        Transfer transfer = new Transfer(this.f6800ao, this.f6801ap.getAccount(), this.f6802aq, this.f6811c.getCents(), this.f6803ar);
        mo10986b(getString(C1506am.ellipse_transferring));
        this.f6809ax = new C1898c(transfer, new C1913r(this, this, new C1902g(this)));
        this.f6809ax.execute(new Void[0]);
    }

    public void transferAnother() {
        this.f6800ao = null;
        this.f6801ap = null;
        this.f6802aq = null;
        this.f6803ar = Calendar.getInstance();
        getActivity().getSupportLoaderManager().restartLoader(1, (Bundle) null, this.f6807av);
        this.f6811c.setText("");
        this.f6805at = null;
        m6910u();
        m6913x();
        m6914y();
        m6912w();
        m6911v();
    }
}
