package android.support.p003v7.internal.widget;

/* renamed from: android.support.v7.internal.widget.RtlSpacingHelper */
public class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;

    /* renamed from: a */
    private int f2334a = 0;

    /* renamed from: b */
    private int f2335b = 0;

    /* renamed from: c */
    private int f2336c = Integer.MIN_VALUE;

    /* renamed from: d */
    private int f2337d = Integer.MIN_VALUE;

    /* renamed from: e */
    private int f2338e = 0;

    /* renamed from: f */
    private int f2339f = 0;

    /* renamed from: g */
    private boolean f2340g = false;

    /* renamed from: h */
    private boolean f2341h = false;

    public int getEnd() {
        return this.f2340g ? this.f2334a : this.f2335b;
    }

    public int getLeft() {
        return this.f2334a;
    }

    public int getRight() {
        return this.f2335b;
    }

    public int getStart() {
        return this.f2340g ? this.f2335b : this.f2334a;
    }

    public void setAbsolute(int i, int i2) {
        this.f2341h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2338e = i;
            this.f2334a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2339f = i2;
            this.f2335b = i2;
        }
    }

    public void setDirection(boolean z) {
        if (z != this.f2340g) {
            this.f2340g = z;
            if (!this.f2341h) {
                this.f2334a = this.f2338e;
                this.f2335b = this.f2339f;
            } else if (z) {
                this.f2334a = this.f2337d != Integer.MIN_VALUE ? this.f2337d : this.f2338e;
                this.f2335b = this.f2336c != Integer.MIN_VALUE ? this.f2336c : this.f2339f;
            } else {
                this.f2334a = this.f2336c != Integer.MIN_VALUE ? this.f2336c : this.f2338e;
                this.f2335b = this.f2337d != Integer.MIN_VALUE ? this.f2337d : this.f2339f;
            }
        }
    }

    public void setRelative(int i, int i2) {
        this.f2336c = i;
        this.f2337d = i2;
        this.f2341h = true;
        if (this.f2340g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2334a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2335b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2334a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2335b = i2;
        }
    }
}
