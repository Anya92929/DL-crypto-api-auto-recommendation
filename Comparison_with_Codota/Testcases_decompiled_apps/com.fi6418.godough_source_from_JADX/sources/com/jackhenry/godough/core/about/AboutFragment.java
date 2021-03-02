package com.jackhenry.godough.core.about;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import java.util.ArrayList;

public class AboutFragment extends C1802r {

    /* renamed from: a */
    ArrayList<C1413c> f5796a = new ArrayList<>();

    /* renamed from: b */
    AdapterView.OnItemClickListener f5797b = new C1412b(this);

    /* renamed from: c */
    private ListView f5798c;

    /* renamed from: d */
    private C1411a f5799d;

    /* renamed from: n */
    private void m5764n() {
        this.f5796a.clear();
        C1413c cVar = new C1413c();
        cVar.setText(GoDoughApp.getApp().getString(C1506am.licenses));
        cVar.mo9542a(LicensesFragmentActivity.class);
        this.f5796a.add(cVar);
        this.f5799d = new C1411a(GoDoughApp.getApp(), 0, this.f5796a);
        this.f5798c.setAdapter(this.f5799d);
        this.f5798c.setOnItemClickListener(this.f5797b);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C1496ak.about_fragment, viewGroup, false);
        TextView textView = (TextView) relativeLayout.findViewById(C1494ai.about_fi_name);
        TextView textView2 = (TextView) relativeLayout.findViewById(C1494ai.about_version);
        ((TextView) relativeLayout.findViewById(C1494ai.about_app_name)).setText(GoDoughApp.getApp().getString(C1506am.app_name));
        try {
            textView2.setText(GoDoughApp.getApp().getString(C1506am.lbl_version) + " " + GoDoughApp.getApp().getPackageManager().getPackageInfo(GoDoughApp.getApp().getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
        }
        this.f5798c = (ListView) relativeLayout.findViewById(C1494ai.list);
        m5764n();
        return relativeLayout;
    }
}
