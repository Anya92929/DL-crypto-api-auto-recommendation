package com.jackhenry.godough.core.wires;

import com.jackhenry.godough.core.model.Wire;
import com.jackhenry.godough.core.model.WireStatus;
import com.jackhenry.godough.core.model.WiresList;
import com.jackhenry.godough.core.model.WiresRequest;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;

/* renamed from: com.jackhenry.godough.core.wires.a */
public class C1925a extends C1396a {
    /* renamed from: a */
    public Wire mo11201a(Wire wire, String str) {
        C1885a.m6860a();
        WiresRequest wiresRequest = new WiresRequest();
        wiresRequest.setDebitAccountName(wire.getDebitAccountName());
        wiresRequest.setPin(str);
        wiresRequest.setSequenceNumber(wire.getSequenceNumber());
        wiresRequest.setRequestToken(mo9443o());
        wire.setResponseStatus((WireStatus) mo9442n().mo9453a("/Wire", (C1401c) new C1400b(WireStatus.class), (String) new C1400b(WiresRequest.class).mo9450a((Object) wiresRequest)));
        return wire;
    }

    /* renamed from: b */
    public WiresList mo11202b() {
        C1885a.m6860a();
        return (WiresList) mo9442n().mo9452a("/Wire", (C1401c) new C1400b(WiresList.class));
    }
}
