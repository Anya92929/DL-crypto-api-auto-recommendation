package p000;

import android.os.AsyncTask;

/* renamed from: ce */
public class C0655ce {
    /* renamed from: a */
    public static <Params, Progress, Result> void m3579a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
