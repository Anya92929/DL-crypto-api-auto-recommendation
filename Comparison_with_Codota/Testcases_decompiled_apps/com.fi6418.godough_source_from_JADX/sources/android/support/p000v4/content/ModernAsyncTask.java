package android.support.p000v4.content;

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
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f763b, f762a);

    /* renamed from: a */
    private static final ThreadFactory f762a = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f770a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f770a.getAndIncrement());
        }
    };

    /* renamed from: b */
    private static final BlockingQueue<Runnable> f763b = new LinkedBlockingQueue(10);

    /* renamed from: c */
    private static InternalHandler f764c;

    /* renamed from: d */
    private static volatile Executor f765d = THREAD_POOL_EXECUTOR;

    /* renamed from: e */
    private final WorkerRunnable<Params, Result> f766e = new WorkerRunnable<Params, Result>() {
        public Result call() {
            ModernAsyncTask.this.f769h.set(true);
            Process.setThreadPriority(10);
            return ModernAsyncTask.this.m644d(ModernAsyncTask.this.mo1147a((Params[]) this.f777b));
        }
    };

    /* renamed from: f */
    private final FutureTask<Result> f767f = new FutureTask<Result>(this.f766e) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                ModernAsyncTask.this.m643c(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                ModernAsyncTask.this.m643c(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* renamed from: g */
    private volatile Status f768g = Status.PENDING;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final AtomicBoolean f769h = new AtomicBoolean();

    /* renamed from: android.support.v4.content.ModernAsyncTask$AsyncTaskResult */
    class AsyncTaskResult<Data> {

        /* renamed from: a */
        final ModernAsyncTask f774a;

        /* renamed from: b */
        final Data[] f775b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f774a = modernAsyncTask;
            this.f775b = dataArr;
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$InternalHandler */
    class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    asyncTaskResult.f774a.m645e(asyncTaskResult.f775b[0]);
                    return;
                case 2:
                    asyncTaskResult.f774a.mo1219b((Progress[]) asyncTaskResult.f775b);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$Status */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$WorkerRunnable */
    abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* renamed from: b */
        Params[] f777b;

        private WorkerRunnable() {
        }
    }

    /* renamed from: c */
    private static Handler m641c() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (f764c == null) {
                f764c = new InternalHandler();
            }
            internalHandler = f764c;
        }
        return internalHandler;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m643c(Result result) {
        if (!this.f769h.get()) {
            m644d(result);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public Result m644d(Result result) {
        m641c().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m645e(Result result) {
        if (isCancelled()) {
            mo1150b(result);
        } else {
            mo1149a(result);
        }
        this.f768g = Status.FINISHED;
    }

    public static void execute(Runnable runnable) {
        f765d.execute(runnable);
    }

    public static void setDefaultExecutor(Executor executor) {
        f765d = executor;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo1147a(Params... paramsArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1217a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1149a(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1218b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1150b(Result result) {
        mo1218b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1219b(Progress... progressArr) {
    }

    public final boolean cancel(boolean z) {
        return this.f767f.cancel(z);
    }

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(f765d, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.f768g != Status.PENDING) {
            switch (this.f768g) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f768g = Status.RUNNING;
        mo1217a();
        this.f766e.f777b = paramsArr;
        executor.execute(this.f767f);
        return this;
    }

    public final Result get() {
        return this.f767f.get();
    }

    public final Result get(long j, TimeUnit timeUnit) {
        return this.f767f.get(j, timeUnit);
    }

    public final Status getStatus() {
        return this.f768g;
    }

    public final boolean isCancelled() {
        return this.f767f.isCancelled();
    }
}
