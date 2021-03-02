package android.support.p003v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.content.SharedPreferencesCompat;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.support.p003v7.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.preference.Preference */
public class Preference implements Comparable<Preference> {
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;

    /* renamed from: A */
    private OnPreferenceChangeInternalListener f2443A;

    /* renamed from: B */
    private List<Preference> f2444B;

    /* renamed from: C */
    private boolean f2445C;

    /* renamed from: D */
    private final View.OnClickListener f2446D;

    /* renamed from: a */
    private Context f2447a;

    /* renamed from: b */
    private PreferenceManager f2448b;

    /* renamed from: c */
    private long f2449c;

    /* renamed from: d */
    private OnPreferenceChangeListener f2450d;

    /* renamed from: e */
    private OnPreferenceClickListener f2451e;

    /* renamed from: f */
    private int f2452f;

    /* renamed from: g */
    private CharSequence f2453g;

    /* renamed from: h */
    private CharSequence f2454h;

    /* renamed from: i */
    private int f2455i;

    /* renamed from: j */
    private Drawable f2456j;

    /* renamed from: k */
    private String f2457k;

    /* renamed from: l */
    private Intent f2458l;

    /* renamed from: m */
    private String f2459m;

    /* renamed from: n */
    private Bundle f2460n;

    /* renamed from: o */
    private boolean f2461o;

    /* renamed from: p */
    private boolean f2462p;

    /* renamed from: q */
    private boolean f2463q;

    /* renamed from: r */
    private boolean f2464r;

    /* renamed from: s */
    private String f2465s;

    /* renamed from: t */
    private Object f2466t;

    /* renamed from: u */
    private boolean f2467u;

    /* renamed from: v */
    private boolean f2468v;

    /* renamed from: w */
    private boolean f2469w;

    /* renamed from: x */
    private boolean f2470x;

    /* renamed from: y */
    private int f2471y;

    /* renamed from: z */
    private int f2472z;

    /* renamed from: android.support.v7.preference.Preference$BaseSavedState */
    public class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            public BaseSavedState[] newArray(int i) {
                return new BaseSavedState[i];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: android.support.v7.preference.Preference$OnPreferenceChangeInternalListener */
    interface OnPreferenceChangeInternalListener {
        void onPreferenceChange(Preference preference);

        void onPreferenceHierarchyChange(Preference preference);

        void onPreferenceVisibilityChange(Preference preference);
    }

    /* renamed from: android.support.v7.preference.Preference$OnPreferenceChangeListener */
    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    /* renamed from: android.support.v7.preference.Preference$OnPreferenceClickListener */
    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference preference);
    }

    public Preference(Context context) {
        this(context, (AttributeSet) null);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0268R.attr.preferenceStyle);
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2452f = Integer.MAX_VALUE;
        this.f2461o = true;
        this.f2462p = true;
        this.f2464r = true;
        this.f2467u = true;
        this.f2468v = true;
        this.f2469w = true;
        this.f2470x = true;
        this.f2471y = C0268R.layout.preference;
        this.f2446D = new View.OnClickListener() {
            public void onClick(View view) {
                Preference.this.mo4727a(view);
            }
        };
        this.f2447a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0268R.styleable.Preference, i, i2);
        this.f2455i = TypedArrayUtils.getResourceId(obtainStyledAttributes, C0268R.styleable.Preference_icon, C0268R.styleable.Preference_android_icon, 0);
        this.f2457k = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.Preference_key, C0268R.styleable.Preference_android_key);
        this.f2453g = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.Preference_title, C0268R.styleable.Preference_android_title);
        this.f2454h = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.Preference_summary, C0268R.styleable.Preference_android_summary);
        this.f2452f = TypedArrayUtils.getInt(obtainStyledAttributes, C0268R.styleable.Preference_order, C0268R.styleable.Preference_android_order, Integer.MAX_VALUE);
        this.f2459m = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.Preference_fragment, C0268R.styleable.Preference_android_fragment);
        this.f2471y = TypedArrayUtils.getResourceId(obtainStyledAttributes, C0268R.styleable.Preference_layout, C0268R.styleable.Preference_android_layout, C0268R.layout.preference);
        this.f2472z = TypedArrayUtils.getResourceId(obtainStyledAttributes, C0268R.styleable.Preference_widgetLayout, C0268R.styleable.Preference_android_widgetLayout, 0);
        this.f2461o = TypedArrayUtils.getBoolean(obtainStyledAttributes, C0268R.styleable.Preference_enabled, C0268R.styleable.Preference_android_enabled, true);
        this.f2462p = TypedArrayUtils.getBoolean(obtainStyledAttributes, C0268R.styleable.Preference_selectable, C0268R.styleable.Preference_android_selectable, true);
        this.f2464r = TypedArrayUtils.getBoolean(obtainStyledAttributes, C0268R.styleable.Preference_persistent, C0268R.styleable.Preference_android_persistent, true);
        this.f2465s = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.Preference_dependency, C0268R.styleable.Preference_android_dependency);
        if (obtainStyledAttributes.hasValue(C0268R.styleable.Preference_defaultValue)) {
            this.f2466t = mo4748a(obtainStyledAttributes, C0268R.styleable.Preference_defaultValue);
        } else if (obtainStyledAttributes.hasValue(C0268R.styleable.Preference_android_defaultValue)) {
            this.f2466t = mo4748a(obtainStyledAttributes, C0268R.styleable.Preference_android_defaultValue);
        }
        this.f2470x = TypedArrayUtils.getBoolean(obtainStyledAttributes, C0268R.styleable.Preference_shouldDisableView, C0268R.styleable.Preference_shouldDisableView, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m1563a(SharedPreferences.Editor editor) {
        if (this.f2448b.mo4911c()) {
            SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
        }
    }

    /* renamed from: a */
    private void mo4857a(Preference preference) {
        if (this.f2444B == null) {
            this.f2444B = new ArrayList();
        }
        this.f2444B.add(preference);
        preference.onDependencyChanged(this, shouldDisableDependents());
    }

    /* renamed from: a */
    private void m1565a(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m1565a(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    /* renamed from: b */
    private void m1566b(Preference preference) {
        if (this.f2444B != null) {
            this.f2444B.remove(preference);
        }
    }

    /* renamed from: j */
    private void mo4888j() {
        if (!TextUtils.isEmpty(this.f2465s)) {
            Preference a = mo4780a(this.f2465s);
            if (a != null) {
                a.mo4857a(this);
                return;
            }
            throw new IllegalStateException("Dependency \"" + this.f2465s + "\" not found for preference \"" + this.f2457k + "\" (title: \"" + this.f2453g + "\"");
        }
    }

    /* renamed from: k */
    private void mo4889k() {
        Preference a;
        if (this.f2465s != null && (a = mo4780a(this.f2465s)) != null) {
            a.m1566b(this);
        }
    }

    /* renamed from: l */
    private void m1569l() {
        if (mo4794e() && getSharedPreferences().contains(this.f2457k)) {
            mo4750a(true, (Object) null);
        } else if (this.f2466t != null) {
            mo4750a(false, this.f2466t);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Preference mo4780a(String str) {
        if (TextUtils.isEmpty(str) || this.f2448b == null) {
            return null;
        }
        return this.f2448b.findPreference(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4748a(TypedArray typedArray, int i) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4729a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4781a(Bundle bundle) {
        if (hasKey()) {
            this.f2445C = false;
            Parcelable b = mo4751b();
            if (!this.f2445C) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (b != null) {
                bundle.putParcelable(this.f2457k, b);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4749a(Parcelable parcelable) {
        this.f2445C = true;
        if (parcelable != BaseSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo4782a(OnPreferenceChangeInternalListener onPreferenceChangeInternalListener) {
        this.f2443A = onPreferenceChangeInternalListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4783a(PreferenceManager preferenceManager) {
        this.f2448b = preferenceManager;
        this.f2449c = preferenceManager.mo4909a();
        m1569l();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4727a(View view) {
        performClick();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4750a(boolean z, Object obj) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4784a(boolean z) {
        boolean z2 = false;
        if (!mo4794e()) {
            return false;
        }
        if (!z) {
            z2 = true;
        }
        if (z == mo4787b(z2)) {
            return true;
        }
        SharedPreferences.Editor b = this.f2448b.mo4910b();
        b.putBoolean(this.f2457k, z);
        m1563a(b);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Parcelable mo4751b() {
        this.f2445C = true;
        return BaseSavedState.EMPTY_STATE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4785b(Bundle bundle) {
        Parcelable parcelable;
        if (hasKey() && (parcelable = bundle.getParcelable(this.f2457k)) != null) {
            this.f2445C = false;
            mo4749a(parcelable);
            if (!this.f2445C) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo4786b(String str) {
        if (!mo4794e()) {
            return false;
        }
        if (str == mo4789c((String) null)) {
            return true;
        }
        SharedPreferences.Editor b = this.f2448b.mo4910b();
        b.putString(this.f2457k, str);
        m1563a(b);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo4787b(boolean z) {
        return !mo4794e() ? z : this.f2448b.getSharedPreferences().getBoolean(this.f2457k, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo4788c() {
        return this.f2449c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo4789c(String str) {
        return !mo4794e() ? str : this.f2448b.getSharedPreferences().getString(this.f2457k, str);
    }

    public boolean callChangeListener(Object obj) {
        return this.f2450d == null || this.f2450d.onPreferenceChange(this, obj);
    }

    public int compareTo(Preference preference) {
        if (this.f2452f != preference.f2452f) {
            return this.f2452f - preference.f2452f;
        }
        if (this.f2453g == preference.f2453g) {
            return 0;
        }
        if (this.f2453g == null) {
            return 1;
        }
        if (preference.f2453g == null) {
            return -1;
        }
        return this.f2453g.toString().compareToIgnoreCase(preference.f2453g.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4793d() {
        if (TextUtils.isEmpty(this.f2457k)) {
            throw new IllegalStateException("Preference does not have a key assigned.");
        }
        this.f2463q = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo4794e() {
        return this.f2448b != null && isPersistent() && hasKey();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo4795f() {
        if (this.f2443A != null) {
            this.f2443A.onPreferenceChange(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo4796g() {
        if (this.f2443A != null) {
            this.f2443A.onPreferenceHierarchyChange(this);
        }
    }

    public Context getContext() {
        return this.f2447a;
    }

    public String getDependency() {
        return this.f2465s;
    }

    public Bundle getExtras() {
        if (this.f2460n == null) {
            this.f2460n = new Bundle();
        }
        return this.f2460n;
    }

    public String getFragment() {
        return this.f2459m;
    }

    public Drawable getIcon() {
        return this.f2456j;
    }

    public Intent getIntent() {
        return this.f2458l;
    }

    public String getKey() {
        return this.f2457k;
    }

    public final int getLayoutResource() {
        return this.f2471y;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return this.f2450d;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return this.f2451e;
    }

    public int getOrder() {
        return this.f2452f;
    }

    public PreferenceManager getPreferenceManager() {
        return this.f2448b;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.f2448b == null) {
            return null;
        }
        return this.f2448b.getSharedPreferences();
    }

    public boolean getShouldDisableView() {
        return this.f2470x;
    }

    public CharSequence getSummary() {
        return this.f2454h;
    }

    public CharSequence getTitle() {
        return this.f2453g;
    }

    public final int getWidgetLayoutResource() {
        return this.f2472z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo4813h() {
        mo4889k();
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.f2457k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public StringBuilder mo4815i() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title).append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary).append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public boolean isEnabled() {
        return this.f2461o && this.f2467u && this.f2468v;
    }

    public boolean isPersistent() {
        return this.f2464r;
    }

    public boolean isSelectable() {
        return this.f2462p;
    }

    public final boolean isVisible() {
        return this.f2469w;
    }

    public void notifyDependencyChange(boolean z) {
        List<Preference> list = this.f2444B;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).onDependencyChanged(this, z);
            }
        }
    }

    public void onAttached() {
        mo4888j();
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        int i = 0;
        preferenceViewHolder.itemView.setOnClickListener(this.f2446D);
        TextView textView = (TextView) preferenceViewHolder.findViewById(16908310);
        if (textView != null) {
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                textView.setText(title);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) preferenceViewHolder.findViewById(16908304);
        if (textView2 != null) {
            CharSequence summary = getSummary();
            if (!TextUtils.isEmpty(summary)) {
                textView2.setText(summary);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) preferenceViewHolder.findViewById(16908294);
        if (imageView != null) {
            if (!(this.f2455i == 0 && this.f2456j == null)) {
                if (this.f2456j == null) {
                    this.f2456j = ContextCompat.getDrawable(getContext(), this.f2455i);
                }
                if (this.f2456j != null) {
                    imageView.setImageDrawable(this.f2456j);
                }
            }
            imageView.setVisibility(this.f2456j != null ? 0 : 8);
        }
        View findViewById = preferenceViewHolder.findViewById(C0268R.C0270id.icon_frame);
        if (findViewById != null) {
            if (this.f2456j == null) {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
        if (this.f2470x) {
            m1565a(preferenceViewHolder.itemView, isEnabled());
        } else {
            m1565a(preferenceViewHolder.itemView, true);
        }
    }

    public void onDependencyChanged(Preference preference, boolean z) {
        if (this.f2467u == z) {
            this.f2467u = !z;
            notifyDependencyChange(shouldDisableDependents());
            mo4795f();
        }
    }

    public void onParentChanged(Preference preference, boolean z) {
        if (this.f2468v == z) {
            this.f2468v = !z;
            notifyDependencyChange(shouldDisableDependents());
            mo4795f();
        }
    }

    public Bundle peekExtras() {
        return this.f2460n;
    }

    public void performClick() {
        PreferenceManager.OnPreferenceTreeClickListener onPreferenceTreeClickListener;
        if (isEnabled()) {
            mo4729a();
            if (this.f2451e == null || !this.f2451e.onPreferenceClick(this)) {
                PreferenceManager preferenceManager = getPreferenceManager();
                if ((preferenceManager == null || (onPreferenceTreeClickListener = preferenceManager.getOnPreferenceTreeClickListener()) == null || !onPreferenceTreeClickListener.onPreferenceTreeClick(this)) && this.f2458l != null) {
                    getContext().startActivity(this.f2458l);
                }
            }
        }
    }

    public void restoreHierarchyState(Bundle bundle) {
        mo4785b(bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        mo4781a(bundle);
    }

    public void setDefaultValue(Object obj) {
        this.f2466t = obj;
    }

    public void setDependency(String str) {
        mo4889k();
        this.f2465s = str;
        mo4888j();
    }

    public void setEnabled(boolean z) {
        if (this.f2461o != z) {
            this.f2461o = z;
            notifyDependencyChange(shouldDisableDependents());
            mo4795f();
        }
    }

    public void setFragment(String str) {
        this.f2459m = str;
    }

    public void setIcon(int i) {
        setIcon(ContextCompat.getDrawable(this.f2447a, i));
        this.f2455i = i;
    }

    public void setIcon(Drawable drawable) {
        if ((drawable == null && this.f2456j != null) || (drawable != null && this.f2456j != drawable)) {
            this.f2456j = drawable;
            this.f2455i = 0;
            mo4795f();
        }
    }

    public void setIntent(Intent intent) {
        this.f2458l = intent;
    }

    public void setKey(String str) {
        this.f2457k = str;
        if (this.f2463q && !hasKey()) {
            mo4793d();
        }
    }

    public void setLayoutResource(int i) {
        this.f2471y = i;
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        this.f2450d = onPreferenceChangeListener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        this.f2451e = onPreferenceClickListener;
    }

    public void setOrder(int i) {
        if (i != this.f2452f) {
            this.f2452f = i;
            mo4796g();
        }
    }

    public void setPersistent(boolean z) {
        this.f2464r = z;
    }

    public void setSelectable(boolean z) {
        if (this.f2462p != z) {
            this.f2462p = z;
            mo4795f();
        }
    }

    public void setShouldDisableView(boolean z) {
        this.f2470x = z;
        mo4795f();
    }

    public void setSummary(int i) {
        setSummary((CharSequence) this.f2447a.getString(i));
    }

    public void setSummary(CharSequence charSequence) {
        if ((charSequence == null && this.f2454h != null) || (charSequence != null && !charSequence.equals(this.f2454h))) {
            this.f2454h = charSequence;
            mo4795f();
        }
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.f2447a.getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.f2453g != null) || (charSequence != null && !charSequence.equals(this.f2453g))) {
            this.f2453g = charSequence;
            mo4795f();
        }
    }

    public final void setVisible(boolean z) {
        this.f2469w = z;
        if (this.f2443A != null) {
            this.f2443A.onPreferenceVisibilityChange(this);
        }
    }

    public void setWidgetLayoutResource(int i) {
        this.f2472z = i;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public String toString() {
        return mo4815i().toString();
    }
}
