package cmn;

import android.os.Process;

/* renamed from: cmn.aw */
final class C0728aw extends C0737be {

    /* renamed from: a */
    final /* synthetic */ C0726au f1805a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0728aw(C0726au auVar) {
        super((byte) 0);
        this.f1805a = auVar;
    }

    public final Object call() {
        this.f1805a.f1803j.set(true);
        Process.setThreadPriority(10);
        return this.f1805a.m3238b(this.f1805a.mo3411a());
    }
}
