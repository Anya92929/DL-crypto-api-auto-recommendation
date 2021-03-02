package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.google.android.gms.internal.cs */
public class C0351cs extends WebChromeClient {

    /* renamed from: fG */
    private final C0347cq f1039fG;

    /* renamed from: com.google.android.gms.internal.cs$7 */
    static /* synthetic */ class C03587 {

        /* renamed from: il */
        static final /* synthetic */ int[] f1047il = new int[ConsoleMessage.MessageLevel.values().length];

        static {
            try {
                f1047il[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1047il[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1047il[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1047il[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1047il[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public C0351cs(C0347cq cqVar) {
        this.f1039fG = cqVar;
    }

    /* renamed from: a */
    private static void m771a(AlertDialog.Builder builder, String str, final JsResult jsResult) {
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
    private static void m772a(Context context, AlertDialog.Builder builder, String str, String str2, final JsPromptResult jsPromptResult) {
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

    /* renamed from: a */
    private static boolean m773a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        if (z) {
            m772a(context, builder, str2, str3, jsPromptResult);
            return true;
        }
        m771a(builder, str2, jsResult);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo4235a(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        C0280bf au = this.f1039fG.mo4210au();
        if (au == null) {
            C0344cn.m737q("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        au.mo4099a(view, customViewCallback);
        au.setRequestedOrientation(i);
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof C0347cq)) {
            C0344cn.m737q("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        C0280bf au = ((C0347cq) webView).mo4210au();
        if (au == null) {
            C0344cn.m737q("Tried to close an AdWebView not associated with an overlay.");
        } else {
            au.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        switch (C03587.f1047il[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                C0344cn.m734n(str);
                break;
            case 2:
                C0344cn.m737q(str);
                break;
            case 3:
            case 4:
                C0344cn.m735o(str);
                break;
            case 5:
                C0344cn.m733m(str);
                break;
            default:
                C0344cn.m735o(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
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
        C0280bf au = this.f1039fG.mo4210au();
        if (au == null) {
            C0344cn.m737q("Could not get ad overlay when hiding custom view.");
        } else {
            au.mo4097R();
        }
    }

    public final boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
        return m773a(webView.getContext(), url, message, (String) null, result, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String url, String message, JsResult result) {
        return m773a(webView.getContext(), url, message, (String) null, result, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String url, String message, JsResult result) {
        return m773a(webView.getContext(), url, message, (String) null, result, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String url, String message, String defaultValue, JsPromptResult result) {
        return m773a(webView.getContext(), url, message, defaultValue, (JsResult) null, result, true);
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
        mo4235a(view, -1, customViewCallback);
    }
}
