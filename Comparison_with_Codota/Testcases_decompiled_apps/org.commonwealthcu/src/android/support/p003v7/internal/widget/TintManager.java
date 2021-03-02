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
import android.support.p003v7.appcompat.C0137R;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.internal.widget.TintManager */
public final class TintManager {
    private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {C0137R.C0138drawable.abc_popup_background_mtrl_mult, C0137R.C0138drawable.abc_cab_background_internal_bg, C0137R.C0138drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {C0137R.C0138drawable.abc_textfield_activated_mtrl_alpha, C0137R.C0138drawable.abc_textfield_search_activated_mtrl_alpha, C0137R.C0138drawable.abc_cab_background_top_mtrl_alpha, C0137R.C0138drawable.abc_text_cursor_mtrl_alpha};
    private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {C0137R.C0138drawable.abc_textfield_search_default_mtrl_alpha, C0137R.C0138drawable.abc_textfield_default_mtrl_alpha, C0137R.C0138drawable.abc_ab_share_pack_mtrl_alpha};
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static final WeakHashMap INSTANCE_CACHE = new WeakHashMap();
    public static final boolean SHOULD_BE_USED = (Build.VERSION.SDK_INT < 21);
    private static final String TAG = "TintManager";
    private static final int[] TINT_CHECKABLE_BUTTON_LIST = {C0137R.C0138drawable.abc_btn_check_material, C0137R.C0138drawable.abc_btn_radio_material};
    private static final int[] TINT_COLOR_CONTROL_NORMAL = {C0137R.C0138drawable.abc_ic_ab_back_mtrl_am_alpha, C0137R.C0138drawable.abc_ic_go_search_api_mtrl_alpha, C0137R.C0138drawable.abc_ic_search_api_mtrl_alpha, C0137R.C0138drawable.abc_ic_commit_search_api_mtrl_alpha, C0137R.C0138drawable.abc_ic_clear_mtrl_alpha, C0137R.C0138drawable.abc_ic_menu_share_mtrl_alpha, C0137R.C0138drawable.abc_ic_menu_copy_mtrl_am_alpha, C0137R.C0138drawable.abc_ic_menu_cut_mtrl_alpha, C0137R.C0138drawable.abc_ic_menu_selectall_mtrl_alpha, C0137R.C0138drawable.abc_ic_menu_paste_mtrl_am_alpha, C0137R.C0138drawable.abc_ic_menu_moreoverflow_mtrl_alpha, C0137R.C0138drawable.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] TINT_COLOR_CONTROL_STATE_LIST = {C0137R.C0138drawable.abc_edit_text_material, C0137R.C0138drawable.abc_tab_indicator_material, C0137R.C0138drawable.abc_textfield_search_material, C0137R.C0138drawable.abc_spinner_mtrl_am_alpha, C0137R.C0138drawable.abc_spinner_textfield_background_material, C0137R.C0138drawable.abc_ratingbar_full_material, C0137R.C0138drawable.abc_switch_track_mtrl_alpha, C0137R.C0138drawable.abc_switch_thumb_material, C0137R.C0138drawable.abc_btn_default_mtrl_shape, C0137R.C0138drawable.abc_btn_borderless_material};
    private final WeakReference mContextRef;
    private ColorStateList mDefaultColorStateList;
    private SparseArray mTintLists;

    /* renamed from: android.support.v7.internal.widget.TintManager$ColorFilterLruCache */
    class ColorFilterLruCache extends LruCache {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        private static int generateCacheKey(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter get(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(generateCacheKey(i, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter put(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }
    }

    private TintManager(Context context) {
        this.mContextRef = new WeakReference(context);
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList createButtonColorStateList(Context context) {
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorButtonNormal);
        int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0137R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor2, themeAttrColor), ColorUtils.compositeColors(themeAttrColor2, themeAttrColor), themeAttrColor});
    }

    private ColorStateList createCheckableButtonColorStateList(Context context) {
        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.CHECKED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0137R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlActivated), ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlNormal)});
    }

    private ColorStateList createEditTextColorStateList(Context context) {
        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0137R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlActivated)});
    }

    private ColorStateList createSpinnerColorStateList(Context context) {
        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0137R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlNormal), ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlActivated)});
    }

    private ColorStateList createSwitchThumbColorStateList(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, C0137R.attr.colorSwitchThumbNormal);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, C0137R.attr.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = themeAttrColorStateList.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList createSwitchTrackColorStateList(Context context) {
        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.CHECKED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getThemeAttrColor(context, 16842800, 0.1f), ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlActivated, 0.3f), ThemeUtils.getThemeAttrColor(context, 16842800, 0.3f)});
    }

    public static TintManager get(Context context) {
        TintManager tintManager = (TintManager) INSTANCE_CACHE.get(context);
        if (tintManager != null) {
            return tintManager;
        }
        TintManager tintManager2 = new TintManager(context);
        INSTANCE_CACHE.put(context, tintManager2);
        return tintManager2;
    }

    private ColorStateList getDefaultColorStateList(Context context) {
        if (this.mDefaultColorStateList == null) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlNormal);
            int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, C0137R.attr.colorControlActivated);
            this.mDefaultColorStateList = new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.ACTIVATED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.CHECKED_STATE_SET, ThemeUtils.SELECTED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, C0137R.attr.colorControlNormal), themeAttrColor2, themeAttrColor2, themeAttrColor2, themeAttrColor2, themeAttrColor2, themeAttrColor});
        }
        return this.mDefaultColorStateList;
    }

    public static Drawable getDrawable(Context context, int i) {
        return isInTintList(i) ? get(context).getDrawable(i) : ContextCompat.getDrawable(context, i);
    }

    private static boolean isInTintList(int i) {
        return arrayContains(TINT_COLOR_CONTROL_NORMAL, i) || arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i) || arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i) || arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i) || arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i) || arrayContains(TINT_CHECKABLE_BUTTON_LIST, i) || i == C0137R.C0138drawable.abc_cab_background_top_material;
    }

    private static void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (mode == null) {
            mode = DEFAULT_MODE;
        }
        PorterDuffColorFilter porterDuffColorFilter = COLOR_FILTER_CACHE.get(i, mode);
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            COLOR_FILTER_CACHE.put(i, mode, porterDuffColorFilter);
        }
        drawable.setColorFilter(porterDuffColorFilter);
    }

    public static void tintViewBackground(View view, TintInfo tintInfo) {
        Drawable background = view.getBackground();
        if (tintInfo.mHasTintList) {
            setPorterDuffColorFilter(background, tintInfo.mTintList.getColorForState(view.getDrawableState(), tintInfo.mTintList.getDefaultColor()), tintInfo.mHasTintMode ? tintInfo.mTintMode : null);
        } else {
            background.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 10) {
            view.invalidate();
        }
    }

    public final Drawable getDrawable(int i) {
        return getDrawable(i, false);
    }

    public final Drawable getDrawable(int i, boolean z) {
        Context context = (Context) this.mContextRef.get();
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
                PorterDuff.Mode tintMode = getTintMode(i);
                if (tintMode != null) {
                    DrawableCompat.setTintMode(drawable, tintMode);
                }
            } else if (i == C0137R.C0138drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{getDrawable(C0137R.C0138drawable.abc_cab_background_internal_bg), getDrawable(C0137R.C0138drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (!tintDrawableUsingColorFilter(i, drawable) && z) {
                drawable = null;
            }
        }
        return drawable;
    }

    public final ColorStateList getTintList(int i) {
        ColorStateList colorStateList = null;
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return null;
        }
        if (this.mTintLists != null) {
            colorStateList = (ColorStateList) this.mTintLists.get(i);
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList createEditTextColorStateList = i == C0137R.C0138drawable.abc_edit_text_material ? createEditTextColorStateList(context) : i == C0137R.C0138drawable.abc_switch_track_mtrl_alpha ? createSwitchTrackColorStateList(context) : i == C0137R.C0138drawable.abc_switch_thumb_material ? createSwitchThumbColorStateList(context) : (i == C0137R.C0138drawable.abc_btn_default_mtrl_shape || i == C0137R.C0138drawable.abc_btn_borderless_material) ? createButtonColorStateList(context) : (i == C0137R.C0138drawable.abc_spinner_mtrl_am_alpha || i == C0137R.C0138drawable.abc_spinner_textfield_background_material) ? createSpinnerColorStateList(context) : arrayContains(TINT_COLOR_CONTROL_NORMAL, i) ? ThemeUtils.getThemeAttrColorStateList(context, C0137R.attr.colorControlNormal) : arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i) ? getDefaultColorStateList(context) : arrayContains(TINT_CHECKABLE_BUTTON_LIST, i) ? createCheckableButtonColorStateList(context) : colorStateList;
        if (createEditTextColorStateList == null) {
            return createEditTextColorStateList;
        }
        if (this.mTintLists == null) {
            this.mTintLists = new SparseArray();
        }
        this.mTintLists.append(i, createEditTextColorStateList);
        return createEditTextColorStateList;
    }

    /* access modifiers changed from: package-private */
    public final PorterDuff.Mode getTintMode(int i) {
        if (i == C0137R.C0138drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public final boolean tintDrawableUsingColorFilter(int i, Drawable drawable) {
        int i2;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return false;
        }
        if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
            i3 = C0137R.attr.colorControlNormal;
            mode = null;
            z = true;
            i2 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
            i3 = C0137R.attr.colorControlActivated;
            mode = null;
            z = true;
            i2 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = 16842801;
            i2 = -1;
        } else if (i == C0137R.C0138drawable.abc_list_divider_mtrl_alpha) {
            i3 = 16842800;
            i2 = Math.round(40.8f);
            mode = null;
            z = true;
        } else {
            i2 = -1;
            i3 = 0;
            mode = null;
            z = false;
        }
        if (!z) {
            return false;
        }
        setPorterDuffColorFilter(drawable, ThemeUtils.getThemeAttrColor(context, i3), mode);
        if (i2 != -1) {
            drawable.setAlpha(i2);
        }
        return true;
    }
}
