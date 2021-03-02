package com.jackhenry.godough.core.ach;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.jackhenry.android.p022a.p023a.C1354f;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.ACH;

public class ACHFragment extends C1802r {
    public static final String EXTRA_ACH = "EXTRA_ACH";
    public static final String TAG = ACHFragment.class.getSimpleName();

    /* renamed from: a */
    C1470a f5946a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1354f<ACH> f5947b;

    /* renamed from: c */
    private ListView f5948c;

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.f5946a.mo9677a(true);
            this.f5947b.mo9282h();
            this.f5947b.mo6276d();
            this.f5947b.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5946a = new C1470a(this);
        this.f5947b = new C1354f<>(getActivity(), true, C1496ak.list_item_single_loading, C1496ak.list_item_loading, this.f5946a);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.ach_fragment, viewGroup);
        this.f5948c = (ListView) inflate.findViewById(C1494ai.list);
        this.f5948c.setAdapter(this.f5947b);
        this.f5948c.setEmptyView(inflate.findViewById(16908292));
        this.f5948c.setOnItemClickListener(new C1485p(this));
        return inflate;
    }
}
