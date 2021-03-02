package com.jackhenry.godough.core.accounts;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1354f;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.AccountTransaction;
import java.util.ArrayList;

public class AccountTransactionsFragment extends C1802r {
    public static final String EXTRA_ACCOUNT = "EXTRA_ACCOUNT";
    public static final int NO_REFRESH = 300;
    public static final String TAG = "AccountTransactionsFragment";
    public static final int VIEW_CHECK = 100;

    /* renamed from: a */
    C1422b f5815a;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public ImageView f5816aj;

    /* renamed from: b */
    AdapterView.OnItemClickListener f5817b = new C1425e(this);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1354f<AccountTransaction> f5818c;

    /* renamed from: d */
    private Account f5819d;

    /* renamed from: e */
    private ListView f5820e;

    /* renamed from: f */
    private boolean f5821f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<View> f5822g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f5823h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f5824i;

    /* renamed from: a */
    private void m5776a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str) && str.trim().length() > 0) {
            textView.setText(str);
        }
    }

    /* renamed from: b */
    private void m5778b(TextView textView, String str) {
        if (!TextUtils.isEmpty(str) && str.trim().length() > 0) {
            if (str.indexOf("(") >= 0 || this.f5819d.getAccountType().toLowerCase().equals("loan")) {
                textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                textView.setTextColor(GoDoughApp.getApp().getResources().getColor(C1491af.green));
            }
            textView.setText(str);
        }
    }

    public ListView getListView() {
        return this.f5820e;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 300 && i == 100) {
            this.f5821f = false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null || !bundle.containsKey("EXTRA_ACCOUNT")) {
            this.f5819d = (Account) getActivity().getIntent().getSerializableExtra("EXTRA_ACCOUNT");
        } else {
            this.f5819d = (Account) bundle.getSerializable("EXTRA_ACCOUNT");
        }
        this.f5815a = new C1422b(this.f5819d, this);
        if ((this.f5819d.isShowAvailableBalance() || this.f5819d.isShowCurrentBalance()) && this.f5819d.isShowBalance()) {
            this.f5818c = new C1354f<>(getActivity(), true, C1496ak.list_item_loading_account_transactions, C1496ak.list_item_loading_account_transactions, this.f5815a);
        } else {
            this.f5818c = new C1354f<>(getActivity(), true, C1496ak.list_item_loading, C1496ak.list_item_loading, this.f5815a);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((AbstractActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) this.f5819d.getName());
        this.f5822g = new ArrayList<>();
        this.f5823h = layoutInflater.inflate(C1496ak.account_transactions_fragment, (ViewGroup) null, false);
        if (this.f5819d.isShowBalance()) {
            if (this.f5819d.isShowCurrentBalance()) {
                TextView textView = (TextView) this.f5823h.findViewById(C1494ai.current_balance);
                m5778b(textView, this.f5819d.getCurrentBalanceFormatted());
                this.f5822g.add(textView);
                TextView textView2 = (TextView) this.f5823h.findViewById(C1494ai.current_balance_label);
                m5776a(textView2, this.f5819d.getCurrentBalanceLabel());
                this.f5822g.add(textView2);
            } else {
                this.f5823h.findViewById(C1494ai.current_balance_layout).setVisibility(8);
            }
            if (this.f5819d.isShowAvailableBalance()) {
                m5778b((TextView) this.f5823h.findViewById(C1494ai.available_balance), this.f5819d.getAvailableBalanceFormatted());
                m5776a((TextView) this.f5823h.findViewById(C1494ai.available_balance_label), this.f5819d.getAvailableBalanceLabel());
                this.f5816aj = (ImageView) this.f5823h.findViewById(C1494ai.balance_info_icon);
                if (this.f5819d.getAvailableBalanceDisclosureText() == null || this.f5819d.getAvailableBalanceDisclosureText().length() <= 0) {
                    this.f5816aj.setVisibility(8);
                } else {
                    ((TextView) this.f5823h.findViewById(C1494ai.available_balance_label)).setTextColor(Color.parseColor("#0088BA"));
                    this.f5816aj = (ImageView) this.f5823h.findViewById(C1494ai.balance_info_icon);
                    this.f5816aj.setVisibility(0);
                    this.f5823h.findViewById(C1494ai.available_balance_layout).setOnClickListener(new C1423c(this));
                }
                this.f5824i = this.f5823h.findViewById(C1494ai.available_balance_holder);
                this.f5822g.add(this.f5824i);
            } else {
                this.f5823h.findViewById(C1494ai.available_balance_layout).setVisibility(8);
            }
            if (getResources().getConfiguration().orientation == 2) {
                this.f5823h.getViewTreeObserver().addOnGlobalLayoutListener(new C1424d(this));
            } else {
                LinearLayout linearLayout = (LinearLayout) this.f5823h.findViewById(C1494ai.balance_layout);
                if (!this.f5819d.isShowAvailableBalance() || !this.f5819d.isShowCurrentBalance()) {
                    linearLayout.setWeightSum(1.0f);
                } else {
                    ((TextView) this.f5823h.findViewById(C1494ai.balance_divider)).setVisibility(0);
                    linearLayout.setWeightSum(2.0f);
                }
            }
        }
        View findViewById = this.f5823h.findViewById(16908292);
        this.f5820e = (ListView) this.f5823h.findViewById(C1494ai.list);
        this.f5820e.setOnItemClickListener(this.f5817b);
        this.f5820e.setAdapter(this.f5818c);
        this.f5820e.setEmptyView(findViewById);
        this.f5821f = false;
        return this.f5823h;
    }

    public void onPause() {
        super.onPause();
        this.f5821f = true;
    }

    public void onResume() {
        super.onResume();
        if (this.f5821f) {
            this.f5818c.mo9282h();
            this.f5815a.mo9566a(true);
            this.f5818c.mo6276d();
            this.f5818c.notifyDataSetChanged();
            this.f5821f = false;
        }
    }
}
