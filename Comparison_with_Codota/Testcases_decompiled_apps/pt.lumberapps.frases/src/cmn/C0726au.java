package cmn;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: cmn.au */
public abstract class C0726au {

    /* renamed from: a */
    public static final ExecutorService f1794a = Executors.newFixedThreadPool(Math.min(16, Math.max(4, C0705a.m3174a().mo3381c() * 2)), f1796c);

    /* renamed from: b */
    public static final Executor f1795b = new C0734bb((byte) 0);

    /* renamed from: c */
    private static final ThreadFactory f1796c = new C0727av();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static volatile ExecutorService f1797d = f1794a;

    /* renamed from: e */
    private static C0731az f1798e;

    /* renamed from: f */
    private final C0737be f1799f = new C0728aw(this);

    /* renamed from: g */
    private final FutureTask f1800g = new C0729ax(this, this.f1799f);

    /* renamed from: h */
    private volatile int f1801h = C0736bd.f1814a;

    /* renamed from: i */
    private final AtomicBoolean f1802i = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final AtomicBoolean f1803j = new AtomicBoolean();

    /* renamed from: a */
    public static void m3237a(Runnable runnable) {
        f1797d.execute(runnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public Object m3238b(Object obj) {
        m3243d().obtainMessage(1, new C0733ba(this, obj)).sendToTarget();
        return obj;
    }

    /* renamed from: b */
    protected static void m3239b() {
    }

    /* renamed from: b */
    static /* synthetic */ void m3240b(C0726au auVar, Object obj) {
        if (!auVar.f1803j.get()) {
            auVar.m3238b(obj);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m3242c(C0726au auVar, Object obj) {
        if (!auVar.f1802i.get()) {
            auVar.mo3412a(obj);
        }
        auVar.f1801h = C0736bd.f1816c;
    }

    /* renamed from: d */
    private static Handler m3243d() {
        C0731az azVar;
        synchronized (C0726au.class) {
            if (f1798e == null) {
                f1798e = new C0731az();
            }
            azVar = f1798e;
        }
        return azVar;
    }

    /* renamed from: a */
    public final C0726au mo3410a(Object... objArr) {
        ExecutorService executorService = f1797d;
        if (this.f1801h != C0736bd.f1814a) {
            switch (C0730ay.f1807a[this.f1801h - 1]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f1801h = C0736bd.f1815b;
        this.f1799f.f1818b = objArr;
        executorService.execute(this.f1800g);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo3411a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3412a(Object obj) {
    }
}
