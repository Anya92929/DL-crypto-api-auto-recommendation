package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.RDARegistrationAccount;
import com.jackhenry.godough.core.model.RDAUserRegistrationData;
import com.jackhenry.godough.core.widgets.ActionButton;
import java.util.ArrayList;

public class RDARegistrationAccountSelectionFragment extends C1802r {
    public static final String TAG = RDARegistrationAccountSelectionFragment.class.getSimpleName();

    /* renamed from: a */
    private static int f6705a = 1000;

    /* renamed from: b */
    private ListView f6706b;

    /* renamed from: c */
    private boolean f6707c = true;

    /* renamed from: d */
    private ActionButton f6708d;

    /* renamed from: e */
    private View f6709e;

    /* renamed from: f */
    private C1858i f6710f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1849ag f6711g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RDAUserRegistrationData f6712h;

    public static RDARegistrationAccountSelectionFragment getInstance(RDAUserRegistrationData rDAUserRegistrationData) {
        RDARegistrationAccountSelectionFragment rDARegistrationAccountSelectionFragment = new RDARegistrationAccountSelectionFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("RDA_USER_INFORMATON", rDAUserRegistrationData);
        rDARegistrationAccountSelectionFragment.setArguments(bundle);
        return rDARegistrationAccountSelectionFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6773n() {
        this.f6708d.setEnabled(false);
        if (m6774o().size() > 0) {
            this.f6708d.setEnabled(true);
        }
    }

    /* renamed from: o */
    private ArrayList<RDARegistrationAccount> m6774o() {
        ArrayList<RDARegistrationAccount> arrayList = new ArrayList<>();
        ArrayList<Boolean> a = ((C1858i) this.f6706b.getAdapter()).mo11081a();
        this.f6708d.setEnabled(false);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).booleanValue()) {
                arrayList.add(((C1858i) this.f6706b.getAdapter()).getItem(i));
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6712h = (RDAUserRegistrationData) getArguments().getSerializable("RDA_USER_INFORMATON");
        this.f6709e = layoutInflater.inflate(C1496ak.rda_account_selection_fragment, viewGroup, false);
        this.f6706b = (ListView) this.f6709e.findViewById(C1494ai.list);
        this.f6708d = (ActionButton) this.f6709e.findViewById(C1494ai.btn_continue);
        this.f6708d.setEnabled(false);
        this.f6708d.setOnClickListener(new C1855f(this));
        ((ActionButton) this.f6709e.findViewById(C1494ai.btn_cancel)).setOnClickListener(new C1856g(this));
        if (this.f6710f == null) {
            this.f6710f = new C1858i(this, getActivity(), this.f6712h.getAccounts());
        }
        this.f6706b.setEmptyView(this.f6709e.findViewById(16908292));
        this.f6706b.setChoiceMode(2);
        this.f6706b.setAdapter(this.f6710f);
        ((AbstractActivity) getActivity()).getSupportActionBar().setSubtitle((CharSequence) getString(C1506am.lbl_rda_account_selection_title, GoDoughApp.getUserSettings().getUserMenu().getRda().getText()));
        m6773n();
        return this.f6709e;
    }

    public void onStart() {
        super.onStart();
        if (this.f6711g == null) {
            return;
        }
        if (!this.f6711g.mo10926c()) {
            mo10986b(getString(C1506am.dg_processing));
        } else if (this.f6711g.mo10929e()) {
            this.f6711g.mo10922a().mo9589a(this.f6711g.mo10927d());
        } else {
            this.f6711g.mo10922a().mo9588a(this.f6711g.mo10925b());
        }
    }

    public void submitData(Object obj) {
        RDAUserRegistrationData rDAUserRegistrationData = new RDAUserRegistrationData((RDAUserRegistrationData) obj, m6774o());
        mo10986b(getString(C1506am.dg_processing));
        this.f6711g = new C1849ag(rDAUserRegistrationData, new C1860k(this, this, new C1857h(this, rDAUserRegistrationData)));
        this.f6711g.execute(new Void[0]);
    }
}
