package com.jackhenry.godough.core.cards;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.p038e.C1579h;

/* renamed from: com.jackhenry.godough.core.cards.e */
class C1554e implements C1579h {

    /* renamed from: a */
    final /* synthetic */ String f6105a;

    /* renamed from: b */
    final /* synthetic */ C1553d f6106b;

    C1554e(C1553d dVar, String str) {
        this.f6106b = dVar;
        this.f6105a = str;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f6106b.f6919c.getLayoutInflater((Bundle) null).inflate(C1496ak.card_action_success_dialog, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(C1494ai.message)).setText(this.f6105a);
        ((TextView) inflate.findViewById(C1494ai.card_number)).setText(this.f6106b.f6104a.f6089c.getMaskedCardNumber());
        ((TextView) inflate.findViewById(C1494ai.cardholder)).setText(this.f6106b.f6104a.f6089c.getPrimaryCardholderName());
        ((TextView) inflate.findViewById(C1494ai.card_status_description)).setText(this.f6106b.f6104a.f6089c.getStatusDescription());
        return inflate;
    }
}
