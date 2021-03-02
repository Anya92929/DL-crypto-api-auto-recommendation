package com.jackhenry.godough.core.transfers;

import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.FromAccountList;
import com.jackhenry.godough.core.model.Transfer;
import com.jackhenry.godough.core.model.TransferRequest;
import com.jackhenry.godough.core.model.TransferStatus;
import com.jackhenry.godough.core.model.TransferToAccount;
import com.jackhenry.godough.core.model.TransferToAccountList;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.transfers.b */
public class C1897b extends C1396a {
    /* renamed from: a */
    public Transfer mo11138a(Transfer transfer) {
        C1885a.m6860a();
        TransferRequest transferRequest = new TransferRequest(transfer);
        transferRequest.setRequestToken(mo9443o());
        C1400b bVar = new C1400b(TransferStatus.class);
        transfer.setStatus((TransferStatus) mo9442n().mo9453a("/Transfer", (C1401c) bVar, (String) bVar.mo9450a((Object) transferRequest)));
        return transfer;
    }

    /* renamed from: a */
    public List<TransferToAccount> mo11139a(String str) {
        C1885a.m6860a();
        try {
            return ((TransferToAccountList) mo9442n().mo9452a(String.format("/TransferToAccounts/%1$s", new Object[]{URLEncoder.encode(str, "UTF-8").replace("+", "%20")}), (C1401c) new C1400b(TransferToAccountList.class))).getAccounts();
        } catch (UnsupportedEncodingException e) {
            throw new C1389d("URLEncoder did not like 'UTF-8' encoding", e, 3000);
        }
    }

    /* renamed from: b */
    public List<Account> mo11140b() {
        C1885a.m6860a();
        FromAccountList fromAccountList = (FromAccountList) mo9442n().mo9452a("/TransferFromAccounts", (C1401c) new C1400b(FromAccountList.class));
        if (fromAccountList == null) {
            return null;
        }
        return fromAccountList.getAccounts();
    }
}
