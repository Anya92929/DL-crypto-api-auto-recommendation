package android.support.p000v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* renamed from: android.support.v4.app.ListFragment */
public class ListFragment extends Fragment {

    /* renamed from: a */
    ListAdapter f537a;

    /* renamed from: aj */
    private final Runnable f538aj = new Runnable() {
        public void run() {
            ListFragment.this.f540b.focusableViewAvailable(ListFragment.this.f540b);
        }
    };

    /* renamed from: ak */
    private final AdapterView.OnItemClickListener f539ak = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    };

    /* renamed from: b */
    ListView f540b;

    /* renamed from: c */
    View f541c;

    /* renamed from: d */
    TextView f542d;

    /* renamed from: e */
    View f543e;

    /* renamed from: f */
    View f544f;

    /* renamed from: g */
    CharSequence f545g;

    /* renamed from: h */
    boolean f546h;

    /* renamed from: i */
    private final Handler f547i = new Handler();

    /* renamed from: a */
    private void m526a(boolean z, boolean z2) {
        mo11010l();
        if (this.f543e == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f546h != z) {
            this.f546h = z;
            if (z) {
                if (z2) {
                    this.f543e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
                    this.f544f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                } else {
                    this.f543e.clearAnimation();
                    this.f544f.clearAnimation();
                }
                this.f543e.setVisibility(8);
                this.f544f.setVisibility(0);
                return;
            }
            if (z2) {
                this.f543e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                this.f544f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
            } else {
                this.f543e.clearAnimation();
                this.f544f.clearAnimation();
            }
            this.f543e.setVisibility(0);
            this.f544f.setVisibility(8);
        }
    }

    /* renamed from: l */
    private void mo11010l() {
        if (this.f540b == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.f540b = (ListView) view;
            } else {
                this.f542d = (TextView) view.findViewById(16711681);
                if (this.f542d == null) {
                    this.f541c = view.findViewById(16908292);
                } else {
                    this.f542d.setVisibility(8);
                }
                this.f543e = view.findViewById(16711682);
                this.f544f = view.findViewById(16711683);
                View findViewById = view.findViewById(16908298);
                if (findViewById instanceof ListView) {
                    this.f540b = (ListView) findViewById;
                    if (this.f541c != null) {
                        this.f540b.setEmptyView(this.f541c);
                    } else if (this.f545g != null) {
                        this.f542d.setText(this.f545g);
                        this.f540b.setEmptyView(this.f542d);
                    }
                } else if (findViewById == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.f546h = true;
            this.f540b.setOnItemClickListener(this.f539ak);
            if (this.f537a != null) {
                ListAdapter listAdapter = this.f537a;
                this.f537a = null;
                setListAdapter(listAdapter);
            } else if (this.f543e != null) {
                m526a(false, false);
            }
            this.f547i.post(this.f538aj);
        }
    }

    public ListAdapter getListAdapter() {
        return this.f537a;
    }

    public ListView getListView() {
        mo11010l();
        return this.f540b;
    }

    public long getSelectedItemId() {
        mo11010l();
        return this.f540b.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        mo11010l();
        return this.f540b.getSelectedItemPosition();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        FrameLayout frameLayout = new FrameLayout(activity);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(activity, (AttributeSet) null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(getActivity());
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(getActivity());
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.f547i.removeCallbacks(this.f538aj);
        this.f540b = null;
        this.f546h = false;
        this.f544f = null;
        this.f543e = null;
        this.f541c = null;
        this.f542d = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        mo11010l();
    }

    public void setEmptyText(CharSequence charSequence) {
        mo11010l();
        if (this.f542d == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        this.f542d.setText(charSequence);
        if (this.f545g == null) {
            this.f540b.setEmptyView(this.f542d);
        }
        this.f545g = charSequence;
    }

    public void setListAdapter(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f537a != null;
        this.f537a = listAdapter;
        if (this.f540b != null) {
            this.f540b.setAdapter(listAdapter);
            if (!this.f546h && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                m526a(true, z);
            }
        }
    }

    public void setListShown(boolean z) {
        m526a(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        m526a(z, false);
    }

    public void setSelection(int i) {
        mo11010l();
        this.f540b.setSelection(i);
    }
}
