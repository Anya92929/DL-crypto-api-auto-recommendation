package com.unity3d.player;

class ac implements Runnable {
    private /* synthetic */ UnityPlayer a;

    ac(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    public final void run() {
        if (this.a.P != null) {
            this.a.P.setVisibility(8);
        }
    }
}
