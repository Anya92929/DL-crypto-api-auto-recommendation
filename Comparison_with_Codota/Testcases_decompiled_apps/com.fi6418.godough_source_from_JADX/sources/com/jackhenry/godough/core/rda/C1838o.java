package com.jackhenry.godough.core.rda;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.model.Deposit;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;

/* renamed from: com.jackhenry.godough.core.rda.o */
class C1838o implements C1579h {

    /* renamed from: a */
    final /* synthetic */ Deposit f6696a;

    /* renamed from: b */
    final /* synthetic */ C1837n f6697b;

    C1838o(C1837n nVar, Deposit deposit) {
        this.f6697b = nVar;
        this.f6696a = deposit;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f6697b.f6919c.getLayoutInflater((Bundle) null).inflate(C1496ak.deposit_check_submitted, (ViewGroup) null);
        ((TextView) inflate.findViewById(C1494ai.transaction_id)).setText(this.f6696a.getStatus().getTransactionId());
        ((TextView) inflate.findViewById(C1494ai.account)).setText(this.f6696a.getAccount().toString());
        ((TextView) inflate.findViewById(C1494ai.amount)).setText(C1580i.m6152a(this.f6696a.getAmount().longValue()));
        ((TextView) inflate.findViewById(C1494ai.date)).setText(C1364k.m5588a(Calendar.getInstance()));
        return inflate;
    }
}
