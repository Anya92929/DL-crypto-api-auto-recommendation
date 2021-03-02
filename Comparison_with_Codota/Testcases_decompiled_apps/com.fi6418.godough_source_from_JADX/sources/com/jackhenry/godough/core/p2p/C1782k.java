package com.jackhenry.godough.core.p2p;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.p038e.C1579h;

/* renamed from: com.jackhenry.godough.core.p2p.k */
class C1782k implements C1579h {

    /* renamed from: a */
    final /* synthetic */ String f6583a;

    /* renamed from: b */
    final /* synthetic */ C1781j f6584b;

    C1782k(C1781j jVar, String str) {
        this.f6584b = jVar;
        this.f6583a = str;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f6584b.f6919c.getLayoutInflater((Bundle) null).inflate(C1496ak.p2p_add_payee_submitted, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(C1494ai.add_payee_message)).setText(this.f6583a);
        return inflate;
    }
}
