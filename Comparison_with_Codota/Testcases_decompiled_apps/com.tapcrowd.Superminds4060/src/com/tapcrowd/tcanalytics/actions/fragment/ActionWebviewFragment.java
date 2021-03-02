package com.tapcrowd.tcanalytics.actions.fragment;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActionWebviewFragment extends Fragment {
    private String url;
    private WebView webview;

    public static ActionWebviewFragment newInstance(String url2) {
        ActionWebviewFragment fr = new ActionWebviewFragment();
        fr.url = url2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.webview == null) {
            this.webview = new WebView(getActivity());
            this.webview.getSettings().setJavaScriptEnabled(true);
            this.webview.getSettings().setUseWideViewPort(true);
            this.webview.getSettings().setUseWideViewPort(true);
            this.webview.getSettings().setLoadWithOverviewMode(true);
            this.webview.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;
                }
            });
            this.webview.loadUrl(this.url);
            return this.webview;
        }
        ((ViewGroup) this.webview.getParent()).removeView(this.webview);
        return this.webview;
    }
}
