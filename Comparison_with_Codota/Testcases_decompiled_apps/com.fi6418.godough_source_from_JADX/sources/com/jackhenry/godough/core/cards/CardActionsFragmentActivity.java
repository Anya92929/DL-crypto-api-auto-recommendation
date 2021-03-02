package com.jackhenry.godough.core.cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Card;
import com.jackhenry.godough.core.model.CardActions;
import java.util.Locale;

public class CardActionsFragmentActivity extends AbstractActivity implements C1556g {
    public static final String EXTRA_RELOAD_CARDS = "EXTRA_RELOAD_CARDS";

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.cards);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 0) {
            getSupportFragmentManager().findFragmentByTag(CardActionsFragment.TAG).onActivityResult(i, i2, intent);
        }
    }

    public void onCardAction(Card card, CardActions.Action action) {
        Intent intent = new Intent(GoDoughApp.getApp(), CardActionSubmitFragmentActivity.class);
        intent.putExtra("EXTRA_ACTION", action.ordinal());
        intent.putExtra("EXTRA_CARD", card);
        intent.putExtra("EXTRA_ACTION_TEXT", action.name().charAt(0) + action.name().substring(1).toLowerCase(Locale.US));
        startActivityForResult(intent, 0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        if (GoDoughApp.getUserSettings().getUserMenu() == null) {
            finish();
            return;
        }
        setContentView(C1496ak.cards_activity);
        getSupportActionBar().setTitle((CharSequence) getString(C1506am.lbl_card_options));
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra(EXTRA_RELOAD_CARDS, false)) {
            getSupportFragmentManager().findFragmentByTag(CardActionsFragment.TAG).onActivityResult(0, -1, (Intent) null);
        }
    }
}
