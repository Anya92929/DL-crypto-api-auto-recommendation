package com.unity3d.player;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class UnityPlayerActivity extends Activity {
    private UnityPlayer a;

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a.configurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(16973831);
        requestWindowFeature(1);
        this.a = new UnityPlayer(this);
        if (this.a.getSettings().getBoolean("hide_status_bar", true)) {
            getWindow().setFlags(1024, 1024);
        }
        this.a.init(this.a.getSettings().getInt("gles_mode", 1), false);
        View view = this.a.getView();
        setContentView(view);
        view.requestFocus();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.a.quit();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.a.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.a.onKeyUp(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.a.pause();
        if (isFinishing()) {
            this.a.quit();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.a.resume();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.a.windowFocusChanged(z);
    }
}
