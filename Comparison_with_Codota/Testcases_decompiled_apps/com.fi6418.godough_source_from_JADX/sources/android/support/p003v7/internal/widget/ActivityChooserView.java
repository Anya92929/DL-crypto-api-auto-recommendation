package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.ActionProvider;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.ActivityChooserModel;
import android.support.p003v7.widget.LinearLayoutCompat;
import android.support.p003v7.widget.ListPopupWindow;
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

/* renamed from: android.support.v7.internal.widget.ActivityChooserView */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* renamed from: a */
    ActionProvider f2277a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ActivityChooserViewAdapter f2278b;

    /* renamed from: c */
    private final Callbacks f2279c;

    /* renamed from: d */
    private final LinearLayoutCompat f2280d;

    /* renamed from: e */
    private final Drawable f2281e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final FrameLayout f2282f;

    /* renamed from: g */
    private final ImageView f2283g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final FrameLayout f2284h;

    /* renamed from: i */
    private final ImageView f2285i;

    /* renamed from: j */
    private final int f2286j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final DataSetObserver f2287k;

    /* renamed from: l */
    private final ViewTreeObserver.OnGlobalLayoutListener f2288l;

    /* renamed from: m */
    private ListPopupWindow f2289m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public PopupWindow.OnDismissListener f2290n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f2291o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f2292p;

    /* renamed from: q */
    private boolean f2293q;

    /* renamed from: r */
    private int f2294r;

    /* renamed from: android.support.v7.internal.widget.ActivityChooserView$ActivityChooserViewAdapter */
    class ActivityChooserViewAdapter extends BaseAdapter {
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;

        /* renamed from: b */
        private ActivityChooserModel f2300b;

        /* renamed from: c */
        private int f2301c;

        /* renamed from: d */
        private boolean f2302d;

        /* renamed from: e */
        private boolean f2303e;

        /* renamed from: f */
        private boolean f2304f;

        private ActivityChooserViewAdapter() {
            this.f2301c = 4;
        }

        public int getActivityCount() {
            return this.f2300b.getActivityCount();
        }

        public int getCount() {
            int activityCount = this.f2300b.getActivityCount();
            if (!this.f2302d && this.f2300b.getDefaultActivity() != null) {
                activityCount--;
            }
            int min = Math.min(activityCount, this.f2301c);
            return this.f2304f ? min + 1 : min;
        }

        public ActivityChooserModel getDataModel() {
            return this.f2300b;
        }

        public ResolveInfo getDefaultActivity() {
            return this.f2300b.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.f2300b.getHistorySize();
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f2302d && this.f2300b.getDefaultActivity() != null) {
                        i++;
                    }
                    return this.f2300b.getActivity(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (!this.f2304f || i != getCount() + -1) ? 0 : 1;
        }

        public boolean getShowDefaultActivity() {
            return this.f2302d;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0235R.C0237id.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(C0235R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0235R.C0237id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0235R.C0237id.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (!this.f2302d || i != 0 || !this.f2303e) {
                        ViewCompat.setActivated(view, false);
                        return view;
                    }
                    ViewCompat.setActivated(view, true);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(C0235R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(C0235R.C0237id.title)).setText(ActivityChooserView.this.getContext().getString(C0235R.string.abc_activity_chooser_view_see_all));
                    return inflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int measureContentWidth() {
            int i = this.f2301c;
            this.f2301c = Integer.MAX_VALUE;
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
            this.f2301c = i;
            return i2;
        }

        public void setDataModel(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel dataModel = ActivityChooserView.this.f2278b.getDataModel();
            if (dataModel != null && ActivityChooserView.this.isShown()) {
                dataModel.unregisterObserver(ActivityChooserView.this.f2287k);
            }
            this.f2300b = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.f2287k);
            }
            notifyDataSetChanged();
        }

        public void setMaxActivityCount(int i) {
            if (this.f2301c != i) {
                this.f2301c = i;
                notifyDataSetChanged();
            }
        }

        public void setShowDefaultActivity(boolean z, boolean z2) {
            if (this.f2302d != z || this.f2303e != z2) {
                this.f2302d = z;
                this.f2303e = z2;
                notifyDataSetChanged();
            }
        }

        public void setShowFooterView(boolean z) {
            if (this.f2304f != z) {
                this.f2304f = z;
                notifyDataSetChanged();
            }
        }
    }

    /* renamed from: android.support.v7.internal.widget.ActivityChooserView$Callbacks */
    class Callbacks implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        private Callbacks() {
        }

        /* renamed from: a */
        private void m1496a() {
            if (ActivityChooserView.this.f2290n != null) {
                ActivityChooserView.this.f2290n.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == ActivityChooserView.this.f2284h) {
                ActivityChooserView.this.dismissPopup();
                Intent chooseActivity = ActivityChooserView.this.f2278b.getDataModel().chooseActivity(ActivityChooserView.this.f2278b.getDataModel().getActivityIndex(ActivityChooserView.this.f2278b.getDefaultActivity()));
                if (chooseActivity != null) {
                    chooseActivity.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(chooseActivity);
                }
            } else if (view == ActivityChooserView.this.f2282f) {
                boolean unused = ActivityChooserView.this.f2291o = false;
                ActivityChooserView.this.m1485a(ActivityChooserView.this.f2292p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            m1496a();
            if (ActivityChooserView.this.f2277a != null) {
                ActivityChooserView.this.f2277a.subUiVisibilityChanged(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.dismissPopup();
                    if (!ActivityChooserView.this.f2291o) {
                        if (!ActivityChooserView.this.f2278b.getShowDefaultActivity()) {
                            i++;
                        }
                        Intent chooseActivity = ActivityChooserView.this.f2278b.getDataModel().chooseActivity(i);
                        if (chooseActivity != null) {
                            chooseActivity.addFlags(524288);
                            ActivityChooserView.this.getContext().startActivity(chooseActivity);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        ActivityChooserView.this.f2278b.getDataModel().setDefaultActivity(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    ActivityChooserView.this.m1485a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.f2284h) {
                if (ActivityChooserView.this.f2278b.getCount() > 0) {
                    boolean unused = ActivityChooserView.this.f2291o = true;
                    ActivityChooserView.this.m1485a(ActivityChooserView.this.f2292p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: android.support.v7.internal.widget.ActivityChooserView$InnerLayout */
    public class InnerLayout extends LinearLayoutCompat {

        /* renamed from: a */
        private static final int[] f2306a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f2306a);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2287k = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f2278b.notifyDataSetChanged();
            }

            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f2278b.notifyDataSetInvalidated();
            }
        };
        this.f2288l = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!ActivityChooserView.this.isShowingPopup()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                if (ActivityChooserView.this.f2277a != null) {
                    ActivityChooserView.this.f2277a.subUiVisibilityChanged(true);
                }
            }
        };
        this.f2292p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0235R.styleable.ActivityChooserView, i, 0);
        this.f2292p = obtainStyledAttributes.getInt(C0235R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0235R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(C0235R.layout.abc_activity_chooser_view, this, true);
        this.f2279c = new Callbacks();
        this.f2280d = (LinearLayoutCompat) findViewById(C0235R.C0237id.activity_chooser_view_content);
        this.f2281e = this.f2280d.getBackground();
        this.f2284h = (FrameLayout) findViewById(C0235R.C0237id.default_activity_button);
        this.f2284h.setOnClickListener(this.f2279c);
        this.f2284h.setOnLongClickListener(this.f2279c);
        this.f2285i = (ImageView) this.f2284h.findViewById(C0235R.C0237id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(C0235R.C0237id.expand_activities_button);
        frameLayout.setOnClickListener(this.f2279c);
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
        this.f2282f = frameLayout;
        this.f2283g = (ImageView) frameLayout.findViewById(C0235R.C0237id.image);
        this.f2283g.setImageDrawable(drawable);
        this.f2278b = new ActivityChooserViewAdapter();
        this.f2278b.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.m1484a();
            }
        });
        Resources resources = context.getResources();
        this.f2286j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0235R.dimen.abc_config_prefDialogWidth));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1484a() {
        if (this.f2278b.getCount() > 0) {
            this.f2282f.setEnabled(true);
        } else {
            this.f2282f.setEnabled(false);
        }
        int activityCount = this.f2278b.getActivityCount();
        int historySize = this.f2278b.getHistorySize();
        if (activityCount == 1 || (activityCount > 1 && historySize > 0)) {
            this.f2284h.setVisibility(0);
            ResolveInfo defaultActivity = this.f2278b.getDefaultActivity();
            PackageManager packageManager = getContext().getPackageManager();
            this.f2285i.setImageDrawable(defaultActivity.loadIcon(packageManager));
            if (this.f2294r != 0) {
                CharSequence loadLabel = defaultActivity.loadLabel(packageManager);
                this.f2284h.setContentDescription(getContext().getString(this.f2294r, new Object[]{loadLabel}));
            }
        } else {
            this.f2284h.setVisibility(8);
        }
        if (this.f2284h.getVisibility() == 0) {
            this.f2280d.setBackgroundDrawable(this.f2281e);
        } else {
            this.f2280d.setBackgroundDrawable((Drawable) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1485a(int i) {
        if (this.f2278b.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f2288l);
        boolean z = this.f2284h.getVisibility() == 0;
        int activityCount = this.f2278b.getActivityCount();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || activityCount <= i2 + i) {
            this.f2278b.setShowFooterView(false);
            this.f2278b.setMaxActivityCount(i);
        } else {
            this.f2278b.setShowFooterView(true);
            this.f2278b.setMaxActivityCount(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (this.f2291o || !z) {
                this.f2278b.setShowDefaultActivity(true, z);
            } else {
                this.f2278b.setShowDefaultActivity(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.f2278b.measureContentWidth(), this.f2286j));
            listPopupWindow.show();
            if (this.f2277a != null) {
                this.f2277a.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(C0235R.string.abc_activitychooserview_choose_application));
        }
    }

    /* access modifiers changed from: private */
    public ListPopupWindow getListPopupWindow() {
        if (this.f2289m == null) {
            this.f2289m = new ListPopupWindow(getContext());
            this.f2289m.setAdapter(this.f2278b);
            this.f2289m.setAnchorView(this);
            this.f2289m.setModal(true);
            this.f2289m.setOnItemClickListener(this.f2279c);
            this.f2289m.setOnDismissListener(this.f2279c);
        }
        return this.f2289m;
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
        viewTreeObserver.removeGlobalOnLayoutListener(this.f2288l);
        return true;
    }

    public ActivityChooserModel getDataModel() {
        return this.f2278b.getDataModel();
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = this.f2278b.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.f2287k);
        }
        this.f2293q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.f2278b.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.f2287k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2288l);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.f2293q = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2280d.layout(0, 0, i3 - i, i4 - i2);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.f2280d;
        if (this.f2284h.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f2278b.setDataModel(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f2294r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f2283g.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2283g.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f2292p = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f2290n = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f2277a = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.f2293q) {
            return false;
        }
        this.f2291o = false;
        m1485a(this.f2292p);
        return true;
    }
}
