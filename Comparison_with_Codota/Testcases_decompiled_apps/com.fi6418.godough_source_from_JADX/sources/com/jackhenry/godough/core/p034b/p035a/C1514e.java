package com.jackhenry.godough.core.p034b.p035a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Message;
import android.support.p000v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.b.a.e */
public class C1514e extends DialogFragment {

    /* renamed from: aj */
    private AlertDialog f6004aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public C1576e f6005ak;

    /* renamed from: a */
    public static C1514e m5999a(C1576e eVar, boolean z) {
        C1514e eVar2 = new C1514e();
        eVar2.f6005ak = eVar;
        eVar2.setCancelable(z);
        return eVar2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(this.f6005ak.mo9793b());
        if (this.f6005ak.mo9797f() != null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(GoDoughApp.getApp()).inflate(C1496ak.dialog, (ViewGroup) null, false);
            ((ViewGroup) linearLayout.findViewById(C1494ai.content_frame)).addView(this.f6005ak.mo9797f(), new FrameLayout.LayoutParams(-1, -2));
            builder.setView(linearLayout);
        } else {
            builder.setMessage(this.f6005ak.mo9794c());
        }
        List<C1574c> e = this.f6005ak.mo9796e();
        if (e.size() == 0) {
            builder.setPositiveButton(GoDoughApp.getApp().getString(C1506am.btn_ok), new C1515f(this));
        }
        if (e.size() > 0) {
            builder.setPositiveButton(e.get(0).mo9789b(), new C1516g(this, e));
        }
        if (e.size() > 1) {
            builder.setNegativeButton(e.get(1).mo9789b(), new C1517h(this, e));
        }
        if (e.size() > 2) {
            builder.setNeutralButton(e.get(2).mo9789b(), new C1518i(this, e));
        }
        this.f6004aj = builder.create();
        return this.f6004aj;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage((Message) null);
        }
        if (this.f6004aj.isShowing()) {
            this.f6004aj.hide();
        }
        super.onDestroyView();
    }
}
