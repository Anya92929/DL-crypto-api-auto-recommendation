package com.tapcrowd.app.modules.menuitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuFragment extends SherlockFragment {
    private static final int LOADER = 7435;
    List<Integer> ids = new ArrayList();
    private MenuItemListener listener;
    private Menu menu;
    ArrayList<MenuItemContainer> menuitems = new ArrayList<>();
    List<Integer> toHide = new ArrayList();

    public interface MenuItemListener {
        void click(MenuItem menuItem);
    }

    public static MenuFragment newInstance(ArrayList<MenuItemContainer> menuitems2, MenuItemListener listener2) {
        MenuFragment menu2 = new MenuFragment();
        menu2.menuitems = menuitems2;
        menu2.listener = listener2;
        return menu2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater inflater) {
        this.menu = menu2;
        Iterator<MenuItemContainer> it = this.menuitems.iterator();
        while (it.hasNext()) {
            MenuItemContainer menuitem = it.next();
            if (!this.ids.contains(Integer.valueOf(menuitem.getItemid()))) {
                menuitem.addMenuItem(menu2);
                this.ids.add(Integer.valueOf(menuitem.getItemid()));
            }
        }
        for (Integer intValue : this.toHide) {
            hide(intValue.intValue());
        }
        super.onCreateOptionsMenu(menu2, inflater);
    }

    public void addItem(MenuItemContainer item) {
        this.menuitems.add(item);
        if (this.menu != null) {
            item.addMenuItem(this.menu);
        }
    }

    public void editIcon(int itemid, Drawable icon) {
        if (this.menu != null) {
            this.menu.findItem(itemid).setIcon(icon);
        }
    }

    public void startLoader() {
        if (this.menu == null || this.menu.findItem(LOADER) != null) {
            this.menuitems.add(0, new MenuItemContainer(true));
            return;
        }
        MenuItem item = this.menu.add(0, (int) LOADER, 0, (CharSequence) "");
        item.setShowAsAction(1);
        item.setActionView((int) C0846R.layout.indeterminate_progress_action);
        item.expandActionView();
    }

    public void hide(int itemid) {
        if (this.menu != null) {
            if (this.menu.findItem(itemid) != null) {
                this.menu.findItem(itemid).setVisible(false);
            }
        } else if (!this.toHide.contains(Integer.valueOf(itemid))) {
            this.toHide.add(Integer.valueOf(itemid));
        }
    }

    public void show(int itemid) {
        if (this.menu != null) {
            if (this.menu.findItem(itemid) != null) {
                this.menu.findItem(itemid).setVisible(true);
            }
        } else if (this.toHide.contains(Integer.valueOf(itemid))) {
            this.toHide.remove(Integer.valueOf(itemid));
        }
    }

    public void stopLoader() {
        if (this.menu != null && this.menu.findItem(LOADER) != null) {
            this.menu.removeItem(LOADER);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.listener != null) {
            this.listener.click(item);
        }
        return super.onOptionsItemSelected(item);
    }

    public static class MenuItemContainer {
        private List<SubMenuContainer> dropdown;

        /* renamed from: id */
        private String f2085id;
        private boolean isLoader;
        private int itemid;
        private Drawable resource;
        private boolean showText;
        private boolean subMenu;
        private String text;
        private String url;

        public MenuItemContainer(boolean isLoader2) {
            this.isLoader = isLoader2;
        }

        public MenuItemContainer(String id, String url2) {
            this.f2085id = id;
            this.url = url2;
            this.itemid = (int) Long.parseLong(id);
        }

        public MenuItemContainer(Drawable resource2, int itemid2) {
            this(resource2, itemid2, "", false, false);
        }

        public MenuItemContainer(String text2, int itemid2) {
            this((Drawable) null, itemid2, text2, false, true);
        }

        public MenuItemContainer(Drawable resource2, List<SubMenuContainer> dropdown2) {
            this.resource = resource2;
            this.dropdown = dropdown2;
        }

        public MenuItemContainer(String text2, int itemid2, boolean showText2) {
            this((Drawable) null, itemid2, text2, showText2, false);
        }

        public MenuItemContainer(Drawable resource2, int itemid2, String text2, boolean showText2, boolean subMenu2) {
            this.resource = resource2;
            this.itemid = itemid2;
            this.text = text2;
            this.showText = showText2;
            this.subMenu = subMenu2;
        }

        public void addMenuItem(Menu menu) {
            final MenuItem item;
            if (this.isLoader && menu.findItem(MenuFragment.LOADER) == null) {
                MenuItem item2 = menu.add(0, (int) MenuFragment.LOADER, 0, (CharSequence) "");
                item2.setShowAsAction(1);
                item2.setActionView((int) C0846R.layout.indeterminate_progress_action);
                item2.expandActionView();
            } else if (this.dropdown != null) {
                SubMenu drop = menu.addSubMenu((CharSequence) null);
                MenuItem item3 = drop.getItem();
                item3.setIcon(this.resource);
                item3.setShowAsAction(6);
                for (SubMenuContainer sub : this.dropdown) {
                    drop.addSubMenu(0, sub.getId(), sub.getOrder(), (CharSequence) sub.getTitle());
                }
            } else {
                if (this.showText) {
                    item = menu.add(0, this.itemid, 0, (CharSequence) this.text);
                } else {
                    item = menu.add(0, this.itemid, 0, (CharSequence) this.text);
                }
                if (this.showText) {
                    item.setShowAsAction(5);
                } else if (this.subMenu) {
                    item.setShowAsAction(4);
                } else {
                    item.setShowAsAction(1);
                }
                if (!this.subMenu) {
                    item.setIcon(this.resource);
                }
                if (this.url != null) {
                    new FastImageLoader().getBitmap(this.url, new FastImageLoader.LoadBitmapListener() {
                        public void bitmapLoaded(Bitmap bitmap) {
                            item.setIcon((Drawable) new BitmapDrawable(bitmap));
                        }
                    });
                }
            }
        }

        public int getItemid() {
            return this.itemid;
        }

        public String getId() {
            return this.f2085id;
        }
    }

    public static class SubMenuContainer {

        /* renamed from: id */
        int f2086id;
        int order;
        String title;

        public SubMenuContainer(int id, String title2) {
            this.f2086id = id;
            this.order = 0;
            this.title = title2;
        }

        public SubMenuContainer(int id, int order2, String title2) {
            this.f2086id = id;
            this.order = order2;
            this.title = title2;
        }

        public int getId() {
            return this.f2086id;
        }

        public int getOrder() {
            return this.order;
        }

        public String getTitle() {
            return this.title;
        }
    }
}
