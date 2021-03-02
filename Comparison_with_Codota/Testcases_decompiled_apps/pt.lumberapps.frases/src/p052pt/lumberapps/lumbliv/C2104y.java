package p052pt.lumberapps.lumbliv;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/* renamed from: pt.lumberapps.lumbliv.y */
public class C2104y {
    /* renamed from: a */
    public static Intent m8435a(Activity activity) {
        try {
            activity.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent("android.intent.action.VIEW", Uri.parse("fb://page/547242681961764"));
        } catch (Exception e) {
            return new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/1000FrasesNoAndroid"));
        }
    }

    /* renamed from: a */
    public static Intent m8436a(Activity activity, String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
    }

    /* renamed from: a */
    public static Intent m8437a(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setPackage(str2);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8438a(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse(str));
    }

    /* renamed from: a */
    public static String m8439a(String str, int i) {
        return str.length() > i + 1 ? str.substring(0, i) + " (...)" : str;
    }
}
