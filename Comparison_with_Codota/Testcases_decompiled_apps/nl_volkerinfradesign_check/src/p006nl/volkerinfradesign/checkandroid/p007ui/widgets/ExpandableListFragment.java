package p006nl.volkerinfradesign.checkandroid.p007ui.widgets;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
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

/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.ExpandableListFragment */
public class ExpandableListFragment extends Fragment implements View.OnCreateContextMenuListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a */
    ExpandableListAdapter f5615a;

    /* renamed from: b */
    View f5616b;

    /* renamed from: c */
    boolean f5617c = false;

    /* renamed from: d */
    ExpandableListView f5618d;

    /* renamed from: e */
    View f5619e;

    /* renamed from: f */
    boolean f5620f;

    /* renamed from: g */
    boolean f5621g;

    /* renamed from: h */
    TextView f5622h;

    /* renamed from: i */
    private final Handler f5623i = new Handler();

    /* renamed from: j */
    private final ExpandableListView.OnChildClickListener f5624j = new ExpandableListView.OnChildClickListener() {
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            return ExpandableListFragment.this.onChildClick(expandableListView, view, i, i2, j);
        }
    };

    /* renamed from: k */
    private final AdapterView.OnItemClickListener f5625k = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ExpandableListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    };

    /* renamed from: l */
    private final Runnable f5626l = new Runnable() {
        public void run() {
            ExpandableListFragment.this.f5618d.focusableViewAvailable(ExpandableListFragment.this.f5618d);
        }
    };

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.f5615a;
    }

    public ExpandableListView getExpandableListView() {
        m6447a();
        return this.f5618d;
    }

    public long getSelectedId() {
        m6447a();
        return this.f5618d.getSelectedId();
    }

    public long getSelectedPosition() {
        m6447a();
        return this.f5618d.getSelectedPosition();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m6447a();
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        return false;
    }

    public void onContentChanged() {
        View findViewById = getView().findViewById(16908292);
        this.f5618d = (ExpandableListView) getView().findViewById(16908298);
        if (this.f5618d == null) {
            throw new RuntimeException("Your content must have a ExpandableListView whose id attribute is 'android.R.id.list'");
        }
        if (findViewById != null) {
            this.f5618d.setEmptyView(findViewById);
        }
        this.f5618d.setOnChildClickListener(this);
        this.f5618d.setOnGroupExpandListener(this);
        this.f5618d.setOnGroupCollapseListener(this);
        if (this.f5617c) {
            setListAdapter(this.f5615a);
        }
        this.f5617c = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        TextView textView = new TextView(getActivity());
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ExpandableListView expandableListView = new ExpandableListView(getActivity());
        expandableListView.setId(16908298);
        expandableListView.setDrawSelectorOnTop(false);
        frameLayout.addView(expandableListView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.f5623i.removeCallbacks(this.f5626l);
        this.f5618d = null;
        super.onDestroyView();
    }

    public void onGroupCollapse(int i) {
    }

    public void onGroupExpand(int i) {
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
    }

    public void setEmptyText(CharSequence charSequence) {
        m6447a();
        if (this.f5622h == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        this.f5622h.setText(charSequence);
        if (!this.f5621g) {
            this.f5618d.setEmptyView(this.f5622h);
            this.f5621g = true;
        }
    }

    public void setListAdapter(ExpandableListAdapter expandableListAdapter) {
        boolean z = false;
        boolean z2 = this.f5615a != null;
        this.f5615a = expandableListAdapter;
        if (this.f5618d != null) {
            this.f5618d.setAdapter(expandableListAdapter);
            if (!this.f5620f && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                m6448a(true, z);
            }
        }
    }

    public void setListShown(boolean z) {
        m6448a(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        m6448a(z, false);
    }

    public void setSelection(int i) {
        m6447a();
        this.f5618d.setSelection(i);
    }

    /* renamed from: a */
    private void m6447a() {
        if (this.f5618d == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ExpandableListView) {
                this.f5618d = (ExpandableListView) view;
            } else {
                this.f5622h = (TextView) view.findViewById(16711681);
                if (this.f5622h == null) {
                    this.f5616b = view.findViewById(16908292);
                }
                this.f5619e = view.findViewById(16908298);
                View findViewById = view.findViewById(16908298);
                if (findViewById instanceof ExpandableListView) {
                    this.f5618d = (ExpandableListView) findViewById;
                    if (this.f5616b != null) {
                        this.f5618d.setEmptyView(this.f5616b);
                    }
                } else if (findViewById == null) {
                    throw new RuntimeException("Your content must have a ExpandableListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ExpandableListView class");
                }
            }
            this.f5620f = true;
            this.f5618d.setOnItemClickListener(this.f5625k);
            this.f5618d.setOnChildClickListener(this.f5624j);
            if (this.f5615a != null) {
                setListAdapter(this.f5615a);
            } else {
                m6448a(false, false);
            }
            this.f5623i.post(this.f5626l);
        }
    }

    /* renamed from: a */
    private void m6448a(boolean z, boolean z2) {
        m6447a();
        if (this.f5620f != z) {
            this.f5620f = z;
            if (z) {
                if (z2) {
                    this.f5619e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                }
                this.f5619e.setVisibility(0);
                return;
            }
            if (z2) {
                this.f5619e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
            }
            this.f5619e.setVisibility(8);
        }
    }
}
