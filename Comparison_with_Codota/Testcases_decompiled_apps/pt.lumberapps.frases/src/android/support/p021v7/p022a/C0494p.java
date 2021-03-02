package android.support.p021v7.p022a;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.a.p */
class C0494p {

    /* renamed from: a */
    public Method f773a;

    /* renamed from: b */
    public Method f774b;

    /* renamed from: c */
    public ImageView f775c;

    C0494p(Activity activity) {
        try {
            this.f773a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
            this.f774b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e) {
            View findViewById = activity.findViewById(16908332);
            if (findViewById != null) {
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() == 2) {
                    View childAt = viewGroup.getChildAt(0);
                    View view = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                    if (view instanceof ImageView) {
                        this.f775c = (ImageView) view;
                    }
                }
            }
        }
    }
}
