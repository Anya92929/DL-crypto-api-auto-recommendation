package com.jackhenry.godough.core.p2p;

import android.content.Intent;
import android.view.View;
import com.jackhenry.godough.core.GoDoughApp;

/* renamed from: com.jackhenry.godough.core.p2p.z */
class C1797z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6603a;

    C1797z(P2PFragment p2PFragment) {
        this.f6603a = p2PFragment;
    }

    public void onClick(View view) {
        this.f6603a.startActivityForResult(new Intent(GoDoughApp.getApp(), P2PAddPersonFragmentActivity.class), 2);
        this.f6603a.f6544aw.dismiss();
    }
}
