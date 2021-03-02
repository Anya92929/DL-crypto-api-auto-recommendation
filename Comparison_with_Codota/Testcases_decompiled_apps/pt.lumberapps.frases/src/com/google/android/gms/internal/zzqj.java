package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzqj {

    /* renamed from: d */
    protected final zzqk f6908d;

    protected zzqj(zzqk zzqk) {
        this.f6908d = zzqk;
    }

    /* renamed from: a */
    protected static zzqk m7513a(Activity activity) {
        return m7514a(new zzqi(activity));
    }

    /* renamed from: a */
    protected static zzqk m7514a(zzqi zzqi) {
        return zzqi.zzaqq() ? zzqv.zza(zzqi.zzaqs()) : zzql.zzt(zzqi.zzaqr());
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        return this.f6908d.zzaqt();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
