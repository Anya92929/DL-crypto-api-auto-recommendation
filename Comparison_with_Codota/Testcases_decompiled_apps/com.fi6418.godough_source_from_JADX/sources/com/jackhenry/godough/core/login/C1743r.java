package com.jackhenry.godough.core.login;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.NotificationCompat;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.r */
class C1743r extends C1635ag<Void> {

    /* renamed from: a */
    final /* synthetic */ EnrollmentFragmentActivity f6489a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1743r(EnrollmentFragmentActivity enrollmentFragmentActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6489a = enrollmentFragmentActivity;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public void mo9588a(Void voidR) {
        Notification build = new NotificationCompat.Builder(GoDoughApp.getApp()).setAutoCancel(true).setSmallIcon(C1493ah.fi_icon).setContentTitle(this.f6489a.getString(C1506am.enroll_success_title)).setContentText(this.f6489a.getString(C1506am.enroll_success_msg)).build();
        build.contentIntent = PendingIntent.getActivity(GoDoughApp.getApp(), 0, new Intent(), 0);
        build.flags |= 24;
        ((NotificationManager) this.f6489a.getSystemService("notification")).notify(0, build);
        super.mo9588a(voidR);
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        if (!super.mo9589a(dVar)) {
            mo11216b(dVar);
        }
        this.f6489a.dismissLoadingDialog();
        return true;
    }
}
