package org.apache.cordova;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.json.JSONArray;
import org.json.JSONException;

public class CordovaChromeClient extends WebChromeClient {
    private long MAX_QUOTA = 104857600;
    private String TAG = "CordovaLog";
    private CordovaWebView appView;
    private CordovaInterface cordova;
    private View mVideoProgressView;

    public CordovaChromeClient(CordovaInterface cordova2) {
        this.cordova = cordova2;
    }

    public CordovaChromeClient(CordovaInterface ctx, CordovaWebView app) {
        this.cordova = ctx;
        this.appView = app;
    }

    public void setWebView(CordovaWebView view) {
        this.appView = view;
    }

    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this.cordova.getActivity());
        dlg.setMessage(message);
        dlg.setTitle("Alert");
        dlg.setCancelable(true);
        dlg.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                result.confirm();
            }
        });
        dlg.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                result.cancel();
            }
        });
        dlg.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                result.confirm();
                return false;
            }
        });
        dlg.create();
        dlg.show();
        return true;
    }

    public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this.cordova.getActivity());
        dlg.setMessage(message);
        dlg.setTitle("Confirm");
        dlg.setCancelable(true);
        dlg.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                result.confirm();
            }
        });
        dlg.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                result.cancel();
            }
        });
        dlg.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                result.cancel();
            }
        });
        dlg.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                result.cancel();
                return false;
            }
        });
        dlg.create();
        dlg.show();
        return true;
    }

    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        boolean reqOk = false;
        if (url.startsWith("file://") || url.indexOf(this.appView.baseUrl) == 0 || this.appView.isUrlWhiteListed(url)) {
            reqOk = true;
        }
        if (reqOk && defaultValue != null && defaultValue.length() > 3 && defaultValue.substring(0, 4).equals("gap:")) {
            try {
                JSONArray array = new JSONArray(defaultValue.substring(4));
                String r = this.appView.exposedJsApi.exec(array.getString(0), array.getString(1), array.getString(2), message);
                if (r == null) {
                    r = "";
                }
                result.confirm(r);
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return true;
            }
        } else if (reqOk && defaultValue != null && defaultValue.equals("gap_bridge_mode:")) {
            this.appView.exposedJsApi.setNativeToJsBridgeMode(Integer.parseInt(message));
            result.confirm("");
            return true;
        } else if (reqOk && defaultValue != null && defaultValue.equals("gap_poll:")) {
            String r2 = this.appView.exposedJsApi.retrieveJsMessages();
            if (r2 == null) {
                r2 = "";
            }
            result.confirm(r2);
            return true;
        } else if (defaultValue == null || !defaultValue.equals("gap_init:")) {
            final JsPromptResult res = result;
            AlertDialog.Builder dlg = new AlertDialog.Builder(this.cordova.getActivity());
            dlg.setMessage(message);
            final EditText input = new EditText(this.cordova.getActivity());
            if (defaultValue != null) {
                input.setText(defaultValue);
            }
            dlg.setView(input);
            dlg.setCancelable(false);
            dlg.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    res.confirm(input.getText().toString());
                }
            });
            dlg.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    res.cancel();
                }
            });
            dlg.create();
            dlg.show();
            return true;
        } else {
            result.confirm("OK");
            return true;
        }
    }

    public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        LOG.m2217d(this.TAG, "DroidGap:  onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", Long.valueOf(estimatedSize), Long.valueOf(currentQuota), Long.valueOf(totalUsedQuota));
        if (estimatedSize < this.MAX_QUOTA) {
            long newQuota = estimatedSize;
            LOG.m2217d(this.TAG, "calling quotaUpdater.updateQuota newQuota: %d", Long.valueOf(newQuota));
            quotaUpdater.updateQuota(newQuota);
            return;
        }
        quotaUpdater.updateQuota(currentQuota);
    }

    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        LOG.m2217d(this.TAG, "%s: Line %d : %s", sourceID, Integer.valueOf(lineNumber), message);
        super.onConsoleMessage(message, lineNumber, sourceID);
    }

    @TargetApi(8)
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.message() != null) {
            LOG.m2215d(this.TAG, consoleMessage.message());
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(origin, callback);
        callback.invoke(origin, true, false);
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        this.appView.showCustomView(view, callback);
    }

    public void onHideCustomView() {
        this.appView.hideCustomView();
    }

    public View getVideoLoadingProgressView() {
        if (this.mVideoProgressView == null) {
            LinearLayout layout = new LinearLayout(this.appView.getContext());
            layout.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layout.setLayoutParams(layoutParams);
            ProgressBar bar = new ProgressBar(this.appView.getContext());
            LinearLayout.LayoutParams barLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            barLayoutParams.gravity = 17;
            bar.setLayoutParams(barLayoutParams);
            layout.addView(bar);
            this.mVideoProgressView = layout;
        }
        return this.mVideoProgressView;
    }
}
