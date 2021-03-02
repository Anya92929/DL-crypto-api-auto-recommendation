package android.support.p009v4.p018e;

import android.os.AsyncTask;

/* renamed from: android.support.v4.e.b */
class C0129b {
    /* renamed from: a */
    static void m318a(AsyncTask asyncTask, Object... objArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
    }
}
