package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

@SuppressLint({"NewApi"})
public final class zzb extends zzc.zza {

    /* renamed from: a */
    private Fragment f4781a;

    private zzb(Fragment fragment) {
        this.f4781a = fragment;
    }

    public static zzb zza(Fragment fragment) {
        if (fragment != null) {
            return new zzb(fragment);
        }
        return null;
    }

    public Bundle getArguments() {
        return this.f4781a.getArguments();
    }

    public int getId() {
        return this.f4781a.getId();
    }

    public boolean getRetainInstance() {
        return this.f4781a.getRetainInstance();
    }

    public String getTag() {
        return this.f4781a.getTag();
    }

    public int getTargetRequestCode() {
        return this.f4781a.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f4781a.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzac(this.f4781a.getView());
    }

    public boolean isAdded() {
        return this.f4781a.isAdded();
    }

    public boolean isDetached() {
        return this.f4781a.isDetached();
    }

    public boolean isHidden() {
        return this.f4781a.isHidden();
    }

    public boolean isInLayout() {
        return this.f4781a.isInLayout();
    }

    public boolean isRemoving() {
        return this.f4781a.isRemoving();
    }

    public boolean isResumed() {
        return this.f4781a.isResumed();
    }

    public boolean isVisible() {
        return this.f4781a.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.f4781a.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.f4781a.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.f4781a.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.f4781a.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.f4781a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f4781a.startActivityForResult(intent, i);
    }

    public void zzab(zzd zzd) {
        this.f4781a.registerForContextMenu((View) zze.zzad(zzd));
    }

    public void zzac(zzd zzd) {
        this.f4781a.unregisterForContextMenu((View) zze.zzad(zzd));
    }

    public zzd zzbbu() {
        return zze.zzac(this.f4781a.getActivity());
    }

    public zzc zzbbv() {
        return zza(this.f4781a.getParentFragment());
    }

    public zzd zzbbw() {
        return zze.zzac(this.f4781a.getResources());
    }

    public zzc zzbbx() {
        return zza(this.f4781a.getTargetFragment());
    }
}
