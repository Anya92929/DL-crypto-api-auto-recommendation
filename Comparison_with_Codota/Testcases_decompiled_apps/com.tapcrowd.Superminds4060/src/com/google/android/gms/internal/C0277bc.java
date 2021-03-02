package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.internal.bc */
public final class C0277bc {
    /* renamed from: a */
    public static boolean m560a(Context context, C0279be beVar, C0291bl blVar) {
        if (beVar == null) {
            C0344cn.m737q("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(beVar.f845fz)) {
            C0344cn.m737q("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(beVar.mimeType)) {
            intent.setDataAndType(Uri.parse(beVar.f845fz), beVar.mimeType);
        } else {
            intent.setData(Uri.parse(beVar.f845fz));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(beVar.packageName)) {
            intent.setPackage(beVar.packageName);
        }
        if (!TextUtils.isEmpty(beVar.f841fA)) {
            String[] split = beVar.f841fA.split("/", 2);
            if (split.length < 2) {
                C0344cn.m737q("Could not parse component name from open GMSG: " + beVar.f841fA);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            C0344cn.m736p("Launching an intent: " + intent);
            context.startActivity(intent);
            blVar.mo4145A();
            return true;
        } catch (ActivityNotFoundException e) {
            C0344cn.m737q(e.getMessage());
            return false;
        }
    }
}
