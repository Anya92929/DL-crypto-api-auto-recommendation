package android.support.p000v4.content;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.content.ExecutorCompatHoneycomb */
class ExecutorCompatHoneycomb {
    ExecutorCompatHoneycomb() {
    }

    public static Executor getParallelExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}
