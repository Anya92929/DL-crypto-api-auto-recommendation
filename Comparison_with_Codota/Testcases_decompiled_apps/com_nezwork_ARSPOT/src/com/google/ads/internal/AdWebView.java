package com.google.ads.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.m;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.g;
import com.google.ads.util.h;
import java.lang.ref.WeakReference;

public class AdWebView extends WebView {
    private WeakReference<AdActivity> a = null;
    private AdSize b;
    private boolean c = false;
    private boolean d = false;

    public AdWebView(m slotState, AdSize adSize) {
        super(slotState.d.a());
        this.b = adSize;
        setBackgroundColor(0);
        AdUtil.a((WebView) this);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(url), mimeType);
                    AdActivity d = AdWebView.this.d();
                    if (d != null && AdUtil.a(intent, (Context) d)) {
                        d.startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    b.a("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
                } catch (Throwable th) {
                    b.b("Unknown error trying to start activity to view URL: " + url, th);
                }
            }
        });
        if (AdUtil.a >= 11) {
            g.a(settings, slotState);
        }
        setScrollBarStyle(33554432);
        if (AdUtil.a >= 14) {
            setWebChromeClient(new h.a(slotState));
        } else if (AdUtil.a >= 11) {
            setWebChromeClient(new g.a(slotState));
        }
    }

    public void a() {
        AdActivity d2 = d();
        if (d2 != null) {
            d2.finish();
        }
    }

    public void b() {
        if (AdUtil.a >= 11) {
            g.a((View) this);
        }
        this.d = true;
    }

    public void c() {
        if (this.d && AdUtil.a >= 11) {
            g.b(this);
        }
        this.d = false;
    }

    public AdActivity d() {
        if (this.a != null) {
            return (AdActivity) this.a.get();
        }
        return null;
    }

    public boolean e() {
        return this.d;
    }

    public void setAdActivity(AdActivity adActivity) {
        this.a = new WeakReference<>(adActivity);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        try {
            super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        } catch (Throwable th) {
            b.b("An error occurred while loading data in AdWebView:", th);
        }
    }

    public void loadUrl(String url) {
        try {
            super.loadUrl(url);
        } catch (Throwable th) {
            b.b("An error occurred while loading a URL in AdWebView:", th);
        }
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Throwable th) {
            b.d("An error occurred while stopping loading in AdWebView:", th);
        }
    }

    public void destroy() {
        try {
            super.destroy();
            setWebViewClient(new WebViewClient());
        } catch (Throwable th) {
            b.b("An error occurred while destroying an AdWebView:", th);
        }
    }

    public synchronized void setAdSize(AdSize adSize) {
        this.b = adSize;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2 = Integer.MAX_VALUE;
        synchronized (this) {
            if (isInEditMode()) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else if (this.b == null || this.c) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else {
                int mode = View.MeasureSpec.getMode(widthMeasureSpec);
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                float f = getContext().getResources().getDisplayMetrics().density;
                int width = (int) (((float) this.b.getWidth()) * f);
                int height = (int) (((float) this.b.getHeight()) * f);
                if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                    i = size;
                } else {
                    i = Integer.MAX_VALUE;
                }
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i2 = size2;
                }
                if (((float) width) - (f * 6.0f) > ((float) i) || height > i2) {
                    b.e("Not enough space to show ad! Wants: <" + width + ", " + height + ">, Has: <" + size + ", " + size2 + ">");
                    setVisibility(8);
                    setMeasuredDimension(size, size2);
                } else {
                    setMeasuredDimension(width, height);
                }
            }
        }
    }

    public void setIsExpandedMraid(boolean isCurrentlyExpandedMraid) {
        this.c = isCurrentlyExpandedMraid;
    }
}
