package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

@C1130ez
/* renamed from: com.google.android.gms.internal.dh */
public final class C1053dh {
    /* renamed from: a */
    public static boolean m4228a(Context context, C1055dj djVar, C1068dq dqVar) {
        if (djVar == null) {
            C1229gs.m4679W("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(djVar.f3151rq)) {
            C1229gs.m4679W("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(djVar.mimeType)) {
            intent.setDataAndType(Uri.parse(djVar.f3151rq), djVar.mimeType);
        } else {
            intent.setData(Uri.parse(djVar.f3151rq));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(djVar.packageName)) {
            intent.setPackage(djVar.packageName);
        }
        if (!TextUtils.isEmpty(djVar.f3152rr)) {
            String[] split = djVar.f3152rr.split("/", 2);
            if (split.length < 2) {
                C1229gs.m4679W("Could not parse component name from open GMSG: " + djVar.f3152rr);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            C1229gs.m4678V("Launching an intent: " + intent);
            context.startActivity(intent);
            dqVar.mo8361ab();
            return true;
        } catch (ActivityNotFoundException e) {
            C1229gs.m4679W(e.getMessage());
            return false;
        }
    }
}
