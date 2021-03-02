package p000;

import android.os.Process;

/* renamed from: hg */
public class C1202hg implements Runnable {

    /* renamed from: a */
    private final Runnable f4259a;

    /* renamed from: b */
    private final int f4260b;

    public C1202hg(Runnable runnable, int i) {
        this.f4259a = runnable;
        this.f4260b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f4260b);
        this.f4259a.run();
    }
}
