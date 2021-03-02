package p000;

import android.view.MenuItem;

/* renamed from: da */
public class C1036da {

    /* renamed from: da$b */
    public interface C1038b {
        /* renamed from: a */
        boolean mo1788a(MenuItem menuItem);

        /* renamed from: b */
        boolean mo1789b(MenuItem menuItem);
    }

    /* renamed from: a */
    public static boolean m4627a(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    /* renamed from: b */
    public static boolean m4628b(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    /* renamed from: c */
    public static boolean m4629c(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    /* renamed from: a */
    public static MenuItem m4626a(MenuItem menuItem, C1038b bVar) {
        return menuItem.setOnActionExpandListener(new C1037a(bVar));
    }

    /* renamed from: da$a */
    static class C1037a implements MenuItem.OnActionExpandListener {

        /* renamed from: a */
        private C1038b f4054a;

        public C1037a(C1038b bVar) {
            this.f4054a = bVar;
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f4054a.mo1788a(menuItem);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f4054a.mo1789b(menuItem);
        }
    }
}
