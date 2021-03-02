package com.jackhenry.godough.core.wires;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.C0018aj;
import android.support.design.widget.C0022an;
import android.support.design.widget.TabLayout;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.app.ActionBar;
import android.widget.ViewFlipper;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Wire;

public class WiresTabbedFragmentActivity extends AbstractActivity implements C0018aj {

    /* renamed from: m */
    private ActionBar f6894m;

    /* renamed from: n */
    private ViewFlipper f6895n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C0022an f6896o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C0022an f6897p;

    /* renamed from: q */
    private int f6898q = 0;

    /* renamed from: r */
    private C1939o f6899r = new C1940p(this);

    /* renamed from: s */
    private C1939o f6900s = new C1941q(this);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6970a(Wire wire) {
        Intent intent = new Intent(GoDoughApp.getApp(), WireDetailFragmentActivity.class);
        intent.putExtra(WireDetailsFragment.EXTRA_WIRE, wire);
        int i = 0;
        if (wire.getStatus().equals(Wire.STATUS_NEED_APPROVAL)) {
            i = 1;
        }
        startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentByTag(WiresFragment.TAG + "-READY");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2) {
            String str = WiresFragment.TAG + "-READY";
            if (i == 1) {
                str = WiresFragment.TAG + "-APPROVE";
            } else {
                getSupportFragmentManager().findFragmentByTag(WiresFragment.TAG + "-APPROVE").onActivityResult(i, i2, intent);
            }
            getSupportFragmentManager().findFragmentByTag(str).onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.wires_tabbed_fragment_activity);
        this.f6895n = (ViewFlipper) findViewById(C1494ai.layout);
        this.f6895n.setDisplayedChild(0);
        this.f6894m = getSupportActionBar();
        this.f6894m.setHomeButtonEnabled(true);
        this.f6894m.setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getWires().getText());
        TabLayout tabLayout = (TabLayout) findViewById(C1494ai.tablayout_wires);
        tabLayout.setTabGravity(0);
        tabLayout.setTabMode(1);
        this.f6896o = tabLayout.mo147a().mo204a((CharSequence) getString(C1506am.tab_ready));
        this.f6897p = tabLayout.mo147a().mo204a((CharSequence) getString(C1506am.tab_approve));
        tabLayout.mo150a(this.f6896o);
        tabLayout.mo150a(this.f6897p);
        tabLayout.setOnTabSelectedListener(this);
        if (bundle != null) {
            this.f6898q = bundle.getInt("GD_OUT_TAB_INDEX");
            this.f6896o.mo204a((CharSequence) bundle.getString("OUT_READY_TAB"));
            this.f6897p.mo204a((CharSequence) bundle.getString("OUT_APPROVE_TAB"));
            ((WiresFragment) getSupportFragmentManager().findFragmentByTag(WiresFragment.TAG + "-READY")).setWireListener(this.f6899r);
            ((WiresFragment) getSupportFragmentManager().findFragmentByTag(WiresFragment.TAG + "-APPROVE")).setWireListener(this.f6900s);
        } else {
            WiresFragment newInstance = WiresFragment.newInstance((String) null);
            newInstance.setWireListener(this.f6899r);
            getSupportFragmentManager().beginTransaction().add(C1494ai.tab_ready, newInstance, WiresFragment.TAG + "-READY").commit();
            WiresFragment newInstance2 = WiresFragment.newInstance(Wire.STATUS_NEED_APPROVAL);
            newInstance2.setWireListener(this.f6900s);
            getSupportFragmentManager().beginTransaction().add(C1494ai.tab_approve, newInstance2, WiresFragment.TAG + "-APPROVE").commit();
        }
        tabLayout.mo148a(this.f6898q).mo210e();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("GD_OUT_TAB_INDEX", this.f6898q);
        bundle.putString("OUT_READY_TAB", this.f6896o.mo209d().toString());
        bundle.putString("OUT_APPROVE_TAB", this.f6897p.mo209d().toString());
    }

    public void onTabReselected(C0022an anVar) {
    }

    public void onTabSelected(C0022an anVar) {
        this.f6898q = anVar.mo208c();
        this.f6895n.setDisplayedChild(anVar.mo208c());
    }

    public void onTabUnselected(C0022an anVar) {
    }
}
