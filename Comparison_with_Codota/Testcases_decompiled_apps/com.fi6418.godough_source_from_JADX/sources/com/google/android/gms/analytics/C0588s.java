package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.p000v4.p002os.EnvironmentCompat;
import com.google.android.gms.analytics.internal.C0561i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.analytics.s */
public class C0588s implements C0579j {

    /* renamed from: a */
    private final TreeSet<String> f3927a = new TreeSet<>();

    public C0588s(Context context, Collection<String> collection) {
        mo6926a(context, collection);
    }

    /* renamed from: a */
    public String mo6898a(String str, Throwable th) {
        return mo6924a(mo6925a(th), mo6927b(mo6925a(th)), str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo6924a(Throwable th, StackTraceElement stackTraceElement, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            sb.append(String.format(" (@%s:%s:%s)", new Object[]{str2, stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
        }
        if (str != null) {
            sb.append(String.format(" {%s}", new Object[]{str}));
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Throwable mo6925a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    /* renamed from: a */
    public void mo6926a(Context context, Collection<String> collection) {
        this.f3927a.clear();
        HashSet<String> hashSet = new HashSet<>();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            try {
                String packageName = context.getApplicationContext().getPackageName();
                this.f3927a.add(packageName);
                ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 1).activities;
                if (activityInfoArr != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        hashSet.add(activityInfo.packageName);
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                C0561i.m3259a("No package found");
            }
        }
        for (String str : hashSet) {
            Iterator<String> it = this.f3927a.iterator();
            boolean z = true;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (str.startsWith(next)) {
                    z = false;
                } else if (next.startsWith(str)) {
                    this.f3927a.remove(next);
                }
            }
            if (z) {
                this.f3927a.add(str);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public StackTraceElement mo6927b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator<String> it = this.f3927a.iterator();
            while (it.hasNext()) {
                if (className.startsWith(it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }
}
