package com.jackhenry.godough.core.locations;

import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.jackhenry.android.p022a.C1362i;
import com.jackhenry.android.p022a.C1363j;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.widgets.ActionButton;
import java.util.List;

public class LocationCityFragment extends C1802r implements View.OnClickListener {

    /* renamed from: a */
    private ActionButton f6174a;

    /* renamed from: b */
    private ActionButton f6175b;

    /* renamed from: c */
    private View f6176c;

    /* renamed from: d */
    private EditText f6177d;

    /* renamed from: e */
    private TextView f6178e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f6179f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<C1363j> f6180g;

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6228n() {
        if (this.f6179f == null || this.f6177d.getText().toString().trim().length() <= 0) {
            this.f6175b.setEnabled(false);
        } else {
            this.f6175b.setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6229o() {
        if (this.f6179f == null) {
            this.f6178e.setText(getString(C1506am.tap_select));
            this.f6178e.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
        } else {
            this.f6178e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.f6178e.setText(C1362i.m5581a(this.f6179f).mo9284a());
        }
        m6228n();
    }

    /* renamed from: p */
    private synchronized void m6230p() {
        int i;
        if (this.f6180g != null && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), C1496ak.selection_dialog_list_item, this.f6180g);
            arrayAdapter.setDropDownViewResource(C1496ak.selection_dialog_list_item);
            if (this.f6179f != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f6180g.size()) {
                        break;
                    } else if (this.f6180g.get(i2).mo9285b().equals(this.f6179f)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            i = -1;
            C1512c cVar = new C1512c();
            cVar.mo9713b(getString(C1506am.select_state));
            cVar.mo9712a(arrayAdapter, i, new C1607f(this));
            cVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    public void onClick(View view) {
        if (view == this.f6174a.getButton()) {
            ((LocationSearchCriteria.OnLocationSearch) getActivity()).onLocationCancel();
        } else if (view == this.f6175b.getButton()) {
            ((LocationSearchCriteria.OnLocationSearch) getActivity()).onLocationSearch(new LocationSearchCriteria(this.f6177d.getText().toString(), this.f6179f, (String) null));
        } else if (view == this.f6176c) {
            m6230p();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.location_city_fragment, viewGroup);
        this.f6180g = LocationSearchCriteria.getUniqueStates(GoDoughApp.getLocations());
        this.f6177d = (EditText) inflate.findViewById(C1494ai.city_edit);
        this.f6178e = (TextView) inflate.findViewById(C1494ai.state);
        this.f6176c = inflate.findViewById(C1494ai.state_panel);
        this.f6174a = (ActionButton) inflate.findViewById(C1494ai.btn_cancel);
        this.f6175b = (ActionButton) inflate.findViewById(C1494ai.btn_search);
        this.f6174a.setOnClickListener(this);
        this.f6175b.setOnClickListener(this);
        this.f6176c.setOnClickListener(this);
        this.f6177d.addTextChangedListener(new C1606e(this));
        m6229o();
        return inflate;
    }
}
