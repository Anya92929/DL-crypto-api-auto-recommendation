package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzap;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzin;

@zzin
public final class VideoController {

    /* renamed from: a */
    private final Object f3396a = new Object();

    /* renamed from: b */
    private zzab f3397b;

    /* renamed from: c */
    private VideoLifecycleCallbacks f3398c;

    public abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.f3396a) {
            videoLifecycleCallbacks = this.f3398c;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.f3396a) {
            z = this.f3397b != null;
        }
        return z;
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        com.google.android.gms.common.internal.zzab.zzb((Object) videoLifecycleCallbacks, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f3396a) {
            this.f3398c = videoLifecycleCallbacks;
            if (this.f3397b != null) {
                try {
                    this.f3397b.zza(new zzap(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzb.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
                return;
            }
            return;
        }
    }

    public void zza(zzab zzab) {
        synchronized (this.f3396a) {
            this.f3397b = zzab;
            if (this.f3398c != null) {
                setVideoLifecycleCallbacks(this.f3398c);
            }
        }
    }
}
