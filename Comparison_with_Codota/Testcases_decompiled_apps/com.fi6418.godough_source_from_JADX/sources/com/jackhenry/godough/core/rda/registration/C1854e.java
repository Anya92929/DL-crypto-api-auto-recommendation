package com.jackhenry.godough.core.rda.registration;

import android.content.Intent;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.login.C1635ag;
import com.jackhenry.godough.core.model.RDAMessage;
import com.jackhenry.godough.core.rda.DepositReviewFragmentActivity;
import com.jackhenry.godough.core.rda.RDAFragmentActivity;

/* renamed from: com.jackhenry.godough.core.rda.registration.e */
public abstract class C1854e<T> extends C1635ag<T> {
    public C1854e(Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
    }

    /* renamed from: a */
    public void mo11075a() {
        FragmentActivity activity = this.f6919c.getActivity();
        if (activity != null) {
            activity.startActivity(activity.getPackageManager().hasSystemFeature("android.hardware.camera") ? new Intent(GoDoughApp.getApp(), RDAFragmentActivity.class) : new Intent(GoDoughApp.getApp(), DepositReviewFragmentActivity.class));
            activity.finish();
        }
    }

    /* renamed from: a */
    public void mo11076a(RDAMessage rDAMessage) {
        Intent intent = new Intent(GoDoughApp.getApp(), RDAMessageFragmentActivity.class);
        intent.putExtra(RDAMessageFragmentActivity.EXTRA_USER_STATUS_RESPONSE, rDAMessage);
        this.f6919c.getActivity().startActivity(intent);
        this.f6919c.getActivity().finish();
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }
}
