package com.jackhenry.godough.core.alerts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.jackhenry.android.p022a.p023a.C1354f;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.Alert;

public class AlertsFragment extends C1802r {

    /* renamed from: a */
    protected C1354f<Alert> f5977a;

    /* renamed from: b */
    private ListView f5978b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5977a = new C1354f<>(getActivity(), true, C1496ak.list_item_single_loading, C1496ak.list_item_single, new C1498a(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.alerts_fragment, viewGroup);
        this.f5978b = (ListView) inflate.findViewById(C1494ai.list);
        this.f5978b.setAdapter(this.f5977a);
        this.f5978b.setEmptyView(inflate.findViewById(16908292));
        this.f5978b.setOnItemClickListener(new C1503f(this));
        return inflate;
    }
}
