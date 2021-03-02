package okhttp3;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Internal;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.p008io.RealConnection;

public final class ConnectionPool {

    /* renamed from: c */
    static final /* synthetic */ boolean f5751c = (!ConnectionPool.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final Executor f5752d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));

    /* renamed from: a */
    final RouteDatabase f5753a;

    /* renamed from: b */
    boolean f5754b;

    /* renamed from: e */
    private final int f5755e;

    /* renamed from: f */
    private final long f5756f;

    /* renamed from: g */
    private final Runnable f5757g;

    /* renamed from: h */
    private final Deque<RealConnection> f5758h;

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f5757g = new Runnable() {
            public void run() {
                while (true) {
                    long a = ConnectionPool.this.mo10599a(System.nanoTime());
                    if (a != -1) {
                        if (a > 0) {
                            long j = a / 1000000;
                            long j2 = a - (j * 1000000);
                            synchronized (ConnectionPool.this) {
                                try {
                                    ConnectionPool.this.wait(j, (int) j2);
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        };
        this.f5758h = new ArrayDeque();
        this.f5753a = new RouteDatabase();
        this.f5755e = i;
        this.f5756f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    public synchronized int idleConnectionCount() {
        int i;
        int i2;
        i = 0;
        for (RealConnection realConnection : this.f5758h) {
            if (realConnection.allocations.isEmpty()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public synchronized int connectionCount() {
        return this.f5758h.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public RealConnection mo10600a(Address address, StreamAllocation streamAllocation) {
        if (f5751c || Thread.holdsLock(this)) {
            for (RealConnection next : this.f5758h) {
                if (next.allocations.size() < next.allocationLimit() && address.equals(next.route().f5948a) && !next.noNewStreams) {
                    streamAllocation.acquire(next);
                    return next;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10601a(RealConnection realConnection) {
        if (f5751c || Thread.holdsLock(this)) {
            if (!this.f5754b) {
                this.f5754b = true;
                f5752d.execute(this.f5757g);
            }
            this.f5758h.add(realConnection);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo10602b(RealConnection realConnection) {
        if (!f5751c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (realConnection.noNewStreams || this.f5755e == 0) {
            this.f5758h.remove(realConnection);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<RealConnection> it = this.f5758h.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.allocations.isEmpty()) {
                    next.noNewStreams = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (RealConnection socket : arrayList) {
            Util.closeQuietly(socket.socket());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo10599a(long j) {
        RealConnection realConnection;
        long j2;
        RealConnection realConnection2 = null;
        long j3 = Long.MIN_VALUE;
        synchronized (this) {
            int i = 0;
            int i2 = 0;
            for (RealConnection next : this.f5758h) {
                if (m6514a(next, j) > 0) {
                    i2++;
                } else {
                    int i3 = i + 1;
                    long j4 = j - next.idleAtNanos;
                    if (j4 > j3) {
                        long j5 = j4;
                        realConnection = next;
                        j2 = j5;
                    } else {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                    j3 = j2;
                    realConnection2 = realConnection;
                    i = i3;
                }
            }
            if (j3 >= this.f5756f || i > this.f5755e) {
                this.f5758h.remove(realConnection2);
                Util.closeQuietly(realConnection2.socket());
                return 0;
            } else if (i > 0) {
                long j6 = this.f5756f - j3;
                return j6;
            } else if (i2 > 0) {
                long j7 = this.f5756f;
                return j7;
            } else {
                this.f5754b = false;
                return -1;
            }
        }
    }

    /* renamed from: a */
    private int m6514a(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).get() != null) {
                i++;
            } else {
                Internal.logger.warning("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?");
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.f5756f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
