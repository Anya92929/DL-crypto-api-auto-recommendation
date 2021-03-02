package com.google.zxing.client.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public final class HelpActivity extends Activity {
    private static final String BASE_URL = ("file:///android_asset/html-" + LocaleManager.getTranslatedAssetLanguage() + '/');
    private WebView webView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(C0776R.layout.help);
        this.webView = (WebView) findViewById(C0776R.C0777id.help_contents);
        if (icicle == null) {
            this.webView.loadUrl(String.valueOf(BASE_URL) + "index.html");
        } else {
            this.webView.restoreState(icicle);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle state) {
        String url = this.webView.getUrl();
        if (url != null && !url.isEmpty()) {
            this.webView.saveState(state);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.webView.canGoBack()) {
            return super.onKeyDown(keyCode, event);
        }
        this.webView.goBack();
        return true;
    }
}
