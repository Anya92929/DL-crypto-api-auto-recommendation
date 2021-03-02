package com.google.ads.util;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.AdActivity;
import com.google.ads.C0265m;
import com.google.ads.C0272n;
import com.google.ads.C0273o;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0238c;
import com.google.ads.internal.C0247d;
import com.google.ads.internal.C0254i;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@TargetApi(11)
/* renamed from: com.google.ads.util.g */
public class C0293g {

    /* renamed from: com.google.ads.util.g$b */
    public static class C0302b extends C0254i {
        public C0302b(C0247d dVar, Map<String, C0273o> map, boolean z, boolean z2) {
            super(dVar, map, z, z2);
        }

        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            try {
                if ("mraid.js".equalsIgnoreCase(new File(url).getName())) {
                    C0238c k = this.f589a.mo3552k();
                    if (k != null) {
                        k.mo3504c(true);
                    } else {
                        this.f589a.mo3537a(true);
                    }
                    C0265m.C0266a a = this.f589a.mo3550i().f657d.mo3725a().f616b.mo3725a();
                    if (this.f589a.mo3550i().mo3684b()) {
                        String a2 = a.f624g.mo3726a();
                        C0284b.m480a("shouldInterceptRequest(" + a2 + ")");
                        return m509a(a2, view.getContext());
                    } else if (this.f590b) {
                        String a3 = a.f623f.mo3726a();
                        C0284b.m480a("shouldInterceptRequest(" + a3 + ")");
                        return m509a(a3, view.getContext());
                    } else {
                        String a4 = a.f622e.mo3726a();
                        C0284b.m480a("shouldInterceptRequest(" + a4 + ")");
                        return m509a(a4, view.getContext());
                    }
                }
            } catch (IOException e) {
                C0284b.m489d("IOException fetching MRAID JS.", e);
            } catch (Throwable th) {
                C0284b.m489d("An unknown error occurred fetching MRAID JS.", th);
            }
            return super.shouldInterceptRequest(view, url);
        }

        /* renamed from: a */
        private static WebResourceResponse m509a(String str, Context context) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                AdUtil.m447a(httpURLConnection, context.getApplicationContext());
                httpURLConnection.connect();
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(AdUtil.m442a((Readable) new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
            } finally {
                httpURLConnection.disconnect();
            }
        }
    }

    /* renamed from: com.google.ads.util.g$a */
    public static class C0295a extends WebChromeClient {

        /* renamed from: a */
        private final C0272n f731a;

        public C0295a(C0272n nVar) {
            this.f731a = nVar;
        }

        public void onCloseWindow(WebView webView) {
            if (webView instanceof AdWebView) {
                ((AdWebView) webView).mo3456f();
            }
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
            switch (C02941.f730a[consoleMessage.messageLevel().ordinal()]) {
                case 1:
                    C0284b.m484b(str);
                    break;
                case 2:
                    C0284b.m490e(str);
                    break;
                case 3:
                case 4:
                    C0284b.m486c(str);
                    break;
                case 5:
                    C0284b.m480a(str);
                    break;
            }
            return super.onConsoleMessage(consoleMessage);
        }

        public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
            C0265m.C0266a a = this.f731a.f657d.mo3725a().f616b.mo3725a();
            long longValue = a.f629l.mo3726a().longValue() - totalUsedQuota;
            if (longValue <= 0) {
                quotaUpdater.updateQuota(currentQuota);
                return;
            }
            if (currentQuota == 0) {
                if (estimatedSize > longValue || estimatedSize > a.f630m.mo3726a().longValue()) {
                    estimatedSize = 0;
                }
            } else if (estimatedSize == 0) {
                estimatedSize = Math.min(Math.min(a.f631n.mo3726a().longValue(), longValue) + currentQuota, a.f630m.mo3726a().longValue());
            } else {
                if (estimatedSize <= Math.min(a.f630m.mo3726a().longValue() - currentQuota, longValue)) {
                    currentQuota += estimatedSize;
                }
                estimatedSize = currentQuota;
            }
            quotaUpdater.updateQuota(estimatedSize);
        }

        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return m508a(view, url, message, (String) null, result, (JsPromptResult) null, false);
        }

        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            return m508a(view, url, message, (String) null, result, (JsPromptResult) null, false);
        }

        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return m508a(view, url, message, (String) null, result, (JsPromptResult) null, false);
        }

        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return m508a(view, url, message, defaultValue, (JsResult) null, result, true);
        }

        public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
            C0265m.C0266a a = this.f731a.f657d.mo3725a().f616b.mo3725a();
            long longValue = a.f627j.mo3726a().longValue() + spaceNeeded;
            if (a.f628k.mo3726a().longValue() - totalUsedQuota < longValue) {
                quotaUpdater.updateQuota(0);
            } else {
                quotaUpdater.updateQuota(longValue);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            callback.onCustomViewHidden();
        }

        /* renamed from: a */
        private static boolean m508a(WebView webView, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
            AdActivity i;
            if (!(webView instanceof AdWebView) || (i = ((AdWebView) webView).mo3459i()) == null) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(i);
            builder.setTitle(str);
            if (z) {
                m506a(builder, i, str2, str3, jsPromptResult);
            } else {
                m507a(builder, str2, jsResult);
            }
            return true;
        }

        /* renamed from: a */
        private static void m507a(AlertDialog.Builder builder, String str, final JsResult jsResult) {
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
        private static void m506a(AlertDialog.Builder builder, Context context, String str, String str2, final JsPromptResult jsPromptResult) {
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
    }

    /* renamed from: com.google.ads.util.g$1 */
    static /* synthetic */ class C02941 {

        /* renamed from: a */
        static final /* synthetic */ int[] f730a = new int[ConsoleMessage.MessageLevel.values().length];

        static {
            try {
                f730a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f730a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f730a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f730a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f730a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: a */
    public static void m504a(WebSettings webSettings, C0272n nVar) {
        Context a = nVar.f659f.mo3725a();
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCacheMaxSize(nVar.f657d.mo3725a().f616b.mo3725a().f626i.mo3726a().longValue());
        webSettings.setAppCachePath(new File(a.getCacheDir(), "admob").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDatabasePath(a.getDatabasePath("admob").getAbsolutePath());
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
    }

    /* renamed from: a */
    public static void m502a(View view) {
        view.setLayerType(1, (Paint) null);
    }

    /* renamed from: b */
    public static void m505b(View view) {
        view.setLayerType(0, (Paint) null);
    }

    /* renamed from: a */
    public static void m503a(Window window) {
        window.setFlags(16777216, 16777216);
    }
}
