package com.jackhenry.godough.core.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.about.a */
public class C1411a extends ArrayAdapter<C1413c> {

    /* renamed from: a */
    private ArrayList<C1413c> f5809a;

    /* renamed from: b */
    private Context f5810b;

    public C1411a(Context context, int i, ArrayList<C1413c> arrayList) {
        super(context, i, arrayList);
        this.f5809a = arrayList;
        this.f5810b = context;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f5810b.getSystemService("layout_inflater")).inflate(C1496ak.list_item_about, viewGroup, false);
        }
        ((TextView) view.findViewById(C1494ai.line1)).setText(this.f5809a.get(i).getText());
        return view;
    }
}
