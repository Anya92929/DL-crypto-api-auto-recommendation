package p052pt.lumberapps.lumbliv;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.appbrain.AppBrainBanner;
import com.p028a.C0765a;
import java.util.ArrayList;

/* renamed from: pt.lumberapps.lumbliv.k */
public class C2090k implements C2095p {

    /* renamed from: a */
    Activity f7859a;

    /* renamed from: b */
    Integer f7860b;

    public C2090k(Activity activity, AdapterView.OnItemClickListener onItemClickListener, ArrayAdapter arrayAdapter, String[] strArr, int i, int i2, boolean z) {
        this.f7859a = activity;
        C2101v.f7877a = this;
        this.f7860b = Integer.valueOf(i2);
        ((RelativeLayout) activity.findViewById(C2099t.linalayamenu)).setBackgroundColor(i);
        ListView listView = (ListView) activity.findViewById(C2099t.listViewMenu);
        if (arrayAdapter != null) {
            listView.setAdapter(arrayAdapter);
        } else {
            listView.setAdapter(new C2091l(this, activity, 0, strArr));
        }
        listView.setOnItemClickListener(onItemClickListener);
    }

    /* renamed from: a */
    public void mo10292a() {
        AppBrainBanner appBrainBanner = new AppBrainBanner(this.f7859a.getBaseContext());
        ((LinearLayout) this.f7859a.findViewById(C2099t.lin_banner)).addView(appBrainBanner, 0);
        appBrainBanner.mo3599b();
    }

    /* renamed from: a */
    public void mo10293a(C0765a aVar, String str) {
        C2093n nVar = new C2093n(aVar);
        nVar.f7869a = str;
        nVar.mo10300a("https://dl.dropboxusercontent.com/u/30859657/MAPPS/json_apps.json");
    }

    /* renamed from: a */
    public void mo10294a(String str) {
        if (this.f7859a != null) {
        }
    }

    /* renamed from: a */
    public void mo10295a(ArrayList arrayList, C0765a aVar) {
        FrameLayout frameLayout = (FrameLayout) this.f7859a.findViewById(C2099t.frame_ads);
        frameLayout.setVisibility(0);
        new C2102w().mo10304a(this.f7859a, frameLayout, arrayList, aVar);
    }

    public void addViewToTopo(View view) {
        ((LinearLayout) this.f7859a.findViewById(C2099t.lin_banner)).addView(view);
    }
}
