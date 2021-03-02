package com.jackhenry.godough.core.accounts;

import com.jackhenry.godough.core.model.Account;
import java.util.Comparator;
import java.util.HashMap;

/* renamed from: com.jackhenry.godough.core.accounts.w */
class C1468w implements Comparator<Account> {

    /* renamed from: a */
    final /* synthetic */ HashMap f5933a;

    /* renamed from: b */
    final /* synthetic */ C1465t f5934b;

    C1468w(C1465t tVar, HashMap hashMap) {
        this.f5934b = tVar;
        this.f5933a = hashMap;
    }

    /* renamed from: a */
    public int compare(Account account, Account account2) {
        return Integer.valueOf(((Integer) (account.getId() != null ? this.f5933a.get(account.getId()) != null ? this.f5933a.get(account.getId()) : Integer.MAX_VALUE : Integer.MIN_VALUE)).intValue()).compareTo(Integer.valueOf(((Integer) (account2.getId() != null ? this.f5933a.get(account2.getId()) != null ? this.f5933a.get(account2.getId()) : Integer.MAX_VALUE : Integer.MIN_VALUE)).intValue()));
    }
}
