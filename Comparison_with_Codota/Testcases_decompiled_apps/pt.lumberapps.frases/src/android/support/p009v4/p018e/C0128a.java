package android.support.p009v4.p018e;

import android.os.AsyncTask;
import android.os.Build;

/* renamed from: android.support.v4.e.a */
public final class C0128a {
    /* renamed from: a */
    public static AsyncTask m317a(AsyncTask asyncTask, Object... objArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            C0129b.m318a(asyncTask, objArr);
        } else {
            asyncTask.execute(objArr);
        }
        return asyncTask;
    }
}
