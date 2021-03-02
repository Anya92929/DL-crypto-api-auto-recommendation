package org.apache.cordova;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.IOException;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;

public class IceCreamCordovaWebViewClient extends CordovaWebViewClient {
    public IceCreamCordovaWebViewClient(CordovaInterface cordova) {
        super(cordova);
    }

    public IceCreamCordovaWebViewClient(CordovaInterface cordova, CordovaWebView view) {
        super(cordova, view);
    }

    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        if (url.contains("?") || url.contains("#")) {
            return generateWebResourceResponse(url);
        }
        return super.shouldInterceptRequest(view, url);
    }

    private WebResourceResponse generateWebResourceResponse(String url) {
        if (url.startsWith("file:///android_asset/")) {
            String str = url;
            String niceUrl = url.replaceFirst("file:///android_asset/", "");
            if (niceUrl.contains("?")) {
                niceUrl = niceUrl.split("\\?")[0];
            } else if (niceUrl.contains("#")) {
                niceUrl = niceUrl.split("#")[0];
            }
            String mimetype = null;
            if (niceUrl.endsWith(".html")) {
                mimetype = "text/html";
            }
            try {
                return new WebResourceResponse(mimetype, "UTF-8", this.cordova.getActivity().getAssets().open(Uri.parse(niceUrl).getPath(), 2));
            } catch (IOException e) {
                LOG.m2219e("generateWebResourceResponse", e.getMessage(), (Throwable) e);
            }
        }
        return null;
    }
}
