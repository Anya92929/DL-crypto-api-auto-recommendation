package android.support.p001v4.app;

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
    ListAdapter f261a;

    /* renamed from: aj */
    private final Runnable f262aj = new Runnable() {
        public void run() {
            ListFragment.this.f264b.focusableViewAvailable(ListFragment.this.f264b);
        }
    };

    /* renamed from: ak */
    private final AdapterView.OnItemClickListener f263ak = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    };

    /* renamed from: b */
    ListView f264b;

    /* renamed from: c */
    View f265c;

    /* renamed from: d */
    TextView f266d;

    /* renamed from: e */
    View f267e;

    /* renamed from: f */
    View f268f;

    /* renamed from: g */
    CharSequence f269g;

    /* renamed from: h */
    boolean f270h;

    /* renamed from: i */
    private final Handler f271i = new Handler();

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

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m242l();
    }

    public void onDestroyView() {
        this.f271i.removeCallbacks(this.f262aj);
        this.f264b = null;
        this.f270h = false;
        this.f268f = null;
        this.f267e = null;
        this.f265c = null;
        this.f266d = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
    }

    public void setListAdapter(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f261a != null;
        this.f261a = listAdapter;
        if (this.f264b != null) {
            this.f264b.setAdapter(listAdapter);
            if (!this.f270h && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                m241a(true, z);
            }
        }
    }

    public void setSelection(int i) {
        m242l();
        this.f264b.setSelection(i);
    }

    public int getSelectedItemPosition() {
        m242l();
        return this.f264b.getSelectedItemPosition();
    }

    public long getSelectedItemId() {
        m242l();
        return this.f264b.getSelectedItemId();
    }

    public ListView getListView() {
        m242l();
        return this.f264b;
    }

    public void setEmptyText(CharSequence charSequence) {
        m242l();
        if (this.f266d == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        this.f266d.setText(charSequence);
        if (this.f269g == null) {
            this.f264b.setEmptyView(this.f266d);
        }
        this.f269g = charSequence;
    }

    public void setListShown(boolean z) {
        m241a(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        m241a(z, false);
    }

    /* renamed from: a */
    private void m241a(boolean z, boolean z2) {
        m242l();
        if (this.f267e == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f270h != z) {
            this.f270h = z;
            if (z) {
                if (z2) {
                    this.f267e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
                    this.f268f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                } else {
                    this.f267e.clearAnimation();
                    this.f268f.clearAnimation();
                }
                this.f267e.setVisibility(8);
                this.f268f.setVisibility(0);
                return;
            }
            if (z2) {
                this.f267e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                this.f268f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
            } else {
                this.f267e.clearAnimation();
                this.f268f.clearAnimation();
            }
            this.f267e.setVisibility(0);
            this.f268f.setVisibility(8);
        }
    }

    public ListAdapter getListAdapter() {
        return this.f261a;
    }

    /* renamed from: l */
    private void m242l() {
        if (this.f264b == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.f264b = (ListView) view;
            } else {
                this.f266d = (TextView) view.findViewById(16711681);
                if (this.f266d == null) {
                    this.f265c = view.findViewById(16908292);
                } else {
                    this.f266d.setVisibility(8);
                }
                this.f267e = view.findViewById(16711682);
                this.f268f = view.findViewById(16711683);
                View findViewById = view.findViewById(16908298);
                if (findViewById instanceof ListView) {
                    this.f264b = (ListView) findViewById;
                    if (this.f265c != null) {
                        this.f264b.setEmptyView(this.f265c);
                    } else if (this.f269g != null) {
                        this.f266d.setText(this.f269g);
                        this.f264b.setEmptyView(this.f266d);
                    }
                } else if (findViewById == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.f270h = true;
            this.f264b.setOnItemClickListener(this.f263ak);
            if (this.f261a != null) {
                ListAdapter listAdapter = this.f261a;
                this.f261a = null;
                setListAdapter(listAdapter);
            } else if (this.f267e != null) {
                m241a(false, false);
            }
            this.f271i.post(this.f262aj);
        }
    }
}
