package cmn;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;

@TargetApi(18)
/* renamed from: cmn.i */
public class C0747i extends C0746h {
    /* renamed from: b */
    public final int mo3379b() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (int) Math.min((statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / 1024, 2147483647L);
        } catch (Throwable th) {
            return -1;
        }
    }
}
