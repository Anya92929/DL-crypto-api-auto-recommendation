package com.tapcrowd.app.modules.launcher;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.nineoldandroids.animation.ValueAnimator;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.coupons.CouponsFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.ImageViewpager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TCMetroLauncher extends TCFragment implements MenuFragment.MenuItemListener {
    private FastImageLoader fil;
    private ArrayList<MenuFragment.MenuItemContainer> menuitems;
    /* access modifiers changed from: private */
    public Timer timer;
    private String type;
    private String typeid;
    /* access modifiers changed from: private */
    public ViewPager viewpager;

    public static TCMetroLauncher newInstance(String type2, String typeid2) {
        TCMetroLauncher fr = new TCMetroLauncher();
        fr.type = type2;
        fr.typeid = typeid2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.layout_metro, container, false);
        } else {
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
            this.retained = true;
        }
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        setShowHomebutton(false);
        super.onActivityCreated(savedInstanceState);
        setupMenu();
        if (!this.retained) {
            this.fil = new FastImageLoader();
            setupLayout();
        }
    }

    private void setupMenu() {
        List<TCObject> navigation = C1199DB.getQueryFromDb(String.format("SELECT * FROM launchers WHERE %1$s == '%2$s' AND displaytype == 'navigation' ORDER BY order_value +0 ASC", new Object[]{this.type, this.typeid}));
        this.menuitems = new ArrayList<>();
        for (TCObject item : navigation) {
            this.menuitems.add(new MenuFragment.MenuItemContainer(item.get(DBFavorites.KEY_EVENT_ID), item.get(C1216LO.icon)));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(this.menuitems, this));
    }

    private void setupLayout() {
        if (C1216LO.launcherBackground == 0) {
            getView().findViewById(C0846R.C0847id.screen).setBackgroundColor(C1216LO.getLo(C1216LO.launcherBackgroundColor));
        } else {
            this.fil.getBitmap(C1216LO.getLoUrl(C1216LO.launcherBackground), new FastImageLoader.LoadBitmapListener() {
                public void bitmapLoaded(Bitmap bitmap) {
                    TCMetroLauncher.this.f2005v.findViewById(C0846R.C0847id.screen).setBackgroundDrawable(new BitmapDrawable(bitmap));
                }
            });
        }
        List<TCObject> items = C1199DB.getQueryFromDb(String.format("SELECT * FROM launchers WHERE %1$s == '%2$s' AND displaytype != 'navigation' ORDER BY order_value +0 ASC", new Object[]{this.type, this.typeid}));
        for (int i = 0; i < 6; i++) {
            final TCObject item = items.get(i);
            if (i == 0) {
                List<TCObject> coupons = C1199DB.getListFromDb("coupons", "order_value DESC");
                List<String> urls = new ArrayList<>();
                for (TCObject coupon : coupons) {
                    urls.add(coupon.get("image"));
                }
                ImageViewpager vp = (ImageViewpager) this.f2005v.findViewById(C0846R.C0847id.f1996vp);
                this.viewpager = vp.getViewPager();
                vp.showImages(urls);
                vp.setDpHeight(150);
                vp.setPagerPosition(ImageViewpager.PagerPosition.Gone);
                vp.showCounter(false);
                vp.setOnClickListener(new ImageViewpager.OnClickListener() {
                    public boolean onClick(int position, String url) {
                        if (LauncherUtil.getFragment(item) != null) {
                            Fragments.add(TCMetroLauncher.this, CouponsFragment.newInstance(position), item.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                        }
                        return false;
                    }
                });
                vp.setOnPageChangedListener(new ImageViewpager.onPageChangedListener() {
                    public void onPageChanged(int position) {
                        if (TCMetroLauncher.this.timer != null) {
                            TCMetroLauncher.this.timer.cancel();
                        }
                        TCMetroLauncher.this.timer = new Timer();
                        TCMetroLauncher.this.timer.schedule(new VpTimerTask(TCMetroLauncher.this, (VpTimerTask) null), 6000);
                        TCMetroLauncher.this.startProgress();
                    }
                });
            } else {
                ImageView iv = getIv(i);
                getTv(i).setText(item.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                iv.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (LauncherUtil.getFragment(item) != null) {
                            Fragments.add(TCMetroLauncher.this, LauncherUtil.getFragment(item), item.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                        }
                    }
                });
                this.fil.DisplayImage(item.get(C1216LO.icon), iv);
            }
        }
    }

    public void onPause() {
        if (this.timer != null) {
            this.timer.cancel();
        }
        super.onPause();
    }

    public void onResume() {
        this.timer = new Timer();
        this.timer.schedule(new VpTimerTask(this, (VpTimerTask) null), 6000);
        this.f2005v.post(new Runnable() {
            public void run() {
                TCMetroLauncher.this.startProgress();
            }
        });
        super.onResume();
    }

    /* access modifiers changed from: private */
    public void startProgress() {
        final View progress = this.f2005v.findViewById(C0846R.C0847id.progress);
        ValueAnimator animator = ValueAnimator.ofInt(0, ((View) progress.getParent()).getMeasuredWidth());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = progress.getLayoutParams();
                layoutParams.width = value;
                progress.setLayoutParams(layoutParams);
            }
        });
        animator.setDuration(6000);
        animator.start();
    }

    public ImageView getIv(int position) {
        int id;
        switch (position) {
            case 1:
                id = C0846R.C0847id.image_2;
                break;
            case 2:
                id = C0846R.C0847id.image_3;
                break;
            case 3:
                id = C0846R.C0847id.image_4;
                break;
            case 4:
                id = C0846R.C0847id.image_5;
                break;
            case 5:
                id = C0846R.C0847id.image_6;
                break;
            default:
                id = C0846R.C0847id.image_2;
                break;
        }
        return (ImageView) this.f2005v.findViewById(id);
    }

    public TextView getTv(int position) {
        int id;
        switch (position) {
            case 1:
                id = C0846R.C0847id.title_2;
                break;
            case 2:
                id = C0846R.C0847id.title_3;
                break;
            case 3:
                id = C0846R.C0847id.title_4;
                break;
            case 4:
                id = C0846R.C0847id.title_5;
                break;
            case 5:
                id = C0846R.C0847id.title_6;
                break;
            default:
                id = C0846R.C0847id.title_2;
                break;
        }
        return (TextView) this.f2005v.findViewById(id);
    }

    private class VpTimerTask extends TimerTask {
        private VpTimerTask() {
        }

        /* synthetic */ VpTimerTask(TCMetroLauncher tCMetroLauncher, VpTimerTask vpTimerTask) {
            this();
        }

        public void run() {
            TCMetroLauncher.this.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    int position = TCMetroLauncher.this.viewpager.getCurrentItem();
                    TCMetroLauncher.this.viewpager.setCurrentItem(position + 1 == TCMetroLauncher.this.viewpager.getAdapter().getCount() ? 0 : position + 1, true);
                }
            });
        }
    }

    public void click(MenuItem item) {
        int id = item.getItemId();
        Iterator<MenuFragment.MenuItemContainer> it = this.menuitems.iterator();
        while (it.hasNext()) {
            MenuFragment.MenuItemContainer menuItem = it.next();
            if (menuItem.getItemid() == id) {
                TCObject launcher = C1199DB.getFirstObject("launchers", DBFavorites.KEY_EVENT_ID, menuItem.getId());
                if (LauncherUtil.getFragment(launcher) != null) {
                    Fragments.add(this, LauncherUtil.getFragment(launcher), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                    return;
                }
                return;
            }
        }
    }
}
