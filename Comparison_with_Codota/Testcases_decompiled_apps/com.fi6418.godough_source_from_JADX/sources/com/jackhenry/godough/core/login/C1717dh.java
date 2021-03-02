package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.MFA;
import com.jackhenry.godough.core.model.MFAResponse;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.p038e.C1588q;

/* renamed from: com.jackhenry.godough.core.login.dh */
public class C1717dh extends C1757n<MFAResponse> {

    /* renamed from: e */
    private MFA f6458e;

    public C1717dh(MFA mfa, C1759p<MFAResponse> pVar) {
        super(new MFAResponse(), pVar);
        this.f6458e = mfa;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MFAResponse mo9592a(Void... voidArr) {
        MFAResponse a = new C1689cg().mo9999a(this.f6458e);
        if (a.isSuccess() && a.getRedirect().getRedirect() == Redirect.RedirectType.HOME) {
            C1588q.m6215a();
        }
        return a;
    }
}
