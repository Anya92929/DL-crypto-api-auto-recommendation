package com.unity3d.player;

class t implements Runnable {
    private /* synthetic */ p a;

    t(p pVar) {
        this.a = pVar;
    }

    public final void run() {
        this.a.b.nativeLinearAcc(this.a.t, this.a.u, this.a.v, this.a.w);
    }
}
