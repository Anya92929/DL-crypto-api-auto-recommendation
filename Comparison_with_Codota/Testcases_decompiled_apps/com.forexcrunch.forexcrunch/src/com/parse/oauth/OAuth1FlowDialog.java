package com.parse.oauth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class OAuth1FlowDialog extends Dialog {
    private static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
    /* access modifiers changed from: private */
    public final String callbackUrl;
    /* access modifiers changed from: private */
    public ImageView closeImage;
    /* access modifiers changed from: private */
    public FrameLayout content;
    /* access modifiers changed from: private */
    public final FlowResultHandler handler;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    private final String requestUrl;
    /* access modifiers changed from: private */
    public final String serviceUrlIdentifier;
    /* access modifiers changed from: private */
    public WebView webView;

    public interface FlowResultHandler {
        void onCancel();

        void onComplete(String str);

        void onError(int i, String str, String str2);
    }

    public OAuth1FlowDialog(Context context, String requestUrl2, String callbackUrl2, String serviceUrlIdentifier2, FlowResultHandler resultHandler) {
        super(context, 16973840);
        this.requestUrl = requestUrl2;
        this.callbackUrl = callbackUrl2;
        this.serviceUrlIdentifier = serviceUrlIdentifier2;
        this.handler = resultHandler;
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                OAuth1FlowDialog.this.handler.onCancel();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.progressDialog = new ProgressDialog(getContext());
        this.progressDialog.requestWindowFeature(1);
        this.progressDialog.setMessage("Loading...");
        requestWindowFeature(1);
        this.content = new FrameLayout(getContext());
        createCloseImage();
        setUpWebView(this.closeImage.getDrawable().getIntrinsicWidth() / 2);
        this.content.addView(this.closeImage, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.content, new ViewGroup.LayoutParams(-1, -1));
    }

    private void createCloseImage() {
        this.closeImage = new ImageView(getContext());
        this.closeImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OAuth1FlowDialog.this.cancel();
            }
        });
        this.closeImage.setImageDrawable(getContext().getResources().getDrawable(17301527));
        this.closeImage.setVisibility(4);
    }

    private void setUpWebView(int margin) {
        LinearLayout webViewContainer = new LinearLayout(getContext());
        this.webView = new WebView(getContext());
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new OAuth1WebViewClient(this, (OAuth1WebViewClient) null));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(this.requestUrl);
        this.webView.setLayoutParams(FILL);
        this.webView.setVisibility(4);
        webViewContainer.setPadding(margin, margin, margin, margin);
        webViewContainer.addView(this.webView);
        this.content.addView(webViewContainer);
    }

    private class OAuth1WebViewClient extends WebViewClient {
        private OAuth1WebViewClient() {
        }

        /* synthetic */ OAuth1WebViewClient(OAuth1FlowDialog oAuth1FlowDialog, OAuth1WebViewClient oAuth1WebViewClient) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith(OAuth1FlowDialog.this.callbackUrl)) {
                OAuth1FlowDialog.this.dismiss();
                OAuth1FlowDialog.this.handler.onComplete(url);
                return true;
            } else if (url.contains(OAuth1FlowDialog.this.serviceUrlIdentifier)) {
                return false;
            } else {
                OAuth1FlowDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                return true;
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            OAuth1FlowDialog.this.dismiss();
            OAuth1FlowDialog.this.handler.onError(errorCode, description, failingUrl);
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            OAuth1FlowDialog.this.progressDialog.show();
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            try {
                OAuth1FlowDialog.this.progressDialog.dismiss();
            } catch (IllegalArgumentException e) {
            }
            OAuth1FlowDialog.this.content.setBackgroundColor(0);
            OAuth1FlowDialog.this.webView.setVisibility(0);
            OAuth1FlowDialog.this.closeImage.setVisibility(0);
        }
    }
}
