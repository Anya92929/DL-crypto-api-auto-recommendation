package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.forexcrunch.forexcrunch.C0089R;

public class WebViewActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: pd */
    public ProgressDialog f67pd;
    /* access modifiers changed from: private */
    public String url;
    /* access modifiers changed from: private */

    /* renamed from: wv */
    public WebView f68wv;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.activity_web_view);
        this.url = getIntent().getExtras().getString("url");
        this.f68wv = (WebView) findViewById(C0089R.idActivityWebView.webview);
        this.f68wv.getSettings().setJavaScriptEnabled(true);
        this.f68wv.setWebViewClient(new CustomWebViewClient(this, (CustomWebViewClient) null));
        new LoadWebView().execute(new String[0]);
    }

    private class CustomWebViewClient extends WebViewClient {
        private CustomWebViewClient() {
        }

        /* synthetic */ CustomWebViewClient(WebViewActivity webViewActivity, CustomWebViewClient customWebViewClient) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView wv, String url) {
            wv.loadUrl(url);
            if (WebViewActivity.this.f67pd == null || WebViewActivity.this.f67pd.isShowing()) {
                return true;
            }
            WebViewActivity.this.f67pd.show();
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            if (WebViewActivity.this.f67pd.isShowing()) {
                WebViewActivity.this.f67pd.dismiss();
            }
        }
    }

    public class LoadWebView extends AsyncTask<String, Void, String> {
        public LoadWebView() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            WebViewActivity.this.f67pd = new ProgressDialog(WebViewActivity.this);
            WebViewActivity.this.f67pd.setMessage(WebViewActivity.this.getString(C0089R.string.loading));
            WebViewActivity.this.f67pd.show();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... params) {
            WebViewActivity.this.f68wv.setWebViewClient(new CustomWebViewClient(WebViewActivity.this, (CustomWebViewClient) null));
            WebViewActivity.this.f68wv.loadUrl(WebViewActivity.this.url);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
        }
    }
}
