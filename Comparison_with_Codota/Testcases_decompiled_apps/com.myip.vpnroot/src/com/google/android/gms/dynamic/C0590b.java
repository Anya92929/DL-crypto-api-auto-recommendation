package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.C0591c;

/* renamed from: com.google.android.gms.dynamic.b */
public final class C0590b extends C0591c.C0592a {

    /* renamed from: Sb */
    private Fragment f1265Sb;

    private C0590b(Fragment fragment) {
        this.f1265Sb = fragment;
    }

    /* renamed from: a */
    public static C0590b m1721a(Fragment fragment) {
        if (fragment != null) {
            return new C0590b(fragment);
        }
        return null;
    }

    /* renamed from: d */
    public void mo5515d(C0594d dVar) {
        this.f1265Sb.registerForContextMenu((View) C0597e.m1742f(dVar));
    }

    /* renamed from: e */
    public void mo5516e(C0594d dVar) {
        this.f1265Sb.unregisterForContextMenu((View) C0597e.m1742f(dVar));
    }

    public Bundle getArguments() {
        return this.f1265Sb.getArguments();
    }

    public int getId() {
        return this.f1265Sb.getId();
    }

    public boolean getRetainInstance() {
        return this.f1265Sb.getRetainInstance();
    }

    public String getTag() {
        return this.f1265Sb.getTag();
    }

    public int getTargetRequestCode() {
        return this.f1265Sb.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f1265Sb.getUserVisibleHint();
    }

    public C0594d getView() {
        return C0597e.m1743k(this.f1265Sb.getView());
    }

    public boolean isAdded() {
        return this.f1265Sb.isAdded();
    }

    public boolean isDetached() {
        return this.f1265Sb.isDetached();
    }

    public boolean isHidden() {
        return this.f1265Sb.isHidden();
    }

    public boolean isInLayout() {
        return this.f1265Sb.isInLayout();
    }

    public boolean isRemoving() {
        return this.f1265Sb.isRemoving();
    }

    public boolean isResumed() {
        return this.f1265Sb.isResumed();
    }

    public boolean isVisible() {
        return this.f1265Sb.isVisible();
    }

    /* renamed from: iu */
    public C0594d mo5531iu() {
        return C0597e.m1743k(this.f1265Sb.getActivity());
    }

    /* renamed from: iv */
    public C0591c mo5532iv() {
        return m1721a(this.f1265Sb.getParentFragment());
    }

    /* renamed from: iw */
    public C0594d mo5533iw() {
        return C0597e.m1743k(this.f1265Sb.getResources());
    }

    /* renamed from: ix */
    public C0591c mo5534ix() {
        return m1721a(this.f1265Sb.getTargetFragment());
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.f1265Sb.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.f1265Sb.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.f1265Sb.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.f1265Sb.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.f1265Sb.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.f1265Sb.startActivityForResult(intent, requestCode);
    }
}
