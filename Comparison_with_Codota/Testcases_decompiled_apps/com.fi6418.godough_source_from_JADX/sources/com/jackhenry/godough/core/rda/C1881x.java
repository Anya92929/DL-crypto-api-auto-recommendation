package com.jackhenry.godough.core.rda;

import android.graphics.Bitmap;
import com.jackhenry.godough.core.model.Deposit;
import com.jackhenry.godough.core.model.DepositAccount;
import com.jackhenry.godough.core.model.DepositAccountResponse;
import com.jackhenry.godough.core.model.DepositRequest;
import com.jackhenry.godough.core.model.DepositStatus;
import com.jackhenry.godough.core.model.DepositTransaction;
import com.jackhenry.godough.core.model.DepositTransactionsResponse;
import com.jackhenry.godough.core.model.RDARegistrationTermsRequest;
import com.jackhenry.godough.core.model.RDARegistrationTermsResponse;
import com.jackhenry.godough.core.model.RDATermsAndConditions;
import com.jackhenry.godough.core.model.RDAUserRegistrationData;
import com.jackhenry.godough.core.model.RDAUserRegistrationResponse;
import com.jackhenry.godough.core.model.RDAVerificationStatusResponse;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1397a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import com.jackhenry.godough.p043d.C1945a;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.rda.x */
public class C1881x extends C1396a {
    /* renamed from: a */
    private Bitmap m6840a(String str, String str2) {
        return (Bitmap) mo9442n().mo9452a(String.format("/RdaTransactions/%1$s?image=%2$s", new Object[]{str, str2}), (C1401c) new C1397a());
    }

    /* renamed from: a */
    public Bitmap mo11104a(String str, Deposit.Side side) {
        C1885a.m6860a();
        String str2 = null;
        switch (C1882y.f6775a[side.ordinal()]) {
            case 1:
                str2 = "front";
                break;
            case 2:
                str2 = "back";
                break;
        }
        return m6840a(str, str2);
    }

    /* renamed from: a */
    public Deposit mo11105a(Deposit deposit) {
        C1885a.m6860a();
        DepositRequest depositRequest = new DepositRequest(deposit);
        depositRequest.setRequestToken(mo9443o());
        deposit.setStatus((DepositStatus) mo9442n().mo9453a("/Rda", (C1401c) new C1400b(DepositStatus.class), (String) new C1400b(DepositRequest.class).mo9450a((Object) depositRequest)));
        return deposit;
    }

    /* renamed from: a */
    public RDARegistrationTermsResponse mo11106a(boolean z) {
        String str = z ? "/RdaCollectTermsAndConditions" : "/RdaTermsAndConditions";
        C1945a.m6997b("Url submitted for terms" + str);
        C1885a.m6860a();
        RDARegistrationTermsRequest rDARegistrationTermsRequest = new RDARegistrationTermsRequest();
        rDARegistrationTermsRequest.setRequestToken(mo9443o());
        return (RDARegistrationTermsResponse) mo9442n().mo9453a(str, (C1401c) new C1400b(RDARegistrationTermsResponse.class), (String) new C1400b(RDARegistrationTermsRequest.class).mo9450a((Object) rDARegistrationTermsRequest));
    }

    /* renamed from: a */
    public RDAUserRegistrationResponse mo11107a(RDAUserRegistrationData rDAUserRegistrationData) {
        C1885a.m6860a();
        rDAUserRegistrationData.setRequestToken(mo9443o());
        return (RDAUserRegistrationResponse) mo9442n().mo9453a("/RdaRegistration", (C1401c) new C1400b(RDAUserRegistrationResponse.class), (String) new C1400b(RDAUserRegistrationData.class).mo9450a((Object) rDAUserRegistrationData));
    }

    /* renamed from: b */
    public RDATermsAndConditions mo11108b(boolean z) {
        C1885a.m6860a();
        String str = "/RdaTermsAndConditions";
        if (z) {
            str = "/RdaCollectTermsAndConditions";
        }
        C1945a.m6997b("URL for get " + str);
        return (RDATermsAndConditions) mo9442n().mo9452a("/RdaTermsAndConditions", (C1401c) new C1400b(RDATermsAndConditions.class));
    }

    /* renamed from: b */
    public List<DepositAccount> mo11109b() {
        C1885a.m6860a();
        return ((DepositAccountResponse) mo9442n().mo9452a("/RdaAccounts", (C1401c) new C1400b(DepositAccountResponse.class))).getRdaAccounts();
    }

    /* renamed from: c */
    public List<DepositTransaction> mo11110c() {
        C1885a.m6860a();
        return ((DepositTransactionsResponse) mo9442n().mo9452a("/RdaTransactions", (C1401c) new C1400b(DepositTransactionsResponse.class))).getRdaTransactions();
    }

    /* renamed from: d */
    public RDAUserRegistrationData mo11111d() {
        C1885a.m6860a();
        return (RDAUserRegistrationData) mo9442n().mo9452a("/RdaRegistration", (C1401c) new C1400b(RDAUserRegistrationData.class));
    }

    /* renamed from: e */
    public RDAVerificationStatusResponse mo11112e() {
        C1885a.m6860a();
        return (RDAVerificationStatusResponse) mo9442n().mo9452a("/RDA", (C1401c) new C1400b(RDAVerificationStatusResponse.class));
    }
}
