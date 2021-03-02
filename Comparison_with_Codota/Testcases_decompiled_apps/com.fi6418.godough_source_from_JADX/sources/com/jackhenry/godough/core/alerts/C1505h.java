package com.jackhenry.godough.core.alerts;

import com.jackhenry.godough.core.model.Alert;
import com.jackhenry.godough.core.model.AlertResponse;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.alerts.h */
public class C1505h extends C1396a {
    /* renamed from: a */
    public final boolean mo9703a(long j) {
        C1885a.m6860a();
        try {
            mo9442n().mo9451a("/Alerts/" + j);
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: b */
    public final List<Alert> mo9704b() {
        C1885a.m6860a();
        return ((AlertResponse) mo9442n().mo9452a("/Alerts", (C1401c) new C1400b(AlertResponse.class))).getActiveAlerts();
    }
}
