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

/* renamed from: i */
public class C1235i {

    /* renamed from: a */
    private static final int[] f4353a = {16843531};

    /* renamed from: a */
    public static Object m5502a(Object obj, Activity activity, Drawable drawable, int i) {
        Object obj2;
        if (obj == null) {
            obj2 = new C1236a(activity);
        } else {
            obj2 = obj;
        }
        C1236a aVar = (C1236a) obj2;
        if (aVar.f4354a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f4354a.invoke(actionBar, new Object[]{drawable});
                aVar.f4355b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (aVar.f4356c != null) {
            aVar.f4356c.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        }
        return obj2;
    }

    /* renamed from: a */
    public static Object m5501a(Object obj, Activity activity, int i) {
        Object obj2;
        if (obj == null) {
            obj2 = new C1236a(activity);
        } else {
            obj2 = obj;
        }
        C1236a aVar = (C1236a) obj2;
        if (aVar.f4354a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f4355b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return obj2;
    }

    /* renamed from: a */
    public static Drawable m5500a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(f4353a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    /* renamed from: i$a */
    static class C1236a {

        /* renamed from: a */
        public Method f4354a;

        /* renamed from: b */
        public Method f4355b;

        /* renamed from: c */
        public ImageView f4356c;

        C1236a(Activity activity) {
            try {
                this.f4354a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f4355b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException e) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        View view = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                        if (view instanceof ImageView) {
                            this.f4356c = (ImageView) view;
                        }
                    }
                }
            }
        }
    }
}
