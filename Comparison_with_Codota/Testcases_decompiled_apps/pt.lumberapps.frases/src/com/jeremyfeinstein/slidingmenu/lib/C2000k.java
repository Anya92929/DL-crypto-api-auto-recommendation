package com.jeremyfeinstein.slidingmenu.lib;

import android.graphics.Paint;
import android.util.Log;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.k */
class C2000k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f7607a;

    /* renamed from: b */
    final /* synthetic */ SlidingMenu f7608b;

    C2000k(SlidingMenu slidingMenu, int i) {
        this.f7608b = slidingMenu;
        this.f7607a = i;
    }

    public void run() {
        Log.v(SlidingMenu.f7551a, "changing layerType. hardware? " + (this.f7607a == 2));
        this.f7608b.getContent().setLayerType(this.f7607a, (Paint) null);
        this.f7608b.getMenu().setLayerType(this.f7607a, (Paint) null);
        if (this.f7608b.getSecondaryMenu() != null) {
            this.f7608b.getSecondaryMenu().setLayerType(this.f7607a, (Paint) null);
        }
    }
}
