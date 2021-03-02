package com.appbrain.p032a;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import cmn.C0725at;
import com.appbrain.AppBrainActivity;
import com.appbrain.C1025d;
import com.appbrain.C1027e;
import com.appbrain.C1099g;
import com.appbrain.p037f.C1054at;

/* renamed from: com.appbrain.a.fo */
public class C0934fo {

    /* renamed from: a */
    private static final String f2449a = C0934fo.class.getSimpleName();

    /* renamed from: a */
    static Context m3992a(Context context) {
        return Build.VERSION.SDK_INT >= 14 ? new ContextThemeWrapper(context, 16974123) : new ContextThemeWrapper(context, 16973836);
    }

    /* renamed from: a */
    static View m3993a(View view) {
        return m3994a((View) null, view);
    }

    /* renamed from: a */
    static View m3994a(View view, View view2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        RelativeLayout relativeLayout = new RelativeLayout(view2.getContext());
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (view != null) {
            relativeLayout.addView(view, -1, -1);
        }
        relativeLayout.addView(view2, layoutParams);
        return relativeLayout;
    }

    /* renamed from: a */
    public static C0929fj m3995a(C0930fk fkVar) {
        String string = fkVar.getArguments().getString("screen");
        if ("interstitial".equals(string)) {
            return new C0809ay(fkVar);
        }
        if ("offerwall".equals(string)) {
            return new C0829br(fkVar);
        }
        if ("app_popup".equals(string)) {
            return new C0940fu(fkVar);
        }
        if ("redirect".equals(string)) {
            return new C0854cp(fkVar);
        }
        new StringBuilder("Screen type ").append(string).append(" not recognized");
        return null;
    }

    /* renamed from: a */
    static void m3996a(Dialog dialog) {
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.flags |= 2;
        attributes.dimAmount = 0.6f;
        attributes.windowAnimations = 16973826;
    }

    /* renamed from: a */
    private static void m3997a(Context context, Bundle bundle, C1027e eVar) {
        C0725at.m3228a((Runnable) new C0935fp(context, eVar, bundle));
    }

    /* renamed from: a */
    static void m3998a(Context context, C0936fq fqVar) {
        Bundle bundle = new Bundle();
        bundle.putString("screen", "offerwall");
        bundle.putInt("src", fqVar.f2453a.mo4236a());
        bundle.putString("ca", fqVar.f2455c);
        if (fqVar.f2454b == -1) {
            bundle.putInt("aid", C0794aj.m3602a(fqVar.f2459g));
        } else {
            bundle.putInt("aid", fqVar.f2454b);
        }
        if (fqVar.f2457e) {
            bundle.putBoolean("bo", m4001a());
        }
        if (fqVar.f2456d != null) {
            bundle.putInt("bt", fqVar.f2456d.intValue());
        }
        if (fqVar.f2460h != null) {
            bundle.putInt("id", fqVar.f2460h.intValue());
        }
        m3997a(context, bundle, fqVar.f2458f);
    }

    /* renamed from: a */
    static void m3999a(Context context, String str, C0844cf cfVar) {
        Bundle bundle = new Bundle();
        bundle.putString("screen", "redirect");
        bundle.putString("url", str);
        bundle.putSerializable("clk", cfVar);
        AppBrainActivity.m3569a(context, bundle);
    }

    /* renamed from: a */
    static void m4000a(Context context, boolean z, C1025d dVar) {
        if (dVar == null) {
            dVar = new C1025d();
        }
        boolean z2 = false;
        if (dVar.mo4041g() != null && !(z2 = dVar.mo4041g().mo3617b())) {
            Log.println(6, "AppBrain", "Ad id '" + dVar.mo4041g() + "' is not an interstitial id. Using no ad id instead.");
        }
        if (dVar.mo4034a() == C1099g.MORE_APPS) {
            m4002b(context, z, dVar);
        } else if (dVar.mo4034a() == C1099g.SINGLE_APP) {
            m4003c(context, z, dVar);
        } else {
            if (Math.random() < C0932fm.m3968a().mo3839a("iskip", 0.0d)) {
                C0936fq fqVar = new C0936fq(C1054at.SKIPPED_INTERSTITIAL);
                fqVar.f2458f = dVar.mo4040f();
                fqVar.f2459g = dVar.mo4039e();
                if (z2) {
                    fqVar.f2460h = Integer.valueOf(dVar.mo4041g().mo3616a());
                }
                m3998a(context, fqVar);
                return;
            }
            if (Math.random() < C0932fm.m3968a().mo3839a("apppopup", 0.05d)) {
                m4003c(context, z, dVar);
            } else {
                m4002b(context, z, dVar);
            }
        }
    }

    /* renamed from: a */
    private static boolean m4001a() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        String name = C0934fo.class.getPackage().getName();
        int i = 0;
        while (i < stackTrace.length) {
            if (stackTrace[i].getClassName().startsWith(name)) {
                i++;
            } else if (i == stackTrace.length - 1) {
                return false;
            } else {
                String className = stackTrace[i + 1].getClassName();
                return className.startsWith("android.view") || className.startsWith("com.android.internal.view.menu");
            }
        }
        return false;
    }

    /* renamed from: b */
    private static void m4002b(Context context, boolean z, C1025d dVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("aid", C0794aj.m3602a(dVar.mo4039e()));
        bundle.putString("screen", "interstitial");
        bundle.putBoolean("maybe", z);
        bundle.putSerializable("adop", dVar);
        m3997a(context, bundle, dVar.mo4040f());
    }

    /* renamed from: c */
    private static void m4003c(Context context, boolean z, C1025d dVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("aid", C0794aj.m3602a(dVar.mo4039e()));
        bundle.putString("screen", "app_popup");
        bundle.putSerializable(C0940fu.f2461a, dVar);
        bundle.putBoolean(C0940fu.f2462b, z);
        m3997a(context, bundle, dVar.mo4040f());
    }
}
