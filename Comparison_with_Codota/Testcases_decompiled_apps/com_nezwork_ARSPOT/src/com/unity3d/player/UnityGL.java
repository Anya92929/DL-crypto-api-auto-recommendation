package com.unity3d.player;

import android.opengl.GLSurfaceView;

public interface UnityGL {
    void a();

    void onPause();

    void onResume();

    void queueEvent(Runnable runnable);

    void setRenderer(GLSurfaceView.Renderer renderer);
}
