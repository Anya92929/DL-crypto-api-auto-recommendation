package cmn;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* renamed from: cmn.l */
final class C0750l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f1831a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f1832b;

    C0750l(Context context, CountDownLatch countDownLatch) {
        this.f1831a = context;
        this.f1832b = countDownLatch;
    }

    public final void run() {
        List<PackageInfo> emptyList;
        try {
            if (!C0749k.f1830b) {
                boolean unused = C0749k.f1830b = false;
                this.f1832b.countDown();
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            emptyList = this.f1831a.getPackageManager().getInstalledPackages(0);
            if (!emptyList.isEmpty() || C0749k.f1829a.get() == null) {
                C0751m mVar = new C0751m((byte) 0);
                mVar.f1833a = Collections.unmodifiableList(emptyList);
                mVar.f1834b = elapsedRealtime;
                C0749k.f1829a.set(mVar);
            }
            boolean unused2 = C0749k.f1830b = false;
            this.f1832b.countDown();
        } catch (Throwable th) {
            boolean unused3 = C0749k.f1830b = false;
            this.f1832b.countDown();
            throw th;
        }
    }
}
