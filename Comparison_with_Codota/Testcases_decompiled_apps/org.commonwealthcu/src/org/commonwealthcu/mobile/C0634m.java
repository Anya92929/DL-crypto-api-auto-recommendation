package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.content.Intent;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* renamed from: org.commonwealthcu.mobile.m */
final class C0634m extends WebChromeClient {

    /* renamed from: a */
    private /* synthetic */ BankingView f852a;

    C0634m(BankingView bankingView) {
        this.f852a = bankingView;
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (str2.contains("logged") || str2.contains("Error contacting host") || str2.contains("Challenge Response") || str2.contains("Security Code")) {
            boolean unused = this.f852a.f655i = true;
            this.f852a.mo5455c();
            Intent intent = new Intent();
            intent.putExtra("EXIT_MESSAGE", str2);
            this.f852a.setResult(-1, intent);
            jsResult.confirm();
            this.f852a.finish();
        } else {
            new AlertDialog.Builder(webView.getContext()).setMessage(str2).setPositiveButton("OK", new C0635n(this, jsResult)).setCancelable(false).show();
        }
        return true;
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        String str3 = "Confirmation";
        if (str2.contains("transfer")) {
            str3 = "Transfer Confirmation";
        }
        if (str2.contains("Pay")) {
            str3 = "Payment Confirmation";
        }
        if (str2.contains("deposit")) {
            str3 = "Deposit Confirmation";
        }
        new AlertDialog.Builder(webView.getContext()).setTitle(str3).setMessage(str2).setPositiveButton(17039370, new C0637p(this, jsResult)).setNegativeButton("Cancel", new C0636o(this, jsResult)).setCancelable(false).create().show();
        return true;
    }
}
