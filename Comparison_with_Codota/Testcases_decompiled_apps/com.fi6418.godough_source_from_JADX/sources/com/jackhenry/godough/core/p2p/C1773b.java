package com.jackhenry.godough.core.p2p;

import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.P2PAccountsResponse;
import com.jackhenry.godough.core.model.P2PAddPayeeRequest;
import com.jackhenry.godough.core.model.P2PAddPayeeResponse;
import com.jackhenry.godough.core.model.P2PAddPayeeStatus;
import com.jackhenry.godough.core.model.P2PPayee;
import com.jackhenry.godough.core.model.P2PPayeesResponse;
import com.jackhenry.godough.core.model.P2PPayment;
import com.jackhenry.godough.core.model.P2PPaymentDate;
import com.jackhenry.godough.core.model.P2PPaymentDatesResponse;
import com.jackhenry.godough.core.model.P2PPaymentRequest;
import com.jackhenry.godough.core.model.P2PPaymentStatus;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.p2p.b */
public class C1773b extends C1396a {
    /* renamed from: a */
    public P2PPayee mo10950a(P2PPayee p2PPayee) {
        C1885a.m6860a();
        P2PAddPayeeRequest p2PAddPayeeRequest = new P2PAddPayeeRequest(p2PPayee);
        p2PAddPayeeRequest.setRequestToken(mo9443o());
        P2PAddPayeeResponse p2PAddPayeeResponse = (P2PAddPayeeResponse) mo9442n().mo9453a("/P2PPayees", (C1401c) new C1400b(P2PAddPayeeResponse.class), (String) new C1400b(P2PAddPayeeRequest.class).mo9450a((Object) p2PAddPayeeRequest));
        if (p2PAddPayeeResponse.getAddedPayee() != null) {
            p2PPayee.setId(p2PAddPayeeResponse.getAddedPayee().getId());
        }
        p2PPayee.setAddPayeeStatus(new P2PAddPayeeStatus(p2PAddPayeeResponse.getMessage(), p2PAddPayeeResponse.getWasSuccessful()));
        return p2PPayee;
    }

    /* renamed from: a */
    public P2PPayment mo10951a(P2PPayment p2PPayment) {
        C1885a.m6860a();
        P2PPaymentRequest p2PPaymentRequest = new P2PPaymentRequest(p2PPayment);
        p2PPaymentRequest.setRequestToken(mo9443o());
        p2PPayment.setP2PPaymentStatus((P2PPaymentStatus) mo9442n().mo9453a("/P2P", (C1401c) new C1400b(P2PPaymentStatus.class), (String) new C1400b(P2PPaymentRequest.class).mo9450a((Object) p2PPaymentRequest)));
        return p2PPayment;
    }

    /* renamed from: a */
    public List<P2PPaymentDate> mo10952a(String str) {
        C1885a.m6860a();
        return ((P2PPaymentDatesResponse) mo9442n().mo9452a(String.format("/P2PPaymentDates/%1$s", new Object[]{str}), (C1401c) new C1400b(P2PPaymentDatesResponse.class))).getP2PPaymentDates();
    }

    /* renamed from: b */
    public List<Account> mo10953b() {
        C1885a.m6860a();
        return ((P2PAccountsResponse) mo9442n().mo9452a("/P2PAccounts", (C1401c) new C1400b(P2PAccountsResponse.class))).getP2PAccounts();
    }

    /* renamed from: c */
    public List<P2PPayee> mo10954c() {
        C1885a.m6860a();
        return ((P2PPayeesResponse) mo9442n().mo9452a("/P2PPayees", (C1401c) new C1400b(P2PPayeesResponse.class))).getP2PPayees();
    }
}
