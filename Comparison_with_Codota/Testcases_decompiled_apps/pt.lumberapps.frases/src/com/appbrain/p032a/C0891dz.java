package com.appbrain.p032a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import cmn.C0725at;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.dz */
public final class C0891dz {

    /* renamed from: a */
    private static final C0899eg f2361a = new C0899eg();

    /* renamed from: a */
    static void m3860a(Activity activity, C1056av avVar) {
        C0725at.m3228a((Runnable) new C0893ea(activity, avVar));
    }

    /* renamed from: a */
    static /* synthetic */ void m3861a(C1056av avVar, boolean z) {
        f2361a.mo3782a();
        C0902ej.m3874a(avVar, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m3862b(C1056av avVar) {
        return "appbrain.internal.AppAlertDialogManager" + avVar.mo4238h();
    }

    /* renamed from: b */
    static /* synthetic */ void m3863b(Activity activity, C1056av avVar) {
        if (!f2361a.mo3784a(activity)) {
            Dialog e = m3866e(activity, avVar);
            e.setOnCancelListener(new C0894eb(avVar));
            f2361a.mo3783a(activity, e);
            e.show();
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m3864c(Activity activity, C1056av avVar) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            fragmentManager.executePendingTransactions();
            if (fragmentManager.findFragmentByTag(m3862b(avVar)) == null) {
                C0898ef.m3867a(fragmentManager, avVar);
            }
        } catch (RuntimeException e) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static Dialog m3866e(Activity activity, C1056av avVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(avVar.mo4240j());
        if (avVar.mo4245o()) {
            builder.setNegativeButton(!TextUtils.isEmpty(avVar.mo4242l()) ? avVar.mo4242l() : activity.getString(17039360), new C0895ec(avVar));
            builder.setPositiveButton(C0911es.m3891a((Context) activity, avVar), new C0896ed(avVar, activity));
        } else {
            builder.setNeutralButton(C0911es.m3891a((Context) activity, avVar), new C0897ee(avVar));
        }
        return builder.create();
    }
}
