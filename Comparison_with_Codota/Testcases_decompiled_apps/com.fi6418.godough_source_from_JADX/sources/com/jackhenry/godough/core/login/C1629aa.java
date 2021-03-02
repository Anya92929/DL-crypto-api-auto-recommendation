package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1758o;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.MFA;

/* renamed from: com.jackhenry.godough.core.login.aa */
public class C1629aa extends C1758o<Void, MFA> {
    public C1629aa(C1759p<MFA> pVar) {
        super(pVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MFA mo9592a(Void... voidArr) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new C1689cg().mo10007e();
    }
}
