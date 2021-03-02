package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/* renamed from: org.commonwealthcu.mobile.q */
final class C0638q extends WebViewClient {

    /* renamed from: a */
    private /* synthetic */ BankingView f856a;

    C0638q(BankingView bankingView) {
        this.f856a = bankingView;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f856a.f652f.mo5546b();
        webView.loadUrl("javascript:window.HtmlViewer.showHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
        if (str.indexOf("LOGOFF") > 0) {
            Log.d("BV", "LogOff Detected");
            boolean unused = this.f856a.f655i = true;
            this.f856a.mo5455c();
            Intent intent = new Intent();
            intent.putExtra("EXIT_MESSAGE", "You have successfully logged off.");
            this.f856a.setResult(-1, intent);
            this.f856a.finish();
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f856a.f652f.mo5545a();
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        URI uri;
        if (str.startsWith("pmajaxhandler")) {
            Log.d("BV", "Ajax seen: " + str);
            return true;
        } else if (str != null && str.startsWith("rdc")) {
            if ((this.f856a.f656j && !this.f856a.f657k) || this.f856a.f657k) {
                this.f856a.f652f.mo5545a();
                try {
                    uri = new URI(str);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                    uri = null;
                }
                if (uri != null) {
                    try {
                        Map a = BankingView.m1232a(uri);
                        ((MobileBankingApp) this.f856a.getApplicationContext()).mo5461a(a);
                        String unused = this.f856a.f660n = (String) a.get("member");
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
                if ((this.f856a.f656j && !this.f856a.f657k) || this.f856a.f658l.contains("|" + this.f856a.f660n + "|")) {
                    this.f856a.mo5453b();
                    return true;
                }
            }
            try {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                this.f856a.f652f.mo5546b();
            } catch (Exception e3) {
                if (this.f856a.f659m == null) {
                    String unused2 = this.f856a.f659m = "In order to use this feature you must first download the app.";
                }
                this.f856a.f652f.mo5546b();
                new AlertDialog.Builder(webView.getContext()).setTitle("No Application Found").setMessage(this.f856a.f659m).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
            }
            return true;
        } else if (str == null || str.startsWith("http")) {
            return false;
        } else {
            try {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e4) {
                this.f856a.f652f.mo5546b();
                new AlertDialog.Builder(webView.getContext()).setTitle("No Application Found").setMessage("An application to handle this request was not found.").setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
            }
            return true;
        }
    }
}
