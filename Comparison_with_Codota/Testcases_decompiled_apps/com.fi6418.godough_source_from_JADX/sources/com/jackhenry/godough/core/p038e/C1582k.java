package com.jackhenry.godough.core.p038e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.e.k */
public class C1582k {
    /* renamed from: a */
    public static View m6159a(List<C1583l> list, ViewGroup viewGroup, LayoutInflater layoutInflater, View.OnClickListener onClickListener) {
        View inflate = layoutInflater.inflate(C1496ak.location_detail_row, viewGroup, false);
        for (C1583l next : list) {
            if (next.f6159c != -1) {
                ((ImageView) inflate.findViewById(next.f6157a)).setImageResource(next.f6159c);
            } else {
                ((TextView) inflate.findViewById(next.f6157a)).setText(next.f6158b);
            }
        }
        inflate.findViewById(C1494ai.inner_panel).setOnClickListener(onClickListener);
        viewGroup.addView(inflate, viewGroup.getChildCount() - 1);
        return inflate;
    }

    /* renamed from: a */
    public static void m6160a(int i, String str, TableLayout tableLayout, LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(C1496ak.table_row_field_label, tableLayout, false);
        ((TextView) inflate.findViewById(C1494ai.row_label)).setText(i);
        ((TextView) inflate.findViewById(C1494ai.row_value)).setText(str);
        tableLayout.addView(inflate);
    }
}
