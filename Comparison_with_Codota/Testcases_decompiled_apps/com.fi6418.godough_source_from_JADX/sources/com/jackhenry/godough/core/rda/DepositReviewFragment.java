package com.jackhenry.godough.core.rda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.jackhenry.android.p022a.p023a.C1354f;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.DepositTransaction;

public class DepositReviewFragment extends C1802r {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1354f<DepositTransaction> f6635a;

    /* renamed from: b */
    private ListView f6636b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.deposit_review_fragment, viewGroup);
        this.f6636b = (ListView) inflate.findViewById(C1494ai.list);
        this.f6636b.setEmptyView(inflate.findViewById(16908292));
        this.f6636b.setOnItemClickListener(new C1841r(this));
        this.f6636b.getEmptyView().setVisibility(4);
        this.f6636b.setVisibility(4);
        if (this.f6635a != null) {
            this.f6636b.setVisibility(0);
            this.f6636b.setAdapter(this.f6635a);
        }
        return inflate;
    }

    public void setupAdapter() {
        this.f6636b.setVisibility(0);
        if (this.f6635a == null) {
            this.f6636b.getEmptyView().setVisibility(0);
            this.f6635a = new C1354f<>(getActivity(), true, C1496ak.list_item_single_loading, C1496ak.list_item_single, new C1813d(this));
            this.f6636b.setAdapter(this.f6635a);
        }
    }
}
