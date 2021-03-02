package com.google.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.actionbarsherlock.view.Menu;
import com.parse.ParseException;

public class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_MRECT = new AdSize(300, ParseException.LINKED_ID_MISSING, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");

    /* renamed from: a */
    private final int f110a;

    /* renamed from: b */
    private final int f111b;

    /* renamed from: c */
    private boolean f112c;

    /* renamed from: d */
    private boolean f113d;

    /* renamed from: e */
    private boolean f114e;

    /* renamed from: f */
    private String f115f;

    public AdSize(int width, int height) {
        this(width, height, (String) null);
        if (m18a()) {
            this.f114e = false;
            this.f115f = "mb";
            return;
        }
        this.f114e = true;
    }

    private AdSize(int width, int height, String type) {
        boolean z;
        boolean z2 = true;
        this.f110a = width;
        this.f111b = height;
        this.f115f = type;
        if (width == -1) {
            z = true;
        } else {
            z = false;
        }
        this.f112c = z;
        this.f113d = height != -2 ? false : z2;
        this.f114e = false;
    }

    public static AdSize createAdSize(AdSize adSize, Context context) {
        if (context == null || !adSize.m18a()) {
            return adSize.m18a() ? BANNER : adSize;
        }
        AdSize adSize2 = new AdSize(adSize.f112c ? m17a(context) : adSize.getWidth(), adSize.f113d ? m19b(context) : adSize.getHeight(), adSize.f115f);
        adSize2.f113d = adSize.f113d;
        adSize2.f112c = adSize.f112c;
        adSize2.f114e = adSize.f114e;
        return adSize2;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        if (this.f110a == adSize.f110a && this.f111b == adSize.f111b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f110a).hashCode() << 16) | (Integer.valueOf(this.f111b).hashCode() & Menu.USER_MASK);
    }

    public int getWidth() {
        if (this.f110a >= 0) {
            return this.f110a;
        }
        throw new UnsupportedOperationException("Ad size was not set before getWidth() was called.");
    }

    public int getHeight() {
        if (this.f111b >= 0) {
            return this.f111b;
        }
        throw new UnsupportedOperationException("Ad size was not set before getHeight() was called.");
    }

    /* renamed from: a */
    private boolean m18a() {
        return this.f110a < 0 || this.f111b < 0;
    }

    public boolean isFullWidth() {
        return this.f112c;
    }

    public boolean isAutoHeight() {
        return this.f113d;
    }

    public boolean isCustomAdSize() {
        return this.f114e;
    }

    public String toString() {
        return getWidth() + "x" + getHeight() + (this.f115f == null ? "" : "_" + this.f115f);
    }

    public int getWidthInPixels(Context context) {
        return (int) TypedValue.applyDimension(1, (float) this.f110a, context.getResources().getDisplayMetrics());
    }

    public int getHeightInPixels(Context context) {
        return (int) TypedValue.applyDimension(1, (float) this.f111b, context.getResources().getDisplayMetrics());
    }

    public boolean isSizeAppropriate(int width, int height) {
        return ((double) width) <= ((double) this.f110a) * 1.25d && ((double) width) >= ((double) this.f110a) * 0.8d && ((double) height) <= ((double) this.f111b) * 1.25d && ((double) height) >= ((double) this.f111b) * 0.8d;
    }

    public AdSize findBestSize(AdSize... options) {
        double d;
        AdSize adSize;
        AdSize adSize2 = null;
        double d2 = 0.0d;
        if (options != null) {
            int length = options.length;
            int i = 0;
            while (i < length) {
                AdSize adSize3 = options[i];
                if (isSizeAppropriate(adSize3.f110a, adSize3.f111b)) {
                    d = (((double) adSize3.f110a) * ((double) adSize3.f111b)) / (((double) this.f110a) * ((double) this.f111b));
                    if (d > 1.0d) {
                        d = 1.0d / d;
                    }
                    if (d > d2) {
                        adSize = adSize3;
                        i++;
                        adSize2 = adSize;
                        d2 = d;
                    }
                }
                d = d2;
                adSize = adSize2;
                i++;
                adSize2 = adSize;
                d2 = d;
            }
        }
        return adSize2;
    }

    /* renamed from: a */
    private static int m17a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    /* renamed from: b */
    private static int m19b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        if (i <= 720) {
            return 50;
        }
        return 90;
    }
}
