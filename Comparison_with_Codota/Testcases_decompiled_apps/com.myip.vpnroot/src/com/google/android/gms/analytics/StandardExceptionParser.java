package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class StandardExceptionParser implements ExceptionParser {

    /* renamed from: Bl */
    private final TreeSet<String> f108Bl = new TreeSet<>();

    public StandardExceptionParser(Context context, Collection<String> additionalPackages) {
        setIncludedPackages(context, additionalPackages);
    }

    /* access modifiers changed from: protected */
    public StackTraceElement getBestStackTraceElement(Throwable t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator<String> it = this.f108Bl.iterator();
            while (it.hasNext()) {
                if (className.startsWith(it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    /* access modifiers changed from: protected */
    public Throwable getCause(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public String getDescription(String threadName, Throwable t) {
        return getDescription(getCause(t), getBestStackTraceElement(getCause(t)), threadName);
    }

    /* access modifiers changed from: protected */
    public String getDescription(Throwable cause, StackTraceElement element, String threadName) {
        StringBuilder sb = new StringBuilder();
        sb.append(cause.getClass().getSimpleName());
        if (element != null) {
            String[] split = element.getClassName().split("\\.");
            String str = "unknown";
            if (split != null && split.length > 0) {
                str = split[split.length - 1];
            }
            sb.append(String.format(" (@%s:%s:%s)", new Object[]{str, element.getMethodName(), Integer.valueOf(element.getLineNumber())}));
        }
        if (threadName != null) {
            sb.append(String.format(" {%s}", new Object[]{threadName}));
        }
        return sb.toString();
    }

    public void setIncludedPackages(Context context, Collection<String> additionalPackages) {
        this.f108Bl.clear();
        HashSet<String> hashSet = new HashSet<>();
        if (additionalPackages != null) {
            hashSet.addAll(additionalPackages);
        }
        if (context != null) {
            try {
                String packageName = context.getApplicationContext().getPackageName();
                this.f108Bl.add(packageName);
                ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 15).activities;
                if (activityInfoArr != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        hashSet.add(activityInfo.packageName);
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                C0207z.m307U("No package found");
            }
        }
        for (String str : hashSet) {
            Iterator<String> it = this.f108Bl.iterator();
            boolean z = true;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (str.startsWith(next)) {
                    z = false;
                } else if (next.startsWith(str)) {
                    this.f108Bl.remove(next);
                }
            }
            if (z) {
                this.f108Bl.add(str);
            }
        }
    }
}
