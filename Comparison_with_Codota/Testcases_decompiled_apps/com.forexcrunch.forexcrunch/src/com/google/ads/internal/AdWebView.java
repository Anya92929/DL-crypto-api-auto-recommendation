package com.google.ads.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.C0190ak;
import com.google.ads.C0272n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import com.google.ads.util.C0293g;
import com.google.ads.util.C0303h;
import com.google.ads.util.IcsUtil;
import java.lang.ref.WeakReference;

public class AdWebView extends WebView {

    /* renamed from: a */
    protected final C0272n f466a;

    /* renamed from: b */
    private WeakReference<AdActivity> f467b = null;

    /* renamed from: c */
    private AdSize f468c;

    /* renamed from: d */
    private boolean f469d = false;

    /* renamed from: e */
    private boolean f470e = false;

    /* renamed from: f */
    private boolean f471f = false;

    public AdWebView(C0272n slotState, AdSize adSize) {
        super(slotState.f659f.mo3725a());
        this.f466a = slotState;
        this.f468c = adSize;
        setBackgroundColor(0);
        AdUtil.m446a((WebView) this);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(url), mimeType);
                    AdActivity i = AdWebView.this.mo3459i();
                    if (i != null && AdUtil.m451a(intent, (Context) i)) {
                        i.startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    C0284b.m480a("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
                } catch (Throwable th) {
                    C0284b.m485b("Unknown error trying to start activity to view URL: " + url, th);
                }
            }
        });
        if (AdUtil.f690a >= 17) {
            C0303h.m510a(settings, slotState);
        } else if (AdUtil.f690a >= 11) {
            C0293g.m504a(settings, slotState);
        }
        setScrollBarStyle(33554432);
        if (AdUtil.f690a >= 14) {
            setWebChromeClient(new IcsUtil.C0281a(slotState));
        } else if (AdUtil.f690a >= 11) {
            setWebChromeClient(new C0293g.C0295a(slotState));
        }
    }

    /* renamed from: f */
    public void mo3456f() {
        AdActivity i = mo3459i();
        if (i != null) {
            i.finish();
        }
    }

    /* renamed from: g */
    public void mo3457g() {
        if (AdUtil.f690a >= 11) {
            C0293g.m502a((View) this);
        }
        this.f470e = true;
    }

    /* renamed from: h */
    public void mo3458h() {
        if (this.f470e && AdUtil.f690a >= 11) {
            C0293g.m505b(this);
        }
        this.f470e = false;
    }

    /* renamed from: i */
    public AdActivity mo3459i() {
        if (this.f467b != null) {
            return (AdActivity) this.f467b.get();
        }
        return null;
    }

    /* renamed from: j */
    public boolean mo3460j() {
        return this.f471f;
    }

    /* renamed from: k */
    public boolean mo3461k() {
        return this.f470e;
    }

    public void setAdActivity(AdActivity adActivity) {
        this.f467b = new WeakReference<>(adActivity);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        try {
            super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        } catch (Throwable th) {
            C0284b.m489d("An error occurred while loading data in AdWebView:", th);
        }
    }

    public void loadUrl(String url) {
        try {
            super.loadUrl(url);
        } catch (Throwable th) {
            C0284b.m489d("An error occurred while loading a URL in AdWebView:", th);
        }
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Throwable th) {
            C0284b.m489d("An error occurred while stopping loading in AdWebView:", th);
        }
    }

    public void destroy() {
        try {
            super.destroy();
        } catch (Throwable th) {
            C0284b.m489d("An error occurred while destroying an AdWebView:", th);
        }
        try {
            setWebViewClient(new WebViewClient());
        } catch (Throwable th2) {
        }
    }

    public synchronized void setAdSize(AdSize adSize) {
        this.f468c = adSize;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2 = Integer.MAX_VALUE;
        synchronized (this) {
            if (isInEditMode()) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else if (this.f468c == null || this.f469d) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else {
                int mode = View.MeasureSpec.getMode(widthMeasureSpec);
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                float f = getContext().getResources().getDisplayMetrics().density;
                int width = (int) (((float) this.f468c.getWidth()) * f);
                int height = (int) (((float) this.f468c.getHeight()) * f);
                if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                    i = size;
                } else {
                    i = Integer.MAX_VALUE;
                }
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i2 = size2;
                }
                if (((float) width) - (f * 6.0f) > ((float) i) || height > i2) {
                    C0284b.m484b("Not enough space to show ad! Wants: <" + width + ", " + height + ">, Has: <" + size + ", " + size2 + ">");
                    setVisibility(8);
                    setMeasuredDimension(size, size2);
                } else {
                    setMeasuredDimension(width, height);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        C0190ak a = this.f466a.f671r.mo3726a();
        if (a != null) {
            a.mo3338a(event);
        }
        return super.onTouchEvent(event);
    }

    public void setCustomClose(boolean useCustomClose) {
        AdActivity adActivity;
        this.f471f = useCustomClose;
        if (this.f467b != null && (adActivity = (AdActivity) this.f467b.get()) != null) {
            adActivity.setCustomClose(useCustomClose);
        }
    }

    public void setIsExpandedMraid(boolean isCurrentlyExpandedMraid) {
        this.f469d = isCurrentlyExpandedMraid;
    }

    /* renamed from: a */
    public void mo3454a(boolean z) {
        if (z) {
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    return event.getAction() == 2;
                }
            });
        } else {
            setOnTouchListener((View.OnTouchListener) null);
        }
    }
}
