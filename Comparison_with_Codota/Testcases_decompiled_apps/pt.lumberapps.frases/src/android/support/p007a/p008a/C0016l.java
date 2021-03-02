package android.support.p007a.p008a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p012b.p013a.C0095a;
import android.util.AttributeSet;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* renamed from: android.support.a.a.l */
public class C0016l extends C0015k {

    /* renamed from: b */
    static final PorterDuff.Mode f77b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    private C0023s f78c;

    /* renamed from: d */
    private PorterDuffColorFilter f79d;

    /* renamed from: e */
    private ColorFilter f80e;

    /* renamed from: f */
    private boolean f81f;

    /* renamed from: g */
    private boolean f82g;

    /* renamed from: h */
    private Drawable.ConstantState f83h;

    /* renamed from: i */
    private final float[] f84i;

    /* renamed from: j */
    private final Matrix f85j;

    /* renamed from: k */
    private final Rect f86k;

    private C0016l() {
        this.f82g = true;
        this.f84i = new float[9];
        this.f85j = new Matrix();
        this.f86k = new Rect();
        this.f78c = new C0023s();
    }

    private C0016l(C0023s sVar) {
        this.f82g = true;
        this.f84i = new float[9];
        this.f85j = new Matrix();
        this.f86k = new Rect();
        this.f78c = sVar;
        this.f79d = mo72a(this.f79d, sVar.f134c, sVar.f135d);
    }

    /* renamed from: a */
    private static PorterDuff.Mode m74a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033 A[Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[SYNTHETIC, Splitter:B:15:0x0045] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p007a.p008a.C0016l m75a(android.content.res.Resources r5, int r6, android.content.res.Resources.Theme r7) {
        /*
            r4 = 2
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x0020
            android.support.a.a.l r0 = new android.support.a.a.l
            r0.<init>()
            android.graphics.drawable.Drawable r1 = android.support.p009v4.p010a.p011a.C0034i.m141a(r5, r6, r7)
            r0.f76a = r1
            android.support.a.a.t r1 = new android.support.a.a.t
            android.graphics.drawable.Drawable r2 = r0.f76a
            android.graphics.drawable.Drawable$ConstantState r2 = r2.getConstantState()
            r1.<init>(r2)
            r0.f83h = r1
        L_0x001f:
            return r0
        L_0x0020:
            android.content.res.XmlResourceParser r0 = r5.getXml(r6)     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r0)     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
        L_0x0028:
            int r2 = r0.next()     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            if (r2 == r4) goto L_0x0031
            r3 = 1
            if (r2 != r3) goto L_0x0028
        L_0x0031:
            if (r2 == r4) goto L_0x0045
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            java.lang.String r1 = "No start tag found"
            r0.<init>(r1)     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            throw r0     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
        L_0x003b:
            r0 = move-exception
            java.lang.String r1 = "VectorDrawableCompat"
            java.lang.String r2 = "parser error"
            android.util.Log.e(r1, r2, r0)
        L_0x0043:
            r0 = 0
            goto L_0x001f
        L_0x0045:
            android.support.a.a.l r0 = m76a(r5, r0, r1, r7)     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            goto L_0x001f
        L_0x004a:
            r0 = move-exception
            java.lang.String r1 = "VectorDrawableCompat"
            java.lang.String r2 = "parser error"
            android.util.Log.e(r1, r2, r0)
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p007a.p008a.C0016l.m75a(android.content.res.Resources, int, android.content.res.Resources$Theme):android.support.a.a.l");
    }

    /* renamed from: a */
    public static C0016l m76a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0016l lVar = new C0016l();
        lVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return lVar;
    }

    /* renamed from: a */
    private void m77a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0023s sVar = this.f78c;
        C0022r rVar = sVar.f133b;
        sVar.f135d = m74a(C0014j.m68a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            sVar.f134c = colorStateList;
        }
        sVar.f136e = C0014j.m69a(typedArray, xmlPullParser, "autoMirrored", 5, sVar.f136e);
        rVar.f119c = C0014j.m67a(typedArray, xmlPullParser, "viewportWidth", 7, rVar.f119c);
        rVar.f120d = C0014j.m67a(typedArray, xmlPullParser, "viewportHeight", 8, rVar.f120d);
        if (rVar.f119c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (rVar.f120d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            rVar.f117a = typedArray.getDimension(3, rVar.f117a);
            rVar.f118b = typedArray.getDimension(2, rVar.f118b);
            if (rVar.f117a <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (rVar.f118b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                rVar.mo107a(C0014j.m67a(typedArray, xmlPullParser, "alpha", 4, rVar.mo110b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    rVar.f122f = string;
                    rVar.f123g.put(string, rVar);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m78a() {
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m79b(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    /* renamed from: b */
    private void m80b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        boolean z;
        C0023s sVar = this.f78c;
        C0022r rVar = sVar.f133b;
        Stack stack = new Stack();
        stack.push(rVar.f131p);
        int eventType = xmlPullParser.getEventType();
        boolean z2 = true;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C0020p pVar = (C0020p) stack.peek();
                if ("path".equals(name)) {
                    C0019o oVar = new C0019o();
                    oVar.mo101a(resources, attributeSet, theme, xmlPullParser);
                    pVar.f100a.add(oVar);
                    if (oVar.mo105b() != null) {
                        rVar.f123g.put(oVar.mo105b(), oVar);
                    }
                    z = false;
                    sVar.f132a = oVar.f115o | sVar.f132a;
                } else if ("clip-path".equals(name)) {
                    C0018n nVar = new C0018n();
                    nVar.mo99a(resources, attributeSet, theme, xmlPullParser);
                    pVar.f100a.add(nVar);
                    if (nVar.mo105b() != null) {
                        rVar.f123g.put(nVar.mo105b(), nVar);
                    }
                    sVar.f132a |= nVar.f115o;
                    z = z2;
                } else {
                    if ("group".equals(name)) {
                        C0020p pVar2 = new C0020p();
                        pVar2.mo103a(resources, attributeSet, theme, xmlPullParser);
                        pVar.f100a.add(pVar2);
                        stack.push(pVar2);
                        if (pVar2.mo102a() != null) {
                            rVar.f123g.put(pVar2.mo102a(), pVar2);
                        }
                        sVar.f132a |= pVar2.f110k;
                    }
                    z = z2;
                }
                z2 = z;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                stack.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PorterDuffColorFilter mo72a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo73a(String str) {
        return this.f78c.f133b.f123g.get(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo74a(boolean z) {
        this.f82g = z;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        if (this.f76a == null) {
            return false;
        }
        C0095a.m206d(this.f76a);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.f76a != null) {
            this.f76a.draw(canvas);
            return;
        }
        copyBounds(this.f86k);
        if (this.f86k.width() > 0 && this.f86k.height() > 0) {
            ColorFilter colorFilter = this.f80e == null ? this.f79d : this.f80e;
            canvas.getMatrix(this.f85j);
            this.f85j.getValues(this.f84i);
            float abs = Math.abs(this.f84i[0]);
            float abs2 = Math.abs(this.f84i[4]);
            float abs3 = Math.abs(this.f84i[1]);
            float abs4 = Math.abs(this.f84i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int min = Math.min(2048, (int) (abs * ((float) this.f86k.width())));
            int min2 = Math.min(2048, (int) (abs2 * ((float) this.f86k.height())));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f86k.left, (float) this.f86k.top);
                if (m78a()) {
                    canvas.translate((float) this.f86k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f86k.offsetTo(0, 0);
                this.f78c.mo115b(min, min2);
                if (!this.f82g) {
                    this.f78c.mo112a(min, min2);
                } else if (!this.f78c.mo116b()) {
                    this.f78c.mo112a(min, min2);
                    this.f78c.mo117c();
                }
                this.f78c.mo113a(canvas, colorFilter, this.f86k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.f76a != null ? C0095a.m205c(this.f76a) : this.f78c.f133b.mo106a();
    }

    public int getChangingConfigurations() {
        return this.f76a != null ? this.f76a.getChangingConfigurations() : super.getChangingConfigurations() | this.f78c.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f76a != null) {
            return new C0024t(this.f76a.getConstantState());
        }
        this.f78c.f132a = getChangingConfigurations();
        return this.f78c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f76a != null ? this.f76a.getIntrinsicHeight() : (int) this.f78c.f133b.f118b;
    }

    public int getIntrinsicWidth() {
        return this.f76a != null ? this.f76a.getIntrinsicWidth() : (int) this.f78c.f133b.f117a;
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        if (this.f76a != null) {
            return this.f76a.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.f76a != null) {
            this.f76a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f76a != null) {
            C0095a.m200a(this.f76a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0023s sVar = this.f78c;
        sVar.f133b = new C0022r();
        TypedArray b = m72b(resources, theme, attributeSet, C0005a.f56a);
        m77a(b, xmlPullParser);
        b.recycle();
        sVar.f132a = getChangingConfigurations();
        sVar.f142k = true;
        m80b(resources, xmlPullParser, attributeSet, theme);
        this.f79d = mo72a(this.f79d, sVar.f134c, sVar.f135d);
    }

    public void invalidateSelf() {
        if (this.f76a != null) {
            this.f76a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.f76a != null ? this.f76a.isStateful() : super.isStateful() || !(this.f78c == null || this.f78c.f134c == null || !this.f78c.f134c.isStateful());
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.f76a != null) {
            this.f76a.mutate();
        } else if (!this.f81f && super.mutate() == this) {
            this.f78c = new C0023s(this.f78c);
            this.f81f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f76a != null) {
            return this.f76a.setState(iArr);
        }
        C0023s sVar = this.f78c;
        if (sVar.f134c == null || sVar.f135d == null) {
            return false;
        }
        this.f79d = mo72a(this.f79d, sVar.f134c, sVar.f135d);
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f76a != null) {
            this.f76a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.f76a != null) {
            this.f76a.setAlpha(i);
        } else if (this.f78c.f133b.mo106a() != i) {
            this.f78c.f133b.mo108a(i);
            invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        if (this.f76a != null) {
            this.f76a.setBounds(i, i2, i3, i4);
        } else {
            super.setBounds(i, i2, i3, i4);
        }
    }

    public void setBounds(Rect rect) {
        if (this.f76a != null) {
            this.f76a.setBounds(rect);
        } else {
            super.setBounds(rect);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f76a != null) {
            this.f76a.setColorFilter(colorFilter);
            return;
        }
        this.f80e = colorFilter;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.f76a != null) {
            C0095a.m196a(this.f76a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f76a != null) {
            C0095a.m198a(this.f76a, colorStateList);
            return;
        }
        C0023s sVar = this.f78c;
        if (sVar.f134c != colorStateList) {
            sVar.f134c = colorStateList;
            this.f79d = mo72a(this.f79d, colorStateList, sVar.f135d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f76a != null) {
            C0095a.m201a(this.f76a, mode);
            return;
        }
        C0023s sVar = this.f78c;
        if (sVar.f135d != mode) {
            sVar.f135d = mode;
            this.f79d = mo72a(this.f79d, sVar.f134c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f76a != null ? this.f76a.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.f76a != null) {
            this.f76a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
