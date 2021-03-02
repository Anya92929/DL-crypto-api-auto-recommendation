package com.jackhenry.godough.core.locations;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.locations.g */
class C1608g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ LocationDetailFragment f6242a;

    C1608g(LocationDetailFragment locationDetailFragment) {
        this.f6242a = locationDetailFragment;
    }

    public void onClick(View view) {
        boolean unused = this.f6242a.f6193au = !this.f6242a.f6193au;
        this.f6242a.m6242p();
    }
}
