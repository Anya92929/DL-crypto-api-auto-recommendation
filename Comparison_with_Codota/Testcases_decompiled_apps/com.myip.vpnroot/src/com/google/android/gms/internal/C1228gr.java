package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@C1130ez
/* renamed from: com.google.android.gms.internal.gr */
public final class C1228gr {

    /* renamed from: wC */
    public static final Handler f3776wC = new Handler(Looper.getMainLooper());

    /* renamed from: R */
    public static String m4666R(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, instance.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static int m4667a(Context context, int i) {
        return m4668a(context.getResources().getDisplayMetrics(), i);
    }

    /* renamed from: a */
    public static int m4668a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    /* renamed from: a */
    public static void m4669a(ViewGroup viewGroup, C0927ay ayVar, String str) {
        m4670a(viewGroup, ayVar, str, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    /* renamed from: a */
    private static void m4670a(ViewGroup viewGroup, C0927ay ayVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m4667a(context, 3);
            frameLayout.addView(textView, new FrameLayout.LayoutParams(ayVar.widthPixels - a, ayVar.heightPixels - a, 17));
            viewGroup.addView(frameLayout, ayVar.widthPixels, ayVar.heightPixels);
        }
    }

    /* renamed from: a */
    public static void m4671a(ViewGroup viewGroup, C0927ay ayVar, String str, String str2) {
        C1229gs.m4679W(str2);
        m4670a(viewGroup, ayVar, str, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
    }

    /* renamed from: ds */
    public static boolean m4672ds() {
        return Build.DEVICE.startsWith("generic");
    }

    /* renamed from: dt */
    public static boolean m4673dt() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: v */
    public static String m4674v(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || m4672ds()) {
            string = "emulator";
        }
        return m4666R(string);
    }
}
