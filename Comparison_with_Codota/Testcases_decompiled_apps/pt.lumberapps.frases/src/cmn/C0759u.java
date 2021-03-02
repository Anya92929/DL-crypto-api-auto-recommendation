package cmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: cmn.u */
public class C0759u {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f1873a = C0759u.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map f1874b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0710ae f1875c;

    /* renamed from: a */
    public final void mo3448a(String str, C0708ac acVar) {
        boolean z;
        synchronized (this.f1874b) {
            List list = (List) this.f1874b.get(str);
            if (list != null) {
                list.add(acVar);
                z = true;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(acVar);
                this.f1874b.put(str, arrayList);
                z = false;
            }
            if (!z) {
                new C0760v(this, str).mo3410a((Object[]) new Void[]{null});
            }
        }
    }
}
