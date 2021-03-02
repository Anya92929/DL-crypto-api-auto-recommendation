package com.tapcrowd.app.utils.facebook;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
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
import com.google.android.gcm.GCMConstants;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.facebook.Facebook;

public class FbDialog extends Dialog {
    static final float[] DIMENSIONS_DIFF_LANDSCAPE = {20.0f, 60.0f};
    static final float[] DIMENSIONS_DIFF_PORTRAIT = {40.0f, 60.0f};
    static final String DISPLAY_STRING = "touch";
    static final int FB_BLUE = -9599820;
    static final String FB_ICON = "icon.png";
    static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
    static final int MARGIN = 4;
    static final int PADDING = 2;
    /* access modifiers changed from: private */
    public FrameLayout mContent;
    /* access modifiers changed from: private */
    public ImageView mCrossImage;
    /* access modifiers changed from: private */
    public Facebook.DialogListener mListener;
    /* access modifiers changed from: private */
    public ProgressDialog mSpinner;
    private String mUrl;
    /* access modifiers changed from: private */
    public WebView mWebView;

    public FbDialog(Context context, String url, Facebook.DialogListener listener) {
        super(context, 16973840);
        this.mUrl = url;
        this.mListener = listener;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mSpinner = new ProgressDialog(getContext());
        this.mSpinner.requestWindowFeature(1);
        this.mSpinner.setMessage("Loading...");
        requestWindowFeature(1);
        this.mContent = new FrameLayout(getContext());
        createCrossImage();
        setUpWebView(this.mCrossImage.getDrawable().getIntrinsicWidth() / 2);
        this.mContent.addView(this.mCrossImage, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.mContent, new ViewGroup.LayoutParams(-1, -1));
    }

    private void createCrossImage() {
        this.mCrossImage = new ImageView(getContext());
        this.mCrossImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FbDialog.this.mListener.onCancel();
                FbDialog.this.dismiss();
            }
        });
        this.mCrossImage.setImageDrawable(getContext().getResources().getDrawable(C0846R.drawable.close));
        this.mCrossImage.setVisibility(4);
    }

    private void setUpWebView(int margin) {
        LinearLayout webViewContainer = new LinearLayout(getContext());
        this.mWebView = new WebView(getContext());
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebViewClient(new FbWebViewClient(this, (FbWebViewClient) null));
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.loadUrl(this.mUrl);
        this.mWebView.setLayoutParams(FILL);
        this.mWebView.setVisibility(4);
        this.mWebView.getSettings().setSavePassword(false);
        webViewContainer.setPadding(margin, margin, margin, margin);
        webViewContainer.addView(this.mWebView);
        this.mContent.addView(webViewContainer);
    }

    private class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        /* synthetic */ FbWebViewClient(FbDialog fbDialog, FbWebViewClient fbWebViewClient) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Util.logd("Facebook-WebView", "Redirect URL: " + url);
            if (url.startsWith(Facebook.REDIRECT_URI)) {
                Bundle values = Util.parseUrl(url);
                String error = values.getString(GCMConstants.EXTRA_ERROR);
                if (error == null) {
                    error = values.getString("error_type");
                }
                if (error == null) {
                    FbDialog.this.mListener.onComplete(values);
                } else if (error.equals("access_denied") || error.equals("OAuthAccessDeniedException")) {
                    FbDialog.this.mListener.onCancel();
                } else {
                    FbDialog.this.mListener.onFacebookError(new FacebookError(error));
                }
                FbDialog.this.dismiss();
                return true;
            } else if (url.startsWith(Facebook.CANCEL_URI)) {
                FbDialog.this.mListener.onCancel();
                FbDialog.this.dismiss();
                return true;
            } else if (url.contains(FbDialog.DISPLAY_STRING)) {
                return false;
            } else {
                FbDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                return true;
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            FbDialog.this.mListener.onError(new DialogError(description, errorCode, failingUrl));
            FbDialog.this.dismiss();
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Util.logd("Facebook-WebView", "Webview loading URL: " + url);
            super.onPageStarted(view, url, favicon);
            FbDialog.this.mSpinner.show();
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            FbDialog.this.mSpinner.dismiss();
            FbDialog.this.mContent.setBackgroundColor(0);
            FbDialog.this.mWebView.setVisibility(0);
            FbDialog.this.mCrossImage.setVisibility(0);
        }
    }
}
