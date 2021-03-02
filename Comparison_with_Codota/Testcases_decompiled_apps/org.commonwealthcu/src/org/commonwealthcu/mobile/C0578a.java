package org.commonwealthcu.mobile;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.view.ViewPager;
import android.support.p003v7.app.ActionBarActivity;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.Timer;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.a */
public class C0578a extends Fragment {

    /* renamed from: a */
    public Handler f687a = new C0610b(this);

    /* renamed from: b */
    private View f688b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MobileBankingApp f689c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ActionBarActivity f690d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewPager f691e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Timer f692f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f693g;

    /* renamed from: a */
    public final void mo5481a() {
        this.f691e.setAdapter(new C0624c(this, (byte) 0));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        Double valueOf;
        View inflate = layoutInflater.inflate(C0137R.layout.adview, viewGroup, false);
        this.f688b = inflate;
        C0250b.m92a((Context) getActivity(), this.f688b);
        this.f689c = (MobileBankingApp) getActivity().getApplicationContext();
        this.f690d = (ActionBarActivity) getActivity();
        Iterator<String> keys = this.f689c.mo5466c().keys();
        int i2 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.indexOf("IMG") >= 0 && next.length() <= 5) {
                i2++;
            }
            i2 = i2;
        }
        this.f693g = i2;
        C0624c cVar = new C0624c(this, (byte) 0);
        ViewPager viewPager = (ViewPager) inflate.findViewById(C0137R.C0139id.adViewPager);
        viewPager.setAdapter(cVar);
        viewPager.setCurrentItem(0);
        this.f691e = viewPager;
        this.f692f = new Timer();
        C0627f fVar = new C0627f(this);
        if (this.f689c.mo5460a("AdTimeInterval") != null) {
            try {
                valueOf = Double.valueOf(Double.parseDouble(this.f689c.mo5460a("AdTimeInterval")));
            } catch (Exception e) {
                valueOf = Double.valueOf(6.0d);
            }
            i = (int) (valueOf.doubleValue() * 1000.0d);
        } else {
            i = 6000;
        }
        this.f692f.scheduleAtFixedRate(fVar, (long) i, (long) i);
        return inflate;
    }

    public void onStop() {
        super.onStop();
        this.f692f.cancel();
    }
}
