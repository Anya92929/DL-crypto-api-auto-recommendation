package cmn;

import java.io.File;
import java.util.Comparator;
import java.util.Map;

/* renamed from: cmn.ah */
final class C0713ah implements Comparator {

    /* renamed from: a */
    final /* synthetic */ Map f1760a;

    /* renamed from: b */
    final /* synthetic */ C0710ae f1761b;

    C0713ah(C0710ae aeVar, Map map) {
        this.f1761b = aeVar;
        this.f1760a = map;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Long) this.f1760a.get((File) obj)).compareTo((Long) this.f1760a.get((File) obj2));
    }
}
