package com.parse.p005os;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.parse.Parse;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.parse.os.ParseAsyncTask */
public abstract class ParseAsyncTask<Params, Progress, Result> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$parse$os$ParseAsyncTask$Status = null;
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "com.parse.os.ParseAsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_CANCEL = 3;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final ThreadPoolExecutor sExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, sWorkQueue, sThreadFactory);
    /* access modifiers changed from: private */
    public static final InternalHandler sHandler = new InternalHandler((InternalHandler) null);
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "ParseAsyncTask #" + this.mCount.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> sWorkQueue = new LinkedBlockingQueue(10);
    private final FutureTask<Result> mFuture = new FutureTask<Result>(this.mWorker) {
        /* access modifiers changed from: protected */
        public void done() {
            Result result = null;
            try {
                result = get();
            } catch (InterruptedException e) {
                if (5 > Parse.getLogLevel()) {
                    Log.w(ParseAsyncTask.LOG_TAG, e);
                }
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                ParseAsyncTask.sHandler.obtainMessage(3, new ParseAsyncTaskResult(ParseAsyncTask.this, (Data[]) null)).sendToTarget();
                return;
            } catch (Throwable t) {
                throw new RuntimeException("An error occurred while executing doInBackground()", t);
            }
            ParseAsyncTask.sHandler.obtainMessage(1, new ParseAsyncTaskResult(ParseAsyncTask.this, result)).sendToTarget();
        }
    };
    private volatile Status mStatus = Status.PENDING;
    private final WorkerRunnable<Params, Result> mWorker = new WorkerRunnable<Params, Result>() {
        public Result call() throws Exception {
            Process.setThreadPriority(10);
            return ParseAsyncTask.this.doInBackground(this.mParams);
        }
    };

    /* renamed from: com.parse.os.ParseAsyncTask$Status */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground(Params... paramsArr);

    static /* synthetic */ int[] $SWITCH_TABLE$com$parse$os$ParseAsyncTask$Status() {
        int[] iArr = $SWITCH_TABLE$com$parse$os$ParseAsyncTask$Status;
        if (iArr == null) {
            iArr = new int[Status.values().length];
            try {
                iArr[Status.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Status.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Status.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$parse$os$ParseAsyncTask$Status = iArr;
        }
        return iArr;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Progress... values) {
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    public final boolean cancel(boolean mayInterruptIfRunning) {
        return this.mFuture.cancel(mayInterruptIfRunning);
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(timeout, unit);
    }

    public final ParseAsyncTask<Params, Progress, Result> execute(Params... params) {
        switch ($SWITCH_TABLE$com$parse$os$ParseAsyncTask$Status()[this.mStatus.ordinal()]) {
            case 2:
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            case 3:
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            default:
                this.mStatus = Status.RUNNING;
                onPreExecute();
                this.mWorker.mParams = params;
                sExecutor.execute(this.mFuture);
                return this;
        }
    }

    /* access modifiers changed from: protected */
    public final void publishProgress(Progress... values) {
        sHandler.obtainMessage(2, new ParseAsyncTaskResult(this, values)).sendToTarget();
    }

    /* access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            result = null;
        }
        onPostExecute(result);
        this.mStatus = Status.FINISHED;
    }

    /* renamed from: com.parse.os.ParseAsyncTask$InternalHandler */
    private static class InternalHandler extends Handler {
        private InternalHandler() {
        }

        /* synthetic */ InternalHandler(InternalHandler internalHandler) {
            this();
        }

        public void handleMessage(Message msg) {
            ParseAsyncTaskResult result = (ParseAsyncTaskResult) msg.obj;
            switch (msg.what) {
                case 1:
                    result.mTask.finish(result.mData[0]);
                    return;
                case 2:
                    result.mTask.onProgressUpdate(result.mData);
                    return;
                case 3:
                    result.mTask.onCancelled();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.parse.os.ParseAsyncTask$WorkerRunnable */
    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private WorkerRunnable() {
        }

        /* synthetic */ WorkerRunnable(WorkerRunnable workerRunnable) {
            this();
        }
    }

    /* renamed from: com.parse.os.ParseAsyncTask$ParseAsyncTaskResult */
    private static class ParseAsyncTaskResult<Data> {
        final Data[] mData;
        final ParseAsyncTask mTask;

        ParseAsyncTaskResult(ParseAsyncTask task, Data... data) {
            this.mTask = task;
            this.mData = data;
        }
    }
}
