package com.jackhenry.godough.core.locations;

import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.model.GoDoughLocation;

/* renamed from: com.jackhenry.godough.core.locations.p */
class C1617p implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ LocationResultsFragment f6255a;

    C1617p(LocationResultsFragment locationResultsFragment) {
        this.f6255a = locationResultsFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((C1618q) this.f6255a.getActivity()).onLocationClicked((GoDoughLocation) this.f6255a.f6208a.getItem(i));
    }
}
