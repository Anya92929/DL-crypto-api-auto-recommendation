package com.unity3d.player;

class UnityJavaRunnable implements Runnable {
    private final int a;

    UnityJavaRunnable(int i) {
        this.a = i;
    }

    private native void nativeFinalize(int i);

    private native void nativeRun(int i);

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            nativeFinalize(this.a);
        } finally {
            super.finalize();
        }
    }

    public void run() {
        nativeRun(this.a);
    }
}
