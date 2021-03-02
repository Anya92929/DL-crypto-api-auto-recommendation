package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p000v4.app.FragmentTransaction;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.Carrier;
import java.io.Serializable;
import java.util.List;

public class EnrollmentFragmentActivity extends TermsAndConditionsFragmentActivity implements C1751z {

    /* renamed from: m */
    List<Carrier> f6274m;

    /* renamed from: p */
    private EnrollmentSettingsFragment f6275p;

    public void acceptSettings(Carrier carrier, String str, boolean z) {
        mo9483a(getString(C1506am.dg_processing));
        new C1719dj(carrier, str.replaceAll("[^0-9]", ""), z, new C1743r(this, getSupportFragmentManager().findFragmentByTag(EnrollmentSettingsFragment.TAG), new C1742q(this, carrier, str, z))).execute(new Void[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo9874g() {
        mo9489f();
        C1744s sVar = new C1744s(this, this.f6364o, new C1740o(this));
        if (getSupportLoaderManager().getLoader(0) == null) {
            getSupportLoaderManager().initLoader(0, (Bundle) null, sVar);
        } else {
            getSupportLoaderManager().restartLoader(0, (Bundle) null, sVar);
        }
    }

    public List<Carrier> getCarriers() {
        return this.f6274m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo9879h() {
        EnrollmentSettingsFragment enrollmentSettingsFragment = new EnrollmentSettingsFragment();
        setTitle(C1506am.enrollment_title);
        getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(TermsFragment.TAG)).add(C1494ai.layout, enrollmentSettingsFragment, EnrollmentSettingsFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            setCarriers((List) bundle.getSerializable("KEY_SED"));
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("KEY_SED", (Serializable) getCarriers());
    }

    public void setCarriers(List<Carrier> list) {
        this.f6274m = list;
    }

    public void termsAccepted() {
        this.f6275p = new EnrollmentSettingsFragment();
        setTitle(C1506am.enrollment_title);
        getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(TermsFragment.TAG)).add(C1494ai.layout, this.f6275p, EnrollmentSettingsFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}
