package org.apache.cordova;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.app.utils.C1216LO;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.LOG;
import org.json.JSONException;
import org.json.JSONObject;

public class DroidGap extends Activity implements CordovaInterface {
    private static int ACTIVITY_EXITING = 2;
    private static int ACTIVITY_RUNNING = 1;
    private static int ACTIVITY_STARTING = 0;
    public static String TAG = "DroidGap";
    protected CordovaPlugin activityResultCallback = null;
    protected boolean activityResultKeepRunning;
    private int activityState = 0;
    protected CordovaWebView appView;
    private int backgroundColor = -16777216;
    String baseUrl = null;
    protected boolean cancelLoadUrl = false;
    protected boolean keepRunning = true;
    protected int loadUrlTimeoutValue = 20000;
    protected LinearLayout root;
    protected ProgressDialog spinnerDialog = null;
    protected Dialog splashDialog;
    protected int splashscreen = 0;
    protected int splashscreenTime = 0;
    private final ExecutorService threadPool = Executors.newCachedThreadPool();
    protected CordovaWebViewClient webViewClient;

    public void setAuthenticationToken(AuthenticationToken authenticationToken, String host, String realm) {
        if (this.appView != null && this.appView.viewClient != null) {
            this.appView.viewClient.setAuthenticationToken(authenticationToken, host, realm);
        }
    }

    public AuthenticationToken removeAuthenticationToken(String host, String realm) {
        if (this.appView == null || this.appView.viewClient == null) {
            return null;
        }
        return this.appView.viewClient.removeAuthenticationToken(host, realm);
    }

    public AuthenticationToken getAuthenticationToken(String host, String realm) {
        if (this.appView == null || this.appView.viewClient == null) {
            return null;
        }
        return this.appView.viewClient.getAuthenticationToken(host, realm);
    }

    public void clearAuthenticationTokens() {
        if (this.appView != null && this.appView.viewClient != null) {
            this.appView.viewClient.clearAuthenticationTokens();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        LOG.m2215d(TAG, "DroidGap.onCreate()");
        super.onCreate(savedInstanceState);
        if (!getBooleanProperty("showTitle", false)) {
            getWindow().requestFeature(1);
        }
        if (getBooleanProperty("setFullscreen", false)) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().setFlags(2048, 2048);
        }
        Display display = getWindowManager().getDefaultDisplay();
        this.root = new LinearLayoutSoftKeyboardDetect(this, display.getWidth(), display.getHeight());
        this.root.setOrientation(1);
        this.root.setBackgroundColor(this.backgroundColor);
        this.root.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, BitmapDescriptorFactory.HUE_RED));
        setVolumeControlStream(3);
    }

    public Activity getActivity() {
        return this;
    }

    public void init() {
        CordovaWebViewClient webViewClient2;
        CordovaWebView webView = new CordovaWebView(this);
        if (Build.VERSION.SDK_INT < 11) {
            webViewClient2 = new CordovaWebViewClient(this, webView);
        } else {
            webViewClient2 = new IceCreamCordovaWebViewClient(this, webView);
        }
        init(webView, webViewClient2, new CordovaChromeClient(this, webView));
    }

    public void init(CordovaWebView webView, CordovaWebViewClient webViewClient2, CordovaChromeClient webChromeClient) {
        LOG.m2215d(TAG, "DroidGap.init()");
        this.appView = webView;
        this.appView.setId(100);
        this.appView.setWebViewClient(webViewClient2);
        this.appView.setWebChromeClient(webChromeClient);
        webViewClient2.setWebView(this.appView);
        webChromeClient.setWebView(this.appView);
        this.appView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        this.appView.setVisibility(4);
        this.root.addView(this.appView);
        setContentView(this.root);
        this.cancelLoadUrl = false;
    }

    public void loadUrl(String url) {
        if (this.appView == null) {
            init();
        }
        this.backgroundColor = getIntegerProperty(C1216LO.backgroundColor, -16777216);
        this.root.setBackgroundColor(this.backgroundColor);
        this.keepRunning = getBooleanProperty("keepRunning", true);
        loadSpinner();
        this.appView.loadUrl(url);
    }

    /* access modifiers changed from: package-private */
    public void loadSpinner() {
        String loading;
        if (this.appView == null || !this.appView.canGoBack()) {
            loading = getStringProperty("loadingDialog", (String) null);
        } else {
            loading = getStringProperty("loadingPageDialog", (String) null);
        }
        if (loading != null) {
            String title = "";
            String message = "Loading Application...";
            if (loading.length() > 0) {
                int comma = loading.indexOf(44);
                if (comma > 0) {
                    title = loading.substring(0, comma);
                    message = loading.substring(comma + 1);
                } else {
                    title = "";
                    message = loading;
                }
            }
            spinnerStart(title, message);
        }
    }

    public void loadUrl(String url, int time) {
        if (this.appView == null) {
            init();
        }
        this.splashscreenTime = time;
        this.splashscreen = getIntegerProperty("splashscreen", 0);
        showSplashScreen(this.splashscreenTime);
        this.appView.loadUrl(url, time);
    }

    @Deprecated
    public void cancelLoadUrl() {
        this.cancelLoadUrl = true;
    }

    public void clearCache() {
        if (this.appView == null) {
            init();
        }
        this.appView.clearCache(true);
    }

    public void clearHistory() {
        this.appView.clearHistory();
    }

    public boolean backHistory() {
        if (this.appView != null) {
            return this.appView.backHistory();
        }
        return false;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public boolean getBooleanProperty(String name, boolean defaultValue) {
        Boolean p;
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return defaultValue;
        }
        try {
            p = (Boolean) bundle.get(name);
        } catch (ClassCastException e) {
            if ("true".equals(bundle.get(name).toString())) {
                p = true;
            } else {
                p = false;
            }
        }
        return p != null ? p.booleanValue() : defaultValue;
    }

    public int getIntegerProperty(String name, int defaultValue) {
        Integer p;
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return defaultValue;
        }
        try {
            p = (Integer) bundle.get(name);
        } catch (ClassCastException e) {
            p = Integer.valueOf(Integer.parseInt(bundle.get(name).toString()));
        }
        return p != null ? p.intValue() : defaultValue;
    }

    public String getStringProperty(String name, String defaultValue) {
        String p;
        Bundle bundle = getIntent().getExtras();
        if (bundle == null || (p = bundle.getString(name)) == null) {
            return defaultValue;
        }
        return p;
    }

    public double getDoubleProperty(String name, double defaultValue) {
        Double p;
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return defaultValue;
        }
        try {
            p = (Double) bundle.get(name);
        } catch (ClassCastException e) {
            p = Double.valueOf(Double.parseDouble(bundle.get(name).toString()));
        }
        return p != null ? p.doubleValue() : defaultValue;
    }

    public void setBooleanProperty(String name, boolean value) {
        getIntent().putExtra(name, value);
    }

    public void setIntegerProperty(String name, int value) {
        getIntent().putExtra(name, value);
    }

    public void setStringProperty(String name, String value) {
        getIntent().putExtra(name, value);
    }

    public void setDoubleProperty(String name, double value) {
        getIntent().putExtra(name, value);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LOG.m2215d(TAG, "Paused the application!");
        if (this.activityState != ACTIVITY_EXITING && this.appView != null) {
            this.appView.handlePause(this.keepRunning);
            removeSplashScreen();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.appView != null) {
            this.appView.onNewIntent(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LOG.m2215d(TAG, "Resuming the App");
        if (this.activityState == ACTIVITY_STARTING) {
            this.activityState = ACTIVITY_RUNNING;
        } else if (this.appView != null) {
            this.appView.handleResume(this.keepRunning, this.activityResultKeepRunning);
            if ((!this.keepRunning || this.activityResultKeepRunning) && this.activityResultKeepRunning) {
                this.keepRunning = this.activityResultKeepRunning;
                this.activityResultKeepRunning = false;
            }
        }
    }

    public void onDestroy() {
        LOG.m2215d(TAG, "onDestroy()");
        super.onDestroy();
        removeSplashScreen();
        if (this.appView != null) {
            this.appView.handleDestroy();
        } else {
            endActivity();
        }
    }

    public void postMessage(String id, Object data) {
        if (this.appView != null) {
            this.appView.postMessage(id, data);
        }
    }

    public void addService(String serviceType, String className) {
        if (this.appView != null && this.appView.pluginManager != null) {
            this.appView.pluginManager.addService(serviceType, className);
        }
    }

    public void sendJavascript(String statement) {
        if (this.appView != null) {
            this.appView.jsMessageQueue.addJavaScript(statement);
        }
    }

    public void spinnerStart(String title, String message) {
        if (this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
        }
        this.spinnerDialog = ProgressDialog.show(this, title, message, true, true, new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                this.spinnerDialog = null;
            }
        });
    }

    public void spinnerStop() {
        if (this.spinnerDialog != null && this.spinnerDialog.isShowing()) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
        }
    }

    public void endActivity() {
        this.activityState = ACTIVITY_EXITING;
        super.finish();
    }

    public void startActivityForResult(CordovaPlugin command, Intent intent, int requestCode) {
        this.activityResultCallback = command;
        this.activityResultKeepRunning = this.keepRunning;
        if (command != null) {
            this.keepRunning = false;
        }
        super.startActivityForResult(intent, requestCode);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        CordovaPlugin callback = this.activityResultCallback;
        if (callback != null) {
            callback.onActivityResult(requestCode, resultCode, intent);
        }
    }

    public void setActivityResultCallback(CordovaPlugin plugin) {
        this.activityResultCallback = plugin;
    }

    public void onReceivedError(int errorCode, String description, String failingUrl) {
        final String errorUrl = getStringProperty("errorUrl", (String) null);
        if (errorUrl == null || ((!errorUrl.startsWith("file://") && errorUrl.indexOf(this.baseUrl) != 0 && !this.appView.isUrlWhiteListed(errorUrl)) || failingUrl.equals(errorUrl))) {
            final boolean exit = errorCode != -2;
            final String str = description;
            final String str2 = failingUrl;
            runOnUiThread(new Runnable() {
                public void run() {
                    if (exit) {
                        this.appView.setVisibility(8);
                        this.displayError("Application Error", str + " (" + str2 + ")", "OK", exit);
                    }
                }
            });
            return;
        }
        runOnUiThread(new Runnable() {
            public void run() {
                this.spinnerStop();
                this.appView.showWebPage(errorUrl, false, true, (HashMap<String, Object>) null);
            }
        });
    }

    public void displayError(String title, String message, String button, boolean exit) {
        final String str = message;
        final String str2 = title;
        final String str3 = button;
        final boolean z = exit;
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setMessage(str);
                    dlg.setTitle(str2);
                    dlg.setCancelable(false);
                    dlg.setPositiveButton(str3, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            if (z) {
                                this.endActivity();
                            }
                        }
                    });
                    dlg.create();
                    dlg.show();
                } catch (Exception e) {
                    DroidGap.this.finish();
                }
            }
        });
    }

    public boolean isUrlWhiteListed(String url) {
        if (this.appView != null) {
            return this.appView.isUrlWhiteListed(url);
        }
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        postMessage("onCreateOptionsMenu", menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        postMessage("onPrepareOptionsMenu", menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        postMessage("onOptionsItemSelected", item);
        return true;
    }

    public Context getContext() {
        LOG.m2215d(TAG, "This will be deprecated December 2012");
        return this;
    }

    public void showWebPage(String url, boolean openExternal, boolean clearHistory, HashMap<String, Object> params) {
        if (this.appView != null) {
            this.appView.showWebPage(url, openExternal, clearHistory, params);
        }
    }

    public void removeSplashScreen() {
        if (this.splashDialog != null && this.splashDialog.isShowing()) {
            this.splashDialog.dismiss();
            this.splashDialog = null;
        }
    }

    /* access modifiers changed from: protected */
    public void showSplashScreen(final int time) {
        runOnUiThread(new Runnable() {
            public void run() {
                Display display = DroidGap.this.getWindowManager().getDefaultDisplay();
                LinearLayout root = new LinearLayout(this.getActivity());
                root.setMinimumHeight(display.getHeight());
                root.setMinimumWidth(display.getWidth());
                root.setOrientation(1);
                root.setBackgroundColor(this.getIntegerProperty(C1216LO.backgroundColor, -16777216));
                root.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, BitmapDescriptorFactory.HUE_RED));
                root.setBackgroundResource(this.splashscreen);
                DroidGap.this.splashDialog = new Dialog(this, 16973840);
                if ((DroidGap.this.getWindow().getAttributes().flags & 1024) == 1024) {
                    DroidGap.this.splashDialog.getWindow().setFlags(1024, 1024);
                }
                DroidGap.this.splashDialog.setContentView(root);
                DroidGap.this.splashDialog.setCancelable(false);
                DroidGap.this.splashDialog.show();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        DroidGap.this.removeSplashScreen();
                    }
                }, (long) time);
            }
        });
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.appView.getHitTestResult() != null && this.appView.getHitTestResult().getType() == 9 && (keyCode == 4 || keyCode == 82)) {
            return this.appView.onKeyUp(keyCode, event);
        }
        if (!this.appView.isCustomViewShowing() || keyCode != 4) {
            return super.onKeyUp(keyCode, event);
        }
        return this.appView.onKeyUp(keyCode, event);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.appView.getHitTestResult() != null && this.appView.getHitTestResult().getType() == 9 && keyCode == 4) {
            return this.appView.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    public Object onMessage(String id, Object data) {
        LOG.m2215d(TAG, "onMessage(" + id + "," + data + ")");
        if ("splashscreen".equals(id)) {
            if ("hide".equals(data.toString())) {
                removeSplashScreen();
                return null;
            } else if (this.splashDialog == null || this.splashDialog.isShowing()) {
                return null;
            } else {
                this.splashscreen = getIntegerProperty("splashscreen", 0);
                showSplashScreen(this.splashscreenTime);
                return null;
            }
        } else if ("spinner".equals(id)) {
            if (!"stop".equals(data.toString())) {
                return null;
            }
            spinnerStop();
            this.appView.setVisibility(0);
            return null;
        } else if ("onReceivedError".equals(id)) {
            JSONObject d = (JSONObject) data;
            try {
                onReceivedError(d.getInt("errorCode"), d.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION), d.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } else if (!"exit".equals(id)) {
            return null;
        } else {
            endActivity();
            return null;
        }
    }

    public ExecutorService getThreadPool() {
        return this.threadPool;
    }
}
