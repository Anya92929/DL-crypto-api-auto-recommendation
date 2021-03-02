package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cmn.C0709ad;

/* renamed from: com.appbrain.a.fr */
public class C0937fr implements C0947ga {
    /* renamed from: c */
    private static ViewGroup m4004c(Context context, C0945fz fzVar) {
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
        linearLayout.setPadding(C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = C0709ad.m3188b(16.0f);
        linearLayout.addView(m4004c(context, fzVar), layoutParams);
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
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(C0709ad.m3188b(112.0f), C0709ad.m3188b(112.0f));
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
        layoutParams8.topMargin = C0709ad.m3188b(16.0f);
        linearLayout.addView(fzVar.f2501j, layoutParams8);
        fzVar.f2501j.setGravity(1);
        return linearLayout;
    }

    /* renamed from: a */
    public final boolean mo3860a() {
        return false;
    }

    /* renamed from: b */
    public final ViewGroup mo3861b(Context context, C0945fz fzVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = C0709ad.m3188b(8.0f);
        linearLayout.addView(m4004c(context, fzVar), layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = C0709ad.m3188b(34.0f);
        layoutParams2.gravity = 1;
        linearLayout.addView(fzVar.f2492a, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.addView(fzVar.f2499h, new LinearLayout.LayoutParams(C0709ad.m3188b(112.0f), C0709ad.m3188b(112.0f)));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.leftMargin = C0709ad.m3188b(8.0f);
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(1);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), 0);
        linearLayout3.addView(fzVar.f2495d, layoutParams5);
        fzVar.f2495d.setGravity(1);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), C0709ad.m3188b(16.0f));
        linearLayout3.addView(fzVar.f2496e, layoutParams6);
        fzVar.f2496e.setGravity(1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), 0);
        linearLayout3.addView(fzVar.f2497f, layoutParams7);
        fzVar.f2497f.setGravity(1);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), C0709ad.m3188b(16.0f));
        linearLayout3.addView(fzVar.f2498g, layoutParams8);
        fzVar.f2498g.setGravity(1);
        linearLayout3.addView(fzVar.f2500i, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(linearLayout3, layoutParams4);
        linearLayout.addView(linearLayout2, layoutParams3);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.topMargin = C0709ad.m3188b(8.0f);
        linearLayout.addView(fzVar.f2501j, layoutParams9);
        return linearLayout;
    }
}
