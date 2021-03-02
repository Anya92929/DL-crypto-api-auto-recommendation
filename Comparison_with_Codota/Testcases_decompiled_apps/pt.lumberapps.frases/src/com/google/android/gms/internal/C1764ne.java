package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzin
/* renamed from: com.google.android.gms.internal.ne */
class C1764ne extends FrameLayout implements zzlh {

    /* renamed from: a */
    private final zzlh f5383a;

    /* renamed from: b */
    private final zzlg f5384b;

    public C1764ne(zzlh zzlh) {
        super(zzlh.getContext());
        this.f5383a = zzlh;
        this.f5384b = new zzlg(zzlh.zzuf(), this, this);
        zzli zzuj = this.f5383a.zzuj();
        if (zzuj != null) {
            zzuj.zzl(this);
        }
        addView(this.f5383a.getView());
    }

    public void destroy() {
        this.f5383a.destroy();
    }

    public String getRequestId() {
        return this.f5383a.getRequestId();
    }

    public int getRequestedOrientation() {
        return this.f5383a.getRequestedOrientation();
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this.f5383a.getWebView();
    }

    public boolean isDestroyed() {
        return this.f5383a.isDestroyed();
    }

    public void loadData(String str, String str2, String str3) {
        this.f5383a.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f5383a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        this.f5383a.loadUrl(str);
    }

    public void onPause() {
        this.f5384b.onPause();
        this.f5383a.onPause();
    }

    public void onResume() {
        this.f5383a.onResume();
    }

    public void setBackgroundColor(int i) {
        this.f5383a.setBackgroundColor(i);
    }

    public void setContext(Context context) {
        this.f5383a.setContext(context);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f5383a.setOnClickListener(onClickListener);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f5383a.setOnTouchListener(onTouchListener);
    }

    public void setRequestedOrientation(int i) {
        this.f5383a.setRequestedOrientation(i);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f5383a.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f5383a.setWebViewClient(webViewClient);
    }

    public void stopLoading() {
        this.f5383a.stopLoading();
    }

    public void zza(Context context, AdSizeParcel adSizeParcel, zzdk zzdk) {
        this.f5384b.onDestroy();
        this.f5383a.zza(context, adSizeParcel, zzdk);
    }

    public void zza(AdSizeParcel adSizeParcel) {
        this.f5383a.zza(adSizeParcel);
    }

    public void zza(zzcd zzcd, boolean z) {
        this.f5383a.zza(zzcd, z);
    }

    public void zza(zzlm zzlm) {
        this.f5383a.zza(zzlm);
    }

    public void zza(String str, zzep zzep) {
        this.f5383a.zza(str, zzep);
    }

    public void zza(String str, Map map) {
        this.f5383a.zza(str, map);
    }

    public void zza(String str, JSONObject jSONObject) {
        this.f5383a.zza(str, jSONObject);
    }

    public void zzaf(int i) {
        this.f5383a.zzaf(i);
    }

    public void zzah(boolean z) {
        this.f5383a.zzah(z);
    }

    public void zzai(boolean z) {
        this.f5383a.zzai(z);
    }

    public void zzaj(boolean z) {
        this.f5383a.zzaj(z);
    }

    public void zzb(zzd zzd) {
        this.f5383a.zzb(zzd);
    }

    public void zzb(String str, zzep zzep) {
        this.f5383a.zzb(str, zzep);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.f5383a.zzb(str, jSONObject);
    }

    public void zzc(zzd zzd) {
        this.f5383a.zzc(zzd);
    }

    public void zzcy(String str) {
        this.f5383a.zzcy(str);
    }

    public void zzcz(String str) {
        this.f5383a.zzcz(str);
    }

    public AdSizeParcel zzdn() {
        return this.f5383a.zzdn();
    }

    public void zzef() {
        this.f5383a.zzef();
    }

    public void zzeg() {
        this.f5383a.zzeg();
    }

    public void zzj(String str, String str2) {
        this.f5383a.zzj(str, str2);
    }

    public void zzoa() {
        this.f5383a.zzoa();
    }

    public boolean zzou() {
        return this.f5383a.zzou();
    }

    public void zzuc() {
        this.f5383a.zzuc();
    }

    public void zzud() {
        this.f5383a.zzud();
    }

    public Activity zzue() {
        return this.f5383a.zzue();
    }

    public Context zzuf() {
        return this.f5383a.zzuf();
    }

    public com.google.android.gms.ads.internal.zzd zzug() {
        return this.f5383a.zzug();
    }

    public zzd zzuh() {
        return this.f5383a.zzuh();
    }

    public zzd zzui() {
        return this.f5383a.zzui();
    }

    public zzli zzuj() {
        return this.f5383a.zzuj();
    }

    public boolean zzuk() {
        return this.f5383a.zzuk();
    }

    public zzas zzul() {
        return this.f5383a.zzul();
    }

    public VersionInfoParcel zzum() {
        return this.f5383a.zzum();
    }

    public boolean zzun() {
        return this.f5383a.zzun();
    }

    public void zzuo() {
        this.f5384b.onDestroy();
        this.f5383a.zzuo();
    }

    public boolean zzup() {
        return this.f5383a.zzup();
    }

    public zzlg zzuq() {
        return this.f5384b;
    }

    public zzdi zzur() {
        return this.f5383a.zzur();
    }

    public zzdj zzus() {
        return this.f5383a.zzus();
    }

    public zzlm zzut() {
        return this.f5383a.zzut();
    }

    public void zzuu() {
        this.f5383a.zzuu();
    }

    public void zzuv() {
        this.f5383a.zzuv();
    }

    public View.OnClickListener zzuw() {
        return this.f5383a.zzuw();
    }
}
