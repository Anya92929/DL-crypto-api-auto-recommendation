package android.support.p021v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.p009v4.p012b.p013a.C0113q;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: android.support.v7.widget.bc */
class C0605bc {

    /* renamed from: b */
    private static final int[] f1431b = {16843067, 16843068};

    /* renamed from: a */
    final C0591ap f1432a;

    /* renamed from: c */
    private final ProgressBar f1433c;

    /* renamed from: d */
    private Bitmap f1434d;

    C0605bc(ProgressBar progressBar, C0591ap apVar) {
        this.f1433c = progressBar;
        this.f1432a = apVar;
    }

    /* renamed from: a */
    private Drawable mo3028a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m2770a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* renamed from: a */
    private Drawable m2770a(Drawable drawable, boolean z) {
        if (drawable instanceof C0113q) {
            Drawable a = ((C0113q) drawable).mo979a();
            if (a != null) {
                ((C0113q) drawable).mo983a(m2770a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = m2770a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1434d == null) {
                this.f1434d = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(mo3029b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    /* renamed from: b */
    private Shape mo3029b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo3016a() {
        return this.f1434d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3017a(AttributeSet attributeSet, int i) {
        C0670dn a = C0670dn.m3014a(this.f1433c.getContext(), attributeSet, f1431b, i, 0);
        Drawable b = a.mo3322b(0);
        if (b != null) {
            this.f1433c.setIndeterminateDrawable(mo3028a(b));
        }
        Drawable b2 = a.mo3322b(1);
        if (b2 != null) {
            this.f1433c.setProgressDrawable(m2770a(b2, false));
        }
        a.mo3319a();
    }
}
