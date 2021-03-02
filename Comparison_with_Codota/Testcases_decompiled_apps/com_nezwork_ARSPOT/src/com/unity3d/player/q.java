package com.unity3d.player;

class q implements Runnable {
    private /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public final void run() {
        this.a.b.nativeSensor(this.a.h, this.a.i, this.a.j, this.a.k);
    }
}
