package com.jackhenry.godough.core.cards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.jackhenry.android.p022a.p023a.C1354f;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.Card;

public class ManageCardsFragment extends C1802r implements AdapterView.OnItemClickListener {
    public static final String EXTRA_ACTION = "EXTRA_ACTION";
    public static final String EXTRA_CARD = "EXTRA_CARD";
    public static final String EXTRA_CARDS_LIST = "EXTRA_CARDS_LIST";
    public static final String TAG = ManageCardsFragment.class.getSimpleName();

    /* renamed from: a */
    private C1354f<Card> f6097a;

    /* renamed from: b */
    private ListView f6098b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6097a = new C1354f<>(getActivity(), true, C1496ak.list_item_single_loading, C1496ak.list_item_loading, new C1558i(C1496ak.list_item_icon_nav_small_2, this, false));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.manage_cards_fragment, viewGroup);
        this.f6098b = (ListView) inflate.findViewById(C1494ai.list);
        this.f6098b.setAdapter(this.f6097a);
        this.f6098b.setEmptyView(inflate.findViewById(16908292));
        this.f6098b.setOnItemClickListener(this);
        return inflate;
    }

    public synchronized void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((C1559j) getActivity()).onCardSelected((Card) this.f6097a.getItem(i));
    }

    public void updateCards() {
        this.f6097a = new C1354f<>(getActivity(), true, C1496ak.list_item_single_loading, C1496ak.list_item_loading, new C1558i(C1496ak.list_item_icon_nav_small_2, this, false));
        this.f6098b.setAdapter(this.f6097a);
    }
}
