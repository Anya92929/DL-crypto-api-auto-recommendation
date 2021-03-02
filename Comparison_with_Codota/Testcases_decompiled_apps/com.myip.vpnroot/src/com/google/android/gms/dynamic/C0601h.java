package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.C0591c;

/* renamed from: com.google.android.gms.dynamic.h */
public final class C0601h extends C0591c.C0592a {

    /* renamed from: Ll */
    private Fragment f1271Ll;

    private C0601h(Fragment fragment) {
        this.f1271Ll = fragment;
    }

    /* renamed from: a */
    public static C0601h m1747a(Fragment fragment) {
        if (fragment != null) {
            return new C0601h(fragment);
        }
        return null;
    }

    /* renamed from: d */
    public void mo5515d(C0594d dVar) {
        this.f1271Ll.registerForContextMenu((View) C0597e.m1742f(dVar));
    }

    /* renamed from: e */
    public void mo5516e(C0594d dVar) {
        this.f1271Ll.unregisterForContextMenu((View) C0597e.m1742f(dVar));
    }

    public Bundle getArguments() {
        return this.f1271Ll.getArguments();
    }

    public int getId() {
        return this.f1271Ll.getId();
    }

    public boolean getRetainInstance() {
        return this.f1271Ll.getRetainInstance();
    }

    public String getTag() {
        return this.f1271Ll.getTag();
    }

    public int getTargetRequestCode() {
        return this.f1271Ll.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f1271Ll.getUserVisibleHint();
    }

    public C0594d getView() {
        return C0597e.m1743k(this.f1271Ll.getView());
    }

    public boolean isAdded() {
        return this.f1271Ll.isAdded();
    }

    public boolean isDetached() {
        return this.f1271Ll.isDetached();
    }

    public boolean isHidden() {
        return this.f1271Ll.isHidden();
    }

    public boolean isInLayout() {
        return this.f1271Ll.isInLayout();
    }

    public boolean isRemoving() {
        return this.f1271Ll.isRemoving();
    }

    public boolean isResumed() {
        return this.f1271Ll.isResumed();
    }

    public boolean isVisible() {
        return this.f1271Ll.isVisible();
    }

    /* renamed from: iu */
    public C0594d mo5531iu() {
        return C0597e.m1743k(this.f1271Ll.getActivity());
    }

    /* renamed from: iv */
    public C0591c mo5532iv() {
        return m1747a(this.f1271Ll.getParentFragment());
    }

    /* renamed from: iw */
    public C0594d mo5533iw() {
        return C0597e.m1743k(this.f1271Ll.getResources());
    }

    /* renamed from: ix */
    public C0591c mo5534ix() {
        return m1747a(this.f1271Ll.getTargetFragment());
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.f1271Ll.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.f1271Ll.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.f1271Ll.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.f1271Ll.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.f1271Ll.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.f1271Ll.startActivityForResult(intent, requestCode);
    }
}
