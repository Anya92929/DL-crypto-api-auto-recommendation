package android.support.p001v4.media;

import android.os.Build;
import android.support.p001v4.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v4.media.VolumeProviderCompat */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;

    /* renamed from: a */
    private final int f644a;

    /* renamed from: b */
    private final int f645b;

    /* renamed from: c */
    private int f646c;

    /* renamed from: d */
    private Callback f647d;

    /* renamed from: e */
    private Object f648e;

    /* renamed from: android.support.v4.media.VolumeProviderCompat$Callback */
    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.VolumeProviderCompat$ControlType */
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.f644a = i;
        this.f645b = i2;
        this.f646c = i3;
    }

    public final int getCurrentVolume() {
        return this.f646c;
    }

    public final int getVolumeControl() {
        return this.f644a;
    }

    public final int getMaxVolume() {
        return this.f645b;
    }

    public final void setCurrentVolume(int i) {
        this.f646c = i;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null) {
            VolumeProviderCompatApi21.m636a(volumeProvider, i);
        }
        if (this.f647d != null) {
            this.f647d.onVolumeChanged(this);
        }
    }

    public void onSetVolumeTo(int i) {
    }

    public void onAdjustVolume(int i) {
    }

    public void setCallback(Callback callback) {
        this.f647d = callback;
    }

    public Object getVolumeProvider() {
        if (this.f648e != null || Build.VERSION.SDK_INT < 21) {
            return this.f648e;
        }
        this.f648e = VolumeProviderCompatApi21.m635a(this.f644a, this.f645b, this.f646c, new VolumeProviderCompatApi21.Delegate() {
            public void onSetVolumeTo(int i) {
                VolumeProviderCompat.this.onSetVolumeTo(i);
            }

            public void onAdjustVolume(int i) {
                VolumeProviderCompat.this.onAdjustVolume(i);
            }
        });
        return this.f648e;
    }
}
