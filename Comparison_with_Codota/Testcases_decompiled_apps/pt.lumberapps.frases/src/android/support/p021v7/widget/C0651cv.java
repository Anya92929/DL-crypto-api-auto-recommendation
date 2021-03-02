package android.support.p021v7.widget;

/* renamed from: android.support.v7.widget.cv */
class C0651cv {

    /* renamed from: a */
    private int f1581a = 0;

    /* renamed from: b */
    private int f1582b = 0;

    /* renamed from: c */
    private int f1583c = Integer.MIN_VALUE;

    /* renamed from: d */
    private int f1584d = Integer.MIN_VALUE;

    /* renamed from: e */
    private int f1585e = 0;

    /* renamed from: f */
    private int f1586f = 0;

    /* renamed from: g */
    private boolean f1587g = false;

    /* renamed from: h */
    private boolean f1588h = false;

    C0651cv() {
    }

    /* renamed from: a */
    public int mo3268a() {
        return this.f1581a;
    }

    /* renamed from: a */
    public void mo3269a(int i, int i2) {
        this.f1583c = i;
        this.f1584d = i2;
        this.f1588h = true;
        if (this.f1587g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1581a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1582b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1581a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1582b = i2;
        }
    }

    /* renamed from: a */
    public void mo3270a(boolean z) {
        if (z != this.f1587g) {
            this.f1587g = z;
            if (!this.f1588h) {
                this.f1581a = this.f1585e;
                this.f1582b = this.f1586f;
            } else if (z) {
                this.f1581a = this.f1584d != Integer.MIN_VALUE ? this.f1584d : this.f1585e;
                this.f1582b = this.f1583c != Integer.MIN_VALUE ? this.f1583c : this.f1586f;
            } else {
                this.f1581a = this.f1583c != Integer.MIN_VALUE ? this.f1583c : this.f1585e;
                this.f1582b = this.f1584d != Integer.MIN_VALUE ? this.f1584d : this.f1586f;
            }
        }
    }

    /* renamed from: b */
    public int mo3271b() {
        return this.f1582b;
    }

    /* renamed from: b */
    public void mo3272b(int i, int i2) {
        this.f1588h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1585e = i;
            this.f1581a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1586f = i2;
            this.f1582b = i2;
        }
    }

    /* renamed from: c */
    public int mo3273c() {
        return this.f1587g ? this.f1582b : this.f1581a;
    }

    /* renamed from: d */
    public int mo3274d() {
        return this.f1587g ? this.f1581a : this.f1582b;
    }
}
