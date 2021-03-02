package com.unity3d.player;

import android.app.NativeActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;

public class UnityPlayerNativeActivity extends NativeActivity {
    protected UnityPlayer mUnityPlayer;

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mUnityPlayer.configurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mUnityPlayer = new UnityPlayer(this);
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().takeSurface((SurfaceHolder.Callback2) null);
        setTheme(16973831);
        getWindow().setFormat(4);
        if (this.mUnityPlayer.getSettings().getBoolean("hide_status_bar", true)) {
            getWindow().setFlags(1024, 1024);
        }
        this.mUnityPlayer.init(this.mUnityPlayer.getSettings().getInt("gles_mode", 1), false);
        View view = this.mUnityPlayer.getView();
        setContentView(view);
        view.requestFocus();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mUnityPlayer.quit();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mUnityPlayer.pause();
        if (isFinishing()) {
            this.mUnityPlayer.quit();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mUnityPlayer.resume();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mUnityPlayer.windowFocusChanged(z);
    }
}
