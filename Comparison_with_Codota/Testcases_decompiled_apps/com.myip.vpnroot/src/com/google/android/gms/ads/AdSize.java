package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.C0927ay;
import com.google.android.gms.internal.C1228gr;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");

    /* renamed from: lf */
    private final int f33lf;

    /* renamed from: lg */
    private final int f34lg;

    /* renamed from: lh */
    private final String f35lh;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdSize(int width, int height) {
        this(width, height, (width == -1 ? "FULL" : String.valueOf(width)) + "x" + (height == -2 ? "AUTO" : String.valueOf(height)) + "_as");
    }

    AdSize(int width, int height, String formatString) {
        if (width < 0 && width != -1) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + width);
        } else if (height >= 0 || height == -2) {
            this.f33lf = width;
            this.f34lg = height;
            this.f35lh = formatString;
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
        return this.f33lf == adSize.f33lf && this.f34lg == adSize.f34lg && this.f35lh.equals(adSize.f35lh);
    }

    public int getHeight() {
        return this.f34lg;
    }

    public int getHeightInPixels(Context context) {
        return this.f34lg == -2 ? C0927ay.m3914b(context.getResources().getDisplayMetrics()) : C1228gr.m4667a(context, this.f34lg);
    }

    public int getWidth() {
        return this.f33lf;
    }

    public int getWidthInPixels(Context context) {
        return this.f33lf == -1 ? C0927ay.m3913a(context.getResources().getDisplayMetrics()) : C1228gr.m4667a(context, this.f33lf);
    }

    public int hashCode() {
        return this.f35lh.hashCode();
    }

    public boolean isAutoHeight() {
        return this.f34lg == -2;
    }

    public boolean isFullWidth() {
        return this.f33lf == -1;
    }

    public String toString() {
        return this.f35lh;
    }
}
