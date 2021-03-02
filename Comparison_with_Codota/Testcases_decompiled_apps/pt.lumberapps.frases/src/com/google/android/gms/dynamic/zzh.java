package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.p009v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

public final class zzh extends zzc.zza {

    /* renamed from: a */
    private Fragment f4785a;

    private zzh(Fragment fragment) {
        this.f4785a = fragment;
    }

    public static zzh zza(Fragment fragment) {
        if (fragment != null) {
            return new zzh(fragment);
        }
        return null;
    }

    public Bundle getArguments() {
        return this.f4785a.getArguments();
    }

    public int getId() {
        return this.f4785a.getId();
    }

    public boolean getRetainInstance() {
        return this.f4785a.getRetainInstance();
    }

    public String getTag() {
        return this.f4785a.getTag();
    }

    public int getTargetRequestCode() {
        return this.f4785a.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f4785a.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzac(this.f4785a.getView());
    }

    public boolean isAdded() {
        return this.f4785a.isAdded();
    }

    public boolean isDetached() {
        return this.f4785a.isDetached();
    }

    public boolean isHidden() {
        return this.f4785a.isHidden();
    }

    public boolean isInLayout() {
        return this.f4785a.isInLayout();
    }

    public boolean isRemoving() {
        return this.f4785a.isRemoving();
    }

    public boolean isResumed() {
        return this.f4785a.isResumed();
    }

    public boolean isVisible() {
        return this.f4785a.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.f4785a.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.f4785a.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.f4785a.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.f4785a.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.f4785a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f4785a.startActivityForResult(intent, i);
    }

    public void zzab(zzd zzd) {
        this.f4785a.registerForContextMenu((View) zze.zzad(zzd));
    }

    public void zzac(zzd zzd) {
        this.f4785a.unregisterForContextMenu((View) zze.zzad(zzd));
    }

    public zzd zzbbu() {
        return zze.zzac(this.f4785a.getActivity());
    }

    public zzc zzbbv() {
        return zza(this.f4785a.getParentFragment());
    }

    public zzd zzbbw() {
        return zze.zzac(this.f4785a.getResources());
    }

    public zzc zzbbx() {
        return zza(this.f4785a.getTargetFragment());
    }
}
