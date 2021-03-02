package com.jackhenry.godough.core.accounts;

import android.graphics.Color;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1801q;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.AccountTransaction;
import com.jackhenry.godough.core.model.AccountTransactionList;

/* renamed from: com.jackhenry.godough.core.accounts.b */
public class C1422b extends C1801q<AccountTransaction> {

    /* renamed from: b */
    private Account f5848b;

    /* renamed from: c */
    private int f5849c;

    /* renamed from: d */
    private boolean f5850d;

    public C1422b(Account account, int i, Fragment fragment) {
        super(fragment);
        this.f5848b = account;
        this.f5849c = i;
    }

    public C1422b(Account account, Fragment fragment) {
        this(account, C1496ak.list_item_account_transactions, fragment);
    }

    /* renamed from: a */
    public C1349a<AccountTransaction> mo9278a(int i) {
        boolean z = true;
        boolean z2 = !this.f5850d;
        if (i < 0) {
            z = false;
        }
        if (!z || !z2) {
            i = 0;
        }
        AccountTransactionList a = new C1439s().mo9594a(this.f5848b.getName(), (long) i);
        return new C1349a<>(a.getAccountTransactions(), a.isMoreRecords(), a.getNextStartRecord());
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, AccountTransaction accountTransaction) {
        View inflate = layoutInflater.inflate(this.f5849c, viewGroup);
        TextView textView = (TextView) inflate.findViewById(C1494ai.line1);
        TextView textView2 = (TextView) inflate.findViewById(C1494ai.line2);
        TextView textView3 = (TextView) inflate.findViewById(C1494ai.tv_amount);
        TextView textView4 = (TextView) inflate.findViewById(C1494ai.tv_balance);
        ImageView imageView = (ImageView) inflate.findViewById(C1494ai.check_image);
        if (accountTransaction.getImages() == null || accountTransaction.getImages().size() <= 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setColorFilter(Color.parseColor("#0088BA"));
        }
        textView.setText(accountTransaction.getDescription());
        textView2.setText(accountTransaction.getPostDateFormatted());
        textView3.setText(accountTransaction.getAmountFormatted());
        String l = Long.toString(accountTransaction.getRunningBalance());
        if (!this.f5848b.isShowBalance()) {
            ((LinearLayout) inflate.findViewById(C1494ai.line2_right_balance)).setVisibility(8);
        } else if (this.f5848b.getAccountType().toLowerCase().trim().equals("loan") && l.equals("0")) {
            ((LinearLayout) inflate.findViewById(C1494ai.line2_right_balance)).setVisibility(8);
        } else if (l.matches("(^-?[0-9]+$)")) {
            textView4.setText(accountTransaction.getRunningBalanceFormatted());
        } else {
            textView4.setText(GoDoughApp.getApp().getResources().getString(C1506am.lbl_not_available));
        }
        if (accountTransaction.isCredit()) {
            textView3.setTextColor(GoDoughApp.getApp().getResources().getColor(C1491af.green));
        }
    }

    /* renamed from: a */
    public void mo9566a(boolean z) {
        this.f5850d = z;
    }

    /* renamed from: b */
    public boolean mo9567b(View view, Exception exc) {
        mo10985a(exc);
        return false;
    }
}
