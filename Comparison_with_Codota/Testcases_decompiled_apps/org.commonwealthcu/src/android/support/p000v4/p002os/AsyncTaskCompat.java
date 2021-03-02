package android.support.p000v4.p002os;

import android.os.AsyncTask;
import android.os.Build;

/* renamed from: android.support.v4.os.AsyncTaskCompat */
public class AsyncTaskCompat {
    public static AsyncTask executeParallel(AsyncTask asyncTask, Object... objArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            AsyncTaskCompatHoneycomb.executeParallel(asyncTask, objArr);
        } else {
            asyncTask.execute(objArr);
        }
        return asyncTask;
    }
}
