package com.unity3d.player;

class s implements Runnable {
    private /* synthetic */ p a;

    s(p pVar) {
        this.a = pVar;
    }

    public final void run() {
        this.a.b.nativeGravity(this.a.p, this.a.q, this.a.r, this.a.s);
    }
}
