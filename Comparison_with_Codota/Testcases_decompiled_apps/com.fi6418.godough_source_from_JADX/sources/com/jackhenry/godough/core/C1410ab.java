package com.jackhenry.godough.core;

import android.content.Intent;
import android.support.p000v4.app.ActivityCompat;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.p038e.C1576e;

/* renamed from: com.jackhenry.godough.core.ab */
public class C1410ab implements C1409aa {

    /* renamed from: a */
    Fragment f5795a;

    public C1410ab(Fragment fragment) {
        this.f5795a = fragment;
    }

    /* renamed from: b */
    private AbstractActivity m5756b() {
        return (AbstractActivity) this.f5795a.getActivity();
    }

    /* renamed from: a */
    public int mo9532a(String str) {
        return ActivityCompat.checkSelfPermission(this.f5795a.getActivity(), str);
    }

    /* renamed from: a */
    public String mo9533a(int i) {
        return m5756b().getString(i);
    }

    /* renamed from: a */
    public void mo9534a() {
        m5756b().finish();
    }

    /* renamed from: a */
    public void mo9535a(Intent intent) {
        m5756b().startActivity(intent);
    }

    /* renamed from: a */
    public void mo9536a(C1576e eVar) {
        m5756b().showDialog(eVar);
    }

    /* renamed from: a */
    public void mo9537a(String[] strArr, int i) {
        this.f5795a.requestPermissions(strArr, i);
    }

    /* renamed from: b */
    public boolean mo9538b(String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this.f5795a.getActivity(), str);
    }
}
