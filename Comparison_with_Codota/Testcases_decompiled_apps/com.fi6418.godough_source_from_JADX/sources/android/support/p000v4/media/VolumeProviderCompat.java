package android.support.p000v4.media;

import android.os.Build;
import android.support.p000v4.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v4.media.VolumeProviderCompat */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;

    /* renamed from: a */
    private final int f882a;

    /* renamed from: b */
    private final int f883b;

    /* renamed from: c */
    private int f884c;

    /* renamed from: d */
    private Callback f885d;

    /* renamed from: e */
    private Object f886e;

    /* renamed from: android.support.v4.media.VolumeProviderCompat$Callback */
    public abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.VolumeProviderCompat$ControlType */
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.f882a = i;
        this.f883b = i2;
        this.f884c = i3;
    }

    public final int getCurrentVolume() {
        return this.f884c;
    }

    public final int getMaxVolume() {
        return this.f883b;
    }

    public final int getVolumeControl() {
        return this.f882a;
    }

    public Object getVolumeProvider() {
        if (this.f886e != null || Build.VERSION.SDK_INT < 21) {
            return this.f886e;
        }
        this.f886e = VolumeProviderCompatApi21.createVolumeProvider(this.f882a, this.f883b, this.f884c, new VolumeProviderCompatApi21.Delegate() {
            public void onAdjustVolume(int i) {
                VolumeProviderCompat.this.onAdjustVolume(i);
            }

            public void onSetVolumeTo(int i) {
                VolumeProviderCompat.this.onSetVolumeTo(i);
            }
        });
        return this.f886e;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        this.f885d = callback;
    }

    public final void setCurrentVolume(int i) {
        this.f884c = i;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i);
        }
        if (this.f885d != null) {
            this.f885d.onVolumeChanged(this);
        }
    }
}
