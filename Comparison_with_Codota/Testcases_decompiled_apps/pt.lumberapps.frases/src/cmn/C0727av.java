package cmn;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: cmn.av */
final class C0727av implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f1804a = new AtomicInteger(1);

    C0727av() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "_AsyncTask #" + this.f1804a.getAndIncrement());
    }
}
