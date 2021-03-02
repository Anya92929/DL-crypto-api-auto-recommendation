package com.jackhenry.godough.core.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.jackhenry.android.p022a.p023a.C1350b;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.GoDoughLocation;

public class LocationResultsFragment extends C1802r implements C1601ae {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1350b<GoDoughLocation> f6208a;

    /* renamed from: b */
    private ListView f6209b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6208a = ((LocationResultsFragmentActivity) getActivity()).getLocationAdapter();
        View inflate = layoutInflater.inflate(C1496ak.location_results_fragment, viewGroup);
        this.f6209b = (ListView) inflate.findViewById(C1494ai.list);
        this.f6209b.setAdapter(this.f6208a);
        this.f6209b.setEmptyView(inflate.findViewById(16908292));
        this.f6209b.setOnItemClickListener(new C1617p(this));
        return inflate;
    }

    public void onLocationsChanged() {
    }
}
