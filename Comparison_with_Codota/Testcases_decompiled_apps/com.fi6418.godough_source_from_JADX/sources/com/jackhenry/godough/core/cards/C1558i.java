package com.jackhenry.godough.core.cards;

import android.graphics.Color;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1801q;
import com.jackhenry.godough.core.model.Card;

/* renamed from: com.jackhenry.godough.core.cards.i */
public class C1558i extends C1801q<Card> {

    /* renamed from: b */
    private int f6109b;

    /* renamed from: c */
    private boolean f6110c;

    /* renamed from: d */
    private Fragment f6111d;

    public C1558i(int i, Fragment fragment, boolean z) {
        super(fragment);
        this.f6111d = fragment;
        this.f6109b = i;
        this.f6110c = z;
    }

    /* renamed from: a */
    public C1349a<Card> mo9278a(int i) {
        return new C1349a<>(new C1560k().mo9773b().getCards(), false, -1);
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, Card card) {
        View inflate = layoutInflater.inflate(this.f6109b, viewGroup);
        viewGroup.setTag(card);
        if (this.f6110c) {
            inflate.findViewById(C1494ai.nav_icon).setVisibility(8);
        }
        TextView textView = (TextView) inflate.findViewById(C1494ai.line2_right);
        ((TextView) inflate.findViewById(C1494ai.line1)).setText(card.getPrimaryCardholderName());
        ((TextView) inflate.findViewById(C1494ai.line2)).setText(card.getMaskedCardNumber());
        textView.setText(card.getStatusDescription());
        int color = this.f6111d.getResources().getColor(C1491af.default_card_status_color);
        if (card.getStatusColor() != null) {
            try {
                color = Color.parseColor("#" + card.getStatusColor());
            } catch (IllegalArgumentException e) {
            }
        }
        textView.setTextColor(color);
    }

    /* renamed from: b */
    public boolean mo9567b(View view, Exception exc) {
        mo10985a(exc);
        return false;
    }
}
