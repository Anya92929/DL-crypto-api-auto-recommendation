package com.p028a.p031c;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.p028a.C0765a;
import java.io.File;
import java.util.Comparator;

/* renamed from: com.a.c.c */
public class C0778c implements TextWatcher, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, Runnable, Comparator {

    /* renamed from: a */
    private Object f2018a;

    /* renamed from: b */
    private String f2019b;

    /* renamed from: c */
    private Object[] f2020c;

    /* renamed from: d */
    private boolean f2021d;

    /* renamed from: e */
    private Class[] f2022e;

    /* renamed from: f */
    private int f2023f;

    /* renamed from: g */
    private int f2024g = 0;

    /* renamed from: h */
    private AbsListView.OnScrollListener f2025h;

    /* renamed from: i */
    private int f2026i;

    /* renamed from: j */
    private AdapterView.OnItemSelectedListener f2027j;

    /* renamed from: k */
    private boolean f2028k = false;

    /* renamed from: a */
    private Object m3546a(Object... objArr) {
        if (this.f2019b != null) {
            Object[] objArr2 = this.f2020c != null ? this.f2020c : objArr;
            Object obj = this.f2018a;
            if (obj == null) {
                obj = this;
            }
            return C0776a.m3514a(obj, this.f2019b, this.f2021d, true, this.f2022e, objArr2);
        }
        if (this.f2023f != 0) {
            switch (this.f2023f) {
                case 1:
                    C0776a.m3533b((File) this.f2020c[0], (byte[]) this.f2020c[1]);
                    break;
                case 2:
                    C0776a.m3519a((File) this.f2020c[0], ((Long) this.f2020c[1]).longValue(), ((Long) this.f2020c[2]).longValue());
                    break;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m3547a(AbsListView absListView, int i) {
        int count = absListView.getCount();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        if (i != 0 || count != lastVisiblePosition + 1) {
            this.f2026i = -1;
        } else if (lastVisiblePosition != this.f2026i) {
            this.f2026i = lastVisiblePosition;
            m3546a(absListView, Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    private void m3548a(ExpandableListView expandableListView, int i) {
        expandableListView.setTag(1090453508, Integer.valueOf(i));
        if (i == 0) {
            int firstVisiblePosition = expandableListView.getFirstVisiblePosition();
            int lastVisiblePosition = expandableListView.getLastVisiblePosition() - firstVisiblePosition;
            ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
            for (int i2 = 0; i2 <= lastVisiblePosition; i2++) {
                long expandableListPosition = expandableListView.getExpandableListPosition(i2 + firstVisiblePosition);
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                if (packedPositionGroup >= 0) {
                    View childAt = expandableListView.getChildAt(i2);
                    Long l = (Long) childAt.getTag(1090453508);
                    if (l != null && l.longValue() == expandableListPosition) {
                        if (packedPositionChild == -1) {
                            expandableListAdapter.getGroupView(packedPositionGroup, expandableListView.isGroupExpanded(packedPositionGroup), childAt, expandableListView);
                        } else {
                            expandableListAdapter.getChildView(packedPositionGroup, packedPositionChild, packedPositionChild == expandableListAdapter.getChildrenCount(packedPositionGroup) + -1, childAt, expandableListView);
                        }
                        childAt.setTag(1090453508, (Object) null);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m3549a(Object obj, String str, boolean z) {
        if (obj == null) {
            return;
        }
        if (obj instanceof View) {
            View view = (View) obj;
            ProgressBar progressBar = obj instanceof ProgressBar ? (ProgressBar) obj : null;
            if (z) {
                view.setTag(1090453505, str);
                view.setVisibility(0);
                if (progressBar != null) {
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    return;
                }
                return;
            }
            Object tag = view.getTag(1090453505);
            if (tag == null || tag.equals(str)) {
                view.setTag(1090453505, (Object) null);
                if (progressBar == null || progressBar.isIndeterminate()) {
                    view.setVisibility(8);
                }
            }
        } else if (obj instanceof Dialog) {
            Dialog dialog = (Dialog) obj;
            C0765a aVar = new C0765a(dialog.getContext());
            if (z) {
                aVar.mo3461a(dialog);
            } else {
                aVar.mo3476b(dialog);
            }
        } else if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            activity.setProgressBarIndeterminateVisibility(z);
            activity.setProgressBarVisibility(z);
            if (z) {
                activity.setProgress(0);
            }
        }
    }

    /* renamed from: b */
    private void m3550b(AbsListView absListView, int i) {
        absListView.setTag(1090453508, Integer.valueOf(i));
        if (i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            int lastVisiblePosition = absListView.getLastVisiblePosition() - firstVisiblePosition;
            ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
            for (int i2 = 0; i2 <= lastVisiblePosition; i2++) {
                long j = (long) (i2 + firstVisiblePosition);
                View childAt = absListView.getChildAt(i2);
                if (((Number) childAt.getTag(1090453508)) != null) {
                    listAdapter.getView((int) j, childAt, absListView);
                    childAt.setTag(1090453508, (Object) null);
                }
            }
        }
    }

    /* renamed from: a */
    public int compare(File file, File file2) {
        long lastModified = file.lastModified();
        long lastModified2 = file2.lastModified();
        if (lastModified2 > lastModified) {
            return 1;
        }
        return lastModified2 == lastModified ? 0 : -1;
    }

    /* renamed from: a */
    public C0778c mo3561a(int i, Object... objArr) {
        this.f2023f = i;
        this.f2020c = objArr;
        return this;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onClick(View view) {
        m3546a(view);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m3546a(adapterView, view, Integer.valueOf(i), Long.valueOf(j));
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        m3546a(adapterView, view, Integer.valueOf(i), Long.valueOf(j));
        if (this.f2027j != null) {
            this.f2027j.onItemSelected(adapterView, view, i, j);
        }
        if (this.f2028k && ((Integer) adapterView.getTag(1090453508)).intValue() != i) {
            Adapter adapter = adapterView.getAdapter();
            adapterView.setTag(1090453508, Integer.valueOf(i));
            int childCount = adapterView.getChildCount();
            int firstVisiblePosition = adapterView.getFirstVisiblePosition();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = adapterView.getChildAt(i2);
                int i3 = firstVisiblePosition + i2;
                Integer num = (Integer) childAt.getTag(1090453508);
                if (num == null || num.intValue() != i3) {
                    adapter.getView(i3, childAt, adapterView);
                }
            }
        }
    }

    public boolean onLongClick(View view) {
        Object a = m3546a(view);
        if (a instanceof Boolean) {
            return ((Boolean) a).booleanValue();
        }
        return false;
    }

    public void onNothingSelected(AdapterView adapterView) {
        if (this.f2027j != null) {
            this.f2027j.onNothingSelected(adapterView);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        m3547a(absListView, this.f2024g);
        if (this.f2025h != null) {
            this.f2025h.onScroll(absListView, i, i2, i3);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f2024g = i;
        m3547a(absListView, i);
        if (absListView instanceof ExpandableListView) {
            m3548a((ExpandableListView) absListView, i);
        } else {
            m3550b(absListView, i);
        }
        if (this.f2025h != null) {
            this.f2025h.onScrollStateChanged(absListView, i);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m3546a(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void run() {
        m3546a(new Object[0]);
    }
}
