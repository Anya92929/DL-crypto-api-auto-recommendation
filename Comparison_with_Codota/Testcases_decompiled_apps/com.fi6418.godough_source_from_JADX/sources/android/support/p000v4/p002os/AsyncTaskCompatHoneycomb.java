package android.support.p000v4.p002os;

import android.os.AsyncTask;

/* renamed from: android.support.v4.os.AsyncTaskCompatHoneycomb */
class AsyncTaskCompatHoneycomb {
    AsyncTaskCompatHoneycomb() {
    }

    /* renamed from: a */
    static <Params, Progress, Result> void m748a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
