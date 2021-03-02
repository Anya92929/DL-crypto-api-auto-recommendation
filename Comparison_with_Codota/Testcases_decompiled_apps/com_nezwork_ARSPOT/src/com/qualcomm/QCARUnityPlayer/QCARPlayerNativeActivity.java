package com.qualcomm.QCARUnityPlayer;

import android.app.Dialog;
import android.app.NativeActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.SurfaceHolder;
import com.unity3d.player.UnityPlayer;

public class QCARPlayerNativeActivity extends NativeActivity {
    private QCARPlayerSharedActivity mQCARShared;
    protected UnityPlayer mUnityPlayer;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        this.mQCARShared = new QCARPlayerSharedActivity();
        this.mQCARShared.setActivity(this);
        this.mQCARShared.onCreate(savedInstanceState);
        this.mUnityPlayer = this.mQCARShared.getUnityPlayer();
        super.onCreate(savedInstanceState);
        getWindow().takeSurface((SurfaceHolder.Callback2) null);
        setTheme(16973831);
        getWindow().setFormat(4);
        getWindow().setFlags(1024, 1024);
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int id) {
        return this.mQCARShared.onCreateDialog(id);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mQCARShared.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mQCARShared.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mQCARShared.onDestroy();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mQCARShared.onConfigurationChanged(newConfig);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.mQCARShared.onWindowFocusChanged(hasFocus);
    }
}
