package p052pt.lumberapps.lumbliv;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.p028a.C0765a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: pt.lumberapps.lumbliv.w */
public class C2102w {

    /* renamed from: a */
    private Context f7880a;

    /* renamed from: a */
    public void mo10304a(Activity activity, FrameLayout frameLayout, ArrayList arrayList, C0765a aVar) {
        this.f7880a = aVar.mo3477c();
        LayoutInflater layoutInflater = (LayoutInflater) this.f7880a.getSystemService("layout_inflater");
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) layoutInflater.inflate(C2100u.ads_layout, (ViewGroup) null);
        frameLayout.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) horizontalScrollView.findViewById(C2099t.ads_layout_lin);
        frameLayout.addView(horizontalScrollView);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2092m mVar = (C2092m) it.next();
            LinearLayout linearLayout2 = (LinearLayout) layoutInflater.inflate(C2100u.ads_layout_item, (ViewGroup) null);
            ((C0765a) aVar.mo3462a((View) (ImageView) linearLayout2.findViewById(C2099t.ads_lay_iv))).mo3470a(mVar.f7867d, false, true);
            ((TextView) linearLayout2.findViewById(C2099t.ads_lay_tv)).setText(mVar.f7864a);
            ((RatingBar) linearLayout2.findViewById(C2099t.ads_lay_rb)).setRating(mVar.f7868e);
            linearLayout2.setClickable(true);
            linearLayout2.setOnClickListener(new C2103x(this, activity, mVar));
            linearLayout.addView(linearLayout2);
        }
        C2101v.f7877a.mo10294a("Scrloa ads size: " + linearLayout.getChildCount());
    }
}
