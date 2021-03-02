package android.support.p007a.p008a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.a.a.s */
class C0023s extends Drawable.ConstantState {

    /* renamed from: a */
    int f132a;

    /* renamed from: b */
    C0022r f133b;

    /* renamed from: c */
    ColorStateList f134c;

    /* renamed from: d */
    PorterDuff.Mode f135d;

    /* renamed from: e */
    boolean f136e;

    /* renamed from: f */
    Bitmap f137f;

    /* renamed from: g */
    ColorStateList f138g;

    /* renamed from: h */
    PorterDuff.Mode f139h;

    /* renamed from: i */
    int f140i;

    /* renamed from: j */
    boolean f141j;

    /* renamed from: k */
    boolean f142k;

    /* renamed from: l */
    Paint f143l;

    public C0023s() {
        this.f134c = null;
        this.f135d = C0016l.f77b;
        this.f133b = new C0022r();
    }

    public C0023s(C0023s sVar) {
        this.f134c = null;
        this.f135d = C0016l.f77b;
        if (sVar != null) {
            this.f132a = sVar.f132a;
            this.f133b = new C0022r(sVar.f133b);
            if (sVar.f133b.f128m != null) {
                Paint unused = this.f133b.f128m = new Paint(sVar.f133b.f128m);
            }
            if (sVar.f133b.f127l != null) {
                Paint unused2 = this.f133b.f127l = new Paint(sVar.f133b.f127l);
            }
            this.f134c = sVar.f134c;
            this.f135d = sVar.f135d;
            this.f136e = sVar.f136e;
        }
    }

    /* renamed from: a */
    public Paint mo111a(ColorFilter colorFilter) {
        if (!mo114a() && colorFilter == null) {
            return null;
        }
        if (this.f143l == null) {
            this.f143l = new Paint();
            this.f143l.setFilterBitmap(true);
        }
        this.f143l.setAlpha(this.f133b.mo106a());
        this.f143l.setColorFilter(colorFilter);
        return this.f143l;
    }

    /* renamed from: a */
    public void mo112a(int i, int i2) {
        this.f137f.eraseColor(0);
        this.f133b.mo109a(new Canvas(this.f137f), i, i2, (ColorFilter) null);
    }

    /* renamed from: a */
    public void mo113a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        canvas.drawBitmap(this.f137f, (Rect) null, rect, mo111a(colorFilter));
    }

    /* renamed from: a */
    public boolean mo114a() {
        return this.f133b.mo106a() < 255;
    }

    /* renamed from: b */
    public void mo115b(int i, int i2) {
        if (this.f137f == null || !mo118c(i, i2)) {
            this.f137f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.f142k = true;
        }
    }

    /* renamed from: b */
    public boolean mo116b() {
        return !this.f142k && this.f138g == this.f134c && this.f139h == this.f135d && this.f141j == this.f136e && this.f140i == this.f133b.mo106a();
    }

    /* renamed from: c */
    public void mo117c() {
        this.f138g = this.f134c;
        this.f139h = this.f135d;
        this.f140i = this.f133b.mo106a();
        this.f141j = this.f136e;
        this.f142k = false;
    }

    /* renamed from: c */
    public boolean mo118c(int i, int i2) {
        return i == this.f137f.getWidth() && i2 == this.f137f.getHeight();
    }

    public int getChangingConfigurations() {
        return this.f132a;
    }

    public Drawable newDrawable() {
        return new C0016l(this);
    }

    public Drawable newDrawable(Resources resources) {
        return new C0016l(this);
    }
}
