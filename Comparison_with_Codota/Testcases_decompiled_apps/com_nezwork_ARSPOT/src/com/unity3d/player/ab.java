package com.unity3d.player;

import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

class ab implements Runnable {
    private /* synthetic */ UnityPlayer a;

    ab(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    public final void run() {
        int l = this.a.nativeActivityIndicatorStyle();
        if (l >= 0) {
            if (this.a.P == null) {
                ProgressBar unused = this.a.P = new ProgressBar(this.a.i, (AttributeSet) null, new int[]{16842874, 16843401, 16842873, 16843400}[l]);
                this.a.P.setIndeterminate(true);
                this.a.P.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 51));
                this.a.addView(this.a.P);
            }
            this.a.P.setVisibility(0);
            this.a.bringChildToFront(this.a.P);
        }
    }
}
