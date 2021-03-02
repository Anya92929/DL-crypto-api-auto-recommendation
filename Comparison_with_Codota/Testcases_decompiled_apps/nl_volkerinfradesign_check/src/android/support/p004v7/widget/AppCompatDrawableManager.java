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
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.graphics.ColorUtils;
import android.support.p001v4.graphics.drawable.DrawableCompat;
import android.support.p001v4.util.LruCache;
import android.support.p004v7.appcompat.C0505R;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.AppCompatDrawableManager */
public final class AppCompatDrawableManager {

    /* renamed from: a */
    private static final PorterDuff.Mode f2003a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private static AppCompatDrawableManager f2004b;

    /* renamed from: c */
    private static final C0545a f2005c = new C0545a(6);

    /* renamed from: d */
    private static final int[] f2006d = {C0505R.C0506drawable.abc_textfield_search_default_mtrl_alpha, C0505R.C0506drawable.abc_textfield_default_mtrl_alpha, C0505R.C0506drawable.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: e */
    private static final int[] f2007e = {C0505R.C0506drawable.abc_ic_ab_back_mtrl_am_alpha, C0505R.C0506drawable.abc_ic_go_search_api_mtrl_alpha, C0505R.C0506drawable.abc_ic_search_api_mtrl_alpha, C0505R.C0506drawable.abc_ic_commit_search_api_mtrl_alpha, C0505R.C0506drawable.abc_ic_clear_mtrl_alpha, C0505R.C0506drawable.abc_ic_menu_share_mtrl_alpha, C0505R.C0506drawable.abc_ic_menu_copy_mtrl_am_alpha, C0505R.C0506drawable.abc_ic_menu_cut_mtrl_alpha, C0505R.C0506drawable.abc_ic_menu_selectall_mtrl_alpha, C0505R.C0506drawable.abc_ic_menu_paste_mtrl_am_alpha, C0505R.C0506drawable.abc_ic_menu_moreoverflow_mtrl_alpha, C0505R.C0506drawable.abc_ic_voice_search_api_mtrl_alpha};

    /* renamed from: f */
    private static final int[] f2008f = {C0505R.C0506drawable.abc_textfield_activated_mtrl_alpha, C0505R.C0506drawable.abc_textfield_search_activated_mtrl_alpha, C0505R.C0506drawable.abc_cab_background_top_mtrl_alpha, C0505R.C0506drawable.abc_text_cursor_material};

    /* renamed from: g */
    private static final int[] f2009g = {C0505R.C0506drawable.abc_popup_background_mtrl_mult, C0505R.C0506drawable.abc_cab_background_internal_bg, C0505R.C0506drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: h */
    private static final int[] f2010h = {C0505R.C0506drawable.abc_edit_text_material, C0505R.C0506drawable.abc_tab_indicator_material, C0505R.C0506drawable.abc_textfield_search_material, C0505R.C0506drawable.abc_spinner_mtrl_am_alpha, C0505R.C0506drawable.abc_spinner_textfield_background_material, C0505R.C0506drawable.abc_ratingbar_full_material, C0505R.C0506drawable.abc_switch_track_mtrl_alpha, C0505R.C0506drawable.abc_switch_thumb_material, C0505R.C0506drawable.abc_btn_default_mtrl_shape, C0505R.C0506drawable.abc_btn_borderless_material};

    /* renamed from: i */
    private static final int[] f2011i = {C0505R.C0506drawable.abc_btn_check_material, C0505R.C0506drawable.abc_btn_radio_material};

    /* renamed from: j */
    private WeakHashMap<Context, SparseArray<ColorStateList>> f2012j;

    /* renamed from: k */
    private ArrayList<InflateDelegate> f2013k;

    /* renamed from: android.support.v7.widget.AppCompatDrawableManager$InflateDelegate */
    public interface InflateDelegate {
        @Nullable
        Drawable onInflateDrawable(@NonNull Context context, @DrawableRes int i);
    }

    public static AppCompatDrawableManager get() {
        if (f2004b == null) {
            f2004b = new AppCompatDrawableManager();
        }
        return f2004b;
    }

    public Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return getDrawable(context, i, false);
    }

    public Drawable getDrawable(@NonNull Context context, @DrawableRes int i, boolean z) {
        if (this.f2013k != null) {
            int size = this.f2013k.size();
            for (int i2 = 0; i2 < size; i2++) {
                Drawable onInflateDrawable = this.f2013k.get(i2).onInflateDrawable(context, i);
                if (onInflateDrawable != null) {
                    return onInflateDrawable;
                }
            }
        }
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable == null) {
            return drawable;
        }
        if (Build.VERSION.SDK_INT >= 8) {
            drawable = drawable.mutate();
        }
        ColorStateList tintList = getTintList(context, i);
        if (tintList != null) {
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, tintList);
            PorterDuff.Mode a = mo4099a(i);
            if (a == null) {
                return wrap;
            }
            DrawableCompat.setTintMode(wrap, a);
            return wrap;
        } else if (i == C0505R.C0506drawable.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{getDrawable(context, C0505R.C0506drawable.abc_cab_background_internal_bg), getDrawable(context, C0505R.C0506drawable.abc_cab_background_top_mtrl_alpha)});
        } else if (i == C0505R.C0506drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            m3170a(layerDrawable.findDrawableByLayerId(16908288), C1188ha.m5254a(context, C0505R.attr.colorControlNormal), f2003a);
            m3170a(layerDrawable.findDrawableByLayerId(16908303), C1188ha.m5254a(context, C0505R.attr.colorControlNormal), f2003a);
            m3170a(layerDrawable.findDrawableByLayerId(16908301), C1188ha.m5254a(context, C0505R.attr.colorControlActivated), f2003a);
            return drawable;
        } else if (tintDrawableUsingColorFilter(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    public final boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        int i2;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        PorterDuff.Mode mode2 = f2003a;
        if (m3172a(f2006d, i)) {
            i3 = C0505R.attr.colorControlNormal;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (m3172a(f2008f, i)) {
            i3 = C0505R.attr.colorControlActivated;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (m3172a(f2009g, i)) {
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
        drawable.setColorFilter(m3167a(C1188ha.m5254a(context, i3), mode));
        if (i2 == -1) {
            return true;
        }
        drawable.setAlpha(i2);
        return true;
    }

    public void addDelegate(@NonNull InflateDelegate inflateDelegate) {
        if (this.f2013k == null) {
            this.f2013k = new ArrayList<>();
        }
        if (!this.f2013k.contains(inflateDelegate)) {
            this.f2013k.add(inflateDelegate);
        }
    }

    public void removeDelegate(@NonNull InflateDelegate inflateDelegate) {
        if (this.f2013k != null) {
            this.f2013k.remove(inflateDelegate);
        }
    }

    /* renamed from: a */
    private static boolean m3172a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PorterDuff.Mode mo4099a(int i) {
        if (i == C0505R.C0506drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public final ColorStateList getTintList(@NonNull Context context, @DrawableRes int i) {
        ColorStateList a = m3166a(context, i);
        if (a == null) {
            if (i == C0505R.C0506drawable.abc_edit_text_material) {
                a = m3177e(context);
            } else if (i == C0505R.C0506drawable.abc_switch_track_mtrl_alpha) {
                a = m3175c(context);
            } else if (i == C0505R.C0506drawable.abc_switch_thumb_material) {
                a = m3176d(context);
            } else if (i == C0505R.C0506drawable.abc_btn_default_mtrl_shape || i == C0505R.C0506drawable.abc_btn_borderless_material) {
                a = m3178f(context);
            } else if (i == C0505R.C0506drawable.abc_btn_colored_material) {
                a = m3179g(context);
            } else if (i == C0505R.C0506drawable.abc_spinner_mtrl_am_alpha || i == C0505R.C0506drawable.abc_spinner_textfield_background_material) {
                a = m3180h(context);
            } else if (m3172a(f2007e, i)) {
                a = C1188ha.m5257b(context, C0505R.attr.colorControlNormal);
            } else if (m3172a(f2010h, i)) {
                a = m3165a(context);
            } else if (m3172a(f2011i, i)) {
                a = m3173b(context);
            } else if (i == C0505R.C0506drawable.abc_seekbar_thumb_material) {
                a = m3181i(context);
            }
            if (a != null) {
                m3169a(context, i, a);
            }
        }
        return a;
    }

    /* renamed from: a */
    private ColorStateList m3166a(@NonNull Context context, @DrawableRes int i) {
        if (this.f2012j == null) {
            return null;
        }
        SparseArray sparseArray = this.f2012j.get(context);
        if (sparseArray != null) {
            return (ColorStateList) sparseArray.get(i);
        }
        return null;
    }

    /* renamed from: a */
    private void m3169a(@NonNull Context context, @DrawableRes int i, @NonNull ColorStateList colorStateList) {
        if (this.f2012j == null) {
            this.f2012j = new WeakHashMap<>();
        }
        SparseArray sparseArray = this.f2012j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f2012j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    /* renamed from: a */
    private ColorStateList m3165a(Context context) {
        int a = C1188ha.m5254a(context, C0505R.attr.colorControlNormal);
        int a2 = C1188ha.m5254a(context, C0505R.attr.colorControlActivated);
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4238b, C1188ha.f4239c, C1188ha.f4240d, C1188ha.f4241e, C1188ha.f4242f, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlNormal), a2, a2, a2, a2, a2, a});
    }

    /* renamed from: b */
    private ColorStateList m3173b(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4241e, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlActivated), C1188ha.m5254a(context, C0505R.attr.colorControlNormal)});
    }

    /* renamed from: c */
    private ColorStateList m3175c(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4241e, C1188ha.f4244h}, new int[]{C1188ha.m5255a(context, 16842800, 0.1f), C1188ha.m5255a(context, C0505R.attr.colorControlActivated, 0.3f), C1188ha.m5255a(context, 16842800, 0.3f)});
    }

    /* renamed from: d */
    private ColorStateList m3176d(Context context) {
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
    private ColorStateList m3177e(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4243g, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlActivated)});
    }

    /* renamed from: f */
    private ColorStateList m3178f(Context context) {
        return m3174b(context, C0505R.attr.colorButtonNormal);
    }

    /* renamed from: g */
    private ColorStateList m3179g(Context context) {
        return m3174b(context, C0505R.attr.colorAccent);
    }

    /* renamed from: b */
    private ColorStateList m3174b(Context context, int i) {
        int a = C1188ha.m5254a(context, i);
        int a2 = C1188ha.m5254a(context, C0505R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4240d, C1188ha.f4238b, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorButtonNormal), ColorUtils.compositeColors(a2, a), ColorUtils.compositeColors(a2, a), a});
    }

    /* renamed from: h */
    private ColorStateList m3180h(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4243g, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlNormal), C1188ha.m5254a(context, C0505R.attr.colorControlActivated)});
    }

    /* renamed from: i */
    private ColorStateList m3181i(Context context) {
        return new ColorStateList(new int[][]{C1188ha.f4237a, C1188ha.f4244h}, new int[]{C1188ha.m5258c(context, C0505R.attr.colorControlActivated), C1188ha.m5254a(context, C0505R.attr.colorControlActivated)});
    }

    /* renamed from: android.support.v7.widget.AppCompatDrawableManager$a */
    static class C0545a extends LruCache<Integer, PorterDuffColorFilter> {
        public C0545a(int i) {
            super(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo4107a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(m3183b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo4108a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(m3183b(i, mode)), porterDuffColorFilter);
        }

        /* renamed from: b */
        private static int m3183b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    public static void tintDrawable(Drawable drawable, C1191hc hcVar, int[] iArr) {
        if (!m3171a(drawable) || drawable.mutate() == drawable) {
            if (hcVar.f4252d || hcVar.f4251c) {
                drawable.setColorFilter(m3168a(hcVar.f4252d ? hcVar.f4249a : null, hcVar.f4251c ? hcVar.f4250b : f2003a, iArr));
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
    private static boolean m3171a(Drawable drawable) {
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
                if (!m3171a(a)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m3168a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m3167a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m3167a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a = f2005c.mo4107a(i, mode);
        if (a != null) {
            return a;
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        f2005c.mo4108a(i, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    /* renamed from: a */
    private static void m3170a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (mode == null) {
            mode = f2003a;
        }
        drawable.setColorFilter(m3167a(i, mode));
    }
}
