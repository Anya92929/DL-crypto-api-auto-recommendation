package cmn;

import java.util.concurrent.Exchanger;

/* renamed from: cmn.w */
final class C0761w implements C0708ac {

    /* renamed from: a */
    final /* synthetic */ Exchanger f1878a;

    /* renamed from: b */
    final /* synthetic */ C0760v f1879b;

    C0761w(C0760v vVar, Exchanger exchanger) {
        this.f1879b = vVar;
        this.f1878a = exchanger;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3385a(Object obj) {
        try {
            this.f1878a.exchange((byte[]) obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
