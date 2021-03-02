package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    private final ArrayList<C0024b> f13a = new ArrayList<>();

    /* renamed from: b */
    private FrameLayout f14b;

    /* renamed from: c */
    private Context f15c;

    /* renamed from: d */
    private FragmentManager f16d;

    /* renamed from: e */
    private int f17e;

    /* renamed from: f */
    private TabHost.OnTabChangeListener f18f;

    /* renamed from: g */
    private C0024b f19g;

    /* renamed from: h */
    private boolean f20h;

    /* renamed from: android.support.v13.app.FragmentTabHost$b */
    static final class C0024b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f23a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Class<?> f24b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final Bundle f25c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Fragment f26d;

        C0024b(String str, Class<?> cls, Bundle bundle) {
            this.f23a = str;
            this.f24b = cls;
            this.f25c = bundle;
        }
    }

    /* renamed from: android.support.v13.app.FragmentTabHost$a */
    static class C0023a implements TabHost.TabContentFactory {

        /* renamed from: a */
        private final Context f22a;

        public C0023a(Context context) {
            this.f22a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f22a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        String f21a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f21a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f21a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f21a + "}";
        }
    }

    public FragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        m48a(context, (AttributeSet) null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m48a(context, attributeSet);
    }

    /* renamed from: a */
    private void m48a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f17e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    /* renamed from: a */
    private void m47a(Context context) {
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
            this.f14b = frameLayout2;
            this.f14b.setId(this.f17e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, FragmentManager fragmentManager) {
        m47a(context);
        super.setup();
        this.f15c = context;
        this.f16d = fragmentManager;
        m46a();
    }

    public void setup(Context context, FragmentManager fragmentManager, int i) {
        m47a(context);
        super.setup();
        this.f15c = context;
        this.f16d = fragmentManager;
        this.f17e = i;
        m46a();
        this.f14b.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    /* renamed from: a */
    private void m46a() {
        if (this.f14b == null) {
            this.f14b = (FrameLayout) findViewById(this.f17e);
            if (this.f14b == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f17e);
            }
        }
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f18f = onTabChangeListener;
    }

    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new C0023a(this.f15c));
        String tag = tabSpec.getTag();
        C0024b bVar = new C0024b(tag, cls, bundle);
        if (this.f20h) {
            Fragment unused = bVar.f26d = this.f16d.findFragmentByTag(tag);
            if (bVar.f26d != null && !bVar.f26d.isDetached()) {
                FragmentTransaction beginTransaction = this.f16d.beginTransaction();
                beginTransaction.detach(bVar.f26d);
                beginTransaction.commit();
            }
        }
        this.f13a.add(bVar);
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
            if (i2 >= this.f13a.size()) {
                break;
            }
            C0024b bVar = this.f13a.get(i2);
            Fragment unused = bVar.f26d = this.f16d.findFragmentByTag(bVar.f23a);
            if (bVar.f26d != null && !bVar.f26d.isDetached()) {
                if (bVar.f23a.equals(currentTabTag)) {
                    this.f19g = bVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f16d.beginTransaction();
                    }
                    fragmentTransaction.detach(bVar.f26d);
                }
            }
            i = i2 + 1;
        }
        this.f20h = true;
        FragmentTransaction a = m45a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.f16d.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20h = false;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f21a = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f21a);
    }

    public void onTabChanged(String str) {
        FragmentTransaction a;
        if (this.f20h && (a = m45a(str, (FragmentTransaction) null)) != null) {
            a.commit();
        }
        if (this.f18f != null) {
            this.f18f.onTabChanged(str);
        }
    }

    /* renamed from: a */
    private FragmentTransaction m45a(String str, FragmentTransaction fragmentTransaction) {
        C0024b bVar = null;
        int i = 0;
        while (i < this.f13a.size()) {
            C0024b bVar2 = this.f13a.get(i);
            if (!bVar2.f23a.equals(str)) {
                bVar2 = bVar;
            }
            i++;
            bVar = bVar2;
        }
        if (bVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f19g != bVar) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f16d.beginTransaction();
            }
            if (!(this.f19g == null || this.f19g.f26d == null)) {
                fragmentTransaction.detach(this.f19g.f26d);
            }
            if (bVar != null) {
                if (bVar.f26d == null) {
                    Fragment unused = bVar.f26d = Fragment.instantiate(this.f15c, bVar.f24b.getName(), bVar.f25c);
                    fragmentTransaction.add(this.f17e, bVar.f26d, bVar.f23a);
                } else {
                    fragmentTransaction.attach(bVar.f26d);
                }
            }
            this.f19g = bVar;
        }
        return fragmentTransaction;
    }
}
