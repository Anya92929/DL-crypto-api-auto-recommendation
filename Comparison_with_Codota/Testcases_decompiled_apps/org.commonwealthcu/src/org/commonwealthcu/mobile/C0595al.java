package org.commonwealthcu.mobile;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.al */
public final class C0595al extends BaseAdapter {

    /* renamed from: b */
    private static Activity f731b;

    /* renamed from: c */
    private static LayoutInflater f732c;

    /* renamed from: d */
    private static String f733d;

    /* renamed from: a */
    private ArrayList f734a;

    public C0595al(Activity activity, ArrayList arrayList) {
        f731b = activity;
        this.f734a = arrayList;
        f732c = (LayoutInflater) activity.getSystemService("layout_inflater");
        f733d = f731b.getPackageName();
    }

    public final int getCount() {
        return this.f734a.size();
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = f732c.inflate(C0137R.layout.moretablecell, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(C0137R.C0139id.moreCellImage);
        new HashMap();
        HashMap hashMap = (HashMap) this.f734a.get(i);
        ((TextView) inflate.findViewById(C0137R.C0139id.moreCellTitle)).setText((CharSequence) hashMap.get("title"));
        String str = (String) hashMap.get("image");
        if (str != null) {
            if (str.indexOf("#custom") >= 0) {
                String substring = str.substring(str.indexOf("_") + 1);
                imageView.setImageDrawable(Drawable.createFromPath(f731b.getFileStreamPath(str.indexOf("#customhd") >= 0 ? substring.substring(0, substring.indexOf(".")) + "@2x" + substring.substring(substring.indexOf(".")) : substring).toString()));
            } else {
                int identifier = f731b.getResources().getIdentifier(str, "drawable", f733d);
                if (identifier != 0) {
                    imageView.setImageDrawable(f731b.getResources().getDrawable(identifier));
                }
            }
        }
        C0250b.m92a((Context) f731b, inflate);
        return inflate;
    }
}
