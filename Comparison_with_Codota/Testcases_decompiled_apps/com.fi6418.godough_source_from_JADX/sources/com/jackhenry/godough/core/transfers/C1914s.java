package com.jackhenry.godough.core.transfers;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.model.Transfer;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.core.p038e.C1580i;

/* renamed from: com.jackhenry.godough.core.transfers.s */
class C1914s implements C1579h {

    /* renamed from: a */
    final /* synthetic */ Transfer f6839a;

    /* renamed from: b */
    final /* synthetic */ C1913r f6840b;

    C1914s(C1913r rVar, Transfer transfer) {
        this.f6840b = rVar;
        this.f6839a = transfer;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f6840b.f6838a.getLayoutInflater((Bundle) null).inflate(C1496ak.transfers_submitted, (ViewGroup) null);
        ((TextView) inflate.findViewById(C1494ai.confirm_number)).setText(this.f6839a.getStatus().getConfirmationNumber());
        ((TextView) inflate.findViewById(C1494ai.transfer_from)).setText(this.f6839a.getFromAccount().getName());
        ((TextView) inflate.findViewById(C1494ai.transfer_to)).setText(this.f6839a.getToAccount().getName());
        ((TextView) inflate.findViewById(C1494ai.date)).setText(C1364k.m5588a(this.f6839a.getTransferDate()));
        ((TextView) inflate.findViewById(C1494ai.amount)).setText(C1580i.m6152a(this.f6839a.getAmount()));
        if (this.f6839a.getTransferOption() == null) {
            inflate.findViewById(C1494ai.type_row).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(C1494ai.transfer_type)).setText(this.f6839a.getTransferOption().getDescription());
        }
        return inflate;
    }
}
