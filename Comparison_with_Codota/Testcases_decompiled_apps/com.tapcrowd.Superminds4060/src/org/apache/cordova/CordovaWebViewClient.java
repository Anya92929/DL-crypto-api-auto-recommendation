package org.apache.cordova;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.plus.PlusShare;
import java.util.Hashtable;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaWebViewClient extends WebViewClient {
    private static final String CORDOVA_EXEC_URL_PREFIX = "http://cdv_exec/";
    private static final String TAG = "Cordova";
    CordovaWebView appView;
    private Hashtable<String, AuthenticationToken> authenticationTokens = new Hashtable<>();
    CordovaInterface cordova;
    private boolean doClearHistory = false;

    public CordovaWebViewClient(CordovaInterface cordova2) {
        this.cordova = cordova2;
    }

    public CordovaWebViewClient(CordovaInterface cordova2, CordovaWebView view) {
        this.cordova = cordova2;
        this.appView = view;
    }

    public void setWebView(CordovaWebView view) {
        this.appView = view;
    }

    private void handleExecUrl(String url) {
        int idx1 = CORDOVA_EXEC_URL_PREFIX.length();
        int idx2 = url.indexOf(35, idx1 + 1);
        int idx3 = url.indexOf(35, idx2 + 1);
        int idx4 = url.indexOf(35, idx3 + 1);
        if (idx1 == -1 || idx2 == -1 || idx3 == -1 || idx4 == -1) {
            Log.e(TAG, "Could not decode URL command: " + url);
            return;
        }
        this.appView.pluginManager.exec(url.substring(idx1, idx2), url.substring(idx2 + 1, idx3), url.substring(idx3 + 1, idx4), url.substring(idx4 + 1));
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String address;
        if (this.appView.pluginManager == null || !this.appView.pluginManager.onOverrideUrlLoading(url)) {
            if (url.startsWith("tel:")) {
                try {
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(url));
                    this.cordova.getActivity().startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    LOG.m2218e(TAG, "Error dialing " + url + ": " + e.toString());
                }
            } else if (url.startsWith("geo:")) {
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(url));
                    this.cordova.getActivity().startActivity(intent2);
                } catch (ActivityNotFoundException e2) {
                    LOG.m2218e(TAG, "Error showing map " + url + ": " + e2.toString());
                }
            } else if (url.startsWith("mailto:")) {
                try {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setData(Uri.parse(url));
                    this.cordova.getActivity().startActivity(intent3);
                } catch (ActivityNotFoundException e3) {
                    LOG.m2218e(TAG, "Error sending email " + url + ": " + e3.toString());
                }
            } else if (url.startsWith("sms:")) {
                try {
                    Intent intent4 = new Intent("android.intent.action.VIEW");
                    int parmIndex = url.indexOf(63);
                    if (parmIndex == -1) {
                        address = url.substring(4);
                    } else {
                        address = url.substring(4, parmIndex);
                        String query = Uri.parse(url).getQuery();
                        if (query != null && query.startsWith("body=")) {
                            intent4.putExtra("sms_body", query.substring(5));
                        }
                    }
                    intent4.setData(Uri.parse("sms:" + address));
                    intent4.putExtra("address", address);
                    intent4.setType("vnd.android-dir/mms-sms");
                    this.cordova.getActivity().startActivity(intent4);
                } catch (ActivityNotFoundException e4) {
                    LOG.m2218e(TAG, "Error sending sms " + url + ":" + e4.toString());
                }
            } else if (!url.startsWith("file://") && !url.startsWith("data:") && url.indexOf(this.appView.baseUrl) != 0 && !this.appView.isUrlWhiteListed(url)) {
                try {
                    Intent intent5 = new Intent("android.intent.action.VIEW");
                    intent5.setData(Uri.parse(url));
                    this.cordova.getActivity().startActivity(intent5);
                } catch (ActivityNotFoundException e5) {
                    LOG.m2219e(TAG, "Error loading url " + url, (Throwable) e5);
                }
            } else if (this.appView.useBrowserHistory || url.startsWith("data:")) {
                return false;
            } else {
                this.appView.loadUrl(url);
            }
        }
        return true;
    }

    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        AuthenticationToken token = getAuthenticationToken(host, realm);
        if (token != null) {
            handler.proceed(token.getUserName(), token.getPassword());
        }
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if (!this.appView.useBrowserHistory) {
            view.clearHistory();
            this.doClearHistory = true;
        }
        this.appView.jsMessageQueue.reset();
        this.appView.postMessage("onPageStarted", url);
        if (this.appView.pluginManager != null) {
            this.appView.pluginManager.onReset();
        }
    }

    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        LOG.m2215d(TAG, "onPageFinished(" + url + ")");
        if (this.doClearHistory) {
            view.clearHistory();
            this.doClearHistory = false;
        }
        this.appView.loadUrlTimeout++;
        if (!url.equals("about:blank")) {
            this.appView.loadUrl("javascript:try{ cordova.require('cordova/channel').onNativeReady.fire();}catch(e){_nativeReady = true;}");
            this.appView.postMessage("onNativeReady", (Object) null);
        }
        this.appView.postMessage("onPageFinished", url);
        if (this.appView.getVisibility() == 4) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                        CordovaWebViewClient.this.cordova.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                CordovaWebViewClient.this.appView.postMessage("spinner", "stop");
                            }
                        });
                    } catch (InterruptedException e) {
                    }
                }
            }).start();
        }
        if (url.equals("about:blank")) {
            this.appView.postMessage("exit", (Object) null);
        }
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        LOG.m2217d(TAG, "CordovaWebViewClient.onReceivedError: Error code=%s Description=%s URL=%s", Integer.valueOf(errorCode), description, failingUrl);
        this.appView.loadUrlTimeout++;
        JSONObject data = new JSONObject();
        try {
            data.put("errorCode", errorCode);
            data.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, description);
            data.put(PlusShare.KEY_CALL_TO_ACTION_URL, failingUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.appView.postMessage("onReceivedError", data);
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        try {
            if ((this.cordova.getActivity().getPackageManager().getApplicationInfo(this.cordova.getActivity().getPackageName(), 128).flags & 2) != 0) {
                handler.proceed();
            } else {
                super.onReceivedSslError(view, handler, error);
            }
        } catch (PackageManager.NameNotFoundException e) {
            super.onReceivedSslError(view, handler, error);
        }
    }

    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        if (!this.appView.peekAtUrlStack().equals(url)) {
            this.appView.pushUrl(url);
        }
    }

    public void setAuthenticationToken(AuthenticationToken authenticationToken, String host, String realm) {
        if (host == null) {
            host = "";
        }
        if (realm == null) {
            realm = "";
        }
        this.authenticationTokens.put(host.concat(realm), authenticationToken);
    }

    public AuthenticationToken removeAuthenticationToken(String host, String realm) {
        return this.authenticationTokens.remove(host.concat(realm));
    }

    public AuthenticationToken getAuthenticationToken(String host, String realm) {
        AuthenticationToken token = this.authenticationTokens.get(host.concat(realm));
        if (token != null) {
            return token;
        }
        AuthenticationToken token2 = this.authenticationTokens.get(host);
        if (token2 == null) {
            token2 = this.authenticationTokens.get(realm);
        }
        if (token2 == null) {
            return this.authenticationTokens.get("");
        }
        return token2;
    }

    public void clearAuthenticationTokens() {
        this.authenticationTokens.clear();
    }
}
