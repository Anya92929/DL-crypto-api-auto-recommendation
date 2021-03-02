package com.appbrain;

import android.content.BroadcastReceiver;

public class ReferrerReceiver extends BroadcastReceiver {
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            java.lang.String r0 = "referrer"
            java.lang.String r0 = r8.getStringExtra(r0)     // Catch:{ all -> 0x012a }
            if (r0 != 0) goto L_0x0089
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Throwable -> 0x01ad }
            r1.<init>()     // Catch:{ Throwable -> 0x01ad }
            android.content.pm.PackageManager r0 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0061 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.Class<com.appbrain.ReferrerReceiver> r3 = com.appbrain.ReferrerReceiver.class
            r2.<init>(r7, r3)     // Catch:{ NameNotFoundException -> 0x0061 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r2 = r0.getReceiverInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x0061 }
            if (r2 == 0) goto L_0x0038
            android.os.Bundle r0 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0061 }
            if (r0 == 0) goto L_0x0038
            android.os.Bundle r0 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0061 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0061 }
            if (r0 == 0) goto L_0x0038
            android.os.Bundle r0 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0061 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0061 }
            int r0 = r0.size()     // Catch:{ NameNotFoundException -> 0x0061 }
            if (r0 != 0) goto L_0x0039
        L_0x0038:
            return
        L_0x0039:
            android.os.Bundle r0 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0061 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0061 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ NameNotFoundException -> 0x0061 }
        L_0x0043:
            boolean r0 = r3.hasNext()     // Catch:{ NameNotFoundException -> 0x0061 }
            if (r0 == 0) goto L_0x0065
            java.lang.Object r0 = r3.next()     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r4 = "forward."
            boolean r4 = r0.startsWith(r4)     // Catch:{ NameNotFoundException -> 0x0061 }
            if (r4 == 0) goto L_0x0043
            android.os.Bundle r4 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ NameNotFoundException -> 0x0061 }
            r1.add(r0)     // Catch:{ NameNotFoundException -> 0x0061 }
            goto L_0x0043
        L_0x0061:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Throwable -> 0x01ad }
        L_0x0065:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Throwable -> 0x01ad }
        L_0x0069:
            boolean r0 = r1.hasNext()     // Catch:{ Throwable -> 0x01ad }
            if (r0 == 0) goto L_0x0038
            java.lang.Object r0 = r1.next()     // Catch:{ Throwable -> 0x01ad }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Throwable -> 0x01ad }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x01c8, InstantiationException -> 0x01c5, IllegalAccessException -> 0x01c2 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ ClassNotFoundException -> 0x01c8, InstantiationException -> 0x01c5, IllegalAccessException -> 0x01c2 }
            boolean r2 = r0 instanceof android.content.BroadcastReceiver     // Catch:{ ClassNotFoundException -> 0x01c8, InstantiationException -> 0x01c5, IllegalAccessException -> 0x01c2 }
            if (r2 == 0) goto L_0x0069
            android.content.BroadcastReceiver r0 = (android.content.BroadcastReceiver) r0     // Catch:{ Throwable -> 0x0087 }
            r0.onReceive(r7, r8)     // Catch:{ Throwable -> 0x0087 }
            goto L_0x0069
        L_0x0087:
            r0 = move-exception
            goto L_0x0069
        L_0x0089:
            com.appbrain.a.fg r1 = com.appbrain.p032a.C0926fg.m3925a()     // Catch:{ all -> 0x012a }
            r2 = 0
            r3 = 0
            r1.mo3817a(r7, r2, r3)     // Catch:{ all -> 0x012a }
            com.appbrain.a.fm r1 = com.appbrain.p032a.C0932fm.m3968a()     // Catch:{ all -> 0x012a }
            java.lang.String r1 = r1.mo3845d()     // Catch:{ all -> 0x012a }
            if (r1 != 0) goto L_0x00aa
            com.appbrain.a.fm r1 = com.appbrain.p032a.C0932fm.m3968a()     // Catch:{ all -> 0x012a }
            r1.mo3842a((java.lang.String) r0)     // Catch:{ all -> 0x012a }
            com.appbrain.a.de r0 = com.appbrain.p032a.C0870de.m3790a((android.content.Context) r7)     // Catch:{ all -> 0x012a }
            r0.mo3747c()     // Catch:{ all -> 0x012a }
        L_0x00aa:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Throwable -> 0x01ad }
            r1.<init>()     // Catch:{ Throwable -> 0x01ad }
            android.content.pm.PackageManager r0 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0102 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0102 }
            java.lang.Class<com.appbrain.ReferrerReceiver> r3 = com.appbrain.ReferrerReceiver.class
            r2.<init>(r7, r3)     // Catch:{ NameNotFoundException -> 0x0102 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r2 = r0.getReceiverInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x0102 }
            if (r2 == 0) goto L_0x0038
            android.os.Bundle r0 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0102 }
            if (r0 == 0) goto L_0x0038
            android.os.Bundle r0 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0102 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0102 }
            if (r0 == 0) goto L_0x0038
            android.os.Bundle r0 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0102 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0102 }
            int r0 = r0.size()     // Catch:{ NameNotFoundException -> 0x0102 }
            if (r0 == 0) goto L_0x0038
            android.os.Bundle r0 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0102 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0102 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ NameNotFoundException -> 0x0102 }
        L_0x00e4:
            boolean r0 = r3.hasNext()     // Catch:{ NameNotFoundException -> 0x0102 }
            if (r0 == 0) goto L_0x0106
            java.lang.Object r0 = r3.next()     // Catch:{ NameNotFoundException -> 0x0102 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NameNotFoundException -> 0x0102 }
            java.lang.String r4 = "forward."
            boolean r4 = r0.startsWith(r4)     // Catch:{ NameNotFoundException -> 0x0102 }
            if (r4 == 0) goto L_0x00e4
            android.os.Bundle r4 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0102 }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ NameNotFoundException -> 0x0102 }
            r1.add(r0)     // Catch:{ NameNotFoundException -> 0x0102 }
            goto L_0x00e4
        L_0x0102:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Throwable -> 0x01ad }
        L_0x0106:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Throwable -> 0x01ad }
        L_0x010a:
            boolean r0 = r1.hasNext()     // Catch:{ Throwable -> 0x01ad }
            if (r0 == 0) goto L_0x0038
            java.lang.Object r0 = r1.next()     // Catch:{ Throwable -> 0x01ad }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Throwable -> 0x01ad }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x01bf, InstantiationException -> 0x01bc, IllegalAccessException -> 0x01b9 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ ClassNotFoundException -> 0x01bf, InstantiationException -> 0x01bc, IllegalAccessException -> 0x01b9 }
            boolean r2 = r0 instanceof android.content.BroadcastReceiver     // Catch:{ ClassNotFoundException -> 0x01bf, InstantiationException -> 0x01bc, IllegalAccessException -> 0x01b9 }
            if (r2 == 0) goto L_0x010a
            android.content.BroadcastReceiver r0 = (android.content.BroadcastReceiver) r0     // Catch:{ Throwable -> 0x0128 }
            r0.onReceive(r7, r8)     // Catch:{ Throwable -> 0x0128 }
            goto L_0x010a
        L_0x0128:
            r0 = move-exception
            goto L_0x010a
        L_0x012a:
            r0 = move-exception
            r1 = r0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Throwable -> 0x01ad }
            r2.<init>()     // Catch:{ Throwable -> 0x01ad }
            android.content.pm.PackageManager r0 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0184 }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0184 }
            java.lang.Class<com.appbrain.ReferrerReceiver> r4 = com.appbrain.ReferrerReceiver.class
            r3.<init>(r7, r4)     // Catch:{ NameNotFoundException -> 0x0184 }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r3 = r0.getReceiverInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x0184 }
            if (r3 == 0) goto L_0x0038
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0184 }
            if (r0 == 0) goto L_0x0038
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0184 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0184 }
            if (r0 == 0) goto L_0x0038
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0184 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0184 }
            int r0 = r0.size()     // Catch:{ NameNotFoundException -> 0x0184 }
            if (r0 == 0) goto L_0x0038
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0184 }
            java.util.Set r0 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0184 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ NameNotFoundException -> 0x0184 }
        L_0x0166:
            boolean r0 = r4.hasNext()     // Catch:{ NameNotFoundException -> 0x0184 }
            if (r0 == 0) goto L_0x0188
            java.lang.Object r0 = r4.next()     // Catch:{ NameNotFoundException -> 0x0184 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NameNotFoundException -> 0x0184 }
            java.lang.String r5 = "forward."
            boolean r5 = r0.startsWith(r5)     // Catch:{ NameNotFoundException -> 0x0184 }
            if (r5 == 0) goto L_0x0166
            android.os.Bundle r5 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0184 }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ NameNotFoundException -> 0x0184 }
            r2.add(r0)     // Catch:{ NameNotFoundException -> 0x0184 }
            goto L_0x0166
        L_0x0184:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Throwable -> 0x01ad }
        L_0x0188:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Throwable -> 0x01ad }
        L_0x018c:
            boolean r0 = r2.hasNext()     // Catch:{ Throwable -> 0x01ad }
            if (r0 == 0) goto L_0x01ac
            java.lang.Object r0 = r2.next()     // Catch:{ Throwable -> 0x01ad }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Throwable -> 0x01ad }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x01b7, InstantiationException -> 0x01b5, IllegalAccessException -> 0x01b3 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ ClassNotFoundException -> 0x01b7, InstantiationException -> 0x01b5, IllegalAccessException -> 0x01b3 }
            boolean r3 = r0 instanceof android.content.BroadcastReceiver     // Catch:{ ClassNotFoundException -> 0x01b7, InstantiationException -> 0x01b5, IllegalAccessException -> 0x01b3 }
            if (r3 == 0) goto L_0x018c
            android.content.BroadcastReceiver r0 = (android.content.BroadcastReceiver) r0     // Catch:{ Throwable -> 0x01aa }
            r0.onReceive(r7, r8)     // Catch:{ Throwable -> 0x01aa }
            goto L_0x018c
        L_0x01aa:
            r0 = move-exception
            goto L_0x018c
        L_0x01ac:
            throw r1     // Catch:{ Throwable -> 0x01ad }
        L_0x01ad:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0038
        L_0x01b3:
            r0 = move-exception
            goto L_0x018c
        L_0x01b5:
            r0 = move-exception
            goto L_0x018c
        L_0x01b7:
            r0 = move-exception
            goto L_0x018c
        L_0x01b9:
            r0 = move-exception
            goto L_0x010a
        L_0x01bc:
            r0 = move-exception
            goto L_0x010a
        L_0x01bf:
            r0 = move-exception
            goto L_0x010a
        L_0x01c2:
            r0 = move-exception
            goto L_0x0069
        L_0x01c5:
            r0 = move-exception
            goto L_0x0069
        L_0x01c8:
            r0 = move-exception
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.ReferrerReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
