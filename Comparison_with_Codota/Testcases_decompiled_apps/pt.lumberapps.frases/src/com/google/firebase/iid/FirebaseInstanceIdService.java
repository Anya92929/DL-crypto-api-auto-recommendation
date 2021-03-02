package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.firebase.C1975b;

public class FirebaseInstanceIdService extends C1981c {

    /* renamed from: c */
    private static BroadcastReceiver f7508c;

    /* renamed from: d */
    private static final Object f7509d = new Object();

    /* renamed from: e */
    private static boolean f7510e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f7511f = false;

    /* renamed from: a */
    private C1985g m8122a(String str) {
        if (str == null) {
            return C1985g.m8145a(this, (Bundle) null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return C1985g.m8145a(this, bundle);
    }

    /* renamed from: a */
    static void m8123a(Context context) {
        if (C1987i.m8156a(context) != null) {
            synchronized (f7509d) {
                if (!f7510e) {
                    context.sendBroadcast(m8131c(0));
                    f7510e = true;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r3.mo9862g().mo9886a() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        m8123a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r3.mo9860e() == null) goto L_0x001a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m8124a(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
            java.lang.Object r1 = f7509d
            monitor-enter(r1)
            boolean r0 = f7510e     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
        L_0x0008:
            return
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r3.mo9860e()
            if (r0 == 0) goto L_0x001a
            com.google.firebase.iid.h r0 = r3.mo9862g()
            java.lang.String r0 = r0.mo9886a()
            if (r0 == 0) goto L_0x0008
        L_0x001a:
            m8123a((android.content.Context) r2)
            goto L_0x0008
        L_0x001e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.m8124a(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    /* renamed from: a */
    private void m8125a(Intent intent, String str) {
        boolean c = m8133c((Context) this);
        int b = m8129b(intent, c);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(b).append("s").toString());
        synchronized (f7509d) {
            m8134d(b);
            f7510e = true;
        }
        if (!c) {
            if (this.f7511f) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (f7508c == null) {
                f7508c = new C1979a(this, b);
            }
            getApplicationContext().registerReceiver(f7508c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e A[Catch:{ IOException -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab A[SYNTHETIC, Splitter:B:51:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0071 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8126a(android.content.Intent r9, boolean r10) {
        /*
            r8 = this;
            r2 = 1
            r1 = 0
            java.lang.Object r3 = f7509d
            monitor-enter(r3)
            r0 = 0
            f7510e = r0     // Catch:{ all -> 0x0010 }
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = com.google.firebase.iid.C1987i.m8156a((android.content.Context) r8)
            if (r0 != 0) goto L_0x0013
        L_0x000f:
            return
        L_0x0010:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            throw r0
        L_0x0013:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.m8098a()
            com.google.firebase.iid.h r4 = r0.mo9862g()
            java.lang.String r3 = r0.mo9860e()
            if (r3 != 0) goto L_0x0051
            java.lang.String r1 = r0.mo9861f()     // Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
            if (r1 == 0) goto L_0x0042
            boolean r1 = r8.f7511f     // Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "get master token succeeded"
            android.util.Log.d(r1, r2)     // Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        L_0x0032:
            m8124a((android.content.Context) r8, (com.google.firebase.iid.FirebaseInstanceId) r0)     // Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
            r8.mo9866a()     // Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
            goto L_0x000f
        L_0x0039:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r8.m8125a((android.content.Intent) r9, (java.lang.String) r0)
            goto L_0x000f
        L_0x0042:
            java.lang.String r0 = "returned token is null"
            r8.m8125a((android.content.Intent) r9, (java.lang.String) r0)     // Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
            goto L_0x000f
        L_0x0048:
            r0 = move-exception
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "Unable to get master token"
            android.util.Log.e(r1, r2, r0)
            goto L_0x000f
        L_0x0051:
            java.lang.String r0 = r4.mo9886a()
            r3 = r0
        L_0x0056:
            if (r3 == 0) goto L_0x00be
            java.lang.String r0 = "!"
            java.lang.String[] r0 = r3.split(r0)
            int r5 = r0.length
            r6 = 2
            if (r5 != r6) goto L_0x0071
            r5 = r0[r1]
            r6 = r0[r2]
            r0 = -1
            int r7 = r5.hashCode()     // Catch:{ IOException -> 0x00a1 }
            switch(r7) {
                case 83: goto L_0x007a;
                case 84: goto L_0x006e;
                case 85: goto L_0x0084;
                default: goto L_0x006e;
            }
        L_0x006e:
            switch(r0) {
                case 0: goto L_0x008e;
                case 1: goto L_0x00ab;
                default: goto L_0x0071;
            }
        L_0x0071:
            r4.mo9887a(r3)
            java.lang.String r0 = r4.mo9886a()
            r3 = r0
            goto L_0x0056
        L_0x007a:
            java.lang.String r7 = "S"
            boolean r5 = r5.equals(r7)     // Catch:{ IOException -> 0x00a1 }
            if (r5 == 0) goto L_0x006e
            r0 = r1
            goto L_0x006e
        L_0x0084:
            java.lang.String r7 = "U"
            boolean r5 = r5.equals(r7)     // Catch:{ IOException -> 0x00a1 }
            if (r5 == 0) goto L_0x006e
            r0 = r2
            goto L_0x006e
        L_0x008e:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.m8098a()     // Catch:{ IOException -> 0x00a1 }
            r0.mo9855a((java.lang.String) r6)     // Catch:{ IOException -> 0x00a1 }
            boolean r0 = r8.f7511f     // Catch:{ IOException -> 0x00a1 }
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r5 = "subscribe operation succeeded"
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x00a1 }
            goto L_0x0071
        L_0x00a1:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r8.m8125a((android.content.Intent) r9, (java.lang.String) r0)
            goto L_0x000f
        L_0x00ab:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.m8098a()     // Catch:{ IOException -> 0x00a1 }
            r0.mo9857b((java.lang.String) r6)     // Catch:{ IOException -> 0x00a1 }
            boolean r0 = r8.f7511f     // Catch:{ IOException -> 0x00a1 }
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r5 = "unsubscribe operation succeeded"
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x00a1 }
            goto L_0x0071
        L_0x00be:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.m8126a(android.content.Intent, boolean):void");
    }

    /* renamed from: a */
    private void m8127a(C1987i iVar, Bundle bundle) {
        String a = C1987i.m8156a((Context) this);
        if (a == null) {
            Log.w("FirebaseInstanceId", "Unable to respond to ping due to missing target package");
            return;
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        intent.setPackage(a);
        intent.putExtras(bundle);
        iVar.mo9890a(intent);
        intent.putExtra("google.to", "google.com/iid");
        intent.putExtra("google.message_id", C1987i.m8164b());
        sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    /* renamed from: b */
    private int m8129b(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        if (intExtra < 10 && !z) {
            return 30;
        }
        if (intExtra < 10) {
            return 10;
        }
        if (intExtra > 28800) {
            return 28800;
        }
        return intExtra;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Intent m8131c(int i) {
        Context a = C1975b.m8087d().mo9841a();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.m8117b(a, intent);
    }

    /* renamed from: c */
    private String m8132c(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m8133c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* renamed from: d */
    private void m8134d(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * 1000)), PendingIntent.getBroadcast(this, 0, m8131c(i * 2), 268435456));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo9865a(Intent intent) {
        this.f7511f = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.mo9865a(intent);
        }
        String c = m8132c(intent);
        if (this.f7511f) {
            String valueOf = String.valueOf(c);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Register result in service ".concat(valueOf) : new String("Register result in service "));
        }
        m8122a(c).mo9884d().mo9896d(intent);
        mo9871b();
        return 2;
    }

    /* renamed from: a */
    public void mo9866a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Intent mo9867b(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.m8116a();
    }

    public void zzac(Intent intent) {
        String c = m8132c(intent);
        C1985g a = m8122a(c);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.f7511f) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(c).length() + 18 + String.valueOf(stringExtra).length() + String.valueOf(valueOf).length()).append("Service command ").append(c).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            C1989k c2 = a.mo9882c();
            if (c == null) {
                c = "";
            }
            c2.mo9911e(c);
            a.mo9884d().mo9896d(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            a.mo9882c().mo9911e(c);
            m8126a(intent, false);
        } else if ("RST".equals(stringExtra)) {
            a.mo9881b();
            a.mo9882c().mo9911e(c);
            m8126a(intent, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!a.mo9882c().mo9907b()) {
                a.mo9881b();
                a.mo9882c().mo9909c();
                m8126a(intent, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            a.mo9882c().mo9911e(c);
            m8126a(intent, false);
        } else if ("PING".equals(stringExtra)) {
            m8127a(a.mo9884d(), intent.getExtras());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzm(android.content.Intent r5) {
        /*
            r4 = this;
            r1 = 0
            java.lang.String r0 = r5.getAction()
            if (r0 != 0) goto L_0x0009
            java.lang.String r0 = ""
        L_0x0009:
            r2 = -1
            int r3 = r0.hashCode()
            switch(r3) {
                case -1737547627: goto L_0x0019;
                default: goto L_0x0011;
            }
        L_0x0011:
            r0 = r2
        L_0x0012:
            switch(r0) {
                case 0: goto L_0x0023;
                default: goto L_0x0015;
            }
        L_0x0015:
            r4.zzac(r5)
        L_0x0018:
            return
        L_0x0019:
            java.lang.String r3 = "ACTION_TOKEN_REFRESH_RETRY"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0011
            r0 = r1
            goto L_0x0012
        L_0x0023:
            r4.m8126a((android.content.Intent) r5, (boolean) r1)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.zzm(android.content.Intent):void");
    }
}
