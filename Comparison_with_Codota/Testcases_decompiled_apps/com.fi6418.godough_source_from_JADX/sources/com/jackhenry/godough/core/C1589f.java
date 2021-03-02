package com.jackhenry.godough.core;

/* renamed from: com.jackhenry.godough.core.f */
class C1589f implements C1593j {

    /* renamed from: a */
    final /* synthetic */ AbstractActivity f6163a;

    C1589f(AbstractActivity abstractActivity) {
        this.f6163a = abstractActivity;
    }

    public void run() {
        this.f6163a.finish();
        this.f6163a.startActivity(this.f6163a.getIntent());
    }
}
