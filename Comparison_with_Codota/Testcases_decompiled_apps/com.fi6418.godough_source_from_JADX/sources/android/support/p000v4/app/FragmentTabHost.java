package android.support.p000v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.FragmentTabHost */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    private final ArrayList<TabInfo> f501a = new ArrayList<>();

    /* renamed from: b */
    private FrameLayout f502b;

    /* renamed from: c */
    private Context f503c;

    /* renamed from: d */
    private FragmentManager f504d;

    /* renamed from: e */
    private int f505e;

    /* renamed from: f */
    private TabHost.OnTabChangeListener f506f;

    /* renamed from: g */
    private TabInfo f507g;

    /* renamed from: h */
    private boolean f508h;

    /* renamed from: android.support.v4.app.FragmentTabHost$DummyTabFactory */
    class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: a */
        private final Context f509a;

        public DummyTabFactory(Context context) {
            this.f509a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f509a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTabHost$SavedState */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        String f510a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f510a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f510a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f510a);
        }
    }

    /* renamed from: android.support.v4.app.FragmentTabHost$TabInfo */
    final class TabInfo {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f511a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Class<?> f512b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final Bundle f513c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Fragment f514d;

        TabInfo(String str, Class<?> cls, Bundle bundle) {
            this.f511a = str;
            this.f512b = cls;
            this.f513c = bundle;
        }
    }

    public FragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        m511a(context, (AttributeSet) null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m511a(context, attributeSet);
    }

    /* renamed from: a */
    private FragmentTransaction m508a(String str, FragmentTransaction fragmentTransaction) {
        TabInfo tabInfo = null;
        int i = 0;
        while (i < this.f501a.size()) {
            TabInfo tabInfo2 = this.f501a.get(i);
            if (!tabInfo2.f511a.equals(str)) {
                tabInfo2 = tabInfo;
            }
            i++;
            tabInfo = tabInfo2;
        }
        if (tabInfo == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f507g != tabInfo) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f504d.beginTransaction();
            }
            if (!(this.f507g == null || this.f507g.f514d == null)) {
                fragmentTransaction.detach(this.f507g.f514d);
            }
            if (tabInfo != null) {
                if (tabInfo.f514d == null) {
                    Fragment unused = tabInfo.f514d = Fragment.instantiate(this.f503c, tabInfo.f512b.getName(), tabInfo.f513c);
                    fragmentTransaction.add(this.f505e, tabInfo.f514d, tabInfo.f511a);
                } else {
                    fragmentTransaction.attach(tabInfo.f514d);
                }
            }
            this.f507g = tabInfo;
        }
        return fragmentTransaction;
    }

    /* renamed from: a */
    private void m509a() {
        if (this.f502b == null) {
            this.f502b = (FrameLayout) findViewById(this.f505e);
            if (this.f502b == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f505e);
            }
        }
    }

    /* renamed from: a */
    private void m510a(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, BitmapDescriptorFactory.HUE_RED));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, BitmapDescriptorFactory.HUE_RED));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f502b = frameLayout2;
            this.f502b.setId(this.f505e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    /* renamed from: a */
    private void m511a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f505e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new DummyTabFactory(this.f503c));
        String tag = tabSpec.getTag();
        TabInfo tabInfo = new TabInfo(tag, cls, bundle);
        if (this.f508h) {
            Fragment unused = tabInfo.f514d = this.f504d.findFragmentByTag(tag);
            if (tabInfo.f514d != null && !tabInfo.f514d.isDetached()) {
                FragmentTransaction beginTransaction = this.f504d.beginTransaction();
                beginTransaction.detach(tabInfo.f514d);
                beginTransaction.commit();
            }
        }
        this.f501a.add(tabInfo);
        addTab(tabSpec);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f501a.size()) {
                break;
            }
            TabInfo tabInfo = this.f501a.get(i2);
            Fragment unused = tabInfo.f514d = this.f504d.findFragmentByTag(tabInfo.f511a);
            if (tabInfo.f514d != null && !tabInfo.f514d.isDetached()) {
                if (tabInfo.f511a.equals(currentTabTag)) {
                    this.f507g = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f504d.beginTransaction();
                    }
                    fragmentTransaction.detach(tabInfo.f514d);
                }
            }
            i = i2 + 1;
        }
        this.f508h = true;
        FragmentTransaction a = m508a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.f504d.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f508h = false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f510a);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f510a = getCurrentTabTag();
        return savedState;
    }

    public void onTabChanged(String str) {
        FragmentTransaction a;
        if (this.f508h && (a = m508a(str, (FragmentTransaction) null)) != null) {
            a.commit();
        }
        if (this.f506f != null) {
            this.f506f.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f506f = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, FragmentManager fragmentManager) {
        m510a(context);
        super.setup();
        this.f503c = context;
        this.f504d = fragmentManager;
        m509a();
    }

    public void setup(Context context, FragmentManager fragmentManager, int i) {
        m510a(context);
        super.setup();
        this.f503c = context;
        this.f504d = fragmentManager;
        this.f505e = i;
        m509a();
        this.f502b.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }
}
