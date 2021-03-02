package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.p007a.p008a.C0016l;
import android.support.p009v4.p010a.C0025a;
import android.support.p009v4.p012b.C0094a;
import android.support.p009v4.p012b.p013a.C0095a;
import android.support.p009v4.p019f.C0136a;
import android.support.p009v4.p019f.C0141f;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0508d;
import android.support.p021v7.p023b.C0510f;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.ap */
public final class C0591ap {

    /* renamed from: a */
    private static final PorterDuff.Mode f1394a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private static C0591ap f1395b;

    /* renamed from: c */
    private static final C0594as f1396c = new C0594as(6);

    /* renamed from: d */
    private static final int[] f1397d = {C0510f.abc_textfield_search_default_mtrl_alpha, C0510f.abc_textfield_default_mtrl_alpha, C0510f.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: e */
    private static final int[] f1398e = {C0510f.abc_ic_commit_search_api_mtrl_alpha, C0510f.abc_seekbar_tick_mark_material};

    /* renamed from: f */
    private static final int[] f1399f = {C0510f.abc_textfield_activated_mtrl_alpha, C0510f.abc_textfield_search_activated_mtrl_alpha, C0510f.abc_cab_background_top_mtrl_alpha, C0510f.abc_text_cursor_material};

    /* renamed from: g */
    private static final int[] f1400g = {C0510f.abc_popup_background_mtrl_mult, C0510f.abc_cab_background_internal_bg, C0510f.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: h */
    private static final int[] f1401h = {C0510f.abc_tab_indicator_material, C0510f.abc_textfield_search_material};

    /* renamed from: i */
    private static final int[] f1402i = {C0510f.abc_btn_check_material, C0510f.abc_btn_radio_material};

    /* renamed from: j */
    private WeakHashMap f1403j;

    /* renamed from: k */
    private C0136a f1404k;

    /* renamed from: l */
    private SparseArray f1405l;

    /* renamed from: m */
    private final Object f1406m = new Object();

    /* renamed from: n */
    private final WeakHashMap f1407n = new WeakHashMap(0);

    /* renamed from: o */
    private TypedValue f1408o;

    /* renamed from: p */
    private boolean f1409p;

    /* renamed from: a */
    private static long m2730a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* renamed from: a */
    private ColorStateList m2731a(Context context) {
        return m2752f(context, C0665di.m3003a(context, C0506b.colorButtonNormal));
    }

    /* renamed from: a */
    public static PorterDuffColorFilter m2732a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a = f1396c.mo2986a(i, mode);
        if (a != null) {
            return a;
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        f1396c.mo2987a(i, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m2733a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m2732a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    private Drawable m2734a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = mo2984b(context, i);
        if (b != null) {
            if (C0624bv.m2855b(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable f = C0095a.m208f(drawable);
            C0095a.m198a(f, b);
            PorterDuff.Mode a = mo2981a(i);
            if (a == null) {
                return f;
            }
            C0095a.m201a(f, a);
            return f;
        } else if (i == C0510f.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            m2738a(layerDrawable.findDrawableByLayerId(16908288), C0665di.m3003a(context, C0506b.colorControlNormal), f1394a);
            m2738a(layerDrawable.findDrawableByLayerId(16908303), C0665di.m3003a(context, C0506b.colorControlNormal), f1394a);
            m2738a(layerDrawable.findDrawableByLayerId(16908301), C0665di.m3003a(context, C0506b.colorControlActivated), f1394a);
            return drawable;
        } else if (i == C0510f.abc_ratingbar_material || i == C0510f.abc_ratingbar_indicator_material || i == C0510f.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m2738a(layerDrawable2.findDrawableByLayerId(16908288), C0665di.m3007c(context, C0506b.colorControlNormal), f1394a);
            m2738a(layerDrawable2.findDrawableByLayerId(16908303), C0665di.m3003a(context, C0506b.colorControlActivated), f1394a);
            m2738a(layerDrawable2.findDrawableByLayerId(16908301), C0665di.m3003a(context, C0506b.colorControlActivated), f1394a);
            return drawable;
        } else if (m2742a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m2735a(android.content.Context r5, long r6) {
        /*
            r4 = this;
            r2 = 0
            java.lang.Object r3 = r4.f1406m
            monitor-enter(r3)
            java.util.WeakHashMap r0 = r4.f1407n     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x002b }
            android.support.v4.f.f r0 = (android.support.p009v4.p019f.C0141f) r0     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            r0 = r2
        L_0x0010:
            return r0
        L_0x0011:
            java.lang.Object r1 = r0.mo1055a((long) r6)     // Catch:{ all -> 0x002b }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0031
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x002b }
            android.graphics.drawable.Drawable$ConstantState r1 = (android.graphics.drawable.Drawable.ConstantState) r1     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x002e
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ all -> 0x002b }
            android.graphics.drawable.Drawable r0 = r1.newDrawable(r0)     // Catch:{ all -> 0x002b }
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            goto L_0x0010
        L_0x002b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            throw r0
        L_0x002e:
            r0.mo1059b((long) r6)     // Catch:{ all -> 0x002b }
        L_0x0031:
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            r0 = r2
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0591ap.m2735a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    public static C0591ap m2736a() {
        if (f1395b == null) {
            f1395b = new C0591ap();
            m2740a(f1395b);
        }
        return f1395b;
    }

    /* renamed from: a */
    private void m2737a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1403j == null) {
            this.f1403j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f1403j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f1403j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    /* renamed from: a */
    private static void m2738a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (C0624bv.m2855b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1394a;
        }
        drawable.setColorFilter(m2732a(i, mode));
    }

    /* renamed from: a */
    public static void m2739a(Drawable drawable, C0668dl dlVar, int[] iArr) {
        if (!C0624bv.m2855b(drawable) || drawable.mutate() == drawable) {
            if (dlVar.f1648d || dlVar.f1647c) {
                drawable.setColorFilter(m2733a(dlVar.f1648d ? dlVar.f1645a : null, dlVar.f1647c ? dlVar.f1646b : f1394a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    /* renamed from: a */
    private static void m2740a(C0591ap apVar) {
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            apVar.m2741a("vector", (C0595at) new C0596au());
            if (i >= 11) {
                apVar.m2741a("animated-vector", (C0595at) new C0593ar());
            }
        }
    }

    /* renamed from: a */
    private void m2741a(String str, C0595at atVar) {
        if (this.f1404k == null) {
            this.f1404k = new C0136a();
        }
        this.f1404k.put(str, atVar);
    }

    /* renamed from: a */
    static boolean m2742a(Context context, int i, Drawable drawable) {
        int i2;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        PorterDuff.Mode mode2 = f1394a;
        if (m2745a(f1397d, i)) {
            i3 = C0506b.colorControlNormal;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (m2745a(f1399f, i)) {
            i3 = C0506b.colorControlActivated;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (m2745a(f1400g, i)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = 16842801;
            i2 = -1;
        } else if (i == C0510f.abc_list_divider_mtrl_alpha) {
            i3 = 16842800;
            i2 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == C0510f.abc_dialog_material_background) {
            i3 = 16842801;
            mode = mode2;
            z = true;
            i2 = -1;
        } else {
            i2 = -1;
            i3 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (C0624bv.m2855b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(m2732a(C0665di.m3003a(context, i3), mode));
        if (i2 == -1) {
            return true;
        }
        drawable.setAlpha(i2);
        return true;
    }

    /* renamed from: a */
    private boolean m2743a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f1406m) {
            C0141f fVar = (C0141f) this.f1407n.get(context);
            if (fVar == null) {
                fVar = new C0141f();
                this.f1407n.put(context, fVar);
            }
            fVar.mo1060b(j, new WeakReference(constantState));
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m2744a(Drawable drawable) {
        return (drawable instanceof C0016l) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* renamed from: a */
    private static boolean m2745a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private ColorStateList m2746b(Context context) {
        return m2752f(context, 0);
    }

    /* renamed from: c */
    private ColorStateList m2747c(Context context) {
        return m2752f(context, C0665di.m3003a(context, C0506b.colorAccent));
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m2748c(android.content.Context r9, int r10) {
        /*
            r8 = this;
            r7 = 1
            android.util.TypedValue r0 = r8.f1408o
            if (r0 != 0) goto L_0x000c
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r8.f1408o = r0
        L_0x000c:
            android.util.TypedValue r1 = r8.f1408o
            android.content.res.Resources r0 = r9.getResources()
            r0.getValue(r10, r1, r7)
            long r2 = m2730a((android.util.TypedValue) r1)
            android.graphics.drawable.Drawable r0 = r8.m2735a((android.content.Context) r9, (long) r2)
            if (r0 == 0) goto L_0x0020
        L_0x001f:
            return r0
        L_0x0020:
            int r4 = android.support.p021v7.p023b.C0510f.abc_cab_background_top_material
            if (r10 != r4) goto L_0x0048
            android.graphics.drawable.LayerDrawable r0 = new android.graphics.drawable.LayerDrawable
            r4 = 2
            android.graphics.drawable.Drawable[] r4 = new android.graphics.drawable.Drawable[r4]
            r5 = 0
            int r6 = android.support.p021v7.p023b.C0510f.abc_cab_background_internal_bg
            android.graphics.drawable.Drawable r6 = r8.mo2982a((android.content.Context) r9, (int) r6)
            r4[r5] = r6
            int r5 = android.support.p021v7.p023b.C0510f.abc_cab_background_top_mtrl_alpha
            android.graphics.drawable.Drawable r5 = r8.mo2982a((android.content.Context) r9, (int) r5)
            r4[r7] = r5
            r0.<init>(r4)
        L_0x003d:
            if (r0 == 0) goto L_0x001f
            int r1 = r1.changingConfigurations
            r0.setChangingConfigurations(r1)
            r8.m2743a((android.content.Context) r9, (long) r2, (android.graphics.drawable.Drawable) r0)
            goto L_0x001f
        L_0x0048:
            int r4 = android.support.p021v7.p023b.C0510f.abc_btn_check_material
            if (r10 != r4) goto L_0x0068
            android.graphics.drawable.StateListDrawable r0 = new android.graphics.drawable.StateListDrawable
            r0.<init>()
            int[] r4 = android.support.p021v7.widget.C0665di.f1637e
            int r5 = android.support.p021v7.p023b.C0510f.abc_btn_checkbox_checked_mtrl
            android.graphics.drawable.Drawable r5 = r8.mo2982a((android.content.Context) r9, (int) r5)
            r0.addState(r4, r5)
            int[] r4 = android.support.p021v7.widget.C0665di.f1640h
            int r5 = android.support.p021v7.p023b.C0510f.abc_btn_checkbox_unchecked_mtrl
            android.graphics.drawable.Drawable r5 = r8.mo2982a((android.content.Context) r9, (int) r5)
            r0.addState(r4, r5)
            goto L_0x003d
        L_0x0068:
            int r4 = android.support.p021v7.p023b.C0510f.abc_btn_radio_material
            if (r10 != r4) goto L_0x003d
            android.graphics.drawable.StateListDrawable r0 = new android.graphics.drawable.StateListDrawable
            r0.<init>()
            int[] r4 = android.support.p021v7.widget.C0665di.f1637e
            int r5 = android.support.p021v7.p023b.C0510f.abc_btn_radio_on_mtrl
            android.graphics.drawable.Drawable r5 = r8.mo2982a((android.content.Context) r9, (int) r5)
            r0.addState(r4, r5)
            int[] r4 = android.support.p021v7.widget.C0665di.f1640h
            int r5 = android.support.p021v7.p023b.C0510f.abc_btn_radio_off_mtrl
            android.graphics.drawable.Drawable r5 = r8.mo2982a((android.content.Context) r9, (int) r5)
            r0.addState(r4, r5)
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0591ap.m2748c(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m2749d(android.content.Context r10, int r11) {
        /*
            r9 = this;
            r1 = 0
            r8 = 2
            r7 = 1
            android.support.v4.f.a r0 = r9.f1404k
            if (r0 == 0) goto L_0x00bf
            android.support.v4.f.a r0 = r9.f1404k
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00bf
            android.util.SparseArray r0 = r9.f1405l
            if (r0 == 0) goto L_0x002f
            android.util.SparseArray r0 = r9.f1405l
            java.lang.Object r0 = r0.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "appcompat_skip_skip"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x002d
            if (r0 == 0) goto L_0x0036
            android.support.v4.f.a r2 = r9.f1404k
            java.lang.Object r0 = r2.get(r0)
            if (r0 != 0) goto L_0x0036
        L_0x002d:
            r0 = r1
        L_0x002e:
            return r0
        L_0x002f:
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            r9.f1405l = r0
        L_0x0036:
            android.util.TypedValue r0 = r9.f1408o
            if (r0 != 0) goto L_0x0041
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r9.f1408o = r0
        L_0x0041:
            android.util.TypedValue r2 = r9.f1408o
            android.content.res.Resources r0 = r10.getResources()
            r0.getValue(r11, r2, r7)
            long r4 = m2730a((android.util.TypedValue) r2)
            android.graphics.drawable.Drawable r1 = r9.m2735a((android.content.Context) r10, (long) r4)
            if (r1 == 0) goto L_0x0056
            r0 = r1
            goto L_0x002e
        L_0x0056:
            java.lang.CharSequence r3 = r2.string
            if (r3 == 0) goto L_0x008a
            java.lang.CharSequence r3 = r2.string
            java.lang.String r3 = r3.toString()
            java.lang.String r6 = ".xml"
            boolean r3 = r3.endsWith(r6)
            if (r3 == 0) goto L_0x008a
            android.content.res.XmlResourceParser r3 = r0.getXml(r11)     // Catch:{ Exception -> 0x0082 }
            android.util.AttributeSet r6 = android.util.Xml.asAttributeSet(r3)     // Catch:{ Exception -> 0x0082 }
        L_0x0070:
            int r0 = r3.next()     // Catch:{ Exception -> 0x0082 }
            if (r0 == r8) goto L_0x0078
            if (r0 != r7) goto L_0x0070
        L_0x0078:
            if (r0 == r8) goto L_0x0095
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0082 }
            java.lang.String r2 = "No start tag found"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0082 }
            throw r0     // Catch:{ Exception -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            java.lang.String r2 = "AppCompatDrawableManager"
            java.lang.String r3 = "Exception while inflating drawable"
            android.util.Log.e(r2, r3, r0)
        L_0x008a:
            r0 = r1
        L_0x008b:
            if (r0 != 0) goto L_0x002e
            android.util.SparseArray r1 = r9.f1405l
            java.lang.String r2 = "appcompat_skip_skip"
            r1.append(r11, r2)
            goto L_0x002e
        L_0x0095:
            java.lang.String r0 = r3.getName()     // Catch:{ Exception -> 0x0082 }
            android.util.SparseArray r7 = r9.f1405l     // Catch:{ Exception -> 0x0082 }
            r7.append(r11, r0)     // Catch:{ Exception -> 0x0082 }
            android.support.v4.f.a r7 = r9.f1404k     // Catch:{ Exception -> 0x0082 }
            java.lang.Object r0 = r7.get(r0)     // Catch:{ Exception -> 0x0082 }
            android.support.v7.widget.at r0 = (android.support.p021v7.widget.C0595at) r0     // Catch:{ Exception -> 0x0082 }
            if (r0 == 0) goto L_0x00b0
            android.content.res.Resources$Theme r7 = r10.getTheme()     // Catch:{ Exception -> 0x0082 }
            android.graphics.drawable.Drawable r1 = r0.mo2985a(r10, r3, r6, r7)     // Catch:{ Exception -> 0x0082 }
        L_0x00b0:
            if (r1 == 0) goto L_0x00bd
            int r0 = r2.changingConfigurations     // Catch:{ Exception -> 0x0082 }
            r1.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x0082 }
            boolean r0 = r9.m2743a((android.content.Context) r10, (long) r4, (android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x0082 }
            if (r0 == 0) goto L_0x00bd
        L_0x00bd:
            r0 = r1
            goto L_0x008b
        L_0x00bf:
            r0 = r1
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0591ap.m2749d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* renamed from: d */
    private void m2750d(Context context) {
        if (this.f1409p) {
            Drawable a = mo2982a(context, C0510f.abc_ic_ab_back_material);
            if (a == null || !m2744a(a)) {
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
            this.f1409p = true;
        }
    }

    /* renamed from: e */
    private ColorStateList m2751e(Context context, int i) {
        if (this.f1403j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f1403j.get(context);
        if (sparseArray != null) {
            return (ColorStateList) sparseArray.get(i);
        }
        return null;
    }

    /* renamed from: f */
    private ColorStateList m2752f(Context context, int i) {
        int a = C0665di.m3003a(context, C0506b.colorControlHighlight);
        return new ColorStateList(new int[][]{C0665di.f1633a, C0665di.f1636d, C0665di.f1634b, C0665di.f1640h}, new int[]{C0665di.m3007c(context, C0506b.colorButtonNormal), C0094a.m190a(a, i), C0094a.m190a(a, i), i});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PorterDuff.Mode mo2981a(int i) {
        if (i == C0510f.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    /* renamed from: a */
    public Drawable mo2982a(Context context, int i) {
        return mo2983a(context, i, false);
    }

    /* renamed from: a */
    public Drawable mo2983a(Context context, int i, boolean z) {
        m2750d(context);
        Drawable d = m2749d(context, i);
        if (d == null) {
            d = m2748c(context, i);
        }
        if (d == null) {
            d = C0025a.getDrawable(context, i);
        }
        if (d != null) {
            d = m2734a(context, i, z, d);
        }
        if (d != null) {
            C0624bv.m2854a(d);
        }
        return d;
    }

    /* renamed from: b */
    public final ColorStateList mo2984b(Context context, int i) {
        ColorStateList e = m2751e(context, i);
        if (e == null) {
            if (i == C0510f.abc_edit_text_material) {
                e = C0620br.m2806a(context, C0508d.abc_tint_edittext);
            } else if (i == C0510f.abc_switch_track_mtrl_alpha) {
                e = C0620br.m2806a(context, C0508d.abc_tint_switch_track);
            } else if (i == C0510f.abc_switch_thumb_material) {
                e = C0620br.m2806a(context, C0508d.abc_tint_switch_thumb);
            } else if (i == C0510f.abc_btn_default_mtrl_shape) {
                e = m2731a(context);
            } else if (i == C0510f.abc_btn_borderless_material) {
                e = m2746b(context);
            } else if (i == C0510f.abc_btn_colored_material) {
                e = m2747c(context);
            } else if (i == C0510f.abc_spinner_mtrl_am_alpha || i == C0510f.abc_spinner_textfield_background_material) {
                e = C0620br.m2806a(context, C0508d.abc_tint_spinner);
            } else if (m2745a(f1398e, i)) {
                e = C0665di.m3006b(context, C0506b.colorControlNormal);
            } else if (m2745a(f1401h, i)) {
                e = C0620br.m2806a(context, C0508d.abc_tint_default);
            } else if (m2745a(f1402i, i)) {
                e = C0620br.m2806a(context, C0508d.abc_tint_btn_checkable);
            } else if (i == C0510f.abc_seekbar_thumb_material) {
                e = C0620br.m2806a(context, C0508d.abc_tint_seek_thumb);
            }
            if (e != null) {
                m2737a(context, i, e);
            }
        }
        return e;
    }
}
