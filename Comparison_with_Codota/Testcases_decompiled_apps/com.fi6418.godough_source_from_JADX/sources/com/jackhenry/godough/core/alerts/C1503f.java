package com.jackhenry.godough.core.alerts;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: com.jackhenry.godough.core.alerts.f */
class C1503f implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertsFragment f5985a;

    C1503f(AlertsFragment alertsFragment) {
        this.f5985a = alertsFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((C1504g) this.f5985a.getActivity()).onAlertClicked(i);
    }
}
