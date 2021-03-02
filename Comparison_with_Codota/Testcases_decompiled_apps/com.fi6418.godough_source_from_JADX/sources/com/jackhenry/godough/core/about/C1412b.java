package com.jackhenry.godough.core.about;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.GoDoughApp;

/* renamed from: com.jackhenry.godough.core.about.b */
class C1412b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutFragment f5811a;

    C1412b(AboutFragment aboutFragment) {
        this.f5811a = aboutFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5811a.startActivity(new Intent(GoDoughApp.getApp(), this.f5811a.f5796a.get(i).mo9541a()));
    }
}
