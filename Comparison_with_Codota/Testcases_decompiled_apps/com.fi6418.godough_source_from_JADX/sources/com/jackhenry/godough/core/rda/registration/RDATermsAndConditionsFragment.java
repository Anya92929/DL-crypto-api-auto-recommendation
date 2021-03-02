package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.GoDoughWebView;

public class RDATermsAndConditionsFragment extends C1802r implements CompoundButton.OnCheckedChangeListener {
    public static final String EXTRA_IS_TANDC_COLLECT = "EXTRA_IS_TANDC_COLLECT";
    public static final String TAG = RDATermsAndConditionsFragment.class.getSimpleName();

    /* renamed from: a */
    private GoDoughWebView f6722a;

    /* renamed from: b */
    private CheckBox f6723b;

    /* renamed from: c */
    private ActionButton f6724c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f6725d;

    /* renamed from: e */
    private C1850ah f6726e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Boolean f6727f;

    public void initUI() {
        this.f6723b.setEnabled(true);
        this.f6722a.loadDataWithBaseURL((String) null, this.f6725d, "text/html", "UTF-8", (String) null);
        this.f6722a.invalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo11060n() {
        mo10988l();
        C1845ac acVar = new C1845ac(this, this, new C1874y(this));
        if (this.f6725d == null) {
            getActivity().getSupportLoaderManager().initLoader(RDARegistrationFragmentActivity.RDA_T_C_LOADER, (Bundle) null, acVar);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f6724c.setEnabled(z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6727f = Boolean.valueOf(getActivity().getIntent().getBooleanExtra(EXTRA_IS_TANDC_COLLECT, false));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.rda_terms_and_conditions_fragment, viewGroup, false);
        this.f6722a = (GoDoughWebView) inflate.findViewById(C1494ai.rdaterms);
        this.f6722a.getSettings().setLoadWithOverviewMode(false);
        this.f6722a.getSettings().setUseWideViewPort(false);
        this.f6723b = (CheckBox) inflate.findViewById(C1494ai.agree_checkbox);
        this.f6724c = (ActionButton) inflate.findViewById(C1494ai.btn_continue);
        this.f6724c.setEnabled(false);
        this.f6724c.setOnClickListener(new C1872w(this));
        ((ActionButton) inflate.findViewById(C1494ai.btn_cancel)).setOnClickListener(new C1873x(this));
        this.f6723b.setOnCheckedChangeListener(this);
        if (this.f6725d == null) {
            mo11060n();
        } else {
            initUI();
        }
        ((AbstractActivity) getActivity()).getSupportActionBar().setSubtitle((CharSequence) getString(C1506am.lbl_rda_terms_title));
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.f6726e == null) {
            return;
        }
        if (!this.f6726e.mo10926c()) {
            mo10986b(getString(C1506am.dg_processing));
        } else if (this.f6726e.mo10929e()) {
            this.f6726e.mo10922a().mo9589a(this.f6726e.mo10927d());
        } else {
            this.f6726e.mo10922a().mo9588a(this.f6726e.mo10925b());
        }
    }

    public void submitData() {
        mo10986b(getString(C1506am.dg_processing));
        this.f6726e = new C1850ah(new C1844ab(this, this, new C1843aa(this)), this.f6727f.booleanValue());
        this.f6726e.execute(new Void[0]);
    }
}
