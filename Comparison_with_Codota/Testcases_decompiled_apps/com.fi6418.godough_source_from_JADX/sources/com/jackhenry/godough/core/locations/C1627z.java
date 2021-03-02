package com.jackhenry.godough.core.locations;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.locations.z */
class C1627z implements C1578g {

    /* renamed from: a */
    final /* synthetic */ LocationsFragmentActivity f6266a;

    C1627z(LocationsFragmentActivity locationsFragmentActivity) {
        this.f6266a = locationsFragmentActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -2:
                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                if (Build.VERSION.SDK_INT < 14) {
                    intent.setComponent(new ComponentName("com.android.phone", "com.android.phone.Settings"));
                }
                if (!AbstractActivity.isCallable(this.f6266a.f6225p, intent)) {
                    intent.setAction("android.settings.SETTINGS");
                }
                this.f6266a.startActivityForResult(intent, LocationsFragmentActivity.ACTIVITY_GPS_REQ);
                return;
            default:
                return;
        }
    }
}
