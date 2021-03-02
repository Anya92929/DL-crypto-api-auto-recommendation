package com.jackhenry.godough.core.rda.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.RDAUserRegistrationData;
import com.jackhenry.godough.core.model.RDAVelocity;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.core.rda.DepositReviewFragmentActivity;
import com.jackhenry.godough.core.rda.RDAFragmentActivity;
import java.util.ArrayList;
import java.util.List;

public class RDARegistrationFragmentActivity extends GodoughTransactionActivity implements C1865p {
    public static final String EXTRA_REDIRECT_TO = "REDIRECT_TO";
    public static final int EXTRA_TC = 1;
    public static final int EXTRA_USERINFORMATION = 2;
    public static int RDA_T_C_LOADER = 1002;
    public static int USER_INFORMATION_LOADER = 1001;

    /* renamed from: m */
    private static int f6719m = 1200;

    /* renamed from: n */
    private String f6720n;

    /* renamed from: o */
    private boolean f6721o = true;

    public void actionButtonClickHandler() {
        if (this.f6721o) {
            startActivity(getPackageManager().hasSystemFeature("android.hardware.camera") ? new Intent(GoDoughApp.getApp(), RDAFragmentActivity.class) : new Intent(GoDoughApp.getApp(), DepositReviewFragmentActivity.class));
        }
        finish();
    }

    public void buildConfirmation(RDAVelocity rDAVelocity, String str, boolean z) {
        this.f6721o = z;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1574c(-1, getString(C1506am.btn_ok)));
        C1869t tVar = new C1869t(this, str, rDAVelocity, z);
        String string = getString(C1506am.title_rda_enrollment_submitted);
        if (!z) {
            string = getString(C1506am.registration_submitted);
        }
        C1576e eVar = new C1576e(C1577f.SUCCESS, f6719m, string, (C1579h) tVar, (List<C1574c>) arrayList);
        eVar.mo9791a((C1578g) new C1870u(this));
        getSupportActionBar().setSubtitle((CharSequence) null);
        showConfirmationScreen(C1494ai.layout, eVar);
    }

    public void cancelButtonOnClickHandler() {
        cancelButtonOnClickHandler((String) null, getString(C1506am.btn_cancel), getString(C1506am.btn_quit));
    }

    public void cancelButtonOnClickHandler(String str, String str2, String str3) {
        String str4;
        if (str == null) {
            str4 = getString(C1506am.cancel_rda_terms, new Object[]{GoDoughApp.getUserSettings().getUserMenu().getRda().getText()});
        } else {
            str4 = str;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1574c(-1, str3));
        arrayList.add(new C1574c(-2, str2));
        C1576e eVar = new C1576e(C1577f.ERROR, 100, getString(C1506am.warning), str4, (List<C1574c>) arrayList);
        eVar.mo9791a((C1578g) new C1868s(this));
        showDialog(eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentByTag(this.f6720n);
    }

    public void onBackPressed() {
        cancelButtonOnClickHandler();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.rda_registration_activity);
        int intExtra = getIntent().getIntExtra(EXTRA_REDIRECT_TO, -1);
        if (bundle != null) {
            this.f6720n = bundle.getString("EXTRA_CURRENT_FRAGMENT_TAG");
            setTransactionFragment(getSupportFragmentManager().findFragmentByTag(this.f6720n));
        } else if (intExtra == 1) {
            RDATermsAndConditionsFragment rDATermsAndConditionsFragment = new RDATermsAndConditionsFragment();
            getSupportFragmentManager().beginTransaction().add(C1494ai.layout, rDATermsAndConditionsFragment, RDATermsAndConditionsFragment.TAG).commit();
            this.f6720n = RDATermsAndConditionsFragment.TAG;
            setTransactionFragment(rDATermsAndConditionsFragment);
        } else if (intExtra == 2) {
            RDARegistrationConfirmInformationFragment rDARegistrationConfirmInformationFragment = new RDARegistrationConfirmInformationFragment();
            getSupportFragmentManager().beginTransaction().add(C1494ai.layout, rDARegistrationConfirmInformationFragment, RDARegistrationConfirmInformationFragment.TAG).commit();
            this.f6720n = RDARegistrationConfirmInformationFragment.TAG;
            setTransactionFragment(rDARegistrationConfirmInformationFragment);
        }
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getRda().getText());
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("EXTRA_CURRENT_FRAGMENT_TAG", this.f6720n);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    public void resetFields() {
    }

    public void userInformationEntered(RDAUserRegistrationData rDAUserRegistrationData) {
        setActionBarNavigationOn(false);
        RDARegistrationAccountSelectionFragment instance = RDARegistrationAccountSelectionFragment.getInstance(rDAUserRegistrationData);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentByTag(RDARegistrationConfirmInformationFragment.TAG)).add(C1494ai.layout, instance, RDARegistrationAccountSelectionFragment.TAG).setTransition(0).commit();
        setTransactionFragment(instance);
        this.f6720n = RDARegistrationAccountSelectionFragment.TAG;
    }
}
