package com.qualcomm.QCARUnityPlayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qualcomm.QCAR.QCAR;
import com.unity3d.player.UnityPlayer;
import java.io.InputStream;
import java.lang.reflect.Constructor;

public class QCARPlayerSharedActivity {
    private static final int APPSTATUS_INITED = 3;
    private static final int APPSTATUS_INIT_APP = 0;
    private static final int APPSTATUS_INIT_QCAR = 1;
    private static final int APPSTATUS_INIT_UNITY = 2;
    private static final int APPSTATUS_UNINITED = -1;
    private static final String NATIVE_LIB_QCAR = "QCAR";
    private static final String NATIVE_LIB_QCARWRAPPER = "QCARWrapper";
    private static final String NATIVE_LIB_UNITYPLAYER = "QCARUnityPlayer";
    private boolean isContentViewSet = false;
    private Activity mActivity;
    private int mAppStatus = -1;
    private InitQCARTask mInitQCARTask;
    private InitUnityTask mInitUnityTask;
    /* access modifiers changed from: private */
    public int mQCARFlags = 0;
    private int mScreenHeight = 0;
    private int mScreenWidth = 0;
    /* access modifiers changed from: private */
    public Object mShutdownLock = new Object();
    private ImageView mSplashScreenView;
    /* access modifiers changed from: private */
    public UnityPlayer mUnityPlayer;
    private int mUnity_GLES_mode = 0;

    private native void initApplicationNative();

    public native void setErrorCode(int i);

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    static {
        loadLibrary(NATIVE_LIB_QCAR);
        loadLibrary(NATIVE_LIB_QCARWRAPPER);
        loadLibrary(NATIVE_LIB_UNITYPLAYER);
    }

    public UnityPlayer getUnityPlayer() {
        return this.mUnityPlayer;
    }

    private class InitQCARTask extends AsyncTask<Activity, Integer, Boolean> {
        private int mProgressValue;

        private InitQCARTask() {
            this.mProgressValue = -1;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Activity... params) {
            Boolean valueOf;
            boolean z = true;
            synchronized (QCARPlayerSharedActivity.this.mShutdownLock) {
                if (QCAR.isInitialized()) {
                    DebugLog.LOGD("InitQCARTask::doInBackground: forcing QCAR deinitialization");
                    QCAR.deinit();
                }
                QCAR.setInitParameters(params.length > 0 ? params[0] : null, QCARPlayerSharedActivity.this.mQCARFlags);
                do {
                    this.mProgressValue = QCAR.init();
                    publishProgress(new Integer[]{Integer.valueOf(this.mProgressValue)});
                    if (isCancelled() || this.mProgressValue < 0 || this.mProgressValue >= 100) {
                    }
                    this.mProgressValue = QCAR.init();
                    publishProgress(new Integer[]{Integer.valueOf(this.mProgressValue)});
                    break;
                } while (this.mProgressValue >= 100);
                if (this.mProgressValue <= 0) {
                    z = false;
                }
                valueOf = Boolean.valueOf(z);
            }
            return valueOf;
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Integer... values) {
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean result) {
            if (result.booleanValue()) {
                DebugLog.LOGI("QCAR initialization successful");
                QCARPlayerSharedActivity.this.updateApplicationStatus(2);
                return;
            }
            DebugLog.LOGE("QCAR initialization failed");
            QCARPlayerSharedActivity.this.initUnityPlayer(false);
            QCARPlayerSharedActivity.this.setErrorCode(this.mProgressValue);
        }
    }

    private class InitUnityTask extends AsyncTask<Void, Integer, Boolean> {
        private InitUnityTask() {
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            return true;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean result) {
            QCARPlayerSharedActivity.this.initUnityPlayer(QCAR.requiresAlpha());
            QCARPlayerSharedActivity.this.mUnityPlayer.resume();
            QCARPlayerSharedActivity.this.updateApplicationStatus(3);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        int i;
        if (this.mActivity.getRequestedOrientation() == -1 && this.mActivity.getIntent().hasExtra("orientation")) {
            this.mActivity.setRequestedOrientation(this.mActivity.getIntent().getIntExtra("orientation", -1));
        }
        try {
            QCARUnityPlayer.class.getMethod("getSettings", (Class[]) null);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            this.mActivity.showDialog(0);
            return;
        }
        if (this.mUnityPlayer == null) {
            createUnityPlayer();
        }
        this.mUnity_GLES_mode = this.mUnityPlayer.getSettings().getInt("gles_mode", 1);
        if (this.mUnity_GLES_mode == 1) {
            i = 1;
        } else {
            i = 2;
        }
        this.mQCARFlags = i;
        if (QCAR.isInitialized()) {
            QCAR.setInitParameters(this.mActivity, this.mQCARFlags);
            updateApplicationStatus(2);
            return;
        }
        updateApplicationStatus(0);
    }

    public Dialog onCreateDialog(int id) {
        AlertDialog dialogError = new AlertDialog.Builder(this.mActivity).create();
        dialogError.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                System.exit(1);
            }
        });
        DebugLog.LOGE("This version of the QCAR Extension requires Unity 3.2+");
        dialogError.setMessage("This version of the QCAR Extension requires Unity 3.2+");
        return dialogError;
    }

    public void onResume() {
        QCAR.onResume();
        if (this.mUnityPlayer != null && this.isContentViewSet) {
            this.mUnityPlayer.resume();
        }
    }

    public void onPause() {
        if (this.mUnityPlayer != null) {
            this.mUnityPlayer.pause();
        }
        QCAR.onPause();
    }

    public void onDestroy() {
        if (!(this.mInitQCARTask == null || this.mInitQCARTask.getStatus() == AsyncTask.Status.FINISHED)) {
            this.mInitQCARTask.cancel(true);
            this.mInitQCARTask = null;
        }
        if (!(this.mInitUnityTask == null || this.mInitUnityTask.getStatus() == AsyncTask.Status.FINISHED)) {
            this.mInitUnityTask.cancel(true);
            this.mInitUnityTask = null;
        }
        synchronized (this.mShutdownLock) {
            QCAR.deinit();
            if (this.mUnityPlayer != null) {
                this.mUnityPlayer.quit();
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        try {
            Class.forName("com.unity3d.player.UnityPlayer").getMethod("configurationChanged", new Class[]{Class.forName("android.content.res.Configuration")});
            this.mUnityPlayer.configurationChanged(newConfig);
        } catch (Exception e) {
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        this.mUnityPlayer.windowFocusChanged(hasFocus);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.mUnityPlayer != null) {
            return this.mUnityPlayer.onKeyDown(keyCode, event);
        }
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.mUnityPlayer != null) {
            return this.mUnityPlayer.onKeyUp(keyCode, event);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public synchronized void updateApplicationStatus(int appStatus) {
        if (this.mAppStatus != appStatus) {
            this.mAppStatus = appStatus;
            switch (this.mAppStatus) {
                case 0:
                    initApplication();
                    updateApplicationStatus(1);
                    break;
                case 1:
                    try {
                        this.mInitQCARTask = new InitQCARTask();
                        this.mInitQCARTask.execute(new Activity[]{this.mActivity});
                        break;
                    } catch (Exception e) {
                        DebugLog.LOGE("Initializing QCAR SDK failed");
                        break;
                    }
                case 2:
                    try {
                        this.mInitUnityTask = new InitUnityTask();
                        this.mInitUnityTask.execute(new Void[0]);
                        break;
                    } catch (Exception e2) {
                        DebugLog.LOGE("Initializing Unity failed");
                        break;
                    }
                case 3:
                    System.gc();
                    break;
                default:
                    throw new RuntimeException("Invalid application state");
            }
        }
        return;
    }

    private void initApplication() {
        DisplayMetrics metrics = new DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        this.mScreenWidth = metrics.widthPixels;
        this.mScreenHeight = metrics.heightPixels;
        this.mActivity.getWindow().setFlags(128, 128);
        this.mSplashScreenView = new ImageView(this.mActivity);
        int bitmapWidth = this.mScreenWidth;
        try {
            InputStream stream = this.mActivity.getAssets().open("bin/Data/splash.png");
            BitmapFactory.Options opts = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeStream(stream, (Rect) null, opts);
            bitmapWidth = opts.outWidth;
            this.mSplashScreenView.setImageBitmap(bitmap);
        } catch (Exception e) {
            DebugLog.LOGW("Could not find splash screen image: " + e.getMessage());
        }
        LinearLayout splashScreenControlLayout = new LinearLayout(this.mActivity);
        splashScreenControlLayout.addView(this.mSplashScreenView, new LinearLayout.LayoutParams(-1, -1));
        int padding = (this.mScreenWidth - bitmapWidth) / 2;
        splashScreenControlLayout.setPadding(padding, 0, padding, 0);
        this.mActivity.setContentView(splashScreenControlLayout);
        initApplicationNative();
    }

    private void createUnityPlayer() {
        try {
            Constructor<?>[] constructors = Class.forName("com.unity3d.player.UnityPlayer").getConstructors();
            for (Constructor<?> ct : constructors) {
                Class<?>[] pvec = ct.getParameterTypes();
                int j = 0;
                while (j < pvec.length) {
                    if (pvec[j] == Class.forName("android.content.Context")) {
                        this.mUnityPlayer = new QCARUnityPlayerLegacy(this.mActivity);
                        return;
                    } else if (pvec[j] == Class.forName("android.content.ContextWrapper")) {
                        this.mUnityPlayer = new QCARUnityPlayer(this.mActivity);
                        return;
                    } else {
                        j++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    /* access modifiers changed from: private */
    public void initUnityPlayer(boolean requiresAlpha) {
        if (this.mUnityPlayer == null) {
            createUnityPlayer();
        }
        this.mUnityPlayer.init(this.mUnity_GLES_mode, requiresAlpha);
        View playerView = this.mUnityPlayer.getView();
        this.mActivity.setContentView(playerView);
        playerView.requestFocus();
        this.isContentViewSet = true;
    }

    public static boolean loadLibrary(String nLibName) {
        try {
            System.loadLibrary(nLibName);
            return true;
        } catch (UnsatisfiedLinkError e) {
            DebugLog.LOGE("The library lib" + nLibName + ".so could not be loaded");
            return false;
        } catch (SecurityException e2) {
            DebugLog.LOGE("The library lib" + nLibName + ".so was not allowed to be loaded");
            return false;
        }
    }
}
