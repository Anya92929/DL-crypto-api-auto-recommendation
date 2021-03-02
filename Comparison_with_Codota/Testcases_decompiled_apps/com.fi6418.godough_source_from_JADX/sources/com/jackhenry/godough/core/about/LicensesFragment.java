package com.jackhenry.godough.core.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import java.util.ArrayList;

public class LicensesFragment extends C1802r {

    /* renamed from: a */
    ArrayList<C1413c> f5802a = new ArrayList<>();

    /* renamed from: b */
    AdapterView.OnItemClickListener f5803b = new C1414d(this);

    /* renamed from: c */
    private ListView f5804c;

    /* renamed from: d */
    private C1411a f5805d;

    /* renamed from: n */
    private void m5767n() {
        this.f5802a.clear();
        C1413c cVar = new C1413c();
        cVar.setText(GoDoughApp.getApp().getString(C1506am.lbl_google_api_disclosure));
        cVar.mo9542a(PlayServicesDisclosuresFragmentActivity.class);
        this.f5802a.add(cVar);
        C1413c cVar2 = new C1413c();
        cVar2.setText(GoDoughApp.getApp().getString(C1506am.lbl_analytics_disclosure));
        cVar2.mo9542a(AnalyticsDisclosuresFragmentActivity.class);
        this.f5802a.add(cVar2);
        this.f5805d = new C1411a(GoDoughApp.getApp(), 0, this.f5802a);
        this.f5804c.setAdapter(this.f5805d);
        this.f5804c.setOnItemClickListener(this.f5803b);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C1496ak.licenses_fragment, viewGroup, false);
        this.f5804c = (ListView) relativeLayout.findViewById(C1494ai.list);
        m5767n();
        return relativeLayout;
    }
}
