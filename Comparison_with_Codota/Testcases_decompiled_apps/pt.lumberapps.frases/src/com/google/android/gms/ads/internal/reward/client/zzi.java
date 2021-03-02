package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzin;

@zzin
public class zzi implements RewardedVideoAd {

    /* renamed from: a */
    private final zzb f3973a;

    /* renamed from: b */
    private final Context f3974b;

    /* renamed from: c */
    private final Object f3975c = new Object();

    /* renamed from: d */
    private RewardedVideoAdListener f3976d;

    public zzi(Context context, zzb zzb) {
        this.f3973a = zzb;
        this.f3974b = context;
    }

    public void destroy() {
        destroy((Context) null);
    }

    public void destroy(Context context) {
        synchronized (this.f3975c) {
            if (this.f3973a != null) {
                try {
                    this.f3973a.zzh(zze.zzac(context));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.f3975c) {
            rewardedVideoAdListener = this.f3976d;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        zzb.zzcx("RewardedVideoAd.getUserId() is deprecated. Please do not call this method.");
        return null;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.f3975c) {
            if (this.f3973a != null) {
                try {
                    z = this.f3973a.isLoaded();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String str, AdRequest adRequest) {
        synchronized (this.f3975c) {
            if (this.f3973a != null) {
                try {
                    this.f3973a.zza(zzh.zzih().zza(this.f3974b, adRequest.zzdc(), str));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void pause() {
        pause((Context) null);
    }

    public void pause(Context context) {
        synchronized (this.f3975c) {
            if (this.f3973a != null) {
                try {
                    this.f3973a.zzf(zze.zzac(context));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward pause to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void resume() {
        resume((Context) null);
    }

    public void resume(Context context) {
        synchronized (this.f3975c) {
            if (this.f3973a != null) {
                try {
                    this.f3973a.zzg(zze.zzac(context));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward resume to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.f3975c) {
            this.f3976d = rewardedVideoAdListener;
            if (this.f3973a != null) {
                try {
                    this.f3973a.zza((zzd) new zzg(rewardedVideoAdListener));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String str) {
        zzb.zzcx("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.f3975c) {
            if (this.f3973a != null) {
                try {
                    this.f3973a.show();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward show to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }
}
