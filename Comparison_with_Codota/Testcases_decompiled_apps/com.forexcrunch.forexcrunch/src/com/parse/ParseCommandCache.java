package com.parse;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.parse.ConnectivityNotifier;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

class ParseCommandCache {
    private static final String TAG = "com.parse.ParseCommandCache";
    private static int filenameCounter = 0;
    /* access modifiers changed from: private */
    public static Object lock = new Object();
    private File cachePath;
    private boolean connected = false;
    private ConnectivityNotifier.ConnectivityListener connectivityListener = new ConnectivityNotifier.ConnectivityListener() {
        public void networkConnectivityStatusChanged(Intent intent) {
            if (intent.getBooleanExtra("noConnectivity", false)) {
                ParseCommandCache.this.setConnected(false);
            } else {
                ParseCommandCache.this.setConnected(ConnectivityNotifier.getNotifier().isConnected());
            }
        }
    };
    private Logger log;
    private int maxCacheSizeBytes = 10485760;
    private HashMap<File, Task<Object>.TaskCompletionSource> pendingTasks = new HashMap<>();
    private boolean running = false;
    private Object runningLock;
    private boolean shouldStop = false;
    private TestHelper testHelper = null;
    private int timeoutMaxRetries = 5;
    private double timeoutRetryWaitSeconds = 600.0d;

    public ParseCommandCache(Context context) {
        lock = new Object();
        this.runningLock = new Object();
        this.log = Logger.getLogger(TAG);
        this.cachePath = new File(Parse.getParseDir(), "CommandCache");
        this.cachePath.mkdirs();
        if (Parse.hasPermission("android.permission.ACCESS_NETWORK_STATE")) {
            setConnected(ConnectivityNotifier.getNotifier().isConnected());
            ConnectivityNotifier.getNotifier().addListener(this.connectivityListener, context);
            resume();
        }
    }

    public void setTimeoutMaxRetries(int tries) {
        synchronized (lock) {
            this.timeoutMaxRetries = tries;
        }
    }

    public void setTimeoutRetryWaitSeconds(double seconds) {
        synchronized (lock) {
            this.timeoutRetryWaitSeconds = seconds;
        }
    }

    public void setMaxCacheSizeBytes(int bytes) {
        synchronized (lock) {
            this.maxCacheSizeBytes = bytes;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void resume() {
        /*
            r4 = this;
            java.lang.Object r2 = r4.runningLock
            monitor-enter(r2)
            boolean r1 = r4.running     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0016
            com.parse.ParseCommandCache$2 r1 = new com.parse.ParseCommandCache$2     // Catch:{ all -> 0x0029 }
            java.lang.String r3 = "ParseCommandCache.runLoop()"
            r1.<init>(r3)     // Catch:{ all -> 0x0029 }
            r1.start()     // Catch:{ all -> 0x0029 }
            java.lang.Object r1 = r4.runningLock     // Catch:{ InterruptedException -> 0x0018 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0018 }
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            return
        L_0x0018:
            r0 = move-exception
            java.lang.Object r3 = lock     // Catch:{ all -> 0x0029 }
            monitor-enter(r3)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r4.shouldStop = r1     // Catch:{ all -> 0x0026 }
            java.lang.Object r1 = lock     // Catch:{ all -> 0x0026 }
            r1.notify()     // Catch:{ all -> 0x0026 }
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            goto L_0x0016
        L_0x0026:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            throw r1     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.resume():void");
    }

    public void pause() {
        synchronized (this.runningLock) {
            if (this.running) {
                synchronized (lock) {
                    this.shouldStop = true;
                    lock.notify();
                }
            }
            while (this.running) {
                try {
                    this.runningLock.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b A[SYNTHETIC, Splitter:B:28:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054 A[SYNTHETIC, Splitter:B:33:0x0054] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0057=Splitter:B:35:0x0057, B:18:0x003d=Splitter:B:18:0x003d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeFile(java.io.File r12) {
        /*
            r11 = this;
            java.lang.Object r9 = lock
            monitor-enter(r9)
            java.util.HashMap<java.io.File, com.parse.Task<java.lang.Object>$TaskCompletionSource> r8 = r11.pendingTasks     // Catch:{ all -> 0x0058 }
            r8.remove(r12)     // Catch:{ all -> 0x0058 }
            r4 = 0
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0068, all -> 0x0051 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0068, all -> 0x0051 }
            r8.<init>(r12)     // Catch:{ Exception -> 0x0068, all -> 0x0051 }
            r3.<init>(r8)     // Catch:{ Exception -> 0x0068, all -> 0x0051 }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0047, all -> 0x0061 }
            r0.<init>()     // Catch:{ Exception -> 0x0047, all -> 0x0061 }
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r8]     // Catch:{ Exception -> 0x0047, all -> 0x0061 }
        L_0x001d:
            int r6 = r3.read(r7)     // Catch:{ Exception -> 0x0047, all -> 0x0061 }
            if (r6 > 0) goto L_0x0042
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0047, all -> 0x0061 }
            java.lang.String r8 = "UTF-8"
            java.lang.String r8 = r0.toString(r8)     // Catch:{ Exception -> 0x0047, all -> 0x0061 }
            r5.<init>(r8)     // Catch:{ Exception -> 0x0047, all -> 0x0061 }
            com.parse.ParseCommand r1 = new com.parse.ParseCommand     // Catch:{ Exception -> 0x006a, all -> 0x0064 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x006a, all -> 0x0064 }
            r1.releaseLocalIds()     // Catch:{ Exception -> 0x006a, all -> 0x0064 }
            if (r3 == 0) goto L_0x006e
            r3.close()     // Catch:{ IOException -> 0x005b }
            r2 = r3
            r4 = r5
        L_0x003d:
            r12.delete()     // Catch:{ all -> 0x0058 }
            monitor-exit(r9)     // Catch:{ all -> 0x0058 }
            return
        L_0x0042:
            r8 = 0
            r0.write(r7, r8, r6)     // Catch:{ Exception -> 0x0047, all -> 0x0061 }
            goto L_0x001d
        L_0x0047:
            r8 = move-exception
            r2 = r3
        L_0x0049:
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x003d
        L_0x004f:
            r8 = move-exception
            goto L_0x003d
        L_0x0051:
            r8 = move-exception
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            r2.close()     // Catch:{ IOException -> 0x005f }
        L_0x0057:
            throw r8     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r8 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0058 }
            throw r8
        L_0x005b:
            r8 = move-exception
            r2 = r3
            r4 = r5
            goto L_0x003d
        L_0x005f:
            r10 = move-exception
            goto L_0x0057
        L_0x0061:
            r8 = move-exception
            r2 = r3
            goto L_0x0052
        L_0x0064:
            r8 = move-exception
            r2 = r3
            r4 = r5
            goto L_0x0052
        L_0x0068:
            r8 = move-exception
            goto L_0x0049
        L_0x006a:
            r8 = move-exception
            r2 = r3
            r4 = r5
            goto L_0x0049
        L_0x006e:
            r2 = r3
            r4 = r5
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.removeFile(java.io.File):void");
    }

    /* access modifiers changed from: package-private */
    public void simulateReboot() {
        synchronized (lock) {
            this.pendingTasks.clear();
        }
    }

    public Task<Object> runEventuallyAsync(ParseCommand command, ParseObject object) {
        Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
        return runEventuallyInternalAsync(command, false, object);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:66:0x0250=Splitter:B:66:0x0250, B:79:0x02a2=Splitter:B:79:0x02a2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.parse.Task<java.lang.Object> runEventuallyInternalAsync(com.parse.ParseCommand r25, boolean r26, com.parse.ParseObject r27) {
        /*
            r24 = this;
            com.parse.Task$TaskCompletionSource r17 = com.parse.Task.create()
            if (r27 == 0) goto L_0x0017
            java.lang.String r19 = r27.getObjectId()     // Catch:{ UnsupportedEncodingException -> 0x0065 }
            if (r19 != 0) goto L_0x0017
            java.lang.String r19 = r27.getOrCreateLocalId()     // Catch:{ UnsupportedEncodingException -> 0x0065 }
            r0 = r25
            r1 = r19
            r0.setLocalId(r1)     // Catch:{ UnsupportedEncodingException -> 0x0065 }
        L_0x0017:
            org.json.JSONObject r10 = r25.toJSONObject()     // Catch:{ UnsupportedEncodingException -> 0x0065 }
            java.lang.String r19 = r10.toString()     // Catch:{ UnsupportedEncodingException -> 0x0065 }
            java.lang.String r20 = "UTF-8"
            byte[] r9 = r19.getBytes(r20)     // Catch:{ UnsupportedEncodingException -> 0x0065 }
            int r0 = r9.length
            r19 = r0
            r0 = r24
            int r0 = r0.maxCacheSizeBytes
            r20 = r0
            r0 = r19
            r1 = r20
            if (r0 <= r1) goto L_0x009f
            r19 = 5
            int r20 = com.parse.Parse.getLogLevel()
            r0 = r19
            r1 = r20
            if (r0 < r1) goto L_0x004b
            r0 = r24
            java.util.logging.Logger r0 = r0.log
            r19 = r0
            java.lang.String r20 = "Unable to save command for later because it's too big."
            r19.warning(r20)
        L_0x004b:
            r0 = r24
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper
            r19 = r0
            if (r19 == 0) goto L_0x005e
            r0 = r24
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper
            r19 = r0
            r20 = 4
            r19.notify(r20)
        L_0x005e:
            r19 = 0
            com.parse.Task r19 = com.parse.Task.forResult(r19)
        L_0x0064:
            return r19
        L_0x0065:
            r3 = move-exception
            r19 = 5
            int r20 = com.parse.Parse.getLogLevel()
            r0 = r19
            r1 = r20
            if (r0 < r1) goto L_0x0085
            r0 = r24
            java.util.logging.Logger r0 = r0.log
            r19 = r0
            java.util.logging.Level r20 = java.util.logging.Level.WARNING
            java.lang.String r21 = "UTF-8 isn't supported.  This shouldn't happen."
            r0 = r19
            r1 = r20
            r2 = r21
            r0.log(r1, r2, r3)
        L_0x0085:
            r0 = r24
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper
            r19 = r0
            if (r19 == 0) goto L_0x0098
            r0 = r24
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper
            r19 = r0
            r20 = 4
            r19.notify(r20)
        L_0x0098:
            r19 = 0
            com.parse.Task r19 = com.parse.Task.forResult(r19)
            goto L_0x0064
        L_0x009f:
            java.lang.Object r20 = lock
            monitor-enter(r20)
            r0 = r24
            java.io.File r0 = r0.cachePath     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            java.lang.String[] r6 = r19.list()     // Catch:{ IOException -> 0x0282 }
            if (r6 == 0) goto L_0x014a
            java.util.Arrays.sort(r6)     // Catch:{ IOException -> 0x0282 }
            r16 = 0
            int r0 = r6.length     // Catch:{ IOException -> 0x0282 }
            r21 = r0
            r19 = 0
        L_0x00b8:
            r0 = r19
            r1 = r21
            if (r0 < r1) goto L_0x00fd
            int r0 = r9.length     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            int r16 = r16 + r19
            r0 = r24
            int r0 = r0.maxCacheSizeBytes     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            r0 = r16
            r1 = r19
            if (r0 <= r1) goto L_0x014a
            if (r26 == 0) goto L_0x011a
            r19 = 5
            int r21 = com.parse.Parse.getLogLevel()     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            r1 = r21
            if (r0 < r1) goto L_0x00ec
            r0 = r24
            java.util.logging.Logger r0 = r0.log     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            java.lang.String r21 = "Unable to save command for later because storage is full."
            r0 = r19
            r1 = r21
            r0.warning(r1)     // Catch:{ IOException -> 0x0282 }
        L_0x00ec:
            r19 = 0
            com.parse.Task r19 = com.parse.Task.forResult(r19)     // Catch:{ IOException -> 0x0282 }
            java.lang.Object r21 = lock     // Catch:{ all -> 0x00fa }
            r21.notify()     // Catch:{ all -> 0x00fa }
            monitor-exit(r20)     // Catch:{ all -> 0x00fa }
            goto L_0x0064
        L_0x00fa:
            r19 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x00fa }
            throw r19
        L_0x00fd:
            r5 = r6[r19]     // Catch:{ IOException -> 0x0282 }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0282 }
            r0 = r24
            java.io.File r0 = r0.cachePath     // Catch:{ IOException -> 0x0282 }
            r22 = r0
            r0 = r22
            r4.<init>(r0, r5)     // Catch:{ IOException -> 0x0282 }
            long r22 = r4.length()     // Catch:{ IOException -> 0x0282 }
            r0 = r22
            int r0 = (int) r0     // Catch:{ IOException -> 0x0282 }
            r22 = r0
            int r16 = r16 + r22
            int r19 = r19 + 1
            goto L_0x00b8
        L_0x011a:
            r19 = 5
            int r21 = com.parse.Parse.getLogLevel()     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            r1 = r21
            if (r0 < r1) goto L_0x0135
            r0 = r24
            java.util.logging.Logger r0 = r0.log     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            java.lang.String r21 = "Deleting old commands to make room in command cache."
            r0 = r19
            r1 = r21
            r0.warning(r1)     // Catch:{ IOException -> 0x0282 }
        L_0x0135:
            r7 = 0
            r8 = r7
        L_0x0137:
            r0 = r24
            int r0 = r0.maxCacheSizeBytes     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            r0 = r16
            r1 = r19
            if (r0 <= r1) goto L_0x014a
            int r0 = r6.length     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            r0 = r19
            if (r8 < r0) goto L_0x025c
        L_0x014a:
            long r21 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0282 }
            java.lang.String r14 = java.lang.Long.toHexString(r21)     // Catch:{ IOException -> 0x0282 }
            int r19 = r14.length()     // Catch:{ IOException -> 0x0282 }
            r21 = 16
            r0 = r19
            r1 = r21
            if (r0 >= r1) goto L_0x018f
            int r19 = r14.length()     // Catch:{ IOException -> 0x0282 }
            int r19 = 16 - r19
            r0 = r19
            char[] r0 = new char[r0]     // Catch:{ IOException -> 0x0282 }
            r18 = r0
            r19 = 48
            java.util.Arrays.fill(r18, r19)     // Catch:{ IOException -> 0x0282 }
            java.lang.StringBuilder r19 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0282 }
            java.lang.String r21 = new java.lang.String     // Catch:{ IOException -> 0x0282 }
            r0 = r21
            r1 = r18
            r0.<init>(r1)     // Catch:{ IOException -> 0x0282 }
            java.lang.String r21 = java.lang.String.valueOf(r21)     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            r1 = r21
            r0.<init>(r1)     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            java.lang.StringBuilder r19 = r0.append(r14)     // Catch:{ IOException -> 0x0282 }
            java.lang.String r14 = r19.toString()     // Catch:{ IOException -> 0x0282 }
        L_0x018f:
            int r19 = filenameCounter     // Catch:{ IOException -> 0x0282 }
            int r21 = r19 + 1
            filenameCounter = r21     // Catch:{ IOException -> 0x0282 }
            java.lang.String r15 = java.lang.Integer.toHexString(r19)     // Catch:{ IOException -> 0x0282 }
            int r19 = r15.length()     // Catch:{ IOException -> 0x0282 }
            r21 = 8
            r0 = r19
            r1 = r21
            if (r0 >= r1) goto L_0x01d6
            int r19 = r15.length()     // Catch:{ IOException -> 0x0282 }
            int r19 = 8 - r19
            r0 = r19
            char[] r0 = new char[r0]     // Catch:{ IOException -> 0x0282 }
            r18 = r0
            r19 = 48
            java.util.Arrays.fill(r18, r19)     // Catch:{ IOException -> 0x0282 }
            java.lang.StringBuilder r19 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0282 }
            java.lang.String r21 = new java.lang.String     // Catch:{ IOException -> 0x0282 }
            r0 = r21
            r1 = r18
            r0.<init>(r1)     // Catch:{ IOException -> 0x0282 }
            java.lang.String r21 = java.lang.String.valueOf(r21)     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            r1 = r21
            r0.<init>(r1)     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            java.lang.StringBuilder r19 = r0.append(r15)     // Catch:{ IOException -> 0x0282 }
            java.lang.String r15 = r19.toString()     // Catch:{ IOException -> 0x0282 }
        L_0x01d6:
            java.lang.StringBuilder r19 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0282 }
            java.lang.String r21 = "CachedCommand_"
            r0 = r19
            r1 = r21
            r0.<init>(r1)     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            java.lang.StringBuilder r19 = r0.append(r14)     // Catch:{ IOException -> 0x0282 }
            java.lang.String r21 = "_"
            r0 = r19
            r1 = r21
            java.lang.StringBuilder r19 = r0.append(r1)     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            java.lang.StringBuilder r19 = r0.append(r15)     // Catch:{ IOException -> 0x0282 }
            java.lang.String r21 = "_"
            r0 = r19
            r1 = r21
            java.lang.StringBuilder r19 = r0.append(r1)     // Catch:{ IOException -> 0x0282 }
            java.lang.String r13 = r19.toString()     // Catch:{ IOException -> 0x0282 }
            java.lang.String r19 = ""
            r0 = r24
            java.io.File r0 = r0.cachePath     // Catch:{ IOException -> 0x0282 }
            r21 = r0
            r0 = r19
            r1 = r21
            java.io.File r12 = java.io.File.createTempFile(r13, r0, r1)     // Catch:{ IOException -> 0x0282 }
            r0 = r24
            java.util.HashMap<java.io.File, com.parse.Task<java.lang.Object>$TaskCompletionSource> r0 = r0.pendingTasks     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            r0 = r19
            r1 = r17
            r0.put(r12, r1)     // Catch:{ IOException -> 0x0282 }
            r25.retainLocalIds()     // Catch:{ IOException -> 0x0282 }
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0282 }
            java.io.FileOutputStream r19 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            r0.<init>(r12)     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            r11.<init>(r0)     // Catch:{ IOException -> 0x0282 }
            r11.write(r9)     // Catch:{ IOException -> 0x0282 }
            r11.close()     // Catch:{ IOException -> 0x0282 }
            r0 = r24
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            if (r19 == 0) goto L_0x0250
            r0 = r24
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            r21 = 3
            r0 = r19
            r1 = r21
            r0.notify(r1)     // Catch:{ IOException -> 0x0282 }
        L_0x0250:
            java.lang.Object r19 = lock     // Catch:{ all -> 0x00fa }
            r19.notify()     // Catch:{ all -> 0x00fa }
        L_0x0255:
            monitor-exit(r20)     // Catch:{ all -> 0x00fa }
            com.parse.Task r19 = r17.getTask()
            goto L_0x0064
        L_0x025c:
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0282 }
            r0 = r24
            java.io.File r0 = r0.cachePath     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            int r7 = r8 + 1
            r21 = r6[r8]     // Catch:{ IOException -> 0x0282 }
            r0 = r19
            r1 = r21
            r4.<init>(r0, r1)     // Catch:{ IOException -> 0x0282 }
            long r21 = r4.length()     // Catch:{ IOException -> 0x0282 }
            r0 = r21
            int r0 = (int) r0     // Catch:{ IOException -> 0x0282 }
            r19 = r0
            int r16 = r16 - r19
            r0 = r24
            r0.removeFile(r4)     // Catch:{ IOException -> 0x0282 }
            r8 = r7
            goto L_0x0137
        L_0x0282:
            r3 = move-exception
            r19 = 5
            int r21 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x02a8 }
            r0 = r19
            r1 = r21
            if (r0 < r1) goto L_0x02a2
            r0 = r24
            java.util.logging.Logger r0 = r0.log     // Catch:{ all -> 0x02a8 }
            r19 = r0
            java.util.logging.Level r21 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x02a8 }
            java.lang.String r22 = "Unable to save command for later."
            r0 = r19
            r1 = r21
            r2 = r22
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x02a8 }
        L_0x02a2:
            java.lang.Object r19 = lock     // Catch:{ all -> 0x00fa }
            r19.notify()     // Catch:{ all -> 0x00fa }
            goto L_0x0255
        L_0x02a8:
            r19 = move-exception
            java.lang.Object r21 = lock     // Catch:{ all -> 0x00fa }
            r21.notify()     // Catch:{ all -> 0x00fa }
            throw r19     // Catch:{ all -> 0x00fa }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.runEventuallyInternalAsync(com.parse.ParseCommand, boolean, com.parse.ParseObject):com.parse.Task");
    }

    public int pendingCount() {
        int length;
        synchronized (lock) {
            String[] files = this.cachePath.list();
            length = files == null ? 0 : files.length;
        }
        return length;
    }

    public void clear() {
        synchronized (lock) {
            File[] files = this.cachePath.listFiles();
            if (files != null) {
                for (File file : files) {
                    removeFile(file);
                }
                this.pendingTasks.clear();
            }
        }
    }

    public void setConnected(boolean connected2) {
        synchronized (lock) {
            if (this.connected != connected2) {
                this.connected = connected2;
                if (connected2) {
                    lock.notify();
                }
            }
        }
    }

    private <T> T waitForTaskWithoutLock(Task<T> task) throws ParseException {
        T waitForTask;
        synchronized (lock) {
            final Capture<Boolean> finished = new Capture<>(false);
            task.continueWith(new Continuation<T, Void>() {
                public Void then(Task<T> task) throws Exception {
                    finished.set(true);
                    synchronized (ParseCommandCache.lock) {
                        ParseCommandCache.lock.notifyAll();
                    }
                    return null;
                }
            }, ParseCommand.networkThreadPool);
            while (!finished.get().booleanValue()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    this.shouldStop = true;
                }
            }
            waitForTask = Parse.waitForTask(task);
        }
        return waitForTask;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0258 A[Catch:{ JSONException -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x00f4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x00f4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013d A[Catch:{ all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0157 A[SYNTHETIC, Splitter:B:73:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016a A[Catch:{ all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0184 A[SYNTHETIC, Splitter:B:84:0x0184] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x018f A[SYNTHETIC, Splitter:B:89:0x018f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void maybeRunAllCommandsNow(int r33) {
        /*
            r32 = this;
            java.lang.Object r26 = lock
            monitor-enter(r26)
            r0 = r32
            boolean r0 = r0.connected     // Catch:{ all -> 0x0020 }
            r24 = r0
            if (r24 != 0) goto L_0x000d
            monitor-exit(r26)     // Catch:{ all -> 0x0020 }
        L_0x000c:
            return
        L_0x000d:
            r0 = r32
            java.io.File r0 = r0.cachePath     // Catch:{ all -> 0x0020 }
            r24 = r0
            java.lang.String[] r12 = r24.list()     // Catch:{ all -> 0x0020 }
            if (r12 == 0) goto L_0x001e
            int r0 = r12.length     // Catch:{ all -> 0x0020 }
            r24 = r0
            if (r24 != 0) goto L_0x0023
        L_0x001e:
            monitor-exit(r26)     // Catch:{ all -> 0x0020 }
            goto L_0x000c
        L_0x0020:
            r24 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x0020 }
            throw r24
        L_0x0023:
            java.util.Arrays.sort(r12)     // Catch:{ all -> 0x0020 }
            int r0 = r12.length     // Catch:{ all -> 0x0020 }
            r27 = r0
            r24 = 0
            r25 = r24
        L_0x002d:
            r0 = r25
            r1 = r27
            if (r0 < r1) goto L_0x0035
            monitor-exit(r26)     // Catch:{ all -> 0x0020 }
            goto L_0x000c
        L_0x0035:
            r11 = r12[r25]     // Catch:{ all -> 0x0020 }
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x0020 }
            r0 = r32
            java.io.File r0 = r0.cachePath     // Catch:{ all -> 0x0020 }
            r24 = r0
            r0 = r24
            r10.<init>(r0, r11)     // Catch:{ all -> 0x0020 }
            r16 = 0
            r14 = 0
            java.io.BufferedInputStream r15 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x0130, JSONException -> 0x015d }
            java.io.FileInputStream r24 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x0130, JSONException -> 0x015d }
            r0 = r24
            r0.<init>(r10)     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x0130, JSONException -> 0x015d }
            r0 = r24
            r15.<init>(r0)     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x0130, JSONException -> 0x015d }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0107, IOException -> 0x02fa, JSONException -> 0x02f6, all -> 0x02f2 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0107, IOException -> 0x02fa, JSONException -> 0x02f6, all -> 0x02f2 }
            r24 = 1024(0x400, float:1.435E-42)
            r0 = r24
            byte[] r0 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x0107, IOException -> 0x02fa, JSONException -> 0x02f6, all -> 0x02f2 }
            r21 = r0
        L_0x0062:
            r0 = r21
            int r19 = r15.read(r0)     // Catch:{ FileNotFoundException -> 0x0107, IOException -> 0x02fa, JSONException -> 0x02f6, all -> 0x02f2 }
            if (r19 > 0) goto L_0x00fa
            org.json.JSONObject r17 = new org.json.JSONObject     // Catch:{ FileNotFoundException -> 0x0107, IOException -> 0x02fa, JSONException -> 0x02f6, all -> 0x02f2 }
            java.lang.String r24 = "UTF-8"
            r0 = r24
            java.lang.String r24 = r4.toString(r0)     // Catch:{ FileNotFoundException -> 0x0107, IOException -> 0x02fa, JSONException -> 0x02f6, all -> 0x02f2 }
            r0 = r17
            r1 = r24
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0107, IOException -> 0x02fa, JSONException -> 0x02f6, all -> 0x02f2 }
            if (r15 == 0) goto L_0x0080
            r15.close()     // Catch:{ IOException -> 0x02ef }
        L_0x0080:
            r5 = 0
            r0 = r32
            java.util.HashMap<java.io.File, com.parse.Task<java.lang.Object>$TaskCompletionSource> r0 = r0.pendingTasks     // Catch:{ all -> 0x0020 }
            r24 = r0
            r0 = r24
            boolean r24 = r0.containsKey(r10)     // Catch:{ all -> 0x0020 }
            if (r24 == 0) goto L_0x0193
            r0 = r32
            java.util.HashMap<java.io.File, com.parse.Task<java.lang.Object>$TaskCompletionSource> r0 = r0.pendingTasks     // Catch:{ all -> 0x0020 }
            r24 = r0
            r0 = r24
            java.lang.Object r24 = r0.get(r10)     // Catch:{ all -> 0x0020 }
            com.parse.Task$TaskCompletionSource r24 = (com.parse.Task.TaskCompletionSource) r24     // Catch:{ all -> 0x0020 }
            r20 = r24
        L_0x009f:
            com.parse.ParseCommand r5 = new com.parse.ParseCommand     // Catch:{ JSONException -> 0x0197 }
            r0 = r17
            r5.<init>(r0)     // Catch:{ JSONException -> 0x0197 }
            java.lang.String r18 = r5.getLocalId()     // Catch:{ ParseException -> 0x01c1 }
            com.parse.Task r24 = r5.performAsync()     // Catch:{ ParseException -> 0x01c1 }
            com.parse.ParseCommandCache$4 r28 = new com.parse.ParseCommandCache$4     // Catch:{ ParseException -> 0x01c1 }
            r0 = r28
            r1 = r32
            r2 = r20
            r3 = r18
            r0.<init>(r2, r3)     // Catch:{ ParseException -> 0x01c1 }
            r0 = r24
            r1 = r28
            com.parse.Task r6 = r0.onSuccess(r1)     // Catch:{ ParseException -> 0x01c1 }
            r0 = r32
            r0.waitForTaskWithoutLock(r6)     // Catch:{ ParseException -> 0x01c1 }
            if (r20 == 0) goto L_0x00d5
            com.parse.Task r24 = r20.getTask()     // Catch:{ ParseException -> 0x01c1 }
            r0 = r32
            r1 = r24
            r0.waitForTaskWithoutLock(r1)     // Catch:{ ParseException -> 0x01c1 }
        L_0x00d5:
            r0 = r32
            r0.removeFile(r10)     // Catch:{ ParseException -> 0x01c1 }
            r0 = r32
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper     // Catch:{ ParseException -> 0x01c1 }
            r24 = r0
            if (r24 == 0) goto L_0x02e7
            r0 = r32
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper     // Catch:{ ParseException -> 0x01c1 }
            r24 = r0
            r28 = 1
            r0 = r24
            r1 = r28
            r0.notify(r1)     // Catch:{ ParseException -> 0x01c1 }
            r14 = r15
            r16 = r17
        L_0x00f4:
            int r24 = r25 + 1
            r25 = r24
            goto L_0x002d
        L_0x00fa:
            r24 = 0
            r0 = r21
            r1 = r24
            r2 = r19
            r4.write(r0, r1, r2)     // Catch:{ FileNotFoundException -> 0x0107, IOException -> 0x02fa, JSONException -> 0x02f6, all -> 0x02f2 }
            goto L_0x0062
        L_0x0107:
            r9 = move-exception
            r14 = r15
        L_0x0109:
            r24 = 6
            int r28 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x018c }
            r0 = r24
            r1 = r28
            if (r0 < r1) goto L_0x0128
            r0 = r32
            java.util.logging.Logger r0 = r0.log     // Catch:{ all -> 0x018c }
            r24 = r0
            java.util.logging.Level r28 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x018c }
            java.lang.String r29 = "File disappeared from cache while being read."
            r0 = r24
            r1 = r28
            r2 = r29
            r0.log(r1, r2, r9)     // Catch:{ all -> 0x018c }
        L_0x0128:
            if (r14 == 0) goto L_0x00f4
            r14.close()     // Catch:{ IOException -> 0x012e }
            goto L_0x00f4
        L_0x012e:
            r24 = move-exception
            goto L_0x00f4
        L_0x0130:
            r9 = move-exception
        L_0x0131:
            r24 = 6
            int r28 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x018c }
            r0 = r24
            r1 = r28
            if (r0 < r1) goto L_0x0150
            r0 = r32
            java.util.logging.Logger r0 = r0.log     // Catch:{ all -> 0x018c }
            r24 = r0
            java.util.logging.Level r28 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x018c }
            java.lang.String r29 = "Unable to read contents of file in cache."
            r0 = r24
            r1 = r28
            r2 = r29
            r0.log(r1, r2, r9)     // Catch:{ all -> 0x018c }
        L_0x0150:
            r0 = r32
            r0.removeFile(r10)     // Catch:{ all -> 0x018c }
            if (r14 == 0) goto L_0x00f4
            r14.close()     // Catch:{ IOException -> 0x015b }
            goto L_0x00f4
        L_0x015b:
            r24 = move-exception
            goto L_0x00f4
        L_0x015d:
            r9 = move-exception
        L_0x015e:
            r24 = 6
            int r28 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x018c }
            r0 = r24
            r1 = r28
            if (r0 < r1) goto L_0x017d
            r0 = r32
            java.util.logging.Logger r0 = r0.log     // Catch:{ all -> 0x018c }
            r24 = r0
            java.util.logging.Level r28 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x018c }
            java.lang.String r29 = "Error parsing JSON found in cache."
            r0 = r24
            r1 = r28
            r2 = r29
            r0.log(r1, r2, r9)     // Catch:{ all -> 0x018c }
        L_0x017d:
            r0 = r32
            r0.removeFile(r10)     // Catch:{ all -> 0x018c }
            if (r14 == 0) goto L_0x00f4
            r14.close()     // Catch:{ IOException -> 0x0189 }
            goto L_0x00f4
        L_0x0189:
            r24 = move-exception
            goto L_0x00f4
        L_0x018c:
            r24 = move-exception
        L_0x018d:
            if (r14 == 0) goto L_0x0192
            r14.close()     // Catch:{ IOException -> 0x02ec }
        L_0x0192:
            throw r24     // Catch:{ all -> 0x0020 }
        L_0x0193:
            r20 = 0
            goto L_0x009f
        L_0x0197:
            r9 = move-exception
            r24 = 6
            int r28 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0020 }
            r0 = r24
            r1 = r28
            if (r0 < r1) goto L_0x01b7
            r0 = r32
            java.util.logging.Logger r0 = r0.log     // Catch:{ all -> 0x0020 }
            r24 = r0
            java.util.logging.Level r28 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0020 }
            java.lang.String r29 = "Unable to create ParseCommand from JSON."
            r0 = r24
            r1 = r28
            r2 = r29
            r0.log(r1, r2, r9)     // Catch:{ all -> 0x0020 }
        L_0x01b7:
            r0 = r32
            r0.removeFile(r10)     // Catch:{ all -> 0x0020 }
            r14 = r15
            r16 = r17
            goto L_0x00f4
        L_0x01c1:
            r9 = move-exception
            int r24 = r9.getCode()     // Catch:{ all -> 0x0020 }
            r28 = 100
            r0 = r24
            r1 = r28
            if (r0 != r1) goto L_0x02ac
            if (r33 <= 0) goto L_0x02e7
            r24 = 4
            int r28 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0020 }
            r0 = r24
            r1 = r28
            if (r0 < r1) goto L_0x0212
            r0 = r32
            java.util.logging.Logger r0 = r0.log     // Catch:{ all -> 0x0020 }
            r24 = r0
            java.lang.StringBuilder r28 = new java.lang.StringBuilder     // Catch:{ all -> 0x0020 }
            java.lang.String r29 = "Network timeout in command cache. Waiting for "
            r28.<init>(r29)     // Catch:{ all -> 0x0020 }
            r0 = r32
            double r0 = r0.timeoutRetryWaitSeconds     // Catch:{ all -> 0x0020 }
            r29 = r0
            java.lang.StringBuilder r28 = r28.append(r29)     // Catch:{ all -> 0x0020 }
            java.lang.String r29 = " seconds and then retrying "
            java.lang.StringBuilder r28 = r28.append(r29)     // Catch:{ all -> 0x0020 }
            r0 = r28
            r1 = r33
            java.lang.StringBuilder r28 = r0.append(r1)     // Catch:{ all -> 0x0020 }
            java.lang.String r29 = " times."
            java.lang.StringBuilder r28 = r28.append(r29)     // Catch:{ all -> 0x0020 }
            java.lang.String r28 = r28.toString()     // Catch:{ all -> 0x0020 }
            r0 = r24
            r1 = r28
            r0.info(r1)     // Catch:{ all -> 0x0020 }
        L_0x0212:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0020 }
            r0 = r32
            double r0 = r0.timeoutRetryWaitSeconds     // Catch:{ all -> 0x0020 }
            r28 = r0
            r30 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r28 = r28 * r30
            r0 = r28
            long r0 = (long) r0     // Catch:{ all -> 0x0020 }
            r28 = r0
            long r22 = r7 + r28
        L_0x022a:
            int r24 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r24 < 0) goto L_0x023c
            int r24 = r33 + -1
            r0 = r32
            r1 = r24
            r0.maybeRunAllCommandsNow(r1)     // Catch:{ all -> 0x0020 }
            r14 = r15
            r16 = r17
            goto L_0x00f4
        L_0x023c:
            r0 = r32
            boolean r0 = r0.connected     // Catch:{ all -> 0x0020 }
            r24 = r0
            if (r24 == 0) goto L_0x024c
            r0 = r32
            boolean r0 = r0.shouldStop     // Catch:{ all -> 0x0020 }
            r24 = r0
            if (r24 == 0) goto L_0x0266
        L_0x024c:
            r24 = 4
            int r25 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0020 }
            r0 = r24
            r1 = r25
            if (r0 < r1) goto L_0x0263
            r0 = r32
            java.util.logging.Logger r0 = r0.log     // Catch:{ all -> 0x0020 }
            r24 = r0
            java.lang.String r25 = "Aborting wait because runEventually thread should stop."
            r24.info(r25)     // Catch:{ all -> 0x0020 }
        L_0x0263:
            monitor-exit(r26)     // Catch:{ all -> 0x0020 }
            goto L_0x000c
        L_0x0266:
            java.lang.Object r24 = lock     // Catch:{ InterruptedException -> 0x02a2 }
            long r28 = r22 - r7
            r0 = r24
            r1 = r28
            r0.wait(r1)     // Catch:{ InterruptedException -> 0x02a2 }
        L_0x0271:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0020 }
            r0 = r32
            double r0 = r0.timeoutRetryWaitSeconds     // Catch:{ all -> 0x0020 }
            r28 = r0
            r30 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r28 = r28 * r30
            r0 = r28
            long r0 = (long) r0     // Catch:{ all -> 0x0020 }
            r28 = r0
            long r28 = r22 - r28
            int r24 = (r7 > r28 ? 1 : (r7 == r28 ? 0 : -1))
            if (r24 >= 0) goto L_0x022a
            r0 = r32
            double r0 = r0.timeoutRetryWaitSeconds     // Catch:{ all -> 0x0020 }
            r28 = r0
            r30 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r28 = r28 * r30
            r0 = r28
            long r0 = (long) r0     // Catch:{ all -> 0x0020 }
            r28 = r0
            long r7 = r22 - r28
            goto L_0x022a
        L_0x02a2:
            r13 = move-exception
            r24 = 1
            r0 = r24
            r1 = r32
            r1.shouldStop = r0     // Catch:{ all -> 0x0020 }
            goto L_0x0271
        L_0x02ac:
            r24 = 6
            int r28 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0020 }
            r0 = r24
            r1 = r28
            if (r0 < r1) goto L_0x02cb
            r0 = r32
            java.util.logging.Logger r0 = r0.log     // Catch:{ all -> 0x0020 }
            r24 = r0
            java.util.logging.Level r28 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0020 }
            java.lang.String r29 = "Failed to run command."
            r0 = r24
            r1 = r28
            r2 = r29
            r0.log(r1, r2, r9)     // Catch:{ all -> 0x0020 }
        L_0x02cb:
            r0 = r32
            r0.removeFile(r10)     // Catch:{ all -> 0x0020 }
            r0 = r32
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper     // Catch:{ all -> 0x0020 }
            r24 = r0
            if (r24 == 0) goto L_0x02e7
            r0 = r32
            com.parse.ParseCommandCache$TestHelper r0 = r0.testHelper     // Catch:{ all -> 0x0020 }
            r24 = r0
            r28 = 2
            r0 = r24
            r1 = r28
            r0.notify(r1)     // Catch:{ all -> 0x0020 }
        L_0x02e7:
            r14 = r15
            r16 = r17
            goto L_0x00f4
        L_0x02ec:
            r25 = move-exception
            goto L_0x0192
        L_0x02ef:
            r24 = move-exception
            goto L_0x0080
        L_0x02f2:
            r24 = move-exception
            r14 = r15
            goto L_0x018d
        L_0x02f6:
            r9 = move-exception
            r14 = r15
            goto L_0x015e
        L_0x02fa:
            r9 = move-exception
            r14 = r15
            goto L_0x0131
        L_0x02fe:
            r9 = move-exception
            goto L_0x0109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.maybeRunAllCommandsNow(int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r4 = lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r9.shouldStop != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (java.lang.Thread.interrupted() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0051, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x006b A[Catch:{ Exception -> 0x0076, all -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runLoop() {
        /*
            r9 = this;
            r8 = 4
            r2 = 0
            r3 = 1
            int r4 = com.parse.Parse.getLogLevel()
            if (r8 < r4) goto L_0x0010
            java.util.logging.Logger r4 = r9.log
            java.lang.String r5 = "Parse command cache has started processing queued commands."
            r4.info(r5)
        L_0x0010:
            java.lang.Object r4 = r9.runningLock
            monitor-enter(r4)
            boolean r5 = r9.running     // Catch:{ all -> 0x004e }
            if (r5 == 0) goto L_0x0019
            monitor-exit(r4)     // Catch:{ all -> 0x004e }
        L_0x0018:
            return
        L_0x0019:
            r5 = 1
            r9.running = r5     // Catch:{ all -> 0x004e }
            java.lang.Object r5 = r9.runningLock     // Catch:{ all -> 0x004e }
            r5.notifyAll()     // Catch:{ all -> 0x004e }
            monitor-exit(r4)     // Catch:{ all -> 0x004e }
            r1 = 0
            java.lang.Object r4 = lock
            monitor-enter(r4)
            boolean r5 = r9.shouldStop     // Catch:{ all -> 0x0053 }
            if (r5 != 0) goto L_0x0030
            boolean r5 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0051
        L_0x0030:
            r1 = r2
        L_0x0031:
            monitor-exit(r4)     // Catch:{ all -> 0x0053 }
        L_0x0032:
            if (r1 != 0) goto L_0x0056
            java.lang.Object r3 = r9.runningLock
            monitor-enter(r3)
            r2 = 0
            r9.running = r2     // Catch:{ all -> 0x009a }
            java.lang.Object r2 = r9.runningLock     // Catch:{ all -> 0x009a }
            r2.notifyAll()     // Catch:{ all -> 0x009a }
            monitor-exit(r3)     // Catch:{ all -> 0x009a }
            int r2 = com.parse.Parse.getLogLevel()
            if (r8 < r2) goto L_0x0018
            java.util.logging.Logger r2 = r9.log
            java.lang.String r3 = "saveEventually thread has stopped processing commands."
            r2.info(r3)
            goto L_0x0018
        L_0x004e:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x004e }
            throw r2
        L_0x0051:
            r1 = r3
            goto L_0x0031
        L_0x0053:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0053 }
            throw r2
        L_0x0056:
            java.lang.Object r5 = lock
            monitor-enter(r5)
            int r4 = r9.timeoutMaxRetries     // Catch:{ Exception -> 0x0076 }
            r9.maybeRunAllCommandsNow(r4)     // Catch:{ Exception -> 0x0076 }
            boolean r4 = r9.shouldStop     // Catch:{ Exception -> 0x0076 }
            if (r4 != 0) goto L_0x0067
            java.lang.Object r4 = lock     // Catch:{ InterruptedException -> 0x0071 }
            r4.wait()     // Catch:{ InterruptedException -> 0x0071 }
        L_0x0067:
            boolean r4 = r9.shouldStop     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x0098
            r1 = r2
        L_0x006c:
            monitor-exit(r5)     // Catch:{ all -> 0x006e }
            goto L_0x0032
        L_0x006e:
            r2 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x006e }
            throw r2
        L_0x0071:
            r0 = move-exception
            r4 = 1
            r9.shouldStop = r4     // Catch:{ Exception -> 0x0076 }
            goto L_0x0067
        L_0x0076:
            r0 = move-exception
            r4 = 6
            int r6 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x008f }
            if (r4 < r6) goto L_0x0087
            java.util.logging.Logger r4 = r9.log     // Catch:{ all -> 0x008f }
            java.util.logging.Level r6 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x008f }
            java.lang.String r7 = "saveEventually thread had an error."
            r4.log(r6, r7, r0)     // Catch:{ all -> 0x008f }
        L_0x0087:
            boolean r4 = r9.shouldStop     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x008d
            r1 = r2
        L_0x008c:
            goto L_0x006c
        L_0x008d:
            r1 = r3
            goto L_0x008c
        L_0x008f:
            r4 = move-exception
            boolean r6 = r9.shouldStop     // Catch:{ all -> 0x006e }
            if (r6 == 0) goto L_0x0096
            r1 = r2
        L_0x0095:
            throw r4     // Catch:{ all -> 0x006e }
        L_0x0096:
            r1 = r3
            goto L_0x0095
        L_0x0098:
            r1 = r3
            goto L_0x006c
        L_0x009a:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x009a }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.runLoop():void");
    }

    public TestHelper getTestHelper() {
        if (this.testHelper == null) {
            this.testHelper = new TestHelper(this, (TestHelper) null);
        }
        return this.testHelper;
    }

    public class TestHelper {
        public static final int COMMAND_ENQUEUED = 3;
        public static final int COMMAND_FAILED = 2;
        public static final int COMMAND_NOT_ENQUEUED = 4;
        public static final int COMMAND_SUCCESSFUL = 1;
        private static final int MAX_EVENTS = 1000;
        public static final int OBJECT_REMOVED = 6;
        public static final int OBJECT_UPDATED = 5;
        @SuppressLint({"UseSparseArrays"})
        private HashMap<Integer, Semaphore> events;

        private TestHelper() {
            this.events = new HashMap<>();
            clear();
        }

        /* synthetic */ TestHelper(ParseCommandCache parseCommandCache, TestHelper testHelper) {
            this();
        }

        public void clear() {
            this.events.clear();
            this.events.put(1, new Semaphore(1000));
            this.events.put(2, new Semaphore(1000));
            this.events.put(3, new Semaphore(1000));
            this.events.put(4, new Semaphore(1000));
            this.events.put(5, new Semaphore(1000));
            this.events.put(6, new Semaphore(1000));
            for (Integer intValue : this.events.keySet()) {
                this.events.get(Integer.valueOf(intValue.intValue())).acquireUninterruptibly(1000);
            }
        }

        public int unexpectedEvents() {
            int sum = 0;
            for (Integer intValue : this.events.keySet()) {
                sum += this.events.get(Integer.valueOf(intValue.intValue())).availablePermits();
            }
            return sum;
        }

        public void notify(int event) {
            this.events.get(Integer.valueOf(event)).release();
        }

        public boolean waitFor(int event) {
            try {
                return this.events.get(Integer.valueOf(event)).tryAcquire(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
