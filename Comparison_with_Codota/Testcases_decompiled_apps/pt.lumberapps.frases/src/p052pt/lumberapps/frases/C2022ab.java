package p052pt.lumberapps.frases;

import com.google.android.gms.ads.AdRequest;

/* renamed from: pt.lumberapps.frases.ab */
class C2022ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2076w f7676a;

    C2022ab(C2076w wVar) {
        this.f7676a = wVar;
    }

    public void run() {
        try {
            this.f7676a.f7805O.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("3C61727371E60E0BFD3663CCB7BFA8B4").build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
