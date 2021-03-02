package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzgi;

public class AdLoader {

    /* renamed from: a */
    private final zzh f3383a;

    /* renamed from: b */
    private final Context f3384b;

    /* renamed from: c */
    private final zzr f3385c;

    public class Builder {

        /* renamed from: a */
        private final Context f3386a;

        /* renamed from: b */
        private final zzs f3387b;

        Builder(Context context, zzs zzs) {
            this.f3386a = context;
            this.f3387b = zzs;
        }

        public Builder(Context context, String str) {
            this((Context) zzab.zzb((Object) context, (Object) "context cannot be null"), zzm.zzix().zzb(context, str, new zzgi()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.f3386a, this.f3387b.zzes());
            } catch (RemoteException e) {
                zzb.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.f3387b.zza((zzeb) new zzeg(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.f3387b.zza((zzec) new zzeh(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.f3387b.zza(str, new zzej(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzei(onCustomClickListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.f3387b.zzb((zzq) new zzc(adListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(Correlator correlator) {
            zzab.zzy(correlator);
            try {
                this.f3387b.zzb((zzy) correlator.zzdd());
            } catch (RemoteException e) {
                zzb.zzd("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.f3387b.zza(new NativeAdOptionsParcel(nativeAdOptions));
            } catch (RemoteException e) {
                zzb.zzd("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzr zzr) {
        this(context, zzr, zzh.zzih());
    }

    AdLoader(Context context, zzr zzr, zzh zzh) {
        this.f3384b = context;
        this.f3385c = zzr;
        this.f3383a = zzh;
    }

    /* renamed from: a */
    private void m5498a(zzad zzad) {
        try {
            this.f3385c.zzf(this.f3383a.zza(this.f3384b, zzad));
        } catch (RemoteException e) {
            zzb.zzb("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.f3385c.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.f3385c.isLoading();
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        m5498a(adRequest.zzdc());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        m5498a(publisherAdRequest.zzdc());
    }
}
