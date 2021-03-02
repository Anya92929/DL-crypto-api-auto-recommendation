package twitter4j.internal.async;

import java.util.LinkedList;
import java.util.List;
import twitter4j.conf.Configuration;

final class DispatcherImpl implements Dispatcher {
    /* access modifiers changed from: private */
    public boolean active = true;

    /* renamed from: q */
    private final List<Runnable> f2157q = new LinkedList();
    private ExecuteThread[] threads;
    final Object ticket = new Object();

    public DispatcherImpl(Configuration conf) {
        this.threads = new ExecuteThread[conf.getAsyncNumThreads()];
        for (int i = 0; i < this.threads.length; i++) {
            this.threads[i] = new ExecuteThread("Twitter4J Async Dispatcher", this, i);
            this.threads[i].setDaemon(true);
            this.threads[i].start();
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                if (DispatcherImpl.this.active) {
                    DispatcherImpl.this.shutdown();
                }
            }
        });
    }

    public synchronized void invokeLater(Runnable task) {
        synchronized (this.f2157q) {
            this.f2157q.add(task);
        }
        synchronized (this.ticket) {
            this.ticket.notify();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r2 = r4.ticket;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4.ticket.wait();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Runnable poll() {
        /*
            r4 = this;
        L_0x0000:
            boolean r1 = r4.active
            if (r1 == 0) goto L_0x002d
            java.util.List<java.lang.Runnable> r2 = r4.f2157q
            monitor-enter(r2)
            java.util.List<java.lang.Runnable> r1 = r4.f2157q     // Catch:{ all -> 0x002a }
            int r1 = r1.size()     // Catch:{ all -> 0x002a }
            if (r1 <= 0) goto L_0x001c
            java.util.List<java.lang.Runnable> r1 = r4.f2157q     // Catch:{ all -> 0x002a }
            r3 = 0
            java.lang.Object r0 = r1.remove(r3)     // Catch:{ all -> 0x002a }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x001c
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
        L_0x001b:
            return r0
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            java.lang.Object r2 = r4.ticket
            monitor-enter(r2)
            java.lang.Object r1 = r4.ticket     // Catch:{ InterruptedException -> 0x002f }
            r1.wait()     // Catch:{ InterruptedException -> 0x002f }
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            goto L_0x0000
        L_0x0027:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            throw r1
        L_0x002a:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            throw r1
        L_0x002d:
            r0 = 0
            goto L_0x001b
        L_0x002f:
            r1 = move-exception
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.internal.async.DispatcherImpl.poll():java.lang.Runnable");
    }

    public synchronized void shutdown() {
        if (this.active) {
            this.active = false;
            for (ExecuteThread thread : this.threads) {
                thread.shutdown();
            }
            synchronized (this.ticket) {
                this.ticket.notify();
            }
        }
    }
}
