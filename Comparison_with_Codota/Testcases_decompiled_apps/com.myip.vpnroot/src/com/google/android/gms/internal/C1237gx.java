package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

@C1130ez
/* renamed from: com.google.android.gms.internal.gx */
public class C1237gx extends WebChromeClient {

    /* renamed from: md */
    private final C1232gv f3811md;

    /* renamed from: com.google.android.gms.internal.gx$7 */
    static /* synthetic */ class C12447 {

        /* renamed from: xb */
        static final /* synthetic */ int[] f3819xb = new int[ConsoleMessage.MessageLevel.values().length];

        static {
            try {
                f3819xb[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3819xb[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3819xb[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3819xb[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3819xb[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public C1237gx(C1232gv gvVar) {
        this.f3811md = gvVar;
    }

    /* renamed from: a */
    private static void m4730a(AlertDialog.Builder builder, String str, final JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jsResult.confirm();
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jsResult.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                jsResult.cancel();
            }
        }).create().show();
    }

    /* renamed from: a */
    private static void m4731a(Context context, AlertDialog.Builder builder, String str, String str2, final JsPromptResult jsPromptResult) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(str);
        final EditText editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jsPromptResult.confirm(editText.getText().toString());
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jsPromptResult.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                jsPromptResult.cancel();
            }
        }).create().show();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo8666a(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        C1056dk du = this.f3811md.mo8630du();
        if (du == null) {
            C1229gs.m4679W("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        du.mo8307a(view, customViewCallback);
        du.setRequestedOrientation(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8667a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str);
            if (z) {
                m4731a(context, builder, str2, str3, jsPromptResult);
                return true;
            }
            m4730a(builder, str2, jsResult);
            return true;
        } catch (WindowManager.BadTokenException e) {
            C1229gs.m4683d("Fail to display Dialog.", e);
            return true;
        }
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof C1232gv)) {
            C1229gs.m4679W("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        C1056dk du = ((C1232gv) webView).mo8630du();
        if (du == null) {
            C1229gs.m4679W("Tried to close an AdWebView not associated with an overlay.");
        } else {
            du.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C12447.f3819xb[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                C1229gs.m4676T(str);
                break;
            case 2:
                C1229gs.m4679W(str);
                break;
            case 3:
            case 4:
                C1229gs.m4677U(str);
                break;
            case 5:
                C1229gs.m4675S(str);
                break;
            default:
                C1229gs.m4677U(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        WebView webView = new WebView(view.getContext());
        webView.setWebViewClient(this.f3811md.mo8631dv());
        ((WebView.WebViewTransport) resultMsg.obj).setWebView(webView);
        resultMsg.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        long j = 5242880 - totalUsedQuota;
        if (j <= 0) {
            quotaUpdater.updateQuota(currentQuota);
            return;
        }
        if (currentQuota == 0) {
            if (estimatedSize > j || estimatedSize > 1048576) {
                estimatedSize = 0;
            }
        } else if (estimatedSize == 0) {
            estimatedSize = Math.min(Math.min(131072, j) + currentQuota, 1048576);
        } else {
            if (estimatedSize <= Math.min(1048576 - currentQuota, j)) {
                currentQuota += estimatedSize;
            }
            estimatedSize = currentQuota;
        }
        quotaUpdater.updateQuota(estimatedSize);
    }

    public final void onHideCustomView() {
        C1056dk du = this.f3811md.mo8630du();
        if (du == null) {
            C1229gs.m4679W("Could not get ad overlay when hiding custom view.");
        } else {
            du.mo8310bX();
        }
    }

    public final boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
        Context context = webView.getContext();
        if ((webView instanceof C1232gv) && ((C1232gv) webView).mo8628dA() != null) {
            context = ((C1232gv) webView).mo8628dA();
        }
        return mo8667a(context, url, message, (String) null, result, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String url, String message, JsResult result) {
        return mo8667a(webView.getContext(), url, message, (String) null, result, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String url, String message, JsResult result) {
        return mo8667a(webView.getContext(), url, message, (String) null, result, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String url, String message, String defaultValue, JsPromptResult result) {
        return mo8667a(webView.getContext(), url, message, defaultValue, (JsResult) null, result, true);
    }

    public final void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        long j = 131072 + spaceNeeded;
        if (5242880 - totalUsedQuota < j) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        mo8666a(view, -1, customViewCallback);
    }
}
