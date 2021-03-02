package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzk;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzin
public final class zzez implements zzep {

    /* renamed from: a */
    private final Map f6166a = new WeakHashMap();

    /* renamed from: b */
    private boolean f6167b;

    /* renamed from: a */
    private static int m7019a(Context context, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return zzm.zziw().zza(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            zzkd.zzcx(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            return i;
        }
    }

    public void zza(zzlh zzlh, Map map) {
        int i;
        zzk zzub;
        String str = (String) map.get("action");
        if (str == null) {
            zzkd.zzcx("Action missing from video GMSG.");
            return;
        }
        if (zzkd.zzaz(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject.toString());
            zzkd.zzcv(new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(valueOf).length()).append("Video GMSG: ").append(str).append(" ").append(valueOf).toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzkd.zzcx("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                zzlg zzuq = zzlh.zzuq();
                if (zzuq == null || (zzub = zzuq.zzub()) == null) {
                    this.f6166a.put(zzlh, Integer.valueOf(parseColor));
                } else {
                    zzub.setBackgroundColor(parseColor);
                }
            } catch (IllegalArgumentException e) {
                zzkd.zzcx("Invalid color parameter in video GMSG.");
            }
        } else {
            zzlg zzuq2 = zzlh.zzuq();
            if (zzuq2 == null) {
                zzkd.zzcx("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzlh.getContext();
                int a = m7019a(context, map, "x", 0);
                int a2 = m7019a(context, map, "y", 0);
                int a3 = m7019a(context, map, "w", -1);
                int a4 = m7019a(context, map, "h", -1);
                try {
                    i = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException e2) {
                    i = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzuq2.zzub() != null) {
                    zzuq2.zze(a, a2, a3, a4);
                    return;
                }
                zzuq2.zza(a, a2, a3, a4, i, parseBoolean);
                if (this.f6166a.containsKey(zzlh)) {
                    zzuq2.zzub().setBackgroundColor(((Integer) this.f6166a.get(zzlh)).intValue());
                    return;
                }
                return;
            }
            zzk zzub2 = zzuq2.zzub();
            if (zzub2 == null) {
                zzk.zzh(zzlh);
            } else if ("click".equals(str)) {
                Context context2 = zzlh.getContext();
                int a5 = m7019a(context2, map, "x", 0);
                int a6 = m7019a(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a6, 0);
                zzub2.zzd(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str3 = (String) map.get("time");
                if (str3 == null) {
                    zzkd.zzcx("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzub2.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                } catch (NumberFormatException e3) {
                    String valueOf2 = String.valueOf(str3);
                    zzkd.zzcx(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                }
            } else if ("hide".equals(str)) {
                zzub2.setVisibility(4);
            } else if ("load".equals(str)) {
                zzub2.zzlv();
            } else if ("mimetype".equals(str)) {
                zzub2.setMimeType((String) map.get("mimetype"));
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzub2.zzno();
                } else {
                    zzub2.zznp();
                }
            } else if ("pause".equals(str)) {
                zzub2.pause();
            } else if ("play".equals(str)) {
                zzub2.play();
            } else if ("show".equals(str)) {
                zzub2.setVisibility(0);
            } else if ("src".equals(str)) {
                zzub2.zzbw((String) map.get("src"));
            } else if ("touchMove".equals(str)) {
                Context context3 = zzlh.getContext();
                zzub2.zza((float) m7019a(context3, map, "dx", 0), (float) m7019a(context3, map, "dy", 0));
                if (!this.f6167b) {
                    zzlh.zzuh().zzob();
                    this.f6167b = true;
                }
            } else if ("volume".equals(str)) {
                String str4 = (String) map.get("volume");
                if (str4 == null) {
                    zzkd.zzcx("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzub2.zza(Float.parseFloat(str4));
                } catch (NumberFormatException e4) {
                    String valueOf3 = String.valueOf(str4);
                    zzkd.zzcx(valueOf3.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf3) : new String("Could not parse volume parameter from volume video GMSG: "));
                }
            } else if ("watermark".equals(str)) {
                zzub2.zzon();
            } else {
                String valueOf4 = String.valueOf(str);
                zzkd.zzcx(valueOf4.length() != 0 ? "Unknown video action: ".concat(valueOf4) : new String("Unknown video action: "));
            }
        }
    }
}
