package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.ce */
public final class C0991ce implements C0974by {
    /* renamed from: a */
    private static int m4114a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return C1228gr.m4668a(displayMetrics, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            C1229gs.m4679W("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    /* renamed from: a */
    public void mo7942a(C1232gv gvVar, Map<String, String> map) {
        String str = map.get("action");
        if (str == null) {
            C1229gs.m4679W("Action missing from video GMSG.");
            return;
        }
        C1056dk du = gvVar.mo8630du();
        if (du == null) {
            C1229gs.m4679W("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = gvVar.getContext().getResources().getDisplayMetrics();
            int a = m4114a(displayMetrics, map, "x", 0);
            int a2 = m4114a(displayMetrics, map, "y", 0);
            int a3 = m4114a(displayMetrics, map, "w", -1);
            int a4 = m4114a(displayMetrics, map, "h", -1);
            if (!equalsIgnoreCase || du.mo8309bW() != null) {
                du.mo8308b(a, a2, a3, a4);
            } else {
                du.mo8313c(a, a2, a3, a4);
            }
        } else {
            C1064do bW = du.mo8309bW();
            if (bW == null) {
                C1064do.m4262a(gvVar, "no_video_view", (String) null);
            } else if ("click".equalsIgnoreCase(str)) {
                DisplayMetrics displayMetrics2 = gvVar.getContext().getResources().getDisplayMetrics();
                int a5 = m4114a(displayMetrics2, map, "x", 0);
                int a6 = m4114a(displayMetrics2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a6, 0);
                bW.mo8345b(obtain);
                obtain.recycle();
            } else if ("controls".equalsIgnoreCase(str)) {
                String str2 = map.get("enabled");
                if (str2 == null) {
                    C1229gs.m4679W("Enabled parameter missing from controls video GMSG.");
                } else {
                    bW.mo8354q(Boolean.parseBoolean(str2));
                }
            } else if ("currentTime".equalsIgnoreCase(str)) {
                String str3 = map.get("time");
                if (str3 == null) {
                    C1229gs.m4679W("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    bW.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                } catch (NumberFormatException e) {
                    C1229gs.m4679W("Could not parse time parameter from currentTime video GMSG: " + str3);
                }
            } else if ("hide".equalsIgnoreCase(str)) {
                bW.setVisibility(4);
            } else if ("load".equalsIgnoreCase(str)) {
                bW.mo8346ci();
            } else if ("pause".equalsIgnoreCase(str)) {
                bW.pause();
            } else if ("play".equalsIgnoreCase(str)) {
                bW.play();
            } else if ("show".equalsIgnoreCase(str)) {
                bW.setVisibility(0);
            } else if ("src".equalsIgnoreCase(str)) {
                bW.mo8344C(map.get("src"));
            } else {
                C1229gs.m4679W("Unknown video action: " + str);
            }
        }
    }
}
