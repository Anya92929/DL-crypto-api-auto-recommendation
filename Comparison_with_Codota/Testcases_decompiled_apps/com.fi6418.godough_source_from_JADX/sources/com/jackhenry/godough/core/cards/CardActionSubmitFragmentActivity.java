package com.jackhenry.godough.core.cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.CardActions;

public class CardActionSubmitFragmentActivity extends GodoughTransactionActivity {
    public static final int DIALOG_CARD_ACTION_FAILED = 5013;
    public static final int DIALOG_CARD_ACTION_SUCCESS = 5012;
    public static final String EXTRA_ACTION = "EXTRA_ACTION";
    public static final String EXTRA_ACTION_TEXT = "EXTRA_ACTION_TEXT";
    public static final String EXTRA_CARD = "EXTRA_CARD";

    /* renamed from: m */
    private CardActionSubmitFragment f6093m;

    /* renamed from: n */
    private CardActions.Action f6094n;

    public void actionButtonClickHandler() {
        super.actionButtonClickHandler();
        Intent intent = new Intent(GoDoughApp.getApp(), ManageCardsFragmentActivity.class);
        intent.putExtra(ManageCardsFragmentActivity.EXTRA_RELOAD_CARDS, true);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6093m;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setShowArrowOnToolbar(true);
        setContentView(C1496ak.card_action_activity);
        this.f6093m = (CardActionSubmitFragment) getSupportFragmentManager().findFragmentById(C1494ai.card_action_submit);
        setTransactionFragment(this.f6093m);
        this.f6094n = CardActions.Action.values()[getIntent().getIntExtra("EXTRA_ACTION", 0)];
        switch (C1555f.f6107a[this.f6094n.ordinal()]) {
            case 1:
                setTitle(C1506am.activity_title_cards_activate);
                break;
            case 2:
                setTitle(C1506am.activity_title_cards_reorder);
                break;
            case 3:
                setTitle(C1506am.activity_title_cards_report);
                break;
            case 4:
                setTitle(C1506am.activity_title_cards_suspend);
                break;
        }
        setResult(0);
    }

    public void resetFields() {
    }
}
