package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C1204R;

public class zzai {

    /* renamed from: a */
    private final Resources f4519a;

    /* renamed from: b */
    private final String f4520b = this.f4519a.getResourcePackageName(C1204R.string.common_google_play_services_unknown_issue);

    public zzai(Context context) {
        zzab.zzy(context);
        this.f4519a = context.getResources();
    }

    public String getString(String str) {
        int identifier = this.f4519a.getIdentifier(str, "string", this.f4520b);
        if (identifier == 0) {
            return null;
        }
        return this.f4519a.getString(identifier);
    }
}
