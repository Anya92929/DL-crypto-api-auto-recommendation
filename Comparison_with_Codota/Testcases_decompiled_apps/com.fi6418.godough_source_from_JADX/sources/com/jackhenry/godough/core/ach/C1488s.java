package com.jackhenry.godough.core.ach;

import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.ACHRequest;
import com.jackhenry.godough.core.model.ACHStatus;

/* renamed from: com.jackhenry.godough.core.ach.s */
public class C1488s extends C1757n<ACHStatus> {

    /* renamed from: e */
    ACHRequest f5971e;

    public C1488s(ACHRequest aCHRequest, C1759p<ACHStatus> pVar) {
        super(new ACHStatus(), pVar);
        this.f5971e = aCHRequest;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ACHStatus mo9592a(Void... voidArr) {
        return new C1487r().mo9694a(this.f5971e);
    }
}
