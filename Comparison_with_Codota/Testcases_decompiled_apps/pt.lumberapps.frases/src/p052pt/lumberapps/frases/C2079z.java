package p052pt.lumberapps.frases;

import com.google.android.gms.ads.AdListener;

/* renamed from: pt.lumberapps.frases.z */
class C2079z extends AdListener {

    /* renamed from: a */
    final /* synthetic */ C2078y f7829a;

    C2079z(C2078y yVar) {
        this.f7829a = yVar;
    }

    public void onAdClosed() {
        this.f7829a.f7828a.f7799H.postDelayed(this.f7829a.f7828a.f7810W, 3000);
        super.onAdClosed();
    }
}
