package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.internal.b;
import com.google.ads.internal.d;
import com.google.ads.internal.j;
import com.google.ads.util.AdUtil;
import java.util.HashSet;
import java.util.Set;

public class AdView extends RelativeLayout implements Ad {
    private m a;
    private d b;

    public AdView(Activity activity, AdSize adSize, String adUnitId) {
        super(activity.getApplicationContext());
        try {
            a((Context) activity, adSize, (AttributeSet) null);
            b(activity, adSize, (AttributeSet) null);
            a(activity, adSize, adUnitId);
        } catch (b e) {
            a(activity, e.c("Could not initialize AdView"), adSize, (AttributeSet) null);
            e.a("Could not initialize AdView");
        }
    }

    protected AdView(Activity activity, AdSize[] adSizes, String adUnitId) {
        this(activity, new AdSize(0, 0), adUnitId);
        a(adSizes);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context, attrs);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str, int i, AdSize adSize, AttributeSet attributeSet) {
        if (adSize == null) {
            adSize = AdSize.BANNER;
        }
        AdSize createAdSize = AdSize.createAdSize(adSize, context.getApplicationContext());
        if (getChildCount() == 0) {
            TextView textView = attributeSet == null ? new TextView(context) : new TextView(context, attributeSet);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(-16777216);
            LinearLayout linearLayout = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout.setGravity(17);
            LinearLayout linearLayout2 = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundColor(i);
            int a2 = a(context, createAdSize.getWidth());
            int a3 = a(context, createAdSize.getHeight());
            linearLayout.addView(textView, a2 - 2, a3 - 2);
            linearLayout2.addView(linearLayout);
            addView(linearLayout2, a2, a3);
        }
    }

    private int a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    private boolean a(Context context, AdSize adSize, AttributeSet attributeSet) {
        if (AdUtil.c(context)) {
            return true;
        }
        a(context, "You must have AdActivity declared in AndroidManifest.xml with configChanges.", adSize, attributeSet);
        return false;
    }

    private boolean b(Context context, AdSize adSize, AttributeSet attributeSet) {
        if (AdUtil.b(context)) {
            return true;
        }
        a(context, "You must have INTERNET and ACCESS_NETWORK_STATE permissions in AndroidManifest.xml.", adSize, attributeSet);
        return false;
    }

    public void destroy() {
        this.b.b();
    }

    private void a(Context context, String str, AdSize adSize, AttributeSet attributeSet) {
        com.google.ads.util.b.b(str);
        a(context, str, -65536, adSize, attributeSet);
    }

    private AdSize[] a(String str) {
        AdSize adSize;
        String[] split = str.split(",");
        AdSize[] adSizeArr = new AdSize[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if ("BANNER".equals(trim)) {
                adSize = AdSize.BANNER;
            } else {
                adSize = "SMART_BANNER".equals(trim) ? AdSize.SMART_BANNER : "IAB_MRECT".equals(trim) ? AdSize.IAB_MRECT : "IAB_BANNER".equals(trim) ? AdSize.IAB_BANNER : "IAB_LEADERBOARD".equals(trim) ? AdSize.IAB_LEADERBOARD : "IAB_WIDE_SKYSCRAPER".equals(trim) ? AdSize.IAB_WIDE_SKYSCRAPER : null;
            }
            if (adSize == null) {
                return null;
            }
            adSizeArr[i] = adSize;
        }
        return adSizeArr;
    }

    private void a(Context context, AttributeSet attributeSet) {
        b bVar;
        AdSize[] adSizeArr;
        if (attributeSet != null) {
            try {
                String a2 = a("adSize", context, attributeSet, false, true);
                AdSize[] a3 = a(a2);
                if (a3 != null) {
                    try {
                        if (a3.length != 0) {
                            if (!a("adUnitId", attributeSet)) {
                                throw new b("Required XML attribute \"adUnitId\" missing", true);
                            } else if (isInEditMode()) {
                                a(context, "Ads by Google", -1, a3[0], attributeSet);
                                return;
                            } else {
                                String a4 = a("adUnitId", context, attributeSet, true, true);
                                boolean attributeBooleanValue = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.google.ads", "loadAdOnCreate", false);
                                if (context instanceof Activity) {
                                    Activity activity = (Activity) context;
                                    a((Context) activity, a3[0], attributeSet);
                                    b(activity, a3[0], attributeSet);
                                    if (a3.length == 1) {
                                        a(activity, a3[0], a4);
                                    } else {
                                        a(activity, new AdSize(0, 0), a4);
                                        a(a3);
                                    }
                                    if (attributeBooleanValue) {
                                        Set<String> b2 = b("testDevices", context, attributeSet, false, false);
                                        if (b2.contains("TEST_EMULATOR")) {
                                            b2.remove("TEST_EMULATOR");
                                            b2.add(AdRequest.TEST_EMULATOR);
                                        }
                                        loadAd(new AdRequest().setTestDevices(b2).setKeywords(b("keywords", context, attributeSet, false, false)));
                                        return;
                                    }
                                    return;
                                }
                                throw new b("AdView was initialized with a Context that wasn't an Activity.", true);
                            }
                        }
                    } catch (b e) {
                        bVar = e;
                        adSizeArr = a3;
                        a(context, bVar.c("Could not initialize AdView"), (adSizeArr == null || adSizeArr.length <= 0) ? AdSize.BANNER : adSizeArr[0], attributeSet);
                        bVar.a("Could not initialize AdView");
                        if (!isInEditMode()) {
                            bVar.b("Could not initialize AdView");
                            return;
                        }
                        return;
                    }
                }
                throw new b("Attribute \"adSize\" invalid: " + a2, true);
            } catch (b e2) {
                bVar = e2;
                adSizeArr = null;
            }
        }
    }

    private String a(String str, Context context, AttributeSet attributeSet, boolean z, boolean z2) throws b {
        String str2;
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        if (attributeValue == null || !attributeValue.startsWith("@string/") || !z) {
            str2 = attributeValue;
        } else {
            String substring = attributeValue.substring("@string/".length());
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                getResources().getValue(packageName + ":string/" + substring, typedValue, true);
                if (typedValue.string != null) {
                    str2 = typedValue.string.toString();
                } else {
                    throw new b("Resource " + str + " was not a string: " + typedValue, true);
                }
            } catch (Resources.NotFoundException e) {
                throw new b("Could not find resource for " + str + ": " + attributeValue, true, e);
            }
        }
        if (!z2 || str2 != null) {
            return str2;
        }
        throw new b("Required XML attribute \"" + str + "\" missing", true);
    }

    private Set<String> b(String str, Context context, AttributeSet attributeSet, boolean z, boolean z2) throws b {
        String a2 = a(str, context, attributeSet, z, z2);
        HashSet hashSet = new HashSet();
        if (a2 != null) {
            for (String trim : a2.split(",")) {
                String trim2 = trim.trim();
                if (trim2.length() != 0) {
                    hashSet.add(trim2);
                }
            }
        }
        return hashSet;
    }

    private boolean a(String str, AttributeSet attributeSet) {
        return attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str) != null;
    }

    private void a(Activity activity, AdSize adSize, String str) throws b {
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setFocusable(false);
        this.a = m.a(this, str, activity, frameLayout, adSize);
        this.b = new d(this.a, false);
        setGravity(17);
        try {
            ViewGroup a2 = j.a(activity, this.b);
            if (a2 != null) {
                a2.addView(frameLayout, -2, -2);
                addView(a2, -2, -2);
                return;
            }
            addView(frameLayout, -2, -2);
        } catch (VerifyError e) {
            com.google.ads.util.b.a("Gestures disabled: Not supported on this version of Android.", (Throwable) e);
            addView(frameLayout, -2, -2);
        }
    }

    public boolean isReady() {
        if (this.b == null) {
            return false;
        }
        return this.b.r();
    }

    public boolean isRefreshing() {
        if (this.b == null) {
            return false;
        }
        return this.b.s();
    }

    public void loadAd(AdRequest adRequest) {
        if (this.b != null) {
            if (isRefreshing()) {
                this.b.e();
            }
            this.b.a(adRequest);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.a.k.a(adListener);
    }

    /* access modifiers changed from: protected */
    public void setAppEventListener(AppEventListener appEventListener) {
        this.a.l.a(appEventListener);
    }

    /* access modifiers changed from: protected */
    public void setSupportedAdSizes(AdSize... adSizes) {
        if (this.a.j.a() == null) {
            com.google.ads.util.b.b("Error: Tried to set supported ad sizes on a single-size AdView.");
        } else {
            a(adSizes);
        }
    }

    private void a(AdSize... adSizeArr) {
        AdSize[] adSizeArr2 = new AdSize[adSizeArr.length];
        for (int i = 0; i < adSizeArr.length; i++) {
            adSizeArr2[i] = AdSize.createAdSize(adSizeArr[i], getContext());
        }
        this.a.j.a(adSizeArr2);
    }

    public void stopLoading() {
        if (this.b != null) {
            this.b.A();
        }
    }
}
