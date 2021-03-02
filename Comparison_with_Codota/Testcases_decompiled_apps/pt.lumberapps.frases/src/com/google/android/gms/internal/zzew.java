package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzin
public final class zzew implements zzep {

    /* renamed from: a */
    private final zzer f6159a;

    /* renamed from: b */
    private final zze f6160b;

    /* renamed from: c */
    private final zzha f6161c;

    public class zza {

        /* renamed from: a */
        private final zzlh f6162a;

        public zza(zzlh zzlh) {
            this.f6162a = zzlh;
        }

        public Intent zza(Context context, Map map) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            ResolveInfo zza;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.f6162a != null) {
                str = zzu.zzfq().zza(this.f6162a, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent zze = zze(parse);
            Intent zze2 = zze(build);
            ResolveInfo zza2 = zza(context, zze, arrayList);
            if (zza2 != null) {
                return zza(zze, zza2);
            }
            if (!(zze2 == null || (zza = zza(context, zze2)) == null)) {
                Intent zza3 = zza(zze, zza);
                if (zza(context, zza3) != null) {
                    return zza3;
                }
            }
            if (arrayList.size() == 0) {
                return zze;
            }
            if (!(!parseBoolean2 || activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ResolveInfo resolveInfo = (ResolveInfo) it.next();
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                return zza(zze, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? zza(zze, (ResolveInfo) arrayList.get(0)) : zze;
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList arrayList) {
            ResolveInfo resolveInfo;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = queryIntentActivities.get(i2);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i = i2 + 1;
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }

        public Intent zze(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzew(zzer zzer, zze zze, zzha zzha) {
        this.f6159a = zzer;
        this.f6160b = zze;
        this.f6161c = zzha;
    }

    /* renamed from: a */
    private static void m7013a(zzlh zzlh, Map map) {
        Context context = zzlh.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            zzkd.zzcx("Destination url cannot be empty.");
            return;
        }
        try {
            zzlh.zzuj().zza(new AdLauncherIntentInfoParcel(new zza(zzlh).zza(context, map)));
        } catch (ActivityNotFoundException e) {
            zzkd.zzcx(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m7014a(boolean z) {
        if (this.f6161c != null) {
            this.f6161c.zzs(z);
        }
    }

    /* renamed from: a */
    private static boolean m7015a(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* renamed from: b */
    private static int m7016b(Map map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzu.zzfs().zztk();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzu.zzfs().zztj();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzu.zzfs().zztl();
            }
        }
        return -1;
    }

    public void zza(zzlh zzlh, Map map) {
        String str = (String) map.get("a");
        if (str == null) {
            zzkd.zzcx("Action missing from an open GMSG.");
        } else if (this.f6160b == null || this.f6160b.zzel()) {
            zzli zzuj = zzlh.zzuj();
            if ("expand".equalsIgnoreCase(str)) {
                if (zzlh.zzun()) {
                    zzkd.zzcx("Cannot expand WebView that is already expanded.");
                    return;
                }
                m7014a(false);
                zzuj.zza(m7015a(map), m7016b(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                String str2 = (String) map.get("u");
                m7014a(false);
                if (str2 != null) {
                    zzuj.zza(m7015a(map), m7016b(map), str2);
                } else {
                    zzuj.zza(m7015a(map), m7016b(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                String str3 = (String) map.get("product_id");
                String str4 = (String) map.get("report_urls");
                if (this.f6159a == null) {
                    return;
                }
                if (str4 == null || str4.isEmpty()) {
                    this.f6159a.zza(str3, new ArrayList());
                } else {
                    this.f6159a.zza(str3, new ArrayList(Arrays.asList(str4.split(" "))));
                }
            } else if (!"app".equalsIgnoreCase(str) || !"true".equalsIgnoreCase((String) map.get("system_browser"))) {
                m7014a(true);
                String str5 = (String) map.get("u");
                zzuj.zza(new AdLauncherIntentInfoParcel((String) map.get("i"), !TextUtils.isEmpty(str5) ? zzu.zzfq().zza(zzlh, str5) : str5, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            } else {
                m7014a(true);
                m7013a(zzlh, map);
            }
        } else {
            this.f6160b.zzt((String) map.get("u"));
        }
    }
}
