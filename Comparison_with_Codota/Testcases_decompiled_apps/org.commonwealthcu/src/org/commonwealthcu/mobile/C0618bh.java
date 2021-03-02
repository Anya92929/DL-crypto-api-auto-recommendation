package org.commonwealthcu.mobile;

import android.app.Activity;
import android.content.Context;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.bh */
public final class C0618bh extends BaseAdapter {

    /* renamed from: b */
    private static Activity f828b;

    /* renamed from: c */
    private static LayoutInflater f829c;

    /* renamed from: a */
    private JSONArray f830a;

    /* renamed from: d */
    private List f831d = new ArrayList();

    /* renamed from: e */
    private List f832e = new ArrayList();

    public C0618bh(Activity activity, JSONArray jSONArray) {
        f828b = activity;
        this.f830a = jSONArray;
        f829c = (LayoutInflater) activity.getSystemService("layout_inflater");
        f828b.getPackageName();
    }

    /* renamed from: a */
    public final List mo5538a() {
        return this.f831d;
    }

    /* renamed from: a */
    public final void mo5539a(JSONArray jSONArray) {
        this.f830a = jSONArray;
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public final List mo5540b() {
        return this.f832e;
    }

    public final int getCount() {
        return this.f830a.length();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = f829c.inflate(C0137R.layout.vertifi_tablecell, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(C0137R.C0139id.vertifi_review_depositlabel);
        TextView textView2 = (TextView) inflate.findViewById(C0137R.C0139id.vertifi_review_datelabel);
        TextView textView3 = (TextView) inflate.findViewById(C0137R.C0139id.vertifi_review_amountlabel);
        this.f831d.add((Button) inflate.findViewById(C0137R.C0139id.vertifi_review_deletebutton));
        try {
            JSONObject jSONObject = this.f830a.getJSONObject(i);
            String string = jSONObject.getString("ID");
            this.f832e.add(string);
            textView.setText("Deposit #" + string);
            textView3.setText(NumberFormat.getCurrencyInstance().format(Double.valueOf(jSONObject.getDouble("Amount"))));
            String str = jSONObject.getString("CreateTimestamp").split("\\(")[1].split("\\)")[0];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(Long.parseLong(str.substring(0, str.length() - 3)) * 1000);
            String format = simpleDateFormat.format(instance.getTime());
            System.out.println("Found date of : " + format);
            textView2.setText("Submitted " + format);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C0250b.m92a((Context) f828b, inflate);
        return inflate;
    }
}
