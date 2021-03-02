package android.support.p003v7.widget;

import android.support.p003v7.widget.AdapterHelper;
import java.util.List;

/* renamed from: android.support.v7.widget.OpReorderer */
class OpReorderer {

    /* renamed from: a */
    final Callback f2879a;

    /* renamed from: android.support.v7.widget.OpReorderer$Callback */
    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.f2879a = callback;
    }

    /* renamed from: a */
    private void m1940a(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        switch (updateOp2.f2646a) {
            case 0:
                m1942c(list, i, updateOp, i2, updateOp2);
                return;
            case 1:
                mo5452a(list, i, updateOp, i2, updateOp2);
                return;
            case 2:
                mo5453b(list, i, updateOp, i2, updateOp2);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private int m1941b(List<AdapterHelper.UpdateOp> list) {
        boolean z;
        boolean z2 = false;
        int size = list.size() - 1;
        while (size >= 0) {
            if (list.get(size).f2646a != 3) {
                z = true;
            } else if (z2) {
                return size;
            } else {
                z = z2;
            }
            size--;
            z2 = z;
        }
        return -1;
    }

    /* renamed from: c */
    private void m1942c(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = 0;
        if (updateOp.f2649d < updateOp2.f2647b) {
            i3 = -1;
        }
        if (updateOp.f2647b < updateOp2.f2647b) {
            i3++;
        }
        if (updateOp2.f2647b <= updateOp.f2647b) {
            updateOp.f2647b += updateOp2.f2649d;
        }
        if (updateOp2.f2647b <= updateOp.f2649d) {
            updateOp.f2649d += updateOp2.f2649d;
        }
        updateOp2.f2647b = i3 + updateOp2.f2647b;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5451a(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int b = m1941b(list);
            if (b != -1) {
                m1940a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5452a(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        AdapterHelper.UpdateOp updateOp3;
        boolean z2 = false;
        if (updateOp.f2647b < updateOp.f2649d) {
            z = updateOp2.f2647b == updateOp.f2647b && updateOp2.f2649d == updateOp.f2649d - updateOp.f2647b;
        } else if (updateOp2.f2647b == updateOp.f2649d + 1 && updateOp2.f2649d == updateOp.f2647b - updateOp.f2649d) {
            z2 = true;
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (updateOp.f2649d < updateOp2.f2647b) {
            updateOp2.f2647b--;
        } else if (updateOp.f2649d < updateOp2.f2647b + updateOp2.f2649d) {
            updateOp2.f2649d--;
            updateOp.f2646a = 1;
            updateOp.f2649d = 1;
            if (updateOp2.f2649d == 0) {
                list.remove(i2);
                this.f2879a.recycleUpdateOp(updateOp2);
                return;
            }
            return;
        }
        if (updateOp.f2647b <= updateOp2.f2647b) {
            updateOp2.f2647b++;
            updateOp3 = null;
        } else if (updateOp.f2647b < updateOp2.f2647b + updateOp2.f2649d) {
            updateOp3 = this.f2879a.obtainUpdateOp(1, updateOp.f2647b + 1, (updateOp2.f2647b + updateOp2.f2649d) - updateOp.f2647b, (Object) null);
            updateOp2.f2649d = updateOp.f2647b - updateOp2.f2647b;
        } else {
            updateOp3 = null;
        }
        if (z) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.f2879a.recycleUpdateOp(updateOp);
            return;
        }
        if (z2) {
            if (updateOp3 != null) {
                if (updateOp.f2647b > updateOp3.f2647b) {
                    updateOp.f2647b -= updateOp3.f2649d;
                }
                if (updateOp.f2649d > updateOp3.f2647b) {
                    updateOp.f2649d -= updateOp3.f2649d;
                }
            }
            if (updateOp.f2647b > updateOp2.f2647b) {
                updateOp.f2647b -= updateOp2.f2649d;
            }
            if (updateOp.f2649d > updateOp2.f2647b) {
                updateOp.f2649d -= updateOp2.f2649d;
            }
        } else {
            if (updateOp3 != null) {
                if (updateOp.f2647b >= updateOp3.f2647b) {
                    updateOp.f2647b -= updateOp3.f2649d;
                }
                if (updateOp.f2649d >= updateOp3.f2647b) {
                    updateOp.f2649d -= updateOp3.f2649d;
                }
            }
            if (updateOp.f2647b >= updateOp2.f2647b) {
                updateOp.f2647b -= updateOp2.f2649d;
            }
            if (updateOp.f2649d >= updateOp2.f2647b) {
                updateOp.f2649d -= updateOp2.f2649d;
            }
        }
        list.set(i, updateOp2);
        if (updateOp.f2647b != updateOp.f2649d) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOp3 != null) {
            list.add(i, updateOp3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5453b(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp updateOp3;
        AdapterHelper.UpdateOp updateOp4 = null;
        if (updateOp.f2649d < updateOp2.f2647b) {
            updateOp2.f2647b--;
            updateOp3 = null;
        } else if (updateOp.f2649d < updateOp2.f2647b + updateOp2.f2649d) {
            updateOp2.f2649d--;
            updateOp3 = this.f2879a.obtainUpdateOp(2, updateOp.f2647b, 1, updateOp2.f2648c);
        } else {
            updateOp3 = null;
        }
        if (updateOp.f2647b <= updateOp2.f2647b) {
            updateOp2.f2647b++;
        } else if (updateOp.f2647b < updateOp2.f2647b + updateOp2.f2649d) {
            int i3 = (updateOp2.f2647b + updateOp2.f2649d) - updateOp.f2647b;
            updateOp4 = this.f2879a.obtainUpdateOp(2, updateOp.f2647b + 1, i3, updateOp2.f2648c);
            updateOp2.f2649d -= i3;
        }
        list.set(i2, updateOp);
        if (updateOp2.f2649d > 0) {
            list.set(i, updateOp2);
        } else {
            list.remove(i);
            this.f2879a.recycleUpdateOp(updateOp2);
        }
        if (updateOp3 != null) {
            list.add(i, updateOp3);
        }
        if (updateOp4 != null) {
            list.add(i, updateOp4);
        }
    }
}
