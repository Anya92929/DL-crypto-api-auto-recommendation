package p000;

/* renamed from: jm */
public class C1326jm implements Runnable {

    /* renamed from: a */
    private final Thread f4588a;

    /* renamed from: b */
    private final long f4589b;

    /* renamed from: a */
    public static Thread m5721a(long j) {
        return m5722a(Thread.currentThread(), j);
    }

    /* renamed from: a */
    public static Thread m5722a(Thread thread, long j) {
        if (j <= 0) {
            return null;
        }
        Thread thread2 = new Thread(new C1326jm(thread, j), C1326jm.class.getSimpleName());
        thread2.setDaemon(true);
        thread2.start();
        return thread2;
    }

    /* renamed from: a */
    public static void m5723a(Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }

    private C1326jm(Thread thread, long j) {
        this.f4588a = thread;
        this.f4589b = j;
    }

    public void run() {
        try {
            Thread.sleep(this.f4589b);
            this.f4588a.interrupt();
        } catch (InterruptedException e) {
        }
    }
}
