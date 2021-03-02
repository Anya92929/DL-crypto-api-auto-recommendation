package com.google.android.gms.internal;

import android.text.TextUtils;

@zzin
public class zzdf {
    public zzde zza(zzdd zzdd) {
        if (zzdd == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!zzdd.mo8267a()) {
            zzkd.m7303v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (zzdd.mo8269c() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzdd.mo8270d())) {
            return new zzde(zzdd.mo8269c(), zzdd.mo8270d(), zzdd.mo8268b(), zzdd.mo8271e());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
