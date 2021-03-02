package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.view.Menu;
import com.jackhenry.godough.core.AbstractNoUserMenuActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.core.p038e.C1586o;
import java.util.ArrayList;
import java.util.List;

public class TermsAndConditionsFragmentActivity extends AbstractNoUserMenuActivity implements C1690ch, C1729dt {
    public static final int DIALOG_CANCEL_TERMS = 5025;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f6362m;

    /* renamed from: n */
    protected boolean f6363n;

    /* renamed from: o */
    TermsFragment f6364o;

    public void cancelTerms(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(-1, getString(C1506am.btn_ok)));
            arrayList.add(new C1574c(-2, getString(C1506am.btn_cancel)));
            C1576e eVar = new C1576e(C1577f.ERROR, (int) DIALOG_CANCEL_TERMS, getString(C1506am.warning), getString(C1506am.cancel_terms), (List<C1574c>) arrayList);
            eVar.mo9791a((C1578g) new C1723dn(this));
            showDialog(eVar);
            return;
        }
        setTitle(C1506am.terms_title);
        getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(EnrollmentSettingsFragment.TAG)).add(C1494ai.layout, new TermsFragment(), TermsFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentByTag(TermsFragment.TAG);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo9874g() {
        mo9489f();
        C1724do doVar = new C1724do(this, getSupportFragmentManager().findFragmentByTag(TermsFragment.TAG), new C1720dk(this));
        if (getSupportLoaderManager().getLoader(0) == null) {
            getSupportLoaderManager().initLoader(0, (Bundle) null, doVar);
        } else {
            getSupportLoaderManager().restartLoader(0, (Bundle) null, doVar);
        }
    }

    public String getTermsAndConditions() {
        return this.f6362m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo9879h() {
        gotoLandingPage();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        supportRequestWindowFeature(5);
        setContentView(C1496ak.terms_activity);
        C1586o.m6205b(findViewById(C1494ai.layout));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        if (bundle == null) {
            this.f6364o = new TermsFragment();
            getSupportFragmentManager().beginTransaction().add(C1494ai.layout, this.f6364o, TermsFragment.TAG).commit();
            return;
        }
        this.f6363n = bundle.getBoolean("KEY_LOAD_COMPLETE", false);
        this.f6362m = bundle.getString("TERMS");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("KEY_LOAD_COMPLETE", this.f6363n);
        bundle.putSerializable("TERMS", this.f6362m);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (!this.f6363n) {
            mo9874g();
        } else {
            dismissLoadingDialog();
        }
    }

    public void setTermsAndConditions(String str) {
        this.f6362m = str;
    }

    public void termsAccepted() {
        mo9483a(getString(C1506am.dg_processing));
        new C1713dd(new C1725dp(this, getSupportFragmentManager().findFragmentByTag(TermsFragment.TAG), new C1722dm(this))).execute(new Void[0]);
    }
}
