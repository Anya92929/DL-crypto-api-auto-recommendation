package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.google.android.gms.common.zzc;

/* renamed from: hd */
public abstract class C1192hd extends BroadcastReceiver {

    /* renamed from: c */
    protected Context f4253c;

    @Nullable
    /* renamed from: a */
    public static <T extends C1192hd> T m5260a(Context context, T t) {
        return m5261a(context, t, zzc.zzoK());
    }

    @Nullable
    /* renamed from: a */
    public static <T extends C1192hd> T m5261a(Context context, T t, zzc zzc) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(t, intentFilter);
        t.f4253c = context;
        if (zzc.zzi(context, "com.google.android.gms")) {
            return t;
        }
        t.mo5134a();
        t.mo8270b();
        return null;
    }

    /* renamed from: a */
    public abstract void mo5134a();

    /* renamed from: b */
    public synchronized void mo8270b() {
        if (this.f4253c != null) {
            this.f4253c.unregisterReceiver(this);
        }
        this.f4253c = null;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(str)) {
            mo5134a();
            mo8270b();
        }
    }
}
