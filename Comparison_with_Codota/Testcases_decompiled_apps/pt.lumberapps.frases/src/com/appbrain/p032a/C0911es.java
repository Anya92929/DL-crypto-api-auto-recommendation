package com.appbrain.p032a;

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import cmn.C0725at;
import com.appbrain.p037f.C1054at;
import com.appbrain.p037f.C1056av;
import com.appbrain.p037f.C1058ax;

/* renamed from: com.appbrain.a.es */
final class C0911es {
    /* renamed from: a */
    static String m3891a(Context context, C1056av avVar) {
        return !TextUtils.isEmpty(avVar.mo4244n()) ? avVar.mo4244n() : context.getString(17039370);
    }

    @TargetApi(11)
    /* renamed from: a */
    static void m3892a(FragmentManager fragmentManager, DialogFragment dialogFragment, String str) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(dialogFragment, str);
        try {
            beginTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
        }
    }

    /* renamed from: a */
    private static void m3893a(Context context, Intent intent) {
        if (C0725at.m3226a(context) == null) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    static void m3894a(Context context, String str, C1058ax axVar) {
        if (!TextUtils.isEmpty(str)) {
            C0890dy.m3857a().mo3770a("app_alert_action", 1);
            if (str.startsWith("offerwall://")) {
                C0936fq fqVar = new C0936fq(C1054at.APP_ALERT);
                fqVar.f2455c = axVar.name();
                C0934fo.m3998a(context, fqVar);
            } else if (str.startsWith("activity://")) {
                try {
                    m3893a(context, new Intent(context, Class.forName(str.substring(11))));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    m3893a(context, intent);
                } catch (ActivityNotFoundException e2) {
                    Toast.makeText(context, "Couldn't open URL", 0).show();
                }
            }
        }
    }
}
