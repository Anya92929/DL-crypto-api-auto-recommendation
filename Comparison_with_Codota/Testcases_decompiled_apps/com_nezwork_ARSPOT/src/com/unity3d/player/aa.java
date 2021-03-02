package com.unity3d.player;

class aa implements Runnable {
    private /* synthetic */ UnityPlayer a;

    aa(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    public final void run() {
        if (n.a) {
            j jVar = n.b;
            ((z) this.a.k).setPreserveEGLContextOnPause(false);
        }
        this.a.k.onPause();
        this.a.k.onResume();
        if (n.a) {
            j jVar2 = n.b;
            ((z) this.a.k).setPreserveEGLContextOnPause(true);
        }
    }
}
