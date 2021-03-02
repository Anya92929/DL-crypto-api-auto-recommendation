package com.jackhenry.godough.p028c.p029a;

import com.jackhenry.godough.core.accounts.C1439s;
import com.jackhenry.godough.core.login.C1689cg;
import com.jackhenry.godough.core.model.AccountGroupList;
import com.jackhenry.godough.core.model.RequestToken;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;

/* renamed from: com.jackhenry.godough.c.a.a */
public abstract class C1396a {

    /* renamed from: a */
    private C1403b f5746a = new C1403b();

    /* renamed from: a */
    public AccountGroupList mo9440a() {
        return new C1439s().mo9440a();
    }

    /* renamed from: m */
    public void mo9441m() {
        new C1689cg().mo9441m();
    }

    /* renamed from: n */
    public C1403b mo9442n() {
        return this.f5746a;
    }

    /* renamed from: o */
    public String mo9443o() {
        return ((RequestToken) mo9442n().mo9452a("/RequestToken", (C1401c) new C1400b(RequestToken.class))).getRequestToken();
    }
}
