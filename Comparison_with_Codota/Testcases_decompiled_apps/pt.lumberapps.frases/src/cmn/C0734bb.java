package cmn;

import java.util.LinkedList;
import java.util.concurrent.Executor;

/* renamed from: cmn.bb */
final class C0734bb implements Executor {

    /* renamed from: a */
    final LinkedList f1810a;

    /* renamed from: b */
    Runnable f1811b;

    private C0734bb() {
        this.f1810a = new LinkedList();
    }

    /* synthetic */ C0734bb(byte b) {
        this();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized void mo3417a() {
        Runnable runnable = (Runnable) this.f1810a.poll();
        this.f1811b = runnable;
        if (runnable != null) {
            C0726au.f1797d.execute(this.f1811b);
        }
    }

    public final synchronized void execute(Runnable runnable) {
        this.f1810a.offer(new C0735bc(this, runnable));
        if (this.f1811b == null) {
            mo3417a();
        }
    }
}
