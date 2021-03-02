package p052pt.lumberapps.frases;

import com.google.android.gms.C1204R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/* renamed from: pt.lumberapps.frases.y */
class C2078y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2076w f7828a;

    C2078y(C2076w wVar) {
        this.f7828a = wVar;
    }

    public void run() {
        try {
            InterstitialAd unused = this.f7828a.f7812e = new InterstitialAd(this.f7828a);
            this.f7828a.f7812e.setAdUnitId(this.f7828a.getResources().getString(C1204R.string.idads_inter));
            AdRequest build = new AdRequest.Builder().build();
            this.f7828a.f7812e.setAdListener(new C2079z(this));
            this.f7828a.f7812e.loadAd(build);
            this.f7828a.f7812e.setAdListener(new C2021aa(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
