package com.appbrain.p032a;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0715aj;
import com.appbrain.p036e.C1031d;

/* renamed from: com.appbrain.a.y */
final class C0978y implements C0974u {

    /* renamed from: a */
    private final Typeface f2587a;

    /* renamed from: b */
    private final float f2588b;

    /* renamed from: c */
    private final float f2589c;

    /* renamed from: d */
    private final float f2590d;

    private C0978y(Typeface typeface, float f, float f2, float f3) {
        this.f2587a = typeface;
        this.f2588b = f;
        this.f2589c = f2;
        this.f2590d = f3;
    }

    /* synthetic */ C0978y(Typeface typeface, float f, float f2, float f3, byte b) {
        this(typeface, f, f2, f3);
    }

    /* renamed from: a */
    private void m4087a(TextView textView, C0973t tVar, int i) {
        C0705a.m3174a().mo3378a(textView, C0838c.m3706b((View) textView, (Drawable) C1031d.m4307a(tVar.f2580c.f2570d, tVar.f2580c.f2571e, tVar.f2580c.f2572f, tVar.mo3902b(this.f2589c), tVar.mo3903c(this.f2590d))));
        C0838c.m3704a(textView, tVar);
        textView.setTextSize(tVar.mo3901a(13.0f));
        textView.setPadding(i, i, i, i);
    }

    /* renamed from: a */
    public final View mo3890a(Context context, C0973t tVar) {
        int c = tVar.mo3903c(4.0f);
        int c2 = tVar.mo3903c(8.0f);
        C0715aj ajVar = new C0715aj(context);
        ajVar.setMaxLines(2);
        ajVar.setText(tVar.f2578a);
        ajVar.setTypeface(this.f2587a);
        ajVar.setTextSize(tVar.mo3901a(13.0f));
        ajVar.setTextColor(tVar.f2580c.f2569c);
        ajVar.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f - this.f2588b;
        layoutParams.leftMargin = c2;
        layoutParams.rightMargin = c2;
        C0715aj ajVar2 = new C0715aj(context);
        TextView textView = new TextView(context);
        m4087a(ajVar2, tVar, c);
        m4087a(textView, tVar, c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = this.f2588b;
        layoutParams2.rightMargin = c;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{tVar.f2580c.f2567a, tVar.f2580c.f2568b});
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        C0705a.m3174a().mo3378a(linearLayout, gradientDrawable);
        linearLayout.addView(ajVar, layoutParams);
        linearLayout.addView(ajVar2, layoutParams2);
        linearLayout.setPadding(0, c, 0, c);
        return C0838c.m3703a(linearLayout, (TextView) ajVar2, textView);
    }
}
