package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.commonwealthcu.mobile.p038a.C0581c;
import org.commonwealthcu.mobile.p038a.C0583e;
import org.json.JSONArray;
import org.json.JSONObject;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.bb */
public class C0612bb extends Fragment implements C0583e {

    /* renamed from: a */
    private ListView f797a;

    /* renamed from: b */
    private JSONArray f798b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0583e f799c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f800d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f801e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f802f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public VertifiActivity f803g;

    /* renamed from: h */
    private TextView f804h;

    /* renamed from: i */
    private List f805i;

    /* renamed from: j */
    private C0618bh f806j;

    /* renamed from: k */
    private Boolean f807k = false;

    /* renamed from: l */
    private Boolean f808l = false;

    /* renamed from: m */
    private Button f809m;

    /* renamed from: n */
    private ProgressDialog f810n;

    /* renamed from: c */
    private static void m1331c() {
        File file = new File(Environment.getExternalStorageDirectory(), "temp_deposit.pdf");
        if (file.exists()) {
            file.delete();
        }
        System.out.println("Deleteing Temp PDF File");
    }

    /* renamed from: a */
    public final void mo5528a() {
        this.f808l = true;
        HashMap c = mo5530c("helddelete");
        System.out.println("Deleting deposit #" + this.f802f);
        mo5529b();
        new C0581c(this, c, (File) null, (File) null).execute(new String[]{this.f800d, this.f801e});
    }

    /* renamed from: a */
    public final void mo5450a(String str) {
        if (this.f810n != null) {
            this.f810n.dismiss();
        }
        this.f810n = null;
        new AlertDialog.Builder(this.f803g).setTitle("Request Timed Out").setMessage("The request timed out, please verify connection to the internet and try again.").setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
    }

    /* renamed from: a */
    public final void mo5451a(String str, String str2) {
        if (this.f810n != null) {
            this.f810n.dismiss();
        }
        JSONObject jSONObject = new JSONObject(str);
        if (str2.equals("heldquery") && !this.f808l.booleanValue()) {
            if (jSONObject.getBoolean("IsInputValid")) {
                this.f798b = jSONObject.getJSONArray("Deposits");
            }
            System.out.println("Running once ---------");
            this.f806j = new C0618bh(getActivity(), this.f798b);
            this.f797a.setAdapter(this.f806j);
            this.f804h.setText(this.f798b.length() + " Items Found");
            this.f797a.setOnItemClickListener(new C0613bc(this));
        } else if (str2.equals("heldquery") && this.f808l.booleanValue()) {
            if (jSONObject.getBoolean("IsInputValid")) {
                this.f798b = jSONObject.getJSONArray("Deposits");
            }
            this.f804h.setText(this.f798b.length() + " Items Found");
            this.f806j.mo5539a(this.f798b);
            this.f808l = false;
        } else if (str2.equals("heldpdfquery")) {
            if (jSONObject.getBoolean("IsInputValid")) {
                System.out.println("Kicking off Asyn Task");
                try {
                    new C0616bf(this, (byte) 0).execute(new URL[]{new URL(jSONObject.getString("PDFURL"))});
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } else if (str2.equals("helddelete")) {
            int i = jSONObject.getInt("DeletedDepositId");
            if (i != 0) {
                new AlertDialog.Builder(this.f803g).setTitle("Deposit Deleted").setMessage("Deposit #" + i + " deleted successfully.").setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
            } else {
                String string = jSONObject.getString("ErrorMessage");
                String str3 = "";
                if (string.length() > 0) {
                    str3 = " Error - " + string;
                }
                new AlertDialog.Builder(this.f803g).setTitle("Error").setMessage("There was an issue deleting the deposit." + str3).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
            }
            HashMap c = mo5530c("heldquery");
            mo5529b();
            new C0581c(this, c, (File) null, (File) null).execute(new String[]{this.f800d, this.f801e});
        }
    }

    /* renamed from: b */
    public final void mo5529b() {
        this.f810n = ProgressDialog.show(this.f803g, "", "Processing. Please wait...", true);
    }

    /* renamed from: b */
    public final void mo5454b(String str) {
    }

    /* renamed from: c */
    public final HashMap mo5530c(String str) {
        HashMap hashMap = new HashMap();
        Map f = ((MobileBankingApp) getActivity().getApplicationContext()).mo5470f();
        if (f != null) {
            for (Map.Entry entry : f.entrySet()) {
                System.out.println("QueryString has : " + ((String) entry.getKey()) + " = " + ((String) entry.getValue()));
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("action", str);
        if (this.f802f != null) {
            hashMap.put("reference", this.f802f);
        }
        return hashMap;
    }

    public void deletePressed(View view) {
        int positionForView = this.f797a.getPositionForView((View) view.getParent()) - 1;
        System.out.println("The position is " + positionForView);
        this.f802f = (String) this.f806j.mo5540b().get(positionForView);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f803g);
        builder.setMessage("Delete deposit #" + this.f802f + "?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new C0614bd(this));
        builder.setNegativeButton("Cancel", new C0615be(this));
        builder.create().show();
    }

    public void editList(View view) {
        int i;
        this.f805i = this.f806j.mo5538a();
        if (this.f807k.booleanValue()) {
            this.f807k = false;
            this.f809m.setTextColor(Color.rgb(0, 0, 0));
            this.f809m.setBackgroundDrawable(getResources().getDrawable(C0137R.C0138drawable.round_button));
            i = 8;
        } else {
            this.f807k = true;
            this.f809m.setTextColor(Color.rgb(255, 255, 255));
            this.f809m.setBackgroundDrawable(getResources().getDrawable(C0137R.C0138drawable.round_button_pressed));
            i = 0;
        }
        for (int i2 = 0; i2 < this.f805i.size(); i2++) {
            ((Button) this.f805i.get(i2)).setVisibility(i);
        }
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
        this.f799c = this;
        this.f803g = (VertifiActivity) getActivity();
        HashMap c = mo5530c("heldquery");
        this.f801e = mobileBankingApp.mo5471g();
        this.f800d = d + "/commonfiles/iPhone/asppages/vertifi.aspx";
        mo5529b();
        new C0581c(this, c, (File) null, (File) null).execute(new String[]{this.f800d, this.f801e});
        View inflate = layoutInflater.inflate(C0137R.layout.vertifi_reviewview, viewGroup, false);
        this.f797a = (ListView) inflate.findViewById(C0137R.C0139id.vertifi_review_list);
        View inflate2 = layoutInflater.inflate(C0137R.layout.vertifi_listfooter, (ViewGroup) null, false);
        this.f804h = (TextView) inflate2.findViewById(C0137R.C0139id.vertif_review_footer);
        this.f797a.addFooterView(inflate2);
        View inflate3 = layoutInflater.inflate(C0137R.layout.vertifi_listheader, (ViewGroup) null, false);
        this.f809m = (Button) inflate3.findViewById(C0137R.C0139id.vertifi_review_editbutton);
        this.f797a.addHeaderView(inflate3);
        C0250b.m92a((Context) getActivity(), inflate);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        m1331c();
    }

    public void onResume() {
        super.onResume();
        m1331c();
    }

    public void onStart() {
        super.onStart();
    }
}
