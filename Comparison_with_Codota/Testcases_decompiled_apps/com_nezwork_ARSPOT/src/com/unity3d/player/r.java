package com.unity3d.player;

class r implements Runnable {
    private /* synthetic */ p a;

    r(p pVar) {
        this.a = pVar;
    }

    public final void run() {
        this.a.b.nativeGyro(this.a.l, this.a.m, this.a.n, this.a.o);
    }
}
