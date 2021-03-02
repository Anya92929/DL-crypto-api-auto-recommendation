package cmn;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/* renamed from: cmn.af */
final class C0711af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Object f1755a;

    /* renamed from: b */
    final /* synthetic */ C0708ac f1756b;

    /* renamed from: c */
    final /* synthetic */ C0710ae f1757c;

    C0711af(C0710ae aeVar, Object obj, C0708ac acVar) {
        this.f1757c = aeVar;
        this.f1755a = obj;
        this.f1756b = acVar;
    }

    public final void run() {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(this.f1757c.mo3387a(this.f1755a)));
            if (!objectInputStream.readObject().equals(this.f1755a)) {
                this.f1756b.mo3385a((Object) null);
                objectInputStream.close();
                return;
            }
            long readLong = objectInputStream.readLong();
            if (this.f1757c.f1751c <= 0 || readLong >= System.currentTimeMillis() - (86400000 * ((long) this.f1757c.f1751c))) {
                Object readObject = objectInputStream.readObject();
                new StringBuilder("Diskcache hit saved ").append(new File(this.f1757c.mo3387a(this.f1755a)).length()).append(" bytes for ").append(this.f1755a);
                this.f1756b.mo3385a(readObject);
                objectInputStream.close();
                return;
            }
            this.f1757c.mo3390b(this.f1755a);
            this.f1756b.mo3385a((Object) null);
            objectInputStream.close();
        } catch (Exception e) {
            this.f1756b.mo3385a((Object) null);
        } catch (Throwable th) {
            objectInputStream.close();
            throw th;
        }
    }
}
