package android.support.p000v4.content;

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
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap mActions = new HashMap();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList mPendingBroadcasts = new ArrayList();
    private final HashMap mReceivers = new HashMap();

    /* renamed from: android.support.v4.content.LocalBroadcastManager$BroadcastRecord */
    class BroadcastRecord {
        final Intent intent;
        final ArrayList receivers;

        BroadcastRecord(Intent intent2, ArrayList arrayList) {
            this.intent = intent2;
            this.receivers = arrayList;
        }
    }

    /* renamed from: android.support.v4.content.LocalBroadcastManager$ReceiverRecord */
    class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        LocalBroadcastManager.this.executePendingBroadcasts();
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
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
        if (r1 >= r5.receivers.size()) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        ((android.support.p000v4.content.LocalBroadcastManager.ReceiverRecord) r5.receivers.get(r1)).receiver.onReceive(r8.mAppContext, r5.intent);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executePendingBroadcasts() {
        /*
            r8 = this;
            r2 = 0
        L_0x0001:
            java.util.HashMap r1 = r8.mReceivers
            monitor-enter(r1)
            java.util.ArrayList r0 = r8.mPendingBroadcasts     // Catch:{ all -> 0x003f }
            int r0 = r0.size()     // Catch:{ all -> 0x003f }
            if (r0 > 0) goto L_0x000e
            monitor-exit(r1)     // Catch:{ all -> 0x003f }
            return
        L_0x000e:
            android.support.v4.content.LocalBroadcastManager$BroadcastRecord[] r4 = new android.support.p000v4.content.LocalBroadcastManager.BroadcastRecord[r0]     // Catch:{ all -> 0x003f }
            java.util.ArrayList r0 = r8.mPendingBroadcasts     // Catch:{ all -> 0x003f }
            r0.toArray(r4)     // Catch:{ all -> 0x003f }
            java.util.ArrayList r0 = r8.mPendingBroadcasts     // Catch:{ all -> 0x003f }
            r0.clear()     // Catch:{ all -> 0x003f }
            monitor-exit(r1)     // Catch:{ all -> 0x003f }
            r3 = r2
        L_0x001c:
            int r0 = r4.length
            if (r3 >= r0) goto L_0x0001
            r5 = r4[r3]
            r1 = r2
        L_0x0022:
            java.util.ArrayList r0 = r5.receivers
            int r0 = r0.size()
            if (r1 >= r0) goto L_0x0042
            java.util.ArrayList r0 = r5.receivers
            java.lang.Object r0 = r0.get(r1)
            android.support.v4.content.LocalBroadcastManager$ReceiverRecord r0 = (android.support.p000v4.content.LocalBroadcastManager.ReceiverRecord) r0
            android.content.BroadcastReceiver r0 = r0.receiver
            android.content.Context r6 = r8.mAppContext
            android.content.Intent r7 = r5.intent
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.content.LocalBroadcastManager.executePendingBroadcasts():void");
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x015b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(android.content.Intent r17) {
        /*
            r16 = this;
            r0 = r16
            java.util.HashMap r13 = r0.mReceivers
            monitor-enter(r13)
            java.lang.String r2 = r17.getAction()     // Catch:{ all -> 0x00f3 }
            r0 = r16
            android.content.Context r1 = r0.mAppContext     // Catch:{ all -> 0x00f3 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x00f3 }
            r0 = r17
            java.lang.String r3 = r0.resolveTypeIfNeeded(r1)     // Catch:{ all -> 0x00f3 }
            android.net.Uri r5 = r17.getData()     // Catch:{ all -> 0x00f3 }
            java.lang.String r4 = r17.getScheme()     // Catch:{ all -> 0x00f3 }
            java.util.Set r6 = r17.getCategories()     // Catch:{ all -> 0x00f3 }
            int r1 = r17.getFlags()     // Catch:{ all -> 0x00f3 }
            r1 = r1 & 8
            if (r1 == 0) goto L_0x00bd
            r1 = 1
            r12 = r1
        L_0x002d:
            if (r12 == 0) goto L_0x0059
            java.lang.String r1 = "LocalBroadcastManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            java.lang.String r8 = "Resolving type "
            r7.<init>(r8)     // Catch:{ all -> 0x00f3 }
            java.lang.StringBuilder r7 = r7.append(r3)     // Catch:{ all -> 0x00f3 }
            java.lang.String r8 = " scheme "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00f3 }
            java.lang.StringBuilder r7 = r7.append(r4)     // Catch:{ all -> 0x00f3 }
            java.lang.String r8 = " of intent "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00f3 }
            r0 = r17
            java.lang.StringBuilder r7 = r7.append(r0)     // Catch:{ all -> 0x00f3 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00f3 }
            android.util.Log.v(r1, r7)     // Catch:{ all -> 0x00f3 }
        L_0x0059:
            r0 = r16
            java.util.HashMap r1 = r0.mActions     // Catch:{ all -> 0x00f3 }
            java.lang.String r7 = r17.getAction()     // Catch:{ all -> 0x00f3 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x00f3 }
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x00f3 }
            r8 = r0
            if (r8 == 0) goto L_0x015a
            if (r12 == 0) goto L_0x0081
            java.lang.String r1 = "LocalBroadcastManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = "Action list: "
            r7.<init>(r9)     // Catch:{ all -> 0x00f3 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00f3 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00f3 }
            android.util.Log.v(r1, r7)     // Catch:{ all -> 0x00f3 }
        L_0x0081:
            r10 = 0
            r1 = 0
            r11 = r1
        L_0x0084:
            int r1 = r8.size()     // Catch:{ all -> 0x00f3 }
            if (r11 >= r1) goto L_0x011f
            java.lang.Object r1 = r8.get(r11)     // Catch:{ all -> 0x00f3 }
            r0 = r1
            android.support.v4.content.LocalBroadcastManager$ReceiverRecord r0 = (android.support.p000v4.content.LocalBroadcastManager.ReceiverRecord) r0     // Catch:{ all -> 0x00f3 }
            r9 = r0
            if (r12 == 0) goto L_0x00aa
            java.lang.String r1 = "LocalBroadcastManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            java.lang.String r14 = "Matching against filter "
            r7.<init>(r14)     // Catch:{ all -> 0x00f3 }
            android.content.IntentFilter r14 = r9.filter     // Catch:{ all -> 0x00f3 }
            java.lang.StringBuilder r7 = r7.append(r14)     // Catch:{ all -> 0x00f3 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00f3 }
            android.util.Log.v(r1, r7)     // Catch:{ all -> 0x00f3 }
        L_0x00aa:
            boolean r1 = r9.broadcasting     // Catch:{ all -> 0x00f3 }
            if (r1 == 0) goto L_0x00c1
            if (r12 == 0) goto L_0x0111
            java.lang.String r1 = "LocalBroadcastManager"
            java.lang.String r7 = "  Filter's target already added"
            android.util.Log.v(r1, r7)     // Catch:{ all -> 0x00f3 }
            r1 = r10
        L_0x00b8:
            int r7 = r11 + 1
            r11 = r7
            r10 = r1
            goto L_0x0084
        L_0x00bd:
            r1 = 0
            r12 = r1
            goto L_0x002d
        L_0x00c1:
            android.content.IntentFilter r1 = r9.filter     // Catch:{ all -> 0x00f3 }
            java.lang.String r7 = "LocalBroadcastManager"
            int r1 = r1.match(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00f3 }
            if (r1 < 0) goto L_0x00f6
            if (r12 == 0) goto L_0x00e5
            java.lang.String r7 = "LocalBroadcastManager"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            java.lang.String r15 = "  Filter matched!  match=0x"
            r14.<init>(r15)     // Catch:{ all -> 0x00f3 }
            java.lang.String r1 = java.lang.Integer.toHexString(r1)     // Catch:{ all -> 0x00f3 }
            java.lang.StringBuilder r1 = r14.append(r1)     // Catch:{ all -> 0x00f3 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f3 }
            android.util.Log.v(r7, r1)     // Catch:{ all -> 0x00f3 }
        L_0x00e5:
            if (r10 != 0) goto L_0x015d
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00f3 }
            r1.<init>()     // Catch:{ all -> 0x00f3 }
        L_0x00ec:
            r1.add(r9)     // Catch:{ all -> 0x00f3 }
            r7 = 1
            r9.broadcasting = r7     // Catch:{ all -> 0x00f3 }
            goto L_0x00b8
        L_0x00f3:
            r1 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x00f3 }
            throw r1
        L_0x00f6:
            if (r12 == 0) goto L_0x0111
            switch(r1) {
                case -4: goto L_0x0116;
                case -3: goto L_0x0113;
                case -2: goto L_0x0119;
                case -1: goto L_0x011c;
                default: goto L_0x00fb;
            }
        L_0x00fb:
            java.lang.String r1 = "unknown reason"
        L_0x00fd:
            java.lang.String r7 = "LocalBroadcastManager"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            java.lang.String r14 = "  Filter did not match: "
            r9.<init>(r14)     // Catch:{ all -> 0x00f3 }
            java.lang.StringBuilder r1 = r9.append(r1)     // Catch:{ all -> 0x00f3 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f3 }
            android.util.Log.v(r7, r1)     // Catch:{ all -> 0x00f3 }
        L_0x0111:
            r1 = r10
            goto L_0x00b8
        L_0x0113:
            java.lang.String r1 = "action"
            goto L_0x00fd
        L_0x0116:
            java.lang.String r1 = "category"
            goto L_0x00fd
        L_0x0119:
            java.lang.String r1 = "data"
            goto L_0x00fd
        L_0x011c:
            java.lang.String r1 = "type"
            goto L_0x00fd
        L_0x011f:
            if (r10 == 0) goto L_0x015a
            r1 = 0
            r2 = r1
        L_0x0123:
            int r1 = r10.size()     // Catch:{ all -> 0x00f3 }
            if (r2 >= r1) goto L_0x0136
            java.lang.Object r1 = r10.get(r2)     // Catch:{ all -> 0x00f3 }
            android.support.v4.content.LocalBroadcastManager$ReceiverRecord r1 = (android.support.p000v4.content.LocalBroadcastManager.ReceiverRecord) r1     // Catch:{ all -> 0x00f3 }
            r3 = 0
            r1.broadcasting = r3     // Catch:{ all -> 0x00f3 }
            int r1 = r2 + 1
            r2 = r1
            goto L_0x0123
        L_0x0136:
            r0 = r16
            java.util.ArrayList r1 = r0.mPendingBroadcasts     // Catch:{ all -> 0x00f3 }
            android.support.v4.content.LocalBroadcastManager$BroadcastRecord r2 = new android.support.v4.content.LocalBroadcastManager$BroadcastRecord     // Catch:{ all -> 0x00f3 }
            r0 = r17
            r2.<init>(r0, r10)     // Catch:{ all -> 0x00f3 }
            r1.add(r2)     // Catch:{ all -> 0x00f3 }
            r0 = r16
            android.os.Handler r1 = r0.mHandler     // Catch:{ all -> 0x00f3 }
            r2 = 1
            boolean r1 = r1.hasMessages(r2)     // Catch:{ all -> 0x00f3 }
            if (r1 != 0) goto L_0x0157
            r0 = r16
            android.os.Handler r1 = r0.mHandler     // Catch:{ all -> 0x00f3 }
            r2 = 1
            r1.sendEmptyMessage(r2)     // Catch:{ all -> 0x00f3 }
        L_0x0157:
            r1 = 1
            monitor-exit(r13)     // Catch:{ all -> 0x00f3 }
        L_0x0159:
            return r1
        L_0x015a:
            monitor-exit(r13)     // Catch:{ all -> 0x00f3 }
            r1 = 0
            goto L_0x0159
        L_0x015d:
            r1 = r10
            goto L_0x00ec
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.content.LocalBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        int i;
        synchronized (this.mReceivers) {
            ArrayList arrayList = (ArrayList) this.mReceivers.remove(broadcastReceiver);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    IntentFilter intentFilter = (IntentFilter) arrayList.get(i2);
                    for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                        String action = intentFilter.getAction(i3);
                        ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                        if (arrayList2 != null) {
                            int i4 = 0;
                            while (i4 < arrayList2.size()) {
                                if (((ReceiverRecord) arrayList2.get(i4)).receiver == broadcastReceiver) {
                                    arrayList2.remove(i4);
                                    i = i4 - 1;
                                } else {
                                    i = i4;
                                }
                                i4 = i + 1;
                            }
                            if (arrayList2.size() <= 0) {
                                this.mActions.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
