package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import p000.C1295iv;

public final class Dispatcher {

    /* renamed from: a */
    private int f5791a = 64;

    /* renamed from: b */
    private int f5792b = 5;

    /* renamed from: c */
    private ExecutorService f5793c;

    /* renamed from: d */
    private final Deque<C1295iv.C1298b> f5794d = new ArrayDeque();

    /* renamed from: e */
    private final Deque<C1295iv.C1298b> f5795e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<C1295iv> f5796f = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.f5793c = executorService;
    }

    public Dispatcher() {
    }

    public synchronized ExecutorService executorService() {
        if (this.f5793c == null) {
            this.f5793c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.f5793c;
    }

    public synchronized void setMaxRequests(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        this.f5791a = i;
        m6538a();
    }

    public synchronized int getMaxRequests() {
        return this.f5791a;
    }

    public synchronized void setMaxRequestsPerHost(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        this.f5792b = i;
        m6538a();
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.f5792b;
    }

    /* renamed from: a */
    public synchronized void mo10646a(C1295iv.C1298b bVar) {
        if (this.f5795e.size() >= this.f5791a || m6539c(bVar) >= this.f5792b) {
            this.f5794d.add(bVar);
        } else {
            this.f5795e.add(bVar);
            executorService().execute(bVar);
        }
    }

    public synchronized void cancelAll() {
        for (C1295iv.C1298b b : this.f5794d) {
            b.mo8699b();
        }
        for (C1295iv.C1298b b2 : this.f5795e) {
            b2.mo8699b();
        }
        for (C1295iv cancel : this.f5796f) {
            cancel.cancel();
        }
    }

    /* renamed from: b */
    public synchronized void mo10649b(C1295iv.C1298b bVar) {
        if (!this.f5795e.remove(bVar)) {
            throw new AssertionError("AsyncCall wasn't running!");
        }
        m6538a();
    }

    /* renamed from: a */
    private void m6538a() {
        if (this.f5795e.size() < this.f5791a && !this.f5794d.isEmpty()) {
            Iterator<C1295iv.C1298b> it = this.f5794d.iterator();
            while (it.hasNext()) {
                C1295iv.C1298b next = it.next();
                if (m6539c(next) < this.f5792b) {
                    it.remove();
                    this.f5795e.add(next);
                    executorService().execute(next);
                }
                if (this.f5795e.size() >= this.f5791a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private int m6539c(C1295iv.C1298b bVar) {
        int i = 0;
        Iterator<C1295iv.C1298b> it = this.f5795e.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            if (it.next().mo8698a().equals(bVar.mo8698a())) {
                i = i2 + 1;
            } else {
                i = i2;
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo10647a(C1295iv ivVar) {
        this.f5796f.add(ivVar);
    }

    /* renamed from: a */
    public synchronized void mo10648a(Call call) {
        if (!this.f5796f.remove(call)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C1295iv.C1298b c : this.f5794d) {
            arrayList.add(c.mo8700c());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f5796f);
        for (C1295iv.C1298b c : this.f5795e) {
            arrayList.add(c.mo8700c());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.f5794d.size();
    }

    public synchronized int runningCallsCount() {
        return this.f5795e.size() + this.f5796f.size();
    }
}
