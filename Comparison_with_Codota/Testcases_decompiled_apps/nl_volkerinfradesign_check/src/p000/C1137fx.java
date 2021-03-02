package p000;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* renamed from: fx */
public class C1137fx {

    /* renamed from: a */
    private static final int[] f4101a = {16843531};

    /* renamed from: a */
    public static C1138a m5126a(C1138a aVar, Activity activity, Drawable drawable, int i) {
        C1138a aVar2 = new C1138a(activity);
        if (aVar2.f4102a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar2.f4102a.invoke(actionBar, new Object[]{drawable});
                aVar2.f4103b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (aVar2.f4104c != null) {
            aVar2.f4104c.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        }
        return aVar2;
    }

    /* renamed from: a */
    public static C1138a m5125a(C1138a aVar, Activity activity, int i) {
        if (aVar == null) {
            aVar = new C1138a(activity);
        }
        if (aVar.f4102a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f4103b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return aVar;
    }

    /* renamed from: a */
    public static Drawable m5124a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(f4101a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    /* renamed from: fx$a */
    public static class C1138a {

        /* renamed from: a */
        public Method f4102a;

        /* renamed from: b */
        public Method f4103b;

        /* renamed from: c */
        public ImageView f4104c;

        C1138a(Activity activity) {
            try {
                this.f4102a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f4103b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException e) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        View view = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                        if (view instanceof ImageView) {
                            this.f4104c = (ImageView) view;
                        }
                    }
                }
            }
        }
    }
}
