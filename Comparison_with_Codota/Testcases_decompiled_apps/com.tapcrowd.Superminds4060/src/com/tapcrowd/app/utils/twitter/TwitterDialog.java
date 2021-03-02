package com.tapcrowd.app.utils.twitter;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Display;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tapcrowd.Superminds4060.C0846R;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterDialog extends Dialog {
    private final float[] DIMENSIONS_LANDSCAPE = {460.0f, 260.0f};
    private final float[] DIMENSIONS_PORTRAIT = {280.0f, 420.0f};
    private final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
    private LinearLayout content;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public OnLoginListener listener;
    /* access modifiers changed from: private */
    public RequestToken requestToken;
    /* access modifiers changed from: private */
    public ProgressDialog spinner;
    /* access modifiers changed from: private */
    public Twitter twitter;
    /* access modifiers changed from: private */
    public String url;
    /* access modifiers changed from: private */
    public WebView webview;

    public interface OnLoginListener {
        void onError();

        void onLogin(Twitter twitter);
    }

    public TwitterDialog(Context context2, OnLoginListener listener2) {
        super(context2, C0846R.style.transparentDialogTheme);
        this.context = context2;
        this.listener = listener2;
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(TwitterConst.CONSUMER_KEY);
        configurationBuilder.setOAuthConsumerSecret(TwitterConst.CONSUMER_SECRET);
        this.twitter = new TwitterFactory(configurationBuilder.build()).getInstance();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.content = new LinearLayout(this.context);
        this.content.setOrientation(1);
        this.spinner = new ProgressDialog(this.context);
        this.spinner.requestWindowFeature(1);
        this.spinner.setMessage(this.context.getString(C0846R.string.loading));
        setUpWebView();
        this.spinner.show();
        new GetUrlTask(this, (GetUrlTask) null).execute(new Void[0]);
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        float scale = getContext().getResources().getDisplayMetrics().density;
        float[] dimensions = display.getWidth() < display.getHeight() ? this.DIMENSIONS_PORTRAIT : this.DIMENSIONS_LANDSCAPE;
        addContentView(this.content, new FrameLayout.LayoutParams((int) ((dimensions[0] * scale) + 0.5f), (int) ((dimensions[1] * scale) + 0.5f)));
    }

    private class GetUrlTask extends AsyncTask<Void, Void, Void> {
        private GetUrlTask() {
        }

        /* synthetic */ GetUrlTask(TwitterDialog twitterDialog, GetUrlTask getUrlTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            try {
                TwitterDialog.this.requestToken = TwitterDialog.this.twitter.getOAuthRequestToken(TwitterConst.CALLBACK_URL);
                TwitterDialog.this.url = TwitterDialog.this.requestToken.getAuthenticationURL();
                return null;
            } catch (Exception e) {
                TwitterDialog.this.dismiss();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            TwitterDialog.this.webview.loadUrl(TwitterDialog.this.url);
        }
    }

    private void setUpWebView() {
        this.webview = new WebView(getContext());
        this.webview.setVerticalScrollBarEnabled(false);
        this.webview.setHorizontalScrollBarEnabled(false);
        this.webview.setWebViewClient(new TwitterWebviewClient(this, (TwitterWebviewClient) null));
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.setLayoutParams(this.FILL);
        this.webview.setVisibility(4);
        this.webview.getSettings().setSavePassword(false);
        this.content.addView(this.webview);
    }

    private class TwitterWebviewClient extends WebViewClient {
        private TwitterWebviewClient() {
        }

        /* synthetic */ TwitterWebviewClient(TwitterDialog twitterDialog, TwitterWebviewClient twitterWebviewClient) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView view, final String url) {
            if (url.startsWith(TwitterConst.CALLBACK_URL)) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            SharedPreferences.Editor e = TwitterDialog.this.context.getSharedPreferences(TwitterConst.PREFERENCE_NAME, 0).edit();
                            AccessToken accessToken = TwitterDialog.this.twitter.getOAuthAccessToken(TwitterDialog.this.requestToken, TwitterDialog.this.parseUrl(url).getString("oauth_verifier"));
                            e.putString("oauth_token", accessToken.getToken());
                            e.putString("oauth_token_secret", accessToken.getTokenSecret());
                            e.commit();
                            if (TwitterDialog.this.listener != null) {
                                TwitterDialog.this.listener.onLogin(TwitterDialog.this.twitter);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            if (TwitterDialog.this.listener != null) {
                                TwitterDialog.this.listener.onError();
                            }
                        }
                    }
                }).start();
                TwitterDialog.this.dismiss();
                return true;
            }
            view.loadUrl(url);
            return false;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            TwitterDialog.this.spinner.show();
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            TwitterDialog.this.webview.setVisibility(0);
            TwitterDialog.this.spinner.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public Bundle parseUrl(String url2) {
        try {
            URL u = new URL(url2.replace("oauth", "http"));
            Bundle b = decodeUrl(u.getQuery());
            b.putAll(decodeUrl(u.getRef()));
            return b;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    private Bundle decodeUrl(String s) {
        Bundle params = new Bundle();
        if (s != null) {
            for (String parameter : s.replace("http", "oauth").split("&")) {
                String[] v = parameter.split("=");
                if (v.length > 1) {
                    params.putString(URLDecoder.decode(v[0]), URLDecoder.decode(v[1]));
                }
            }
        }
        return params;
    }
}
