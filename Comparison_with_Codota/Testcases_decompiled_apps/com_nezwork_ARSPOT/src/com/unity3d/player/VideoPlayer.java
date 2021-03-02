package com.unity3d.player;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.FileInputStream;
import java.io.IOException;

public class VideoPlayer extends Activity implements SensorEventListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {
    private int a;
    private int b;
    private int c;
    private int d;
    private MediaPlayer e;
    private MediaController f;
    private SurfaceView g;
    private SurfaceHolder h;
    private String i;
    private int j;
    private int k;
    private boolean l;
    private boolean m = false;
    private boolean n = false;
    private FrameLayout o;
    private int p = 0;
    private boolean q = false;
    private int r = 0;
    private PowerManager.WakeLock s = null;
    private boolean t = false;
    private boolean u = true;
    private boolean v = false;

    private void a() {
        if (this.t && !this.u && !this.v) {
            this.v = true;
            c();
        }
    }

    private void b() {
        if (this.e != null) {
            this.e.release();
            this.e = null;
        }
        this.c = 0;
        this.d = 0;
        this.n = false;
        this.m = false;
    }

    private void c() {
        if (this.n && this.m && !isPlaying()) {
            d();
            if (!this.q) {
                start();
            }
        }
    }

    private void d() {
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.a = windowManager.getDefaultDisplay().getWidth();
        this.b = windowManager.getDefaultDisplay().getHeight();
        int i2 = this.a;
        int i3 = this.b;
        if (this.k == 1 || this.k == 2) {
            float f2 = ((float) this.c) / ((float) this.d);
            if (((float) this.a) / ((float) this.b) <= f2) {
                i3 = (int) (((float) this.a) / f2);
            } else {
                i2 = (int) (((float) this.b) * f2);
            }
        } else if (this.k == 0) {
            i2 = this.c;
            i3 = this.d;
        }
        this.o.updateViewLayout(this.g, new FrameLayout.LayoutParams(i2, i3, 17));
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public int getBufferPercentage() {
        if (this.l) {
            return this.p;
        }
        return 100;
    }

    public int getCurrentPosition() {
        if (this.e == null) {
            return 0;
        }
        return this.e.getCurrentPosition();
    }

    public int getDuration() {
        if (this.e == null) {
            return 0;
        }
        return this.e.getDuration();
    }

    public boolean isPlaying() {
        boolean z = this.n && this.m;
        return this.e == null ? !z : this.e.isPlaying() || !z;
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        this.p = i2;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i2 = 4;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras.getString("fileName").length() == 0) {
            finish();
            return;
        }
        setTheme(16973831);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        int i3 = extras.getInt("screenOrientation");
        if (extras.getBoolean("autorotationOn") || i3 == 4) {
            if (Build.VERSION.SDK_INT >= 9) {
                i2 = 10;
            }
            setRequestedOrientation(i2);
        }
        if (extras.getBoolean("wakeLock")) {
            this.s = ((PowerManager) getSystemService("power")).newWakeLock(26, "videowakelock");
            this.s.acquire();
        }
        String string = extras.getString("fileName");
        int i4 = extras.getInt("backgroundColor");
        int i5 = extras.getInt("controlMode");
        int i6 = extras.getInt("scalingMode");
        boolean z = extras.getBoolean("isURL");
        if (string.length() == 0) {
            finish();
            return;
        }
        this.o = new FrameLayout(this);
        this.g = new SurfaceView(this);
        this.h = this.g.getHolder();
        this.h.addCallback(this);
        this.h.setType(3);
        this.o.setBackgroundColor(i4);
        this.o.addView(this.g);
        setContentView(this.o);
        this.i = string;
        this.j = i5;
        this.k = i6;
        this.l = z;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        b();
        if (this.s != null) {
            this.s.release();
        }
        this.s = null;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 26 || i2 == 82 || i2 == 25 || i2 == 24 || i2 == 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.f != null && (i2 == 23 || i2 == 19 || i2 == 20 || i2 == 21 || i2 == 22)) {
            return this.f.onKeyDown(i2, keyEvent);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.u = true;
        this.v = false;
        super.onPause();
        if (!this.q) {
            pause();
            this.q = false;
        }
        if (this.e != null) {
            this.r = this.e.getCurrentPosition();
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.n = true;
        c();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.u = false;
        super.onResume();
        a();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f != null) {
            return this.f.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (this.j == 2 && action == 0) {
            finish();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 != 0 && i3 != 0) {
            this.m = true;
            this.c = i2;
            this.d = i3;
            c();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        this.t = z;
        a();
    }

    public void pause() {
        if (this.e != null) {
            this.e.pause();
            this.q = true;
        }
    }

    public void seekTo(int i2) {
        if (this.e != null) {
            this.e.seekTo(i2);
        }
    }

    public void start() {
        if (this.e != null) {
            this.e.start();
            this.q = false;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.a = i3;
        this.b = i4;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        b();
        try {
            this.e = new MediaPlayer();
            if (this.l) {
                this.e.setDataSource(this, Uri.parse(this.i));
            } else {
                try {
                    AssetFileDescriptor openFd = getResources().getAssets().openFd(this.i);
                    this.e.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                } catch (IOException e2) {
                    FileInputStream fileInputStream = new FileInputStream(this.i);
                    this.e.setDataSource(fileInputStream.getFD());
                    fileInputStream.close();
                }
            }
            this.e.setDisplay(this.h);
            this.e.setOnBufferingUpdateListener(this);
            this.e.setOnCompletionListener(this);
            this.e.setOnPreparedListener(this);
            this.e.setOnVideoSizeChangedListener(this);
            this.e.setAudioStreamType(3);
            this.e.prepare();
            if (this.j == 0 || this.j == 1) {
                this.f = new MediaController(this);
                this.f.setMediaPlayer(this);
                this.f.setAnchorView(this.g);
                this.f.setEnabled(true);
                this.f.show();
            }
        } catch (Exception e3) {
            finish();
        }
        seekTo(this.r);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b();
    }
}
