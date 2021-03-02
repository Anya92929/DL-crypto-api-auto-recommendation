package com.jackhenry.godough.core.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import com.jackhenry.godough.core.widgets.ActionButton;

public class LocationZipFragment extends C1802r implements View.OnClickListener {

    /* renamed from: a */
    private EditText f6218a;

    /* renamed from: b */
    private ActionButton f6219b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ActionButton f6220c;

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6258n() {
        this.f6220c.setEnabled(this.f6218a.getText().toString().length() > 4);
    }

    public void onClick(View view) {
        if (view == this.f6219b.getButton() || view == this.f6219b) {
            ((LocationSearchCriteria.OnLocationSearch) getActivity()).onLocationCancel();
        } else if (view == this.f6220c.getButton() || view == this.f6220c) {
            ((LocationSearchCriteria.OnLocationSearch) getActivity()).onLocationSearch(new LocationSearchCriteria((String) null, (String) null, this.f6218a.getText().toString()));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.location_zip_fragment, viewGroup);
        this.f6218a = (EditText) inflate.findViewById(C1494ai.zip_edit);
        this.f6218a.addTextChangedListener(new C1621t(this));
        this.f6218a.setOnEditorActionListener(new C1622u(this));
        this.f6219b = (ActionButton) inflate.findViewById(C1494ai.btn_cancel);
        this.f6220c = (ActionButton) inflate.findViewById(C1494ai.btn_search);
        this.f6219b.setOnClickListener(this);
        this.f6220c.setOnClickListener(this);
        m6258n();
        return inflate;
    }
}
