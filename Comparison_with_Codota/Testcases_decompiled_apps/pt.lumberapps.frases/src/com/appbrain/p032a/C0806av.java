package com.appbrain.p032a;

import android.view.View;

/* renamed from: com.appbrain.a.av */
final class C0806av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0979z f2120a;

    /* renamed from: b */
    final /* synthetic */ C0805au f2121b;

    C0806av(C0805au auVar, C0979z zVar) {
        this.f2121b = auVar;
        this.f2120a = zVar;
    }

    public final void onClick(View view) {
        if (this.f2121b.f2119a.f2118f != null) {
            this.f2121b.f2119a.f2118f.run();
        }
        this.f2120a.f2591a.f2552d.onClick(view);
    }
}
