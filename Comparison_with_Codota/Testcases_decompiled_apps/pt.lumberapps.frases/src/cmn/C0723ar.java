package cmn;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: cmn.ar */
final class C0723ar extends LinkedHashMap {
    C0723ar() {
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry entry) {
        return size() > 100;
    }
}
