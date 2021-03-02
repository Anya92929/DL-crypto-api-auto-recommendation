package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.Menu;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.cm */
public final class C0343cm {

    /* renamed from: hO */
    public static final Handler f1013hO = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static int m721a(Context context, int i) {
        return m722a(context.getResources().getDisplayMetrics(), i);
    }

    /* renamed from: a */
    public static int m722a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    /* renamed from: a */
    public static void m723a(ViewGroup viewGroup, C0622x xVar, String str) {
        C0344cn.m737q(str);
        m724a(viewGroup, xVar, str, Menu.CATEGORY_MASK, -16777216);
    }

    /* renamed from: a */
    private static void m724a(ViewGroup viewGroup, C0622x xVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m721a(context, 3);
            frameLayout.addView(textView, new FrameLayout.LayoutParams(xVar.widthPixels - a, xVar.heightPixels - a, 17));
            viewGroup.addView(frameLayout, xVar.widthPixels, xVar.heightPixels);
        }
    }

    /* renamed from: aq */
    public static boolean m725aq() {
        return Build.DEVICE.startsWith("generic");
    }

    /* renamed from: ar */
    public static boolean m726ar() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: b */
    public static void m727b(ViewGroup viewGroup, C0622x xVar, String str) {
        m724a(viewGroup, xVar, str, -16777216, -1);
    }

    /* renamed from: l */
    public static String m728l(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || m725aq()) {
            string = "emulator";
        }
        return m729l(string);
    }

    /* renamed from: l */
    public static String m729l(String str) {
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
}
