package com.google.android.gms.p018c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;
import java.util.List;

/* renamed from: com.google.android.gms.c.ah */
public class C0619ah {
    /* renamed from: a */
    public static String m3570a(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(m3573a(stackTrace, i)).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m3571a(Context context) {
        return m3572a(context, Binder.getCallingPid());
    }

    /* renamed from: a */
    public static String m3572a(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == i) {
                    return next.processName;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m3573a(StackTraceElement[] stackTraceElementArr, int i) {
        if (i + 4 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i + 4];
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber();
    }
}
