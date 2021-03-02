package p052pt.lumberapps.frases;

/* renamed from: pt.lumberapps.frases.u */
class C2074u extends Thread {

    /* renamed from: a */
    final /* synthetic */ MainActivity f7780a;

    C2074u(MainActivity mainActivity) {
        this.f7780a = mainActivity;
    }

    public void run() {
        while (C2076w.f7783T) {
            try {
                Thread.sleep((long) ((C2076w.f7784U * String.valueOf(this.f7780a.f7802L.getText()).length()) + C2076w.f7785V));
            } catch (InterruptedException e) {
            }
            this.f7780a.runOnUiThread(new C2075v(this));
        }
    }
}
