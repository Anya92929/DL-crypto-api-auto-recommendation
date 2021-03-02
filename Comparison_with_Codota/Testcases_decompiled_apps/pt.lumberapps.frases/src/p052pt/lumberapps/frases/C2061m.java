package p052pt.lumberapps.frases;

import com.google.android.gms.C1204R;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: pt.lumberapps.frases.m */
public class C2061m {

    /* renamed from: a */
    private static int[] f7756a = {C1204R.drawable.f3342a, C1204R.drawable.f3345d, C1204R.drawable.f3347e, C1204R.drawable.f3349f, C1204R.drawable.f3351g, C1204R.drawable.f3354i, C1204R.drawable.f3355j, C1204R.drawable.f3357k, C1204R.drawable.f3359l, C1204R.drawable.f3360m, C1204R.drawable.f3361n, C1204R.drawable.f3363o, C1204R.drawable.f3365p, C1204R.drawable.f3367q, C1204R.drawable.f3369r, C1204R.drawable.f3371s, C1204R.drawable.f3373v, C1204R.drawable.f3376y, C1204R.drawable.f3377z, C1204R.drawable.f3343aa, C1204R.drawable.f3344cc, C1204R.drawable.f3346dd, C1204R.drawable.f3348ee, C1204R.drawable.f3350ff, C1204R.drawable.f3352gg, C1204R.drawable.f3353hh, C1204R.drawable.f3356jj, C1204R.drawable.f3358kk, C1204R.drawable.f3362nn, C1204R.drawable.f3364oo, C1204R.drawable.f3366pp, C1204R.drawable.f3368qq, C1204R.drawable.f3370rr, C1204R.drawable.f3372ss, C1204R.drawable.f3374ww, C1204R.drawable.f3375xx, C1204R.drawable.f3378zz};

    /* renamed from: b */
    private int f7757b;

    /* renamed from: c */
    private int f7758c;

    /* renamed from: d */
    private int f7759d;

    /* renamed from: e */
    private int f7760e = 0;

    /* renamed from: f */
    private int f7761f = 0;

    /* renamed from: g */
    private ArrayList f7762g = new ArrayList();

    public C2061m() {
        for (int valueOf : f7756a) {
            this.f7762g.add(Integer.valueOf(valueOf));
        }
        Collections.shuffle(this.f7762g);
        this.f7757b = this.f7762g.size() - 1;
        this.f7758c = 0;
    }

    /* renamed from: a */
    private boolean m8349a() {
        return this.f7759d == this.f7757b;
    }

    /* renamed from: a */
    public int mo10221a(int i) {
        this.f7759d = i;
        if (m8349a()) {
            this.f7759d = 0;
        } else if (this.f7760e != 0) {
            this.f7760e = 0;
        } else {
            this.f7759d++;
            this.f7760e++;
        }
        return this.f7759d;
    }

    /* renamed from: b */
    public int mo10222b(int i) {
        return ((Integer) this.f7762g.get(i)).intValue();
    }
}
