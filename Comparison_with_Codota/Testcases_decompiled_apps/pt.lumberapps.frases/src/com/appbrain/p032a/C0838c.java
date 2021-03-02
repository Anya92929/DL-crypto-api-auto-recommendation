package com.appbrain.p032a;

import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0709ad;
import cmn.C0715aj;
import cmn.C0720ao;
import cmn.C0738bf;
import com.appbrain.p036e.C1028a;
import com.appbrain.p040i.C1116a;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.appbrain.a.c */
public final class C0838c {

    /* renamed from: a */
    public static final C0970q[] f2210a = {new C0970q(-12303292, -15658735, -1118482, -12207149, -12736838, -1, -1, -10967038), new C0970q(-1, -1118482, -13421773, -12207149, -12736838, -1, -1, -10967038), new C0970q(-2565928, -2565928, -13421773, -10967038, -10967038, -1, -1, -10967038), new C0970q(-13224394, -13224394, -1, -16738603, -16738603, 0, -1, -37373), new C0970q(-16738603, -16738603, -1, -2796288, -2796288, -1, -1, -10967038), new C0970q(-1, -1, -16777216, -10967038, -10967038, -1, -1, -37373), new C0970q(-34304, -2135038, -1, -2031540, -2031540, -1, -1, -13824), new C0970q(-5869824, -4223184, -1, -22016, -22016, -1, -1, -12173), new C0970q(-5895168, -4244944, -1, -60672, -60672, -1, -1, -4105646), new C0970q(-16744682, -14314952, -1, -15897058, -15897058, -1, -1, -13049514), new C0970q(-15252318, -13876104, -1, -16308633, -16308633, -1, -1, -10057779), new C0970q(-12384921, -10868616, -1, -9695070, -9695070, -1, -1, -6004531), new C0970q(-1710619, -3618873, -12435134, -1, -1, -1, -12435134, -3223858), new C0970q(-1, -1, -12435134, -856091, -856091, -4609383, -12435134, -1645868)};

    /* renamed from: b */
    public static final C0974u[] f2211b = {new C0978y(Typeface.DEFAULT, 0.33333334f, 1.0f, 1.0f, (byte) 0), new C0978y(Typeface.SERIF, 0.3f, 0.5f, 1.5f, (byte) 0), new C0963j((byte) 0), new C0975v((byte) 0)};

    /* renamed from: c */
    private static final int[] f2212c = {3};

    /* renamed from: a */
    public static int m3698a(boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            if (z || !m3705a(i)) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return ((Integer) arrayList.get(C0738bf.m3250a(arrayList.size()))).intValue();
    }

    /* renamed from: a */
    static /* synthetic */ Drawable m3700a(View view, Drawable drawable, Drawable drawable2) {
        return view.isInEditMode() ? drawable : C1028a.m4302a(view.getContext(), drawable, drawable2);
    }

    /* renamed from: a */
    static ShapeDrawable m3701a(int i, C0977x xVar) {
        Path path = new Path();
        RectF rectF = new RectF();
        path.moveTo(0.0f, 24.0f);
        rectF.set(22.0f, 2.0f, 66.0f, 46.0f);
        path.arcTo(rectF, 180.0f, 180.0f);
        path.moveTo(88.0f, 24.0f);
        rectF.set(78.0f, 78.0f, 88.0f, 88.0f);
        path.arcTo(rectF, 0.0f, 90.0f);
        rectF.set(0.0f, 78.0f, 10.0f, 88.0f);
        path.arcTo(rectF, 90.0f, 90.0f);
        path.lineTo(0.0f, 24.0f);
        path.close();
        rectF.set(30.0f, 10.0f, 58.0f, 38.0f);
        path.arcTo(rectF, 0.0f, -180.0f);
        path.close();
        path.moveTo(32.0f, 40.0f);
        path.lineTo(32.0f, 73.0f);
        path.lineTo(61.0f, 56.5f);
        path.close();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new PathShape(path, 88.0f, 88.0f));
        if (xVar == null) {
            shapeDrawable.setIntrinsicHeight(C0709ad.m3188b(44.0f));
            shapeDrawable.setIntrinsicWidth(C0709ad.m3188b(44.0f));
        } else {
            shapeDrawable.setIntrinsicHeight(xVar.mo3903c(44.0f));
            shapeDrawable.setIntrinsicWidth(xVar.mo3903c(44.0f));
        }
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    /* renamed from: a */
    static /* synthetic */ View m3702a(Context context, C0979z zVar, C0970q qVar, Drawable drawable, Drawable drawable2, int i, int i2, int i3, boolean z, boolean z2, Drawable drawable3) {
        int c = zVar.mo3903c(4.0f);
        int c2 = zVar.mo3903c(8.0f);
        int c3 = zVar.mo3903c(50.0f);
        int c4 = zVar.mo3903c(42.0f);
        ImageView imageView = new ImageView(context);
        C0720ao.m3213a().mo3407b(imageView, zVar.f2591a.f2551c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c4, c4);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = c2;
        C0715aj ajVar = new C0715aj(context);
        ajVar.setMaxLines(1);
        if (z2) {
            ajVar.setTypeface(ajVar.getTypeface(), 1);
        }
        ajVar.setText(zVar.f2591a.f2549a);
        ajVar.setTextSize(zVar.mo3901a(z ? 13.0f : 16.0f));
        ajVar.setTextColor(qVar.f2569c);
        C0715aj ajVar2 = new C0715aj(context);
        ajVar2.setMaxLines(z ? 2 : 1);
        ajVar2.setText(zVar.f2591a.f2550b);
        ajVar2.setTextSize(zVar.mo3901a(z ? 10.0f : 13.0f));
        ajVar2.setTextColor(qVar.f2569c);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(ajVar);
        linearLayout.addView(ajVar2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(c, c, c, c);
        linearLayout2.addView(imageView, layoutParams);
        linearLayout2.addView(linearLayout, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.rightMargin = i;
        String language = context.getResources().getConfiguration().locale.getLanguage();
        TextView textView = new TextView(context);
        textView.setText(C0801aq.m3606a(4, language));
        textView.setTextSize(zVar.mo3901a(16.0f));
        textView.setTextColor(qVar.f2573g);
        textView.setMaxLines(1);
        textView.setVisibility(8);
        textView.setPadding(zVar.mo3903c(16.0f), 0, zVar.mo3903c(8.0f), 0);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(drawable);
        imageView2.setPadding(i2, i2, i2, i2);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(i - (i3 * 2), c3 - (i3 * 2)));
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        linearLayout3.addView(textView);
        linearLayout3.addView(imageView2);
        linearLayout2.setOnClickListener(new C0961h(textView, new C1116a(linearLayout3)));
        linearLayout3.setOnClickListener(zVar.f2591a.f2552d);
        C0705a.m3174a().mo3378a(linearLayout3, m3706b((View) linearLayout3, drawable2));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = i3;
        layoutParams4.rightMargin = i3;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        C0705a.m3174a().mo3378a(relativeLayout, drawable3);
        relativeLayout.addView(linearLayout2, layoutParams3);
        relativeLayout.addView(linearLayout3, layoutParams4);
        return relativeLayout;
    }

    /* renamed from: a */
    static /* synthetic */ RelativeLayout m3703a(LinearLayout linearLayout, TextView textView, TextView textView2) {
        RelativeLayout relativeLayout = new RelativeLayout(linearLayout.getContext());
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        linearLayout.setOnClickListener(new C0865d(textView2, textView, relativeLayout, new C1116a(relativeLayout)));
        return relativeLayout;
    }

    /* renamed from: a */
    static /* synthetic */ void m3704a(TextView textView, C0973t tVar) {
        textView.setMaxLines(2);
        textView.setGravity(17);
        textView.setTextColor(tVar.f2580c.f2573g);
        textView.setText(tVar.f2579b);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setOnClickListener(tVar.f2581d);
    }

    /* renamed from: a */
    public static boolean m3705a(int i) {
        return Arrays.binarySearch(f2212c, i) >= 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Drawable m3706b(View view, Drawable drawable) {
        return view.isInEditMode() ? drawable : C1028a.m4305b(view.getContext(), drawable);
    }

    /* renamed from: b */
    static /* synthetic */ ShapeDrawable m3707b(int i, C0977x xVar) {
        Path path = new Path();
        path.moveTo(14.0f, 7.0f);
        path.lineTo(23.0f, 7.0f);
        path.lineTo(23.0f, 19.0f);
        path.lineTo(29.0f, 19.0f);
        path.lineTo(19.0f, 30.0f);
        path.lineTo(9.0f, 19.0f);
        path.lineTo(14.0f, 19.0f);
        path.close();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new PathShape(path, 38.0f, 38.0f));
        shapeDrawable.setIntrinsicHeight(xVar.mo3903c(48.0f));
        shapeDrawable.setIntrinsicWidth(xVar.mo3903c(48.0f));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    /* renamed from: b */
    public static C0785aa m3708b(int i) {
        switch (i) {
            case 0:
                return new C0967n((byte) 0);
            case 1:
                return new C0966m((byte) 0);
            case 2:
                return new C0786ab();
            case 3:
                return new C0971r((byte) 0);
            default:
                return null;
        }
    }

    /* renamed from: c */
    static /* synthetic */ int m3709c(int i) {
        return -16777216 | ((((i & 16711680) * 2) / 3) & 16711680) | ((((i & 65280) * 2) / 3) & 65280) | ((((i & 255) * 2) / 3) & 255);
    }
}
