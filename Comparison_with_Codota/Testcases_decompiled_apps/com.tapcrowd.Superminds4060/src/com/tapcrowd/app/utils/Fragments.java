package com.tapcrowd.app.utils;

import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentTransaction;
import android.view.inputmethod.InputMethodManager;
import com.actionbarsherlock.view.ActionMode;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;

public class Fragments {
    public static int currentPage;

    /* renamed from: fa */
    public static FragmentActivity f2128fa;
    public static ActionMode mode;

    public static void add(Fragment caller, Fragment toadd, String title) {
        hideIme();
        String analytics = null;
        if ((caller instanceof TCFragment) && !((TCFragment) caller).analytics.equals("")) {
            analytics = ((TCFragment) caller).analytics;
        } else if ((caller instanceof TCListFragment) && !((TCListFragment) caller).analytics.equals("")) {
            analytics = ((TCListFragment) caller).analytics;
        }
        if (analytics != null) {
            add(caller, toadd, title, analytics);
        } else {
            addFragment(caller, toadd, title);
        }
    }

    public static void add(Fragment caller, Fragment toadd, String title, String analytics) {
        hideIme();
        if (toadd instanceof TCFragment) {
            ((TCFragment) toadd).analytics = analytics;
        } else if (toadd instanceof TCListFragment) {
            ((TCListFragment) toadd).analytics = analytics;
        }
        addFragment(caller, toadd, title);
    }

    public static void addMenu(Fragment host, MenuFragment fragment) {
        removeMenu();
        FragmentTransaction transaction = f2128fa.getSupportFragmentManager().beginTransaction();
        Fragment prev = f2128fa.getSupportFragmentManager().findFragmentByTag("menu");
        if (prev != null) {
            transaction.remove(prev);
        }
        transaction.add((Fragment) fragment, "menu");
        transaction.commit();
    }

    public static void removeMenu() {
        FragmentTransaction transaction = f2128fa.getSupportFragmentManager().beginTransaction();
        Fragment prev = f2128fa.getSupportFragmentManager().findFragmentByTag("menu");
        if (prev != null) {
            transaction.remove(prev);
        }
        transaction.commit();
    }

    private static void addFragment(Fragment caller, Fragment toadd, String title) {
        removeMenu();
        FragmentTransaction transaction = f2128fa.getSupportFragmentManager().beginTransaction();
        if (toadd instanceof TCFragment) {
            ((TCFragment) toadd).setTitle(title);
        } else if (toadd instanceof TCListFragment) {
            ((TCListFragment) toadd).setTitle(title);
        }
        transaction.setCustomAnimations(C0846R.anim.slide_in_left, C0846R.anim.slide_out_left, C0846R.anim.slide_in_right, C0846R.anim.slide_out_right);
        transaction.replace(C0846R.C0847id.contentbox1, toadd);
        if (caller != null) {
            transaction.addToBackStack((String) null);
        }
        transaction.commit();
    }

    public static void back() {
        hideIme();
        removeMenu();
        f2128fa.getSupportFragmentManager().popBackStack();
    }

    public static void clear() {
        if (f2128fa != null) {
            hideIme();
            f2128fa.getSupportFragmentManager().popBackStack((String) null, 1);
            removeMenu();
        }
    }

    private static void hideIme() {
        ((InputMethodManager) f2128fa.getSystemService("input_method")).hideSoftInputFromWindow(f2128fa.findViewById(16908290).getWindowToken(), 0);
    }
}
