package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.google.android.gms.common.internal.C0348n;

@C1130ez
/* renamed from: com.google.android.gms.internal.bl */
public class C0950bl {
    private final Context mContext;

    public C0950bl(Context context) {
        C0348n.m857b(context, (Object) "Context can not be null");
        this.mContext = context;
    }

    /* renamed from: bn */
    public static boolean m3987bn() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: a */
    public boolean mo8128a(Intent intent) {
        C0348n.m857b(intent, (Object) "Intent can not be null");
        return !this.mContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    /* renamed from: bj */
    public boolean mo8129bj() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return mo8128a(intent);
    }

    /* renamed from: bk */
    public boolean mo8130bk() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return mo8128a(intent);
    }

    /* renamed from: bl */
    public boolean mo8131bl() {
        return m3987bn() && this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* renamed from: bm */
    public boolean mo8132bm() {
        return false;
    }

    /* renamed from: bo */
    public boolean mo8133bo() {
        return Build.VERSION.SDK_INT >= 14 && mo8128a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
