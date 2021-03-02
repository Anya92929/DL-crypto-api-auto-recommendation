package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import org.json.JSONObject;

@zzin
public interface zzlh extends zzs, zzce, zzft {
    void destroy();

    Context getContext();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    String getRequestId();

    int getRequestedOrientation();

    View getView();

    WebView getWebView();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    void zza(Context context, AdSizeParcel adSizeParcel, zzdk zzdk);

    void zza(AdSizeParcel adSizeParcel);

    void zza(zzlm zzlm);

    void zza(String str, Map map);

    void zza(String str, JSONObject jSONObject);

    void zzaf(int i);

    void zzah(boolean z);

    void zzai(boolean z);

    void zzaj(boolean z);

    void zzb(zzd zzd);

    void zzc(zzd zzd);

    void zzcy(String str);

    void zzcz(String str);

    AdSizeParcel zzdn();

    void zzj(String str, String str2);

    void zzoa();

    boolean zzou();

    void zzuc();

    void zzud();

    Activity zzue();

    Context zzuf();

    com.google.android.gms.ads.internal.zzd zzug();

    zzd zzuh();

    zzd zzui();

    zzli zzuj();

    boolean zzuk();

    zzas zzul();

    VersionInfoParcel zzum();

    boolean zzun();

    void zzuo();

    boolean zzup();

    zzlg zzuq();

    zzdi zzur();

    zzdj zzus();

    zzlm zzut();

    void zzuu();

    void zzuv();

    View.OnClickListener zzuw();
}
