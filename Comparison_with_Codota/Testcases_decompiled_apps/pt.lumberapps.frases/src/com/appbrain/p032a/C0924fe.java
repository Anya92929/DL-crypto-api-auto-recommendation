package com.appbrain.p032a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cmn.C0725at;
import com.appbrain.AppBrainActivity;

@TargetApi(14)
/* renamed from: com.appbrain.a.fe */
public final class C0924fe extends DialogFragment implements C0930fk {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0931fl f2419a = new C0931fl();

    /* renamed from: a */
    public static boolean m3919a(Activity activity, Bundle bundle) {
        C0924fe feVar = new C0924fe();
        feVar.setArguments(bundle);
        try {
            feVar.show(activity.getFragmentManager(), "AppBrainFragment");
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo3583a() {
        if (!C0725at.m3232b(getActivity())) {
            return false;
        }
        AppBrainActivity.m3569a(getActivity(), getArguments());
        return true;
    }

    /* renamed from: b */
    public final void mo3584b() {
        dismissAllowingStateLoss();
    }

    /* renamed from: c */
    public final boolean mo3585c() {
        return !isAdded();
    }

    /* renamed from: d */
    public final boolean mo3586d() {
        return false;
    }

    public final Context getContext() {
        return getActivity();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = getDialog();
        View a = this.f2419a.mo3831a();
        if (dialog != null && a != null) {
            dialog.setContentView(C0929fj.m3940a(a));
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        C0925ff ffVar = new C0925ff(this, getActivity());
        C0934fo.m3996a((Dialog) ffVar);
        return ffVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return C0929fj.m3940a(this.f2419a.mo3832a(this, bundle));
    }

    public final void onDestroy() {
        this.f2419a.mo3838f();
        super.onDestroy();
    }

    public final void onPause() {
        this.f2419a.mo3836d();
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        this.f2419a.mo3835c();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f2419a.mo3833a(bundle);
        super.onSaveInstanceState(bundle);
    }

    public final void onStop() {
        this.f2419a.mo3837e();
        super.onStop();
    }
}
