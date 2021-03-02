package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzlt;
import java.util.Date;
import java.util.Set;

@zzin
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, zzlt {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected AdView zzfb;
    protected InterstitialAd zzfc;
    private AdLoader zzfd;
    private Context zzfe;
    /* access modifiers changed from: private */
    public InterstitialAd zzff;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzfg;
    final RewardedVideoAdListener zzfh = new RewardedVideoAdListener() {
        public void onRewarded(RewardItem rewardItem) {
            AbstractAdViewAdapter.this.zzfg.onRewarded(AbstractAdViewAdapter.this, rewardItem);
        }

        public void onRewardedVideoAdClosed() {
            AbstractAdViewAdapter.this.zzfg.onAdClosed(AbstractAdViewAdapter.this);
            InterstitialAd unused = AbstractAdViewAdapter.this.zzff = null;
        }

        public void onRewardedVideoAdFailedToLoad(int i) {
            AbstractAdViewAdapter.this.zzfg.onAdFailedToLoad(AbstractAdViewAdapter.this, i);
        }

        public void onRewardedVideoAdLeftApplication() {
            AbstractAdViewAdapter.this.zzfg.onAdLeftApplication(AbstractAdViewAdapter.this);
        }

        public void onRewardedVideoAdLoaded() {
            AbstractAdViewAdapter.this.zzfg.onAdLoaded(AbstractAdViewAdapter.this);
        }

        public void onRewardedVideoAdOpened() {
            AbstractAdViewAdapter.this.zzfg.onAdOpened(AbstractAdViewAdapter.this);
        }

        public void onRewardedVideoStarted() {
            AbstractAdViewAdapter.this.zzfg.onVideoStarted(AbstractAdViewAdapter.this);
        }
    };

    class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzfj;

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            this.zzfj = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzfj);
            }
        }
    }

    class zzb extends NativeContentAdMapper {
        private final NativeContentAd zzfk;

        public zzb(NativeContentAd nativeContentAd) {
            this.zzfk = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzfk);
            }
        }
    }

    final class zzc extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzfl;
        final MediationBannerListener zzfm;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.zzfl = abstractAdViewAdapter;
            this.zzfm = mediationBannerListener;
        }

        public void onAdClicked() {
            this.zzfm.onAdClicked(this.zzfl);
        }

        public void onAdClosed() {
            this.zzfm.onAdClosed(this.zzfl);
        }

        public void onAdFailedToLoad(int i) {
            this.zzfm.onAdFailedToLoad(this.zzfl, i);
        }

        public void onAdLeftApplication() {
            this.zzfm.onAdLeftApplication(this.zzfl);
        }

        public void onAdLoaded() {
            this.zzfm.onAdLoaded(this.zzfl);
        }

        public void onAdOpened() {
            this.zzfm.onAdOpened(this.zzfl);
        }
    }

    final class zzd extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzfl;
        final MediationInterstitialListener zzfn;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzfl = abstractAdViewAdapter;
            this.zzfn = mediationInterstitialListener;
        }

        public void onAdClicked() {
            this.zzfn.onAdClicked(this.zzfl);
        }

        public void onAdClosed() {
            this.zzfn.onAdClosed(this.zzfl);
        }

        public void onAdFailedToLoad(int i) {
            this.zzfn.onAdFailedToLoad(this.zzfl, i);
        }

        public void onAdLeftApplication() {
            this.zzfn.onAdLeftApplication(this.zzfl);
        }

        public void onAdLoaded() {
            this.zzfn.onAdLoaded(this.zzfl);
        }

        public void onAdOpened() {
            this.zzfn.onAdOpened(this.zzfl);
        }
    }

    final class zze extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzfl;
        final MediationNativeListener zzfo;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzfl = abstractAdViewAdapter;
            this.zzfo = mediationNativeListener;
        }

        public void onAdClicked() {
            this.zzfo.onAdClicked(this.zzfl);
        }

        public void onAdClosed() {
            this.zzfo.onAdClosed(this.zzfl);
        }

        public void onAdFailedToLoad(int i) {
            this.zzfo.onAdFailedToLoad(this.zzfl, i);
        }

        public void onAdLeftApplication() {
            this.zzfo.onAdLeftApplication(this.zzfl);
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
            this.zzfo.onAdOpened(this.zzfl);
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.zzfo.onAdLoaded(this.zzfl, new zza(nativeAppInstallAd));
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.zzfo.onAdLoaded(this.zzfl, new zzb(nativeContentAd));
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzfb;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzbb(1).zzvp();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzfe = context.getApplicationContext();
        this.zzfg = mediationRewardedVideoAdListener;
        this.zzfg.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzfg != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzfe == null || this.zzfg == null) {
            com.google.android.gms.ads.internal.util.client.zzb.m5769e("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzff = new InterstitialAd(this.zzfe);
        this.zzff.zzd(true);
        this.zzff.setAdUnitId(getAdUnitId(bundle));
        this.zzff.setRewardedVideoAdListener(this.zzfh);
        this.zzff.loadAd(zza(this.zzfe, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzfb != null) {
            this.zzfb.destroy();
            this.zzfb = null;
        }
        if (this.zzfc != null) {
            this.zzfc = null;
        }
        if (this.zzfd != null) {
            this.zzfd = null;
        }
        if (this.zzff != null) {
            this.zzff = null;
        }
    }

    public void onPause() {
        if (this.zzfb != null) {
            this.zzfb.pause();
        }
    }

    public void onResume() {
        if (this.zzfb != null) {
            this.zzfb.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzfb = new AdView(context);
        this.zzfb.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzfb.setAdUnitId(getAdUnitId(bundle));
        this.zzfb.setAdListener(new zzc(this, mediationBannerListener));
        this.zzfb.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzfc = new InterstitialAd(context);
        this.zzfc.setAdUnitId(getAdUnitId(bundle));
        this.zzfc.setAdListener(new zzd(this, mediationInterstitialListener));
        this.zzfc.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zze2 = new zze(this, mediationNativeListener);
        AdLoader.Builder withAdListener = zza(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zze2);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(zze2);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(zze2);
        }
        this.zzfd = withAdListener.build();
        this.zzfd.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzfc.show();
    }

    public void showVideo() {
        this.zzff.show();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);

    /* access modifiers changed from: package-private */
    public AdLoader.Builder zza(Context context, String str) {
        return new AdLoader.Builder(context, str);
    }

    /* access modifiers changed from: package-private */
    public AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(zzm.zziw().zzaq(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }
}
