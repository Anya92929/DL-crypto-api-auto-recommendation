package android.support.p007a.p008a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.p012b.p013a.C0095a;
import android.support.p009v4.p019f.C0136a;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
/* renamed from: android.support.a.a.b */
public class C0006b extends C0015k implements Animatable {

    /* renamed from: b */
    private C0008d f62b;

    /* renamed from: c */
    private Context f63c;

    /* renamed from: d */
    private ArgbEvaluator f64d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Drawable.Callback f65e;

    private C0006b() {
        this((Context) null, (C0008d) null, (Resources) null);
    }

    private C0006b(Context context) {
        this(context, (C0008d) null, (Resources) null);
    }

    private C0006b(Context context, C0008d dVar, Resources resources) {
        this.f64d = null;
        this.f65e = new C0007c(this);
        this.f63c = context;
        if (dVar != null) {
            this.f62b = dVar;
        } else {
            this.f62b = new C0008d(context, dVar, this.f65e, resources);
        }
    }

    /* synthetic */ C0006b(C0007c cVar) {
        this();
    }

    /* renamed from: a */
    static TypedArray m49a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: a */
    public static C0006b m51a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0006b bVar = new C0006b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    /* renamed from: a */
    private void m52a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childAnimations.size()) {
                    break;
                }
                m52a(childAnimations.get(i2));
                i = i2 + 1;
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f64d == null) {
                    this.f64d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f64d);
            }
        }
    }

    /* renamed from: a */
    private void m53a(String str, Animator animator) {
        animator.setTarget(this.f62b.f68b.mo73a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m52a(animator);
        }
        if (this.f62b.f69c == null) {
            this.f62b.f69c = new ArrayList();
            this.f62b.f70d = new C0136a();
        }
        this.f62b.f69c.add(animator);
        this.f62b.f70d.put(animator, str);
    }

    /* renamed from: a */
    private boolean m54a() {
        ArrayList arrayList = this.f62b.f69c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.f76a != null) {
            C0095a.m199a(this.f76a, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.f76a != null) {
            return C0095a.m206d(this.f76a);
        }
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
        this.f62b.f68b.draw(canvas);
        if (m54a()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f76a != null ? C0095a.m205c(this.f76a) : this.f62b.f68b.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.f76a != null ? this.f76a.getChangingConfigurations() : super.getChangingConfigurations() | this.f62b.f67a;
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f76a != null) {
            return new C0009e(this.f76a.getConstantState());
        }
        return null;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f76a != null ? this.f76a.getIntrinsicHeight() : this.f62b.f68b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f76a != null ? this.f76a.getIntrinsicWidth() : this.f62b.f68b.getIntrinsicWidth();
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
        return this.f76a != null ? this.f76a.getOpacity() : this.f62b.f68b.getOpacity();
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
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f76a != null) {
            C0095a.m200a(this.f76a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a = m49a(resources, theme, attributeSet, C0005a.f60e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0016l a2 = C0016l.m75a(resources, resourceId, theme);
                        a2.mo74a(false);
                        a2.setCallback(this.f65e);
                        if (this.f62b.f68b != null) {
                            this.f62b.f68b.setCallback((Drawable.Callback) null);
                        }
                        this.f62b.f68b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C0005a.f61f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f63c != null) {
                            m53a(string, AnimatorInflater.loadAnimator(this.f63c, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isRunning() {
        if (this.f76a != null) {
            return ((AnimatedVectorDrawable) this.f76a).isRunning();
        }
        ArrayList arrayList = this.f62b.f69c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStateful() {
        return this.f76a != null ? this.f76a.isStateful() : this.f62b.f68b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.f76a != null) {
            this.f76a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f76a != null) {
            this.f76a.setBounds(rect);
        } else {
            this.f62b.f68b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f76a != null ? this.f76a.setLevel(i) : this.f62b.f68b.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return this.f76a != null ? this.f76a.setState(iArr) : this.f62b.f68b.setState(iArr);
    }

    public void setAlpha(int i) {
        if (this.f76a != null) {
            this.f76a.setAlpha(i);
        } else {
            this.f62b.f68b.setAlpha(i);
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
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
        } else {
            this.f62b.f68b.setColorFilter(colorFilter);
        }
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
            this.f62b.f68b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f76a != null) {
            C0095a.m198a(this.f76a, colorStateList);
        } else {
            this.f62b.f68b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f76a != null) {
            C0095a.m201a(this.f76a, mode);
        } else {
            this.f62b.f68b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f76a != null) {
            return this.f76a.setVisible(z, z2);
        }
        this.f62b.f68b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.f76a != null) {
            ((AnimatedVectorDrawable) this.f76a).start();
        } else if (!m54a()) {
            ArrayList arrayList = this.f62b.f69c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.f76a != null) {
            ((AnimatedVectorDrawable) this.f76a).stop();
            return;
        }
        ArrayList arrayList = this.f62b.f69c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
