package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.preference.DialogPreference;
import android.support.p003v7.preference.PreferenceManager;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.preference.PreferenceFragmentCompat */
public abstract class PreferenceFragmentCompat extends Fragment implements DialogPreference.TargetFragment, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, PreferenceManager.OnPreferenceTreeClickListener {
    public static final String ARG_PREFERENCE_ROOT = "android.support.v7.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";

    /* renamed from: a */
    private PreferenceManager f2476a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RecyclerView f2477b;

    /* renamed from: c */
    private boolean f2478c;

    /* renamed from: d */
    private boolean f2479d;

    /* renamed from: e */
    private Context f2480e;

    /* renamed from: f */
    private int f2481f = C0268R.layout.preference_list_fragment;

    /* renamed from: g */
    private Handler f2482g = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PreferenceFragmentCompat.this.m1602p();
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: h */
    private final Runnable f2483h = new Runnable() {
        public void run() {
            PreferenceFragmentCompat.this.f2477b.focusableViewAvailable(PreferenceFragmentCompat.this.f2477b);
        }
    };

    /* renamed from: android.support.v7.preference.PreferenceFragmentCompat$OnPreferenceDisplayDialogCallback */
    public interface OnPreferenceDisplayDialogCallback {
        boolean onPreferenceDisplayDialog(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    /* renamed from: android.support.v7.preference.PreferenceFragmentCompat$OnPreferenceStartFragmentCallback */
    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    /* renamed from: android.support.v7.preference.PreferenceFragmentCompat$OnPreferenceStartScreenCallback */
    public interface OnPreferenceStartScreenCallback {
        boolean onPreferenceStartScreen(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen);
    }

    /* renamed from: n */
    private void m1600n() {
        if (this.f2476a == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    /* renamed from: o */
    private void m1601o() {
        if (!this.f2482g.hasMessages(1)) {
            this.f2482g.obtainMessage(1).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m1602p() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(mo4861a(preferenceScreen));
            preferenceScreen.onAttached();
        }
        mo4867l();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public RecyclerView.Adapter mo4861a(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    public void addPreferencesFromResource(int i) {
        m1600n();
        setPreferenceScreen(this.f2476a.inflateFromResource(this.f2480e, i, getPreferenceScreen()));
    }

    public Preference findPreference(CharSequence charSequence) {
        if (this.f2476a == null) {
            return null;
        }
        return this.f2476a.findPreference(charSequence);
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.f2477b;
    }

    public PreferenceManager getPreferenceManager() {
        return this.f2476a;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.f2476a.getPreferenceScreen();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo4867l() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo4868m() {
    }

    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onActivityCreated(bundle);
        if (this.f2478c) {
            m1602p();
        }
        this.f2479d = true;
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.restoreHierarchyState(bundle2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(C0268R.attr.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i <= 0) {
            throw new IllegalStateException("Must specify preferenceTheme in theme");
        }
        this.f2480e = new ContextThemeWrapper(getActivity(), i);
        this.f2476a = new PreferenceManager(this.f2480e);
        this.f2476a.setOnNavigateToScreenListener(this);
        onCreatePreferences(bundle, getArguments() != null ? getArguments().getString(ARG_PREFERENCE_ROOT) : null);
    }

    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) layoutInflater.inflate(C0268R.layout.preference_recyclerview, viewGroup, false);
        recyclerView.setLayoutManager(onCreateLayoutManager());
        return recyclerView;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = this.f2480e.obtainStyledAttributes((AttributeSet) null, C0268R.styleable.PreferenceFragmentCompat, C0268R.attr.preferenceFragmentStyle, 0);
        this.f2481f = obtainStyledAttributes.getResourceId(C0268R.styleable.PreferenceFragmentCompat_layout, this.f2481f);
        obtainStyledAttributes.recycle();
        View inflate = layoutInflater.inflate(this.f2481f, viewGroup, false);
        View findViewById = inflate.findViewById(C0268R.C0270id.list_container);
        if (!(findViewById instanceof ViewGroup)) {
            throw new RuntimeException("Content has view with id attribute 'R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        RecyclerView onCreateRecyclerView = onCreateRecyclerView(layoutInflater, viewGroup2, bundle);
        if (onCreateRecyclerView == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.f2477b = onCreateRecyclerView;
        viewGroup2.addView(this.f2477b);
        this.f2482g.post(this.f2483h);
        return inflate;
    }

    public void onDestroyView() {
        this.f2477b = null;
        this.f2482g.removeCallbacks(this.f2483h);
        this.f2482g.removeMessages(1);
        super.onDestroyView();
    }

    public void onDisplayPreferenceDialog(Preference preference) {
        DialogFragment newInstance;
        boolean onPreferenceDisplayDialog = getCallbackFragment() instanceof OnPreferenceDisplayDialogCallback ? ((OnPreferenceDisplayDialogCallback) getCallbackFragment()).onPreferenceDisplayDialog(this, preference) : false;
        if (!onPreferenceDisplayDialog && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            onPreferenceDisplayDialog = ((OnPreferenceDisplayDialogCallback) getActivity()).onPreferenceDisplayDialog(this, preference);
        }
        if (!onPreferenceDisplayDialog && getFragmentManager().findFragmentByTag("android.support.v7.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                newInstance = EditTextPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else if (preference instanceof ListPreference) {
                newInstance = ListPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            newInstance.setTargetFragment(this, 0);
            newInstance.show(getFragmentManager(), "android.support.v7.preference.PreferenceFragment.DIALOG");
        }
    }

    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        boolean z = false;
        if (getCallbackFragment() instanceof OnPreferenceStartScreenCallback) {
            z = ((OnPreferenceStartScreenCallback) getCallbackFragment()).onPreferenceStartScreen(this, preferenceScreen);
        }
        if (!z && (getActivity() instanceof OnPreferenceStartScreenCallback)) {
            ((OnPreferenceStartScreenCallback) getActivity()).onPreferenceStartScreen(this, preferenceScreen);
        }
    }

    public boolean onPreferenceTreeClick(Preference preference) {
        boolean z = false;
        if (preference.getFragment() == null) {
            return false;
        }
        if (getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) {
            z = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, preference);
        }
        return (z || !(getActivity() instanceof OnPreferenceStartFragmentCallback)) ? z : ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.saveHierarchyState(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        this.f2476a.setOnPreferenceTreeClickListener(this);
        this.f2476a.setOnDisplayPreferenceDialogListener(this);
    }

    public void onStop() {
        super.onStop();
        this.f2476a.setOnPreferenceTreeClickListener((PreferenceManager.OnPreferenceTreeClickListener) null);
        this.f2476a.setOnDisplayPreferenceDialogListener((PreferenceManager.OnDisplayPreferenceDialogListener) null);
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (this.f2476a.setPreferences(preferenceScreen) && preferenceScreen != null) {
            mo4868m();
            this.f2478c = true;
            if (this.f2479d) {
                m1601o();
            }
        }
    }

    public void setPreferencesFromResource(int i, String str) {
        m1600n();
        PreferenceScreen inflateFromResource = this.f2476a.inflateFromResource(this.f2480e, i, (PreferenceScreen) null);
        Preference preference = inflateFromResource;
        if (str != null) {
            Preference findPreference = inflateFromResource.findPreference(str);
            boolean z = findPreference instanceof PreferenceScreen;
            preference = findPreference;
            if (!z) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        setPreferenceScreen((PreferenceScreen) preference);
    }
}
