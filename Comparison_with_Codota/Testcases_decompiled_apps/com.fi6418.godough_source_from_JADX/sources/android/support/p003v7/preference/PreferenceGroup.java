package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v7.preference.PreferenceGroup */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: a */
    private List<Preference> f2486a;

    /* renamed from: b */
    private boolean f2487b;

    /* renamed from: c */
    private int f2488c;

    /* renamed from: d */
    private boolean f2489d;

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f2487b = true;
        this.f2488c = 0;
        this.f2489d = false;
        this.f2486a = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0268R.styleable.PreferenceGroup, i, i2);
        this.f2487b = TypedArrayUtils.getBoolean(obtainStyledAttributes, C0268R.styleable.PreferenceGroup_orderingFromXml, C0268R.styleable.PreferenceGroup_orderingFromXml, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private boolean m1606b(Preference preference) {
        boolean remove;
        synchronized (this) {
            preference.mo4813h();
            remove = this.f2486a.remove(preference);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4781a(Bundle bundle) {
        super.mo4781a(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).mo4781a(bundle);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4857a(Preference preference) {
        preference.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public boolean addPreference(Preference preference) {
        if (this.f2486a.contains(preference)) {
            return true;
        }
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.f2487b) {
                int i = this.f2488c;
                this.f2488c = i + 1;
                preference.setOrder(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).setOrderingAsAdded(this.f2487b);
            }
        }
        int binarySearch = Collections.binarySearch(this.f2486a, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * -1) - 1;
        }
        if (!mo4857a(preference)) {
            return false;
        }
        synchronized (this) {
            this.f2486a.add(binarySearch, preference);
        }
        preference.mo4783a(getPreferenceManager());
        if (this.f2489d) {
            preference.onAttached();
        }
        mo4796g();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4785b(Bundle bundle) {
        super.mo4785b(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).mo4785b(bundle);
        }
    }

    public Preference findPreference(CharSequence charSequence) {
        Preference findPreference;
        if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        }
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = getPreference(i);
            String key = preference.getKey();
            if (key != null && key.equals(charSequence)) {
                return preference;
            }
            if ((preference instanceof PreferenceGroup) && (findPreference = ((PreferenceGroup) preference).findPreference(charSequence)) != null) {
                return findPreference;
            }
        }
        return null;
    }

    public Preference getPreference(int i) {
        return this.f2486a.get(i);
    }

    public int getPreferenceCount() {
        return this.f2486a.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo4813h() {
        super.mo4813h();
        this.f2489d = false;
    }

    public boolean isOrderingAsAdded() {
        return this.f2487b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public boolean mo4888j() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo4889k() {
        synchronized (this) {
            Collections.sort(this.f2486a);
        }
    }

    public void notifyDependencyChange(boolean z) {
        super.notifyDependencyChange(z);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onParentChanged(this, z);
        }
    }

    public void onAttached() {
        super.onAttached();
        this.f2489d = true;
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onAttached();
        }
    }

    public void removeAll() {
        synchronized (this) {
            List<Preference> list = this.f2486a;
            for (int size = list.size() - 1; size >= 0; size--) {
                m1606b(list.get(0));
            }
        }
        mo4796g();
    }

    public boolean removePreference(Preference preference) {
        boolean b = m1606b(preference);
        mo4796g();
        return b;
    }

    public void setOrderingAsAdded(boolean z) {
        this.f2487b = z;
    }
}
