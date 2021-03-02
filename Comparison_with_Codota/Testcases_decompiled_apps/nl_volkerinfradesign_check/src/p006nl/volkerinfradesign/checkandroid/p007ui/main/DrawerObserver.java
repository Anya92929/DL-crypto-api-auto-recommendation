package p006nl.volkerinfradesign.checkandroid.p007ui.main;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.DrawerObserver */
public interface DrawerObserver {
    DrawerItem getCheckedDrawerItem();

    void notifyDataSetChanged();

    void setCheckedDrawerItem(DrawerItem drawerItem);
}
