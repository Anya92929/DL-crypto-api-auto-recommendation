package android.support.p003v7.widget;

import android.support.p000v4.util.Pools;
import android.support.p003v7.widget.OpReorderer;
import android.support.p003v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.AdapterHelper */
class AdapterHelper implements OpReorderer.Callback {

    /* renamed from: a */
    final ArrayList<UpdateOp> f2639a;

    /* renamed from: b */
    final ArrayList<UpdateOp> f2640b;

    /* renamed from: c */
    final Callback f2641c;

    /* renamed from: d */
    Runnable f2642d;

    /* renamed from: e */
    final boolean f2643e;

    /* renamed from: f */
    final OpReorderer f2644f;

    /* renamed from: g */
    private Pools.Pool<UpdateOp> f2645g;

    /* renamed from: android.support.v7.widget.AdapterHelper$Callback */
    interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i2, Object obj);

        void offsetPositionsForAdd(int i, int i2);

        void offsetPositionsForMove(int i, int i2);

        void offsetPositionsForRemovingInvisible(int i, int i2);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    /* renamed from: android.support.v7.widget.AdapterHelper$UpdateOp */
    class UpdateOp {

        /* renamed from: a */
        int f2646a;

        /* renamed from: b */
        int f2647b;

        /* renamed from: c */
        Object f2648c;

        /* renamed from: d */
        int f2649d;

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.f2646a = i;
            this.f2647b = i2;
            this.f2649d = i3;
            this.f2648c = obj;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo5092a() {
            switch (this.f2646a) {
                case 0:
                    return "add";
                case 1:
                    return "rm";
                case 2:
                    return "up";
                case 3:
                    return "mv";
                default:
                    return "??";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            if (this.f2646a != updateOp.f2646a) {
                return false;
            }
            if (this.f2646a == 3 && Math.abs(this.f2649d - this.f2647b) == 1 && this.f2649d == updateOp.f2647b && this.f2647b == updateOp.f2649d) {
                return true;
            }
            if (this.f2649d != updateOp.f2649d) {
                return false;
            }
            if (this.f2647b != updateOp.f2647b) {
                return false;
            }
            return this.f2648c != null ? this.f2648c.equals(updateOp.f2648c) : updateOp.f2648c == null;
        }

        public int hashCode() {
            return (((this.f2646a * 31) + this.f2647b) * 31) + this.f2649d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + mo5092a() + ",s:" + this.f2647b + "c:" + this.f2649d + ",p:" + this.f2648c + "]";
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    AdapterHelper(Callback callback, boolean z) {
        this.f2645g = new Pools.SimplePool(30);
        this.f2639a = new ArrayList<>();
        this.f2640b = new ArrayList<>();
        this.f2641c = callback;
        this.f2643e = z;
        this.f2644f = new OpReorderer(this);
    }

    /* renamed from: a */
    private void m1713a(UpdateOp updateOp) {
        m1720f(updateOp);
    }

    /* renamed from: b */
    private void m1714b(UpdateOp updateOp) {
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4 = updateOp.f2647b;
        int i5 = updateOp.f2647b + updateOp.f2649d;
        char c = 65535;
        int i6 = updateOp.f2647b;
        int i7 = 0;
        while (i6 < i5) {
            if (this.f2641c.findViewHolder(i6) != null || m1715b(i6)) {
                if (c == 0) {
                    m1718d(obtainUpdateOp(1, i4, i7, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c = 1;
            } else {
                if (c == 1) {
                    m1720f(obtainUpdateOp(1, i4, i7, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 = i6 - i7;
                i = i5 - i7;
                i2 = 1;
            } else {
                int i8 = i6;
                i = i5;
                i2 = i7 + 1;
                i3 = i8;
            }
            i7 = i2;
            i5 = i;
            i6 = i3 + 1;
        }
        if (i7 != updateOp.f2649d) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(1, i4, i7, (Object) null);
        }
        if (c == 0) {
            m1718d(updateOp);
        } else {
            m1720f(updateOp);
        }
    }

    /* renamed from: b */
    private boolean m1715b(int i) {
        int size = this.f2640b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f2640b.get(i2);
            if (updateOp.f2646a == 3) {
                if (mo5069a(updateOp.f2649d, i2 + 1) == i) {
                    return true;
                }
            } else if (updateOp.f2646a == 0) {
                int i3 = updateOp.f2647b + updateOp.f2649d;
                for (int i4 = updateOp.f2647b; i4 < i3; i4++) {
                    if (mo5069a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m1716c(UpdateOp updateOp) {
        int i;
        int i2;
        boolean z;
        int i3 = updateOp.f2647b;
        int i4 = updateOp.f2647b + updateOp.f2649d;
        int i5 = updateOp.f2647b;
        boolean z2 = true;
        int i6 = 0;
        while (i5 < i4) {
            if (this.f2641c.findViewHolder(i5) != null || m1715b(i5)) {
                if (!z2) {
                    m1718d(obtainUpdateOp(2, i3, i6, updateOp.f2648c));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                z = true;
            } else {
                if (z2) {
                    m1720f(obtainUpdateOp(2, i3, i6, updateOp.f2648c));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                z = false;
            }
            i5++;
            boolean z3 = z;
            i6 = i2 + 1;
            i3 = i;
            z2 = z3;
        }
        if (i6 != updateOp.f2649d) {
            Object obj = updateOp.f2648c;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i3, i6, obj);
        }
        if (!z2) {
            m1718d(updateOp);
        } else {
            m1720f(updateOp);
        }
    }

    /* renamed from: d */
    private int m1717d(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        for (int size = this.f2640b.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.f2640b.get(size);
            if (updateOp.f2646a == 3) {
                if (updateOp.f2647b < updateOp.f2649d) {
                    i3 = updateOp.f2647b;
                    i4 = updateOp.f2649d;
                } else {
                    i3 = updateOp.f2649d;
                    i4 = updateOp.f2647b;
                }
                if (i6 < i3 || i6 > i4) {
                    if (i6 < updateOp.f2647b) {
                        if (i2 == 0) {
                            updateOp.f2647b++;
                            updateOp.f2649d++;
                            i5 = i6;
                        } else if (i2 == 1) {
                            updateOp.f2647b--;
                            updateOp.f2649d--;
                        }
                    }
                    i5 = i6;
                } else if (i3 == updateOp.f2647b) {
                    if (i2 == 0) {
                        updateOp.f2649d++;
                    } else if (i2 == 1) {
                        updateOp.f2649d--;
                    }
                    i5 = i6 + 1;
                } else {
                    if (i2 == 0) {
                        updateOp.f2647b++;
                    } else if (i2 == 1) {
                        updateOp.f2647b--;
                    }
                    i5 = i6 - 1;
                }
                i6 = i5;
            } else if (updateOp.f2647b <= i6) {
                if (updateOp.f2646a == 0) {
                    i6 -= updateOp.f2649d;
                } else if (updateOp.f2646a == 1) {
                    i6 += updateOp.f2649d;
                }
            } else if (i2 == 0) {
                updateOp.f2647b++;
            } else if (i2 == 1) {
                updateOp.f2647b--;
            }
        }
        for (int size2 = this.f2640b.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.f2640b.get(size2);
            if (updateOp2.f2646a == 3) {
                if (updateOp2.f2649d == updateOp2.f2647b || updateOp2.f2649d < 0) {
                    this.f2640b.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.f2649d <= 0) {
                this.f2640b.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i6;
    }

    /* renamed from: d */
    private void m1718d(UpdateOp updateOp) {
        int i;
        boolean z;
        if (updateOp.f2646a == 0 || updateOp.f2646a == 3) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d = m1717d(updateOp.f2647b, updateOp.f2646a);
        int i2 = updateOp.f2647b;
        switch (updateOp.f2646a) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i3 = 1;
        int i4 = d;
        int i5 = i2;
        for (int i6 = 1; i6 < updateOp.f2649d; i6++) {
            int d2 = m1717d(updateOp.f2647b + (i * i6), updateOp.f2646a);
            switch (updateOp.f2646a) {
                case 1:
                    if (d2 != i4) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 2:
                    if (d2 != i4 + 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                default:
                    z = false;
                    break;
            }
            if (z) {
                i3++;
            } else {
                UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.f2646a, i4, i3, updateOp.f2648c);
                mo5071a(obtainUpdateOp, i5);
                recycleUpdateOp(obtainUpdateOp);
                if (updateOp.f2646a == 2) {
                    i5 += i3;
                }
                i3 = 1;
                i4 = d2;
            }
        }
        Object obj = updateOp.f2648c;
        recycleUpdateOp(updateOp);
        if (i3 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.f2646a, i4, i3, obj);
            mo5071a(obtainUpdateOp2, i5);
            recycleUpdateOp(obtainUpdateOp2);
        }
    }

    /* renamed from: e */
    private void m1719e(UpdateOp updateOp) {
        m1720f(updateOp);
    }

    /* renamed from: f */
    private void m1720f(UpdateOp updateOp) {
        this.f2640b.add(updateOp);
        switch (updateOp.f2646a) {
            case 0:
                this.f2641c.offsetPositionsForAdd(updateOp.f2647b, updateOp.f2649d);
                return;
            case 1:
                this.f2641c.offsetPositionsForRemovingLaidOutOrNewView(updateOp.f2647b, updateOp.f2649d);
                return;
            case 2:
                this.f2641c.markViewHoldersUpdated(updateOp.f2647b, updateOp.f2649d, updateOp.f2648c);
                return;
            case 3:
                this.f2641c.offsetPositionsForMove(updateOp.f2647b, updateOp.f2649d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5068a(int i) {
        return mo5069a(i, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5069a(int i, int i2) {
        int size = this.f2640b.size();
        int i3 = i;
        while (i2 < size) {
            UpdateOp updateOp = this.f2640b.get(i2);
            if (updateOp.f2646a == 3) {
                if (updateOp.f2647b == i3) {
                    i3 = updateOp.f2649d;
                } else {
                    if (updateOp.f2647b < i3) {
                        i3--;
                    }
                    if (updateOp.f2649d <= i3) {
                        i3++;
                    }
                }
            } else if (updateOp.f2647b > i3) {
                continue;
            } else if (updateOp.f2646a == 1) {
                if (i3 < updateOp.f2647b + updateOp.f2649d) {
                    return -1;
                }
                i3 -= updateOp.f2649d;
            } else if (updateOp.f2646a == 0) {
                i3 += updateOp.f2649d;
            }
            i2++;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5070a() {
        mo5072a((List<UpdateOp>) this.f2639a);
        mo5072a((List<UpdateOp>) this.f2640b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5071a(UpdateOp updateOp, int i) {
        this.f2641c.onDispatchFirstPass(updateOp);
        switch (updateOp.f2646a) {
            case 1:
                this.f2641c.offsetPositionsForRemovingInvisible(i, updateOp.f2649d);
                return;
            case 2:
                this.f2641c.markViewHoldersUpdated(i, updateOp.f2649d, updateOp.f2648c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5072a(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp(list.get(i));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5073a(int i, int i2, int i3) {
        boolean z = true;
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f2639a.add(obtainUpdateOp(3, i, i2, (Object) null));
        if (this.f2639a.size() != 1) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5074a(int i, int i2, Object obj) {
        this.f2639a.add(obtainUpdateOp(2, i, i2, obj));
        return this.f2639a.size() == 1;
    }

    public int applyPendingUpdatesToPosition(int i) {
        int size = this.f2639a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.f2639a.get(i3);
            switch (updateOp.f2646a) {
                case 0:
                    if (updateOp.f2647b > i2) {
                        break;
                    } else {
                        i2 += updateOp.f2649d;
                        break;
                    }
                case 1:
                    if (updateOp.f2647b <= i2) {
                        if (updateOp.f2647b + updateOp.f2649d <= i2) {
                            i2 -= updateOp.f2649d;
                            break;
                        } else {
                            return -1;
                        }
                    } else {
                        continue;
                    }
                case 3:
                    if (updateOp.f2647b != i2) {
                        if (updateOp.f2647b < i2) {
                            i2--;
                        }
                        if (updateOp.f2649d > i2) {
                            break;
                        } else {
                            i2++;
                            break;
                        }
                    } else {
                        i2 = updateOp.f2649d;
                        break;
                    }
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5076b() {
        this.f2644f.mo5451a(this.f2639a);
        int size = this.f2639a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.f2639a.get(i);
            switch (updateOp.f2646a) {
                case 0:
                    m1719e(updateOp);
                    break;
                case 1:
                    m1714b(updateOp);
                    break;
                case 2:
                    m1716c(updateOp);
                    break;
                case 3:
                    m1713a(updateOp);
                    break;
            }
            if (this.f2642d != null) {
                this.f2642d.run();
            }
        }
        this.f2639a.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5077b(int i, int i2) {
        this.f2639a.add(obtainUpdateOp(0, i, i2, (Object) null));
        return this.f2639a.size() == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5078c() {
        int size = this.f2640b.size();
        for (int i = 0; i < size; i++) {
            this.f2641c.onDispatchSecondPass(this.f2640b.get(i));
        }
        mo5072a((List<UpdateOp>) this.f2640b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5079c(int i, int i2) {
        this.f2639a.add(obtainUpdateOp(1, i, i2, (Object) null));
        return this.f2639a.size() == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5080d() {
        return this.f2639a.size() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5081e() {
        mo5078c();
        int size = this.f2639a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.f2639a.get(i);
            switch (updateOp.f2646a) {
                case 0:
                    this.f2641c.onDispatchSecondPass(updateOp);
                    this.f2641c.offsetPositionsForAdd(updateOp.f2647b, updateOp.f2649d);
                    break;
                case 1:
                    this.f2641c.onDispatchSecondPass(updateOp);
                    this.f2641c.offsetPositionsForRemovingInvisible(updateOp.f2647b, updateOp.f2649d);
                    break;
                case 2:
                    this.f2641c.onDispatchSecondPass(updateOp);
                    this.f2641c.markViewHoldersUpdated(updateOp.f2647b, updateOp.f2649d, updateOp.f2648c);
                    break;
                case 3:
                    this.f2641c.onDispatchSecondPass(updateOp);
                    this.f2641c.offsetPositionsForMove(updateOp.f2647b, updateOp.f2649d);
                    break;
            }
            if (this.f2642d != null) {
                this.f2642d.run();
            }
        }
        mo5072a((List<UpdateOp>) this.f2639a);
    }

    public UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        UpdateOp acquire = this.f2645g.acquire();
        if (acquire == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        acquire.f2646a = i;
        acquire.f2647b = i2;
        acquire.f2649d = i3;
        acquire.f2648c = obj;
        return acquire;
    }

    public void recycleUpdateOp(UpdateOp updateOp) {
        if (!this.f2643e) {
            updateOp.f2648c = null;
            this.f2645g.release(updateOp);
        }
    }
}
