package com.jackhenry.godough.core.p2p;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.P2PPayment;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.core.p038e.C1580i;

/* renamed from: com.jackhenry.godough.core.p2p.ah */
class C1768ah implements C1579h {

    /* renamed from: a */
    final /* synthetic */ P2PPayment f6570a;

    /* renamed from: b */
    final /* synthetic */ C1767ag f6571b;

    C1768ah(C1767ag agVar, P2PPayment p2PPayment) {
        this.f6571b = agVar;
        this.f6570a = p2PPayment;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f6571b.f6569a.getLayoutInflater((Bundle) null).inflate(C1496ak.p2p_pay_submitted, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(C1494ai.confirm_number)).setText(this.f6570a.getP2PPaymentStatus().getConfirmationNumber());
        String nickname = this.f6570a.getPayee().getNickname();
        ((TextView) inflate.findViewById(C1494ai.payee)).setText((nickname == null || nickname.trim().length() == 0) ? this.f6570a.getPayee().getName() : nickname);
        ((TextView) inflate.findViewById(C1494ai.account)).setText(this.f6570a.getAccount().getName());
        ((TextView) inflate.findViewById(C1494ai.amount)).setText(C1580i.m6152a(this.f6570a.getAmount()));
        ((TextView) inflate.findViewById(C1494ai.memo)).setText(this.f6570a.getMemo());
        ((TextView) inflate.findViewById(C1494ai.lbl_date)).setText(GoDoughApp.getUserSettings().getP2PUserDateLabelText());
        ((TextView) inflate.findViewById(C1494ai.date)).setText(C1580i.m6154a(this.f6570a.getPaymentDate()));
        return inflate;
    }
}
