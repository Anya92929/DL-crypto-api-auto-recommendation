package p052pt.lumberapps.frases;

/* renamed from: pt.lumberapps.frases.n */
public class C2062n {

    /* renamed from: a */
    private int f7763a;

    /* renamed from: b */
    private int f7764b;

    /* renamed from: c */
    private int f7765c;

    public C2062n() {
    }

    public C2062n(int i, int i2) {
        this.f7763a = i2;
        this.f7764b = i;
    }

    /* renamed from: a */
    private boolean m8352a() {
        return this.f7765c >= this.f7763a;
    }

    /* renamed from: b */
    private boolean m8353b() {
        return this.f7765c <= this.f7764b;
    }

    /* renamed from: a */
    public void mo10223a(int i) {
        this.f7763a = i;
    }

    /* renamed from: b */
    public int mo10224b(int i) {
        this.f7765c = i;
        if (m8352a()) {
            this.f7765c = 0;
        } else {
            this.f7765c++;
        }
        return this.f7765c;
    }

    /* renamed from: c */
    public int mo10225c(int i) {
        this.f7765c = i;
        if (m8353b()) {
            this.f7765c = this.f7763a;
        } else {
            this.f7765c--;
        }
        return this.f7765c;
    }
}
