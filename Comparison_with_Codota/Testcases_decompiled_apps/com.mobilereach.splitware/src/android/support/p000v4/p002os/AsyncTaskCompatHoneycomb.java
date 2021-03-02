package android.support.p000v4.p002os;

import android.os.AsyncTask;

/* renamed from: android.support.v4.os.AsyncTaskCompatHoneycomb */
class AsyncTaskCompatHoneycomb {
    AsyncTaskCompatHoneycomb() {
    }

    static <Params, Progress, Result> void executeParallel(AsyncTask<Params, Progress, Result> task, Params... params) {
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
    }
}
