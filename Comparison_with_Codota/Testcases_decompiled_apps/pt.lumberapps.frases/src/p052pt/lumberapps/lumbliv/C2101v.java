package p052pt.lumberapps.lumbliv;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.gms.ads.AdView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.p028a.C0765a;
import java.util.ArrayList;

/* renamed from: pt.lumberapps.lumbliv.v */
public class C2101v extends SlidingMenu implements C2095p {

    /* renamed from: a */
    public static C2095p f7877a;

    /* renamed from: b */
    Activity f7878b;

    /* renamed from: c */
    private AdView f7879c;

    /* renamed from: a */
    public void mo9920a() {
        if (this.f7879c != null) {
            this.f7879c.pause();
        }
        super.mo9920a();
    }

    /* renamed from: a */
    public void mo10294a(String str) {
        if (this.f7878b != null) {
        }
    }

    /* renamed from: a */
    public void mo10295a(ArrayList arrayList, C0765a aVar) {
        FrameLayout frameLayout = (FrameLayout) this.f7878b.findViewById(C2099t.frame_ads);
        frameLayout.setVisibility(0);
        new C2102w().mo10304a(this.f7878b, frameLayout, arrayList, aVar);
    }

    public void addViewToTopo(View view) {
        ((LinearLayout) this.f7878b.findViewById(C2099t.lin_banner)).addView(view);
    }
}
