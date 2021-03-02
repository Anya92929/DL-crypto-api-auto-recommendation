package com.jackhenry.godough.core.ach;

import com.jackhenry.godough.core.model.ACH;
import com.jackhenry.godough.core.model.ACHBatches;
import com.jackhenry.godough.core.model.ACHEffectiveDatesResponse;
import com.jackhenry.godough.core.model.ACHRequest;
import com.jackhenry.godough.core.model.ACHStatus;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.ach.r */
public class C1487r extends C1396a {

    /* renamed from: a */
    private static List<Calendar> f5970a;

    /* renamed from: b */
    private List<Calendar> m5964b() {
        return ((ACHEffectiveDatesResponse) mo9442n().mo9452a("/AchEffectiveDates", (C1401c) new C1400b(ACHEffectiveDatesResponse.class))).getEffectiveDates();
    }

    /* renamed from: a */
    public ACH mo9692a(String str) {
        C1885a.m6860a();
        ACH ach = (ACH) mo9442n().mo9452a(String.format("/Ach/%1$s", new Object[]{str}), (C1401c) new C1400b(ACH.class));
        f5970a = m5964b();
        ach.setEffectiveDates(f5970a);
        return ach;
    }

    /* renamed from: a */
    public ACHBatches mo9693a(int i) {
        C1885a.m6860a();
        Object[] objArr = new Object[1];
        if (i < 0) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        return (ACHBatches) mo9442n().mo9452a(String.format("/Ach?startRecord=%1$s", objArr), (C1401c) new C1400b(ACHBatches.class));
    }

    /* renamed from: a */
    public ACHStatus mo9694a(ACHRequest aCHRequest) {
        C1885a.m6860a();
        aCHRequest.setRequestToken(mo9443o());
        return (ACHStatus) mo9442n().mo9453a("/Ach", (C1401c) new C1400b(ACHStatus.class), (String) new C1400b(ACHRequest.class).mo9450a((Object) aCHRequest));
    }
}
