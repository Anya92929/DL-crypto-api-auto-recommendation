package com.actionbarsherlock.internal;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.actionbarsherlock.C0051R;

public final class ResourcesCompat {
    private ResourcesCompat() {
    }

    public static boolean getResources_getBoolean(Context context, int id) {
        float smallestWidthDp;
        if (Build.VERSION.SDK_INT >= 13) {
            return context.getResources().getBoolean(id);
        }
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float widthDp = ((float) metrics.widthPixels) / metrics.density;
        float heightDp = ((float) metrics.heightPixels) / metrics.density;
        if (widthDp < heightDp) {
            smallestWidthDp = widthDp;
        } else {
            smallestWidthDp = heightDp;
        }
        if (id == C0051R.bool.abs__action_bar_embed_tabs) {
            if (widthDp < 480.0f) {
                return false;
            }
            return true;
        } else if (id == C0051R.bool.abs__split_action_bar_is_narrow) {
            if (widthDp >= 480.0f) {
                return false;
            }
            return true;
        } else if (id == C0051R.bool.abs__action_bar_expanded_action_views_exclusive) {
            if (smallestWidthDp >= 600.0f) {
                return false;
            }
            return true;
        } else if (id != C0051R.bool.abs__config_allowActionMenuItemTextWithIcon) {
            throw new IllegalArgumentException("Unknown boolean resource ID " + id);
        } else if (widthDp < 480.0f) {
            return false;
        } else {
            return true;
        }
    }

    public static int getResources_getInteger(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 13) {
            return context.getResources().getInteger(id);
        }
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float widthDp = ((float) metrics.widthPixels) / metrics.density;
        if (id != C0051R.integer.abs__max_action_buttons) {
            throw new IllegalArgumentException("Unknown integer resource ID " + id);
        } else if (widthDp >= 600.0f) {
            return 5;
        } else {
            if (widthDp >= 500.0f) {
                return 4;
            }
            if (widthDp >= 360.0f) {
                return 3;
            }
            return 2;
        }
    }
}
