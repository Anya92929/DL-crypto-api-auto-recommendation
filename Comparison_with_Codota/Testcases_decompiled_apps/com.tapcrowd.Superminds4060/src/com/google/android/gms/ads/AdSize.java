package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.C0343cm;
import com.google.android.gms.internal.C0622x;
import twitter4j.internal.http.HttpResponseCode;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(HttpResponseCode.MULTIPLE_CHOICES, 250, "300x250_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");

    /* renamed from: dP */
    private final int f310dP;

    /* renamed from: dQ */
    private final int f311dQ;

    /* renamed from: dR */
    private final String f312dR;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdSize(int width, int height) {
        this(width, height, (width == -1 ? "FULL" : String.valueOf(width)) + "x" + (height == -2 ? "AUTO" : String.valueOf(height)) + "_as");
    }

    public AdSize(int width, int height, String formatString) {
        if (width < 0 && width != -1) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + width);
        } else if (height >= 0 || height == -2) {
            this.f310dP = width;
            this.f311dQ = height;
            this.f312dR = formatString;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + height);
        }
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        return this.f310dP == adSize.f310dP && this.f311dQ == adSize.f311dQ && this.f312dR.equals(adSize.f312dR);
    }

    public int getHeight() {
        return this.f311dQ;
    }

    public int getHeightInPixels(Context context) {
        return this.f311dQ == -2 ? C0622x.m1959b(context.getResources().getDisplayMetrics()) : C0343cm.m721a(context, this.f311dQ);
    }

    public int getWidth() {
        return this.f310dP;
    }

    public int getWidthInPixels(Context context) {
        return this.f310dP == -1 ? C0622x.m1958a(context.getResources().getDisplayMetrics()) : C0343cm.m721a(context, this.f310dP);
    }

    public int hashCode() {
        return this.f312dR.hashCode();
    }

    public boolean isAutoHeight() {
        return this.f311dQ == -2;
    }

    public boolean isFullWidth() {
        return this.f310dP == -1;
    }

    public String toString() {
        return this.f312dR;
    }
}
