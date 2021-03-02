package com.tapcrowd.app.modules.webview;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import java.util.Calendar;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.api.CordovaInterface;

public class FormFragment extends TCFragment {
    String firsturl;
    String launcherid;
    ProgressBar progressbar;
    String url;
    CordovaWebView webview;

    public static FormFragment newInstance(String url2, String launcherid2) {
        FormFragment form = new FormFragment();
        form.url = url2;
        form.launcherid = launcherid2;
        return form;
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PlusShare.KEY_CALL_TO_ACTION_URL, this.url);
        outState.putString("launcherid", this.launcherid);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.cordova, container, false);
        AdHelper.showAds(this, "/" + (this.launcherid == null ? "" : this.launcherid));
        if (savedInstanceState != null && this.url == null) {
            this.url = savedInstanceState.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
            this.launcherid = savedInstanceState.getString("launcherid");
        }
        this.progressbar = (ProgressBar) v.findViewById(C0846R.C0847id.progress);
        this.webview = (CordovaWebView) v.findViewById(C0846R.C0847id.f1997wv);
        this.webview.loadUrl(this.url);
        this.webview.getSettings().setUseWideViewPort(false);
        this.webview.setWebViewClient(new MyCordovaWebViewClient((CordovaInterface) getActivity(), this.webview));
        this.webview.setWebChromeClient(new GapClient(getActivity()));
        this.webview.addJavascriptInterface(new JavaScriptInterface(this, (JavaScriptInterface) null), "jsinterface");
        WebSettings ws = this.webview.getSettings();
        ws.setUserAgentString(String.valueOf(ws.getUserAgentString()) + " NativeAppAndroid");
        return v;
    }

    public void loadScript(String script) {
        this.webview.loadUrl("javascript:(function() { " + script + "})()");
    }

    public class MyCordovaWebViewClient extends CordovaWebViewClient {
        public MyCordovaWebViewClient(CordovaInterface cordova, CordovaWebView view) {
            super(cordova, view);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("opennativelauncher")) {
                Fragments.clear();
            } else if (url.contains("submitted=1")) {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(FormFragment.this.getActivity());
                alertbox.setMessage("Your form has been submitted");
                alertbox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        FormFragment.this.getFragmentManager().popBackStack();
                    }
                });
                alertbox.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        FormFragment.this.getFragmentManager().popBackStack();
                    }
                });
            } else {
                view.loadUrl(url);
            }
            return false;
        }

        public void onPageFinished(WebView arg0, String url) {
            if (FormFragment.this.firsturl == null) {
                FormFragment.this.firsturl = url;
            }
            FormFragment.this.url = url;
            FormFragment.this.loadScript("$('input[type=\"date\"]').attr('readonly', 'readonly');$('input[type=\"date\"]').click(function(e) {window.jsinterface.openDatePicker(e.target.id);});");
            super.onPageFinished(arg0, url);
        }
    }

    private class JavaScriptInterface {
        private JavaScriptInterface() {
        }

        /* synthetic */ JavaScriptInterface(FormFragment formFragment, JavaScriptInterface javaScriptInterface) {
            this();
        }

        public void openDatePicker(final String id) {
            Calendar now = Calendar.getInstance();
            new DatePickerDialog(FormFragment.this.getActivity(), new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    final String date = String.valueOf(dayOfMonth) + "-" + (monthOfYear + 1) + "-" + year;
                    FragmentActivity activity = FormFragment.this.getActivity();
                    final String str = id;
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            FormFragment.this.loadScript("$('#" + str + "').val('" + date + "');");
                        }
                    });
                }
            }, now.get(1), now.get(2), now.get(5)).show();
        }
    }

    public class GapClient extends WebChromeClient {
        Context mCtx;

        public GapClient(Context ctx) {
            this.mCtx = ctx;
        }

        public void onReceivedTitle(WebView view, String title) {
            if (title != null && title.length() > 0 && FormFragment.this.url != null && FormFragment.this.url.contains("tap.cr")) {
                C1232UI.setTitle(title);
            }
            super.onReceivedTitle(view, title);
        }

        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            AlertDialog.Builder alertBldr = new AlertDialog.Builder(this.mCtx);
            alertBldr.setMessage(message);
            alertBldr.setTitle("Alert");
            alertBldr.show();
            result.confirm();
            return true;
        }

        public void onProgressChanged(WebView view, int newProgress) {
            FormFragment.this.progressbar.setProgress(newProgress);
            if (newProgress != 100) {
                FormFragment.this.progressbar.setVisibility(0);
            }
            if (newProgress == 100) {
                FormFragment.this.progressbar.setVisibility(8);
            }
        }
    }
}
