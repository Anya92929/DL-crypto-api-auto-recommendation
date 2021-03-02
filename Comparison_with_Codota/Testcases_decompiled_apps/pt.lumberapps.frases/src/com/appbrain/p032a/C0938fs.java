package com.appbrain.p032a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cmn.C0709ad;

/* renamed from: com.appbrain.a.fs */
public class C0938fs implements C0947ga {
    /* renamed from: a */
    public final ViewGroup mo3859a(Context context, C0945fz fzVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(8.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        linearLayout.addView(fzVar.f2494c, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = C0709ad.m3188b(26.0f);
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
        layoutParams7.setMargins(C0709ad.m3188b(16.0f), 0, C0709ad.m3188b(16.0f), C0709ad.m3188b(8.0f));
        linearLayout.addView(fzVar.f2498g, layoutParams7);
        fzVar.f2498g.setGravity(1);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.bottomMargin = C0709ad.m3188b(16.0f);
        linearLayout.addView(fzVar.f2493b, layoutParams8);
        linearLayout.addView(fzVar.f2500i, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.topMargin = C0709ad.m3188b(16.0f);
        linearLayout.addView(fzVar.f2501j, layoutParams9);
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
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(C0709ad.m3188b(112.0f), C0709ad.m3188b(112.0f));
        layoutParams3.bottomMargin = C0709ad.m3188b(8.0f);
        linearLayout3.addView(fzVar.f2499h, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        linearLayout3.addView(fzVar.f2493b, layoutParams4);
        linearLayout2.addView(linearLayout3, layoutParams2);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.leftMargin = C0709ad.m3188b(16.0f);
        LinearLayout linearLayout4 = new LinearLayout(context);
        linearLayout4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout5 = new LinearLayout(context);
        linearLayout5.setOrientation(0);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        layoutParams7.weight = 1.0f;
        linearLayout5.addView(fzVar.f2495d, layoutParams7);
        fzVar.f2495d.setVisibility(4);
        linearLayout5.addView(fzVar.f2494c, new LinearLayout.LayoutParams(-2, -2));
        linearLayout4.addView(linearLayout5, layoutParams6);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.bottomMargin = C0709ad.m3188b(16.0f);
        linearLayout4.addView(fzVar.f2496e, layoutParams8);
        linearLayout4.addView(fzVar.f2497f, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.bottomMargin = C0709ad.m3188b(16.0f);
        linearLayout4.addView(fzVar.f2498g, layoutParams9);
        linearLayout4.addView(fzVar.f2500i, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(linearLayout4, layoutParams5);
        linearLayout.addView(linearLayout2, layoutParams);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.bottomMargin = C0709ad.m3188b(26.0f);
        layoutParams10.gravity = 1;
        linearLayout.addView(fzVar.f2492a, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams11.topMargin = C0709ad.m3188b(8.0f);
        linearLayout.addView(fzVar.f2501j, layoutParams11);
        return linearLayout;
    }
}
