package com.jackhenry.godough.core.cards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.Card;
import com.jackhenry.godough.core.model.CardActions;
import com.jackhenry.godough.core.p038e.C1582k;
import com.jackhenry.godough.core.widgets.ActionButton;

public class CardActionSubmitFragment extends C1802r {
    public static final String EXTRA_ACTION = "EXTRA_ACTION";
    public static final String EXTRA_ACTION_TEXT = "EXTRA_ACTION_TEXT";
    public static final String EXTRA_CARD = "EXTRA_CARD";
    public static final String TAG = "CardActionSubmitFragment";

    /* renamed from: a */
    String f6087a;

    /* renamed from: b */
    CardActions.Action f6088b;

    /* renamed from: c */
    Card f6089c;

    /* renamed from: d */
    ActionButton f6090d;

    /* renamed from: e */
    ActionButton f6091e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1562m f6092f;

    public void onCardAction(Card card, CardActions.Action action) {
        mo10986b(getString(C1506am.dg_processing));
        this.f6089c = card;
        this.f6088b = action;
        this.f6092f = new C1562m(action, card, new C1553d(this, this, new C1552c(this, card, action)));
        this.f6092f.execute(new Void[0]);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getActivity().getIntent().getExtras();
        this.f6089c = (Card) extras.getSerializable("EXTRA_CARD");
        this.f6088b = CardActions.Action.values()[extras.getInt("EXTRA_ACTION", 0)];
        this.f6087a = extras.getString("EXTRA_ACTION_TEXT");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.card_action_fragment, viewGroup, false);
        this.f6090d = (ActionButton) inflate.findViewById(C1494ai.btn_cancel);
        this.f6091e = (ActionButton) inflate.findViewById(C1494ai.btn_action);
        this.f6090d.setOnClickListener(new C1550a(this));
        this.f6091e.setText((CharSequence) this.f6087a);
        this.f6091e.setOnClickListener(new C1551b(this));
        TableLayout tableLayout = (TableLayout) inflate.findViewById(C1494ai.table);
        tableLayout.invalidate();
        C1582k.m6160a(C1506am.lbl_cardholder, this.f6089c.getPrimaryCardholderName(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_card_number, this.f6089c.getMaskedCardNumber(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_description, this.f6089c.getStatusDescription(), tableLayout, layoutInflater);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        ((AbstractActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) this.f6089c.getPrimaryCardholderName());
        if (this.f6092f == null) {
            return;
        }
        if (this.f6092f == null || !this.f6092f.mo10926c()) {
            mo10986b(getString(C1506am.dg_processing));
        } else if (this.f6092f.mo10929e()) {
            this.f6092f.mo10922a().mo9589a(this.f6092f.mo10927d());
        } else {
            this.f6092f.mo10922a().mo9588a(this.f6092f.mo10925b());
        }
    }
}
