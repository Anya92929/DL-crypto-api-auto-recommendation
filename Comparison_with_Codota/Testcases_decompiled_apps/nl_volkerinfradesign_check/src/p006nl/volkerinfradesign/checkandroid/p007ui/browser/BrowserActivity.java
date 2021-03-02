package p006nl.volkerinfradesign.checkandroid.p007ui.browser;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import p006nl.volkerinfradesign.checkandroid.C1352R;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.browser.BrowserActivity */
public class BrowserActivity extends Activity {

    /* renamed from: a */
    String f5006a = "http://docs.google.com/gview?embedded=true&url=";

    /* renamed from: b */
    String f5007b = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1352R.layout.activity_browser);
        WebView webView = (WebView) findViewById(C1352R.C1354id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new C1546a());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f5007b = extras.getString("url");
            webView.loadUrl(this.f5007b);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.browser.BrowserActivity$a */
    class C1546a extends WebViewClient {
        private C1546a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        public void onPageFinished(WebView webView, String str) {
            if ("".equals(webView.getTitle())) {
                webView.loadUrl(BrowserActivity.this.f5006a + BrowserActivity.this.f5007b);
            }
            super.onPageFinished(webView, str);
        }
    }
}
