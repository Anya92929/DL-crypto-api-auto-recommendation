package com.jackhenry.godough.core.locations;

/* renamed from: com.jackhenry.godough.core.locations.l */
class C1613l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1612k f6250a;

    C1613l(C1612k kVar) {
        this.f6250a = kVar;
    }

    public void run() {
        if (this.f6250a.f6249b.f6181a) {
            this.f6250a.f6249b.f6198f = this.f6250a.f6249b.f6187ao.getStreetViewPanorama();
            this.f6250a.f6249b.f6198f.setPosition(this.f6250a.f6249b.f6197e.position);
        }
        this.f6250a.f6249b.f6199g.scrollTo(0, this.f6250a.f6249b.f6188ap.getBottom());
    }
}
