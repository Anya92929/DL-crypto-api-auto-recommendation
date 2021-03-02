package android.support.p001v4.content;

import android.os.Build;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.content.ParallelExecutorCompat */
public class ParallelExecutorCompat {
    public static Executor getParallelExecutor() {
        if (Build.VERSION.SDK_INT >= 11) {
            return C0599ar.m3399a();
        }
        return ModernAsyncTask.f470c;
    }
}
