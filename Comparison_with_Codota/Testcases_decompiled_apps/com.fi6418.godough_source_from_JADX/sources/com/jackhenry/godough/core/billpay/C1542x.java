package com.jackhenry.godough.core.billpay;

import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.BillPayAccountsResponse;
import com.jackhenry.godough.core.model.BillPayPayee;
import com.jackhenry.godough.core.model.BillPayPayeesResponse;
import com.jackhenry.godough.core.model.BillPayPaymentDate;
import com.jackhenry.godough.core.model.BillPayPaymentDatesResponse;
import com.jackhenry.godough.core.model.BillPayment;
import com.jackhenry.godough.core.model.BillPaymentRequest;
import com.jackhenry.godough.core.model.BillPaymentStatus;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.billpay.x */
public class C1542x extends C1396a {
    /* renamed from: a */
    public BillPayment mo9742a(BillPayment billPayment) {
        C1885a.m6860a();
        BillPaymentRequest billPaymentRequest = new BillPaymentRequest(billPayment);
        billPaymentRequest.setRequestToken(mo9443o());
        C1400b bVar = new C1400b(BillPaymentRequest.class);
        billPayment.setStatus((BillPaymentStatus) mo9442n().mo9453a("/BillPay", (C1401c) new C1400b(BillPaymentStatus.class), (String) bVar.mo9450a((Object) billPaymentRequest)));
        return billPayment;
    }

    /* renamed from: a */
    public List<BillPayPaymentDate> mo9743a(String str) {
        C1885a.m6860a();
        try {
            return ((BillPayPaymentDatesResponse) mo9442n().mo9452a(String.format("/BillPayPaymentDates/%1$s", new Object[]{URLEncoder.encode(str, "UTF-8").replace("+", "%20")}), (C1401c) new C1400b(BillPayPaymentDatesResponse.class))).getBillPayPaymentDates();
        } catch (UnsupportedEncodingException e) {
            throw new C1389d("URLEncoder did not like 'UTF-8' encoding", e, 3000);
        }
    }

    /* renamed from: b */
    public List<Account> mo9744b() {
        C1885a.m6860a();
        return ((BillPayAccountsResponse) mo9442n().mo9452a("/BillPayAccounts", (C1401c) new C1400b(BillPayAccountsResponse.class))).getBillPayAccounts();
    }

    /* renamed from: c */
    public List<BillPayPayee> mo9745c() {
        C1885a.m6860a();
        return ((BillPayPayeesResponse) mo9442n().mo9452a("/BillPayPayees", (C1401c) new C1400b(BillPayPayeesResponse.class))).getBillPayPayees();
    }
}
