package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;
import org.apache.cordova.Globalization;

/* renamed from: com.google.android.gms.internal.ak */
public final class C0223ak implements C0221ai {
    /* renamed from: a */
    private static int m494a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return C0343cm.m722a(displayMetrics, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            C0344cn.m737q("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    /* renamed from: a */
    public void mo4037a(C0347cq cqVar, Map<String, String> map) {
        String str = map.get("action");
        if (str == null) {
            C0344cn.m737q("Action missing from video GMSG.");
            return;
        }
        C0280bf au = cqVar.mo4210au();
        if (au == null) {
            C0344cn.m737q("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = cqVar.getContext().getResources().getDisplayMetrics();
            int a = m494a(displayMetrics, map, "x", 0);
            int a2 = m494a(displayMetrics, map, "y", 0);
            int a3 = m494a(displayMetrics, map, "w", -1);
            int a4 = m494a(displayMetrics, map, "h", -1);
            if (!equalsIgnoreCase || au.mo4096Q() != null) {
                au.mo4100b(a, a2, a3, a4);
            } else {
                au.mo4101c(a, a2, a3, a4);
            }
        } else {
            C0287bj Q = au.mo4096Q();
            if (Q == null) {
                C0287bj.m590a(cqVar, "no_video_view", (String) null);
            } else if ("click".equalsIgnoreCase(str)) {
                DisplayMetrics displayMetrics2 = cqVar.getContext().getResources().getDisplayMetrics();
                int a5 = m494a(displayMetrics2, map, "x", 0);
                int a6 = m494a(displayMetrics2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a6, 0);
                Q.mo4130b(obtain);
                obtain.recycle();
            } else if ("controls".equalsIgnoreCase(str)) {
                String str2 = map.get("enabled");
                if (str2 == null) {
                    C0344cn.m737q("Enabled parameter missing from controls video GMSG.");
                } else {
                    Q.mo4132f(Boolean.parseBoolean(str2));
                }
            } else if ("currentTime".equalsIgnoreCase(str)) {
                String str3 = map.get(Globalization.TIME);
                if (str3 == null) {
                    C0344cn.m737q("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    Q.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                } catch (NumberFormatException e) {
                    C0344cn.m737q("Could not parse time parameter from currentTime video GMSG: " + str3);
                }
            } else if ("hide".equalsIgnoreCase(str)) {
                Q.setVisibility(4);
            } else if ("load".equalsIgnoreCase(str)) {
                Q.mo4128Z();
            } else if ("pause".equalsIgnoreCase(str)) {
                Q.pause();
            } else if ("play".equalsIgnoreCase(str)) {
                Q.play();
            } else if ("show".equalsIgnoreCase(str)) {
                Q.setVisibility(0);
            } else if ("src".equalsIgnoreCase(str)) {
                Q.mo4133i(map.get("src"));
            } else {
                C0344cn.m737q("Unknown video action: " + str);
            }
        }
    }
}
