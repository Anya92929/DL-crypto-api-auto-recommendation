package com.google.android.gms.fitness;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.C0355c;
import com.google.android.gms.fitness.data.Session;

public class ViewSessionIntentBuilder {

    /* renamed from: Sj */
    private String f1280Sj;

    /* renamed from: Sk */
    private Session f1281Sk;

    /* renamed from: Sl */
    private boolean f1282Sl = false;
    private final Context mContext;

    public ViewSessionIntentBuilder(Context context) {
        this.mContext = context;
    }

    /* renamed from: i */
    private Intent m1761i(Intent intent) {
        boolean z = false;
        if (this.f1280Sj == null) {
            return intent;
        }
        Intent intent2 = new Intent(intent).setPackage(this.f1280Sj);
        if (this.mContext.getPackageManager().resolveActivity(intent2, 0) != null) {
            z = true;
        }
        return z ? intent2 : intent;
    }

    public Intent build() {
        C0348n.m852a(this.f1281Sk != null, "Session must be set");
        Intent intent = new Intent(FitnessIntents.ACTION_VIEW);
        intent.setType(FitnessIntents.getSessionMimeType(this.f1281Sk.getActivity()));
        C0355c.m944a(this.f1281Sk, intent, FitnessIntents.EXTRA_SESSION);
        if (!this.f1282Sl) {
            this.f1280Sj = this.f1281Sk.getAppPackageName();
        }
        return m1761i(intent);
    }

    public ViewSessionIntentBuilder setPreferredApplication(String packageName) {
        this.f1280Sj = packageName;
        this.f1282Sl = true;
        return this;
    }

    public ViewSessionIntentBuilder setSession(Session session) {
        this.f1281Sk = session;
        return this;
    }
}
