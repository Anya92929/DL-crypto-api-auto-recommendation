package com.jackhenry.godough.core.cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Card;

public class ManageCardsFragmentActivity extends AbstractActivity implements C1559j {
    public static final String EXTRA_CARD = "EXTRA_CARD";
    public static final String EXTRA_RELOAD_CARDS = "Reload_Cards";

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.cards);
    }

    public void onCardSelected(Card card) {
        Intent intent = new Intent(GoDoughApp.getApp(), CardActionsFragmentActivity.class);
        intent.putExtra("EXTRA_CARD", card);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GoDoughApp.getUserSettings().getUserMenu() == null) {
            finish();
            return;
        }
        setContentView(C1496ak.manage_cards_fragment_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getManageCards().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
