package com.tapcrowd.app.modules.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.launcher.TCLauncher;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import java.util.ArrayList;
import org.apache.http.util.EncodingUtils;

public class WebViewFragment extends TCFragment implements TCLauncher.BackPressedListener, MenuFragment.MenuItemListener {
    private final int SHARE = 418;
    boolean abstrac;
    String html;
    String launcherid;
    String post;
    String url;

    /* renamed from: v */
    View f2122v;
    WebView webview;

    public static WebViewFragment newInstance(String url2, String post2) {
        WebViewFragment webview2 = new WebViewFragment();
        webview2.url = url2;
        webview2.post = post2;
        return webview2;
    }

    public static WebViewFragment newInstance(String url2, boolean hideTitleBar) {
        WebViewFragment detail = new WebViewFragment();
        detail.url = url2;
        return detail;
    }

    public static WebViewFragment newInstance(String url2, boolean hideTitleBar, String launcherid2) {
        WebViewFragment detail = new WebViewFragment();
        detail.url = url2;
        detail.launcherid = launcherid2;
        return detail;
    }

    public static WebViewFragment newInstance(String html2, String title, String columnHack) {
        WebViewFragment webview2 = new WebViewFragment();
        webview2.html = html2;
        return webview2;
    }

    public static WebViewFragment newInstance(String html2, String title, String columnHack, boolean abstrac2) {
        WebViewFragment webview2 = new WebViewFragment();
        webview2.html = html2;
        webview2.abstrac = abstrac2;
        return webview2;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PlusShare.KEY_CALL_TO_ACTION_URL, this.url);
        outState.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.title);
        outState.putString("launcherid", this.launcherid);
        outState.putString("html", this.html);
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((TCLauncher) getActivity()).setBackPressedListener(this);
        AdHelper.showAds(this, "/" + (this.launcherid == null ? "" : this.launcherid));
        if (savedInstanceState != null && this.url == null && this.html == null) {
            this.url = savedInstanceState.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
            this.html = savedInstanceState.getString("html");
        }
        if (this.abstrac) {
            setupMenu();
        }
        if (this.f2122v == null) {
            this.f2122v = inflater.inflate(C0846R.layout.webview, container, false);
            C1232UI.show(C0846R.C0847id.loading, this.f2122v);
            C1232UI.hide(C0846R.C0847id.head, this.f2122v);
            ((ImageView) this.f2122v.findViewById(C0846R.C0847id.popup)).setImageDrawable(C1232UI.getColorOverlay((int) C0846R.drawable.icon_expand, C1216LO.getLo(C1216LO.separatorTextColor)));
            this.f2122v.findViewById(C0846R.C0847id.popup).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (WebViewFragment.this.getActivity().findViewById(C0846R.C0847id.contentbox1).getVisibility() == 0) {
                        WebViewFragment.this.getActivity().findViewById(C0846R.C0847id.contentbox1).setVisibility(8);
                        ((ImageView) v.findViewById(C0846R.C0847id.popup)).setImageDrawable(C1232UI.getColorOverlay((int) C0846R.drawable.icon_collapse, C1216LO.getLo(C1216LO.separatorTextColor)));
                        return;
                    }
                    WebViewFragment.this.getActivity().findViewById(C0846R.C0847id.contentbox1).setVisibility(0);
                    ((ImageView) v.findViewById(C0846R.C0847id.popup)).setImageDrawable(C1232UI.getColorOverlay((int) C0846R.drawable.icon_expand, C1216LO.getLo(C1216LO.separatorTextColor)));
                }
            });
            this.f2122v.findViewById(C0846R.C0847id.head).setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
            this.webview = (WebView) this.f2122v.findViewById(C0846R.C0847id.f1997wv);
            this.webview.setScrollBarStyle(0);
            this.webview.getSettings().setJavaScriptEnabled(true);
            this.webview.getSettings().setUseWideViewPort(true);
            this.webview.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(url));
                    WebViewFragment.this.startActivity(intent);
                }
            });
            this.webview.getSettings().setSupportZoom(true);
            this.webview.getSettings().setBuiltInZoomControls(true);
            this.webview.getSettings().setDomStorageEnabled(true);
            this.webview.getSettings().setUseWideViewPort(true);
            this.webview.getSettings().setLoadWithOverviewMode(true);
            this.webview.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int newProgress) {
                    ProgressBar progress = (ProgressBar) WebViewFragment.this.f2122v.findViewById(C0846R.C0847id.progress);
                    progress.setProgress(newProgress);
                    if (newProgress == 100) {
                        progress.setVisibility(8);
                    } else {
                        progress.setVisibility(0);
                    }
                }

                public void onReceivedTitle(WebView view, String title) {
                    C1232UI.setText((int) C0846R.C0847id.webviewtitle, title, WebViewFragment.this.f2122v);
                    ((TextView) WebViewFragment.this.f2122v.findViewById(C0846R.C0847id.webviewtitle)).setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
                    super.onReceivedTitle(view, title);
                }
            });
            this.webview.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url.contains("tel:")) {
                        Actions.doCall(url.replaceFirst("tel:", ""));
                        return true;
                    } else if (url.startsWith("mailto:")) {
                        Actions.doMail(url.replaceFirst("mailto:", ""));
                        return true;
                    } else {
                        view.loadUrl(url);
                        return false;
                    }
                }

                public void onPageFinished(WebView view, String url) {
                    App.notify = "";
                }
            });
            if (this.url != null) {
                if (this.url.equals("help")) {
                    this.webview.loadUrl("file:///android_asset/help.html");
                } else if (this.url.equals("info")) {
                    this.webview.loadUrl("file:///android_asset/info.html");
                } else {
                    if (!this.url.startsWith("http")) {
                        this.url = "http://" + this.url;
                    }
                    if (this.post != null) {
                        this.webview.postUrl(this.url, EncodingUtils.getBytes(this.post, "BASE64"));
                    } else {
                        this.webview.loadUrl(this.url);
                    }
                }
            }
            if (this.html != null) {
                String html2 = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf("") + "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>") + "<html><head>") + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />") + "</head>") + "<body>") + this.html) + "</body></html>";
                this.html = html2;
                this.webview.loadDataWithBaseURL("", html2, "text/html", "utf-8", "");
            }
            return this.f2122v;
        }
        ((ViewGroup) this.f2122v.getParent()).removeAllViews();
        return this.f2122v;
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 418));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 418:
                share();
                return;
            default:
                return;
        }
    }

    public void share() {
        Intent sendIntent = new Intent("android.intent.action.SEND");
        sendIntent.setType("message/rfc822");
        sendIntent.putExtra("android.intent.extra.TEXT", Html.fromHtml(this.html));
        startActivity(Intent.createChooser(sendIntent, "Mail:"));
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onDestroy() {
        ((TCLauncher) getActivity()).removeBackPressedListener();
        super.onDestroy();
    }

    public boolean onBackPressed() {
        if (!this.webview.canGoBack()) {
            return true;
        }
        this.webview.goBack();
        if (this.html != null) {
            this.webview.post(new Runnable() {
                public void run() {
                    if (!WebViewFragment.this.webview.canGoBack()) {
                        WebViewFragment.this.webview.loadDataWithBaseURL("", WebViewFragment.this.html, "text/html", "utf-8", "");
                    }
                }
            });
        }
        return false;
    }
}
