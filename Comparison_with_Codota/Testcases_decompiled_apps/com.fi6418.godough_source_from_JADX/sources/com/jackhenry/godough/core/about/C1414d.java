package com.jackhenry.godough.core.about;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.GoDoughApp;

/* renamed from: com.jackhenry.godough.core.about.d */
class C1414d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ LicensesFragment f5813a;

    C1414d(LicensesFragment licensesFragment) {
        this.f5813a = licensesFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5813a.startActivity(new Intent(GoDoughApp.getApp(), this.f5813a.f5802a.get(i).mo9541a()));
    }
}
