package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkh;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
@zzin
public class zzc extends zzi implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {

    /* renamed from: a */
    private static final Map f3759a = new HashMap();

    /* renamed from: b */
    private final zzx f3760b;

    /* renamed from: c */
    private final boolean f3761c;

    /* renamed from: d */
    private int f3762d = 0;

    /* renamed from: e */
    private int f3763e = 0;

    /* renamed from: f */
    private MediaPlayer f3764f;

    /* renamed from: g */
    private Uri f3765g;

    /* renamed from: h */
    private int f3766h;

    /* renamed from: i */
    private int f3767i;

    /* renamed from: j */
    private int f3768j;

    /* renamed from: k */
    private int f3769k;

    /* renamed from: l */
    private int f3770l;

    /* renamed from: m */
    private float f3771m = 1.0f;

    /* renamed from: n */
    private boolean f3772n;

    /* renamed from: o */
    private boolean f3773o;

    /* renamed from: p */
    private zzw f3774p;

    /* renamed from: q */
    private boolean f3775q;

    /* renamed from: r */
    private int f3776r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public zzh f3777s;

    static {
        f3759a.put(-1004, "MEDIA_ERROR_IO");
        f3759a.put(-1007, "MEDIA_ERROR_MALFORMED");
        f3759a.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        f3759a.put(-110, "MEDIA_ERROR_TIMED_OUT");
        f3759a.put(100, "MEDIA_ERROR_SERVER_DIED");
        f3759a.put(1, "MEDIA_ERROR_UNKNOWN");
        f3759a.put(1, "MEDIA_INFO_UNKNOWN");
        f3759a.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f3759a.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        f3759a.put(701, "MEDIA_INFO_BUFFERING_START");
        f3759a.put(702, "MEDIA_INFO_BUFFERING_END");
        f3759a.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        f3759a.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        f3759a.put(802, "MEDIA_INFO_METADATA_UPDATE");
        f3759a.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        f3759a.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzc(Context context, boolean z, boolean z2, zzx zzx) {
        super(context);
        setSurfaceTextureListener(this);
        this.f3760b = zzx;
        this.f3775q = z;
        this.f3761c = z2;
        this.f3760b.zza(this);
    }

    /* renamed from: a */
    private void m5653a() {
        SurfaceTexture surfaceTexture;
        zzkd.m7303v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture2 = getSurfaceTexture();
        if (this.f3765g != null && surfaceTexture2 != null) {
            m5656a(false);
            try {
                this.f3764f = zzu.zzgd().zzov();
                this.f3764f.setOnBufferingUpdateListener(this);
                this.f3764f.setOnCompletionListener(this);
                this.f3764f.setOnErrorListener(this);
                this.f3764f.setOnInfoListener(this);
                this.f3764f.setOnPreparedListener(this);
                this.f3764f.setOnVideoSizeChangedListener(this);
                this.f3768j = 0;
                if (this.f3775q) {
                    this.f3774p = new zzw(getContext());
                    this.f3774p.mo5542a(surfaceTexture2, getWidth(), getHeight());
                    this.f3774p.start();
                    surfaceTexture = this.f3774p.zzox();
                    if (surfaceTexture == null) {
                        this.f3774p.mo5539a();
                        this.f3774p = null;
                    }
                    this.f3764f.setDataSource(getContext(), this.f3765g);
                    this.f3764f.setSurface(zzu.zzge().zza(surfaceTexture));
                    this.f3764f.setAudioStreamType(3);
                    this.f3764f.setScreenOnWhilePlaying(true);
                    this.f3764f.prepareAsync();
                    m5655a(1);
                }
                surfaceTexture = surfaceTexture2;
                this.f3764f.setDataSource(getContext(), this.f3765g);
                this.f3764f.setSurface(zzu.zzge().zza(surfaceTexture));
                this.f3764f.setAudioStreamType(3);
                this.f3764f.setScreenOnWhilePlaying(true);
                this.f3764f.prepareAsync();
                m5655a(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.f3765g);
                zzkd.zzd(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f3764f, 1, 0);
            }
        }
    }

    /* renamed from: a */
    private void m5654a(float f) {
        if (this.f3764f != null) {
            try {
                this.f3764f.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        } else {
            zzkd.zzcx("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    /* renamed from: a */
    private void m5655a(int i) {
        if (i == 3) {
            this.f3760b.zzpi();
        } else if (this.f3762d == 3) {
            this.f3760b.zzpj();
        }
        this.f3762d = i;
    }

    /* renamed from: a */
    private void m5656a(boolean z) {
        zzkd.m7303v("AdMediaPlayerView release");
        if (this.f3774p != null) {
            this.f3774p.mo5539a();
            this.f3774p = null;
        }
        if (this.f3764f != null) {
            this.f3764f.reset();
            this.f3764f.release();
            this.f3764f = null;
            m5655a(0);
            if (z) {
                this.f3763e = 0;
                m5658b(0);
            }
            m5660d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034 A[LOOP:0: B:9:0x0034->B:14:0x004f, LOOP_START] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5657b() {
        /*
            r8 = this;
            boolean r0 = r8.f3761c
            if (r0 != 0) goto L_0x0005
        L_0x0004:
            return
        L_0x0005:
            boolean r0 = r8.m5661e()
            if (r0 == 0) goto L_0x0004
            android.media.MediaPlayer r0 = r8.f3764f
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0004
            int r0 = r8.f3763e
            r1 = 3
            if (r0 == r1) goto L_0x0004
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.zzkd.m7303v(r0)
            r0 = 0
            r8.m5654a((float) r0)
            android.media.MediaPlayer r0 = r8.f3764f
            r0.start()
            android.media.MediaPlayer r0 = r8.f3764f
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.zze r1 = com.google.android.gms.ads.internal.zzu.zzfu()
            long r2 = r1.currentTimeMillis()
        L_0x0034:
            boolean r1 = r8.m5661e()
            if (r1 == 0) goto L_0x0051
            android.media.MediaPlayer r1 = r8.f3764f
            int r1 = r1.getCurrentPosition()
            if (r1 != r0) goto L_0x0051
            com.google.android.gms.common.util.zze r1 = com.google.android.gms.ads.internal.zzu.zzfu()
            long r4 = r1.currentTimeMillis()
            long r4 = r4 - r2
            r6 = 250(0xfa, double:1.235E-321)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.f3764f
            r0.pause()
            r8.m5664h()
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.m5657b():void");
    }

    /* renamed from: b */
    private void m5658b(int i) {
        this.f3763e = i;
    }

    /* renamed from: c */
    private void m5659c() {
        AudioManager i = m5665i();
        if (i != null && !this.f3773o) {
            if (i.requestAudioFocus(this, 3, 2) == 1) {
                m5662f();
            } else {
                zzkd.zzcx("AdMediaPlayerView audio focus request failed");
            }
        }
    }

    /* renamed from: d */
    private void m5660d() {
        zzkd.m7303v("AdMediaPlayerView abandon audio focus");
        AudioManager i = m5665i();
        if (i != null && this.f3773o) {
            if (i.abandonAudioFocus(this) == 1) {
                this.f3773o = false;
            } else {
                zzkd.zzcx("AdMediaPlayerView abandon audio focus failed");
            }
        }
    }

    /* renamed from: e */
    private boolean m5661e() {
        return (this.f3764f == null || this.f3762d == -1 || this.f3762d == 0 || this.f3762d == 1) ? false : true;
    }

    /* renamed from: f */
    private void m5662f() {
        zzkd.m7303v("AdMediaPlayerView audio focus gained");
        this.f3773o = true;
        m5664h();
    }

    /* renamed from: g */
    private void m5663g() {
        zzkd.m7303v("AdMediaPlayerView audio focus lost");
        this.f3773o = false;
        m5664h();
    }

    /* renamed from: h */
    private void m5664h() {
        if (this.f3772n || !this.f3773o) {
            m5654a(0.0f);
        } else {
            m5654a(this.f3771m);
        }
    }

    /* renamed from: i */
    private AudioManager m5665i() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    public int getCurrentPosition() {
        if (m5661e()) {
            return this.f3764f.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (m5661e()) {
            return this.f3764f.getDuration();
        }
        return -1;
    }

    public int getVideoHeight() {
        if (this.f3764f != null) {
            return this.f3764f.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (this.f3764f != null) {
            return this.f3764f.getVideoWidth();
        }
        return 0;
    }

    public void onAudioFocusChange(int i) {
        if (i > 0) {
            m5662f();
        } else if (i < 0) {
            m5663g();
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f3768j = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        zzkd.m7303v("AdMediaPlayerView completion");
        m5655a(5);
        m5658b(5);
        zzkh.zzclc.post(new C1278b(this));
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f3759a.get(Integer.valueOf(i));
        String str2 = (String) f3759a.get(Integer.valueOf(i2));
        zzkd.zzcx(new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        m5655a(-1);
        m5658b(-1);
        zzkh.zzclc.post(new C1279c(this, str, str2));
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f3759a.get(Integer.valueOf(i));
        String str2 = (String) f3759a.get(Integer.valueOf(i2));
        zzkd.m7303v(new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.f3766h, i);
        int defaultSize2 = getDefaultSize(this.f3767i, i2);
        if (this.f3766h > 0 && this.f3767i > 0 && this.f3774p == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f3766h * defaultSize2 < this.f3767i * size) {
                    defaultSize = (this.f3766h * defaultSize2) / this.f3767i;
                } else if (this.f3766h * defaultSize2 > this.f3767i * size) {
                    defaultSize2 = (this.f3767i * size) / this.f3766h;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.f3767i * size) / this.f3766h;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f3766h * defaultSize2) / this.f3767i;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.f3766h;
                int i5 = this.f3767i;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.f3766h * defaultSize2) / this.f3767i;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.f3767i * size) / this.f3766h;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.f3774p != null) {
            this.f3774p.mo5541a(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            if ((this.f3769k > 0 && this.f3769k != defaultSize) || (this.f3770l > 0 && this.f3770l != defaultSize2)) {
                m5657b();
            }
            this.f3769k = defaultSize;
            this.f3770l = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        zzkd.m7303v("AdMediaPlayerView prepared");
        m5655a(2);
        this.f3760b.zzoj();
        zzkh.zzclc.post(new C1277a(this));
        this.f3766h = mediaPlayer.getVideoWidth();
        this.f3767i = mediaPlayer.getVideoHeight();
        if (this.f3776r != 0) {
            seekTo(this.f3776r);
        }
        m5657b();
        int i = this.f3766h;
        zzkd.zzcw(new StringBuilder(62).append("AdMediaPlayerView stream dimensions: ").append(i).append(" x ").append(this.f3767i).toString());
        if (this.f3763e == 3) {
            play();
        }
        m5659c();
        m5664h();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzkd.m7303v("AdMediaPlayerView surface created");
        m5653a();
        zzkh.zzclc.post(new C1280d(this));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzkd.m7303v("AdMediaPlayerView surface destroyed");
        if (this.f3764f != null && this.f3776r == 0) {
            this.f3776r = this.f3764f.getCurrentPosition();
        }
        if (this.f3774p != null) {
            this.f3774p.mo5539a();
        }
        zzkh.zzclc.post(new C1281e(this));
        m5656a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = true;
        zzkd.m7303v("AdMediaPlayerView surface changed");
        boolean z2 = this.f3763e == 3;
        if (!(this.f3766h == i && this.f3767i == i2)) {
            z = false;
        }
        if (this.f3764f != null && z2 && z) {
            if (this.f3776r != 0) {
                seekTo(this.f3776r);
            }
            play();
        }
        if (this.f3774p != null) {
            this.f3774p.mo5541a(i, i2);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f3760b.zzb(this);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        zzkd.m7303v(new StringBuilder(57).append("AdMediaPlayerView size changed: ").append(i).append(" x ").append(i2).toString());
        this.f3766h = mediaPlayer.getVideoWidth();
        this.f3767i = mediaPlayer.getVideoHeight();
        if (this.f3766h != 0 && this.f3767i != 0) {
            requestLayout();
        }
    }

    public void pause() {
        zzkd.m7303v("AdMediaPlayerView pause");
        if (m5661e() && this.f3764f.isPlaying()) {
            this.f3764f.pause();
            m5655a(4);
            zzkh.zzclc.post(new C1283g(this));
        }
        m5658b(4);
    }

    public void play() {
        zzkd.m7303v("AdMediaPlayerView play");
        if (m5661e()) {
            this.f3764f.start();
            m5655a(3);
            zzkh.zzclc.post(new C1282f(this));
        }
        m5658b(3);
    }

    public void seekTo(int i) {
        zzkd.m7303v(new StringBuilder(34).append("AdMediaPlayerView seek ").append(i).toString());
        if (m5661e()) {
            this.f3764f.seekTo(i);
            this.f3776r = 0;
            return;
        }
        this.f3776r = i;
    }

    public void setMimeType(String str) {
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.f3765g = uri;
        this.f3776r = 0;
        m5653a();
        requestLayout();
        invalidate();
    }

    public void stop() {
        zzkd.m7303v("AdMediaPlayerView stop");
        if (this.f3764f != null) {
            this.f3764f.stop();
            this.f3764f.release();
            this.f3764f = null;
            m5655a(0);
            m5658b(0);
            m5660d();
        }
        this.f3760b.onStop();
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getName());
        String valueOf2 = String.valueOf(Integer.toHexString(hashCode()));
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("@").append(valueOf2).toString();
    }

    public void zza(float f) {
        this.f3771m = f;
        m5664h();
    }

    public void zza(float f, float f2) {
        if (this.f3774p != null) {
            this.f3774p.mo5540a(f, f2);
        }
    }

    public void zza(zzh zzh) {
        this.f3777s = zzh;
    }

    public String zzni() {
        String valueOf = String.valueOf(this.f3775q ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    public void zzno() {
        this.f3772n = true;
        m5664h();
    }

    public void zznp() {
        this.f3772n = false;
        m5664h();
    }
}
