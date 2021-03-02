package com.jackhenry.godough.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p003v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.jackhenry.godough.core.about.AboutFragmentActivity;
import com.jackhenry.godough.core.accounts.AccountsFragmentActivity;
import com.jackhenry.godough.core.accounts.statements.StatementFragmentActivity;
import com.jackhenry.godough.core.ach.ACHFragmentActivity;
import com.jackhenry.godough.core.alerts.AlertsFragmentActivity;
import com.jackhenry.godough.core.billpay.BillPayFragmentActivity;
import com.jackhenry.godough.core.cards.ManageCardsFragmentActivity;
import com.jackhenry.godough.core.locations.LocationsFragmentActivity;
import com.jackhenry.godough.core.login.C1654az;
import com.jackhenry.godough.core.model.GodoughMenuItem;
import com.jackhenry.godough.core.p034b.p035a.C1511b;
import com.jackhenry.godough.core.p034b.p035a.C1514e;
import com.jackhenry.godough.core.p036c.C1546b;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.core.p038e.C1584m;
import com.jackhenry.godough.core.p038e.C1585n;
import com.jackhenry.godough.core.p038e.C1586o;
import com.jackhenry.godough.core.p2p.P2PFragmentActivity;
import com.jackhenry.godough.core.prefmenu.GodoughPreferenceActivity;
import com.jackhenry.godough.core.rda.DepositReviewFragmentActivity;
import com.jackhenry.godough.core.rda.RDAFragmentActivity;
import com.jackhenry.godough.core.session.C1888d;
import com.jackhenry.godough.core.session.SessionTimeoutWarningActivity;
import com.jackhenry.godough.core.transfers.TransfersFragmentActivity;
import com.jackhenry.godough.core.wires.WiresFragmentActivity;
import com.jackhenry.godough.core.wires.WiresTabbedFragmentActivity;
import com.jackhenry.godough.p024a.C1373a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractActivity extends AppCompatActivity implements Serializable {
    public static final int ACTIVITY_SETTINGS_REQ = 5002;
    public static final String BUNDLE_RETRY_RUNNABLE = "BUNDLE_RETRY_RUNNABLE";
    public static final int BUTTON_OK = -1;
    public static final int DIALOG_LOG_OUT = 5001;
    public static final int DIALOG_NO_API = 5010;
    public static final int DIALOG_NO_NETWORK = 5002;
    public static final int DIALOG_OFF_LINE = 5004;
    public static final int DIALOG_P2P_PAY_FAILED = 5033;
    public static final int DIALOG_P2P_PAY_SUCCESS = 5034;
    public static final int DIALOG_REDIRECT = 5035;
    public static final int DIALOG_WARNING = 5032;

    /* renamed from: j */
    C1888d f5760j;

    /* renamed from: k */
    protected C1654az f5761k;

    /* renamed from: l */
    protected boolean f5762l = false;

    /* renamed from: m */
    private C1546b f5763m;

    /* renamed from: n */
    private String f5764n;

    /* renamed from: o */
    private boolean f5765o = false;

    /* renamed from: a */
    private Intent m5735a(GodoughMenuItem.Type type) {
        switch (C1591h.f6166a[type.ordinal()]) {
            case 1:
                return new Intent(GoDoughApp.getApp(), AccountsFragmentActivity.class);
            case 2:
                return new Intent(GoDoughApp.getApp(), ACHFragmentActivity.class);
            case 3:
                return new Intent(GoDoughApp.getApp(), AlertsFragmentActivity.class);
            case 4:
                return new Intent(GoDoughApp.getApp(), BillPayFragmentActivity.class);
            case 5:
                return new Intent(GoDoughApp.getApp(), LocationsFragmentActivity.class);
            case 6:
                return new Intent(GoDoughApp.getApp(), ManageCardsFragmentActivity.class);
            case 7:
                return getPackageManager().hasSystemFeature("android.hardware.camera") ? new Intent(GoDoughApp.getApp(), RDAFragmentActivity.class) : new Intent(GoDoughApp.getApp(), DepositReviewFragmentActivity.class);
            case 8:
                return new Intent(GoDoughApp.getApp(), TransfersFragmentActivity.class);
            case 9:
                return (GoDoughApp.getUserSettings() == null || !GoDoughApp.getUserSettings().isHasDualControlWires()) ? new Intent(GoDoughApp.getApp(), WiresFragmentActivity.class) : new Intent(GoDoughApp.getApp(), WiresTabbedFragmentActivity.class);
            case 10:
                return new Intent(GoDoughApp.getApp(), P2PFragmentActivity.class);
            case 11:
                return new Intent(GoDoughApp.getApp(), AboutFragmentActivity.class);
            case 12:
                return new Intent(GoDoughApp.getApp(), StatementFragmentActivity.class);
            case 13:
                return new Intent(GoDoughApp.getApp(), GodoughPreferenceActivity.class);
            default:
                return null;
        }
    }

    /* renamed from: a */
    private View m5736a(int i) {
        return m5737a(getLayoutInflater().inflate(i, (ViewGroup) null, false));
    }

    /* renamed from: a */
    private View m5737a(View view) {
        this.f5763m = new C1546b(this);
        return this.f5763m.mo9748a(view, showBackArrowOnToolbar());
    }

    /* renamed from: a */
    private void m5739a(C1511b bVar) {
        dismissLoadingDialog();
        getSupportFragmentManager().beginTransaction().add((Fragment) bVar, C1802r.PROGRESS_DIALOG).commitAllowingStateLoss();
    }

    public static C1576e createNoNetworkDialog(AbstractActivity abstractActivity, C1593j jVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1574c(-1, abstractActivity.getString(C1506am.btn_exit)));
        arrayList.add(new C1574c(-2, abstractActivity.getString(C1506am.btn_retry)));
        arrayList.add(new C1574c(-3, abstractActivity.getString(C1506am.no_connectivity_settings)));
        C1576e eVar = new C1576e(C1577f.ERROR, 5002, abstractActivity.getString(C1506am.no_connectivity_title), abstractActivity.getString(C1506am.no_connectivity), (List<C1574c>) arrayList);
        eVar.mo9791a((C1578g) new C1590g(abstractActivity, jVar));
        return eVar;
    }

    /* renamed from: g */
    private void mo9874g() {
        View findViewById = findViewById(C1494ai.layout);
        if (findViewById != null) {
            C1586o.m6205b(findViewById);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void mo9879h() {
        this.f5762l = true;
        new C1654az(new C1592i(this, mo9485d(), new C1563d(this))).execute(new Void[0]);
    }

    /* renamed from: i */
    private boolean m5742i() {
        if (GoDoughApp.getLandingPageType() != null) {
            if (getClass().getName().equals(m5735a(GoDoughApp.getLandingPageType()).getComponent().getShortClassName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCallable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9483a(String str) {
        if (str.equals("")) {
            str = "NOLABEL";
        }
        m5739a(C1511b.m5994b(str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9484c() {
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract Fragment mo9485d();

    public void dismissInfoDialog() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        DialogFragment dialogFragment = (DialogFragment) supportFragmentManager.findFragmentByTag("INFO_DIALOG");
        if (dialogFragment != null) {
            supportFragmentManager.beginTransaction().remove(dialogFragment).commitAllowingStateLoss();
        }
    }

    public void dismissLoadingDialog() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        DialogFragment dialogFragment = (DialogFragment) supportFragmentManager.findFragmentByTag(C1802r.PROGRESS_DIALOG);
        if (dialogFragment != null) {
            supportFragmentManager.beginTransaction().remove(dialogFragment).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo9488e() {
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo9489f() {
        m5739a(C1511b.m5995l());
    }

    public void gotoLandingPage() {
        gotoLandingPage((String) null);
    }

    public void gotoLandingPage(String str) {
        GodoughMenuItem.Type type = GodoughMenuItem.Type.values()[Integer.valueOf(new C1584m(this).mo9798a(getString(C1506am.preferences_custom_landing_page_key), String.valueOf(GodoughMenuItem.Type.ACCOUNTS.ordinal()))).intValue()];
        if (!GoDoughApp.getUserSettings().getUserMenu().isMenuActive(type)) {
            type = GodoughMenuItem.Type.ACCOUNTS;
        }
        Intent a = m5735a(type);
        a.setFlags(131072);
        if (str != null) {
            a.putExtra("REDIRECT_OFFLINE_WHILE_LOGGED_IN_MESSAGE", str);
        }
        startActivity(a);
        finish();
    }

    public void launchLogoutDialog() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1574c(-1, getString(C1506am.btn_yes_logout)));
        arrayList.add(new C1574c(-2, getString(C1506am.btn_no_logout)));
        C1576e eVar = new C1576e(C1577f.INFO, (int) DIALOG_LOG_OUT, getString(C1506am.warning), getString(C1506am.logout_prompt), (List<C1574c>) arrayList);
        eVar.mo9791a((C1578g) new C1544c(this));
        showDialog(eVar);
    }

    public void lockNavDrawer(boolean z) {
        if (!this.f5763m.mo9751a()) {
            return;
        }
        if (z) {
            this.f5763m.mo9756e().setDrawerLockMode(1);
        } else {
            this.f5763m.mo9756e().setDrawerLockMode(0);
        }
    }

    public void onBackPressed() {
        if (GoDoughApp.getLandingPageCount() != 1 || !m5742i()) {
            super.onBackPressed();
        } else {
            launchLogoutDialog();
        }
    }

    public void onButtonClicked(GodoughMenuItem.Type type) {
        Intent a = m5735a(type);
        if (a != null) {
            startActivity(a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f5763m.mo9749a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (m5742i()) {
            GoDoughApp.setLandingPageCount(GoDoughApp.getLandingPageCount() + 1);
        }
        Thread.setDefaultUncaughtExceptionHandler(new C1407a(this));
        C1373a.m5613a();
        if (GoDoughApp.getUserSettings() == null || GoDoughApp.getUserSettings().getUserMenu() == null) {
            mo9484c();
            return;
        }
        if (GoDoughApp.getUserSettings().getOfflineMessage() != null) {
            this.f5764n = GoDoughApp.getUserSettings().getOfflineMessage();
            GoDoughApp.getUserSettings().setOfflineMessage((String) null);
        }
        if (bundle != null) {
            this.f5762l = bundle.getBoolean("LOGGING_OUT", false);
            if (this.f5762l) {
                this.f5761k = (C1654az) getLastCustomNonConfigurationInstance();
                if ((this.f5761k instanceof C1654az) && this.f5761k != null) {
                    C1592i iVar = new C1592i(this, mo9485d(), new C1509b(this));
                    if (!this.f5761k.mo10926c()) {
                        this.f5761k.mo10923a(iVar);
                    } else if (this.f5761k.mo10929e()) {
                        iVar.mo9589a(this.f5761k.mo10927d());
                    } else {
                        iVar.mo9588a("");
                    }
                }
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1497al.action_bar_menu, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (m5742i()) {
            GoDoughApp.setLandingPageCount(GoDoughApp.getLandingPageCount() - 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.hasExtra("REDIRECT_OFFLINE_WHILE_LOGGED_IN_MESSAGE")) {
            this.f5764n = intent.getStringExtra("REDIRECT_OFFLINE_WHILE_LOGGED_IN_MESSAGE");
            intent.removeExtra("REDIRECT_OFFLINE_WHILE_LOGGED_IN_MESSAGE");
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (showBackArrowOnToolbar() && menuItem.getItemId() == 16908332) {
            mo9488e();
        } else if (this.f5763m.mo9751a() && this.f5763m.mo9752a(menuItem)) {
            return true;
        } else {
            if (menuItem.getItemId() == C1494ai.menu_logout) {
                launchLogoutDialog();
                return true;
            } else if (menuItem.getItemId() == 16908332) {
                mo9488e();
                return true;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        GoDoughApp.setInForeground(false);
        super.onPause();
        if (this.f5760j != null) {
            unregisterReceiver(this.f5760j);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f5763m.mo9753b();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        GoDoughApp.setInForeground(true);
        if (this.f5760j == null) {
            this.f5760j = new C1888d();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.jackhenry.godough.action.SESSION_TIMEOUT");
        intentFilter.addCategory("android.intent.category.DEFAULT");
        registerReceiver(this.f5760j, intentFilter);
        long h = new C1585n(GoDoughApp.getApp()).mo9817h();
        if (System.currentTimeMillis() >= h - 59000) {
            Intent intent = new Intent("com.jackhenry.godough.action.SESSION_TIMEOUT");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(SessionTimeoutWarningActivity.EXTRA_TIMEOUT, h);
            sendBroadcast(intent);
        }
        C1585n nVar = new C1585n(GoDoughApp.getApp());
        if (this.f5763m.mo9751a()) {
            if (!nVar.mo9810c()) {
                this.f5763m.mo9756e().openDrawer(3);
                nVar.mo9807b();
            }
            if (this.f5764n != null) {
                this.f5763m.mo9754c();
                GoDoughApp.getUserSettings().setOfflineMessage((String) null);
                showDialog(getResources().getString(C1506am.warning), this.f5764n);
                this.f5764n = null;
            }
            this.f5763m.mo9754c();
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        if (this.f5762l) {
            return this.f5761k;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("LOGGING_OUT", this.f5762l);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        String simpleName = getClass().getSimpleName();
        if (getSupportActionBar() == null || getSupportActionBar().getTitle() == null) {
            PackageManager packageManager = getPackageManager();
            try {
                simpleName = packageManager.getActivityInfo(new ComponentName(getPackageName(), getClass().getName()), 0).loadLabel(packageManager).toString();
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            simpleName = getSupportActionBar().getTitle().toString();
        }
        C1373a.m5618a(new String[]{simpleName, getClass().getSimpleName()});
    }

    public void setActionBarNavigationOn(boolean z) {
        if (z) {
            lockNavDrawer(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            return;
        }
        lockNavDrawer(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    public void setContentView(int i) {
        setContentView(i, true);
    }

    public void setContentView(int i, boolean z) {
        super.setContentView(m5736a(i));
        if (z) {
            mo9874g();
        }
    }

    public void setContentView(View view) {
        setContentView(view, true);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(m5737a(view), layoutParams);
        mo9874g();
    }

    public void setContentView(View view, boolean z) {
        super.setContentView(m5737a(view));
        if (z) {
            mo9874g();
        }
    }

    public void setShowArrowOnToolbar(boolean z) {
        this.f5765o = z;
    }

    public boolean showBackArrowOnToolbar() {
        return this.f5765o;
    }

    public void showDialog(C1576e eVar) {
        dismissInfoDialog();
        if (eVar.mo9794c() == null || eVar.mo9794c().equals("")) {
            eVar.mo9792a(getString(C1506am.dg_no_account_msg));
        }
        getSupportFragmentManager().beginTransaction().add((Fragment) C1514e.m5999a(eVar, true), "INFO_DIALOG").commitAllowingStateLoss();
    }

    public void showDialog(String str, String str2) {
        dismissInfoDialog();
        showDialog(new C1576e(str, str2));
    }

    public void showGeneralErrorRedirectDialog(int i, String str) {
        C1576e eVar = new C1576e(C1577f.ERROR, i, getString(C1506am.error), str);
        eVar.mo9791a((C1578g) new C1566e(this, this));
        showDialog(eVar);
    }

    public void showNoNetworkDialog() {
        showNoNetworkDialog((Bundle) null);
    }

    public void showNoNetworkDialog(Bundle bundle) {
        C1593j fVar = new C1589f(this);
        if (bundle != null) {
            fVar = (C1593j) bundle.getSerializable(BUNDLE_RETRY_RUNNABLE);
        }
        showDialog(createNoNetworkDialog(this, fVar));
    }

    public void showNonCancelableDialog(C1576e eVar) {
        dismissInfoDialog();
        if (eVar.mo9794c() == null || eVar.mo9794c().equals("")) {
            eVar.mo9792a(getString(C1506am.dg_no_account_msg));
        }
        getSupportFragmentManager().beginTransaction().add((Fragment) C1514e.m5999a(eVar, false), "INFO_DIALOG").commitAllowingStateLoss();
    }

    public void startActivityAndFinish(Class<?> cls) {
        startActivity(new Intent(GoDoughApp.getApp(), cls));
        finish();
    }
}
