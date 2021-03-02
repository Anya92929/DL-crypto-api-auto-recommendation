package com.jackhenry.godough.core.rda.registration;

import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.login.C1628a;
import com.jackhenry.godough.core.model.RDAUserRegistrationData;
import com.jackhenry.godough.core.model.RDAUserRegistrationResponse;
import com.jackhenry.godough.core.rda.C1881x;

/* renamed from: com.jackhenry.godough.core.rda.registration.ag */
public class C1849ag extends C1628a<RDAUserRegistrationResponse> {

    /* renamed from: e */
    RDAUserRegistrationData f6735e;

    public C1849ag(RDAUserRegistrationData rDAUserRegistrationData, C1759p<RDAUserRegistrationResponse> pVar) {
        super(pVar);
        this.f6735e = rDAUserRegistrationData;
    }

    /* renamed from: c */
    public RDAUserRegistrationResponse mo9943b(Void... voidArr) {
        return new C1881x().mo11107a(this.f6735e);
    }
}
