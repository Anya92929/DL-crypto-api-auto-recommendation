package com.p028a.p030b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ExifInterface;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.p028a.p029a.C0766a;
import com.p028a.p031c.C0776a;
import com.p028a.p031c.C0777b;
import com.p028a.p031c.C0778c;
import com.p028a.p031c.C0781f;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpHost;

/* renamed from: com.a.b.e */
public class C0772e extends C0768a {

    /* renamed from: F */
    private static Bitmap f1968F = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);

    /* renamed from: G */
    private static Bitmap f1969G = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);

    /* renamed from: i */
    private static int f1970i = 20;

    /* renamed from: j */
    private static int f1971j = 20;

    /* renamed from: k */
    private static int f1972k = 2500;

    /* renamed from: l */
    private static int f1973l = 160000;

    /* renamed from: m */
    private static int f1974m = 1000000;

    /* renamed from: n */
    private static boolean f1975n = false;

    /* renamed from: o */
    private static Map f1976o;

    /* renamed from: p */
    private static Map f1977p;

    /* renamed from: q */
    private static Map f1978q;

    /* renamed from: r */
    private static HashMap f1979r = new HashMap();

    /* renamed from: A */
    private int f1980A;

    /* renamed from: B */
    private boolean f1981B = true;

    /* renamed from: C */
    private float f1982C = Float.MAX_VALUE;

    /* renamed from: D */
    private boolean f1983D;

    /* renamed from: E */
    private boolean f1984E;

    /* renamed from: s */
    private WeakReference f1985s;

    /* renamed from: t */
    private int f1986t;

    /* renamed from: u */
    private int f1987u;

    /* renamed from: v */
    private File f1988v;

    /* renamed from: w */
    private Bitmap f1989w;

    /* renamed from: x */
    private int f1990x;

    /* renamed from: y */
    private Bitmap f1991y;

    /* renamed from: z */
    private float f1992z;

    public C0772e() {
        ((C0772e) ((C0772e) ((C0772e) mo3484a(Bitmap.class)).mo3499b(true)).mo3490a(true)).mo3486a("");
    }

    /* renamed from: a */
    private static int m3457a(int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < 10 && i >= i2 * 2; i4++) {
            i /= 2;
            i3 *= 2;
        }
        return i3;
    }

    /* renamed from: a */
    private static Bitmap m3458a(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = (float) i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    /* renamed from: a */
    private static Bitmap m3459a(View view, Bitmap bitmap, int i) {
        if (bitmap != null && bitmap.getWidth() == 1 && bitmap.getHeight() == 1 && bitmap != f1968F) {
            bitmap = null;
        }
        if (bitmap != null) {
            view.setVisibility(0);
        } else if (i == -2) {
            view.setVisibility(8);
        } else if (i == -1) {
            view.setVisibility(4);
        }
        return bitmap;
    }

    /* renamed from: a */
    private static Bitmap m3460a(String str, int i, int i2) {
        String b = m3474b(str, i, i2);
        Bitmap bitmap = (Bitmap) m3480i().get(b);
        if (bitmap == null) {
            bitmap = (Bitmap) m3481j().get(b);
        }
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmap2 = (Bitmap) m3482k().get(b);
        if (bitmap2 == null || m3383f() != 200) {
            return bitmap2;
        }
        f1978q = null;
        return null;
    }

    /* renamed from: a */
    private static Bitmap m3461a(String str, BitmapFactory.Options options, boolean z) {
        FileInputStream fileInputStream;
        IOException e;
        Bitmap bitmap;
        Bitmap bitmap2;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        options.inInputShareable = true;
        options.inPurgeable = true;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bitmap = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), (Rect) null, options);
                if (bitmap != null && z) {
                    try {
                        bitmap = m3473b(str, bitmap);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                C0776a.m3518a((Closeable) fileInputStream);
            } catch (IOException e3) {
                IOException iOException = e3;
                bitmap2 = null;
                e = iOException;
            }
        } catch (IOException e4) {
            fileInputStream = null;
            IOException iOException2 = e4;
            bitmap2 = null;
            e = iOException2;
            try {
                C0776a.m3535b((Throwable) e);
                C0776a.m3518a((Closeable) fileInputStream);
                return bitmap;
            } catch (Throwable th) {
                th = th;
                C0776a.m3518a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            C0776a.m3518a((Closeable) fileInputStream);
            throw th;
        }
        return bitmap;
    }

    /* renamed from: a */
    private Bitmap m3462a(String str, byte[] bArr) {
        return m3463a(str, bArr, this.f1986t, this.f1981B, this.f1980A, this.f1984E);
    }

    /* renamed from: a */
    public static Bitmap m3463a(String str, byte[] bArr, int i, boolean z, int i2, boolean z2) {
        BitmapFactory.Options options;
        Bitmap bitmap;
        if (str == null && bArr == null) {
            return null;
        }
        if (i > 0) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            m3464a(str, bArr, options2, z2);
            int i3 = options2.outWidth;
            if (!z) {
                i3 = Math.max(i3, options2.outHeight);
            }
            int a = m3457a(i3, i);
            options = new BitmapFactory.Options();
            options.inSampleSize = a;
        } else {
            options = null;
        }
        try {
            bitmap = m3464a(str, bArr, options, z2);
        } catch (OutOfMemoryError e) {
            m3478g();
            C0776a.m3535b((Throwable) e);
            bitmap = null;
        }
        if (i2 > 0) {
            bitmap = m3458a(bitmap, i2);
        }
        return bitmap;
    }

    /* renamed from: a */
    private static Bitmap m3464a(String str, byte[] bArr, BitmapFactory.Options options, boolean z) {
        Bitmap bitmap = null;
        if (str != null) {
            bitmap = m3461a(str, options, z);
        } else if (bArr != null) {
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        if (bitmap == null && options != null && !options.inJustDecodeBounds) {
            C0776a.m3534b((Object) "decode image failed", (Object) str);
        }
        return bitmap;
    }

    /* renamed from: a */
    private static Drawable m3465a(ImageView imageView, Bitmap bitmap, float f, float f2) {
        return f > 0.0f ? new C0781f(imageView.getResources(), bitmap, imageView, f, f2) : new BitmapDrawable(imageView.getResources(), bitmap);
    }

    /* renamed from: a */
    public static void m3466a(Activity activity, Context context, ImageView imageView, String str, Object obj, C0766a aVar, C0773f fVar, HttpHost httpHost, String str2) {
        m3467a(activity, context, imageView, str, fVar.f1993a, fVar.f1994b, fVar.f1997e, fVar.f1998f, fVar.f1995c, fVar.f1999g, fVar.f2000h, fVar.f2002j, obj, aVar, fVar.f1996d, fVar.f2001i, httpHost, str2);
    }

    /* renamed from: a */
    public static void m3467a(Activity activity, Context context, ImageView imageView, String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3, float f, float f2, Object obj, C0766a aVar, int i4, int i5, HttpHost httpHost, String str2) {
        Bitmap bitmap2 = null;
        if (z) {
            bitmap2 = m3460a(str, i, i5);
        }
        if (bitmap2 != null) {
            imageView.setTag(1090453505, str);
            C0778c.m3549a(obj, str, false);
            m3468a(imageView, bitmap2, bitmap, i2, i3, f, f2, 4);
            return;
        }
        C0772e eVar = new C0772e();
        ((C0772e) ((C0772e) ((C0772e) ((C0772e) ((C0772e) ((C0772e) eVar.mo3486a(str)).mo3538a(imageView).mo3499b(z)).mo3490a(z2)).mo3545b(i).mo3547c(i2).mo3537a(bitmap).mo3548d(i3).mo3536a(f).mo3544b(f2).mo3485a(obj)).mo3482a(aVar)).mo3480a(i4)).mo3550e(i5).mo3498b(str2);
        if (httpHost != null) {
            eVar.mo3487a(httpHost.getHostName(), httpHost.getPort());
        }
        if (activity != null) {
            eVar.mo3492a(activity);
        } else {
            eVar.mo3493a(context);
        }
    }

    /* renamed from: a */
    private static void m3468a(ImageView imageView, Bitmap bitmap, Bitmap bitmap2, int i, int i2, float f, float f2, int i3) {
        Animation loadAnimation;
        Bitmap a = m3459a((View) imageView, bitmap, i);
        if (a == null) {
            imageView.setImageBitmap((Bitmap) null);
            return;
        }
        Drawable a2 = m3465a(imageView, a, f, f2);
        if (!m3476b(i2, i3)) {
            loadAnimation = i2 > 0 ? AnimationUtils.loadAnimation(imageView.getContext(), i2) : null;
        } else if (bitmap2 == null) {
            loadAnimation = new AlphaAnimation(0.0f, 1.0f);
            loadAnimation.setInterpolator(new DecelerateInterpolator());
            loadAnimation.setDuration(300);
        } else {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{m3465a(imageView, bitmap2, f, f2), a2});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(300);
            a2 = transitionDrawable;
            loadAnimation = null;
        }
        imageView.setImageDrawable(a2);
        if (loadAnimation != null) {
            loadAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            imageView.startAnimation(loadAnimation);
            return;
        }
        imageView.setAnimation((Animation) null);
    }

    /* renamed from: a */
    private void m3469a(C0772e eVar, String str, ImageView imageView, Bitmap bitmap, C0771d dVar) {
        if (imageView != null && eVar != null) {
            if (str.equals(imageView.getTag(1090453505))) {
                if (imageView instanceof ImageView) {
                    eVar.mo3541a(str, imageView, bitmap, dVar);
                } else {
                    eVar.m3472a(str, imageView, bitmap, false);
                }
            }
            eVar.mo3503c(false);
        }
    }

    /* renamed from: a */
    private static void m3470a(String str, int i, int i2, Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            Map k = z ? m3482k() : bitmap.getWidth() * bitmap.getHeight() <= f1972k ? m3481j() : m3480i();
            if (i > 0 || i2 > 0) {
                k.put(m3474b(str, i, i2), bitmap);
                if (!k.containsKey(str)) {
                    k.put(str, (Object) null);
                    return;
                }
                return;
            }
            k.put(str, bitmap);
        }
    }

    /* renamed from: a */
    private void m3471a(String str, ImageView imageView) {
        if (!str.equals(imageView.getTag(1090453505)) || this.f1991y != null) {
            imageView.setTag(1090453505, str);
            if (this.f1991y == null || mo3501b(imageView.getContext())) {
                m3472a(str, imageView, (Bitmap) null, true);
            } else {
                m3472a(str, imageView, this.f1991y, true);
            }
        }
    }

    /* renamed from: a */
    private void m3472a(String str, ImageView imageView, Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            imageView.setImageDrawable((Drawable) null);
        } else if (z) {
            imageView.setImageDrawable(m3465a(imageView, bitmap, this.f1992z, this.f1982C));
        } else if (this.f1932f != null) {
            m3468a(imageView, bitmap, this.f1991y, this.f1987u, this.f1990x, this.f1992z, this.f1982C, this.f1932f.mo3535k());
        }
    }

    /* renamed from: b */
    private static Bitmap m3473b(String str, Bitmap bitmap) {
        int i;
        if (bitmap == null) {
            return null;
        }
        try {
            i = new ExifInterface(str).getAttributeInt("Orientation", 1);
        } catch (Exception e) {
            C0776a.m3527a((Throwable) e);
            i = 1;
        }
        if (i <= 0) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m3477f(i), true);
        C0776a.m3534b((Object) "before", (Object) String.valueOf(bitmap.getWidth()) + ":" + bitmap.getHeight());
        C0776a.m3534b((Object) "after", (Object) String.valueOf(createBitmap.getWidth()) + ":" + createBitmap.getHeight());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: b */
    private static String m3474b(String str, int i, int i2) {
        String str2 = i > 0 ? String.valueOf(str) + "#" + i : str;
        return i2 > 0 ? String.valueOf(str2) + "#" + i2 : str2;
    }

    /* renamed from: b */
    private void m3475b(String str, ImageView imageView) {
        WeakHashMap weakHashMap = (WeakHashMap) f1979r.get(str);
        if (weakHashMap != null) {
            weakHashMap.put(imageView, this);
        } else if (f1979r.containsKey(str)) {
            WeakHashMap weakHashMap2 = new WeakHashMap();
            weakHashMap2.put(imageView, this);
            f1979r.put(str, weakHashMap2);
        } else {
            f1979r.put(str, (Object) null);
        }
    }

    /* renamed from: b */
    private static boolean m3476b(int i, int i2) {
        switch (i) {
            case -3:
                if (i2 == 3) {
                    return true;
                }
                break;
            case -2:
                break;
            case -1:
                return true;
        }
        return i2 == 1;
    }

    /* renamed from: f */
    private static Matrix m3477f(int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        return matrix;
    }

    /* renamed from: g */
    public static void m3478g() {
        f1977p = null;
        f1976o = null;
        f1978q = null;
    }

    /* renamed from: h */
    private Bitmap m3479h() {
        View view = (View) this.f1985s.get();
        if (view == null) {
            return null;
        }
        String num = Integer.toString(this.f1987u);
        Bitmap e = mo3505d(num);
        if (e != null) {
            return e;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(view.getResources(), this.f1987u);
        if (decodeResource == null) {
            return decodeResource;
        }
        mo3494a(num, decodeResource);
        return decodeResource;
    }

    /* renamed from: i */
    private static Map m3480i() {
        if (f1977p == null) {
            f1977p = Collections.synchronizedMap(new C0777b(f1971j, f1973l, f1974m));
        }
        return f1977p;
    }

    /* renamed from: j */
    private static Map m3481j() {
        if (f1976o == null) {
            f1976o = Collections.synchronizedMap(new C0777b(f1970i, f1972k, 250000));
        }
        return f1976o;
    }

    /* renamed from: k */
    private static Map m3482k() {
        if (f1978q == null) {
            f1978q = Collections.synchronizedMap(new C0777b(100, f1973l, 250000));
        }
        return f1978q;
    }

    /* renamed from: a */
    public C0772e mo3536a(float f) {
        this.f1992z = f;
        return this;
    }

    /* renamed from: a */
    public C0772e mo3537a(Bitmap bitmap) {
        this.f1991y = bitmap;
        return this;
    }

    /* renamed from: a */
    public C0772e mo3538a(ImageView imageView) {
        this.f1985s = new WeakReference(imageView);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public File mo3479a(File file, String str) {
        return (this.f1988v == null || !this.f1988v.exists()) ? super.mo3479a(file, str) : this.f1988v;
    }

    /* renamed from: a */
    public void mo3493a(Context context) {
        String d = mo3506d();
        ImageView imageView = (ImageView) this.f1985s.get();
        if (d == null) {
            mo3503c(false);
            m3472a(d, imageView, (Bitmap) null, false);
            return;
        }
        Bitmap e = mo3505d(d);
        if (e != null) {
            imageView.setTag(1090453505, d);
            this.f1932f = new C0771d().mo3511a(4).mo3510a();
            mo3495a(d, e, this.f1932f);
            return;
        }
        m3471a(d, imageView);
        if (!f1979r.containsKey(d)) {
            m3475b(d, imageView);
            super.mo3493a(imageView.getContext());
            return;
        }
        mo3503c(true);
        m3475b(d, imageView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3494a(String str, Bitmap bitmap) {
        m3470a(str, this.f1986t, this.f1980A, bitmap, this.f1983D);
    }

    /* renamed from: a */
    public final void mo3495a(String str, Bitmap bitmap, C0771d dVar) {
        ImageView imageView = (ImageView) this.f1985s.get();
        WeakHashMap weakHashMap = (WeakHashMap) f1979r.remove(str);
        if (weakHashMap == null || !weakHashMap.containsKey(imageView)) {
            m3469a(this, str, imageView, bitmap, dVar);
        }
        if (weakHashMap != null) {
            for (ImageView imageView2 : weakHashMap.keySet()) {
                C0772e eVar = (C0772e) weakHashMap.get(imageView2);
                eVar.f1932f = dVar;
                m3469a(eVar, str, imageView2, bitmap, dVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3541a(String str, ImageView imageView, Bitmap bitmap, C0771d dVar) {
        m3472a(str, imageView, bitmap, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Bitmap mo3488a(String str, File file, C0771d dVar) {
        return m3462a(file.getAbsolutePath(), (byte[]) null);
    }

    /* renamed from: b */
    public Bitmap mo3489a(String str, byte[] bArr, C0771d dVar) {
        String str2 = null;
        File j = dVar.mo3534j();
        if (j != null) {
            str2 = j.getAbsolutePath();
        }
        Bitmap a = m3462a(str2, bArr);
        if (a == null) {
            if (this.f1987u > 0) {
                a = m3479h();
            } else if (this.f1987u == -2 || this.f1987u == -1) {
                a = f1969G;
            } else if (this.f1987u == -3) {
                a = this.f1991y;
            }
            if (dVar.mo3531g() != 200) {
                this.f1983D = true;
            }
            if (dVar.mo3535k() == 1 && j != null) {
                C0776a.m3524a((Object) "invalid bm from net");
                j.delete();
            }
        }
        return a;
    }

    /* renamed from: b */
    public C0772e mo3544b(float f) {
        this.f1982C = f;
        return this;
    }

    /* renamed from: b */
    public C0772e mo3545b(int i) {
        this.f1986t = i;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3500b(String str, Bitmap bitmap, C0771d dVar) {
        f1979r.remove(str);
    }

    /* renamed from: c */
    public C0772e mo3547c(int i) {
        this.f1987u = i;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3504c() {
        return !f1975n;
    }

    /* renamed from: d */
    public C0772e mo3548d(int i) {
        this.f1990x = i;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Bitmap mo3505d(String str) {
        if (this.f1989w != null) {
            return this.f1989w;
        }
        if (!this.f1934h) {
            return null;
        }
        return m3460a(str, this.f1986t, this.f1980A);
    }

    /* renamed from: e */
    public C0772e mo3550e(int i) {
        this.f1980A = i;
        return this;
    }
}
