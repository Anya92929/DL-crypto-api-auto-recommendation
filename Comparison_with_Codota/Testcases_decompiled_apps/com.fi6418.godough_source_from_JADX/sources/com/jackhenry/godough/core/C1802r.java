package com.jackhenry.godough.core;

import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import com.jackhenry.godough.core.p034b.p035a.C1511b;
import java.io.Serializable;

/* renamed from: com.jackhenry.godough.core.r */
public abstract class C1802r extends Fragment implements Serializable {
    public static final String ERROR_DIALOG = "ErrorDialogFragment";
    public static final String PROGRESS_DIALOG = "ProgressDialogFragment";

    /* renamed from: a */
    private void m6655a(C1511b bVar) {
        mo10989m();
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().add((Fragment) bVar, PROGRESS_DIALOG).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10986b(String str) {
        m6655a(C1511b.m5994b(str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10987c(String str) {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        DialogFragment dialogFragment = (DialogFragment) supportFragmentManager.findFragmentByTag(str);
        if (dialogFragment != null) {
            supportFragmentManager.beginTransaction().remove(dialogFragment).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo10988l() {
        m6655a(C1511b.m5995l());
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo10989m() {
        mo10987c(PROGRESS_DIALOG);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
