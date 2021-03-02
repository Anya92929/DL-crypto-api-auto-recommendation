package com.qualcomm.QCARUnityPlayer;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.unity3d.player.UnityPlayer;

public class QCARPlayerActivity extends Activity {
    private QCARPlayerSharedActivity mQCARShared;
    private UnityPlayer mUnityPlayer;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(16973831);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.mQCARShared = new QCARPlayerSharedActivity();
        this.mQCARShared.setActivity(this);
        this.mQCARShared.onCreate(savedInstanceState);
        this.mUnityPlayer = this.mQCARShared.getUnityPlayer();
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return this.mQCARShared.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return this.mQCARShared.onKeyUp(keyCode, event);
    }
}
