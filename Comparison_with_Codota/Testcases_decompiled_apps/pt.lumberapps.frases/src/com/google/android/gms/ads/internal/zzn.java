package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.internal.zzdr;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

@zzin
public class zzn {
    /* renamed from: a */
    private static zzd m5829a(zzgn zzgn) {
        return new zzd(zzgn.getHeadline(), zzgn.getImages(), zzgn.getBody(), zzgn.zzku(), zzgn.getCallToAction(), zzgn.getStarRating(), zzgn.getStore(), zzgn.getPrice(), (zza) null, zzgn.getExtras());
    }

    /* renamed from: a */
    private static zze m5830a(zzgo zzgo) {
        return new zze(zzgo.getHeadline(), zzgo.getImages(), zzgo.getBody(), zzgo.zzky(), zzgo.getCallToAction(), zzgo.getAdvertiser(), (zza) null, zzgo.getExtras());
    }

    /* renamed from: a */
    static zzep m5832a(zzgn zzgn, zzgo zzgo, zzf.zza zza) {
        return new C1327x(zzgn, zza, zzgo);
    }

    /* renamed from: a */
    static zzep m5833a(CountDownLatch countDownLatch) {
        return new C1325v(countDownLatch);
    }

    /* renamed from: a */
    private static String m5834a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzkd.zzcx("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        String valueOf2 = String.valueOf(encodeToString);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: a */
    static String m5835a(zzdr zzdr) {
        if (zzdr == null) {
            zzkd.zzcx("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzdr.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzkd.zzcx("Unable to get image uri. Trying data uri next");
        }
        return m5844b(zzdr);
    }

    /* renamed from: a */
    private static void m5838a(zzlh zzlh, zzd zzd, String str) {
        zzlh.zzuj().zza((zzli.zza) new C1321t(zzd, str, zzlh));
    }

    /* renamed from: a */
    private static void m5839a(zzlh zzlh, zze zze, String str) {
        zzlh.zzuj().zza((zzli.zza) new C1322u(zze, str, zzlh));
    }

    /* renamed from: a */
    private static void m5840a(zzlh zzlh, CountDownLatch countDownLatch) {
        zzlh.zzuj().zza("/nativeExpressAssetsLoaded", m5833a(countDownLatch));
        zzlh.zzuj().zza("/nativeExpressAssetsLoadingFailed", m5843b(countDownLatch));
    }

    /* renamed from: a */
    private static boolean m5841a(zzlh zzlh, zzge zzge, CountDownLatch countDownLatch) {
        View view = zzlh.getView();
        if (view == null) {
            zzkd.zzcx("AdWebView is null");
            return false;
        }
        view.setVisibility(4);
        List list = zzge.zzbon.zzbni;
        if (list == null || list.isEmpty()) {
            zzkd.zzcx("No template ids present in mediation response");
            return false;
        }
        m5840a(zzlh, countDownLatch);
        zzgn zzmo = zzge.zzboo.zzmo();
        zzgo zzmp = zzge.zzboo.zzmp();
        if (list.contains("2") && zzmo != null) {
            m5838a(zzlh, m5829a(zzmo), zzge.zzbon.zzbnh);
        } else if (!list.contains("1") || zzmp == null) {
            zzkd.zzcx("No matching template id and mapper");
            return false;
        } else {
            m5839a(zzlh, m5830a(zzmp), zzge.zzbon.zzbnh);
        }
        String str = zzge.zzbon.zzbnf;
        String str2 = zzge.zzbon.zzbng;
        if (str2 != null) {
            zzlh.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        } else {
            zzlh.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static zzdr m5842b(Object obj) {
        if (obj instanceof IBinder) {
            return zzdr.zza.zzy((IBinder) obj);
        }
        return null;
    }

    /* renamed from: b */
    static zzep m5843b(CountDownLatch countDownLatch) {
        return new C1326w(countDownLatch);
    }

    /* renamed from: b */
    private static String m5844b(zzdr zzdr) {
        try {
            com.google.android.gms.dynamic.zzd zzkt = zzdr.zzkt();
            if (zzkt == null) {
                zzkd.zzcx("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) com.google.android.gms.dynamic.zze.zzad(zzkt);
            if (drawable instanceof BitmapDrawable) {
                return m5834a(((BitmapDrawable) drawable).getBitmap());
            }
            zzkd.zzcx("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException e) {
            zzkd.zzcx("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static JSONObject m5845b(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (bundle.containsKey(next)) {
                if ("image".equals(jSONObject2.getString(next))) {
                    Object obj = bundle.get(next);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(next, m5834a((Bitmap) obj));
                    } else {
                        zzkd.zzcx("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(next) instanceof Bitmap) {
                    zzkd.zzcx("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(next, String.valueOf(bundle.get(next)));
                }
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m5846b(zzlh zzlh) {
        View.OnClickListener zzuw = zzlh.zzuw();
        if (zzuw != null) {
            zzuw.onClick(zzlh.getView());
        }
    }

    public static void zza(zzju zzju, zzf.zza zza) {
        zzgo zzgo = null;
        if (zzju != null && zzg(zzju)) {
            zzlh zzlh = zzju.zzbtm;
            View view = zzlh != null ? zzlh.getView() : null;
            if (view == null) {
                zzkd.zzcx("AdWebView is null");
                return;
            }
            try {
                List list = zzju.zzbon != null ? zzju.zzbon.zzbni : null;
                if (list == null || list.isEmpty()) {
                    zzkd.zzcx("No template ids present in mediation response");
                    return;
                }
                zzgn zzmo = zzju.zzboo != null ? zzju.zzboo.zzmo() : null;
                if (zzju.zzboo != null) {
                    zzgo = zzju.zzboo.zzmp();
                }
                if (list.contains("2") && zzmo != null) {
                    zzmo.zzl(com.google.android.gms.dynamic.zze.zzac(view));
                    if (!zzmo.getOverrideImpressionRecording()) {
                        zzmo.recordImpression();
                    }
                    zzlh.zzuj().zza("/nativeExpressViewClicked", m5832a(zzmo, (zzgo) null, zza));
                } else if (!list.contains("1") || zzgo == null) {
                    zzkd.zzcx("No matching template id and mapper");
                } else {
                    zzgo.zzl(com.google.android.gms.dynamic.zze.zzac(view));
                    if (!zzgo.getOverrideImpressionRecording()) {
                        zzgo.recordImpression();
                    }
                    zzlh.zzuj().zza("/nativeExpressViewClicked", m5832a((zzgn) null, zzgo, zza));
                }
            } catch (RemoteException e) {
                zzkd.zzd("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    public static boolean zza(zzlh zzlh, zzge zzge, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = m5841a(zzlh, zzge, countDownLatch);
        } catch (RemoteException e) {
            zzkd.zzd("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    public static View zzf(zzju zzju) {
        if (zzju == null) {
            zzkd.m5769e("AdState is null");
            return null;
        } else if (zzg(zzju) && zzju.zzbtm != null) {
            return zzju.zzbtm.getView();
        } else {
            try {
                com.google.android.gms.dynamic.zzd view = zzju.zzboo != null ? zzju.zzboo.getView() : null;
                if (view != null) {
                    return (View) com.google.android.gms.dynamic.zze.zzad(view);
                }
                zzkd.zzcx("View in mediation adapter is null.");
                return null;
            } catch (RemoteException e) {
                zzkd.zzd("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzg(zzju zzju) {
        return (zzju == null || !zzju.zzcby || zzju.zzbon == null || zzju.zzbon.zzbnf == null) ? false : true;
    }
}
