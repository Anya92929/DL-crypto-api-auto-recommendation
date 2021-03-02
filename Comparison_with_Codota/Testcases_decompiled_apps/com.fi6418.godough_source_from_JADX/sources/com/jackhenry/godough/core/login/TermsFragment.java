package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.GoDoughWebView;

public class TermsFragment extends C1802r implements CompoundButton.OnCheckedChangeListener {
    public static final String TAG = TermsFragment.class.getSimpleName();

    /* renamed from: a */
    private GoDoughWebView f6365a;

    /* renamed from: b */
    private CheckBox f6366b;

    /* renamed from: c */
    private ActionButton f6367c;

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f6367c.setEnabled(z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.terms_fragment, (ViewGroup) null, false);
        this.f6365a = (GoDoughWebView) inflate.findViewById(C1494ai.terms);
        this.f6365a.getSettings().setLoadWithOverviewMode(false);
        this.f6365a.getSettings().setUseWideViewPort(false);
        this.f6366b = (CheckBox) inflate.findViewById(C1494ai.agree_checkbox);
        this.f6367c = (ActionButton) inflate.findViewById(C1494ai.btn_continue);
        this.f6367c.setOnClickListener(new C1727dr(this));
        ((ActionButton) inflate.findViewById(C1494ai.btn_cancel)).setOnClickListener(new C1728ds(this));
        this.f6366b.setOnCheckedChangeListener(this);
        if (((TermsAndConditionsFragmentActivity) getActivity()).getTermsAndConditions() != null) {
            setData(((TermsAndConditionsFragmentActivity) getActivity()).getTermsAndConditions());
        }
        return inflate;
    }

    public void setData(String str) {
        this.f6366b.setEnabled(true);
        this.f6365a.loadDataWithBaseURL((String) null, str, "text/html", "UTF-8", (String) null);
        this.f6365a.invalidate();
    }
}
