package android.support.p009v4.view;

import android.support.p009v4.app.NotificationCompat;
import android.view.KeyEvent;

/* renamed from: android.support.v4.view.w */
class C0353w implements C0356z {
    C0353w() {
    }

    /* renamed from: a */
    private static int m1343a(int i, int i2, int i3, int i4, int i5) {
        boolean z = true;
        boolean z2 = (i2 & i3) != 0;
        int i6 = i4 | i5;
        if ((i2 & i6) == 0) {
            z = false;
        }
        if (!z2) {
            return z ? i & (i3 ^ -1) : i;
        }
        if (!z) {
            return i & (i6 ^ -1);
        }
        throw new IllegalArgumentException("bad arguments");
    }

    /* renamed from: a */
    public int mo1629a(int i) {
        int i2 = (i & 192) != 0 ? i | 1 : i;
        if ((i2 & 48) != 0) {
            i2 |= 2;
        }
        return i2 & 247;
    }

    /* renamed from: a */
    public void mo1630a(KeyEvent keyEvent) {
    }

    /* renamed from: a */
    public boolean mo1631a(int i, int i2) {
        return m1343a(m1343a(mo1629a(i) & 247, i2, 1, 64, NotificationCompat.FLAG_HIGH_PRIORITY), i2, 2, 16, 32) == i2;
    }

    /* renamed from: b */
    public boolean mo1632b(int i) {
        return (mo1629a(i) & 247) == 0;
    }

    /* renamed from: b */
    public boolean mo1633b(KeyEvent keyEvent) {
        return false;
    }
}
