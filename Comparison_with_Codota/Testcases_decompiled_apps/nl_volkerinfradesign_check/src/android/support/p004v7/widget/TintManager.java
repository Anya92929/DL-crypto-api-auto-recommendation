package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.graphics.ColorUtils;
import android.support.p001v4.graphics.drawable.DrawableCompat;
import android.support.p001v4.util.LruCache;
import android.support.p004v7.appcompat.C0505R;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.TintManager */
public final class TintManager {
    public static final boolean SHOULD_BE_USED = (Build.VERSION.SDK_INT < 21);

    /* renamed from: a */
    private static final PorterDuff.Mode f2304a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private static final WeakHashMap<Context, TintManager> f2305b = new WeakHashMap<>();

    /* renamed from: c */
    private static final C0588a f2306c = new C0588a(6);

    /* renamed from: d */
    private static final int[] f2307d = {C0505R.C0506drawable.abc_textfield_search_default_mtrl_alpha, C0505R.C0506drawable.abc_textfield_default_mtrl_alpha, C0505R.C0506drawable.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: e */
    private static final int[] f2308e = {C0505R.C0506drawable.abc_ic_ab_back_mtrl_am_alpha, C0505R.C0506drawable.abc_ic_go_search_api_mtrl_alpha, C0505R.C0506drawable.abc_ic_search_api_mtrl_alpha, C0505R.C0506drawable.abc_ic_commit_search_api_mtrl_alpha, C0505R.C0506drawable.abc_ic_clear_mtrl_alpha, C0505R.C0506drawable.abc_ic_menu_share_mtrl_alpha, C0505R.C0506drawable.abc_ic_menu_copy_mtrl_am_alpha, C0505R.C0506drawable.abc_ic_menu_cut_mtrl_alpha, C0505R.C0506drawable.abc_ic_menu_selectall_mtrl_alpha, C0505R.C0506drawable.abc_ic_menu_paste_mtrl_am_alpha, C0505R.C0506drawable.abc_ic_menu_moreoverflow_mtrl_alpha, C0505R.C0506drawable.abc_ic_voice_search_api_mtrl_alpha};

    /* renamed from: f */
    private static final int[] f2309f = {C0505R.C0506drawable.abc_textfield_activated_mtrl_alpha, C0505R.C0506drawable.abc_textfield_search_activated_mtrl_alpha, C0505R.C0506drawable.abc_cab_background_top_mtrl_alpha, C0505R.C0506drawable.abc_text_cursor_material};

    /* renamed from: g */
    private static final int[] f2310g = {C0505R.C0506drawable.abc_popup_background_mtrl_mult, C0505R.C0506drawable.abc_cab_background_internal_bg, C0505R.C0506drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: h */
    private static final int[] f2311h = {C0505R.C0506drawable.abc_edit_text_material, C0505R.C0506drawable.abc_tab_indicator_material, C0505R.C0506drawable.abc_textfield_search_material, C0505R.C0506drawable.abc_spinner_mtrl_am_alpha, C0505R.C0506drawable.abc_spinner_textfield_background_material, C0505R.C0506drawable.abc_ratingbar_full_material, C0505R.C0506drawable.abc_switch_track_mtrl_alpha, C0505R.C0506drawable.abc_switch_thumb_material, C0505R.C0506drawable.abc_btn_default_mtrl_shape, C0505R.C0506drawable.abc_btn_borderless_material};

    /* renamed from: i */
    private static final int[] f2312i = {C0505R.C0506drawable.abc_btn_check_material, C0505R.C0506drawable.abc_btn_radio_material};

    /* renamed from: j */
    private final WeakReference<Context> f2313j;

    /* renamed from: k */
    private SparseArray<ColorStateList> f2314k;

    /* renamed from: l */
    private ColorStateList f2315l;

    public static Drawable getDrawable(Context context, int i) {
        if (m3342b(i)) {
            return get(context).getDrawable(i);
        }
        return ContextCompat.getDrawable(context, i);
    }

    public static TintManager get(Context context) {
        TintManager tintManager = f2305b.get(context);
        if (tintManager != null) {
            return tintManager;
        }
        TintManager tintManager2 = new TintManager(context);
        f2305b.put(context, tintManager2);
        return tintManager2;
    }

    private TintManager(Context context) {
        this.f2313j = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) {
        return getDrawable(i, false);
    }

    public Drawable getDrawable(int i, boolean z) {
        Context context = (Context) this.f2313j.get();
        if (context == null) {
            return null;
        }
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable != null) {
            if (Build.VERSION.SDK_INT >= 8) {
                drawable = drawable.mutate();
            }
            ColorStateList tintList = getTintList(i);
            if (tintList != null) {
                drawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(drawable, tintList);
                PorterDuff.Mode a = mo4542a(i);
                if (a != null) {
                    DrawableCompat.setTintMode(drawable, a);
                }
            } else if (i == C0505R.C0506drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{getDrawable(C0505R.C0506drawable.abc_cab_background_internal_bg), getDrawable(C0505R.C0506drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i == C0505R.C0506drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m3338a(layerDrawable.findDrawableByLayerId(16908288), C1188ha.m5254a(context, C0505R.attr.colorControlNormal), f2304a);
                m3338a(layerDrawable.findDrawableByLayerId(16908303), C1188ha.m5254a(context, C0505R.attr.colorControlNormal), f2304a);
                m3338a(layerDrawable.findDrawableByLayerId(16908301), C1188ha.m5254a(context, C0505R.attr.colorControlActivated), f2304a);
            } else if (!tintDrawableUsingColorFilter(i, drawable) && z) {
                drawable = null;
            }
        }
        return drawable;
    }

    public final boolean tintDrawableUsingColorFilter(int i, Drawable drawable) {
        int i2;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        Context context = (Context) this.f2313j.get();
        if (context == null) {
            return false;
        }
        PorterDuff.Mode mode2 = f2304a;
        if (m3340a(f2307d, i)) {
            i3 = C0505R.attr.colorControlNormal;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (m3340a(f2309f, i)) {
            i3 = C0505R.attr.colorControlActivated;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (m3340a(f2310g, i)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = 16842801;
            i2 = -1;
        } else if (i == C0505R.C0506drawable.abc_list_divider_mtrl_alpha) {
            i3 = 16842800;
            i2 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i2 = -1;
            i3 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        drawable.setColorFilter(m3336a(C1188ha.m5254a(context, i3), mode));
        if (i2 != -1) {
            drawable.setAlpha(i2);
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m3340a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m3342b(int i) {
        return m3340a(f2308e, i) || m3340a(f2307d, i) || m3340a(f2309f, i) || m3340a(f2311h, i) || m3340a(f2310g, i) || m3340a(f2312i, i) || i == C0505R.C0506drawable.abc_cab_background_top_material;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PorterDuff.Mode mo4542a(int i) {
        if (i == C0505R.C0506drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public final ColorStateList getTintList(int i) {
        ColorStateList f;
        ColorStateList colorStateList = null;
        Context context = (Context) this.f2313j.get();
        if (context == null) {
            return null;
        }
        if (this.f2314k != null) {
            colorStateList = this.f2314k.get(i);
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        if (i == C0505R.C0506drawable.abc_edit_text_material) {
            f = m3345e(context);
        } else if (i == C0505R.C0506drawable.abc_switch_track_mtrl_alpha) {
            f = m3343c(context);
        } else if (i == C0505R.C0506drawable.abc_switch_thumb_material) {
            f = m3344d(context);
        } else if (i == C0505R.C0506drawable.abc_btn_default_mtrl_shape || i == C0505R.C0506drawable.abc_btn_borderless_material) {
            f = m3346f(context);
        } else if (i == C0505R.C0506drawable.abc_btn_colored_material) {
            f = m3347g(context);
        } else if (i == C0505R.C0506drawable.abc_spinner_mtrl_am_alpha || i == C0505R.C0506drawable.abc_spinner_textfield_background_material) {
            f = m3348h(context);
        } else if (m3340a(f2308e, i)) {
            f = C1188ha.m5257b(context, C0505R.attr.colorControlNormal);
        } else if (m3340a(f2311h, i)) {
            f = m3334a(context);
        } else if (m3340a(f2312i, i)) {
            f = m3341b(context);
        } else {
            f = i == C0505R.C0506drawable.abc_seekbar_thumb_material ? m3349i(context) : colorStateList;
        }
        if (f == null) {
            return f;
        }
        if (this.f2314k == null) {
            this.f2314k = new SparseArray<>();
        }
        this.f2314k.append(i, f);
        return f;
    }

    /* renamed from: a */
    private ColorStateList m3334a(Context context) {
        if (this.f2315l == null) {
            int a = C1188ha.m5254a(context, C0505R.attr.colorControlNormal);
            int a2 = C1188ha.m5254a(context, C0505R.attr.colorControlActivated);
            this.f2315l = new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4238b, C1188ha.f4239c, C1188ha.f4240d, C1188ha.f4241e, C1188ha.f4242f, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlNormal), a2, a2, a2, a2, a2, a});
        }
        return this.f2315l;
    }

    /* renamed from: b */
    private ColorStateList m3341b(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4241e, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlActivated), C1188ha.m5254a(context, C0505R.attr.colorControlNormal)});
    }

    /* renamed from: c */
    private ColorStateList m3343c(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4241e, C1188ha.f4244h}, new int[]{C1188ha.m5255a(context, 16842800, 0.1f), C1188ha.m5255a(context, C0505R.attr.colorControlActivated, 0.3f), C1188ha.m5255a(context, 16842800, 0.3f)});
    }

    /* renamed from: d */
    private ColorStateList m3344d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = C1188ha.m5257b(context, C0505R.attr.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = C1188ha.f4237a;
            iArr2[0] = C1188ha.m5258c(context, C0505R.attr.colorSwitchThumbNormal);
            iArr[1] = C1188ha.f4241e;
            iArr2[1] = C1188ha.m5254a(context, C0505R.attr.colorControlActivated);
            iArr[2] = C1188ha.f4244h;
            iArr2[2] = C1188ha.m5254a(context, C0505R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = C1188ha.f4237a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = C1188ha.f4241e;
            iArr2[1] = C1188ha.m5254a(context, C0505R.attr.colorControlActivated);
            iArr[2] = C1188ha.f4244h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* renamed from: e */
    private ColorStateList m3345e(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4243g, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlActivated)});
    }

    /* renamed from: f */
    private ColorStateList m3346f(Context context) {
        return m3335a(context, C0505R.attr.colorButtonNormal);
    }

    /* renamed from: g */
    private ColorStateList m3347g(Context context) {
        return m3335a(context, C0505R.attr.colorAccent);
    }

    /* renamed from: a */
    private ColorStateList m3335a(Context context, int i) {
        int a = C1188ha.m5254a(context, i);
        int a2 = C1188ha.m5254a(context, C0505R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4240d, C1188ha.f4238b, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorButtonNormal), ColorUtils.compositeColors(a2, a), ColorUtils.compositeColors(a2, a), a});
    }

    /* renamed from: h */
    private ColorStateList m3348h(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4243g, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlActivated)});
    }

    /* renamed from: i */
    private ColorStateList m3349i(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlActivated), C1188ha.m5254a(context, C0505R.attr.colorControlActivated)});
    }

    /* renamed from: android.support.v7.widget.TintManager$a */
    static class C0588a extends LruCache<Integer, PorterDuffColorFilter> {
        public C0588a(int i) {
            super(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo4547a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(m3351b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo4548a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(m3351b(i, mode)), porterDuffColorFilter);
        }

        /* renamed from: b */
        private static int m3351b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    public static void tintDrawable(Drawable drawable, C1191hc hcVar, int[] iArr) {
        if (!m3339a(drawable) || drawable.mutate() == drawable) {
            if (hcVar.f4252d || hcVar.f4251c) {
                drawable.setColorFilter(m3337a(hcVar.f4252d ? hcVar.f4249a : null, hcVar.f4251c ? hcVar.f4250b : f2304a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 10) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("TintManager", "Mutated drawable is not the same instance as the input.");
    }

    /* renamed from: a */
    private static boolean m3339a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            return true;
        }
        if (drawable instanceof LayerDrawable) {
            return Build.VERSION.SDK_INT >= 16;
        } else if (drawable instanceof InsetDrawable) {
            if (Build.VERSION.SDK_INT < 14) {
                return false;
            }
            return true;
        } else if (!(drawable instanceof DrawableContainer)) {
            return true;
        } else {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable a : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!m3339a(a)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m3337a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m3336a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m3336a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a = f2306c.mo4547a(i, mode);
        if (a != null) {
            return a;
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        f2306c.mo4548a(i, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    /* renamed from: a */
    private static void m3338a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (mode == null) {
            mode = f2304a;
        }
        drawable.setColorFilter(m3336a(i, mode));
    }
}
