package p006nl.volkerinfradesign.checkandroid.p007ui.inspections;

import android.content.Context;
import android.graphics.drawable.Drawable;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.IconUtil */
public final class IconUtil {

    /* renamed from: a */
    private static int[] f5294a = {C1352R.C1353drawable.ic_icon_compass, C1352R.C1353drawable.ic_icon_alarm, C1352R.C1353drawable.ic_icon_puzzle, C1352R.C1353drawable.ic_icon_calendar, C1352R.C1353drawable.ic_icon_eye, C1352R.C1353drawable.ic_icon_suit_case, C1352R.C1353drawable.ic_icon_shopping_cart, C1352R.C1353drawable.ic_icon_star, C1352R.C1353drawable.ic_icon_movie, C1352R.C1353drawable.ic_icon_group, C1352R.C1353drawable.ic_icon_lock, C1352R.C1353drawable.ic_icon_home, C1352R.C1353drawable.ic_icon_credit_card, C1352R.C1353drawable.ic_icon_dude, C1352R.C1353drawable.ic_icon_temple, C1352R.C1353drawable.ic_icon_world, C1352R.C1353drawable.ic_icon_shield, C1352R.C1353drawable.ic_icon_star_inset, C1352R.C1353drawable.ic_icon_wallet, C1352R.C1353drawable.ic_icon_shopping_bag};

    private IconUtil() {
    }

    public static Drawable get(Context context, int i) {
        return context.getResources().getDrawable(f5294a[Math.abs(i) % f5294a.length]);
    }

    public static Drawable get(Context context, InspectionsTable.DataCursor dataCursor) {
        return get(context, Long.valueOf(dataCursor.getId()).intValue());
    }
}
