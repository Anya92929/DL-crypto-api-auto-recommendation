package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzu;

@TargetApi(11)
@zzin
public class zzlo extends WebChromeClient {

    /* renamed from: a */
    private final zzlh f6751a;

    public zzlo(zzlh zzlh) {
        this.f6751a = zzlh;
    }

    /* renamed from: a */
    private final Context m7374a(WebView webView) {
        if (!(webView instanceof zzlh)) {
            return webView.getContext();
        }
        zzlh zzlh = (zzlh) webView;
        Activity zzue = zzlh.zzue();
        return zzue == null ? zzlh.getContext() : zzue;
    }

    /* renamed from: a */
    private static void m7375a(AlertDialog.Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C1770nk(jsResult)).setNegativeButton(17039360, new C1769nj(jsResult)).setOnCancelListener(new C1768ni(jsResult)).create().show();
    }

    /* renamed from: a */
    private static void m7376a(Context context, AlertDialog.Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(str);
        EditText editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C1773nn(jsPromptResult, editText)).setNegativeButton(17039360, new C1772nm(jsPromptResult)).setOnCancelListener(new C1771nl(jsPromptResult)).create().show();
    }

    /* renamed from: a */
    private final boolean m7377a() {
        return zzu.zzfq().zza(this.f6751a.getContext().getPackageManager(), this.f6751a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || zzu.zzfq().zza(this.f6751a.getContext().getPackageManager(), this.f6751a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo8864a(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zzd zzuh = this.f6751a.zzuh();
        if (zzuh == null) {
            zzkd.zzcx("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzuh.zza(view, customViewCallback);
        zzuh.setRequestedOrientation(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8865a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str);
            if (z) {
                m7376a(context, builder, str2, str3, jsPromptResult);
                return true;
            }
            m7375a(builder, str2, jsResult);
            return true;
        } catch (WindowManager.BadTokenException e) {
            zzkd.zzd("Fail to display Dialog.", e);
            return true;
        }
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzlh)) {
            zzkd.zzcx("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzd zzuh = ((zzlh) webView).zzuh();
        if (zzuh == null) {
            zzkd.zzcx("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzuh.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String valueOf = String.valueOf(consoleMessage.message());
        String valueOf2 = String.valueOf(consoleMessage.sourceId());
        String sb = new StringBuilder(String.valueOf(valueOf).length() + 19 + String.valueOf(valueOf2).length()).append("JS: ").append(valueOf).append(" (").append(valueOf2).append(":").append(consoleMessage.lineNumber()).append(")").toString();
        if (sb.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C1774no.f5398a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                zzkd.m5769e(sb);
                break;
            case 2:
                zzkd.zzcx(sb);
                break;
            case 3:
            case 4:
                zzkd.zzcw(sb);
                break;
            case 5:
                zzkd.zzcv(sb);
                break;
            default:
                zzkd.zzcw(sb);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.f6751a.zzuj());
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072, j4) + j, 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (callback != null) {
            callback.invoke(str, m7377a(), true);
        }
    }

    public final void onHideCustomView() {
        zzd zzuh = this.f6751a.zzuh();
        if (zzuh == null) {
            zzkd.zzcx("Could not get ad overlay when hiding custom view.");
        } else {
            zzuh.zznu();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return mo8865a(m7374a(webView), str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return mo8865a(m7374a(webView), str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return mo8865a(m7374a(webView), str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return mo8865a(m7374a(webView), str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        mo8864a(view, -1, customViewCallback);
    }
}
