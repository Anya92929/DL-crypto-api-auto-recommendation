package android.support.p009v4.p010a;

import android.content.Context;
import android.os.Process;
import android.support.p009v4.app.AppOpsManagerCompat;

/* renamed from: android.support.v4.a.s */
public final class C0053s {
    /* renamed from: a */
    public static int m181a(Context context, String str) {
        return m182a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    /* renamed from: a */
    public static int m182a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return AppOpsManagerCompat.noteProxyOp(context, permissionToOp, str2) != 0 ? -2 : 0;
    }
}
