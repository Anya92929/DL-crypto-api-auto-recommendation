package com.jackhenry.godough.core.transfers;

import com.jackhenry.godough.core.C1758o;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.TransferToAccount;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.transfers.a */
public class C1896a extends C1758o<Void, List<TransferToAccount>> {

    /* renamed from: e */
    private Account f6820e;

    public C1896a(Account account, C1759p<List<TransferToAccount>> pVar) {
        super(pVar);
        this.f6820e = account;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<TransferToAccount> mo9592a(Void... voidArr) {
        return new C1897b().mo11139a(this.f6820e.getId());
    }
}
