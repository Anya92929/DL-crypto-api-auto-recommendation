package android.support.p021v7.p022a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;

/* renamed from: android.support.v7.a.o */
class C0493o {

    /* renamed from: a */
    private static final int[] f772a = {16843531};

    /* renamed from: a */
    public static Drawable m2124a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(f772a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    /* renamed from: a */
    public static C0494p m2125a(C0494p pVar, Activity activity, int i) {
        if (pVar == null) {
            pVar = new C0494p(activity);
        }
        if (pVar.f773a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                pVar.f774b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return pVar;
    }

    /* renamed from: a */
    public static C0494p m2126a(C0494p pVar, Activity activity, Drawable drawable, int i) {
        C0494p pVar2 = new C0494p(activity);
        if (pVar2.f773a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                pVar2.f773a.invoke(actionBar, new Object[]{drawable});
                pVar2.f774b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (pVar2.f775c != null) {
            pVar2.f775c.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        }
        return pVar2;
    }
}
