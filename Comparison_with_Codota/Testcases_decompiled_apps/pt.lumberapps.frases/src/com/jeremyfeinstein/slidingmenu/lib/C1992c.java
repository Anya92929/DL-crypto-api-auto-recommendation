package com.jeremyfeinstein.slidingmenu.lib;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.c */
class C1992c extends C1994e {

    /* renamed from: a */
    final /* synthetic */ C1990a f7586a;

    C1992c(C1990a aVar) {
        this.f7586a = aVar;
    }

    /* renamed from: a */
    public void mo10018a(int i) {
        if (this.f7586a.f7578s != null) {
            switch (i) {
                case 0:
                case 2:
                    this.f7586a.f7578s.setChildrenEnabled(true);
                    return;
                case 1:
                    this.f7586a.f7578s.setChildrenEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }
}
