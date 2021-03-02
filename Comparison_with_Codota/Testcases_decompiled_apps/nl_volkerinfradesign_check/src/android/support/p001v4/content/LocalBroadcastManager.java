package android.support.p001v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: android.support.v4.content.LocalBroadcastManager */
public class LocalBroadcastManager {

    /* renamed from: f */
    private static final Object f455f = new Object();

    /* renamed from: g */
    private static LocalBroadcastManager f456g;

    /* renamed from: a */
    private final Context f457a;

    /* renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f458b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C0117b>> f459c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C0116a> f460d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f461e;

    /* renamed from: android.support.v4.content.LocalBroadcastManager$b */
    static class C0117b {

        /* renamed from: a */
        final IntentFilter f465a;

        /* renamed from: b */
        final BroadcastReceiver f466b;

        /* renamed from: c */
        boolean f467c;

        C0117b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f465a = intentFilter;
            this.f466b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f466b);
            sb.append(" filter=");
            sb.append(this.f465a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: android.support.v4.content.LocalBroadcastManager$a */
    static class C0116a {

        /* renamed from: a */
        final Intent f463a;

        /* renamed from: b */
        final ArrayList<C0117b> f464b;

        C0116a(Intent intent, ArrayList<C0117b> arrayList) {
            this.f463a = intent;
            this.f464b = arrayList;
        }
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f455f) {
            if (f456g == null) {
                f456g = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = f456g;
        }
        return localBroadcastManager;
    }

    private LocalBroadcastManager(Context context) {
        this.f457a = context;
        this.f461e = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        LocalBroadcastManager.this.m457a();
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f458b) {
            C0117b bVar = new C0117b(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.f458b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f458b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = this.f459c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f459c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        int i;
        synchronized (this.f458b) {
            ArrayList remove = this.f458b.remove(broadcastReceiver);
            if (remove != null) {
                for (int i2 = 0; i2 < remove.size(); i2++) {
                    IntentFilter intentFilter = (IntentFilter) remove.get(i2);
                    for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                        String action = intentFilter.getAction(i3);
                        ArrayList arrayList = this.f459c.get(action);
                        if (arrayList != null) {
                            int i4 = 0;
                            while (i4 < arrayList.size()) {
                                if (((C0117b) arrayList.get(i4)).f466b == broadcastReceiver) {
                                    arrayList.remove(i4);
                                    i = i4 - 1;
                                } else {
                                    i = i4;
                                }
                                i4 = i + 1;
                            }
                            if (arrayList.size() <= 0) {
                                this.f459c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x016f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(android.content.Intent r17) {
        /*
            r16 = this;
            r0 = r16
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r13 = r0.f458b
            monitor-enter(r13)
            java.lang.String r2 = r17.getAction()     // Catch:{ all -> 0x0103 }
            r0 = r16
            android.content.Context r1 = r0.f457a     // Catch:{ all -> 0x0103 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0103 }
            r0 = r17
            java.lang.String r3 = r0.resolveTypeIfNeeded(r1)     // Catch:{ all -> 0x0103 }
            android.net.Uri r5 = r17.getData()     // Catch:{ all -> 0x0103 }
            java.lang.String r4 = r17.getScheme()     // Catch:{ all -> 0x0103 }
            java.util.Set r6 = r17.getCategories()     // Catch:{ all -> 0x0103 }
            int r1 = r17.getFlags()     // Catch:{ all -> 0x0103 }
            r1 = r1 & 8
            if (r1 == 0) goto L_0x00c9
            r1 = 1
            r12 = r1
        L_0x002d:
            if (r12 == 0) goto L_0x005d
            java.lang.String r1 = "LocalBroadcastManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r7.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r8 = "Resolving type "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r7 = r7.append(r3)     // Catch:{ all -> 0x0103 }
            java.lang.String r8 = " scheme "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r7 = r7.append(r4)     // Catch:{ all -> 0x0103 }
            java.lang.String r8 = " of intent "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x0103 }
            r0 = r17
            java.lang.StringBuilder r7 = r7.append(r0)     // Catch:{ all -> 0x0103 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0103 }
            android.util.Log.v(r1, r7)     // Catch:{ all -> 0x0103 }
        L_0x005d:
            r0 = r16
            java.util.HashMap<java.lang.String, java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$b>> r1 = r0.f459c     // Catch:{ all -> 0x0103 }
            java.lang.String r7 = r17.getAction()     // Catch:{ all -> 0x0103 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x0103 }
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0103 }
            r8 = r0
            if (r8 == 0) goto L_0x016e
            if (r12 == 0) goto L_0x0089
            java.lang.String r1 = "LocalBroadcastManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r7.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r9 = "Action list: "
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x0103 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0103 }
            android.util.Log.v(r1, r7)     // Catch:{ all -> 0x0103 }
        L_0x0089:
            r10 = 0
            r1 = 0
            r11 = r1
        L_0x008c:
            int r1 = r8.size()     // Catch:{ all -> 0x0103 }
            if (r11 >= r1) goto L_0x0133
            java.lang.Object r1 = r8.get(r11)     // Catch:{ all -> 0x0103 }
            r0 = r1
            android.support.v4.content.LocalBroadcastManager$b r0 = (android.support.p001v4.content.LocalBroadcastManager.C0117b) r0     // Catch:{ all -> 0x0103 }
            r9 = r0
            if (r12 == 0) goto L_0x00b6
            java.lang.String r1 = "LocalBroadcastManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r7.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r14 = "Matching against filter "
            java.lang.StringBuilder r7 = r7.append(r14)     // Catch:{ all -> 0x0103 }
            android.content.IntentFilter r14 = r9.f465a     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r7 = r7.append(r14)     // Catch:{ all -> 0x0103 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0103 }
            android.util.Log.v(r1, r7)     // Catch:{ all -> 0x0103 }
        L_0x00b6:
            boolean r1 = r9.f467c     // Catch:{ all -> 0x0103 }
            if (r1 == 0) goto L_0x00cd
            if (r12 == 0) goto L_0x0125
            java.lang.String r1 = "LocalBroadcastManager"
            java.lang.String r7 = "  Filter's target already added"
            android.util.Log.v(r1, r7)     // Catch:{ all -> 0x0103 }
            r1 = r10
        L_0x00c4:
            int r7 = r11 + 1
            r11 = r7
            r10 = r1
            goto L_0x008c
        L_0x00c9:
            r1 = 0
            r12 = r1
            goto L_0x002d
        L_0x00cd:
            android.content.IntentFilter r1 = r9.f465a     // Catch:{ all -> 0x0103 }
            java.lang.String r7 = "LocalBroadcastManager"
            int r1 = r1.match(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0103 }
            if (r1 < 0) goto L_0x0106
            if (r12 == 0) goto L_0x00f5
            java.lang.String r7 = "LocalBroadcastManager"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r14.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r15 = "  Filter matched!  match=0x"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x0103 }
            java.lang.String r1 = java.lang.Integer.toHexString(r1)     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r1 = r14.append(r1)     // Catch:{ all -> 0x0103 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0103 }
            android.util.Log.v(r7, r1)     // Catch:{ all -> 0x0103 }
        L_0x00f5:
            if (r10 != 0) goto L_0x0171
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0103 }
            r1.<init>()     // Catch:{ all -> 0x0103 }
        L_0x00fc:
            r1.add(r9)     // Catch:{ all -> 0x0103 }
            r7 = 1
            r9.f467c = r7     // Catch:{ all -> 0x0103 }
            goto L_0x00c4
        L_0x0103:
            r1 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            throw r1
        L_0x0106:
            if (r12 == 0) goto L_0x0125
            switch(r1) {
                case -4: goto L_0x012a;
                case -3: goto L_0x0127;
                case -2: goto L_0x012d;
                case -1: goto L_0x0130;
                default: goto L_0x010b;
            }
        L_0x010b:
            java.lang.String r1 = "unknown reason"
        L_0x010d:
            java.lang.String r7 = "LocalBroadcastManager"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r9.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r14 = "  Filter did not match: "
            java.lang.StringBuilder r9 = r9.append(r14)     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r1 = r9.append(r1)     // Catch:{ all -> 0x0103 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0103 }
            android.util.Log.v(r7, r1)     // Catch:{ all -> 0x0103 }
        L_0x0125:
            r1 = r10
            goto L_0x00c4
        L_0x0127:
            java.lang.String r1 = "action"
            goto L_0x010d
        L_0x012a:
            java.lang.String r1 = "category"
            goto L_0x010d
        L_0x012d:
            java.lang.String r1 = "data"
            goto L_0x010d
        L_0x0130:
            java.lang.String r1 = "type"
            goto L_0x010d
        L_0x0133:
            if (r10 == 0) goto L_0x016e
            r1 = 0
            r2 = r1
        L_0x0137:
            int r1 = r10.size()     // Catch:{ all -> 0x0103 }
            if (r2 >= r1) goto L_0x014a
            java.lang.Object r1 = r10.get(r2)     // Catch:{ all -> 0x0103 }
            android.support.v4.content.LocalBroadcastManager$b r1 = (android.support.p001v4.content.LocalBroadcastManager.C0117b) r1     // Catch:{ all -> 0x0103 }
            r3 = 0
            r1.f467c = r3     // Catch:{ all -> 0x0103 }
            int r1 = r2 + 1
            r2 = r1
            goto L_0x0137
        L_0x014a:
            r0 = r16
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$a> r1 = r0.f460d     // Catch:{ all -> 0x0103 }
            android.support.v4.content.LocalBroadcastManager$a r2 = new android.support.v4.content.LocalBroadcastManager$a     // Catch:{ all -> 0x0103 }
            r0 = r17
            r2.<init>(r0, r10)     // Catch:{ all -> 0x0103 }
            r1.add(r2)     // Catch:{ all -> 0x0103 }
            r0 = r16
            android.os.Handler r1 = r0.f461e     // Catch:{ all -> 0x0103 }
            r2 = 1
            boolean r1 = r1.hasMessages(r2)     // Catch:{ all -> 0x0103 }
            if (r1 != 0) goto L_0x016b
            r0 = r16
            android.os.Handler r1 = r0.f461e     // Catch:{ all -> 0x0103 }
            r2 = 1
            r1.sendEmptyMessage(r2)     // Catch:{ all -> 0x0103 }
        L_0x016b:
            r1 = 1
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
        L_0x016d:
            return r1
        L_0x016e:
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            r1 = 0
            goto L_0x016d
        L_0x0171:
            r1 = r10
            goto L_0x00fc
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.content.LocalBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            m457a();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r3 >= r4.length) goto L_0x0001;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r5 = r4[r3];
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r1 >= r5.f464b.size()) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        r5.f464b.get(r1).f466b.onReceive(r8.f457a, r5.f463a);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        r3 = r3 + 1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m457a() {
        /*
            r8 = this;
            r2 = 0
        L_0x0001:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r1 = r8.f458b
            monitor-enter(r1)
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$a> r0 = r8.f460d     // Catch:{ all -> 0x003f }
            int r0 = r0.size()     // Catch:{ all -> 0x003f }
            if (r0 > 0) goto L_0x000e
            monitor-exit(r1)     // Catch:{ all -> 0x003f }
            return
        L_0x000e:
            android.support.v4.content.LocalBroadcastManager$a[] r4 = new android.support.p001v4.content.LocalBroadcastManager.C0116a[r0]     // Catch:{ all -> 0x003f }
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$a> r0 = r8.f460d     // Catch:{ all -> 0x003f }
            r0.toArray(r4)     // Catch:{ all -> 0x003f }
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$a> r0 = r8.f460d     // Catch:{ all -> 0x003f }
            r0.clear()     // Catch:{ all -> 0x003f }
            monitor-exit(r1)     // Catch:{ all -> 0x003f }
            r3 = r2
        L_0x001c:
            int r0 = r4.length
            if (r3 >= r0) goto L_0x0001
            r5 = r4[r3]
            r1 = r2
        L_0x0022:
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$b> r0 = r5.f464b
            int r0 = r0.size()
            if (r1 >= r0) goto L_0x0042
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$b> r0 = r5.f464b
            java.lang.Object r0 = r0.get(r1)
            android.support.v4.content.LocalBroadcastManager$b r0 = (android.support.p001v4.content.LocalBroadcastManager.C0117b) r0
            android.content.BroadcastReceiver r0 = r0.f466b
            android.content.Context r6 = r8.f457a
            android.content.Intent r7 = r5.f463a
            r0.onReceive(r6, r7)
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0022
        L_0x003f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003f }
            throw r0
        L_0x0042:
            int r0 = r3 + 1
            r3 = r0
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.content.LocalBroadcastManager.m457a():void");
    }
}
