package android.support.p003v7.widget;

import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.ChildHelper */
class ChildHelper {

    /* renamed from: a */
    final Callback f2712a;

    /* renamed from: b */
    final Bucket f2713b = new Bucket();

    /* renamed from: c */
    final List<View> f2714c = new ArrayList();

    /* renamed from: android.support.v7.widget.ChildHelper$Bucket */
    class Bucket {

        /* renamed from: a */
        long f2715a = 0;

        /* renamed from: b */
        Bucket f2716b;

        Bucket() {
        }

        /* renamed from: b */
        private void m1787b() {
            if (this.f2716b == null) {
                this.f2716b = new Bucket();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5206a() {
            this.f2715a = 0;
            if (this.f2716b != null) {
                this.f2716b.mo5206a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5207a(int i) {
            if (i >= 64) {
                m1787b();
                this.f2716b.mo5207a(i - 64);
                return;
            }
            this.f2715a |= 1 << i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5208a(int i, boolean z) {
            if (i >= 64) {
                m1787b();
                this.f2716b.mo5208a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2715a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f2715a = (((j ^ -1) & this.f2715a) << 1) | (this.f2715a & j);
            if (z) {
                mo5207a(i);
            } else {
                mo5209b(i);
            }
            if (z2 || this.f2716b != null) {
                m1787b();
                this.f2716b.mo5208a(0, z2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5209b(int i) {
            if (i < 64) {
                this.f2715a &= (1 << i) ^ -1;
            } else if (this.f2716b != null) {
                this.f2716b.mo5209b(i - 64);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo5210c(int i) {
            if (i < 64) {
                return (this.f2715a & (1 << i)) != 0;
            }
            m1787b();
            return this.f2716b.mo5210c(i - 64);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo5211d(int i) {
            if (i >= 64) {
                m1787b();
                return this.f2716b.mo5211d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2715a & j) != 0;
            this.f2715a &= j ^ -1;
            long j2 = j - 1;
            this.f2715a = Long.rotateRight((j2 ^ -1) & this.f2715a, 1) | (this.f2715a & j2);
            if (this.f2716b == null) {
                return z;
            }
            if (this.f2716b.mo5210c(0)) {
                mo5207a(63);
            }
            this.f2716b.mo5211d(0);
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public int mo5212e(int i) {
            return this.f2716b == null ? i >= 64 ? Long.bitCount(this.f2715a) : Long.bitCount(this.f2715a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f2715a & ((1 << i) - 1)) : this.f2716b.mo5212e(i - 64) + Long.bitCount(this.f2715a);
        }

        public String toString() {
            return this.f2716b == null ? Long.toBinaryString(this.f2715a) : this.f2716b.toString() + "xx" + Long.toBinaryString(this.f2715a);
        }
    }

    /* renamed from: android.support.v7.widget.ChildHelper$Callback */
    interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    ChildHelper(Callback callback) {
        this.f2712a = callback;
    }

    /* renamed from: e */
    private int m1768e(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.f2712a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int e = i - (i2 - this.f2713b.mo5212e(i2));
            if (e == 0) {
                while (this.f2713b.mo5210c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    /* renamed from: f */
    private void m1769f(View view) {
        this.f2714c.add(view);
        this.f2712a.onEnteredHiddenState(view);
    }

    /* renamed from: g */
    private boolean m1770g(View view) {
        if (!this.f2714c.remove(view)) {
            return false;
        }
        this.f2712a.onLeftHiddenState(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5189a(int i, int i2) {
        int size = this.f2714c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f2714c.get(i3);
            RecyclerView.ViewHolder childViewHolder = this.f2712a.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.mo5930j() && (i2 == -1 || childViewHolder.getItemViewType() == i2)) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5190a() {
        this.f2713b.mo5206a();
        for (int size = this.f2714c.size() - 1; size >= 0; size--) {
            this.f2712a.onLeftHiddenState(this.f2714c.get(size));
            this.f2714c.remove(size);
        }
        this.f2712a.removeAllViews();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5191a(int i) {
        int e = m1768e(i);
        View childAt = this.f2712a.getChildAt(e);
        if (childAt != null) {
            if (this.f2713b.mo5211d(e)) {
                m1770g(childAt);
            }
            this.f2712a.removeViewAt(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5192a(View view) {
        int indexOfChild = this.f2712a.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.f2713b.mo5211d(indexOfChild)) {
                m1770g(view);
            }
            this.f2712a.removeViewAt(indexOfChild);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5193a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int childCount = i < 0 ? this.f2712a.getChildCount() : m1768e(i);
        this.f2713b.mo5208a(childCount, z);
        if (z) {
            m1769f(view);
        }
        this.f2712a.attachViewToParent(view, childCount, layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5194a(View view, int i, boolean z) {
        int childCount = i < 0 ? this.f2712a.getChildCount() : m1768e(i);
        this.f2713b.mo5208a(childCount, z);
        if (z) {
            m1769f(view);
        }
        this.f2712a.addView(view, childCount);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5195a(View view, boolean z) {
        mo5194a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5196b() {
        return this.f2712a.getChildCount() - this.f2714c.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5197b(View view) {
        int indexOfChild = this.f2712a.indexOfChild(view);
        if (indexOfChild != -1 && !this.f2713b.mo5210c(indexOfChild)) {
            return indexOfChild - this.f2713b.mo5212e(indexOfChild);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo5198b(int i) {
        return this.f2712a.getChildAt(m1768e(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo5199c() {
        return this.f2712a.getChildCount();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo5200c(int i) {
        return this.f2712a.getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5201c(View view) {
        return this.f2714c.contains(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5202d(int i) {
        int e = m1768e(i);
        this.f2713b.mo5211d(e);
        this.f2712a.detachViewFromParent(e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5203d(View view) {
        int indexOfChild = this.f2712a.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f2713b.mo5207a(indexOfChild);
        m1769f(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5204e(View view) {
        int indexOfChild = this.f2712a.indexOfChild(view);
        if (indexOfChild == -1) {
            if (m1770g(view)) {
            }
            return true;
        } else if (!this.f2713b.mo5210c(indexOfChild)) {
            return false;
        } else {
            this.f2713b.mo5211d(indexOfChild);
            if (!m1770g(view)) {
            }
            this.f2712a.removeViewAt(indexOfChild);
            return true;
        }
    }

    public String toString() {
        return this.f2713b.toString() + ", hidden list:" + this.f2714c.size();
    }
}
