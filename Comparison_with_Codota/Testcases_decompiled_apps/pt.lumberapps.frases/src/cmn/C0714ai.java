package cmn;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/* renamed from: cmn.ai */
final class C0714ai implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Object f1762a;

    /* renamed from: b */
    final /* synthetic */ Object f1763b;

    /* renamed from: c */
    final /* synthetic */ C0710ae f1764c;

    C0714ai(C0710ae aeVar, Object obj, Object obj2) {
        this.f1764c = aeVar;
        this.f1762a = obj;
        this.f1763b = obj2;
    }

    public final void run() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f1764c.mo3387a(this.f1762a)));
            objectOutputStream.writeObject(this.f1762a);
            objectOutputStream.writeLong(System.currentTimeMillis());
            objectOutputStream.writeObject(this.f1763b);
            objectOutputStream.close();
        } catch (Exception e) {
        }
        C0710ae.m3190b(this.f1764c);
        if (this.f1764c.f1754f <= 0) {
            int unused = this.f1764c.f1754f = 10;
            C0710ae.m3193e(this.f1764c);
        }
    }
}
