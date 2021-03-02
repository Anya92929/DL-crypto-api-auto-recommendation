package p052pt.lumberapps.frases;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.appbrain.AppBrainBanner;
import com.appbrain.C1121k;
import com.google.android.gms.C1204R;
import p000a.p001a.p002a.p003a.p004a.p005a.p006a.C0000a;
import p000a.p001a.p002a.p003a.p004a.p005a.p006a.C0002c;
import p000a.p001a.p002a.p003a.p004a.p005a.p006a.C0004e;
import p052pt.lumberapps.lumbliv.C2104y;
import p052pt.lumberapps.lumbliv.MinhasApps;

/* renamed from: pt.lumberapps.frases.MApps */
public class MApps extends MinhasApps {

    /* renamed from: a */
    C0002c f7654a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10119a(View view) {
        C1121k.m5207a().mo3696b(this);
        super.mo10119a(view);
    }

    @SuppressLint({"ResourceAsColor"})
    /* renamed from: a */
    public void mo10120a(String str) {
        try {
            if (this.f7654a == null) {
                this.f7654a = new C0004e().mo17e((int) C1204R.color.White).mo14b((int) C1204R.color.laranja_bts).mo12a();
            }
            C0000a.m0a(this, str, this.f7654a).mo1b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo10121b(String str) {
        if (!str.equalsIgnoreCase("ok")) {
            mo10120a("Ocorreu um erro, tente novamente mais tarde...");
        }
        super.mo10121b(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10122c(String str) {
        startActivity(C2104y.m8436a((Activity) this, str));
        super.mo10122c(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1121k.m5208a(this);
        AppBrainBanner appBrainBanner = new AppBrainBanner(this);
        mo10120a("A carregar...");
        super.mo10261b((View) appBrainBanner);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C0000a.m1a();
        super.onDestroy();
    }
}
