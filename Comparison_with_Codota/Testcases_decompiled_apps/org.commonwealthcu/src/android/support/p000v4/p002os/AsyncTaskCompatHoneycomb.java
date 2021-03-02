package android.support.p000v4.p002os;

import android.os.AsyncTask;

/* renamed from: android.support.v4.os.AsyncTaskCompatHoneycomb */
class AsyncTaskCompatHoneycomb {
    AsyncTaskCompatHoneycomb() {
    }

    static void executeParallel(AsyncTask asyncTask, Object... objArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
    }
}
