package cmn;

/* renamed from: cmn.bc */
final class C0735bc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f1812a;

    /* renamed from: b */
    final /* synthetic */ C0734bb f1813b;

    C0735bc(C0734bb bbVar, Runnable runnable) {
        this.f1813b = bbVar;
        this.f1812a = runnable;
    }

    public final void run() {
        try {
            this.f1812a.run();
        } finally {
            this.f1813b.mo3417a();
        }
    }
}
