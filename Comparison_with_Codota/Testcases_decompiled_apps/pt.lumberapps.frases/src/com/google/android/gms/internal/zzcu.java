package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.google.android.gms.common.internal.zzab;

@zzin
public class zzcu {

    /* renamed from: a */
    private final Context f6085a;

    public zzcu(Context context) {
        zzab.zzb((Object) context, (Object) "Context can not be null");
        this.f6085a = context;
    }

    public static boolean zzjt() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean zza(Intent intent) {
        zzab.zzb((Object) intent, (Object) "Intent can not be null");
        return !this.f6085a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean zzjp() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public boolean zzjq() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return zza(intent);
    }

    public boolean zzjr() {
        return zzjt() && this.f6085a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public boolean zzjs() {
        return true;
    }

    @TargetApi(14)
    public boolean zzju() {
        return Build.VERSION.SDK_INT >= 14 && zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
