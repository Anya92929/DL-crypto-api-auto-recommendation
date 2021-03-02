package com.unity3d.player;

class u implements Runnable {
    private /* synthetic */ p a;

    u(p pVar) {
        this.a = pVar;
    }

    public final void run() {
        UnityPlayer e = this.a.b;
        float f = this.a.x[0];
        float f2 = this.a.x[1];
        float f3 = this.a.x[2];
        float f4 = this.a.x[3];
        p pVar = this.a;
        e.nativeAttitude(f, f2, f3, f4, p.f());
    }
}
