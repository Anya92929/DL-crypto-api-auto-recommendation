package com.jackhenry.godough.core;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import com.jackhenry.godough.core.p038e.C1576e;

public abstract class GodoughTransactionActivity extends AbstractActivity {

    /* renamed from: m */
    private C1576e f5785m;

    /* renamed from: n */
    private GoDoughConfirmationFragment f5786n;

    /* renamed from: o */
    private Fragment f5787o;

    /* renamed from: p */
    private boolean f5788p = true;

    public void actionButtonClickHandler() {
        resetScreen();
    }

    public void cancelButtonOnClickHandler() {
        onBackPressed();
    }

    public final C1576e getDialogParams() {
        return this.f5785m;
    }

    public Fragment getTransactionFragment() {
        return this.f5787o;
    }

    public boolean isResetFields() {
        return this.f5788p;
    }

    public void onBackPressed() {
        if (this.f5786n == null) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResetFields(false);
    }

    public void onNoData(Object obj) {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (isResetFields()) {
            resetFields();
        }
        setResetFields(true);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f5786n = (GoDoughConfirmationFragment) getSupportFragmentManager().findFragmentByTag("CONFIRMATION_TAG");
        if (this.f5786n != null) {
            setActionBarNavigationOn(false);
        } else {
            setActionBarNavigationOn(true);
        }
    }

    public final void removeConfirmationScreen() {
        if (getTransactionFragment() != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(this.f5786n);
            beginTransaction.show(getTransactionFragment()).commitAllowingStateLoss();
            this.f5786n = null;
        }
    }

    public abstract void resetFields();

    public void resetScreen() {
        removeConfirmationScreen();
        setActionBarNavigationOn(true);
        resetFields();
    }

    public final void setConfirmParams(C1576e eVar) {
        this.f5785m = eVar;
    }

    public void setResetFields(boolean z) {
        this.f5788p = z;
    }

    public void setTransactionFragment(Fragment fragment) {
        this.f5787o = fragment;
    }

    public final void showConfirmationScreen(int i, C1576e eVar) {
        setActionBarNavigationOn(false);
        if (getTransactionFragment() != null) {
            setConfirmParams(eVar);
            if (this.f5786n == null) {
                this.f5786n = new GoDoughConfirmationFragment();
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.hide(getTransactionFragment());
            beginTransaction.add(i, this.f5786n, "CONFIRMATION_TAG").commit();
        }
    }

    public final void showConfirmationScreen(int i, C1576e eVar, String str, String str2) {
        setActionBarNavigationOn(false);
        if (this.f5786n == null) {
            this.f5786n = new GoDoughConfirmationFragment();
        }
        if (str2 != null) {
            this.f5786n.setActionButtonLabel(str2);
        }
        if (str != null) {
            this.f5786n.setCancelButtonLabel(str);
        }
        showConfirmationScreen(i, eVar);
    }
}
