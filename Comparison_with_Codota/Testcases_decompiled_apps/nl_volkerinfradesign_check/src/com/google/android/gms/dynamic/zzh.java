package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

public final class zzh extends zzc.zza {

    /* renamed from: a */
    private Fragment f3145a;

    private zzh(Fragment fragment) {
        this.f3145a = fragment;
    }

    public static zzh zza(Fragment fragment) {
        if (fragment != null) {
            return new zzh(fragment);
        }
        return null;
    }

    public Bundle getArguments() {
        return this.f3145a.getArguments();
    }

    public int getId() {
        return this.f3145a.getId();
    }

    public boolean getRetainInstance() {
        return this.f3145a.getRetainInstance();
    }

    public String getTag() {
        return this.f3145a.getTag();
    }

    public int getTargetRequestCode() {
        return this.f3145a.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f3145a.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzC(this.f3145a.getView());
    }

    public boolean isAdded() {
        return this.f3145a.isAdded();
    }

    public boolean isDetached() {
        return this.f3145a.isDetached();
    }

    public boolean isHidden() {
        return this.f3145a.isHidden();
    }

    public boolean isInLayout() {
        return this.f3145a.isInLayout();
    }

    public boolean isRemoving() {
        return this.f3145a.isRemoving();
    }

    public boolean isResumed() {
        return this.f3145a.isResumed();
    }

    public boolean isVisible() {
        return this.f3145a.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.f3145a.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.f3145a.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.f3145a.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.f3145a.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.f3145a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f3145a.startActivityForResult(intent, i);
    }

    public void zzn(zzd zzd) {
        this.f3145a.registerForContextMenu((View) zze.zzp(zzd));
    }

    public void zzo(zzd zzd) {
        this.f3145a.unregisterForContextMenu((View) zze.zzp(zzd));
    }

    public zzd zztV() {
        return zze.zzC(this.f3145a.getActivity());
    }

    public zzc zztW() {
        return zza(this.f3145a.getParentFragment());
    }

    public zzd zztX() {
        return zze.zzC(this.f3145a.getResources());
    }

    public zzc zztY() {
        return zza(this.f3145a.getTargetFragment());
    }
}
