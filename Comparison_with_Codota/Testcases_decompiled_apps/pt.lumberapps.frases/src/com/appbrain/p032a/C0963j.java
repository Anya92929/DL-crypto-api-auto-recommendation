package com.appbrain.p032a;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0715aj;
import com.appbrain.p036e.C1031d;

/* renamed from: com.appbrain.a.j */
final class C0963j implements C0974u {
    private C0963j() {
    }

    /* synthetic */ C0963j(byte b) {
        this();
    }

    /* renamed from: a */
    private static void m4075a(TextView textView, C0973t tVar, int i) {
        float b = tVar.mo3902b(0.5f);
        int c = tVar.mo3903c(4.0f);
        int i2 = i + c;
        C0705a.m3174a().mo3378a(textView, new InsetDrawable(C0838c.m3700a((View) textView, (Drawable) C1031d.m4307a(tVar.f2580c.f2570d, tVar.f2580c.f2571e, tVar.f2580c.f2572f, b, tVar.mo3903c(1.4f)), (Drawable) new C0965l(c, b)), c));
        C0838c.m3704a(textView, tVar);
        textView.setTextSize(tVar.mo3901a(13.0f));
        textView.setPadding(i2, i2, i2, i2);
        textView.setMinHeight(tVar.mo3903c(40.0f));
    }

    /* renamed from: a */
    public final View mo3890a(Context context, C0973t tVar) {
        int c = tVar.mo3903c(4.0f);
        int c2 = tVar.mo3903c(10.0f);
        int c3 = tVar.mo3903c(30.0f);
        int c4 = tVar.mo3903c(16.0f);
        C0715aj ajVar = new C0715aj(context);
        ajVar.setMaxLines(2);
        ajVar.setText(tVar.f2578a);
        ajVar.setTextSize(tVar.mo3901a(13.0f));
        ajVar.setTextColor(tVar.f2580c.f2569c);
        ajVar.setTypeface(Typeface.SERIF);
        ajVar.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 2.0f;
        layoutParams.leftMargin = c2 + c4;
        layoutParams.rightMargin = c;
        C0715aj ajVar2 = new C0715aj(context);
        TextView textView = new TextView(context);
        m4075a(ajVar2, tVar, c);
        m4075a(textView, tVar, c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = c2 + c4;
        C0964k kVar = new C0964k(this, tVar, c4, c2, c3);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{tVar.f2580c.f2567a, tVar.f2580c.f2568b}), kVar});
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        C0705a.m3174a().mo3378a(linearLayout, layerDrawable);
        linearLayout.setPadding(0, c, 0, c);
        linearLayout.addView(ajVar, layoutParams);
        linearLayout.addView(ajVar2, layoutParams2);
        return C0838c.m3703a(linearLayout, (TextView) ajVar2, textView);
    }
}
