package cmn;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* renamed from: cmn.aa */
public final class C0706aa implements C0764z {

    /* renamed from: a */
    private final LinkedHashMap f1745a = new C0707ab(this, ((int) Math.ceil(133.3333282470703d)) + 1);

    /* renamed from: a */
    public final Object mo3382a(Object obj) {
        SoftReference softReference = (SoftReference) this.f1745a.get(obj);
        if (softReference == null) {
            return null;
        }
        Object obj2 = softReference.get();
        if (obj2 != null) {
            return obj2;
        }
        this.f1745a.remove(obj);
        return obj2;
    }

    /* renamed from: a */
    public final void mo3383a(Object obj, Object obj2) {
        if (obj2 == null) {
            this.f1745a.put(obj, (Object) null);
        } else {
            this.f1745a.put(obj, new SoftReference(obj2));
        }
    }
}
