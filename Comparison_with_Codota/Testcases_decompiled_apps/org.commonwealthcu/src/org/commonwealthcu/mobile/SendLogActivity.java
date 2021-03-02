package org.commonwealthcu.mobile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.p003v7.appcompat.C0137R;
import android.view.View;

public class SendLogActivity extends Activity {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e8 A[SYNTHETIC, Splitter:B:25:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ed A[SYNTHETIC, Splitter:B:28:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m1272a() {
        /*
            r8 = this;
            r1 = 0
            android.content.pm.PackageManager r0 = r8.getPackageManager()
            java.lang.String r2 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x00f1 }
            r3 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x00f1 }
        L_0x000e:
            java.lang.String r2 = android.os.Build.MODEL
            java.lang.String r3 = android.os.Build.MANUFACTURER
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x0031
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = android.os.Build.MANUFACTURER
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = " "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
        L_0x0031:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r3 = r3.append(r4)
            r4 = 47
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = "CrashLog.txt"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.io.File r6 = new java.io.File
            r6.<init>(r3)
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x010c }
            r5 = 15
            if (r4 > r5) goto L_0x00f5
            java.lang.String r4 = "logcat -d -v time MyApp:v dalvikvm:v System.err:v *:s"
        L_0x006c:
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x010c }
            java.lang.Process r4 = r5.exec(r4)     // Catch:{ IOException -> 0x010c }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x010c }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ IOException -> 0x010c }
            r5.<init>(r4)     // Catch:{ IOException -> 0x010c }
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ IOException -> 0x0110 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x0110 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r7 = "Android version: "
            r6.<init>(r7)     // Catch:{ IOException -> 0x00e3 }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x00e3 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r7 = "\n"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x00e3 }
            r4.write(r6)     // Catch:{ IOException -> 0x00e3 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r7 = "Device: "
            r6.<init>(r7)     // Catch:{ IOException -> 0x00e3 }
            java.lang.StringBuilder r2 = r6.append(r2)     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r6 = "\n"
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00e3 }
            r4.write(r2)     // Catch:{ IOException -> 0x00e3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r6 = "App version: "
            r2.<init>(r6)     // Catch:{ IOException -> 0x00e3 }
            if (r0 != 0) goto L_0x00f9
            java.lang.String r0 = "(null)"
        L_0x00bf:
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r2 = "\n"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00e3 }
            r4.write(r0)     // Catch:{ IOException -> 0x00e3 }
            r0 = 10000(0x2710, float:1.4013E-41)
            char[] r0 = new char[r0]     // Catch:{ IOException -> 0x00e3 }
        L_0x00d4:
            r2 = 0
            r6 = 10000(0x2710, float:1.4013E-41)
            int r2 = r5.read(r0, r2, r6)     // Catch:{ IOException -> 0x00e3 }
            r6 = -1
            if (r2 == r6) goto L_0x0100
            r6 = 0
            r4.write(r0, r6, r2)     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00d4
        L_0x00e3:
            r0 = move-exception
            r0 = r4
            r2 = r5
        L_0x00e6:
            if (r0 == 0) goto L_0x00eb
            r0.close()     // Catch:{ IOException -> 0x0108 }
        L_0x00eb:
            if (r2 == 0) goto L_0x00f0
            r2.close()     // Catch:{ IOException -> 0x010a }
        L_0x00f0:
            return r1
        L_0x00f1:
            r0 = move-exception
            r0 = r1
            goto L_0x000e
        L_0x00f5:
            java.lang.String r4 = "logcat -d -v time"
            goto L_0x006c
        L_0x00f9:
            int r0 = r0.versionCode     // Catch:{ IOException -> 0x00e3 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00bf
        L_0x0100:
            r5.close()     // Catch:{ IOException -> 0x00e3 }
            r4.close()     // Catch:{ IOException -> 0x00e3 }
            r1 = r3
            goto L_0x00f0
        L_0x0108:
            r0 = move-exception
            goto L_0x00eb
        L_0x010a:
            r0 = move-exception
            goto L_0x00f0
        L_0x010c:
            r0 = move-exception
            r0 = r1
            r2 = r1
            goto L_0x00e6
        L_0x0110:
            r0 = move-exception
            r0 = r1
            r2 = r5
            goto L_0x00e6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonwealthcu.mobile.SendLogActivity.m1272a():java.lang.String");
    }

    public void exitApp(View view) {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0137R.layout.send_log);
    }

    public void sendLogFile(View view) {
        String a = m1272a();
        if (a != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{"christopher.streett@aciworldwide.com"});
            intent.putExtra("android.intent.extra.SUBJECT", "ACI Webfederal Crash Log");
            intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + a));
            intent.putExtra("android.intent.extra.TEXT", "Log file attached.");
            startActivity(intent);
        }
    }
}
