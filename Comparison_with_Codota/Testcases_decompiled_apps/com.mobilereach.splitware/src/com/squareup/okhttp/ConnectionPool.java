package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000;
    private static final ConnectionPool systemDefault;
    private final LinkedList<Connection> connections = new LinkedList<>();
    private final Runnable connectionsCleanupRunnable = new Runnable() {
        public void run() {
            ConnectionPool.this.runCleanupUntilPoolIsEmpty();
        }
    };
    private Executor executor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    static {
        String keepAlive = System.getProperty("http.keepAlive");
        String keepAliveDuration = System.getProperty("http.keepAliveDuration");
        String maxIdleConnections2 = System.getProperty("http.maxConnections");
        long keepAliveDurationMs = keepAliveDuration != null ? Long.parseLong(keepAliveDuration) : DEFAULT_KEEP_ALIVE_DURATION_MS;
        if (keepAlive != null && !Boolean.parseBoolean(keepAlive)) {
            systemDefault = new ConnectionPool(0, keepAliveDurationMs);
        } else if (maxIdleConnections2 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(maxIdleConnections2), keepAliveDurationMs);
        } else {
            systemDefault = new ConnectionPool(5, keepAliveDurationMs);
        }
    }

    public ConnectionPool(int maxIdleConnections2, long keepAliveDurationMs) {
        this.maxIdleConnections = maxIdleConnections2;
        this.keepAliveDurationNs = keepAliveDurationMs * 1000 * 1000;
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    public synchronized int getConnectionCount() {
        return this.connections.size();
    }

    @Deprecated
    public synchronized int getSpdyConnectionCount() {
        return getMultiplexedConnectionCount();
    }

    public synchronized int getMultiplexedConnectionCount() {
        int total;
        total = 0;
        Iterator it = this.connections.iterator();
        while (it.hasNext()) {
            if (((Connection) it.next()).isSpdy()) {
                total++;
            }
        }
        return total;
    }

    public synchronized int getHttpConnectionCount() {
        return this.connections.size() - getMultiplexedConnectionCount();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r2 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.squareup.okhttp.Connection get(com.squareup.okhttp.Address r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r2 = 0
            java.util.LinkedList<com.squareup.okhttp.Connection> r4 = r8.connections     // Catch:{ all -> 0x0084 }
            java.util.LinkedList<com.squareup.okhttp.Connection> r5 = r8.connections     // Catch:{ all -> 0x0084 }
            int r5 = r5.size()     // Catch:{ all -> 0x0084 }
            java.util.ListIterator r3 = r4.listIterator(r5)     // Catch:{ all -> 0x0084 }
        L_0x000e:
            boolean r4 = r3.hasPrevious()     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x0052
            java.lang.Object r0 = r3.previous()     // Catch:{ all -> 0x0084 }
            com.squareup.okhttp.Connection r0 = (com.squareup.okhttp.Connection) r0     // Catch:{ all -> 0x0084 }
            com.squareup.okhttp.Route r4 = r0.getRoute()     // Catch:{ all -> 0x0084 }
            com.squareup.okhttp.Address r4 = r4.getAddress()     // Catch:{ all -> 0x0084 }
            boolean r4 = r4.equals(r9)     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x000e
            boolean r4 = r0.isAlive()     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x000e
            long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0084 }
            long r6 = r0.getIdleStartTimeNs()     // Catch:{ all -> 0x0084 }
            long r4 = r4 - r6
            long r6 = r8.keepAliveDurationNs     // Catch:{ all -> 0x0084 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x000e
            r3.remove()     // Catch:{ all -> 0x0084 }
            boolean r4 = r0.isSpdy()     // Catch:{ all -> 0x0084 }
            if (r4 != 0) goto L_0x0051
            com.squareup.okhttp.internal.Platform r4 = com.squareup.okhttp.internal.Platform.get()     // Catch:{ SocketException -> 0x0061 }
            java.net.Socket r5 = r0.getSocket()     // Catch:{ SocketException -> 0x0061 }
            r4.tagSocket(r5)     // Catch:{ SocketException -> 0x0061 }
        L_0x0051:
            r2 = r0
        L_0x0052:
            if (r2 == 0) goto L_0x005f
            boolean r4 = r2.isSpdy()     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x005f
            java.util.LinkedList<com.squareup.okhttp.Connection> r4 = r8.connections     // Catch:{ all -> 0x0084 }
            r4.addFirst(r2)     // Catch:{ all -> 0x0084 }
        L_0x005f:
            monitor-exit(r8)
            return r2
        L_0x0061:
            r1 = move-exception
            java.net.Socket r4 = r0.getSocket()     // Catch:{ all -> 0x0084 }
            com.squareup.okhttp.internal.Util.closeQuietly((java.net.Socket) r4)     // Catch:{ all -> 0x0084 }
            com.squareup.okhttp.internal.Platform r4 = com.squareup.okhttp.internal.Platform.get()     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r5.<init>()     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = "Unable to tagSocket(): "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r5 = r5.append(r1)     // Catch:{ all -> 0x0084 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0084 }
            r4.logW(r5)     // Catch:{ all -> 0x0084 }
            goto L_0x000e
        L_0x0084:
            r4 = move-exception
            monitor-exit(r8)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.ConnectionPool.get(com.squareup.okhttp.Address):com.squareup.okhttp.Connection");
    }

    /* access modifiers changed from: package-private */
    public void recycle(Connection connection) {
        if (connection.isSpdy() || !connection.clearOwner()) {
            return;
        }
        if (!connection.isAlive()) {
            Util.closeQuietly(connection.getSocket());
            return;
        }
        try {
            Platform.get().untagSocket(connection.getSocket());
            synchronized (this) {
                addConnection(connection);
                connection.incrementRecycleCount();
                connection.resetIdleStartTime();
            }
        } catch (SocketException e) {
            Platform.get().logW("Unable to untagSocket(): " + e);
            Util.closeQuietly(connection.getSocket());
        }
    }

    private void addConnection(Connection connection) {
        boolean empty = this.connections.isEmpty();
        this.connections.addFirst(connection);
        if (empty) {
            this.executor.execute(this.connectionsCleanupRunnable);
        } else {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void share(Connection connection) {
        if (!connection.isSpdy()) {
            throw new IllegalArgumentException();
        } else if (connection.isAlive()) {
            synchronized (this) {
                addConnection(connection);
            }
        }
    }

    public void evictAll() {
        List<Connection> toEvict;
        synchronized (this) {
            toEvict = new ArrayList<>(this.connections);
            this.connections.clear();
            notifyAll();
        }
        int size = toEvict.size();
        for (int i = 0; i < size; i++) {
            Util.closeQuietly(toEvict.get(i).getSocket());
        }
    }

    /* access modifiers changed from: private */
    public void runCleanupUntilPoolIsEmpty() {
        do {
        } while (performCleanup());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performCleanup() {
        /*
            r24 = this;
            monitor-enter(r24)
            r0 = r24
            java.util.LinkedList<com.squareup.okhttp.Connection> r0 = r0.connections     // Catch:{ all -> 0x0060 }
            r19 = r0
            boolean r19 = r19.isEmpty()     // Catch:{ all -> 0x0060 }
            if (r19 == 0) goto L_0x0011
            r19 = 0
            monitor-exit(r24)     // Catch:{ all -> 0x0060 }
        L_0x0010:
            return r19
        L_0x0011:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0060 }
            r3.<init>()     // Catch:{ all -> 0x0060 }
            r7 = 0
            long r14 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0060 }
            r0 = r24
            long r12 = r0.keepAliveDurationNs     // Catch:{ all -> 0x0060 }
            r0 = r24
            java.util.LinkedList<com.squareup.okhttp.Connection> r0 = r0.connections     // Catch:{ all -> 0x0060 }
            r19 = r0
            r0 = r24
            java.util.LinkedList<com.squareup.okhttp.Connection> r0 = r0.connections     // Catch:{ all -> 0x0060 }
            r20 = r0
            int r20 = r20.size()     // Catch:{ all -> 0x0060 }
            java.util.ListIterator r6 = r19.listIterator(r20)     // Catch:{ all -> 0x0060 }
        L_0x0033:
            boolean r19 = r6.hasPrevious()     // Catch:{ all -> 0x0060 }
            if (r19 == 0) goto L_0x0070
            java.lang.Object r2 = r6.previous()     // Catch:{ all -> 0x0060 }
            com.squareup.okhttp.Connection r2 = (com.squareup.okhttp.Connection) r2     // Catch:{ all -> 0x0060 }
            long r20 = r2.getIdleStartTimeNs()     // Catch:{ all -> 0x0060 }
            r0 = r24
            long r0 = r0.keepAliveDurationNs     // Catch:{ all -> 0x0060 }
            r22 = r0
            long r20 = r20 + r22
            long r10 = r20 - r14
            r20 = 0
            int r19 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r19 <= 0) goto L_0x0059
            boolean r19 = r2.isAlive()     // Catch:{ all -> 0x0060 }
            if (r19 != 0) goto L_0x0063
        L_0x0059:
            r6.remove()     // Catch:{ all -> 0x0060 }
            r3.add(r2)     // Catch:{ all -> 0x0060 }
            goto L_0x0033
        L_0x0060:
            r19 = move-exception
            monitor-exit(r24)     // Catch:{ all -> 0x0060 }
            throw r19
        L_0x0063:
            boolean r19 = r2.isIdle()     // Catch:{ all -> 0x0060 }
            if (r19 == 0) goto L_0x0033
            int r7 = r7 + 1
            long r12 = java.lang.Math.min(r12, r10)     // Catch:{ all -> 0x0060 }
            goto L_0x0033
        L_0x0070:
            r0 = r24
            java.util.LinkedList<com.squareup.okhttp.Connection> r0 = r0.connections     // Catch:{ all -> 0x0060 }
            r19 = r0
            r0 = r24
            java.util.LinkedList<com.squareup.okhttp.Connection> r0 = r0.connections     // Catch:{ all -> 0x0060 }
            r20 = r0
            int r20 = r20.size()     // Catch:{ all -> 0x0060 }
            java.util.ListIterator r6 = r19.listIterator(r20)     // Catch:{ all -> 0x0060 }
        L_0x0084:
            boolean r19 = r6.hasPrevious()     // Catch:{ all -> 0x0060 }
            if (r19 == 0) goto L_0x00a9
            r0 = r24
            int r0 = r0.maxIdleConnections     // Catch:{ all -> 0x0060 }
            r19 = r0
            r0 = r19
            if (r7 <= r0) goto L_0x00a9
            java.lang.Object r2 = r6.previous()     // Catch:{ all -> 0x0060 }
            com.squareup.okhttp.Connection r2 = (com.squareup.okhttp.Connection) r2     // Catch:{ all -> 0x0060 }
            boolean r19 = r2.isIdle()     // Catch:{ all -> 0x0060 }
            if (r19 == 0) goto L_0x0084
            r3.add(r2)     // Catch:{ all -> 0x0060 }
            r6.remove()     // Catch:{ all -> 0x0060 }
            int r7 = r7 + -1
            goto L_0x0084
        L_0x00a9:
            boolean r19 = r3.isEmpty()     // Catch:{ all -> 0x0060 }
            if (r19 == 0) goto L_0x00cd
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r12 / r20
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r20 = r20 * r8
            long r16 = r12 - r20
            r0 = r16
            int r0 = (int) r0     // Catch:{ InterruptedException -> 0x00cc }
            r19 = r0
            r0 = r24
            r1 = r19
            r0.wait(r8, r1)     // Catch:{ InterruptedException -> 0x00cc }
            r19 = 1
            monitor-exit(r24)     // Catch:{ all -> 0x0060 }
            goto L_0x0010
        L_0x00cc:
            r19 = move-exception
        L_0x00cd:
            monitor-exit(r24)     // Catch:{ all -> 0x0060 }
            r5 = 0
            int r18 = r3.size()
        L_0x00d3:
            r0 = r18
            if (r5 >= r0) goto L_0x00e7
            java.lang.Object r4 = r3.get(r5)
            com.squareup.okhttp.Connection r4 = (com.squareup.okhttp.Connection) r4
            java.net.Socket r19 = r4.getSocket()
            com.squareup.okhttp.internal.Util.closeQuietly((java.net.Socket) r19)
            int r5 = r5 + 1
            goto L_0x00d3
        L_0x00e7:
            r19 = 1
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.ConnectionPool.performCleanup():boolean");
    }

    /* access modifiers changed from: package-private */
    public void replaceCleanupExecutorForTests(Executor cleanupExecutor) {
        this.executor = cleanupExecutor;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Connection> getConnections() {
        return new ArrayList(this.connections);
    }
}
