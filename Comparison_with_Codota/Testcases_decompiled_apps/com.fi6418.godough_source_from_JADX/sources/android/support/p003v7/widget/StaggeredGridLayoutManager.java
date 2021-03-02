package android.support.p003v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityRecordCompat;
import android.support.p003v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* renamed from: android.support.v7.widget.StaggeredGridLayoutManager */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager {
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final String TAG = "StaggeredGridLayoutManager";
    public static final int VERTICAL = 1;

    /* renamed from: A */
    private boolean f3130A = true;

    /* renamed from: B */
    private final Runnable f3131B = new Runnable() {
        public void run() {
            boolean unused = StaggeredGridLayoutManager.this.m2291h();
        }
    };

    /* renamed from: a */
    OrientationHelper f3132a;

    /* renamed from: b */
    OrientationHelper f3133b;

    /* renamed from: c */
    boolean f3134c = false;

    /* renamed from: d */
    int f3135d = -1;

    /* renamed from: e */
    int f3136e = Integer.MIN_VALUE;

    /* renamed from: f */
    LazySpanLookup f3137f = new LazySpanLookup();

    /* renamed from: g */
    private int f3138g = -1;

    /* renamed from: h */
    private Span[] f3139h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f3140i;

    /* renamed from: j */
    private int f3141j;

    /* renamed from: k */
    private LayoutState f3142k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f3143l = false;

    /* renamed from: m */
    private BitSet f3144m;

    /* renamed from: n */
    private int f3145n = 2;

    /* renamed from: o */
    private boolean f3146o;

    /* renamed from: p */
    private boolean f3147p;

    /* renamed from: t */
    private SavedState f3148t;

    /* renamed from: u */
    private int f3149u;

    /* renamed from: v */
    private int f3150v;

    /* renamed from: w */
    private int f3151w;

    /* renamed from: x */
    private final Rect f3152x = new Rect();

    /* renamed from: y */
    private final AnchorInfo f3153y = new AnchorInfo();

    /* renamed from: z */
    private boolean f3154z = false;

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo */
    class AnchorInfo {

        /* renamed from: a */
        int f3157a;

        /* renamed from: b */
        int f3158b;

        /* renamed from: c */
        boolean f3159c;

        /* renamed from: d */
        boolean f3160d;

        private AnchorInfo() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6041a() {
            this.f3157a = -1;
            this.f3158b = Integer.MIN_VALUE;
            this.f3159c = false;
            this.f3160d = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6042a(int i) {
            if (this.f3159c) {
                this.f3158b = StaggeredGridLayoutManager.this.f3132a.getEndAfterPadding() - i;
            } else {
                this.f3158b = StaggeredGridLayoutManager.this.f3132a.getStartAfterPadding() + i;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo6043b() {
            this.f3158b = this.f3159c ? StaggeredGridLayoutManager.this.f3132a.getEndAfterPadding() : StaggeredGridLayoutManager.this.f3132a.getStartAfterPadding();
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams */
    public class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: e */
        Span f3162e;

        /* renamed from: f */
        boolean f3163f;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int getSpanIndex() {
            if (this.f3162e == null) {
                return -1;
            }
            return this.f3162e.f3183d;
        }

        public boolean isFullSpan() {
            return this.f3163f;
        }

        public void setFullSpan(boolean z) {
            this.f3163f = z;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup */
    class LazySpanLookup {

        /* renamed from: a */
        int[] f3164a;

        /* renamed from: b */
        List<FullSpanItem> f3165b;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem */
        class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* renamed from: a */
            int f3166a;

            /* renamed from: b */
            int f3167b;

            /* renamed from: c */
            int[] f3168c;

            /* renamed from: d */
            boolean f3169d;

            public FullSpanItem() {
            }

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.f3166a = parcel.readInt();
                this.f3167b = parcel.readInt();
                this.f3169d = parcel.readInt() != 1 ? false : z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f3168c = new int[readInt];
                    parcel.readIntArray(this.f3168c);
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public int mo6059a(int i) {
                if (this.f3168c == null) {
                    return 0;
                }
                return this.f3168c[i];
            }

            public int describeContents() {
                return 0;
            }

            public void invalidateSpanGaps() {
                this.f3168c = null;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3166a + ", mGapDir=" + this.f3167b + ", mHasUnwantedGapAfter=" + this.f3169d + ", mGapPerSpan=" + Arrays.toString(this.f3168c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3166a);
                parcel.writeInt(this.f3167b);
                parcel.writeInt(this.f3169d ? 1 : 0);
                if (this.f3168c == null || this.f3168c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f3168c.length);
                parcel.writeIntArray(this.f3168c);
            }
        }

        LazySpanLookup() {
        }

        /* renamed from: c */
        private void m2314c(int i, int i2) {
            if (this.f3165b != null) {
                int i3 = i + i2;
                for (int size = this.f3165b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f3165b.get(size);
                    if (fullSpanItem.f3166a >= i) {
                        if (fullSpanItem.f3166a < i3) {
                            this.f3165b.remove(size);
                        } else {
                            fullSpanItem.f3166a -= i2;
                        }
                    }
                }
            }
        }

        /* renamed from: d */
        private void m2315d(int i, int i2) {
            if (this.f3165b != null) {
                for (int size = this.f3165b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f3165b.get(size);
                    if (fullSpanItem.f3166a >= i) {
                        fullSpanItem.f3166a += i2;
                    }
                }
            }
        }

        /* renamed from: f */
        private int m2316f(int i) {
            if (this.f3165b == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i);
            if (fullSpanItem != null) {
                this.f3165b.remove(fullSpanItem);
            }
            int size = this.f3165b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f3165b.get(i2).f3166a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f3165b.remove(i2);
            return this.f3165b.get(i2).f3166a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo6047a(int i) {
            if (this.f3165b != null) {
                for (int size = this.f3165b.size() - 1; size >= 0; size--) {
                    if (this.f3165b.get(size).f3166a >= i) {
                        this.f3165b.remove(size);
                    }
                }
            }
            return mo6052b(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6048a() {
            if (this.f3164a != null) {
                Arrays.fill(this.f3164a, -1);
            }
            this.f3165b = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6049a(int i, int i2) {
            if (this.f3164a != null && i < this.f3164a.length) {
                mo6056e(i + i2);
                System.arraycopy(this.f3164a, i + i2, this.f3164a, i, (this.f3164a.length - i) - i2);
                Arrays.fill(this.f3164a, this.f3164a.length - i2, this.f3164a.length, -1);
                m2314c(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6050a(int i, Span span) {
            mo6056e(i);
            this.f3164a[i] = span.f3183d;
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.f3165b == null) {
                this.f3165b = new ArrayList();
            }
            int size = this.f3165b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f3165b.get(i);
                if (fullSpanItem2.f3166a == fullSpanItem.f3166a) {
                    this.f3165b.remove(i);
                }
                if (fullSpanItem2.f3166a >= fullSpanItem.f3166a) {
                    this.f3165b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f3165b.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo6052b(int i) {
            if (this.f3164a == null || i >= this.f3164a.length) {
                return -1;
            }
            int f = m2316f(i);
            if (f == -1) {
                Arrays.fill(this.f3164a, i, this.f3164a.length, -1);
                return this.f3164a.length;
            }
            Arrays.fill(this.f3164a, i, f + 1, -1);
            return f + 1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo6053b(int i, int i2) {
            if (this.f3164a != null && i < this.f3164a.length) {
                mo6056e(i + i2);
                System.arraycopy(this.f3164a, i, this.f3164a, i + i2, (this.f3164a.length - i) - i2);
                Arrays.fill(this.f3164a, i, i + i2, -1);
                m2315d(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo6054c(int i) {
            if (this.f3164a == null || i >= this.f3164a.length) {
                return -1;
            }
            return this.f3164a[i];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo6055d(int i) {
            int length = this.f3164a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo6056e(int i) {
            if (this.f3164a == null) {
                this.f3164a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f3164a, -1);
            } else if (i >= this.f3164a.length) {
                int[] iArr = this.f3164a;
                this.f3164a = new int[mo6055d(i)];
                System.arraycopy(iArr, 0, this.f3164a, 0, iArr.length);
                Arrays.fill(this.f3164a, iArr.length, this.f3164a.length, -1);
            }
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            if (this.f3165b == null) {
                return null;
            }
            int size = this.f3165b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f3165b.get(i4);
                if (fullSpanItem.f3166a >= i2) {
                    return null;
                }
                if (fullSpanItem.f3166a >= i) {
                    if (i3 == 0 || fullSpanItem.f3167b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f3169d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i) {
            if (this.f3165b == null) {
                return null;
            }
            for (int size = this.f3165b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3165b.get(size);
                if (fullSpanItem.f3166a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$SavedState */
    class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f3170a;

        /* renamed from: b */
        int f3171b;

        /* renamed from: c */
        int f3172c;

        /* renamed from: d */
        int[] f3173d;

        /* renamed from: e */
        int f3174e;

        /* renamed from: f */
        int[] f3175f;

        /* renamed from: g */
        List<LazySpanLookup.FullSpanItem> f3176g;

        /* renamed from: h */
        boolean f3177h;

        /* renamed from: i */
        boolean f3178i;

        /* renamed from: j */
        boolean f3179j;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f3170a = parcel.readInt();
            this.f3171b = parcel.readInt();
            this.f3172c = parcel.readInt();
            if (this.f3172c > 0) {
                this.f3173d = new int[this.f3172c];
                parcel.readIntArray(this.f3173d);
            }
            this.f3174e = parcel.readInt();
            if (this.f3174e > 0) {
                this.f3175f = new int[this.f3174e];
                parcel.readIntArray(this.f3175f);
            }
            this.f3177h = parcel.readInt() == 1;
            this.f3178i = parcel.readInt() == 1;
            this.f3179j = parcel.readInt() != 1 ? false : z;
            this.f3176g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3172c = savedState.f3172c;
            this.f3170a = savedState.f3170a;
            this.f3171b = savedState.f3171b;
            this.f3173d = savedState.f3173d;
            this.f3174e = savedState.f3174e;
            this.f3175f = savedState.f3175f;
            this.f3177h = savedState.f3177h;
            this.f3178i = savedState.f3178i;
            this.f3179j = savedState.f3179j;
            this.f3176g = savedState.f3176g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6066a() {
            this.f3173d = null;
            this.f3172c = 0;
            this.f3174e = 0;
            this.f3175f = null;
            this.f3176g = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo6067b() {
            this.f3173d = null;
            this.f3172c = 0;
            this.f3170a = -1;
            this.f3171b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(this.f3170a);
            parcel.writeInt(this.f3171b);
            parcel.writeInt(this.f3172c);
            if (this.f3172c > 0) {
                parcel.writeIntArray(this.f3173d);
            }
            parcel.writeInt(this.f3174e);
            if (this.f3174e > 0) {
                parcel.writeIntArray(this.f3175f);
            }
            parcel.writeInt(this.f3177h ? 1 : 0);
            parcel.writeInt(this.f3178i ? 1 : 0);
            if (!this.f3179j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.f3176g);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$Span */
    class Span {

        /* renamed from: a */
        int f3180a;

        /* renamed from: b */
        int f3181b;

        /* renamed from: c */
        int f3182c;

        /* renamed from: d */
        final int f3183d;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public ArrayList<View> f3185f;

        private Span(int i) {
            this.f3185f = new ArrayList<>();
            this.f3180a = Integer.MIN_VALUE;
            this.f3181b = Integer.MIN_VALUE;
            this.f3182c = 0;
            this.f3183d = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo6072a(int i) {
            if (this.f3180a != Integer.MIN_VALUE) {
                return this.f3180a;
            }
            if (this.f3185f.size() == 0) {
                return i;
            }
            mo6074a();
            return this.f3180a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo6073a(int i, int i2, boolean z) {
            int startAfterPadding = StaggeredGridLayoutManager.this.f3132a.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.f3132a.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f3185f.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.f3132a.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.f3132a.getDecoratedEnd(view);
                if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                    if (!z) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6074a() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.f3185f.get(0);
            LayoutParams c = mo6080c(view);
            this.f3180a = StaggeredGridLayoutManager.this.f3132a.getDecoratedStart(view);
            if (c.f3163f && (fullSpanItem = StaggeredGridLayoutManager.this.f3137f.getFullSpanItem(c.getViewLayoutPosition())) != null && fullSpanItem.f3167b == -1) {
                this.f3180a -= fullSpanItem.mo6059a(this.f3183d);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6075a(View view) {
            LayoutParams c = mo6080c(view);
            c.f3162e = this;
            this.f3185f.add(0, view);
            this.f3180a = Integer.MIN_VALUE;
            if (this.f3185f.size() == 1) {
                this.f3181b = Integer.MIN_VALUE;
            }
            if (c.isItemRemoved() || c.isItemChanged()) {
                this.f3182c += StaggeredGridLayoutManager.this.f3132a.getDecoratedMeasurement(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6076a(boolean z, int i) {
            int b = z ? mo6078b(Integer.MIN_VALUE) : mo6072a(Integer.MIN_VALUE);
            mo6085e();
            if (b != Integer.MIN_VALUE) {
                if (z && b < StaggeredGridLayoutManager.this.f3132a.getEndAfterPadding()) {
                    return;
                }
                if (z || b <= StaggeredGridLayoutManager.this.f3132a.getStartAfterPadding()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.f3181b = b;
                    this.f3180a = b;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo6077b() {
            if (this.f3180a != Integer.MIN_VALUE) {
                return this.f3180a;
            }
            mo6074a();
            return this.f3180a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo6078b(int i) {
            if (this.f3181b != Integer.MIN_VALUE) {
                return this.f3181b;
            }
            if (this.f3185f.size() == 0) {
                return i;
            }
            mo6081c();
            return this.f3181b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo6079b(View view) {
            LayoutParams c = mo6080c(view);
            c.f3162e = this;
            this.f3185f.add(view);
            this.f3181b = Integer.MIN_VALUE;
            if (this.f3185f.size() == 1) {
                this.f3180a = Integer.MIN_VALUE;
            }
            if (c.isItemRemoved() || c.isItemChanged()) {
                this.f3182c += StaggeredGridLayoutManager.this.f3132a.getDecoratedMeasurement(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public LayoutParams mo6080c(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo6081c() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.f3185f.get(this.f3185f.size() - 1);
            LayoutParams c = mo6080c(view);
            this.f3181b = StaggeredGridLayoutManager.this.f3132a.getDecoratedEnd(view);
            if (c.f3163f && (fullSpanItem = StaggeredGridLayoutManager.this.f3137f.getFullSpanItem(c.getViewLayoutPosition())) != null && fullSpanItem.f3167b == 1) {
                this.f3181b = fullSpanItem.mo6059a(this.f3183d) + this.f3181b;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo6082c(int i) {
            this.f3180a = i;
            this.f3181b = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo6083d() {
            if (this.f3181b != Integer.MIN_VALUE) {
                return this.f3181b;
            }
            mo6081c();
            return this.f3181b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo6084d(int i) {
            if (this.f3180a != Integer.MIN_VALUE) {
                this.f3180a += i;
            }
            if (this.f3181b != Integer.MIN_VALUE) {
                this.f3181b += i;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo6085e() {
            this.f3185f.clear();
            mo6086f();
            this.f3182c = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo6086f() {
            this.f3180a = Integer.MIN_VALUE;
            this.f3181b = Integer.MIN_VALUE;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.f3143l ? mo6073a(this.f3185f.size() - 1, -1, true) : mo6073a(0, this.f3185f.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.f3143l ? mo6073a(this.f3185f.size() - 1, -1, false) : mo6073a(0, this.f3185f.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.f3143l ? mo6073a(0, this.f3185f.size(), true) : mo6073a(this.f3185f.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.f3143l ? mo6073a(0, this.f3185f.size(), false) : mo6073a(this.f3185f.size() - 1, -1, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo6091g() {
            int size = this.f3185f.size();
            View remove = this.f3185f.remove(size - 1);
            LayoutParams c = mo6080c(remove);
            c.f3162e = null;
            if (c.isItemRemoved() || c.isItemChanged()) {
                this.f3182c -= StaggeredGridLayoutManager.this.f3132a.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.f3180a = Integer.MIN_VALUE;
            }
            this.f3181b = Integer.MIN_VALUE;
        }

        public int getDeletedSize() {
            return this.f3182c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6093h() {
            View remove = this.f3185f.remove(0);
            LayoutParams c = mo6080c(remove);
            c.f3162e = null;
            if (this.f3185f.size() == 0) {
                this.f3181b = Integer.MIN_VALUE;
            }
            if (c.isItemRemoved() || c.isItemChanged()) {
                this.f3182c -= StaggeredGridLayoutManager.this.f3132a.getDecoratedMeasurement(remove);
            }
            this.f3180a = Integer.MIN_VALUE;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.f3140i = i2;
        setSpanCount(i);
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
    }

    /* renamed from: a */
    private int m2255a(int i, int i2) {
        return i < 0 ? i2 : View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    /* renamed from: a */
    private int m2256a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) - i2) - i3, mode) : i;
    }

    /* renamed from: a */
    private int m2257a(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        Span span;
        int decoratedMeasurement;
        int i;
        this.f3144m.set(0, this.f3138g, true);
        int i2 = layoutState.f2768d == 1 ? layoutState.f2770f + layoutState.f2765a : layoutState.f2769e - layoutState.f2765a;
        m2278b(layoutState.f2768d, i2);
        int endAfterPadding = this.f3134c ? this.f3132a.getEndAfterPadding() : this.f3132a.getStartAfterPadding();
        boolean z = false;
        while (layoutState.mo5271a(state) && !this.f3144m.isEmpty()) {
            View a = layoutState.mo5270a(recycler);
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int c = this.f3137f.mo6054c(viewLayoutPosition);
            boolean z2 = c == -1;
            if (z2) {
                Span a2 = layoutParams.f3163f ? this.f3139h[0] : m2260a(layoutState);
                this.f3137f.mo6050a(viewLayoutPosition, a2);
                span = a2;
            } else {
                span = this.f3139h[c];
            }
            layoutParams.f3162e = span;
            if (layoutState.f2768d == 1) {
                addView(a);
            } else {
                addView(a, 0);
            }
            m2271a(a, layoutParams);
            if (layoutState.f2768d == 1) {
                int f = layoutParams.f3163f ? m2289f(endAfterPadding) : span.mo6078b(endAfterPadding);
                i = f + this.f3132a.getDecoratedMeasurement(a);
                if (!z2 || !layoutParams.f3163f) {
                    decoratedMeasurement = f;
                } else {
                    LazySpanLookup.FullSpanItem b = m2277b(f);
                    b.f3167b = -1;
                    b.f3166a = viewLayoutPosition;
                    this.f3137f.addFullSpanItem(b);
                    decoratedMeasurement = f;
                }
            } else {
                int e = layoutParams.f3163f ? m2288e(endAfterPadding) : span.mo6072a(endAfterPadding);
                decoratedMeasurement = e - this.f3132a.getDecoratedMeasurement(a);
                if (z2 && layoutParams.f3163f) {
                    LazySpanLookup.FullSpanItem c2 = m2284c(e);
                    c2.f3167b = 1;
                    c2.f3166a = viewLayoutPosition;
                    this.f3137f.addFullSpanItem(c2);
                }
                i = e;
            }
            if (layoutParams.f3163f && layoutState.f2767c == -1) {
                if (z2) {
                    this.f3154z = true;
                } else {
                    if (layoutState.f2768d == 1 ? !mo6024f() : !mo6029g()) {
                        LazySpanLookup.FullSpanItem fullSpanItem = this.f3137f.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.f3169d = true;
                        }
                        this.f3154z = true;
                    }
                }
            }
            m2272a(a, layoutParams, layoutState);
            int startAfterPadding = layoutParams.f3163f ? this.f3133b.getStartAfterPadding() : this.f3133b.getStartAfterPadding() + (span.f3183d * this.f3141j);
            int decoratedMeasurement2 = startAfterPadding + this.f3133b.getDecoratedMeasurement(a);
            if (this.f3140i == 1) {
                m2270a(a, startAfterPadding, decoratedMeasurement, decoratedMeasurement2, i);
            } else {
                m2270a(a, decoratedMeasurement, startAfterPadding, i, decoratedMeasurement2);
            }
            if (layoutParams.f3163f) {
                m2278b(this.f3142k.f2768d, i2);
            } else {
                m2267a(span, this.f3142k.f2768d, i2);
            }
            m2264a(recycler, this.f3142k);
            z = true;
        }
        if (!z) {
            m2264a(recycler, this.f3142k);
        }
        int startAfterPadding2 = this.f3142k.f2768d == -1 ? this.f3132a.getStartAfterPadding() - m2288e(this.f3132a.getStartAfterPadding()) : m2289f(this.f3132a.getEndAfterPadding()) - this.f3132a.getEndAfterPadding();
        if (startAfterPadding2 > 0) {
            return Math.min(layoutState.f2765a, startAfterPadding2);
        }
        return 0;
    }

    /* renamed from: a */
    private int m2258a(RecyclerView.State state) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        m2294i();
        OrientationHelper orientationHelper = this.f3132a;
        View a = mo6017a(!this.f3130A, true);
        if (!this.f3130A) {
            z = true;
        }
        return ScrollbarHelper.m2184a(state, orientationHelper, a, mo6019b(z, true), this, this.f3130A, this.f3134c);
    }

    /* renamed from: a */
    private Span m2260a(LayoutState layoutState) {
        int i;
        int i2;
        Span span;
        Span span2;
        Span span3 = null;
        int i3 = -1;
        if (m2292h(layoutState.f2768d)) {
            i = this.f3138g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f3138g;
            i3 = 1;
        }
        if (layoutState.f2768d == 1) {
            int startAfterPadding = this.f3132a.getStartAfterPadding();
            int i4 = i;
            int i5 = Integer.MAX_VALUE;
            while (i4 != i2) {
                Span span4 = this.f3139h[i4];
                int b = span4.mo6078b(startAfterPadding);
                if (b < i5) {
                    span2 = span4;
                } else {
                    b = i5;
                    span2 = span3;
                }
                i4 += i3;
                span3 = span2;
                i5 = b;
            }
        } else {
            int endAfterPadding = this.f3132a.getEndAfterPadding();
            int i6 = i;
            int i7 = Integer.MIN_VALUE;
            while (i6 != i2) {
                Span span5 = this.f3139h[i6];
                int a = span5.mo6072a(endAfterPadding);
                if (a > i7) {
                    span = span5;
                } else {
                    a = i7;
                    span = span3;
                }
                i6 += i3;
                span3 = span;
                i7 = a;
            }
        }
        return span3;
    }

    /* renamed from: a */
    private void m2261a(int i) {
        int i2 = 1;
        this.f3142k.f2768d = i;
        LayoutState layoutState = this.f3142k;
        if (this.f3134c != (i == -1)) {
            i2 = -1;
        }
        layoutState.f2767c = i2;
    }

    /* renamed from: a */
    private void m2262a(int i, RecyclerView.State state) {
        int i2;
        int targetScrollPosition;
        int i3 = 0;
        this.f3142k.f2765a = 0;
        this.f3142k.f2766b = i;
        if (!isSmoothScrolling() || (targetScrollPosition = state.getTargetScrollPosition()) == -1) {
            i2 = 0;
        } else {
            if (this.f3134c == (targetScrollPosition < i)) {
                i2 = this.f3132a.getTotalSpace();
            } else {
                i3 = this.f3132a.getTotalSpace();
                i2 = 0;
            }
        }
        if (getClipToPadding()) {
            this.f3142k.f2769e = this.f3132a.getStartAfterPadding() - i3;
            this.f3142k.f2770f = i2 + this.f3132a.getEndAfterPadding();
            return;
        }
        this.f3142k.f2770f = i2 + this.f3132a.getEnd();
        this.f3142k.f2769e = -i3;
    }

    /* renamed from: a */
    private void m2263a(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f3132a.getDecoratedEnd(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3163f) {
                    int i2 = 0;
                    while (i2 < this.f3138g) {
                        if (this.f3139h[i2].f3185f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f3138g; i3++) {
                        this.f3139h[i3].mo6093h();
                    }
                } else if (layoutParams.f3162e.f3185f.size() != 1) {
                    layoutParams.f3162e.mo6093h();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m2264a(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.f2765a == 0) {
            if (layoutState.f2768d == -1) {
                m2280b(recycler, layoutState.f2770f);
            } else {
                m2263a(recycler, layoutState.f2769e);
            }
        } else if (layoutState.f2768d == -1) {
            int d = layoutState.f2769e - m2287d(layoutState.f2769e);
            m2280b(recycler, d < 0 ? layoutState.f2770f : layoutState.f2770f - Math.min(d, layoutState.f2765a));
        } else {
            int g = m2290g(layoutState.f2770f) - layoutState.f2770f;
            m2263a(recycler, g < 0 ? layoutState.f2769e : Math.min(g, layoutState.f2765a) + layoutState.f2769e);
        }
    }

    /* renamed from: a */
    private void m2265a(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding = this.f3132a.getEndAfterPadding() - m2289f(this.f3132a.getEndAfterPadding());
        if (endAfterPadding > 0) {
            int i = endAfterPadding - (-mo6015a(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.f3132a.offsetChildren(i);
            }
        }
    }

    /* renamed from: a */
    private void m2266a(AnchorInfo anchorInfo) {
        if (this.f3148t.f3172c > 0) {
            if (this.f3148t.f3172c == this.f3138g) {
                for (int i = 0; i < this.f3138g; i++) {
                    this.f3139h[i].mo6085e();
                    int i2 = this.f3148t.f3173d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 = this.f3148t.f3178i ? i2 + this.f3132a.getEndAfterPadding() : i2 + this.f3132a.getStartAfterPadding();
                    }
                    this.f3139h[i].mo6082c(i2);
                }
            } else {
                this.f3148t.mo6066a();
                this.f3148t.f3170a = this.f3148t.f3171b;
            }
        }
        this.f3147p = this.f3148t.f3179j;
        setReverseLayout(this.f3148t.f3177h);
        m2296j();
        if (this.f3148t.f3170a != -1) {
            this.f3135d = this.f3148t.f3170a;
            anchorInfo.f3159c = this.f3148t.f3178i;
        } else {
            anchorInfo.f3159c = this.f3134c;
        }
        if (this.f3148t.f3174e > 1) {
            this.f3137f.f3164a = this.f3148t.f3175f;
            this.f3137f.f3165b = this.f3148t.f3176g;
        }
    }

    /* renamed from: a */
    private void m2267a(Span span, int i, int i2) {
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (deletedSize + span.mo6077b() <= i2) {
                this.f3144m.set(span.f3183d, false);
            }
        } else if (span.mo6083d() - deletedSize >= i2) {
            this.f3144m.set(span.f3183d, false);
        }
    }

    /* renamed from: a */
    private void m2268a(View view) {
        for (int i = this.f3138g - 1; i >= 0; i--) {
            this.f3139h[i].mo6079b(view);
        }
    }

    /* renamed from: a */
    private void m2269a(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.f3152x);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(m2256a(i, layoutParams.leftMargin + this.f3152x.left, layoutParams.rightMargin + this.f3152x.right), m2256a(i2, layoutParams.topMargin + this.f3152x.top, layoutParams.bottomMargin + this.f3152x.bottom));
    }

    /* renamed from: a */
    private void m2270a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutDecorated(view, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    /* renamed from: a */
    private void m2271a(View view, LayoutParams layoutParams) {
        if (layoutParams.f3163f) {
            if (this.f3140i == 1) {
                m2269a(view, this.f3149u, m2255a(layoutParams.height, this.f3151w));
            } else {
                m2269a(view, m2255a(layoutParams.width, this.f3150v), this.f3149u);
            }
        } else if (this.f3140i == 1) {
            m2269a(view, this.f3150v, m2255a(layoutParams.height, this.f3151w));
        } else {
            m2269a(view, m2255a(layoutParams.width, this.f3150v), this.f3151w);
        }
    }

    /* renamed from: a */
    private void m2272a(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.f2768d == 1) {
            if (layoutParams.f3163f) {
                m2268a(view);
            } else {
                layoutParams.f3162e.mo6079b(view);
            }
        } else if (layoutParams.f3163f) {
            m2282b(view);
        } else {
            layoutParams.f3162e.mo6075a(view);
        }
    }

    /* renamed from: a */
    private boolean m2273a(Span span) {
        if (!this.f3134c) {
            return span.mo6077b() > this.f3132a.getStartAfterPadding();
        }
        if (span.mo6083d() < this.f3132a.getEndAfterPadding()) {
            return true;
        }
    }

    /* renamed from: b */
    private int m2275b(RecyclerView.State state) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        m2294i();
        OrientationHelper orientationHelper = this.f3132a;
        View a = mo6017a(!this.f3130A, true);
        if (!this.f3130A) {
            z = true;
        }
        return ScrollbarHelper.m2183a(state, orientationHelper, a, mo6019b(z, true), this, this.f3130A);
    }

    /* renamed from: b */
    private LazySpanLookup.FullSpanItem m2277b(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3168c = new int[this.f3138g];
        for (int i2 = 0; i2 < this.f3138g; i2++) {
            fullSpanItem.f3168c[i2] = i - this.f3139h[i2].mo6078b(i);
        }
        return fullSpanItem;
    }

    /* renamed from: b */
    private void m2278b(int i, int i2) {
        for (int i3 = 0; i3 < this.f3138g; i3++) {
            if (!this.f3139h[i3].f3185f.isEmpty()) {
                m2267a(this.f3139h[i3], i, i2);
            }
        }
    }

    /* renamed from: b */
    private void m2279b(int i, int i2, int i3) {
        int i4;
        int i5;
        int k = this.f3134c ? m2297k() : m2299l();
        if (i3 != 3) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f3137f.mo6052b(i5);
        switch (i3) {
            case 0:
                this.f3137f.mo6053b(i, i2);
                break;
            case 1:
                this.f3137f.mo6049a(i, i2);
                break;
            case 3:
                this.f3137f.mo6049a(i, 1);
                this.f3137f.mo6053b(i2, 1);
                break;
        }
        if (i4 > k) {
            if (i5 <= (this.f3134c ? m2299l() : m2297k())) {
                requestLayout();
            }
        }
    }

    /* renamed from: b */
    private void m2280b(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f3132a.getDecoratedStart(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3163f) {
                    int i2 = 0;
                    while (i2 < this.f3138g) {
                        if (this.f3139h[i2].f3185f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f3138g; i3++) {
                        this.f3139h[i3].mo6091g();
                    }
                } else if (layoutParams.f3162e.f3185f.size() != 1) {
                    layoutParams.f3162e.mo6091g();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m2281b(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int e = m2288e(this.f3132a.getStartAfterPadding()) - this.f3132a.getStartAfterPadding();
        if (e > 0) {
            int a = e - mo6015a(e, recycler, state);
            if (z && a > 0) {
                this.f3132a.offsetChildren(-a);
            }
        }
    }

    /* renamed from: b */
    private void m2282b(View view) {
        for (int i = this.f3138g - 1; i >= 0; i--) {
            this.f3139h[i].mo6075a(view);
        }
    }

    /* renamed from: c */
    private int m2283c(RecyclerView.State state) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        m2294i();
        OrientationHelper orientationHelper = this.f3132a;
        View a = mo6017a(!this.f3130A, true);
        if (!this.f3130A) {
            z = true;
        }
        return ScrollbarHelper.m2185b(state, orientationHelper, a, mo6019b(z, true), this, this.f3130A);
    }

    /* renamed from: c */
    private LazySpanLookup.FullSpanItem m2284c(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3168c = new int[this.f3138g];
        for (int i2 = 0; i2 < this.f3138g; i2++) {
            fullSpanItem.f3168c[i2] = this.f3139h[i2].mo6072a(i) - i;
        }
        return fullSpanItem;
    }

    /* renamed from: c */
    private boolean m2285c(RecyclerView.State state, AnchorInfo anchorInfo) {
        anchorInfo.f3157a = this.f3146o ? m2298k(state.getItemCount()) : m2295j(state.getItemCount());
        anchorInfo.f3158b = Integer.MIN_VALUE;
        return true;
    }

    /* renamed from: d */
    private int m2287d(int i) {
        int a = this.f3139h[0].mo6072a(i);
        for (int i2 = 1; i2 < this.f3138g; i2++) {
            int a2 = this.f3139h[i2].mo6072a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: e */
    private int m2288e(int i) {
        int a = this.f3139h[0].mo6072a(i);
        for (int i2 = 1; i2 < this.f3138g; i2++) {
            int a2 = this.f3139h[i2].mo6072a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: f */
    private int m2289f(int i) {
        int b = this.f3139h[0].mo6078b(i);
        for (int i2 = 1; i2 < this.f3138g; i2++) {
            int b2 = this.f3139h[i2].mo6078b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: g */
    private int m2290g(int i) {
        int b = this.f3139h[0].mo6078b(i);
        for (int i2 = 1; i2 < this.f3138g; i2++) {
            int b2 = this.f3139h[i2].mo6078b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m2291h() {
        int l;
        int k;
        if (getChildCount() == 0 || this.f3145n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f3134c) {
            l = m2297k();
            k = m2299l();
        } else {
            l = m2299l();
            k = m2297k();
        }
        if (l == 0 && mo6016a() != null) {
            this.f3137f.mo6048a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.f3154z) {
            return false;
        } else {
            int i = this.f3134c ? -1 : 1;
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.f3137f.getFirstFullSpanItemInRange(l, k + 1, i, true);
            if (firstFullSpanItemInRange == null) {
                this.f3154z = false;
                this.f3137f.mo6047a(k + 1);
                return false;
            }
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.f3137f.getFirstFullSpanItemInRange(l, firstFullSpanItemInRange.f3166a, i * -1, true);
            if (firstFullSpanItemInRange2 == null) {
                this.f3137f.mo6047a(firstFullSpanItemInRange.f3166a);
            } else {
                this.f3137f.mo6047a(firstFullSpanItemInRange2.f3166a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    /* renamed from: h */
    private boolean m2292h(int i) {
        if (this.f3140i == 0) {
            return (i == -1) != this.f3134c;
        }
        return ((i == -1) == this.f3134c) == mo6020b();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public int m2293i(int i) {
        int i2 = -1;
        if (getChildCount() == 0) {
            return this.f3134c ? 1 : -1;
        }
        if ((i < m2299l()) == this.f3134c) {
            i2 = 1;
        }
        return i2;
    }

    /* renamed from: i */
    private void m2294i() {
        if (this.f3132a == null) {
            this.f3132a = OrientationHelper.createOrientationHelper(this, this.f3140i);
            this.f3133b = OrientationHelper.createOrientationHelper(this, 1 - this.f3140i);
            this.f3142k = new LayoutState();
        }
    }

    /* renamed from: j */
    private int m2295j(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: j */
    private void m2296j() {
        boolean z = true;
        if (this.f3140i == 1 || !mo6020b()) {
            this.f3134c = this.f3143l;
            return;
        }
        if (this.f3143l) {
            z = false;
        }
        this.f3134c = z;
    }

    /* renamed from: k */
    private int m2297k() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    /* renamed from: k */
    private int m2298k(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: l */
    private int m2299l() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6015a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int l;
        m2294i();
        if (i > 0) {
            i2 = 1;
            l = m2297k();
        } else {
            i2 = -1;
            l = m2299l();
        }
        m2262a(l, state);
        m2261a(i2);
        this.f3142k.f2766b = l + this.f3142k.f2767c;
        int abs = Math.abs(i);
        this.f3142k.f2765a = abs;
        int a = m2257a(recycler, this.f3142k, state);
        if (abs >= a) {
            i = i < 0 ? -a : a;
        }
        this.f3132a.offsetChildren(-i);
        this.f3146o = this.f3134c;
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo6016a() {
        int i;
        boolean z;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.f3138g);
        bitSet.set(0, this.f3138g, true);
        char c = (this.f3140i != 1 || !mo6020b()) ? (char) 65535 : 1;
        if (this.f3134c) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        int i2 = childCount < i ? 1 : -1;
        for (int i3 = childCount; i3 != i; i3 += i2) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.f3162e.f3183d)) {
                if (m2273a(layoutParams.f3162e)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.f3162e.f3183d);
            }
            if (!layoutParams.f3163f && i3 + i2 != i) {
                View childAt2 = getChildAt(i3 + i2);
                if (this.f3134c) {
                    int decoratedEnd = this.f3132a.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.f3132a.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd == decoratedEnd2) {
                        z = true;
                    }
                    z = false;
                } else {
                    int decoratedStart = this.f3132a.getDecoratedStart(childAt);
                    int decoratedStart2 = this.f3132a.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                    if (decoratedStart == decoratedStart2) {
                        z = true;
                    }
                    z = false;
                }
                if (!z) {
                    continue;
                } else {
                    if ((layoutParams.f3162e.f3183d - ((LayoutParams) childAt2.getLayoutParams()).f3162e.f3183d < 0) != (c < 0)) {
                        return childAt;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo6017a(boolean z, boolean z2) {
        m2294i();
        int startAfterPadding = this.f3132a.getStartAfterPadding();
        int endAfterPadding = this.f3132a.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.f3132a.getDecoratedStart(childAt);
            if (this.f3132a.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6018a(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!mo6021b(state, anchorInfo) && !m2285c(state, anchorInfo)) {
            anchorInfo.mo6043b();
            anchorInfo.f3157a = 0;
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f3148t == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo6019b(boolean z, boolean z2) {
        m2294i();
        int startAfterPadding = this.f3132a.getStartAfterPadding();
        int endAfterPadding = this.f3132a.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.f3132a.getDecoratedStart(childAt);
            int decoratedEnd = this.f3132a.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6020b() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6021b(RecyclerView.State state, AnchorInfo anchorInfo) {
        boolean z = false;
        if (state.isPreLayout() || this.f3135d == -1) {
            return false;
        }
        if (this.f3135d < 0 || this.f3135d >= state.getItemCount()) {
            this.f3135d = -1;
            this.f3136e = Integer.MIN_VALUE;
            return false;
        } else if (this.f3148t == null || this.f3148t.f3170a == -1 || this.f3148t.f3172c < 1) {
            View findViewByPosition = findViewByPosition(this.f3135d);
            if (findViewByPosition != null) {
                anchorInfo.f3157a = this.f3134c ? m2297k() : m2299l();
                if (this.f3136e != Integer.MIN_VALUE) {
                    if (anchorInfo.f3159c) {
                        anchorInfo.f3158b = (this.f3132a.getEndAfterPadding() - this.f3136e) - this.f3132a.getDecoratedEnd(findViewByPosition);
                        return true;
                    }
                    anchorInfo.f3158b = (this.f3132a.getStartAfterPadding() + this.f3136e) - this.f3132a.getDecoratedStart(findViewByPosition);
                    return true;
                } else if (this.f3132a.getDecoratedMeasurement(findViewByPosition) > this.f3132a.getTotalSpace()) {
                    anchorInfo.f3158b = anchorInfo.f3159c ? this.f3132a.getEndAfterPadding() : this.f3132a.getStartAfterPadding();
                    return true;
                } else {
                    int decoratedStart = this.f3132a.getDecoratedStart(findViewByPosition) - this.f3132a.getStartAfterPadding();
                    if (decoratedStart < 0) {
                        anchorInfo.f3158b = -decoratedStart;
                        return true;
                    }
                    int endAfterPadding = this.f3132a.getEndAfterPadding() - this.f3132a.getDecoratedEnd(findViewByPosition);
                    if (endAfterPadding < 0) {
                        anchorInfo.f3158b = endAfterPadding;
                        return true;
                    }
                    anchorInfo.f3158b = Integer.MIN_VALUE;
                    return true;
                }
            } else {
                anchorInfo.f3157a = this.f3135d;
                if (this.f3136e == Integer.MIN_VALUE) {
                    if (m2293i(anchorInfo.f3157a) == 1) {
                        z = true;
                    }
                    anchorInfo.f3159c = z;
                    anchorInfo.mo6043b();
                } else {
                    anchorInfo.mo6042a(this.f3136e);
                }
                anchorInfo.f3160d = true;
                return true;
            }
        } else {
            anchorInfo.f3158b = Integer.MIN_VALUE;
            anchorInfo.f3157a = this.f3135d;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6022c() {
        this.f3141j = this.f3133b.getTotalSpace() / this.f3138g;
        this.f3149u = View.MeasureSpec.makeMeasureSpec(this.f3133b.getTotalSpace(), 1073741824);
        if (this.f3140i == 1) {
            this.f3150v = View.MeasureSpec.makeMeasureSpec(this.f3141j, 1073741824);
            this.f3151w = View.MeasureSpec.makeMeasureSpec(0, 0);
            return;
        }
        this.f3151w = View.MeasureSpec.makeMeasureSpec(this.f3141j, 1073741824);
        this.f3150v = View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public boolean canScrollHorizontally() {
        return this.f3140i == 0;
    }

    public boolean canScrollVertically() {
        return this.f3140i == 1;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return m2275b(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return m2258a(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return m2283c(state);
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return m2275b(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return m2258a(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return m2283c(state);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo6023e() {
        View b = this.f3134c ? mo6019b(true, true) : mo6017a(true, true);
        if (b == null) {
            return -1;
        }
        return getPosition(b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo6024f() {
        int b = this.f3139h[0].mo6078b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f3138g; i++) {
            if (this.f3139h[i].mo6078b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3138g];
        } else if (iArr.length < this.f3138g) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3138g + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f3138g; i++) {
            iArr[i] = this.f3139h[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3138g];
        } else if (iArr.length < this.f3138g) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3138g + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f3138g; i++) {
            iArr[i] = this.f3139h[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3138g];
        } else if (iArr.length < this.f3138g) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3138g + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f3138g; i++) {
            iArr[i] = this.f3139h[i].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3138g];
        } else if (iArr.length < this.f3138g) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3138g + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f3138g; i++) {
            iArr[i] = this.f3139h[i].findLastVisibleItemPosition();
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo6029g() {
        int a = this.f3139h[0].mo6072a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f3138g; i++) {
            if (this.f3139h[i].mo6072a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f3140i == 1 ? this.f3138g : super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.f3145n;
    }

    public int getOrientation() {
        return this.f3140i;
    }

    public boolean getReverseLayout() {
        return this.f3143l;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f3140i == 0 ? this.f3138g : super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.f3138g;
    }

    public void invalidateSpanAssignments() {
        this.f3137f.mo6048a();
        requestLayout();
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f3138g; i2++) {
            this.f3139h[i2].mo6084d(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f3138g; i2++) {
            this.f3139h[i2].mo6084d(i);
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        removeCallbacks(this.f3131B);
        for (int i = 0; i < this.f3138g; i++) {
            this.f3139h[i].mo6085e();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            View a = mo6017a(false, true);
            View b = mo6019b(false, true);
            if (a != null && b != null) {
                int position = getPosition(a);
                int position2 = getPosition(b);
                if (position < position2) {
                    asRecord.setFromIndex(position);
                    asRecord.setToIndex(position2);
                    return;
                }
                asRecord.setFromIndex(position2);
                asRecord.setToIndex(position);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.mo5707a(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f3140i == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.f3163f ? this.f3138g : 1, -1, -1, layoutParams2.f3163f, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.f3163f ? this.f3138g : 1, layoutParams2.f3163f, false));
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m2279b(i, i2, 0);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3137f.mo6048a();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m2279b(i, i2, 3);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m2279b(i, i2, 1);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        m2279b(i, i2, 2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = false;
        m2294i();
        AnchorInfo anchorInfo = this.f3153y;
        anchorInfo.mo6041a();
        if (!(this.f3148t == null && this.f3135d == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (this.f3148t != null) {
            m2266a(anchorInfo);
        } else {
            m2296j();
            anchorInfo.f3159c = this.f3134c;
        }
        mo6018a(state, anchorInfo);
        if (this.f3148t == null && !(anchorInfo.f3159c == this.f3146o && mo6020b() == this.f3147p)) {
            this.f3137f.mo6048a();
            anchorInfo.f3160d = true;
        }
        if (getChildCount() > 0 && (this.f3148t == null || this.f3148t.f3172c < 1)) {
            if (anchorInfo.f3160d) {
                for (int i = 0; i < this.f3138g; i++) {
                    this.f3139h[i].mo6085e();
                    if (anchorInfo.f3158b != Integer.MIN_VALUE) {
                        this.f3139h[i].mo6082c(anchorInfo.f3158b);
                    }
                }
            } else {
                for (int i2 = 0; i2 < this.f3138g; i2++) {
                    this.f3139h[i2].mo6076a(this.f3134c, anchorInfo.f3158b);
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        this.f3154z = false;
        mo6022c();
        m2262a(anchorInfo.f3157a, state);
        if (anchorInfo.f3159c) {
            m2261a(-1);
            m2257a(recycler, this.f3142k, state);
            m2261a(1);
            this.f3142k.f2766b = anchorInfo.f3157a + this.f3142k.f2767c;
            m2257a(recycler, this.f3142k, state);
        } else {
            m2261a(1);
            m2257a(recycler, this.f3142k, state);
            m2261a(-1);
            this.f3142k.f2766b = anchorInfo.f3157a + this.f3142k.f2767c;
            m2257a(recycler, this.f3142k, state);
        }
        if (getChildCount() > 0) {
            if (this.f3134c) {
                m2265a(recycler, state, true);
                m2281b(recycler, state, false);
            } else {
                m2281b(recycler, state, true);
                m2265a(recycler, state, false);
            }
        }
        if (!state.isPreLayout()) {
            if (this.f3145n != 0 && getChildCount() > 0 && (this.f3154z || mo6016a() != null)) {
                z = true;
            }
            if (z) {
                removeCallbacks(this.f3131B);
                postOnAnimation(this.f3131B);
            }
            this.f3135d = -1;
            this.f3136e = Integer.MIN_VALUE;
        }
        this.f3146o = anchorInfo.f3159c;
        this.f3147p = mo6020b();
        this.f3148t = null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f3148t = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int a;
        if (this.f3148t != null) {
            return new SavedState(this.f3148t);
        }
        SavedState savedState = new SavedState();
        savedState.f3177h = this.f3143l;
        savedState.f3178i = this.f3146o;
        savedState.f3179j = this.f3147p;
        if (this.f3137f == null || this.f3137f.f3164a == null) {
            savedState.f3174e = 0;
        } else {
            savedState.f3175f = this.f3137f.f3164a;
            savedState.f3174e = savedState.f3175f.length;
            savedState.f3176g = this.f3137f.f3165b;
        }
        if (getChildCount() > 0) {
            m2294i();
            savedState.f3170a = this.f3146o ? m2297k() : m2299l();
            savedState.f3171b = mo6023e();
            savedState.f3172c = this.f3138g;
            savedState.f3173d = new int[this.f3138g];
            for (int i = 0; i < this.f3138g; i++) {
                if (this.f3146o) {
                    a = this.f3139h[i].mo6078b(Integer.MIN_VALUE);
                    if (a != Integer.MIN_VALUE) {
                        a -= this.f3132a.getEndAfterPadding();
                    }
                } else {
                    a = this.f3139h[i].mo6072a(Integer.MIN_VALUE);
                    if (a != Integer.MIN_VALUE) {
                        a -= this.f3132a.getStartAfterPadding();
                    }
                }
                savedState.f3173d[i] = a;
            }
        } else {
            savedState.f3170a = -1;
            savedState.f3171b = -1;
            savedState.f3172c = 0;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            m2291h();
        }
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo6015a(i, recycler, state);
    }

    public void scrollToPosition(int i) {
        if (!(this.f3148t == null || this.f3148t.f3170a == i)) {
            this.f3148t.mo6067b();
        }
        this.f3135d = i;
        this.f3136e = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.f3148t != null) {
            this.f3148t.mo6067b();
        }
        this.f3135d = i;
        this.f3136e = i2;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo6015a(i, recycler, state);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (i != this.f3145n) {
            if (i == 0 || i == 2) {
                this.f3145n = i;
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.f3140i) {
                this.f3140i = i;
                if (!(this.f3132a == null || this.f3133b == null)) {
                    OrientationHelper orientationHelper = this.f3132a;
                    this.f3132a = this.f3133b;
                    this.f3133b = orientationHelper;
                }
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (!(this.f3148t == null || this.f3148t.f3177h == z)) {
            this.f3148t.f3177h = z;
        }
        this.f3143l = z;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (i != this.f3138g) {
            invalidateSpanAssignments();
            this.f3138g = i;
            this.f3144m = new BitSet(this.f3138g);
            this.f3139h = new Span[this.f3138g];
            for (int i2 = 0; i2 < this.f3138g; i2++) {
                this.f3139h[i2] = new Span(i2);
            }
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        C03262 r0 = new LinearSmoothScroller(recyclerView.getContext()) {
            public PointF computeScrollVectorForPosition(int i) {
                int a = StaggeredGridLayoutManager.this.m2293i(i);
                if (a == 0) {
                    return null;
                }
                return StaggeredGridLayoutManager.this.f3140i == 0 ? new PointF((float) a, BitmapDescriptorFactory.HUE_RED) : new PointF(BitmapDescriptorFactory.HUE_RED, (float) a);
            }
        };
        r0.setTargetPosition(i);
        startSmoothScroll(r0);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f3148t == null;
    }
}
