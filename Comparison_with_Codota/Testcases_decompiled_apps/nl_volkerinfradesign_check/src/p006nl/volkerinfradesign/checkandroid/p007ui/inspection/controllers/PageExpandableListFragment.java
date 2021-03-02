package p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorTreeAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemsTable;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.environments.Logger;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view.ItemView;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.SupportExpandableListFragment;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageExpandableListFragment */
public class PageExpandableListFragment extends SupportExpandableListFragment implements PageFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1256ij f5197a;

    /* renamed from: aj */
    private final PageFragment.PageObserver f5198aj = new PageFragment.PageObserver() {
        public void changeData() {
            PageExpandableListFragment.this.getExpandableListAdapter().changeCursor(PageExpandableListFragment.this.f5197a.f4408c.getHeaders());
            invalidateFooter();
        }

        public void notifyDataSetChanged() {
            PageExpandableListFragment.this.getExpandableListAdapter().notifyDataSetChanged();
            invalidateFooter();
        }

        public void invalidateFooter() {
            PageExpandableListFragment.this.f5197a.mo8575c();
        }

        public boolean scrollToFirstInvalid() {
            C1612a expandableListAdapter;
            ExpandableListView expandableListView = PageExpandableListFragment.this.getExpandableListView();
            if (expandableListView == null || (expandableListAdapter = PageExpandableListFragment.this.getExpandableListAdapter()) == null) {
                return false;
            }
            Logger logger = AppState.getInstance().getModel().getLogger();
            for (int i = 0; i < expandableListAdapter.getGroupCount(); i++) {
                int i2 = 0;
                while (i2 < expandableListAdapter.getChildrenCount(i)) {
                    if (!expandableListAdapter.getChild(i, i2).isValid()) {
                        long packedPositionForChild = ExpandableListView.getPackedPositionForChild(i, i2);
                        if (packedPositionForChild == 2 || packedPositionForChild == 4294967295L) {
                            logger.logError("Could not scroll to packedPosition " + packedPositionForChild, (Throwable) null);
                            return false;
                        }
                        try {
                            expandableListView.smoothScrollToPosition(expandableListView.getFlatListPosition(packedPositionForChild));
                            return true;
                        } catch (NullPointerException e) {
                            logger.logError("Could not scroll to packedPosition " + packedPositionForChild, e);
                            return false;
                        }
                    } else {
                        i2++;
                    }
                }
            }
            return true;
        }
    };

    public static PageExpandableListFragment newInstance(InspectionKey inspectionKey, String str, int i) {
        PageExpandableListFragment pageExpandableListFragment = new PageExpandableListFragment();
        pageExpandableListFragment.setArguments(C1256ij.m5555a(inspectionKey, str, i));
        return pageExpandableListFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5197a = new C1256ij((InspectionFragment) getParentFragment(), this, getArguments(), bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ExpandableListView expandableListView = getExpandableListView();
        this.f5197a.mo8570a((ListView) expandableListView);
        view.setBackgroundColor(getResources().getColor(C1352R.color.vw_bg_gray));
        expandableListView.setGroupIndicator(getResources().getDrawable(C1352R.C1353drawable.group_indicator));
        this.f5197a.f4412g = getActivity().getLayoutInflater().inflate(C1352R.layout.ins3_footer, expandableListView, false);
        expandableListView.addFooterView(this.f5197a.f4412g, (Object) null, false);
        setListAdapter(new C1612a());
        this.f5197a.mo8575c();
        this.f5197a.f4406a.registerObserver(this.f5198aj);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f5197a.mo8569a(menu, menuInflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f5197a.mo8568a(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f5197a.mo8573a((PageFragment) this, menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f5197a.mo8567a(bundle);
    }

    public void onDestroyView() {
        this.f5197a.f4406a.unregisterObserver(this.f5198aj);
        getExpandableListAdapter().changeCursor((Cursor) null);
        super.onDestroyView();
    }

    public InspectionItemConstants.ItemCursor getItem(long j) {
        return getExpandableListAdapter().mo10037a(j);
    }

    public InspectionKey getKey() {
        return this.f5197a.f4408c;
    }

    public String getTitle() {
        return this.f5197a.f4409d;
    }

    public int getPosition() {
        return this.f5197a.f4410e;
    }

    public C1612a getExpandableListAdapter() {
        return (C1612a) super.getExpandableListAdapter();
    }

    public String toString() {
        String supportExpandableListFragment = super.toString();
        return this.f5197a == null ? supportExpandableListFragment : this.f5197a.mo8566a(supportExpandableListFragment);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageExpandableListFragment$a */
    final class C1612a extends CursorTreeAdapter {

        /* renamed from: b */
        private final LayoutInflater f5201b;

        C1612a() {
            super(PageExpandableListFragment.this.f5197a.f4408c.getHeaders(), PageExpandableListFragment.this.getActivity());
            this.f5201b = PageExpandableListFragment.this.getActivity().getLayoutInflater();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public InspectionItemConstants.ItemCursor getChildrenCursor(Cursor cursor) {
            return PageExpandableListFragment.this.f5197a.f4408c.getItems((InspectionItemConstants.HeaderCursor) cursor);
        }

        /* renamed from: a */
        public InspectionItemConstants.HeaderCursor getGroup(int i) {
            return (InspectionItemConstants.HeaderCursor) super.getGroup(i);
        }

        /* access modifiers changed from: protected */
        public View newGroupView(Context context, Cursor cursor, boolean z, ViewGroup viewGroup) {
            switch (getGroupType(cursor.getPosition())) {
                case 0:
                    return this.f5201b.inflate(C1352R.layout.simple_expandable_list_item_2, viewGroup, false);
                case 1:
                    View view = new View(PageExpandableListFragment.this.getActivity());
                    view.setVisibility(8);
                    return view;
                default:
                    throw new IllegalArgumentException("Wrong view for header");
            }
        }

        /* access modifiers changed from: protected */
        public void bindGroupView(View view, Context context, Cursor cursor, boolean z) {
            switch (getGroupType(cursor.getPosition())) {
                case 0:
                    InspectionItemConstants.HeaderCursor headerCursor = (InspectionItemConstants.HeaderCursor) cursor;
                    Pair<Integer, Integer> validChildCount = headerCursor.getValidChildCount();
                    ((TextView) view.findViewById(16908308)).setText(headerCursor.getTitle());
                    ((TextView) view.findViewById(16908309)).setText(validChildCount.first + "/" + validChildCount.second + " items");
                    return;
                case 1:
                    PageExpandableListFragment.this.getExpandableListView().expandGroup(0);
                    return;
                default:
                    throw new IllegalArgumentException("Wrong view for header");
            }
        }

        /* access modifiers changed from: protected */
        public View newChildView(Context context, Cursor cursor, boolean z, ViewGroup viewGroup) {
            ItemView itemView = (ItemView) this.f5201b.inflate(C1352R.layout.ins3_item_view, viewGroup, false);
            itemView.setObserver(PageExpandableListFragment.this.f5197a.f4413h);
            return itemView;
        }

        /* access modifiers changed from: protected */
        public void bindChildView(View view, Context context, Cursor cursor, boolean z) {
            InspectionItemConstants.ItemCursor itemCursor = (InspectionItemConstants.ItemCursor) cursor;
            ((ItemView) view).setInspectionItem(PageExpandableListFragment.this.f5197a.f4408c, itemCursor, PageExpandableListFragment.this.f5197a.mo8571a(), PageExpandableListFragment.this.f5197a.mo8574b(), PageExpandableListFragment.this.f5197a.mo8572a(itemCursor));
        }

        /* renamed from: a */
        public InspectionItemConstants.ItemCursor getChild(int i, int i2) {
            return (InspectionItemConstants.ItemCursor) super.getChild(i, i2);
        }

        public int getGroupTypeCount() {
            return 2;
        }

        public int getGroupType(int i) {
            return getGroup(i).getRecordType() == InspectionItemsTable.RecordType.HEADER ? 0 : 1;
        }

        /* renamed from: a */
        public InspectionItemConstants.ItemCursor mo10037a(long j) {
            for (int i = 0; i < getGroupCount(); i++) {
                for (int i2 = 0; i2 < getChildrenCount(i); i2++) {
                    InspectionItemConstants.ItemCursor a = getChild(i, i2);
                    if (a.getId() == j) {
                        return a;
                    }
                }
            }
            return null;
        }
    }
}
