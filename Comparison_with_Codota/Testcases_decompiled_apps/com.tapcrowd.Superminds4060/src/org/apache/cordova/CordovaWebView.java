package org.apache.cordova;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginManager;
import org.apache.cordova.api.PluginResult;
import org.xmlpull.v1.XmlPullParserException;

public class CordovaWebView extends WebView {
    static final FrameLayout.LayoutParams COVER_SCREEN_GRAVITY_CENTER = new FrameLayout.LayoutParams(-1, -1, 17);
    public static final String TAG = "CordovaWebView";
    String baseUrl;
    private boolean bound;
    private CordovaChromeClient chromeClient;
    /* access modifiers changed from: private */
    public CordovaInterface cordova;
    ExposedJsApi exposedJsApi;
    private boolean handleButton = false;
    NativeToJsMessageQueue jsMessageQueue;
    private ArrayList<Integer> keyDownCodes = new ArrayList<>();
    private ArrayList<Integer> keyUpCodes = new ArrayList<>();
    private long lastMenuEventTime = 0;
    int loadUrlTimeout = 0;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private boolean paused;
    public PluginManager pluginManager;
    private BroadcastReceiver receiver;
    private String url;
    private Stack<String> urls = new Stack<>();
    boolean useBrowserHistory = true;
    CordovaWebViewClient viewClient;
    private ArrayList<Pattern> whiteList = new ArrayList<>();
    private HashMap<String, Boolean> whiteListCache = new HashMap<>();

    public CordovaWebView(Context context) {
        super(context);
        if (CordovaInterface.class.isInstance(context)) {
            this.cordova = (CordovaInterface) context;
        } else {
            Log.d(TAG, "Your activity must implement CordovaInterface to work");
        }
        loadConfiguration();
        setup();
    }

    public CordovaWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (CordovaInterface.class.isInstance(context)) {
            this.cordova = (CordovaInterface) context;
        } else {
            Log.d(TAG, "Your activity must implement CordovaInterface to work");
        }
        setWebChromeClient(new CordovaChromeClient(this.cordova, this));
        initWebViewClient(this.cordova);
        loadConfiguration();
        setup();
    }

    public CordovaWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (CordovaInterface.class.isInstance(context)) {
            this.cordova = (CordovaInterface) context;
        } else {
            Log.d(TAG, "Your activity must implement CordovaInterface to work");
        }
        setWebChromeClient(new CordovaChromeClient(this.cordova, this));
        loadConfiguration();
        setup();
    }

    @TargetApi(11)
    public CordovaWebView(Context context, AttributeSet attrs, int defStyle, boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
        if (CordovaInterface.class.isInstance(context)) {
            this.cordova = (CordovaInterface) context;
        } else {
            Log.d(TAG, "Your activity must implement CordovaInterface to work");
        }
        setWebChromeClient(new CordovaChromeClient(this.cordova));
        initWebViewClient(this.cordova);
        loadConfiguration();
        setup();
    }

    private void initWebViewClient(CordovaInterface cordova2) {
        if (Build.VERSION.SDK_INT < 11) {
            setWebViewClient(new CordovaWebViewClient(this.cordova, this));
        } else {
            setWebViewClient(new IceCreamCordovaWebViewClient(this.cordova, this));
        }
    }

    @SuppressLint({"NewApi"})
    private void setup() {
        setInitialScale(0);
        setVerticalScrollBarEnabled(false);
        requestFocusFromTouch();
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        if (Build.VERSION.SDK_INT < 11) {
            settings.setNavDump(true);
        }
        if (Build.VERSION.SDK_INT > 15) {
            Level16Apis.enableUniversalAccess(settings);
        }
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.cordova.getActivity().getApplicationContext().getDir("database", 0).getPath());
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        updateUserAgentString();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        if (this.receiver == null) {
            this.receiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    CordovaWebView.this.updateUserAgentString();
                }
            };
            this.cordova.getActivity().registerReceiver(this.receiver, intentFilter);
        }
        this.pluginManager = new PluginManager(this, this.cordova);
        this.jsMessageQueue = new NativeToJsMessageQueue(this, this.cordova);
        this.exposedJsApi = new ExposedJsApi(this.pluginManager, this.jsMessageQueue);
        exposeJsInterface();
    }

    /* access modifiers changed from: private */
    public void updateUserAgentString() {
        getSettings().getUserAgentString();
    }

    private void exposeJsInterface() {
        if (Build.VERSION.SDK_INT < 9) {
            Log.i(TAG, "Disabled addJavascriptInterface() bridge since Android version is old.");
        } else if (Build.VERSION.SDK_INT >= 11 || !Build.MANUFACTURER.equals(NetworkManager.TYPE_UNKNOWN)) {
            addJavascriptInterface(this.exposedJsApi, "_cordovaNative");
        } else {
            Log.i(TAG, "Disabled addJavascriptInterface() bridge callback due to a bug on the 2.3 emulator");
        }
    }

    public void setWebViewClient(CordovaWebViewClient client) {
        this.viewClient = client;
        super.setWebViewClient(client);
    }

    public void setWebChromeClient(CordovaChromeClient client) {
        this.chromeClient = client;
        super.setWebChromeClient(client);
    }

    public void addWhiteListEntry(String origin, boolean subdomains) {
        try {
            if (origin.compareTo("*") == 0) {
                LOG.m2215d(TAG, "Unlimited access to network resources");
                this.whiteList.add(Pattern.compile(".*"));
            } else if (subdomains) {
                if (origin.startsWith("http")) {
                    this.whiteList.add(Pattern.compile(origin.replaceFirst("https?://", "^https?://(.*\\.)?")));
                } else {
                    this.whiteList.add(Pattern.compile("^https?://(.*\\.)?" + origin));
                }
                LOG.m2217d(TAG, "Origin to allow with subdomains: %s", origin);
            } else {
                if (origin.startsWith("http")) {
                    this.whiteList.add(Pattern.compile(origin.replaceFirst("https?://", "^https?://")));
                } else {
                    this.whiteList.add(Pattern.compile("^https?://" + origin));
                }
                LOG.m2217d(TAG, "Origin to allow: %s", origin);
            }
        } catch (Exception e) {
            LOG.m2217d(TAG, "Failed to add origin %s", origin);
        }
    }

    public boolean isUrlWhiteListed(String url2) {
        if (this.whiteListCache.get(url2) != null) {
            return true;
        }
        Iterator<Pattern> pit = this.whiteList.iterator();
        while (pit.hasNext()) {
            if (pit.next().matcher(url2).find()) {
                this.whiteListCache.put(url2, true);
                return true;
            }
        }
        return false;
    }

    public void loadUrl(String url2) {
        if (url2.equals("about:blank") || url2.startsWith("javascript:")) {
            loadUrlNow(url2);
            return;
        }
        String initUrl = getProperty(PlusShare.KEY_CALL_TO_ACTION_URL, (String) null);
        if (initUrl == null || this.urls.size() > 0) {
            loadUrlIntoView(url2);
        } else {
            loadUrlIntoView(initUrl);
        }
    }

    public void loadUrl(String url2, int time) {
        String initUrl = getProperty(PlusShare.KEY_CALL_TO_ACTION_URL, (String) null);
        if (initUrl == null || this.urls.size() > 0) {
            loadUrlIntoView(url2, time);
        } else {
            loadUrlIntoView(initUrl);
        }
    }

    public void loadUrlIntoView(final String url2) {
        LOG.m2215d(TAG, ">>> loadUrl(" + url2 + ")");
        this.url = url2;
        if (this.baseUrl == null) {
            int i = url2.lastIndexOf(47);
            if (i > 0) {
                this.baseUrl = url2.substring(0, i + 1);
            } else {
                this.baseUrl = this.url + "/";
            }
            this.pluginManager.init();
            if (!this.useBrowserHistory) {
                this.urls.push(url2);
            }
        }
        final int currentLoadUrlTimeout = this.loadUrlTimeout;
        final int loadUrlTimeoutValue = Integer.parseInt(getProperty("loadUrlTimeoutValue", "20000"));
        final Runnable loadError = new Runnable() {
            public void run() {
                this.stopLoading();
                LOG.m2218e(CordovaWebView.TAG, "CordovaWebView: TIMEOUT ERROR!");
                if (CordovaWebView.this.viewClient != null) {
                    CordovaWebView.this.viewClient.onReceivedError(this, -6, "The connection to the server was unsuccessful.", url2);
                }
            }
        };
        final Runnable timeoutCheck = new Runnable() {
            public void run() {
                try {
                    synchronized (this) {
                        wait((long) loadUrlTimeoutValue);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.loadUrlTimeout == currentLoadUrlTimeout) {
                    this.cordova.getActivity().runOnUiThread(loadError);
                }
            }
        };
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                new Thread(timeoutCheck).start();
                this.loadUrlNow(url2);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void loadUrlNow(String url2) {
        if (LOG.isLoggable(3) && !url2.startsWith("javascript:")) {
            LOG.m2215d(TAG, ">>> loadUrlNow()");
        }
        if (url2.startsWith("file://") || url2.indexOf(this.baseUrl) == 0 || url2.startsWith("javascript:") || isUrlWhiteListed(url2)) {
            super.loadUrl(url2);
        }
    }

    public void loadUrlIntoView(String url2, int time) {
        if (!url2.startsWith("javascript:") && this.urls.size() <= 0 && !canGoBack()) {
            LOG.m2217d(TAG, "DroidGap.loadUrl(%s, %d)", url2, Integer.valueOf(time));
            postMessage("splashscreen", "show");
        }
        loadUrlIntoView(url2);
    }

    public void sendJavascript(String statement) {
        this.jsMessageQueue.addJavaScript(statement);
    }

    public void sendPluginResult(PluginResult result, String callbackId) {
        this.jsMessageQueue.addPluginResult(result, callbackId);
    }

    public void postMessage(String id, Object data) {
        if (this.pluginManager != null) {
            this.pluginManager.postMessage(id, data);
        }
    }

    public String peekAtUrlStack() {
        if (this.urls.size() > 0) {
            return this.urls.peek();
        }
        return "";
    }

    public void pushUrl(String url2) {
        this.urls.push(url2);
    }

    public boolean backHistory() {
        if (super.canGoBack()) {
            printBackForwardList();
            super.goBack();
            return true;
        } else if (this.urls.size() <= 1 || this.useBrowserHistory) {
            return false;
        } else {
            this.urls.pop();
            loadUrl(this.urls.pop());
            return true;
        }
    }

    public boolean canGoBack() {
        if (!super.canGoBack() && this.urls.size() <= 1) {
            return false;
        }
        return true;
    }

    public void showWebPage(String url2, boolean openExternal, boolean clearHistory, HashMap<String, Object> hashMap) {
        LOG.m2217d(TAG, "showWebPage(%s, %b, %b, HashMap", url2, Boolean.valueOf(openExternal), Boolean.valueOf(clearHistory));
        if (clearHistory) {
            clearHistory();
        }
        if (openExternal) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(url2));
                this.cordova.getActivity().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                LOG.m2219e(TAG, "Error loading url " + url2, (Throwable) e);
            }
        } else if (url2.startsWith("file://") || url2.indexOf(this.baseUrl) == 0 || isUrlWhiteListed(url2)) {
            if (clearHistory) {
                this.urls.clear();
            }
            loadUrl(url2);
        } else {
            LOG.m2227w(TAG, "showWebPage: Cannot load URL into webview since it is not in white list.  Loading into browser instead. (URL=" + url2 + ")");
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(url2));
                this.cordova.getActivity().startActivity(intent2);
            } catch (ActivityNotFoundException e2) {
                LOG.m2219e(TAG, "Error loading url " + url2, (Throwable) e2);
            }
        }
    }

    private void loadConfiguration() {
        boolean z;
        int id = getResources().getIdentifier("config", "xml", this.cordova.getActivity().getPackageName());
        if (id == 0) {
            id = getResources().getIdentifier("cordova", "xml", this.cordova.getActivity().getPackageName());
            Log.i("CordovaLog", "config.xml missing, reverting to cordova.xml");
        }
        if (id == 0) {
            LOG.m2221i("CordovaLog", "cordova.xml missing. Ignoring...");
            return;
        }
        XmlResourceParser xml = getResources().getXml(id);
        int eventType = -1;
        while (eventType != 1) {
            if (eventType == 2) {
                String strNode = xml.getName();
                if (strNode.equals("access")) {
                    String origin = xml.getAttributeValue((String) null, "origin");
                    String subdomains = xml.getAttributeValue((String) null, "subdomains");
                    if (origin != null) {
                        if (subdomains == null || subdomains.compareToIgnoreCase("true") != 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        addWhiteListEntry(origin, z);
                    }
                } else if (strNode.equals("log")) {
                    String level = xml.getAttributeValue((String) null, "level");
                    LOG.m2223i("CordovaLog", "Found log level %s", level);
                    if (level != null) {
                        LOG.setLogLevel(level);
                    }
                } else if (strNode.equals("preference")) {
                    String name = xml.getAttributeValue((String) null, DBFavorites.KEY_NAME);
                    String value = xml.getAttributeValue((String) null, "value");
                    LOG.m2223i("CordovaLog", "Found preference for %s=%s", name, value);
                    Log.d("CordovaLog", "Found preference for " + name + "=" + value);
                    this.cordova.getActivity().getIntent().putExtra(name, value);
                }
            }
            try {
                eventType = xml.next();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if ("false".equals(getProperty("useBrowserHistory", "true"))) {
            this.useBrowserHistory = false;
            Log.w(TAG, "useBrowserHistory=false is deprecated as of Cordova 2.2.0 and will be removed six months after the 2.2.0 release.  Please use the browser history and use history.back().");
        }
        if ("true".equals(getProperty("fullscreen", "false"))) {
            this.cordova.getActivity().getWindow().clearFlags(2048);
            this.cordova.getActivity().getWindow().setFlags(1024, 1024);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = r0.get(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getProperty(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            org.apache.cordova.api.CordovaInterface r2 = r3.cordova
            android.app.Activity r2 = r2.getActivity()
            android.content.Intent r2 = r2.getIntent()
            android.os.Bundle r0 = r2.getExtras()
            if (r0 != 0) goto L_0x0011
        L_0x0010:
            return r5
        L_0x0011:
            java.lang.Object r1 = r0.get(r4)
            if (r1 == 0) goto L_0x0010
            java.lang.String r5 = r1.toString()
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.CordovaWebView.getProperty(java.lang.String, java.lang.String):java.lang.String");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean z = false;
        if (this.keyDownCodes.contains(Integer.valueOf(keyCode))) {
            if (keyCode == 25) {
                LOG.m2215d(TAG, "Down Key Hit");
                loadUrl("javascript:cordova.fireDocumentEvent('volumedownbutton');");
                return true;
            } else if (keyCode != 24) {
                return super.onKeyDown(keyCode, event);
            } else {
                LOG.m2215d(TAG, "Up Key Hit");
                loadUrl("javascript:cordova.fireDocumentEvent('volumeupbutton');");
                return true;
            }
        } else if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        } else {
            if (this.useBrowserHistory) {
                if (!startOfHistory() || this.bound) {
                    z = true;
                }
                return z;
            }
            if (this.urls.size() > 1 || this.bound) {
                z = true;
            }
            return z;
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            if (this.mCustomView != null) {
                hideCustomView();
            } else if (this.bound) {
                loadUrl("javascript:cordova.fireDocumentEvent('backbutton');");
                return true;
            } else if (!backHistory()) {
                return false;
            } else {
                return true;
            }
        } else if (keyCode == 82) {
            if (this.lastMenuEventTime < event.getEventTime()) {
                loadUrl("javascript:cordova.fireDocumentEvent('menubutton');");
            }
            this.lastMenuEventTime = event.getEventTime();
            return super.onKeyUp(keyCode, event);
        } else if (keyCode == 84) {
            loadUrl("javascript:cordova.fireDocumentEvent('searchbutton');");
            return true;
        } else if (this.keyUpCodes.contains(Integer.valueOf(keyCode))) {
            return super.onKeyUp(keyCode, event);
        }
        return super.onKeyUp(keyCode, event);
    }

    public void bindButton(boolean override) {
        this.bound = override;
    }

    public void bindButton(String button, boolean override) {
        if (button.compareTo("volumeup") == 0) {
            this.keyDownCodes.add(24);
        } else if (button.compareTo("volumedown") == 0) {
            this.keyDownCodes.add(25);
        }
    }

    public void bindButton(int keyCode, boolean keyDown, boolean override) {
        if (keyDown) {
            this.keyDownCodes.add(Integer.valueOf(keyCode));
        } else {
            this.keyUpCodes.add(Integer.valueOf(keyCode));
        }
    }

    public boolean isBackButtonBound() {
        return this.bound;
    }

    public void handlePause(boolean keepRunning) {
        LOG.m2215d(TAG, "Handle the pause");
        loadUrl("javascript:try{cordova.fireDocumentEvent('pause');}catch(e){console.log('exception firing pause event from native');};");
        if (this.pluginManager != null) {
            this.pluginManager.onPause(keepRunning);
        }
        if (!keepRunning) {
            pauseTimers();
        }
        this.paused = true;
    }

    public void handleResume(boolean keepRunning, boolean activityResultKeepRunning) {
        loadUrl("javascript:try{cordova.fireDocumentEvent('resume');}catch(e){console.log('exception firing resume event from native');};");
        if (this.pluginManager != null) {
            this.pluginManager.onResume(keepRunning);
        }
        resumeTimers();
        this.paused = false;
    }

    public void handleDestroy() {
        loadUrl("javascript:try{cordova.require('cordova/channel').onDestroy.fire();}catch(e){console.log('exception firing destroy event from native');};");
        loadUrl("about:blank");
        if (this.pluginManager != null) {
            this.pluginManager.onDestroy();
        }
        if (this.receiver != null) {
            try {
                this.cordova.getActivity().unregisterReceiver(this.receiver);
            } catch (Exception e) {
                Log.e(TAG, "Error unregistering configuration receiver: " + e.getMessage(), e);
            }
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.pluginManager != null) {
            this.pluginManager.onNewIntent(intent);
        }
    }

    public boolean isPaused() {
        return this.paused;
    }

    public boolean hadKeyEvent() {
        return this.handleButton;
    }

    @TargetApi(16)
    private static class Level16Apis {
        private Level16Apis() {
        }

        static void enableUniversalAccess(WebSettings settings) {
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
    }

    public void printBackForwardList() {
        WebBackForwardList currentList = copyBackForwardList();
        int currentSize = currentList.getSize();
        for (int i = 0; i < currentSize; i++) {
            LOG.m2215d(TAG, "The URL at index: " + Integer.toString(i) + "is " + currentList.getItemAtIndex(i).getUrl());
        }
    }

    public boolean startOfHistory() {
        String url2 = copyBackForwardList().getItemAtIndex(0).getUrl();
        String currentUrl = getUrl();
        LOG.m2215d(TAG, "The current URL is: " + currentUrl);
        LOG.m2215d(TAG, "The URL at item 0 is:" + url2);
        return currentUrl.equals(url2);
    }

    public void showCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        Log.d(TAG, "showing Custom View");
        if (this.mCustomView != null) {
            callback.onCustomViewHidden();
            return;
        }
        this.mCustomView = view;
        this.mCustomViewCallback = callback;
        ViewGroup parent = (ViewGroup) getParent();
        parent.addView(view, COVER_SCREEN_GRAVITY_CENTER);
        setVisibility(8);
        parent.setVisibility(0);
        parent.bringToFront();
    }

    public void hideCustomView() {
        Log.d(TAG, "Hidding Custom View");
        if (this.mCustomView != null) {
            this.mCustomView.setVisibility(8);
            ((ViewGroup) getParent()).removeView(this.mCustomView);
            this.mCustomView = null;
            this.mCustomViewCallback.onCustomViewHidden();
            setVisibility(0);
        }
    }

    public boolean isCustomViewShowing() {
        return this.mCustomView != null;
    }
}
