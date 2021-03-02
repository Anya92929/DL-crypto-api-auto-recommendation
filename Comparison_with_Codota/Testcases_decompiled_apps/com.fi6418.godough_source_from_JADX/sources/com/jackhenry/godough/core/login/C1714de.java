package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.EmailAddressData;

/* renamed from: com.jackhenry.godough.core.login.de */
public class C1714de extends C1628a<String> {

    /* renamed from: e */
    private EmailAddressData f6457e;

    public C1714de(EmailAddressData emailAddressData, C1759p<String> pVar) {
        super(pVar);
        this.f6457e = emailAddressData;
    }

    /* renamed from: c */
    public String mo9943b(Void... voidArr) {
        EmailAddressData a = new C1689cg().mo9998a(this.f6457e);
        if (a.getStatus().isSuccess()) {
            return null;
        }
        return a.getStatus().getMessage();
    }
}
