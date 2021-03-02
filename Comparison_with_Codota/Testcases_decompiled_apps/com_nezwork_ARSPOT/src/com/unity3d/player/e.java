package com.unity3d.player;

import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

abstract class e implements SurfaceHolder.Callback {
    private final Activity a = ((Activity) y.a.a());
    /* access modifiers changed from: private */
    public final int b = 3;
    /* access modifiers changed from: private */
    public SurfaceView c;

    e(int i) {
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.a.runOnUiThread(new Runnable() {
            public final void run() {
                if (e.this.c == null) {
                    SurfaceView unused = e.this.c = new SurfaceView(y.a.a());
                    e.this.c.getHolder().setType(e.this.b);
                    e.this.c.getHolder().addCallback(e.this);
                    y.a.b(e.this.c);
                    e.this.c.setVisibility(0);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.a.runOnUiThread(new Runnable() {
            public final void run() {
                if (e.this.c != null) {
                    y.a.c(e.this.c);
                }
                SurfaceView unused = e.this.c = null;
            }
        });
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
