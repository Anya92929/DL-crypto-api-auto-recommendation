package com.forexcrunch.forexcrunch.local;

import android.content.Context;
import android.support.p000v4.app.Fragment;
import java.util.Iterator;
import java.util.Stack;

public class LocalFragmentManager {
    private static LocalFragmentManager instance;
    private Stack<Fragment> calendarfragmentStack;
    private Context ctx;
    private int currentTab;
    private Stack<Fragment> dailyfragmentStack;
    private Stack<Fragment> homeFragmentStack;
    private Fragment lastFragment;
    private Stack<Fragment> newsfragmentStack;
    private Stack<Fragment> weeklyfragmentStack;

    public LocalFragmentManager(Context ctx2) {
        this.ctx = ctx2;
    }

    public static LocalFragmentManager getInstance(Context ctx2) {
        if (instance == null) {
            instance = new LocalFragmentManager(ctx2.getApplicationContext());
        }
        return instance;
    }

    public Stack<Fragment> getFragmentStack(int type) {
        if (type == -1) {
            type = this.currentTab;
        }
        switch (type) {
            case 0:
                if (this.homeFragmentStack == null) {
                    this.homeFragmentStack = new Stack<>();
                }
                return this.homeFragmentStack;
            case 1:
                if (this.dailyfragmentStack == null) {
                    this.dailyfragmentStack = new Stack<>();
                }
                return this.dailyfragmentStack;
            case 2:
                if (this.weeklyfragmentStack == null) {
                    this.weeklyfragmentStack = new Stack<>();
                }
                return this.weeklyfragmentStack;
            case 3:
                if (this.newsfragmentStack == null) {
                    this.newsfragmentStack = new Stack<>();
                }
                return this.newsfragmentStack;
            case 4:
                if (this.calendarfragmentStack == null) {
                    this.calendarfragmentStack = new Stack<>();
                }
                return this.calendarfragmentStack;
            default:
                return null;
        }
    }

    public void setFragmentStack(Stack<Fragment> fragmentStack, int type) {
        switch (type) {
            case 0:
                this.homeFragmentStack = fragmentStack;
                return;
            case 1:
                this.dailyfragmentStack = fragmentStack;
                return;
            case 2:
                this.weeklyfragmentStack = fragmentStack;
                return;
            case 3:
                this.newsfragmentStack = fragmentStack;
                return;
            case 4:
                this.calendarfragmentStack = fragmentStack;
                return;
            default:
                return;
        }
    }

    public Fragment getLastFragment() {
        return this.lastFragment;
    }

    public void setLastFragment(Fragment lastFragment2) {
        this.lastFragment = lastFragment2;
    }

    public boolean isSameAsLastFragment(Fragment newFragment) {
        return this.lastFragment.equals(newFragment);
    }

    public void removeFromStack(Fragment fragment) {
        Stack<Fragment> fragmentStack = getCurrentStack();
        Fragment removable = null;
        if (fragmentStack != null && !fragmentStack.isEmpty()) {
            Iterator it = fragmentStack.iterator();
            while (it.hasNext()) {
                Fragment current = (Fragment) it.next();
                if (current.getClass() == fragment.getClass()) {
                    removable = current;
                }
            }
            if (removable != null) {
                fragmentStack.remove(removable);
            }
        }
    }

    private Stack<Fragment> getCurrentStack() {
        switch (this.currentTab) {
            case 0:
                return this.homeFragmentStack;
            case 1:
                return this.dailyfragmentStack;
            case 2:
                return this.weeklyfragmentStack;
            case 3:
                return this.newsfragmentStack;
            case 4:
                return this.calendarfragmentStack;
            default:
                return null;
        }
    }

    public boolean contains(Fragment fragment) {
        Stack<Fragment> fragmentStack = getCurrentStack();
        boolean contains = false;
        if (fragmentStack != null) {
            Iterator it = fragmentStack.iterator();
            while (it.hasNext()) {
                if (((Fragment) it.next()).getClass() == fragment.getClass()) {
                    contains = true;
                }
            }
        }
        return contains;
    }

    public int getCurrentTab() {
        return this.currentTab;
    }

    public void setCurrentTab(int currentTab2) {
        this.currentTab = currentTab2;
    }

    public void clearAllStacks() {
        if (this.dailyfragmentStack != null) {
            this.dailyfragmentStack.clear();
        }
        if (this.newsfragmentStack != null) {
            this.newsfragmentStack.clear();
        }
        if (this.homeFragmentStack != null) {
            this.homeFragmentStack.clear();
        }
        if (this.weeklyfragmentStack != null) {
            this.weeklyfragmentStack.clear();
        }
        if (this.calendarfragmentStack != null) {
            this.calendarfragmentStack.clear();
        }
    }
}
