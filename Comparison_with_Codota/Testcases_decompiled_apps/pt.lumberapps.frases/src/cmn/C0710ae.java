package cmn;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: cmn.ae */
public final class C0710ae {

    /* renamed from: a */
    private int f1749a;

    /* renamed from: b */
    private int f1750b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f1751c;

    /* renamed from: d */
    private File f1752d;

    /* renamed from: e */
    private ExecutorService f1753e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f1754f;

    /* renamed from: b */
    static /* synthetic */ int m3190b(C0710ae aeVar) {
        int i = aeVar.f1754f;
        aeVar.f1754f = i - 1;
        return i;
    }

    /* renamed from: e */
    static /* synthetic */ void m3193e(C0710ae aeVar) {
        File[] listFiles = aeVar.f1752d.listFiles();
        if (listFiles != null) {
            HashMap hashMap = new HashMap();
            ArrayList<File> arrayList = new ArrayList<>(Arrays.asList(listFiles));
            long j = 0;
            for (File file : arrayList) {
                j += file.length();
                hashMap.put(file, Long.valueOf(file.lastModified()));
            }
            int size = arrayList.size();
            Collections.sort(arrayList, new C0713ah(aeVar, hashMap));
            int i = 0;
            while (i < size) {
                if (j > ((long) aeVar.f1750b) || (aeVar.f1749a > 0 && size - i > aeVar.f1749a - 10)) {
                    j -= ((File) arrayList.get(i)).length();
                    ((File) arrayList.get(i)).delete();
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public final int mo3386a() {
        return this.f1750b;
    }

    /* renamed from: a */
    public final String mo3387a(Object obj) {
        return new File(this.f1752d, new StringBuilder().append(obj.hashCode()).toString()).getAbsolutePath();
    }

    /* renamed from: a */
    public final void mo3388a(Object obj, C0708ac acVar) {
        this.f1753e.execute(new C0711af(this, obj, acVar));
    }

    /* renamed from: a */
    public final void mo3389a(Object obj, Object obj2) {
        this.f1753e.execute(new C0714ai(this, obj, obj2));
    }

    /* renamed from: b */
    public final void mo3390b(Object obj) {
        this.f1753e.execute(new C0712ag(this, obj));
    }
}
