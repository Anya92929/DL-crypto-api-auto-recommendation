package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.commonwealthcu.mobile.p038a.C0581c;
import org.commonwealthcu.mobile.p038a.C0583e;
import org.json.JSONArray;
import org.json.JSONObject;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.ay */
public class C0608ay extends Fragment implements C0583e {

    /* renamed from: a */
    private ListView f781a;

    /* renamed from: b */
    private JSONArray f782b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0583e f783c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f784d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f785e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f786f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public VertifiActivity f787g;

    /* renamed from: h */
    private TextView f788h;

    /* renamed from: i */
    private ProgressDialog f789i;

    /* renamed from: b */
    private static void m1318b() {
        File file = new File(Environment.getExternalStorageDirectory(), "temp_deposit.pdf");
        if (file.exists()) {
            file.delete();
        }
        System.out.println("Deleteing Temp PDF File");
    }

    /* renamed from: a */
    public final void mo5522a() {
        this.f789i = ProgressDialog.show(this.f787g, "", "Processing. Please wait...", true);
    }

    /* renamed from: a */
    public final void mo5450a(String str) {
        if (this.f789i != null) {
            this.f789i.dismiss();
        }
        this.f789i = null;
        new AlertDialog.Builder(this.f787g).setTitle("Request Timed Out").setMessage("The request timed out, please verify connection to the internet and try again.").setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
    }

    /* renamed from: a */
    public final void mo5451a(String str, String str2) {
        if (this.f789i != null) {
            this.f789i.dismiss();
        }
        JSONObject jSONObject = new JSONObject(str);
        if (str2.equals("historyquery")) {
            if (jSONObject.getBoolean("IsInputValid")) {
                this.f782b = jSONObject.getJSONArray("Deposits");
            }
            System.out.println("Running once ---------");
            this.f781a.setAdapter(new C0618bh(getActivity(), this.f782b));
            this.f788h.setText(this.f782b.length() + " Items Found");
            if (this.f782b.length() == 1) {
                this.f788h.setText(this.f782b.length() + " Item Found");
            }
            this.f781a.setOnItemClickListener(new C0609az(this));
        } else if (str2.equals("historypdfquery") && jSONObject.getBoolean("IsInputValid")) {
            System.out.println("Kicking off Asyn Task");
            C0611ba baVar = new C0611ba(this, (byte) 0);
            try {
                baVar.execute(new URL[]{new URL(jSONObject.getString("PDFURL"))});
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public final void mo5454b(String str) {
    }

    /* renamed from: c */
    public final HashMap mo5523c(String str) {
        HashMap hashMap = new HashMap();
        Map f = ((MobileBankingApp) getActivity().getApplicationContext()).mo5470f();
        if (f != null) {
            for (Map.Entry entry : f.entrySet()) {
                System.out.println("QueryString has : " + ((String) entry.getKey()) + " = " + ((String) entry.getValue()));
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("action", str);
        if (this.f786f != null) {
            hashMap.put("reference", this.f786f);
        }
        return hashMap;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MobileBankingApp mobileBankingApp = (MobileBankingApp) getActivity().getApplicationContext();
        String d = mobileBankingApp.mo5468d();
        this.f783c = this;
        getActivity();
        this.f787g = (VertifiActivity) getActivity();
        HashMap c = mo5523c("historyquery");
        this.f785e = mobileBankingApp.mo5471g();
        this.f784d = d + "/commonfiles/iPhone/asppages/vertifi.aspx";
        mo5522a();
        new C0581c(this, c, (File) null, (File) null).execute(new String[]{this.f784d, this.f785e});
        View inflate = layoutInflater.inflate(C0137R.layout.vertifi_reviewview, viewGroup, false);
        this.f781a = (ListView) inflate.findViewById(C0137R.C0139id.vertifi_review_list);
        View inflate2 = layoutInflater.inflate(C0137R.layout.vertifi_listfooter, (ViewGroup) null, false);
        this.f788h = (TextView) inflate2.findViewById(C0137R.C0139id.vertif_review_footer);
        this.f781a.addFooterView(inflate2);
        C0250b.m92a((Context) getActivity(), inflate);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        m1318b();
    }

    public void onResume() {
        super.onResume();
        m1318b();
    }

    public void onStart() {
        super.onStart();
    }
}
