package p006nl.volkerinfradesign.checkandroid.p007ui.widgets;

import android.os.Bundle;
import android.os.Handler;
import android.support.p001v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.SupportExpandableListFragment */
public class SupportExpandableListFragment extends Fragment implements View.OnCreateContextMenuListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a */
    private final Handler f5639a = new Handler();

    /* renamed from: aj */
    private final ExpandableListView.OnChildClickListener f5640aj = new ExpandableListView.OnChildClickListener() {
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            return SupportExpandableListFragment.this.onChildClick(expandableListView, view, i, i2, j);
        }
    };

    /* renamed from: ak */
    private final AdapterView.OnItemClickListener f5641ak = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SupportExpandableListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    };

    /* renamed from: al */
    private final Runnable f5642al = new Runnable() {
        public void run() {
            SupportExpandableListFragment.this.f5646e.focusableViewAvailable(SupportExpandableListFragment.this.f5646e);
        }
    };

    /* renamed from: b */
    ExpandableListAdapter f5643b;

    /* renamed from: c */
    View f5644c;

    /* renamed from: d */
    boolean f5645d = false;

    /* renamed from: e */
    ExpandableListView f5646e;

    /* renamed from: f */
    View f5647f;

    /* renamed from: g */
    boolean f5648g;

    /* renamed from: h */
    boolean f5649h;

    /* renamed from: i */
    TextView f5650i;

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.f5643b;
    }

    public ExpandableListView getExpandableListView() {
        m6455l();
        return this.f5646e;
    }

    public long getSelectedId() {
        m6455l();
        return this.f5646e.getSelectedId();
    }

    public long getSelectedPosition() {
        m6455l();
        return this.f5646e.getSelectedPosition();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m6455l();
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        return false;
    }

    public void onContentChanged() {
        View findViewById = getView().findViewById(16908292);
        this.f5646e = (ExpandableListView) getView().findViewById(16908298);
        if (this.f5646e == null) {
            throw new RuntimeException("Your content must have a ExpandableListView whose id attribute is 'android.R.id.list'");
        }
        if (findViewById != null) {
            this.f5646e.setEmptyView(findViewById);
        }
        this.f5646e.setOnChildClickListener(this);
        this.f5646e.setOnGroupExpandListener(this);
        this.f5646e.setOnGroupCollapseListener(this);
        if (this.f5645d) {
            setListAdapter(this.f5643b);
        }
        this.f5645d = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        TextView textView = new TextView(getActivity());
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        SupportExpandableListView supportExpandableListView = new SupportExpandableListView(getActivity());
        supportExpandableListView.setId(16908298);
        supportExpandableListView.setDrawSelectorOnTop(false);
        frameLayout.addView(supportExpandableListView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.f5639a.removeCallbacks(this.f5642al);
        this.f5646e = null;
        super.onDestroyView();
    }

    public void onGroupCollapse(int i) {
    }

    public void onGroupExpand(int i) {
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
    }

    public void setEmptyText(CharSequence charSequence) {
        m6455l();
        if (this.f5650i == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        this.f5650i.setText(charSequence);
        if (!this.f5649h) {
            this.f5646e.setEmptyView(this.f5650i);
            this.f5649h = true;
        }
    }

    public void setListAdapter(ExpandableListAdapter expandableListAdapter) {
        boolean z = false;
        boolean z2 = this.f5643b != null;
        this.f5643b = expandableListAdapter;
        if (this.f5646e != null) {
            this.f5646e.setAdapter(expandableListAdapter);
            if (!this.f5648g && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                m6454a(true, z);
            }
        }
    }

    public void setListShown(boolean z) {
        m6454a(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        m6454a(z, false);
    }

    public void setSelection(int i) {
        m6455l();
        this.f5646e.setSelection(i);
    }

    /* renamed from: l */
    private void m6455l() {
        if (this.f5646e == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ExpandableListView) {
                this.f5646e = (ExpandableListView) view;
            } else {
                this.f5650i = (TextView) view.findViewById(16711681);
                if (this.f5650i == null) {
                    this.f5644c = view.findViewById(16908292);
                }
                this.f5647f = view.findViewById(16908298);
                View findViewById = view.findViewById(16908298);
                if (findViewById instanceof ExpandableListView) {
                    this.f5646e = (ExpandableListView) findViewById;
                    if (this.f5644c != null) {
                        this.f5646e.setEmptyView(this.f5644c);
                    }
                } else if (findViewById == null) {
                    throw new RuntimeException("Your content must have a ExpandableListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ExpandableListView class");
                }
            }
            this.f5648g = true;
            this.f5646e.setOnItemClickListener(this.f5641ak);
            this.f5646e.setOnChildClickListener(this.f5640aj);
            if (this.f5643b != null) {
                setListAdapter(this.f5643b);
            } else {
                m6454a(false, false);
            }
            this.f5639a.post(this.f5642al);
        }
    }

    /* renamed from: a */
    private void m6454a(boolean z, boolean z2) {
        m6455l();
        if (this.f5648g != z) {
            this.f5648g = z;
            if (z) {
                if (z2) {
                    this.f5647f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                }
                this.f5647f.setVisibility(0);
                return;
            }
            if (z2) {
                this.f5647f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
            }
            this.f5647f.setVisibility(8);
        }
    }
}
