package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cmn.C0709ad;

/* renamed from: com.appbrain.a.ft */
public class C0939ft implements C0947ga {
    /* renamed from: c */
    private static ViewGroup m4011c(Context context, C0945fz fzVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(fzVar.f2493b, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(new View(context), layoutParams);
        linearLayout.addView(fzVar.f2494c, new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    /* renamed from: a */
    public final ViewGroup mo3859a(Context context, C0945fz fzVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(0, C0709ad.m3188b(8.0f), 0, C0709ad.m3188b(8.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(C0709ad.m3188b(8.0f), 0, C0709ad.m3188b(8.0f), C0709ad.m3188b(16.0f));
        linearLayout.addView(m4011c(context, fzVar), layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = C0709ad.m3188b(42.0f);
        linearLayout.addView(fzVar.f2492a, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), 0);
        linearLayout.addView(fzVar.f2495d, layoutParams3);
        fzVar.f2495d.setGravity(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), C0709ad.m3188b(16.0f));
        linearLayout.addView(fzVar.f2496e, layoutParams4);
        fzVar.f2496e.setGravity(1);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.bottomMargin = C0709ad.m3188b(16.0f);
        linearLayout.addView(fzVar.f2499h, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), 0);
        linearLayout.addView(fzVar.f2497f, layoutParams6);
        fzVar.f2497f.setGravity(1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), C0709ad.m3188b(16.0f));
        linearLayout.addView(fzVar.f2498g, layoutParams7);
        fzVar.f2498g.setGravity(1);
        linearLayout.addView(fzVar.f2500i, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.setMargins(C0709ad.m3188b(8.0f), C0709ad.m3188b(16.0f), C0709ad.m3188b(8.0f), 0);
        linearLayout.addView(fzVar.f2501j, layoutParams8);
        fzVar.f2501j.setGravity(1);
        return linearLayout;
    }

    /* renamed from: a */
    public final boolean mo3860a() {
        return true;
    }

    /* renamed from: b */
    public final ViewGroup mo3861b(Context context, C0945fz fzVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f));
        linearLayout.addView(m4011c(context, fzVar), new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = C0709ad.m3188b(26.0f);
        layoutParams.gravity = 1;
        linearLayout.addView(fzVar.f2492a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), 0);
        linearLayout.addView(fzVar.f2495d, layoutParams2);
        fzVar.f2495d.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), C0709ad.m3188b(16.0f));
        linearLayout.addView(fzVar.f2496e, layoutParams3);
        fzVar.f2496e.setGravity(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, 0);
        layoutParams5.weight = 1.0f;
        linearLayout2.addView(fzVar.f2499h, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2);
        layoutParams6.leftMargin = C0709ad.m3188b(8.0f);
        layoutParams6.weight = 1.0f;
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        linearLayout3.addView(fzVar.f2497f, new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.addView(fzVar.f2498g, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.topMargin = C0709ad.m3188b(16.0f);
        linearLayout3.addView(fzVar.f2500i, layoutParams7);
        linearLayout2.addView(linearLayout3, layoutParams6);
        linearLayout.addView(linearLayout2, layoutParams4);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.topMargin = C0709ad.m3188b(8.0f);
        linearLayout.addView(fzVar.f2501j, layoutParams8);
        fzVar.f2501j.setGravity(1);
        return linearLayout;
    }
}
