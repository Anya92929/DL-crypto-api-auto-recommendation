package com.google.android.gms.internal;

import android.app.Activity;
import android.support.p009v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzs;

public class zzqi {

    /* renamed from: a */
    private final Object f6907a;

    public zzqi(Activity activity) {
        zzab.zzb((Object) activity, (Object) "Activity must not be null");
        zzab.zzb(zzs.zzavn() || (activity instanceof FragmentActivity), (Object) "This Activity is not supported before platform version 11 (3.0 Honeycomb). Please use FragmentActivity instead.");
        this.f6907a = activity;
    }

    public boolean zzaqq() {
        return this.f6907a instanceof FragmentActivity;
    }

    public Activity zzaqr() {
        return (Activity) this.f6907a;
    }

    public FragmentActivity zzaqs() {
        return (FragmentActivity) this.f6907a;
    }
}
