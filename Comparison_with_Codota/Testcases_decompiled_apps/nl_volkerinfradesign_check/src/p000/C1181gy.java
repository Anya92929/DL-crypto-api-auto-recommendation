package p000;

import android.support.p001v4.widget.ExploreByTouchHelper;

/* renamed from: gy */
public class C1181gy {

    /* renamed from: a */
    private int f4203a = 0;

    /* renamed from: b */
    private int f4204b = 0;

    /* renamed from: c */
    private int f4205c = ExploreByTouchHelper.INVALID_ID;

    /* renamed from: d */
    private int f4206d = ExploreByTouchHelper.INVALID_ID;

    /* renamed from: e */
    private int f4207e = 0;

    /* renamed from: f */
    private int f4208f = 0;

    /* renamed from: g */
    private boolean f4209g = false;

    /* renamed from: h */
    private boolean f4210h = false;

    /* renamed from: a */
    public int mo8251a() {
        return this.f4203a;
    }

    /* renamed from: b */
    public int mo8254b() {
        return this.f4204b;
    }

    /* renamed from: c */
    public int mo8256c() {
        return this.f4209g ? this.f4204b : this.f4203a;
    }

    /* renamed from: d */
    public int mo8257d() {
        return this.f4209g ? this.f4203a : this.f4204b;
    }

    /* renamed from: a */
    public void mo8252a(int i, int i2) {
        this.f4205c = i;
        this.f4206d = i2;
        this.f4210h = true;
        if (this.f4209g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f4203a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f4204b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f4203a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f4204b = i2;
        }
    }

    /* renamed from: b */
    public void mo8255b(int i, int i2) {
        this.f4210h = false;
        if (i != Integer.MIN_VALUE) {
            this.f4207e = i;
            this.f4203a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f4208f = i2;
            this.f4204b = i2;
        }
    }

    /* renamed from: a */
    public void mo8253a(boolean z) {
        if (z != this.f4209g) {
            this.f4209g = z;
            if (!this.f4210h) {
                this.f4203a = this.f4207e;
                this.f4204b = this.f4208f;
            } else if (z) {
                this.f4203a = this.f4206d != Integer.MIN_VALUE ? this.f4206d : this.f4207e;
                this.f4204b = this.f4205c != Integer.MIN_VALUE ? this.f4205c : this.f4208f;
            } else {
                this.f4203a = this.f4205c != Integer.MIN_VALUE ? this.f4205c : this.f4207e;
                this.f4204b = this.f4206d != Integer.MIN_VALUE ? this.f4206d : this.f4208f;
            }
        }
    }
}
