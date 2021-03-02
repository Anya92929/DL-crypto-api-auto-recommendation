package com.google.ads;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.google.ads.doubleclick.DfpExtras;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdRequest {
    public static final String LOGTAG = "Ads";
    public static final String TEST_EMULATOR = AdUtil.m456b("emulator");
    public static final String VERSION = "6.4.1";

    /* renamed from: a */
    private static final SimpleDateFormat f95a = new SimpleDateFormat("yyyyMMdd");

    /* renamed from: b */
    private static Method f96b;

    /* renamed from: c */
    private static Method f97c;

    /* renamed from: d */
    private Gender f98d = null;

    /* renamed from: e */
    private Date f99e = null;

    /* renamed from: f */
    private Set<String> f100f = null;

    /* renamed from: g */
    private Map<String, Object> f101g = null;

    /* renamed from: h */
    private final Map<Class<?>, NetworkExtras> f102h = new HashMap();

    /* renamed from: i */
    private Location f103i = null;

    /* renamed from: j */
    private boolean f104j = false;

    /* renamed from: k */
    private boolean f105k = false;

    /* renamed from: l */
    private Set<String> f106l = null;

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    static {
        f96b = null;
        f97c = null;
        try {
            for (Method method : Class.forName("com.google.analytics.tracking.android.AdMobInfo").getMethods()) {
                if (method.getName().equals("getInstance") && method.getParameterTypes().length == 0) {
                    f96b = method;
                } else if (method.getName().equals("getJoinIds") && method.getParameterTypes().length == 0) {
                    f97c = method;
                }
            }
            if (f96b == null || f97c == null) {
                f96b = null;
                f97c = null;
                C0284b.m490e("No Google Analytics: Library Incompatible.");
            }
        } catch (ClassNotFoundException e) {
            C0284b.m480a("No Google Analytics: Library Not Found.");
        } catch (Throwable th) {
            C0284b.m480a("No Google Analytics: Error Loading Library");
        }
    }

    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        

        /* renamed from: a */
        private final String f108a;

        private ErrorCode(String description) {
            this.f108a = description;
        }

        public String toString() {
            return this.f108a;
        }
    }

    public AdRequest setGender(Gender gender) {
        this.f98d = gender;
        return this;
    }

    public Gender getGender() {
        return this.f98d;
    }

    @Deprecated
    public AdRequest setBirthday(String birthday) {
        if (birthday == "" || birthday == null) {
            this.f99e = null;
        } else {
            try {
                this.f99e = f95a.parse(birthday);
            } catch (ParseException e) {
                C0284b.m490e("Birthday format invalid.  Expected 'YYYYMMDD' where 'YYYY' is a 4 digit year, 'MM' is a two digit month, and 'DD' is a two digit day.  Birthday value ignored");
                this.f99e = null;
            }
        }
        return this;
    }

    public AdRequest setBirthday(Date birthday) {
        if (birthday == null) {
            this.f99e = null;
        } else {
            this.f99e = new Date(birthday.getTime());
        }
        return this;
    }

    public AdRequest setBirthday(Calendar calendar) {
        if (calendar == null) {
            this.f99e = null;
        } else {
            setBirthday(calendar.getTime());
        }
        return this;
    }

    public Date getBirthday() {
        return this.f99e;
    }

    public AdRequest clearBirthday() {
        this.f99e = null;
        return this;
    }

    @Deprecated
    public AdRequest setPlusOneOptOut(boolean plusOneOptOut) {
        m16a().setPlusOneOptOut(plusOneOptOut);
        return this;
    }

    @Deprecated
    public boolean getPlusOneOptOut() {
        return m16a().getPlusOneOptOut();
    }

    public AdRequest setKeywords(Set<String> keywords) {
        this.f100f = keywords;
        return this;
    }

    public AdRequest addKeyword(String keyword) {
        if (this.f100f == null) {
            this.f100f = new HashSet();
        }
        this.f100f.add(keyword);
        return this;
    }

    public AdRequest addKeywords(Set<String> keywords) {
        if (this.f100f == null) {
            this.f100f = new HashSet();
        }
        this.f100f.addAll(keywords);
        return this;
    }

    public Set<String> getKeywords() {
        if (this.f100f == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.f100f);
    }

    /* renamed from: a */
    private synchronized AdMobAdapterExtras m16a() {
        if (getNetworkExtras(AdMobAdapterExtras.class) == null) {
            setNetworkExtras(new AdMobAdapterExtras());
        }
        return (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
    }

    @Deprecated
    public AdRequest setExtras(Map<String, Object> extras) {
        m16a().setExtras(extras);
        return this;
    }

    @Deprecated
    public AdRequest addExtra(String key, Object value) {
        AdMobAdapterExtras a = m16a();
        if (a.getExtras() == null) {
            a.setExtras(new HashMap());
        }
        a.getExtras().put(key, value);
        return this;
    }

    public AdRequest setNetworkExtras(NetworkExtras extras) {
        if (extras != null) {
            this.f102h.put(extras.getClass(), extras);
        }
        return this;
    }

    public AdRequest removeNetworkExtras(Class<?> extrasClass) {
        this.f102h.remove(extrasClass);
        return this;
    }

    public <T> T getNetworkExtras(Class<T> extrasClass) {
        return this.f102h.get(extrasClass);
    }

    public AdRequest setMediationExtras(Map<String, Object> mediationExtras) {
        this.f101g = mediationExtras;
        return this;
    }

    public AdRequest addMediationExtra(String key, Object value) {
        if (this.f101g == null) {
            this.f101g = new HashMap();
        }
        this.f101g.put(key, value);
        return this;
    }

    public AdRequest setLocation(Location location) {
        this.f103i = location;
        return this;
    }

    public Location getLocation() {
        return this.f103i;
    }

    @Deprecated
    public AdRequest setTesting(boolean testing) {
        this.f104j = testing;
        return this;
    }

    public Map<String, Object> getRequestMap(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        if (this.f100f != null) {
            hashMap.put("kw", this.f100f);
        }
        if (this.f98d != null) {
            hashMap.put("cust_gender", Integer.valueOf(this.f98d.ordinal()));
        }
        if (this.f99e != null) {
            hashMap.put("cust_age", f95a.format(this.f99e));
        }
        if (this.f103i != null) {
            hashMap.put("uule", AdUtil.m444a(this.f103i));
        }
        if (this.f104j) {
            hashMap.put("testing", 1);
        }
        if (isTestDevice(context)) {
            hashMap.put("adtest", "on");
        } else if (!this.f105k) {
            if (AdUtil.m460c()) {
                str = "AdRequest.TEST_EMULATOR";
            } else {
                str = "\"" + AdUtil.m441a(context) + "\"";
            }
            C0284b.m486c("To get test ads on this device, call adRequest.addTestDevice(" + str + ");");
            this.f105k = true;
        }
        AdMobAdapterExtras adMobAdapterExtras = (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
        DfpExtras dfpExtras = (DfpExtras) getNetworkExtras(DfpExtras.class);
        if (dfpExtras != null && dfpExtras.getExtras() != null && !dfpExtras.getExtras().isEmpty()) {
            hashMap.put("extras", dfpExtras.getExtras());
        } else if (!(adMobAdapterExtras == null || adMobAdapterExtras.getExtras() == null || adMobAdapterExtras.getExtras().isEmpty())) {
            hashMap.put("extras", adMobAdapterExtras.getExtras());
        }
        if (dfpExtras != null) {
            String publisherProvidedId = dfpExtras.getPublisherProvidedId();
            if (!TextUtils.isEmpty(publisherProvidedId)) {
                hashMap.put("ppid", publisherProvidedId);
            }
        }
        if (this.f101g != null) {
            hashMap.put("mediation_extras", this.f101g);
        }
        try {
            if (f96b != null) {
                Map map = (Map) f97c.invoke(f96b.invoke((Object) null, new Object[0]), new Object[0]);
                if (map != null && map.size() > 0) {
                    hashMap.put("analytics_join_id", map);
                }
            }
        } catch (Throwable th) {
            C0284b.m487c("Internal Analytics Error:", th);
        }
        return hashMap;
    }

    public AdRequest addTestDevice(String testDevice) {
        if (this.f106l == null) {
            this.f106l = new HashSet();
        }
        this.f106l.add(testDevice);
        return this;
    }

    public AdRequest setTestDevices(Set<String> testDevices) {
        this.f106l = testDevices;
        return this;
    }

    public boolean isTestDevice(Context context) {
        String a;
        if (this.f106l == null || (a = AdUtil.m441a(context)) == null || !this.f106l.contains(a)) {
            return false;
        }
        return true;
    }
}
