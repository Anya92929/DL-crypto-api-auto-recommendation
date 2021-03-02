package com.jackhenry.godough.core.ach;

import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1801q;
import com.jackhenry.godough.core.model.ACH;
import com.jackhenry.godough.core.model.ACHBatches;

/* renamed from: com.jackhenry.godough.core.ach.a */
public class C1470a extends C1801q<ACH> {

    /* renamed from: b */
    private int f5949b;

    /* renamed from: c */
    private ACHBatches f5950c;

    /* renamed from: d */
    private boolean f5951d;

    public C1470a(int i, Fragment fragment) {
        super(fragment);
        this.f5951d = false;
        this.f5949b = i;
    }

    public C1470a(Fragment fragment) {
        this(C1496ak.list_item_icon_nav, fragment);
    }

    /* renamed from: a */
    public C1349a<ACH> mo9278a(int i) {
        if (this.f5951d || i < 0) {
            i = 0;
        }
        this.f5951d = false;
        this.f5950c = new C1487r().mo9693a(i);
        return new C1349a<>(this.f5950c.getBatches(), this.f5950c.isMoreRecords(), this.f5950c.getNextStartRecord());
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, ACH ach) {
        View inflate = layoutInflater.inflate(this.f5949b, viewGroup);
        viewGroup.setTag(ach);
        TextView textView = (TextView) inflate.findViewById(C1494ai.line2_right);
        ((TextView) inflate.findViewById(C1494ai.line1)).setText(ach.getName());
        ((TextView) inflate.findViewById(C1494ai.line2)).setText(ach.getCompanyName());
        String totalDebitsFormatted = ach.getTotalDebitsFormatted();
        if (ach.getTotalCredits() >= ach.getTotalDebits()) {
            totalDebitsFormatted = ach.getTotalCreditsFormatted();
        }
        textView.setText(totalDebitsFormatted);
    }

    /* renamed from: a */
    public void mo9677a(boolean z) {
        this.f5951d = z;
    }

    /* renamed from: b */
    public boolean mo9567b(View view, Exception exc) {
        mo10985a(exc);
        return false;
    }
}
