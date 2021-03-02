package com.jackhenry.godough.core.cards;

import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1801q;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Card;
import com.jackhenry.godough.core.model.CardActions;
import com.jackhenry.godough.core.model.ImageTextArrowRow;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.cards.h */
public class C1557h extends C1801q<ImageTextArrowRow> {

    /* renamed from: b */
    private Card f6108b;

    C1557h(Card card, Fragment fragment) {
        super(fragment);
        this.f6108b = card;
    }

    /* renamed from: a */
    private List<ImageTextArrowRow> m6105a(CardActions cardActions) {
        ArrayList arrayList = new ArrayList();
        if (cardActions.isCanActivate()) {
            arrayList.add(new ImageTextArrowRow(CardActions.Action.ACTIVATE.ordinal(), GoDoughApp.getApp().getString(C1506am.lbl_activate_card), C1493ah.ic_card_activate));
        }
        if (cardActions.isCanReorder()) {
            arrayList.add(new ImageTextArrowRow(CardActions.Action.REORDER.ordinal(), GoDoughApp.getApp().getString(C1506am.lbl_reorder_card), C1493ah.ic_card_reorder));
        }
        if (cardActions.isCanSuspend()) {
            arrayList.add(new ImageTextArrowRow(CardActions.Action.SUSPEND.ordinal(), GoDoughApp.getApp().getString(C1506am.lbl_suspend_card), C1493ah.ic_card_suspend));
        }
        if (cardActions.isCanReportLostStolen()) {
            arrayList.add(new ImageTextArrowRow(CardActions.Action.REPORT.ordinal(), GoDoughApp.getApp().getString(C1506am.lbl_report_lost), C1493ah.ic_card_report));
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1349a<ImageTextArrowRow> mo9278a(int i) {
        return new C1349a<>(m6105a(new C1560k().mo9772a(this.f6108b)), false, -1);
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, ImageTextArrowRow imageTextArrowRow) {
        View inflate = layoutInflater.inflate(C1496ak.image_text_arrow_row, viewGroup);
        ((TextView) inflate.findViewById(C1494ai.text)).setText(imageTextArrowRow.getText());
        ((ImageView) inflate.findViewById(C1494ai.image)).setImageResource(imageTextArrowRow.getDrawableId());
    }

    /* renamed from: b */
    public boolean mo9567b(View view, Exception exc) {
        mo10985a(exc);
        return false;
    }
}
