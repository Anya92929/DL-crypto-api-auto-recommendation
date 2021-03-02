package android.support.p000v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p000v4.p002os.OperationCanceledException;
import android.support.p000v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.content.AsyncTaskLoader */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* renamed from: a */
    volatile AsyncTaskLoader<D>.LoadTask f714a;

    /* renamed from: b */
    volatile AsyncTaskLoader<D>.LoadTask f715b;

    /* renamed from: c */
    long f716c;

    /* renamed from: d */
    long f717d;

    /* renamed from: e */
    Handler f718e;

    /* renamed from: f */
    private final Executor f719f;

    /* renamed from: android.support.v4.content.AsyncTaskLoader$LoadTask */
    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: a */
        boolean f720a;

        /* renamed from: c */
        private final CountDownLatch f722c = new CountDownLatch(1);

        LoadTask() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public D mo1147a(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.mo1140d();
            } catch (OperationCanceledException e) {
                if (isCancelled()) {
                    return null;
                }
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo1149a(D d) {
            try {
                AsyncTaskLoader.this.mo1136b(this, d);
            } finally {
                this.f722c.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo1150b(D d) {
            try {
                AsyncTaskLoader.this.mo1135a(this, d);
            } finally {
                this.f722c.countDown();
            }
        }

        public void run() {
            this.f720a = false;
            AsyncTaskLoader.this.mo1138c();
        }

        public void waitForLoader() {
            try {
                this.f722c.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.f717d = -10000;
        this.f719f = executor;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1134a() {
        super.mo1134a();
        cancelLoad();
        this.f714a = new LoadTask();
        mo1138c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1135a(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        onCanceled(d);
        if (this.f715b == loadTask) {
            rollbackContentChanged();
            this.f717d = SystemClock.uptimeMillis();
            this.f715b = null;
            deliverCancellation();
            mo1138c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1136b(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        if (this.f714a != loadTask) {
            mo1135a(loadTask, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.f717d = SystemClock.uptimeMillis();
            this.f714a = null;
            deliverResult(d);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo1137b() {
        boolean z = false;
        if (this.f714a != null) {
            if (this.f715b != null) {
                if (this.f714a.f720a) {
                    this.f714a.f720a = false;
                    this.f718e.removeCallbacks(this.f714a);
                }
                this.f714a = null;
            } else if (this.f714a.f720a) {
                this.f714a.f720a = false;
                this.f718e.removeCallbacks(this.f714a);
                this.f714a = null;
            } else {
                z = this.f714a.cancel(false);
                if (z) {
                    this.f715b = this.f714a;
                    cancelLoadInBackground();
                }
                this.f714a = null;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1138c() {
        if (this.f715b == null && this.f714a != null) {
            if (this.f714a.f720a) {
                this.f714a.f720a = false;
                this.f718e.removeCallbacks(this.f714a);
            }
            if (this.f716c <= 0 || SystemClock.uptimeMillis() >= this.f717d + this.f716c) {
                this.f714a.executeOnExecutor(this.f719f, (Params[]) null);
                return;
            }
            this.f714a.f720a = true;
            this.f718e.postAtTime(this.f714a, this.f717d + this.f716c);
        }
    }

    public void cancelLoadInBackground() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public D mo1140d() {
        return loadInBackground();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.f714a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f714a);
            printWriter.print(" waiting=");
            printWriter.println(this.f714a.f720a);
        }
        if (this.f715b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f715b);
            printWriter.print(" waiting=");
            printWriter.println(this.f715b.f720a);
        }
        if (this.f716c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.f716c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.f717d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.f715b != null;
    }

    public abstract D loadInBackground();

    public void onCanceled(D d) {
    }

    public void setUpdateThrottle(long j) {
        this.f716c = j;
        if (j != 0) {
            this.f718e = new Handler();
        }
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask = this.f714a;
        if (loadTask != null) {
            loadTask.waitForLoader();
        }
    }
}
