package p000;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import p006nl.volkerinfradesign.checkandroid.AppState;

/* renamed from: ip */
final class C1282ip implements Comparable<C1282ip> {

    /* renamed from: a */
    final String f4491a;

    C1282ip(String str) {
        this.f4491a = str;
    }

    public C1282ip(Context context) {
        PackageInfo packageInfo;
        String str = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            AppState.getInstance().getModel().getLogger().logError("Error in fetching current version", e);
            packageInfo = null;
        }
        this.f4491a = packageInfo != null ? packageInfo.versionName : str;
    }

    /* renamed from: a */
    public int compareTo(C1282ip ipVar) {
        int i;
        int i2;
        if (ipVar == null) {
            return 1;
        }
        if (this.f4491a == null) {
            if (ipVar.f4491a != null) {
                return -1;
            }
            return 0;
        } else if (ipVar.f4491a == null) {
            return 1;
        } else {
            String[] split = this.f4491a.split("\\.");
            String[] split2 = ipVar.f4491a.split("\\.");
            int max = Math.max(split.length, split2.length);
            for (int i3 = 0; i3 < max; i3++) {
                if (i3 < split.length) {
                    i = Integer.parseInt(split[i3]);
                } else {
                    i = 0;
                }
                if (i3 < split2.length) {
                    i2 = Integer.parseInt(split2[i3]);
                } else {
                    i2 = 0;
                }
                if (i < i2) {
                    return -1;
                }
                if (i > i2) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1282ip) || compareTo((C1282ip) obj) != 0) {
            return false;
        }
        return true;
    }
}
