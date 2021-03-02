package com.jackhenry.godough.core.wires;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.jackhenry.android.p022a.p023a.C1354f;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Wire;

public class WiresFragment extends C1802r {
    public static final String TAG = WiresFragment.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1354f<Wire> f6890a;

    /* renamed from: b */
    private ListView f6891b;

    /* renamed from: c */
    private String f6892c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1939o f6893d;

    public static WiresFragment newInstance(String str) {
        WiresFragment wiresFragment = new WiresFragment();
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(Wire.STATUS_NEED_APPROVAL, str);
        }
        wiresFragment.setArguments(bundle);
        return wiresFragment;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2) {
            this.f6890a.mo6276d();
            this.f6890a.mo6272a(true);
            this.f6890a.mo9282h();
            this.f6890a.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        C1936l lVar;
        super.onCreate(bundle);
        if (!GoDoughApp.getUserSettings().isHasDualControlWires()) {
            lVar = new C1936l(this);
        } else {
            if (getArguments() == null || !getArguments().containsKey(Wire.STATUS_NEED_APPROVAL)) {
                this.f6892c = null;
            } else {
                this.f6892c = getArguments().getString(Wire.STATUS_NEED_APPROVAL);
            }
            lVar = new C1936l((Fragment) this, this.f6892c);
        }
        if (this.f6890a == null) {
            this.f6890a = new C1354f<>(getActivity(), true, C1496ak.list_item_single_loading, C1496ak.list_item_single, lVar);
            this.f6890a.registerDataSetObserver(new C1937m(this));
            this.f6890a.mo6277e();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.wires_fragment, viewGroup, false);
        this.f6891b = (ListView) inflate.findViewById(C1494ai.list);
        this.f6891b.setAdapter(this.f6890a);
        this.f6891b.setEmptyView(inflate.findViewById(16908292));
        this.f6891b.setOnItemClickListener(new C1938n(this));
        return inflate;
    }

    public void setWireListener(C1939o oVar) {
        this.f6893d = oVar;
    }
}
