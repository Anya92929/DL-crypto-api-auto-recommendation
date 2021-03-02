package com.appbrain.p032a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0709ad;
import cmn.C0725at;
import com.appbrain.p037f.C1056av;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.appbrain.a.em */
public final class C0905em {

    /* renamed from: a */
    private static final Handler f2380a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static List f2381b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static boolean f2382c;

    /* renamed from: a */
    private static Drawable m3880a(int i, int i2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(i2));
        stateListDrawable.addState(new int[0], new ColorDrawable(i));
        return stateListDrawable;
    }

    /* renamed from: a */
    static void m3881a(Activity activity, C1056av avVar) {
        boolean z = f2382c;
        f2380a.postDelayed(new C0906en(activity, avVar, z), z ? 200 : 0);
    }

    /* renamed from: a */
    static /* synthetic */ void m3882a(Activity activity, C1056av avVar, boolean z) {
        boolean z2;
        FrameLayout a = C0725at.m3227a(activity);
        if (a != null) {
            int i = 0;
            while (true) {
                if (i >= a.getChildCount()) {
                    z2 = false;
                    break;
                }
                Object tag = a.getChildAt(i).getTag();
                if (tag != null && tag.equals("appbrain.internal.AppAlertSliderManager")) {
                    z2 = true;
                    break;
                }
                i++;
            }
            if (!z2) {
                int t = avVar.mo4250t();
                C0910er erVar = new C0910er((byte) 0);
                switch (t) {
                    case 0:
                        int unused = erVar.f2389a = -1;
                        int unused2 = erVar.f2390b = -872415232;
                        int unused3 = erVar.f2391c = -867941308;
                        break;
                    case 1:
                        int unused4 = erVar.f2389a = -16777216;
                        int unused5 = erVar.f2390b = -855638017;
                        int unused6 = erVar.f2391c = -860111941;
                        break;
                }
                int b = C0709ad.m3188b(50.0f);
                TextView textView = new TextView(activity);
                textView.setPadding(C0709ad.m3188b(16.0f), C0709ad.m3188b(4.0f), C0709ad.m3188b(16.0f), C0709ad.m3188b(4.0f));
                textView.setText(avVar.mo4240j());
                textView.setTextColor(erVar.f2389a);
                TextView textView2 = new TextView(activity);
                textView2.setTextSize(1, 28.0f);
                textView2.setTextColor(erVar.f2389a);
                C0705a.m3174a().mo3378a(textView2, m3880a(0, erVar.f2391c));
                textView2.setGravity(17);
                textView2.setText("×");
                textView2.setOnClickListener(new C0907eo(avVar));
                LinearLayout linearLayout = new LinearLayout(activity);
                linearLayout.setTag("appbrain.internal.AppAlertSliderManager");
                linearLayout.setOrientation(0);
                C0705a.m3174a().mo3378a(linearLayout, m3880a(erVar.f2390b, erVar.f2391c));
                linearLayout.setBaselineAligned(false);
                linearLayout.setGravity(16);
                linearLayout.setMinimumHeight(b);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
                linearLayout.addView(textView2, new LinearLayout.LayoutParams(b, -1));
                if (avVar.mo4245o()) {
                    linearLayout.setOnClickListener(new C0908ep(avVar, activity));
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                a.addView(linearLayout, layoutParams);
                if (f2381b == null) {
                    f2381b = new ArrayList();
                }
                f2381b.add(new WeakReference(linearLayout));
                if (z) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    translateAnimation.setDuration(200);
                    translateAnimation.setAnimationListener(new C0909eq());
                    linearLayout.startAnimation(translateAnimation);
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3883a(C1056av avVar, boolean z) {
        if (f2381b != null) {
            for (WeakReference weakReference : f2381b) {
                View view = (View) weakReference.get();
                if (view != null) {
                    if (view.getAnimation() != null) {
                        view.getAnimation().cancel();
                    }
                    if (view.getParent() != null) {
                        if (view.isShown()) {
                            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                            translateAnimation.setDuration(200);
                            view.startAnimation(translateAnimation);
                        }
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                }
            }
            f2381b.clear();
        }
        f2382c = true;
        C0902ej.m3874a(avVar, z);
    }
}
