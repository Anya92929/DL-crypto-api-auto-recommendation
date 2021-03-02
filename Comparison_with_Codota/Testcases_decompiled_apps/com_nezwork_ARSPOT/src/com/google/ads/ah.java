package com.google.ads;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import java.util.HashMap;

public class ah implements n {

    public enum b {
        AD("ad"),
        APP("app");
        
        public String c;

        private b(String str) {
            this.c = str;
        }
    }

    private static class c implements DialogInterface.OnClickListener {
        private d a;

        public c(d dVar) {
            this.a = dVar;
        }

        public void onClick(DialogInterface dialog, int which) {
            HashMap hashMap = new HashMap();
            hashMap.put(AdActivity.URL_PARAM, "market://details?id=com.google.android.apps.plus");
            AdActivity.launchAdActivity(this.a, new e("intent", hashMap));
        }
    }

    private static class a implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
        }
    }

    public void a(d dVar, HashMap<String, String> hashMap, WebView webView) {
        Context a2 = dVar.h().d.a();
        String str = hashMap.get("a");
        if (str != null) {
            if (str.equals("resize")) {
                af.a(webView, hashMap.get(AdActivity.URL_PARAM));
                return;
            } else if (str.equals("state")) {
                af.a(dVar.h().c.a(), webView, hashMap.get(AdActivity.URL_PARAM));
                return;
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
        if (ag.a(intent, a2)) {
            AdActivity.launchAdActivity(dVar, new e("plusone", hashMap));
        } else if (!ag.a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.plus")), a2)) {
        } else {
            if (TextUtils.isEmpty(hashMap.get("d")) || TextUtils.isEmpty(hashMap.get(AdActivity.ORIENTATION_PARAM)) || TextUtils.isEmpty(hashMap.get("c"))) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(AdActivity.URL_PARAM, "market://details?id=com.google.android.apps.plus");
                AdActivity.launchAdActivity(dVar, new e("intent", hashMap2));
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(a2);
            builder.setMessage(hashMap.get("d")).setPositiveButton(hashMap.get(AdActivity.ORIENTATION_PARAM), new c(dVar)).setNegativeButton(hashMap.get("c"), new a());
            builder.create().show();
        }
    }
}
