package cmn;

import java.io.File;

/* renamed from: cmn.ag */
final class C0712ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Object f1758a;

    /* renamed from: b */
    final /* synthetic */ C0710ae f1759b;

    C0712ag(C0710ae aeVar, Object obj) {
        this.f1759b = aeVar;
        this.f1758a = obj;
    }

    public final void run() {
        try {
            new File(this.f1759b.mo3387a(this.f1758a)).delete();
        } catch (Exception e) {
        }
    }
}
