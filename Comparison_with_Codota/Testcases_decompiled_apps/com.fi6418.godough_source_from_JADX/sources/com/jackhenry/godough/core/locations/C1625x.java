package com.jackhenry.godough.core.locations;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.locations.x */
class C1625x implements C1593j {

    /* renamed from: a */
    final /* synthetic */ LocationsFragmentActivity f6264a;

    C1625x(LocationsFragmentActivity locationsFragmentActivity) {
        this.f6264a = locationsFragmentActivity;
    }

    public void run() {
        new Handler().post(new C1626y(this));
    }
}
