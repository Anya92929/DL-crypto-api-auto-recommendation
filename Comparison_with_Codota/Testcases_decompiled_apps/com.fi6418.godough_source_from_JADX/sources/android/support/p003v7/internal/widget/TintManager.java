package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.graphics.ColorUtils;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p000v4.util.LruCache;
import android.support.p003v7.appcompat.C0235R;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.internal.widget.TintManager */
public final class TintManager {
    public static final boolean SHOULD_BE_USED = (Build.VERSION.SDK_INT < 21);

    /* renamed from: a */
    private static final PorterDuff.Mode f2381a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private static final WeakHashMap<Context, TintManager> f2382b = new WeakHashMap<>();

    /* renamed from: c */
    private static final ColorFilterLruCache f2383c = new ColorFilterLruCache(6);

    /* renamed from: d */
    private static final int[] f2384d = {C0235R.C0236drawable.abc_textfield_search_default_mtrl_alpha, C0235R.C0236drawable.abc_textfield_default_mtrl_alpha, C0235R.C0236drawable.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: e */
    private static final int[] f2385e = {C0235R.C0236drawable.abc_ic_ab_back_mtrl_am_alpha, C0235R.C0236drawable.abc_ic_go_search_api_mtrl_alpha, C0235R.C0236drawable.abc_ic_search_api_mtrl_alpha, C0235R.C0236drawable.abc_ic_commit_search_api_mtrl_alpha, C0235R.C0236drawable.abc_ic_clear_mtrl_alpha, C0235R.C0236drawable.abc_ic_menu_share_mtrl_alpha, C0235R.C0236drawable.abc_ic_menu_copy_mtrl_am_alpha, C0235R.C0236drawable.abc_ic_menu_cut_mtrl_alpha, C0235R.C0236drawable.abc_ic_menu_selectall_mtrl_alpha, C0235R.C0236drawable.abc_ic_menu_paste_mtrl_am_alpha, C0235R.C0236drawable.abc_ic_menu_moreoverflow_mtrl_alpha, C0235R.C0236drawable.abc_ic_voice_search_api_mtrl_alpha};

    /* renamed from: f */
    private static final int[] f2386f = {C0235R.C0236drawable.abc_textfield_activated_mtrl_alpha, C0235R.C0236drawable.abc_textfield_search_activated_mtrl_alpha, C0235R.C0236drawable.abc_cab_background_top_mtrl_alpha, C0235R.C0236drawable.abc_text_cursor_material};

    /* renamed from: g */
    private static final int[] f2387g = {C0235R.C0236drawable.abc_popup_background_mtrl_mult, C0235R.C0236drawable.abc_cab_background_internal_bg, C0235R.C0236drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: h */
    private static final int[] f2388h = {C0235R.C0236drawable.abc_edit_text_material, C0235R.C0236drawable.abc_tab_indicator_material, C0235R.C0236drawable.abc_textfield_search_material, C0235R.C0236drawable.abc_spinner_mtrl_am_alpha, C0235R.C0236drawable.abc_spinner_textfield_background_material, C0235R.C0236drawable.abc_ratingbar_full_material, C0235R.C0236drawable.abc_switch_track_mtrl_alpha, C0235R.C0236drawable.abc_switch_thumb_material, C0235R.C0236drawable.abc_btn_default_mtrl_shape, C0235R.C0236drawable.abc_btn_borderless_material};

    /* renamed from: i */
    private static final int[] f2389i = {C0235R.C0236drawable.abc_btn_check_material, C0235R.C0236drawable.abc_btn_radio_material};

    /* renamed from: j */
    private final WeakReference<Context> f2390j;

    /* renamed from: k */
    private SparseArray<ColorStateList> f2391k;

    /* renamed from: l */
    private ColorStateList f2392l;

    /* renamed from: android.support.v7.internal.widget.TintManager$ColorFilterLruCache */
    class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        /* renamed from: b */
        private static int m1530b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo4680a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(m1530b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo4681a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(m1530b(i, mode)), porterDuffColorFilter);
        }
    }

    private TintManager(Context context) {
        this.f2390j = new WeakReference<>(context);
    }

    /* renamed from: a */
    private ColorStateList m1516a(Context context) {
        if (this.f2392l == null) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlNormal);
            int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlActivated);
            this.f2392l = new ColorStateList(new int[][]{ThemeUtils.f2367a, ThemeUtils.f2368b, ThemeUtils.f2369c, ThemeUtils.f2370d, ThemeUtils.f2371e, ThemeUtils.f2372f, ThemeUtils.f2374h}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0235R.attr.colorControlNormal), themeAttrColor2, themeAttrColor2, themeAttrColor2, themeAttrColor2, themeAttrColor2, themeAttrColor});
        }
        return this.f2392l;
    }

    /* renamed from: a */
    private ColorStateList m1517a(Context context, int i) {
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, i);
        int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{ThemeUtils.f2367a, ThemeUtils.f2370d, ThemeUtils.f2368b, ThemeUtils.f2374h}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0235R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor2, themeAttrColor), ColorUtils.compositeColors(themeAttrColor2, themeAttrColor), themeAttrColor});
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m1518a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a = f2383c.mo4680a(i, mode);
        if (a != null) {
            return a;
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        f2383c.mo4681a(i, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m1519a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m1518a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    private static boolean m1520a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private ColorStateList m1521b(Context context) {
        return new ColorStateList(new int[][]{ThemeUtils.f2367a, ThemeUtils.f2371e, ThemeUtils.f2374h}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0235R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlActivated), ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlNormal)});
    }

    /* renamed from: b */
    private static boolean m1522b(int i) {
        return m1520a(f2385e, i) || m1520a(f2384d, i) || m1520a(f2386f, i) || m1520a(f2388h, i) || m1520a(f2387g, i) || m1520a(f2389i, i) || i == C0235R.C0236drawable.abc_cab_background_top_material;
    }

    /* renamed from: c */
    private ColorStateList m1523c(Context context) {
        return new ColorStateList(new int[][]{ThemeUtils.f2367a, ThemeUtils.f2371e, ThemeUtils.f2374h}, new int[]{ThemeUtils.m1514a(context, 16842800, 0.1f), ThemeUtils.m1514a(context, C0235R.attr.colorControlActivated, 0.3f), ThemeUtils.m1514a(context, 16842800, 0.3f)});
    }

    /* renamed from: d */
    private ColorStateList m1524d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, C0235R.attr.colorSwitchThumbNormal);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            iArr[0] = ThemeUtils.f2367a;
            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, C0235R.attr.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.f2371e;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.f2374h;
            iArr2[2] = ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = ThemeUtils.f2367a;
            iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
            iArr[1] = ThemeUtils.f2371e;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.f2374h;
            iArr2[2] = themeAttrColorStateList.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* renamed from: e */
    private ColorStateList m1525e(Context context) {
        return new ColorStateList(new int[][]{ThemeUtils.f2367a, ThemeUtils.f2373g, ThemeUtils.f2374h}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0235R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlActivated)});
    }

    /* renamed from: f */
    private ColorStateList m1526f(Context context) {
        return m1517a(context, C0235R.attr.colorButtonNormal);
    }

    /* renamed from: g */
    private ColorStateList m1527g(Context context) {
        return m1517a(context, C0235R.attr.colorAccent);
    }

    public static TintManager get(Context context) {
        TintManager tintManager = f2382b.get(context);
        if (tintManager != null) {
            return tintManager;
        }
        TintManager tintManager2 = new TintManager(context);
        f2382b.put(context, tintManager2);
        return tintManager2;
    }

    public static Drawable getDrawable(Context context, int i) {
        return m1522b(i) ? get(context).getDrawable(i) : ContextCompat.getDrawable(context, i);
    }

    /* renamed from: h */
    private ColorStateList m1528h(Context context) {
        return new ColorStateList(new int[][]{ThemeUtils.f2367a, ThemeUtils.f2373g, ThemeUtils.f2374h}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0235R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0235R.attr.colorControlActivated)});
    }

    public static void tintViewBackground(View view, TintInfo tintInfo) {
        Drawable background = view.getBackground();
        if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
            background.setColorFilter(m1519a(tintInfo.mHasTintList ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : f2381a, view.getDrawableState()));
        } else {
            background.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 10) {
            view.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PorterDuff.Mode mo4675a(int i) {
        if (i == C0235R.C0236drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public Drawable getDrawable(int i) {
        return getDrawable(i, false);
    }

    public Drawable getDrawable(int i, boolean z) {
        Context context = (Context) this.f2390j.get();
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
                PorterDuff.Mode a = mo4675a(i);
                if (a != null) {
                    DrawableCompat.setTintMode(drawable, a);
                }
            } else if (i == C0235R.C0236drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{getDrawable(C0235R.C0236drawable.abc_cab_background_internal_bg), getDrawable(C0235R.C0236drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (!tintDrawableUsingColorFilter(i, drawable) && z) {
                drawable = null;
            }
        }
        return drawable;
    }

    public final ColorStateList getTintList(int i) {
        ColorStateList colorStateList = null;
        Context context = (Context) this.f2390j.get();
        if (context == null) {
            return null;
        }
        if (this.f2391k != null) {
            colorStateList = this.f2391k.get(i);
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList e = i == C0235R.C0236drawable.abc_edit_text_material ? m1525e(context) : i == C0235R.C0236drawable.abc_switch_track_mtrl_alpha ? m1523c(context) : i == C0235R.C0236drawable.abc_switch_thumb_material ? m1524d(context) : (i == C0235R.C0236drawable.abc_btn_default_mtrl_shape || i == C0235R.C0236drawable.abc_btn_borderless_material) ? m1526f(context) : i == C0235R.C0236drawable.abc_btn_colored_material ? m1527g(context) : (i == C0235R.C0236drawable.abc_spinner_mtrl_am_alpha || i == C0235R.C0236drawable.abc_spinner_textfield_background_material) ? m1528h(context) : m1520a(f2385e, i) ? ThemeUtils.getThemeAttrColorStateList(context, C0235R.attr.colorControlNormal) : m1520a(f2388h, i) ? m1516a(context) : m1520a(f2389i, i) ? m1521b(context) : colorStateList;
        if (e == null) {
            return e;
        }
        if (this.f2391k == null) {
            this.f2391k = new SparseArray<>();
        }
        this.f2391k.append(i, e);
        return e;
    }

    public final boolean tintDrawableUsingColorFilter(int i, Drawable drawable) {
        int i2;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        Context context = (Context) this.f2390j.get();
        if (context == null) {
            return false;
        }
        PorterDuff.Mode mode2 = f2381a;
        if (m1520a(f2384d, i)) {
            i3 = C0235R.attr.colorControlNormal;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (m1520a(f2386f, i)) {
            i3 = C0235R.attr.colorControlActivated;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (m1520a(f2387g, i)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = 16842801;
            i2 = -1;
        } else if (i == C0235R.C0236drawable.abc_list_divider_mtrl_alpha) {
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
        drawable.setColorFilter(m1518a(ThemeUtils.getThemeAttrColor(context, i3), mode));
        if (i2 != -1) {
            drawable.setAlpha(i2);
        }
        return true;
    }
}
