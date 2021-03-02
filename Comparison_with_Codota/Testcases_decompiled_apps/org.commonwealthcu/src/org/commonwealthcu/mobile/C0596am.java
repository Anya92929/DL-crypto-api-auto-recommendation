package org.commonwealthcu.mobile;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* renamed from: org.commonwealthcu.mobile.am */
public class C0596am extends Fragment {

    /* renamed from: a */
    private List f735a;

    /* renamed from: b */
    private ListView f736b;

    /* renamed from: c */
    private ArrayList f737c;

    /* renamed from: a */
    public static String m1291a(String str) {
        int indexOf = str.indexOf("//") + 2;
        int indexOf2 = str.indexOf("/", indexOf);
        if (indexOf2 < 0) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2).toLowerCase();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(C0137R.layout.moreview, viewGroup, false);
        MobileBankingApp mobileBankingApp = (MobileBankingApp) getActivity().getApplicationContext();
        JSONObject c = mobileBankingApp.mo5466c();
        this.f737c = new ArrayList();
        c.keys();
        new ArrayList();
        this.f735a = new ArrayList();
        int i = 1;
        String a = mobileBankingApp.mo5460a("LNK~_Label".replaceFirst("~", "1"));
        String a2 = mobileBankingApp.mo5460a("LNK~_Image".replaceFirst("~", "1"));
        String a3 = mobileBankingApp.mo5460a("DefaultBullet");
        if (a3 != null && a2 == null) {
            a2 = a3;
        }
        while (a != null) {
            HashMap hashMap = new HashMap();
            this.f735a.add(a);
            hashMap.put("title", a);
            if (str != null) {
                if (str.indexOf("#custom") < 0) {
                    str = str.substring(0, str.indexOf(46));
                }
                hashMap.put("image", str);
            }
            i++;
            a = mobileBankingApp.mo5460a("LNK~_Label".replaceFirst("~", String.valueOf(i)));
            str = mobileBankingApp.mo5460a("LNK~_Image".replaceFirst("~", String.valueOf(i)));
            if (a3 != null && str == null) {
                str = a3;
            }
            this.f737c.add(hashMap);
        }
        this.f736b = (ListView) inflate.findViewById(C0137R.C0139id.moreview);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        this.f736b.setAdapter(new C0595al(getActivity(), this.f737c));
        this.f736b.setOnItemClickListener(new C0597an(this));
    }
}
