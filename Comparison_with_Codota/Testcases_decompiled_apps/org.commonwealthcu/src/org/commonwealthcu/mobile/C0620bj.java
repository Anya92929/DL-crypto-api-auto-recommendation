package org.commonwealthcu.mobile;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p000v4.media.TransportMediator;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* renamed from: org.commonwealthcu.mobile.bj */
public class C0620bj extends Fragment {

    /* renamed from: a */
    private WebView f835a;

    /* renamed from: b */
    private String f836b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0619bi f837c;

    /* renamed from: a */
    public final void mo5547a(String str) {
        this.f836b = str;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f835a.setWebChromeClient(new C0621bk(this));
        this.f835a.setWebViewClient(new C0622bl(this));
        this.f835a.setOnTouchListener(new C0623bm(this));
        this.f835a.getSettings().setJavaScriptEnabled(true);
        this.f835a.getSettings().setSupportZoom(true);
        this.f835a.getSettings().setSavePassword(false);
        this.f835a.getSettings().setSaveFormData(false);
        this.f835a.setVerticalScrollBarEnabled(false);
        this.f835a.setHorizontalScrollBarEnabled(false);
        this.f835a.getSettings().setBuiltInZoomControls(true);
        this.f835a.getSettings().setUseWideViewPort(true);
        this.f835a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        this.f835a.getSettings().setLoadWithOverviewMode(true);
        this.f835a.getSettings().setUserAgentString(((MobileBankingApp) getActivity().getApplicationContext()).mo5471g());
        this.f835a.loadUrl(this.f836b);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0137R.layout.webview, viewGroup, false);
        this.f835a = (WebView) inflate.findViewById(C0137R.C0139id.main_webview);
        FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        C0619bi biVar = new C0619bi();
        beginTransaction.add(16908290, (Fragment) biVar);
        this.f837c = biVar;
        beginTransaction.commit();
        return inflate;
    }

    public void onStart() {
        super.onStart();
        this.f835a.requestFocus(TransportMediator.KEYCODE_MEDIA_RECORD);
    }
}
