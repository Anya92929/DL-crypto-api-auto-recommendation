package com.jackhenry.godough.core.cards;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.model.CardActionStatus;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.cards.d */
class C1553d extends C1942x<CardActionStatus> {

    /* renamed from: a */
    final /* synthetic */ CardActionSubmitFragment f6104a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1553d(CardActionSubmitFragment cardActionSubmitFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6104a = cardActionSubmitFragment;
    }

    /* renamed from: a */
    public void mo9588a(CardActionStatus cardActionStatus) {
        this.f6104a.mo10989m();
        CardActionSubmitFragmentActivity cardActionSubmitFragmentActivity = (CardActionSubmitFragmentActivity) this.f6104a.getActivity();
        if (cardActionSubmitFragmentActivity != null) {
            int i = cardActionStatus.isWasSuccessful() ? CardActionSubmitFragmentActivity.DIALOG_CARD_ACTION_SUCCESS : CardActionSubmitFragmentActivity.DIALOG_CARD_ACTION_FAILED;
            String message = cardActionStatus.getMessage();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(-1, this.f6104a.getString(C1506am.btn_ok)));
            cardActionSubmitFragmentActivity.showConfirmationScreen(C1494ai.layout, new C1576e(C1577f.SUCCESS, i, this.f6104a.getString(C1506am.dg_card_action_success_title), (C1579h) new C1554e(this, message), (List<C1574c>) arrayList));
            C1562m unused = this.f6104a.f6092f = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6104a.mo10989m();
        if (((CardActionSubmitFragmentActivity) this.f6104a.getActivity()) == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            mo11216b(dVar);
        }
        C1562m unused = this.f6104a.f6092f = null;
        return true;
    }
}
