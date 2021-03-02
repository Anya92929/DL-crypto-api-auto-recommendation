package com.jackhenry.godough.core.locations;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: com.jackhenry.godough.core.locations.r */
class C1619r implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ LocationResultsFragmentActivity f6256a;

    C1619r(LocationResultsFragmentActivity locationResultsFragmentActivity) {
        this.f6256a = locationResultsFragmentActivity;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f6256a.filterLocations(i);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
