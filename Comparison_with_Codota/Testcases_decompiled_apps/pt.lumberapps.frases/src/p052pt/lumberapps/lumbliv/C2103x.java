package p052pt.lumberapps.lumbliv;

import android.app.Activity;
import android.view.View;
import com.appbrain.C1121k;

/* renamed from: pt.lumberapps.lumbliv.x */
class C2103x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f7881a;

    /* renamed from: b */
    final /* synthetic */ C2092m f7882b;

    /* renamed from: c */
    final /* synthetic */ C2102w f7883c;

    C2103x(C2102w wVar, Activity activity, C2092m mVar) {
        this.f7883c = wVar;
        this.f7881a = activity;
        this.f7882b = mVar;
    }

    public void onClick(View view) {
        this.f7881a.startActivity(C2104y.m8436a(this.f7881a, this.f7882b.f7866c));
        C1121k.m5211c().mo3770a(this.f7882b.f7866c, 1);
    }
}
