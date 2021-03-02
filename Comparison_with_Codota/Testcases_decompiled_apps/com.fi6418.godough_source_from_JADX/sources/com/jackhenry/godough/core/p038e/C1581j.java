package com.jackhenry.godough.core.p038e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.C1506am;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.jackhenry.godough.core.e.j */
public class C1581j {
    /* renamed from: a */
    public static void m6156a(Context context, String str) {
        if (C1364k.m5591b(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL");
                String replaceAll = str.replaceAll("\\D", "");
                if (replaceAll.length() > 10) {
                    replaceAll = replaceAll.substring(0, 10);
                }
                intent.setData(Uri.parse("tel:" + replaceAll));
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m6157b(Context context, String str) {
        if (C1364k.m5591b(str)) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
            context.startActivity(Intent.createChooser(intent, context.getString(C1506am.dg_send_email)));
        }
    }

    /* renamed from: c */
    public static void m6158c(Context context, String str) {
        if (C1364k.m5591b(str)) {
            try {
                context.startActivity(Intent.createChooser(new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + URLEncoder.encode(str, "UTF-8"))), context.getString(C1506am.dg_navigate)));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
