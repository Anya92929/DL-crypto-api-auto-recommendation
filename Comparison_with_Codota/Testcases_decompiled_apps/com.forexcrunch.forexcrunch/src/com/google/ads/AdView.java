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
import com.actionbarsherlock.view.Menu;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0232a;
import com.google.ads.internal.C0237b;
import com.google.ads.internal.C0247d;
import com.google.ads.internal.C0257k;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import java.util.HashSet;
import java.util.Set;
import org.achartengine.renderer.DefaultRenderer;

public class AdView extends RelativeLayout implements C0165Ad {

    /* renamed from: b */
    private static final C0232a f116b = C0232a.f474a.mo3484b();

    /* renamed from: a */
    protected C0247d f117a;

    public AdView(Activity activity, AdSize adSize, String adUnitId) {
        super(activity.getApplicationContext());
        try {
            m24a((Context) activity, adSize, (AttributeSet) null);
            m28b(activity, adSize, (AttributeSet) null);
            m20a(activity, adSize, adUnitId);
        } catch (C0237b e) {
            m22a((Context) activity, e.mo3487c("Could not initialize AdView"), adSize, (AttributeSet) null);
            e.mo3485a("Could not initialize AdView");
        }
    }

    protected AdView(Activity activity, AdSize[] adSizes, String adUnitId) {
        this(activity, new AdSize(0, 0), adUnitId);
        m23a(adSizes);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m21a(context, attrs);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3306a(Context context, String str, int i, AdSize adSize, AttributeSet attributeSet) {
        if (adSize == null) {
            adSize = AdSize.BANNER;
        }
        AdSize createAdSize = AdSize.createAdSize(adSize, context.getApplicationContext());
        if (getChildCount() == 0) {
            TextView textView = attributeSet == null ? new TextView(context) : new TextView(context, attributeSet);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(DefaultRenderer.BACKGROUND_COLOR);
            LinearLayout linearLayout = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout.setGravity(17);
            LinearLayout linearLayout2 = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundColor(i);
            int a = AdUtil.m437a(context, createAdSize.getWidth());
            int a2 = AdUtil.m437a(context, createAdSize.getHeight());
            linearLayout.addView(textView, a - 2, a2 - 2);
            linearLayout2.addView(linearLayout);
            addView(linearLayout2, a, a2);
        }
    }

    /* renamed from: a */
    private boolean m24a(Context context, AdSize adSize, AttributeSet attributeSet) {
        if (AdUtil.m461c(context)) {
            return true;
        }
        m22a(context, "You must have AdActivity declared in AndroidManifest.xml with configChanges.", adSize, attributeSet);
        return false;
    }

    /* renamed from: b */
    private boolean m28b(Context context, AdSize adSize, AttributeSet attributeSet) {
        if (AdUtil.m459b(context)) {
            return true;
        }
        m22a(context, "You must have INTERNET and ACCESS_NETWORK_STATE permissions in AndroidManifest.xml.", adSize, attributeSet);
        return false;
    }

    public void destroy() {
        this.f117a.mo3538b();
    }

    /* renamed from: a */
    private void m22a(Context context, String str, AdSize adSize, AttributeSet attributeSet) {
        C0284b.m484b(str);
        mo3306a(context, str, Menu.CATEGORY_MASK, adSize, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdSize[] mo3307a(String str) {
        AdSize adSize;
        String[] split = str.split(",");
        AdSize[] adSizeArr = new AdSize[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    adSize = new AdSize("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    return null;
                }
            } else {
                adSize = "BANNER".equals(trim) ? AdSize.BANNER : "SMART_BANNER".equals(trim) ? AdSize.SMART_BANNER : "IAB_MRECT".equals(trim) ? AdSize.IAB_MRECT : "IAB_BANNER".equals(trim) ? AdSize.IAB_BANNER : "IAB_LEADERBOARD".equals(trim) ? AdSize.IAB_LEADERBOARD : "IAB_WIDE_SKYSCRAPER".equals(trim) ? AdSize.IAB_WIDE_SKYSCRAPER : null;
            }
            if (adSize == null) {
                return null;
            }
            adSizeArr[i] = adSize;
        }
        return adSizeArr;
    }

    /* renamed from: a */
    private void m21a(Context context, AttributeSet attributeSet) {
        AdSize[] adSizeArr;
        C0237b bVar;
        if (attributeSet != null) {
            try {
                String b = m27b("adSize", context, attributeSet, true);
                AdSize[] a = mo3307a(b);
                if (a != null) {
                    try {
                        if (a.length != 0) {
                            if (!m26a("adUnitId", attributeSet)) {
                                throw new C0237b("Required XML attribute \"adUnitId\" missing", true);
                            } else if (isInEditMode()) {
                                mo3306a(context, "Ads by Google", -1, a[0], attributeSet);
                                return;
                            } else {
                                String b2 = m27b("adUnitId", context, attributeSet, true);
                                boolean a2 = m25a("loadAdOnCreate", context, attributeSet, false);
                                if (context instanceof Activity) {
                                    Activity activity = (Activity) context;
                                    m24a((Context) activity, a[0], attributeSet);
                                    m28b(activity, a[0], attributeSet);
                                    if (a.length == 1) {
                                        m20a(activity, a[0], b2);
                                    } else {
                                        m20a(activity, new AdSize(0, 0), b2);
                                        m23a(a);
                                    }
                                    if (a2) {
                                        Set<String> c = m29c("testDevices", context, attributeSet, false);
                                        if (c.contains("TEST_EMULATOR")) {
                                            c.remove("TEST_EMULATOR");
                                            c.add(AdRequest.TEST_EMULATOR);
                                        }
                                        loadAd(new AdRequest().setTestDevices(c).setKeywords(m29c("keywords", context, attributeSet, false)));
                                        return;
                                    }
                                    return;
                                }
                                throw new C0237b("AdView was initialized with a Context that wasn't an Activity.", true);
                            }
                        }
                    } catch (C0237b e) {
                        bVar = e;
                        adSizeArr = a;
                        m22a(context, bVar.mo3487c("Could not initialize AdView"), (adSizeArr == null || adSizeArr.length <= 0) ? AdSize.BANNER : adSizeArr[0], attributeSet);
                        bVar.mo3485a("Could not initialize AdView");
                        if (!isInEditMode()) {
                            bVar.mo3486b("Could not initialize AdView");
                            return;
                        }
                        return;
                    }
                }
                throw new C0237b("Attribute \"adSize\" invalid: " + b, true);
            } catch (C0237b e2) {
                C0237b bVar2 = e2;
                adSizeArr = null;
                bVar = bVar2;
            }
        }
    }

    /* renamed from: a */
    private boolean m25a(String str, Context context, AttributeSet attributeSet, boolean z) throws C0237b {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        boolean attributeBooleanValue = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.google.ads", str, z);
        if (attributeValue != null) {
            String packageName = context.getPackageName();
            if (attributeValue.matches("^@([^:]+)\\:(.*)$")) {
                packageName = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                attributeValue = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (attributeValue.startsWith("@bool/")) {
                String substring = attributeValue.substring("@bool/".length());
                TypedValue typedValue = new TypedValue();
                try {
                    getResources().getValue(packageName + ":bool/" + substring, typedValue, true);
                    if (typedValue.type == 18) {
                        return typedValue.data != 0;
                    }
                    throw new C0237b("Resource " + str + " was not a boolean: " + typedValue, true);
                } catch (Resources.NotFoundException e) {
                    throw new C0237b("Could not find resource for " + str + ": " + attributeValue, true, e);
                }
            }
        }
        return attributeBooleanValue;
    }

    /* renamed from: b */
    private String m27b(String str, Context context, AttributeSet attributeSet, boolean z) throws C0237b {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        if (attributeValue != null) {
            String packageName = context.getPackageName();
            if (attributeValue.matches("^@([^:]+)\\:(.*)$")) {
                packageName = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                attributeValue = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (attributeValue.startsWith("@string/")) {
                String substring = attributeValue.substring("@string/".length());
                TypedValue typedValue = new TypedValue();
                try {
                    getResources().getValue(packageName + ":string/" + substring, typedValue, true);
                    if (typedValue.string != null) {
                        attributeValue = typedValue.string.toString();
                    } else {
                        throw new C0237b("Resource " + str + " was not a string: " + typedValue, true);
                    }
                } catch (Resources.NotFoundException e) {
                    throw new C0237b("Could not find resource for " + str + ": " + attributeValue, true, e);
                }
            }
        }
        if (!z || attributeValue != null) {
            return attributeValue;
        }
        throw new C0237b("Required XML attribute \"" + str + "\" missing", true);
    }

    /* renamed from: c */
    private Set<String> m29c(String str, Context context, AttributeSet attributeSet, boolean z) throws C0237b {
        String b = m27b(str, context, attributeSet, z);
        HashSet hashSet = new HashSet();
        if (b != null) {
            for (String trim : b.split(",")) {
                String trim2 = trim.trim();
                if (trim2.length() != 0) {
                    hashSet.add(trim2);
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private boolean m26a(String str, AttributeSet attributeSet) {
        return attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str) != null;
    }

    /* renamed from: a */
    private void m20a(Activity activity, AdSize adSize, String str) throws C0237b {
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setFocusable(false);
        this.f117a = new C0247d(this, activity, adSize, str, frameLayout, false);
        setGravity(17);
        try {
            ViewGroup a = C0257k.m408a(activity, this.f117a);
            if (a != null) {
                a.addView(frameLayout, -2, -2);
                addView(a, -2, -2);
                return;
            }
            addView(frameLayout, -2, -2);
        } catch (VerifyError e) {
            C0284b.m481a("Gestures disabled: Not supported on this version of Android.", (Throwable) e);
            addView(frameLayout, -2, -2);
        }
    }

    public boolean isReady() {
        if (this.f117a == null) {
            return false;
        }
        return this.f117a.mo3560s();
    }

    public boolean isRefreshing() {
        if (this.f117a == null) {
            return false;
        }
        return this.f117a.mo3561t();
    }

    public void loadAd(AdRequest adRequest) {
        if (this.f117a != null) {
            if (isRefreshing()) {
                this.f117a.mo3547f();
            }
            this.f117a.mo3530a(adRequest);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f117a.mo3550i().f668o.mo3727a(adListener);
    }

    /* access modifiers changed from: protected */
    public void setAppEventListener(AppEventListener appEventListener) {
        this.f117a.mo3550i().f669p.mo3727a(appEventListener);
    }

    /* access modifiers changed from: protected */
    public void setSwipeableEventListener(SwipeableAdListener swipeableEventListener) {
        this.f117a.mo3550i().f670q.mo3727a(swipeableEventListener);
    }

    /* access modifiers changed from: protected */
    public void setSupportedAdSizes(AdSize... adSizes) {
        if (this.f117a.mo3550i().f667n.mo3726a() == null) {
            C0284b.m490e("Warning: Tried to set supported ad sizes on a single-size AdView. AdSizes ignored. To create a multi-sized AdView, use an AdView constructor that takes in an AdSize[] array.");
        } else {
            m23a(adSizes);
        }
    }

    /* renamed from: a */
    private void m23a(AdSize... adSizeArr) {
        AdSize[] adSizeArr2 = new AdSize[adSizeArr.length];
        for (int i = 0; i < adSizeArr.length; i++) {
            adSizeArr2[i] = AdSize.createAdSize(adSizeArr[i], getContext());
        }
        this.f117a.mo3550i().f667n.mo3727a(adSizeArr2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        AdWebView l;
        if (!isInEditMode() && (l = this.f117a.mo3553l()) != null) {
            l.setVisibility(0);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void stopLoading() {
        if (this.f117a != null) {
            this.f117a.mo3518C();
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (!isInEditMode() && this.f117a.mo3550i().f660g.mo3725a().mo3611b() && visibility != 0 && this.f117a.mo3550i().f665l.mo3726a() != null && this.f117a.mo3550i().f658e.mo3725a() != null) {
            if (!AdActivity.isShowing() || AdActivity.leftApplication()) {
                f116b.mo3476a(this.f117a.mo3550i().f658e.mo3725a(), "onleaveapp", (String) null);
            } else {
                f116b.mo3476a(this.f117a.mo3550i().f658e.mo3725a(), "onopeninapp", (String) null);
            }
        }
    }
}
