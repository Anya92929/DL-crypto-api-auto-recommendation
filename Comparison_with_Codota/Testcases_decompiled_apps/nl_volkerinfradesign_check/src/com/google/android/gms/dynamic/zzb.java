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
    private Fragment f3139a;

    private zzb(Fragment fragment) {
        this.f3139a = fragment;
    }

    public static zzb zza(Fragment fragment) {
        if (fragment != null) {
            return new zzb(fragment);
        }
        return null;
    }

    public Bundle getArguments() {
        return this.f3139a.getArguments();
    }

    public int getId() {
        return this.f3139a.getId();
    }

    public boolean getRetainInstance() {
        return this.f3139a.getRetainInstance();
    }

    public String getTag() {
        return this.f3139a.getTag();
    }

    public int getTargetRequestCode() {
        return this.f3139a.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f3139a.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzC(this.f3139a.getView());
    }

    public boolean isAdded() {
        return this.f3139a.isAdded();
    }

    public boolean isDetached() {
        return this.f3139a.isDetached();
    }

    public boolean isHidden() {
        return this.f3139a.isHidden();
    }

    public boolean isInLayout() {
        return this.f3139a.isInLayout();
    }

    public boolean isRemoving() {
        return this.f3139a.isRemoving();
    }

    public boolean isResumed() {
        return this.f3139a.isResumed();
    }

    public boolean isVisible() {
        return this.f3139a.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.f3139a.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.f3139a.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.f3139a.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.f3139a.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.f3139a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f3139a.startActivityForResult(intent, i);
    }

    public void zzn(zzd zzd) {
        this.f3139a.registerForContextMenu((View) zze.zzp(zzd));
    }

    public void zzo(zzd zzd) {
        this.f3139a.unregisterForContextMenu((View) zze.zzp(zzd));
    }

    public zzd zztV() {
        return zze.zzC(this.f3139a.getActivity());
    }

    public zzc zztW() {
        return zza(this.f3139a.getParentFragment());
    }

    public zzd zztX() {
        return zze.zzC(this.f3139a.getResources());
    }

    public zzc zztY() {
        return zza(this.f3139a.getTargetFragment());
    }
}
