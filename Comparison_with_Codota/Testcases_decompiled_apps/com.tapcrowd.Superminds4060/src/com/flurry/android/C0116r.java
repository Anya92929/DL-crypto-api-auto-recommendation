package com.flurry.android;

import android.content.Context;
import android.widget.ImageView;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.flurry.android.r */
final class C0116r {
    C0116r() {
    }

    /* renamed from: a */
    static String m123a(String str, int i) {
        if (str == null) {
            return "";
        }
        return str.length() > i ? str.substring(0, i) : str;
    }

    /* renamed from: a */
    static String m122a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C0095ai.m106d("FlurryAgent", "Cannot encode '" + str + "'");
            return "";
        }
    }

    /* renamed from: a */
    static void m125a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    static void m124a(Context context, ImageView imageView, int i, int i2) {
        imageView.setAdjustViewBounds(true);
        imageView.setMinimumWidth(m121a(context, i));
        imageView.setMinimumHeight(m121a(context, i2));
        imageView.setMaxWidth(m121a(context, i));
        imageView.setMaxHeight(m121a(context, i2));
    }

    /* renamed from: a */
    static int m121a(Context context, int i) {
        return (int) ((context.getResources().getDisplayMetrics().density * ((float) i)) + 0.5f);
    }

    /* renamed from: b */
    static byte[] m126b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes(), 0, str.length());
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            C0095ai.m101b("FlurryAgent", "Unsupported SHA1: " + e.getMessage());
            return null;
        }
    }
}
