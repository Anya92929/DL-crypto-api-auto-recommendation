package com.appbrain.p032a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0715aj;
import com.appbrain.p036e.C1031d;

/* renamed from: com.appbrain.a.v */
final class C0975v implements C0974u {
    private C0975v() {
    }

    /* synthetic */ C0975v(byte b) {
        this();
    }

    /* renamed from: a */
    private static void m4082a(TextView textView, C0973t tVar) {
        C0705a.m3174a().mo3378a(textView, C0838c.m3706b((View) textView, (Drawable) C1031d.m4307a(tVar.f2580c.f2570d, tVar.f2580c.f2571e, tVar.f2580c.f2572f, tVar.mo3902b(0.5f), tVar.mo3903c(1.0f))));
        C0838c.m3704a(textView, tVar);
        textView.setTextSize(tVar.mo3901a(12.0f));
        textView.setPadding(tVar.mo3903c(8.0f), tVar.mo3903c(4.0f), tVar.mo3903c(8.0f), tVar.mo3903c(4.0f));
        textView.setMinWidth(tVar.mo3903c(96.0f));
    }

    /* renamed from: a */
    public final View mo3890a(Context context, C0973t tVar) {
        int c = tVar.mo3903c(2.0f);
        int c2 = tVar.mo3903c(4.0f);
        C0715aj ajVar = new C0715aj(context);
        ajVar.setMaxLines(1);
        ajVar.setText(tVar.f2578a);
        ajVar.setTextSize(tVar.mo3901a(13.0f));
        ajVar.setTextColor(tVar.f2580c.f2569c);
        ajVar.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = c;
        C0715aj ajVar2 = new C0715aj(context);
        TextView textView = new TextView(context);
        m4082a((TextView) ajVar2, tVar);
        m4082a(textView, tVar);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 1;
        int i = tVar.f2580c.f2568b;
        if (i == tVar.f2580c.f2567a) {
            i = (tVar.f2580c.f2567a & -16777216) | (((int) (0.95d * ((double) (tVar.f2580c.f2567a & 16711680)))) & 16711680) | (((int) (0.95d * ((double) (tVar.f2580c.f2567a & 65280)))) & 65280) | (((int) (0.95d * ((double) (tVar.f2580c.f2567a & 255)))) & 255);
        }
        C0976w wVar = new C0976w(this, tVar.f2580c.f2567a, i, tVar);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        C0705a.m3174a().mo3378a(linearLayout, wVar);
        linearLayout.setPadding(c2, c, c2, c2);
        linearLayout.addView(ajVar, layoutParams);
        linearLayout.addView(ajVar2, layoutParams2);
        return C0838c.m3703a(linearLayout, (TextView) ajVar2, textView);
    }
}
