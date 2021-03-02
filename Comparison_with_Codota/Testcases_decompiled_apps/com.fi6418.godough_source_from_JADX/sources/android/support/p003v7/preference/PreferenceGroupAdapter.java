package android.support.p003v7.preference;

import android.os.Handler;
import android.support.p003v7.preference.Preference;
import android.support.p003v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v7.preference.PreferenceGroupAdapter */
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener {

    /* renamed from: a */
    private PreferenceGroup f2490a;

    /* renamed from: b */
    private List<Preference> f2491b;

    /* renamed from: c */
    private List<Preference> f2492c;

    /* renamed from: d */
    private List<PreferenceLayout> f2493d;

    /* renamed from: e */
    private PreferenceLayout f2494e = new PreferenceLayout();

    /* renamed from: f */
    private volatile boolean f2495f = false;

    /* renamed from: g */
    private Handler f2496g = new Handler();

    /* renamed from: h */
    private Runnable f2497h = new Runnable() {
        public void run() {
            PreferenceGroupAdapter.this.m1614a();
        }
    };

    /* renamed from: android.support.v7.preference.PreferenceGroupAdapter$PreferenceLayout */
    class PreferenceLayout {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f2499a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f2500b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f2501c;

        private PreferenceLayout() {
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceLayout)) {
                return false;
            }
            PreferenceLayout preferenceLayout = (PreferenceLayout) obj;
            return this.f2499a == preferenceLayout.f2499a && this.f2500b == preferenceLayout.f2500b && TextUtils.equals(this.f2501c, preferenceLayout.f2501c);
        }

        public int hashCode() {
            return ((((this.f2499a + 527) * 31) + this.f2500b) * 31) + this.f2501c.hashCode();
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.f2490a = preferenceGroup;
        this.f2490a.mo4782a((Preference.OnPreferenceChangeInternalListener) this);
        this.f2491b = new ArrayList();
        this.f2492c = new ArrayList();
        this.f2493d = new ArrayList();
        setHasStableIds(true);
        m1614a();
    }

    /* renamed from: a */
    private PreferenceLayout m1613a(Preference preference, PreferenceLayout preferenceLayout) {
        if (preferenceLayout == null) {
            preferenceLayout = new PreferenceLayout();
        }
        String unused = preferenceLayout.f2501c = preference.getClass().getName();
        int unused2 = preferenceLayout.f2499a = preference.getLayoutResource();
        int unused3 = preferenceLayout.f2500b = preference.getWidgetLayoutResource();
        return preferenceLayout;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r0 = r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r0.isVisible() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r3.f2491b.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        notifyDataSetChanged();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.f2495f = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        r0 = new java.util.ArrayList(r3.f2492c.size());
        m1617a((java.util.List<android.support.p003v7.preference.Preference>) r0, r3.f2490a);
        r3.f2492c = r0;
        r3.f2491b = new java.util.ArrayList(r3.f2492c.size());
        r1 = r3.f2492c.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (r1.hasNext() == false) goto L_0x004b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1614a() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f2495f     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
        L_0x0006:
            return
        L_0x0007:
            r0 = 1
            r3.f2495f = r0     // Catch:{ all -> 0x0048 }
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<android.support.v7.preference.Preference> r1 = r3.f2492c
            int r1 = r1.size()
            r0.<init>(r1)
            android.support.v7.preference.PreferenceGroup r1 = r3.f2490a
            r3.m1617a((java.util.List<android.support.p003v7.preference.Preference>) r0, (android.support.p003v7.preference.PreferenceGroup) r1)
            r3.f2492c = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<android.support.v7.preference.Preference> r1 = r3.f2492c
            int r1 = r1.size()
            r0.<init>(r1)
            r3.f2491b = r0
            java.util.List<android.support.v7.preference.Preference> r0 = r3.f2492c
            java.util.Iterator r1 = r0.iterator()
        L_0x0030:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x004b
            java.lang.Object r0 = r1.next()
            android.support.v7.preference.Preference r0 = (android.support.p003v7.preference.Preference) r0
            boolean r2 = r0.isVisible()
            if (r2 == 0) goto L_0x0030
            java.util.List<android.support.v7.preference.Preference> r2 = r3.f2491b
            r2.add(r0)
            goto L_0x0030
        L_0x0048:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            throw r0
        L_0x004b:
            r3.notifyDataSetChanged()
            monitor-enter(r3)
            r0 = 0
            r3.f2495f = r0     // Catch:{ all -> 0x0057 }
            r3.notifyAll()     // Catch:{ all -> 0x0057 }
            monitor-exit(r3)     // Catch:{ all -> 0x0057 }
            goto L_0x0006
        L_0x0057:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0057 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.preference.PreferenceGroupAdapter.m1614a():void");
    }

    /* renamed from: a */
    private void m1615a(Preference preference) {
        PreferenceLayout a = m1613a(preference, (PreferenceLayout) null);
        if (!this.f2493d.contains(a)) {
            this.f2493d.add(a);
        }
    }

    /* renamed from: a */
    private void m1617a(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.mo4889k();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = preferenceGroup.getPreference(i);
            list.add(preference);
            m1615a(preference);
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.mo4888j()) {
                    m1617a(list, preferenceGroup2);
                }
            }
            preference.mo4782a((Preference.OnPreferenceChangeInternalListener) this);
        }
    }

    public Preference getItem(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return this.f2491b.get(i);
    }

    public int getItemCount() {
        return this.f2491b.size();
    }

    public long getItemId(int i) {
        if (i < 0 || i >= getItemCount()) {
            return Long.MIN_VALUE;
        }
        return getItem(i).mo4788c();
    }

    public int getItemViewType(int i) {
        this.f2494e = m1613a(getItem(i), this.f2494e);
        return this.f2493d.indexOf(this.f2494e);
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder, int i) {
        getItem(i).onBindViewHolder(preferenceViewHolder);
    }

    public PreferenceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PreferenceLayout preferenceLayout = this.f2493d.get(i);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        View inflate = from.inflate(preferenceLayout.f2499a, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (preferenceLayout.f2500b != 0) {
                from.inflate(preferenceLayout.f2500b, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    public void onPreferenceChange(Preference preference) {
        notifyDataSetChanged();
    }

    public void onPreferenceHierarchyChange(Preference preference) {
        this.f2496g.removeCallbacks(this.f2497h);
        this.f2496g.post(this.f2497h);
    }

    public void onPreferenceVisibilityChange(Preference preference) {
        int i;
        if (preference.isVisible()) {
            int i2 = -1;
            Iterator<Preference> it = this.f2492c.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Preference next = it.next();
                if (preference.equals(next)) {
                    break;
                }
                i2 = next.isVisible() ? i + 1 : i;
            }
            this.f2491b.add(i + 1, preference);
            notifyItemInserted(i + 1);
            return;
        }
        int size = this.f2491b.size();
        int i3 = 0;
        while (i3 < size && !preference.equals(this.f2491b.get(i3))) {
            i3++;
        }
        this.f2491b.remove(i3);
        notifyItemRemoved(i3);
    }
}
