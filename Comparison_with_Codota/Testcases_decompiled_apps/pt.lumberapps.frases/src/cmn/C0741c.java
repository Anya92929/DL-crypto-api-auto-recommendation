package cmn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import cmn.Proguard;
import com.appbrain.KeepClass;

/* renamed from: cmn.c */
final class C0741c implements Proguard.KeepMembers, KeepClass {

    /* renamed from: a */
    private final Activity f1827a;

    /* renamed from: b */
    private final Runnable f1828b;

    public C0741c(Activity activity, Runnable runnable) {
        this.f1827a = activity;
        this.f1828b = runnable;
    }

    @JavascriptInterface
    public final void close() {
        this.f1827a.runOnUiThread(this.f1828b);
    }

    @JavascriptInterface
    public final int getVersion() {
        return 1;
    }

    @JavascriptInterface
    public final boolean isPackageInstalled(String str) {
        return C0749k.m3268a((Context) this.f1827a, str);
    }

    @JavascriptInterface
    public final void sendMail(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("mailto:" + str));
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.TEXT", str3);
        this.f1827a.startActivity(intent);
    }
}
