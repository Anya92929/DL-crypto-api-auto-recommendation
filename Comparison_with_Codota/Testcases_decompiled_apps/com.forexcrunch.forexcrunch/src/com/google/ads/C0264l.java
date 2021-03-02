package com.google.ads;

import com.google.ads.internal.C0238c;
import com.google.ads.util.C0304i;

/* renamed from: com.google.ads.l */
public final class C0264l extends C0304i {

    /* renamed from: a */
    public final C0304i.C0307b<C0272n> f611a;

    /* renamed from: b */
    public final C0304i.C0308c<C0238c> f612b;

    /* renamed from: c */
    public final C0304i.C0308c<Boolean> f613c = new C0304i.C0308c<>("disableNativeScroll", false);

    public C0264l(C0272n nVar) {
        this.f611a = new C0304i.C0307b<>("slotState", nVar);
        this.f612b = new C0304i.C0308c<>("adLoader", new C0238c(this));
    }
}
