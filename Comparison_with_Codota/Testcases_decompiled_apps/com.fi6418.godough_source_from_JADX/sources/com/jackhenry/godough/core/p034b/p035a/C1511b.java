package com.jackhenry.godough.core.p034b.p035a;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;

/* renamed from: com.jackhenry.godough.core.b.a.b */
public class C1511b extends DialogFragment {
    /* renamed from: b */
    public static C1511b m5994b(String str) {
        if (str == null) {
            str = GoDoughApp.getApp().getString(C1506am.dg_loading);
        }
        C1511b bVar = new C1511b();
        bVar.setRetainInstance(true);
        Bundle bundle = new Bundle();
        bundle.putString("P_MESSAGE", str);
        bVar.setCancelable(false);
        bVar.setArguments(bundle);
        return bVar;
    }

    /* renamed from: l */
    public static C1511b m5995l() {
        return m5994b((String) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, getTheme());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().getDecorView().setBackgroundDrawable((Drawable) null);
        String str = (String) getArguments().get("P_MESSAGE");
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(C1496ak.progress_dialog, viewGroup, false);
        TextView textView = (TextView) linearLayout.findViewById(C1494ai.message_text);
        textView.setText(str);
        if (str.equals("NOLABEL")) {
            textView.setVisibility(8);
        }
        return linearLayout;
    }
}
