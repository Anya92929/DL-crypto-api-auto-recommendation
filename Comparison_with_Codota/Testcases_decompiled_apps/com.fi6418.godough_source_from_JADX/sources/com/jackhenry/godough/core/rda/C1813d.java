package com.jackhenry.godough.core.rda;

import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1801q;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.DepositTransaction;

/* renamed from: com.jackhenry.godough.core.rda.d */
public class C1813d extends C1801q<DepositTransaction> {

    /* renamed from: b */
    private int f6651b;

    public C1813d(int i, Fragment fragment) {
        super(fragment);
        this.f6651b = i;
    }

    public C1813d(Fragment fragment) {
        this(C1496ak.list_item_icon_nav, fragment);
    }

    /* renamed from: a */
    public C1349a<DepositTransaction> mo9278a(int i) {
        return new C1349a<>(new C1881x().mo11110c(), false, -1);
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, DepositTransaction depositTransaction) {
        View inflate = layoutInflater.inflate(this.f6651b, viewGroup);
        viewGroup.setTag(depositTransaction);
        ImageView imageView = (ImageView) inflate.findViewById(C1494ai.icon);
        imageView.setVisibility(0);
        ((TextView) inflate.findViewById(C1494ai.line1)).setText(GoDoughApp.getApp().getString(C1506am.lbl_check_deposit));
        ((TextView) inflate.findViewById(C1494ai.line2)).setText(depositTransaction.getSubmittedDateFormatted());
        ((TextView) inflate.findViewById(C1494ai.line2_right)).setText(C1364k.m5586a((double) depositTransaction.getEnteredAmount()));
        imageView.setImageResource(depositTransaction.isTransactionSuccessful() ? C1493ah.ic_success : C1493ah.ic_fail);
    }

    /* renamed from: b */
    public boolean mo9567b(View view, Exception exc) {
        mo10985a(exc);
        return false;
    }
}
