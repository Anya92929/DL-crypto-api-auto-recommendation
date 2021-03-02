package com.jackhenry.godough.core.accounts;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.about.AvailableBalanceDisclosureFragment;
import com.jackhenry.godough.core.model.Account;

public class AccountTransactionsFragmentActivity extends AbstractActivity {
    public static final String EXTRA_ACCOUNT = "EXTRA_ACCOUNT";

    /* renamed from: m */
    Account f5825m;

    /* renamed from: n */
    private AccountTransactionsFragment f5826n;

    /* renamed from: o */
    private AvailableBalanceDisclosureFragment f5827o;

    /* renamed from: p */
    private String f5828p;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentByTag(this.f5828p);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setShowArrowOnToolbar(true);
        setContentView(C1496ak.account_transactions_activity);
        this.f5825m = (Account) getIntent().getSerializableExtra("EXTRA_ACCOUNT");
        if (bundle == null) {
            this.f5826n = new AccountTransactionsFragment();
            getSupportFragmentManager().beginTransaction().replace(C1494ai.container, this.f5826n, AccountTransactionsFragment.TAG).commit();
            this.f5828p = AccountTransactionsFragment.TAG;
            return;
        }
        this.f5828p = bundle.getString("EXTRA_CURRENT_FRAGMENT_TAG");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f5828p.equals(AvailableBalanceDisclosureFragment.TAG)) {
            return super.onKeyDown(i, keyEvent);
        }
        this.f5828p = AccountTransactionsFragment.TAG;
        if (this.f5826n == null) {
            this.f5826n = new AccountTransactionsFragment();
        }
        getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(AvailableBalanceDisclosureFragment.TAG)).replace(C1494ai.container, this.f5826n, AccountTransactionsFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                if (this.f5828p.equals(AvailableBalanceDisclosureFragment.TAG)) {
                    this.f5828p = AccountTransactionsFragment.TAG;
                    if (this.f5826n == null) {
                        this.f5826n = new AccountTransactionsFragment();
                    }
                    getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(AvailableBalanceDisclosureFragment.TAG)).replace(C1494ai.container, this.f5826n, AccountTransactionsFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                    return true;
                }
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("EXTRA_CURRENT_FRAGMENT_TAG", this.f5828p);
    }

    public void showBalanceDisclosure(Account.BalanceType balanceType) {
        this.f5827o = new AvailableBalanceDisclosureFragment();
        this.f5828p = AvailableBalanceDisclosureFragment.TAG;
        Bundle bundle = new Bundle();
        bundle.putSerializable(AvailableBalanceDisclosureFragment.ACCOUNT, this.f5825m);
        bundle.putInt(AvailableBalanceDisclosureFragment.BALANCE_TYPE, balanceType.ordinal());
        this.f5827o.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(AccountTransactionsFragment.TAG)).replace(C1494ai.container, this.f5827o, AvailableBalanceDisclosureFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}
