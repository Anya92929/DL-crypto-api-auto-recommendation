package com.jackhenry.godough.core.p034b.p035a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;

/* renamed from: com.jackhenry.godough.core.b.a.c */
public class C1512c extends DialogFragment {

    /* renamed from: aj */
    ListAdapter f5996aj;

    /* renamed from: ak */
    int f5997ak;

    /* renamed from: al */
    String f5998al;

    /* renamed from: am */
    View f5999am;

    /* renamed from: an */
    View f6000an;

    /* renamed from: ao */
    DialogInterface.OnDismissListener f6001ao;

    /* renamed from: ap */
    DialogInterface.OnClickListener f6002ap;

    /* renamed from: a */
    public void mo9711a(View view) {
        this.f6000an = view;
    }

    /* renamed from: a */
    public void mo9712a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        this.f5996aj = listAdapter;
        this.f5997ak = i;
        this.f6002ap = onClickListener;
    }

    /* renamed from: b */
    public void mo9713b(String str) {
        this.f5998al = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, getTheme());
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        dialog.getWindow().getDecorView().setBackgroundDrawable((Drawable) null);
        if (this.f6001ao != null) {
            dialog.setOnDismissListener(this.f6001ao);
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C1496ak.selection_dialog, viewGroup, false);
        ((TextView) viewGroup2.findViewById(C1494ai.title)).setText(this.f5998al);
        if (this.f5999am == null) {
            ListView listView = (ListView) viewGroup2.findViewById(C1494ai.list);
            listView.setAdapter(this.f5996aj);
            listView.setChoiceMode(1);
            if (this.f5997ak >= 0) {
                listView.setItemChecked(this.f5997ak, true);
                listView.setSelection(this.f5997ak);
            }
            listView.setOnItemClickListener(new C1513d(this));
        } else {
            ViewGroup viewGroup3 = (ViewGroup) this.f5999am.getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(this.f5999am);
            }
            ViewGroup viewGroup4 = (ViewGroup) viewGroup2.findViewById(C1494ai.content_frame);
            viewGroup4.removeAllViews();
            viewGroup4.addView(this.f5999am);
        }
        if (this.f6000an != null) {
            ViewGroup viewGroup5 = (ViewGroup) this.f6000an.getParent();
            if (viewGroup5 != null) {
                viewGroup5.removeView(this.f6000an);
            }
            viewGroup2.findViewById(C1494ai.footerDivider).setVisibility(0);
            ((ViewGroup) viewGroup2.findViewById(C1494ai.footer_frame)).addView(this.f6000an);
        }
        return viewGroup2;
    }

    public void onDestroyView() {
        boolean z = false;
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setOnDismissListener((DialogInterface.OnDismissListener) null);
            z = true;
        }
        if (z && this.f6001ao != null) {
            this.f6001ao.onDismiss(getDialog());
        }
        super.onDestroyView();
    }
}
