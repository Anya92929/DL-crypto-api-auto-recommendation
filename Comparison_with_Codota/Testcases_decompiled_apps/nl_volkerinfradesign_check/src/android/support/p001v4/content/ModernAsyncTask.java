package android.support.p001v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.content.ModernAsyncTask */
abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: a */
    private static final ThreadFactory f468a = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f477a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f477a.getAndIncrement());
        }
    };

    /* renamed from: b */
    private static final BlockingQueue<Runnable> f469b = new LinkedBlockingQueue(10);

    /* renamed from: c */
    public static final Executor f470c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f469b, f468a);

    /* renamed from: d */
    private static C0123b f471d;

    /* renamed from: e */
    private static volatile Executor f472e = f470c;

    /* renamed from: f */
    private final C0124c<Params, Result> f473f = new C0124c<Params, Result>() {
        public Result call() throws Exception {
            ModernAsyncTask.this.f476i.set(true);
            Process.setThreadPriority(10);
            return ModernAsyncTask.this.m465d(ModernAsyncTask.this.mo778a((Params[]) this.f484b));
        }
    };

    /* renamed from: g */
    private final FutureTask<Result> f474g = new FutureTask<Result>(this.f473f) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                ModernAsyncTask.this.m464c(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                ModernAsyncTask.this.m464c(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* renamed from: h */
    private volatile Status f475h = Status.PENDING;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicBoolean f476i = new AtomicBoolean();

    /* renamed from: android.support.v4.content.ModernAsyncTask$Status */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo778a(Params... paramsArr);

    /* renamed from: a */
    private static Handler mo780a() {
        C0123b bVar;
        synchronized (ModernAsyncTask.class) {
            if (f471d == null) {
                f471d = new C0123b();
            }
            bVar = f471d;
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m464c(Result result) {
        if (!this.f476i.get()) {
            m465d(result);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public Result m465d(Result result) {
        mo780a().obtainMessage(1, new C0122a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo852b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo781a(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo853b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo782b(Result result) {
        mo854c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo854c() {
    }

    /* renamed from: d */
    public final boolean mo855d() {
        return this.f474g.isCancelled();
    }

    /* renamed from: a */
    public final boolean mo851a(boolean z) {
        return this.f474g.cancel(z);
    }

    /* renamed from: a */
    public final ModernAsyncTask<Params, Progress, Result> mo850a(Executor executor, Params... paramsArr) {
        if (this.f475h != Status.PENDING) {
            switch (this.f475h) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f475h = Status.RUNNING;
        mo852b();
        this.f473f.f484b = paramsArr;
        executor.execute(this.f474g);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m466e(Result result) {
        if (mo855d()) {
            mo782b(result);
        } else {
            mo781a(result);
        }
        this.f475h = Status.FINISHED;
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$b */
    static class C0123b extends Handler {
        public C0123b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C0122a aVar = (C0122a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.f482a.m466e(aVar.f483b[0]);
                    return;
                case 2:
                    aVar.f482a.mo853b((Progress[]) aVar.f483b);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$c */
    static abstract class C0124c<Params, Result> implements Callable<Result> {

        /* renamed from: b */
        Params[] f484b;

        private C0124c() {
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$a */
    static class C0122a<Data> {

        /* renamed from: a */
        final ModernAsyncTask f482a;

        /* renamed from: b */
        final Data[] f483b;

        C0122a(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f482a = modernAsyncTask;
            this.f483b = dataArr;
        }
    }
}
