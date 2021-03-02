package android.support.p001v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p001v4.p003os.OperationCanceledException;
import android.support.p001v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.content.AsyncTaskLoader */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* renamed from: a */
    volatile AsyncTaskLoader<D>.C0000a f420a;

    /* renamed from: b */
    volatile AsyncTaskLoader<D>.C0000a f421b;

    /* renamed from: c */
    long f422c;

    /* renamed from: d */
    long f423d;

    /* renamed from: e */
    Handler f424e;

    /* renamed from: f */
    private final Executor f425f;

    public abstract D loadInBackground();

    /* renamed from: android.support.v4.content.AsyncTaskLoader$a */
    final class C0105a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: a */
        boolean f426a;

        /* renamed from: d */
        private final CountDownLatch f428d = new CountDownLatch(1);

        C0105a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public D mo778a(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException e) {
                if (mo855d()) {
                    return null;
                }
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo781a(D d) {
            try {
                AsyncTaskLoader.this.mo767b(this, d);
            } finally {
                this.f428d.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo782b(D d) {
            try {
                AsyncTaskLoader.this.mo766a(this, d);
            } finally {
                this.f428d.countDown();
            }
        }

        public void run() {
            this.f426a = false;
            AsyncTaskLoader.this.mo765a();
        }

        /* renamed from: a */
        public void mo780a() {
            try {
                this.f428d.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.f470c);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.f423d = -10000;
        this.f425f = executor;
    }

    public void setUpdateThrottle(long j) {
        this.f422c = j;
        if (j != 0) {
            this.f424e = new Handler();
        }
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.f420a = new C0105a();
        mo765a();
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        boolean z = false;
        if (this.f420a != null) {
            if (this.f421b != null) {
                if (this.f420a.f426a) {
                    this.f420a.f426a = false;
                    this.f424e.removeCallbacks(this.f420a);
                }
                this.f420a = null;
            } else if (this.f420a.f426a) {
                this.f420a.f426a = false;
                this.f424e.removeCallbacks(this.f420a);
                this.f420a = null;
            } else {
                z = this.f420a.mo851a(false);
                if (z) {
                    this.f421b = this.f420a;
                    cancelLoadInBackground();
                }
                this.f420a = null;
            }
        }
        return z;
    }

    public void onCanceled(D d) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo765a() {
        if (this.f421b == null && this.f420a != null) {
            if (this.f420a.f426a) {
                this.f420a.f426a = false;
                this.f424e.removeCallbacks(this.f420a);
            }
            if (this.f422c <= 0 || SystemClock.uptimeMillis() >= this.f423d + this.f422c) {
                this.f420a.mo850a(this.f425f, (Params[]) null);
                return;
            }
            this.f420a.f426a = true;
            this.f424e.postAtTime(this.f420a, this.f423d + this.f422c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo766a(AsyncTaskLoader<D>.C0000a aVar, D d) {
        onCanceled(d);
        if (this.f421b == aVar) {
            rollbackContentChanged();
            this.f423d = SystemClock.uptimeMillis();
            this.f421b = null;
            deliverCancellation();
            mo765a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo767b(AsyncTaskLoader<D>.C0000a aVar, D d) {
        if (this.f420a != aVar) {
            mo766a(aVar, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.f423d = SystemClock.uptimeMillis();
            this.f420a = null;
            deliverResult(d);
        }
    }

    /* access modifiers changed from: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void cancelLoadInBackground() {
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.f421b != null;
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.C0000a aVar = this.f420a;
        if (aVar != null) {
            aVar.mo780a();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.f420a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f420a);
            printWriter.print(" waiting=");
            printWriter.println(this.f420a.f426a);
        }
        if (this.f421b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f421b);
            printWriter.print(" waiting=");
            printWriter.println(this.f421b.f426a);
        }
        if (this.f422c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.f422c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.f423d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
