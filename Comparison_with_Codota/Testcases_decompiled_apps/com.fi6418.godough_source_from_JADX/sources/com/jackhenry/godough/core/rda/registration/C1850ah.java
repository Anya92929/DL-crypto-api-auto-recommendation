package com.jackhenry.godough.core.rda.registration;

import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.login.C1628a;
import com.jackhenry.godough.core.model.RDARegistrationTermsResponse;
import com.jackhenry.godough.core.rda.C1881x;

/* renamed from: com.jackhenry.godough.core.rda.registration.ah */
public class C1850ah extends C1628a<RDARegistrationTermsResponse> {

    /* renamed from: e */
    boolean f6736e = false;

    public C1850ah(C1759p<RDARegistrationTermsResponse> pVar, boolean z) {
        super(pVar);
        this.f6736e = z;
    }

    /* renamed from: c */
    public RDARegistrationTermsResponse mo9943b(Void... voidArr) {
        C1881x xVar = new C1881x();
        RDARegistrationTermsResponse a = xVar.mo11106a(this.f6736e);
        a.setTandCCollect(this.f6736e);
        if (!this.f6736e && a.isSuccess()) {
            a.setRdaUserStatusResponse(xVar.mo11112e());
        }
        return a;
    }
}
