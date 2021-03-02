package cmn;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebSettings;

@TargetApi(17)
/* renamed from: cmn.h */
public class C0746h extends C0745g {
    /* renamed from: b */
    public final String mo3380b(Context context) {
        try {
            return WebSettings.getDefaultUserAgent(context);
        } catch (Throwable th) {
            return super.mo3380b(context);
        }
    }

    /* renamed from: c */
    public final int mo3381c() {
        return Runtime.getRuntime().availableProcessors();
    }
}
