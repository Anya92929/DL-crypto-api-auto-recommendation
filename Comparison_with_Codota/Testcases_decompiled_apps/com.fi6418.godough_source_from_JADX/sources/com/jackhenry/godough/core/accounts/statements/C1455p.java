package com.jackhenry.godough.core.accounts.statements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.accounts.statements.model.StatementGroup;
import com.jackhenry.godough.core.p038e.C1567a;
import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.accounts.statements.p */
public class C1455p extends BaseExpandableListAdapter {

    /* renamed from: a */
    private ArrayList<StatementGroup> f5909a;

    /* renamed from: b */
    private LayoutInflater f5910b;

    /* renamed from: c */
    private Context f5911c;

    public C1455p(ArrayList<StatementGroup> arrayList, Context context) {
        this.f5909a = arrayList;
        this.f5911c = context;
        this.f5910b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public Object getChild(int i, int i2) {
        return this.f5909a.get(i).getStatementDetails().get(i2);
    }

    public long getChildId(int i, int i2) {
        return 0;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        String str;
        if (view == null) {
            view = this.f5910b.inflate(C1496ak.statements_child_item_1_line, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C1494ai.statement_date);
        String a = C1567a.m6122a(this.f5911c, Long.valueOf(this.f5909a.get(i).getStatementDetails().get(i2).getStatementDate().getTimeInMillis()));
        if (this.f5909a.get(i).isDate()) {
            str = this.f5911c.getString(C1506am.statements_x, new Object[]{Integer.valueOf(i2 + 1)});
        } else {
            str = a;
        }
        textView.setText(str);
        return view;
    }

    public int getChildrenCount(int i) {
        return this.f5909a.get(i).getStatementDetails().size();
    }

    public Object getGroup(int i) {
        return this.f5909a.get(i);
    }

    public int getGroupCount() {
        return this.f5909a.size();
    }

    public long getGroupId(int i) {
        return 0;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View inflate = this.f5910b.inflate(C1496ak.statements_parent_item_1_line, viewGroup, false);
        ((TextView) inflate.findViewById(C1494ai.accountName)).setText(this.f5909a.get(i).getStatementTitle());
        return inflate;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
