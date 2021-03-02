package com.jackhenry.godough.core.accounts;

import android.graphics.Bitmap;
import com.jackhenry.godough.core.model.AccountGroupList;
import com.jackhenry.godough.core.model.AccountTransactionList;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1397a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.jackhenry.godough.core.accounts.s */
public class C1439s extends C1396a {
    /* renamed from: a */
    public Bitmap mo9593a(String str, boolean z) {
        return (Bitmap) mo9442n().mo9452a(String.format("/TransactionImage?id=%s&frontSide=%b", new Object[]{str, Boolean.valueOf(z)}), (C1401c) new C1397a());
    }

    /* renamed from: a */
    public AccountGroupList mo9440a() {
        C1885a.m6860a();
        return (AccountGroupList) mo9442n().mo9452a("/Accounts", (C1401c) new C1400b(AccountGroupList.class));
    }

    /* renamed from: a */
    public AccountTransactionList mo9594a(String str, long j) {
        C1885a.m6860a();
        try {
            Object[] objArr = new Object[2];
            objArr[0] = URLEncoder.encode(str, "UTF-8");
            if (j < 0) {
                j = 0;
            }
            objArr[1] = Long.valueOf(j);
            return (AccountTransactionList) mo9442n().mo9452a(String.format("/AccountTransactions?accountName=%1$s&startRecord=%2$s", objArr), (C1401c) new C1400b(AccountTransactionList.class));
        } catch (UnsupportedEncodingException e) {
            throw new C1389d("URLEncoder did not like 'UTF-8' encoding", e, 3000);
        }
    }
}
