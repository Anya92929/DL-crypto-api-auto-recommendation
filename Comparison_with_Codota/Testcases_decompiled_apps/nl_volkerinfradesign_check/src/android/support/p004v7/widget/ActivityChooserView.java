package android.support.p004v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.p001v4.view.ActionProvider;
import android.support.p001v4.view.ViewCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.widget.ActivityChooserModel;
import android.support.p004v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.ActivityChooserView */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* renamed from: a */
    ActionProvider f1961a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0543a f1962b;

    /* renamed from: c */
    private final C0544b f1963c;

    /* renamed from: d */
    private final LinearLayoutCompat f1964d;

    /* renamed from: e */
    private final Drawable f1965e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final FrameLayout f1966f;

    /* renamed from: g */
    private final ImageView f1967g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final FrameLayout f1968h;

    /* renamed from: i */
    private final ImageView f1969i;

    /* renamed from: j */
    private final int f1970j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final DataSetObserver f1971k;

    /* renamed from: l */
    private final ViewTreeObserver.OnGlobalLayoutListener f1972l;

    /* renamed from: m */
    private ListPopupWindow f1973m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public PopupWindow.OnDismissListener f1974n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f1975o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f1976p;

    /* renamed from: q */
    private boolean f1977q;

    /* renamed from: r */
    private int f1978r;

    public ActivityChooserView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1971k = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f1962b.notifyDataSetChanged();
            }

            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f1962b.notifyDataSetInvalidated();
            }
        };
        this.f1972l = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!ActivityChooserView.this.isShowingPopup()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                if (ActivityChooserView.this.f1961a != null) {
                    ActivityChooserView.this.f1961a.subUiVisibilityChanged(true);
                }
            }
        };
        this.f1976p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.ActivityChooserView, i, 0);
        this.f1976p = obtainStyledAttributes.getInt(C0505R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0505R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(C0505R.layout.abc_activity_chooser_view, this, true);
        this.f1963c = new C0544b();
        this.f1964d = (LinearLayoutCompat) findViewById(C0505R.C0507id.activity_chooser_view_content);
        this.f1965e = this.f1964d.getBackground();
        this.f1968h = (FrameLayout) findViewById(C0505R.C0507id.default_activity_button);
        this.f1968h.setOnClickListener(this.f1963c);
        this.f1968h.setOnLongClickListener(this.f1963c);
        this.f1969i = (ImageView) this.f1968h.findViewById(C0505R.C0507id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(C0505R.C0507id.expand_activities_button);
        frameLayout.setOnClickListener(this.f1963c);
        frameLayout.setOnTouchListener(new ListPopupWindow.ForwardingListener(frameLayout) {
            public ListPopupWindow getPopup() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* access modifiers changed from: protected */
            public boolean onForwardingStarted() {
                ActivityChooserView.this.showPopup();
                return true;
            }

            /* access modifiers changed from: protected */
            public boolean onForwardingStopped() {
                ActivityChooserView.this.dismissPopup();
                return true;
            }
        });
        this.f1966f = frameLayout;
        this.f1967g = (ImageView) frameLayout.findViewById(C0505R.C0507id.image);
        this.f1967g.setImageDrawable(drawable);
        this.f1962b = new C0543a();
        this.f1962b.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.m3142a();
            }
        });
        Resources resources = context.getResources();
        this.f1970j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0505R.dimen.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f1962b.mo4063a(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1967g.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1967g.setContentDescription(getContext().getString(i));
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1961a = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.f1977q) {
            return false;
        }
        this.f1975o = false;
        m3143a(this.f1976p);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3143a(int i) {
        int i2;
        if (this.f1962b.mo4069e() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1972l);
        boolean z = this.f1968h.getVisibility() == 0;
        int c = this.f1962b.mo4067c();
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.f1962b.mo4064a(false);
            this.f1962b.mo4062a(i);
        } else {
            this.f1962b.mo4064a(true);
            this.f1962b.mo4062a(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (this.f1975o || !z) {
                this.f1962b.mo4065a(true, z);
            } else {
                this.f1962b.mo4065a(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.f1962b.mo4061a(), this.f1970j));
            listPopupWindow.show();
            if (this.f1961a != null) {
                this.f1961a.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(C0505R.string.abc_activitychooserview_choose_application));
        }
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1972l);
        return true;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel e = this.f1962b.mo4069e();
        if (e != null) {
            e.registerObserver(this.f1971k);
        }
        this.f1977q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel e = this.f1962b.mo4069e();
        if (e != null) {
            e.unregisterObserver(this.f1971k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1972l);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.f1977q = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.f1964d;
        if (this.f1968h.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1964d.layout(0, 0, i3 - i, i4 - i2);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.f1962b.mo4069e();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1974n = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1976p = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1978r = i;
    }

    /* access modifiers changed from: private */
    public ListPopupWindow getListPopupWindow() {
        if (this.f1973m == null) {
            this.f1973m = new ListPopupWindow(getContext());
            this.f1973m.setAdapter(this.f1962b);
            this.f1973m.setAnchorView(this);
            this.f1973m.setModal(true);
            this.f1973m.setOnItemClickListener(this.f1963c);
            this.f1973m.setOnDismissListener(this.f1963c);
        }
        return this.f1973m;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3142a() {
        if (this.f1962b.getCount() > 0) {
            this.f1966f.setEnabled(true);
        } else {
            this.f1966f.setEnabled(false);
        }
        int c = this.f1962b.mo4067c();
        int d = this.f1962b.mo4068d();
        if (c == 1 || (c > 1 && d > 0)) {
            this.f1968h.setVisibility(0);
            ResolveInfo b = this.f1962b.mo4066b();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1969i.setImageDrawable(b.loadIcon(packageManager));
            if (this.f1978r != 0) {
                CharSequence loadLabel = b.loadLabel(packageManager);
                this.f1968h.setContentDescription(getContext().getString(this.f1978r, new Object[]{loadLabel}));
            }
        } else {
            this.f1968h.setVisibility(8);
        }
        if (this.f1968h.getVisibility() == 0) {
            this.f1964d.setBackgroundDrawable(this.f1965e);
        } else {
            this.f1964d.setBackgroundDrawable((Drawable) null);
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$b */
    class C0544b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        private C0544b() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0543a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.dismissPopup();
                    if (!ActivityChooserView.this.f1975o) {
                        if (!ActivityChooserView.this.f1962b.mo4070f()) {
                            i++;
                        }
                        Intent b = ActivityChooserView.this.f1962b.mo4069e().mo4026b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            ActivityChooserView.this.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        ActivityChooserView.this.f1962b.mo4069e().mo4029c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    ActivityChooserView.this.m3143a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == ActivityChooserView.this.f1968h) {
                ActivityChooserView.this.dismissPopup();
                Intent b = ActivityChooserView.this.f1962b.mo4069e().mo4026b(ActivityChooserView.this.f1962b.mo4069e().mo4022a(ActivityChooserView.this.f1962b.mo4066b()));
                if (b != null) {
                    b.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(b);
                }
            } else if (view == ActivityChooserView.this.f1966f) {
                boolean unused = ActivityChooserView.this.f1975o = false;
                ActivityChooserView.this.m3143a(ActivityChooserView.this.f1976p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.f1968h) {
                if (ActivityChooserView.this.f1962b.getCount() > 0) {
                    boolean unused = ActivityChooserView.this.f1975o = true;
                    ActivityChooserView.this.m3143a(ActivityChooserView.this.f1976p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            m3164a();
            if (ActivityChooserView.this.f1961a != null) {
                ActivityChooserView.this.f1961a.subUiVisibilityChanged(false);
            }
        }

        /* renamed from: a */
        private void m3164a() {
            if (ActivityChooserView.this.f1974n != null) {
                ActivityChooserView.this.f1974n.onDismiss();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$a */
    class C0543a extends BaseAdapter {

        /* renamed from: b */
        private ActivityChooserModel f1985b;

        /* renamed from: c */
        private int f1986c;

        /* renamed from: d */
        private boolean f1987d;

        /* renamed from: e */
        private boolean f1988e;

        /* renamed from: f */
        private boolean f1989f;

        private C0543a() {
            this.f1986c = 4;
        }

        /* renamed from: a */
        public void mo4063a(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel e = ActivityChooserView.this.f1962b.mo4069e();
            if (e != null && ActivityChooserView.this.isShown()) {
                e.unregisterObserver(ActivityChooserView.this.f1971k);
            }
            this.f1985b = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.f1971k);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            if (!this.f1989f || i != getCount() - 1) {
                return 0;
            }
            return 1;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getCount() {
            int a = this.f1985b.mo4021a();
            if (!this.f1987d && this.f1985b.mo4027b() != null) {
                a--;
            }
            int min = Math.min(a, this.f1986c);
            if (this.f1989f) {
                return min + 1;
            }
            return min;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f1987d && this.f1985b.mo4027b() != null) {
                        i++;
                    }
                    return this.f1985b.mo4023a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0505R.C0507id.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(C0505R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0505R.C0507id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0505R.C0507id.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (!this.f1987d || i != 0 || !this.f1988e) {
                        ViewCompat.setActivated(view, false);
                        return view;
                    }
                    ViewCompat.setActivated(view, true);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(C0505R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(C0505R.C0507id.title)).setText(ActivityChooserView.this.getContext().getString(C0505R.string.abc_activity_chooser_view_see_all));
                    return inflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* renamed from: a */
        public int mo4061a() {
            int i = this.f1986c;
            this.f1986c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f1986c = i;
            return i2;
        }

        /* renamed from: a */
        public void mo4062a(int i) {
            if (this.f1986c != i) {
                this.f1986c = i;
                notifyDataSetChanged();
            }
        }

        /* renamed from: b */
        public ResolveInfo mo4066b() {
            return this.f1985b.mo4027b();
        }

        /* renamed from: a */
        public void mo4064a(boolean z) {
            if (this.f1989f != z) {
                this.f1989f = z;
                notifyDataSetChanged();
            }
        }

        /* renamed from: c */
        public int mo4067c() {
            return this.f1985b.mo4021a();
        }

        /* renamed from: d */
        public int mo4068d() {
            return this.f1985b.mo4028c();
        }

        /* renamed from: e */
        public ActivityChooserModel mo4069e() {
            return this.f1985b;
        }

        /* renamed from: a */
        public void mo4065a(boolean z, boolean z2) {
            if (this.f1987d != z || this.f1988e != z2) {
                this.f1987d = z;
                this.f1988e = z2;
                notifyDataSetChanged();
            }
        }

        /* renamed from: f */
        public boolean mo4070f() {
            return this.f1987d;
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$InnerLayout */
    public static class InnerLayout extends LinearLayoutCompat {

        /* renamed from: a */
        private static final int[] f1983a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f1983a);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }
}
