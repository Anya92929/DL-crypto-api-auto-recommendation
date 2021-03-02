package p006nl.volkerinfradesign.checkandroid.p007ui.widgets;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.SupportExpandableListView */
public class SupportExpandableListView extends ExpandableListView {

    /* renamed from: a */
    private boolean[] f5654a;

    /* renamed from: b */
    private Integer f5655b;

    /* renamed from: c */
    private Integer f5656c;

    public SupportExpandableListView(Context context) {
        super(context);
    }

    public SupportExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SupportExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle(4);
        ExpandableListAdapter expandableListAdapter = getExpandableListAdapter();
        int firstVisiblePosition = getFirstVisiblePosition();
        int top = getChildAt(0) == null ? 0 : getChildAt(0).getTop();
        if (expandableListAdapter != null) {
            int groupCount = expandableListAdapter.getGroupCount();
            boolean[] zArr = new boolean[groupCount];
            for (int i = 0; i < groupCount; i++) {
                zArr[i] = isGroupExpanded(i);
            }
            bundle.putBooleanArray("expanded_groups", zArr);
        }
        bundle.putInt("fist_visible_position", firstVisiblePosition);
        bundle.putInt("scroll_top", top);
        bundle.putParcelable("intrinsic_state", super.onSaveInstanceState());
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("intrinsic_state"));
        this.f5655b = Integer.valueOf(bundle.getInt("fist_visible_position"));
        this.f5656c = Integer.valueOf(bundle.getInt("scroll_top"));
        this.f5654a = bundle.getBooleanArray("expanded_groups");
        m6456a();
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        m6456a();
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        super.setAdapter(expandableListAdapter);
        m6456a();
    }

    /* renamed from: a */
    private void m6456a() {
        if (getExpandableListAdapter() != null && this.f5654a != null && this.f5655b != null && this.f5656c != null) {
            for (int i = 0; i < this.f5654a.length; i++) {
                if (this.f5654a[i]) {
                    expandGroup(i);
                }
            }
            setSelectionFromTop(this.f5655b.intValue(), this.f5656c.intValue());
            this.f5656c = null;
            this.f5655b = null;
            this.f5654a = null;
        }
    }
}
