package cmn;

import android.app.Activity;
import android.webkit.WebView;

/* renamed from: cmn.b */
public final class C0732b {
    /* renamed from: a */
    public static void m3247a(Activity activity, WebView webView, Runnable runnable) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.addJavascriptInterface(new C0741c(activity, runnable), "appbrain");
    }
}
