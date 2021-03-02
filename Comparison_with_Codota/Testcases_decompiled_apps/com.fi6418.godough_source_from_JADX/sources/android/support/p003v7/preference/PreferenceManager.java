package android.support.p003v7.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.p000v4.content.SharedPreferencesCompat;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.PreferenceManager */
public class PreferenceManager {
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";

    /* renamed from: a */
    private Context f2508a;

    /* renamed from: b */
    private long f2509b = 0;

    /* renamed from: c */
    private SharedPreferences f2510c;

    /* renamed from: d */
    private SharedPreferences.Editor f2511d;

    /* renamed from: e */
    private boolean f2512e;

    /* renamed from: f */
    private String f2513f;

    /* renamed from: g */
    private int f2514g;

    /* renamed from: h */
    private PreferenceScreen f2515h;

    /* renamed from: i */
    private OnPreferenceTreeClickListener f2516i;

    /* renamed from: j */
    private OnDisplayPreferenceDialogListener f2517j;

    /* renamed from: k */
    private OnNavigateToScreenListener f2518k;

    /* renamed from: android.support.v7.preference.PreferenceManager$OnDisplayPreferenceDialogListener */
    public interface OnDisplayPreferenceDialogListener {
        void onDisplayPreferenceDialog(Preference preference);
    }

    /* renamed from: android.support.v7.preference.PreferenceManager$OnNavigateToScreenListener */
    public interface OnNavigateToScreenListener {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    /* renamed from: android.support.v7.preference.PreferenceManager$OnPreferenceTreeClickListener */
    public interface OnPreferenceTreeClickListener {
        boolean onPreferenceTreeClick(Preference preference);
    }

    public PreferenceManager(Context context) {
        this.f2508a = context;
        setSharedPreferencesName(m1630a(context));
    }

    /* renamed from: a */
    private static String m1630a(Context context) {
        return context.getPackageName() + "_preferences";
    }

    /* renamed from: a */
    private void m1631a(boolean z) {
        if (!z && this.f2511d != null) {
            SharedPreferencesCompat.EditorCompat.getInstance().apply(this.f2511d);
        }
        this.f2512e = z;
    }

    /* renamed from: d */
    private static int m1632d() {
        return 0;
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(m1630a(context), m1632d());
    }

    public static void setDefaultValues(Context context, int i, boolean z) {
        setDefaultValues(context, m1630a(context), m1632d(), i, z);
    }

    public static void setDefaultValues(Context context, String str, int i, int i2, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_HAS_SET_DEFAULT_VALUES, 0);
        if (z || !sharedPreferences.getBoolean(KEY_HAS_SET_DEFAULT_VALUES, false)) {
            PreferenceManager preferenceManager = new PreferenceManager(context);
            preferenceManager.setSharedPreferencesName(str);
            preferenceManager.setSharedPreferencesMode(i);
            preferenceManager.inflateFromResource(context, i2, (PreferenceScreen) null);
            SharedPreferencesCompat.EditorCompat.getInstance().apply(sharedPreferences.edit().putBoolean(KEY_HAS_SET_DEFAULT_VALUES, true));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo4909a() {
        long j;
        synchronized (this) {
            j = this.f2509b;
            this.f2509b = 1 + j;
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public SharedPreferences.Editor mo4910b() {
        if (!this.f2512e) {
            return getSharedPreferences().edit();
        }
        if (this.f2511d == null) {
            this.f2511d = getSharedPreferences().edit();
        }
        return this.f2511d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo4911c() {
        return !this.f2512e;
    }

    public PreferenceScreen createPreferenceScreen(Context context) {
        PreferenceScreen preferenceScreen = new PreferenceScreen(context, (AttributeSet) null);
        preferenceScreen.mo4783a(this);
        return preferenceScreen;
    }

    public Preference findPreference(CharSequence charSequence) {
        if (this.f2515h == null) {
            return null;
        }
        return this.f2515h.findPreference(charSequence);
    }

    public Context getContext() {
        return this.f2508a;
    }

    public OnDisplayPreferenceDialogListener getOnDisplayPreferenceDialogListener() {
        return this.f2517j;
    }

    public OnNavigateToScreenListener getOnNavigateToScreenListener() {
        return this.f2518k;
    }

    public OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return this.f2516i;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.f2515h;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.f2510c == null) {
            this.f2510c = this.f2508a.getSharedPreferences(this.f2513f, this.f2514g);
        }
        return this.f2510c;
    }

    public int getSharedPreferencesMode() {
        return this.f2514g;
    }

    public String getSharedPreferencesName() {
        return this.f2513f;
    }

    public PreferenceScreen inflateFromResource(Context context, int i, PreferenceScreen preferenceScreen) {
        m1631a(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new PreferenceInflater(context, this).inflate(i, (PreferenceGroup) preferenceScreen);
        preferenceScreen2.mo4783a(this);
        m1631a(false);
        return preferenceScreen2;
    }

    public void setOnDisplayPreferenceDialogListener(OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener) {
        this.f2517j = onDisplayPreferenceDialogListener;
    }

    public void setOnNavigateToScreenListener(OnNavigateToScreenListener onNavigateToScreenListener) {
        this.f2518k = onNavigateToScreenListener;
    }

    public void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        this.f2516i = onPreferenceTreeClickListener;
    }

    public boolean setPreferences(PreferenceScreen preferenceScreen) {
        if (preferenceScreen == this.f2515h) {
            return false;
        }
        this.f2515h = preferenceScreen;
        return true;
    }

    public void setSharedPreferencesMode(int i) {
        this.f2514g = i;
        this.f2510c = null;
    }

    public void setSharedPreferencesName(String str) {
        this.f2513f = str;
        this.f2510c = null;
    }

    public void showDialog(Preference preference) {
        if (this.f2517j != null) {
            this.f2517j.onDisplayPreferenceDialog(preference);
        }
    }
}
