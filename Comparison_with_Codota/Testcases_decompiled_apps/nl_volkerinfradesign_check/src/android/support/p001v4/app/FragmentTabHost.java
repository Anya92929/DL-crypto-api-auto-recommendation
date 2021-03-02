package android.support.p001v4.app;

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
    private final ArrayList<C0058b> f225a = new ArrayList<>();

    /* renamed from: b */
    private FrameLayout f226b;

    /* renamed from: c */
    private Context f227c;

    /* renamed from: d */
    private FragmentManager f228d;

    /* renamed from: e */
    private int f229e;

    /* renamed from: f */
    private TabHost.OnTabChangeListener f230f;

    /* renamed from: g */
    private C0058b f231g;

    /* renamed from: h */
    private boolean f232h;

    /* renamed from: android.support.v4.app.FragmentTabHost$b */
    static final class C0058b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f235a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Class<?> f236b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final Bundle f237c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Fragment f238d;

        C0058b(String str, Class<?> cls, Bundle bundle) {
            this.f235a = str;
            this.f236b = cls;
            this.f237c = bundle;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTabHost$a */
    static class C0057a implements TabHost.TabContentFactory {

        /* renamed from: a */
        private final Context f234a;

        public C0057a(Context context) {
            this.f234a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f234a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTabHost$SavedState */
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
        String f233a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f233a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f233a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f233a + "}";
        }
    }

    public FragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        m210a(context, (AttributeSet) null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m210a(context, attributeSet);
    }

    /* renamed from: a */
    private void m210a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f229e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    /* renamed from: a */
    private void m209a(Context context) {
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
            this.f226b = frameLayout2;
            this.f226b.setId(this.f229e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, FragmentManager fragmentManager) {
        m209a(context);
        super.setup();
        this.f227c = context;
        this.f228d = fragmentManager;
        m208a();
    }

    public void setup(Context context, FragmentManager fragmentManager, int i) {
        m209a(context);
        super.setup();
        this.f227c = context;
        this.f228d = fragmentManager;
        this.f229e = i;
        m208a();
        this.f226b.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    /* renamed from: a */
    private void m208a() {
        if (this.f226b == null) {
            this.f226b = (FrameLayout) findViewById(this.f229e);
            if (this.f226b == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f229e);
            }
        }
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f230f = onTabChangeListener;
    }

    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new C0057a(this.f227c));
        String tag = tabSpec.getTag();
        C0058b bVar = new C0058b(tag, cls, bundle);
        if (this.f232h) {
            Fragment unused = bVar.f238d = this.f228d.findFragmentByTag(tag);
            if (bVar.f238d != null && !bVar.f238d.isDetached()) {
                FragmentTransaction beginTransaction = this.f228d.beginTransaction();
                beginTransaction.detach(bVar.f238d);
                beginTransaction.commit();
            }
        }
        this.f225a.add(bVar);
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
            if (i2 >= this.f225a.size()) {
                break;
            }
            C0058b bVar = this.f225a.get(i2);
            Fragment unused = bVar.f238d = this.f228d.findFragmentByTag(bVar.f235a);
            if (bVar.f238d != null && !bVar.f238d.isDetached()) {
                if (bVar.f235a.equals(currentTabTag)) {
                    this.f231g = bVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f228d.beginTransaction();
                    }
                    fragmentTransaction.detach(bVar.f238d);
                }
            }
            i = i2 + 1;
        }
        this.f232h = true;
        FragmentTransaction a = m207a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.f228d.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f232h = false;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f233a = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f233a);
    }

    public void onTabChanged(String str) {
        FragmentTransaction a;
        if (this.f232h && (a = m207a(str, (FragmentTransaction) null)) != null) {
            a.commit();
        }
        if (this.f230f != null) {
            this.f230f.onTabChanged(str);
        }
    }

    /* renamed from: a */
    private FragmentTransaction m207a(String str, FragmentTransaction fragmentTransaction) {
        C0058b bVar = null;
        int i = 0;
        while (i < this.f225a.size()) {
            C0058b bVar2 = this.f225a.get(i);
            if (!bVar2.f235a.equals(str)) {
                bVar2 = bVar;
            }
            i++;
            bVar = bVar2;
        }
        if (bVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f231g != bVar) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f228d.beginTransaction();
            }
            if (!(this.f231g == null || this.f231g.f238d == null)) {
                fragmentTransaction.detach(this.f231g.f238d);
            }
            if (bVar != null) {
                if (bVar.f238d == null) {
                    Fragment unused = bVar.f238d = Fragment.instantiate(this.f227c, bVar.f236b.getName(), bVar.f237c);
                    fragmentTransaction.add(this.f229e, bVar.f238d, bVar.f235a);
                } else {
                    fragmentTransaction.attach(bVar.f238d);
                }
            }
            this.f231g = bVar;
        }
        return fragmentTransaction;
    }
}
