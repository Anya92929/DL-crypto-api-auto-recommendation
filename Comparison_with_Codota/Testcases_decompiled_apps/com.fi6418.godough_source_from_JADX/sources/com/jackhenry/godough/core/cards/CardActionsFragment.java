package com.jackhenry.godough.core.cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1354f;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.Card;
import com.jackhenry.godough.core.model.CardActions;
import com.jackhenry.godough.core.model.ImageTextArrowRow;

public class CardActionsFragment extends C1802r implements AdapterView.OnItemClickListener {
    public static final String TAG = "CardActionsFragment";

    /* renamed from: a */
    private Card f6095a;

    /* renamed from: b */
    private C1354f<ImageTextArrowRow> f6096b;

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f6095a = (Card) getActivity().getIntent().getSerializableExtra("EXTRA_CARD");
        this.f6096b = new C1354f<>(getActivity(), true, C1496ak.list_item_single_loading, C1496ak.list_item_single_loading, new C1557h(this.f6095a, this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C1496ak.card_action_list_fragment, viewGroup);
        ListView listView = (ListView) relativeLayout.findViewById(C1494ai.list);
        listView.setAdapter(this.f6096b);
        listView.setOnItemClickListener(this);
        listView.setEmptyView((TextView) relativeLayout.findViewById(16908292));
        return relativeLayout;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((C1556g) getActivity()).onCardAction(this.f6095a, CardActions.Action.values()[((ImageTextArrowRow) this.f6096b.getItem(i)).getId()]);
    }
}
