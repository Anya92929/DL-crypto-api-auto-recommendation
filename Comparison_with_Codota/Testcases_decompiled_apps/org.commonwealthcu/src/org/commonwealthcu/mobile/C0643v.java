package org.commonwealthcu.mobile;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import org.commonwealthcu.mobile.p038a.C0583e;
import org.json.JSONObject;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.v */
public final class C0643v extends Fragment implements C0583e {

    /* renamed from: a */
    public String f858a;

    /* renamed from: b */
    public int f859b;

    /* renamed from: c */
    private WebView f860c;

    /* renamed from: d */
    private View f861d;

    /* renamed from: e */
    private TextView f862e;

    /* renamed from: f */
    private String f863f;

    /* renamed from: a */
    public final void mo5450a(String str) {
    }

    /* renamed from: a */
    public final void mo5451a(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getBoolean("IsInputValid")) {
            switch (jSONObject.getInt("LoginValidation")) {
                case 1:
                    this.f860c.loadDataWithBaseURL("file:///android_asset/", "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/style.css\"></head><div>" + jSONObject.getString("DeniedContents") + "</div>", "text/html", "UTF-8", (String) null);
                    this.f861d.findViewById(C0137R.C0139id.okButton);
                    this.f861d.findViewById(C0137R.C0139id.acceptButton).setVisibility(8);
                    this.f861d.findViewById(C0137R.C0139id.cancelButton).setVisibility(8);
                    this.f861d.findViewById(C0137R.C0139id.okButton).setVisibility(0);
                    return;
                case 2:
                    this.f860c.loadDataWithBaseURL("file:///android_asset/", "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/style.css\"></head><div>" + jSONObject.getString("PendingContents") + "</div>", "text/html", "UTF-8", (String) null);
                    this.f861d.findViewById(C0137R.C0139id.okButton);
                    this.f861d.findViewById(C0137R.C0139id.acceptButton).setVisibility(8);
                    this.f861d.findViewById(C0137R.C0139id.cancelButton).setVisibility(8);
                    this.f861d.findViewById(C0137R.C0139id.okButton).setVisibility(0);
                    return;
                case 3:
                    this.f860c.loadDataWithBaseURL("file:///android_asset/", "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/style.css\"></head><div>" + jSONObject.getString("EUAContents") + "</div>", "text/html", "UTF-8", (String) null);
                    this.f861d.findViewById(C0137R.C0139id.acceptButton).setVisibility(0);
                    this.f861d.findViewById(C0137R.C0139id.cancelButton).setVisibility(0);
                    this.f861d.findViewById(C0137R.C0139id.okButton).setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    public final void mo5454b(String str) {
    }

    /* renamed from: c */
    public final void mo5574c(String str) {
        this.f863f = str;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0137R.layout.euaview, viewGroup, false);
        this.f860c = (WebView) inflate.findViewById(C0137R.C0139id.euaWebView);
        this.f861d = inflate;
        C0250b.m92a((Context) getActivity(), this.f861d);
        getActivity().getIntent().getExtras();
        String str = this.f858a;
        int i = this.f859b;
        this.f862e = (TextView) inflate.findViewById(C0137R.C0139id.euaHeaderText);
        if (!(this.f863f == null || this.f862e == null)) {
            this.f862e.setText(this.f863f);
        }
        this.f860c.loadDataWithBaseURL("file:///android_asset/", "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/style.css\"></head><div>" + str + "</div>", "text/html", "UTF-8", (String) null);
        if (i == 3) {
            this.f861d.findViewById(C0137R.C0139id.acceptButton).setVisibility(0);
            this.f861d.findViewById(C0137R.C0139id.cancelButton).setVisibility(0);
            this.f861d.findViewById(C0137R.C0139id.okButton).setVisibility(8);
        } else {
            this.f861d.findViewById(C0137R.C0139id.acceptButton).setVisibility(8);
            this.f861d.findViewById(C0137R.C0139id.cancelButton).setVisibility(8);
            this.f861d.findViewById(C0137R.C0139id.okButton).setVisibility(0);
        }
        return inflate;
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onStop() {
        super.onStop();
    }
}
