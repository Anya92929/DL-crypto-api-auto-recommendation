package com.jackhenry.godough.core;

import android.content.Intent;
import android.os.Process;
import com.jackhenry.godough.core.login.SplashActivity;
import java.lang.Thread;

/* renamed from: com.jackhenry.godough.core.a */
class C1407a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ AbstractActivity f5789a;

    C1407a(AbstractActivity abstractActivity) {
        this.f5789a = abstractActivity;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
        if (!getClass().getSimpleName().equals(SplashActivity.class.getSimpleName())) {
            Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
            intent.setFlags(32768);
            this.f5789a.startActivity(intent);
            Process.killProcess(Process.myPid());
        }
        System.exit(0);
    }
}
