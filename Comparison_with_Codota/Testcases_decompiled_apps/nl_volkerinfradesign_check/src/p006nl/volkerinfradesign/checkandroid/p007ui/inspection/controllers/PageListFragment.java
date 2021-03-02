package p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.p001v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view.ItemView;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageListFragment */
public final class PageListFragment extends ListFragment implements PageFragment {

    /* renamed from: aj */
    private final PageFragment.PageObserver f5202aj = new PageFragment.PageObserver() {
        public void changeData() {
            PageListFragment.this.getListAdapter().changeCursor(PageListFragment.this.f5203i.f4408c.getItems(true));
            invalidateFooter();
        }

        public void notifyDataSetChanged() {
            PageListFragment.this.getListAdapter().notifyDataSetChanged();
            invalidateFooter();
        }

        public void invalidateFooter() {
            PageListFragment.this.f5203i.mo8575c();
        }

        public boolean scrollToFirstInvalid() {
            C1615a listAdapter;
            ListView listView = PageListFragment.this.getListView();
            if (listView == null || (listAdapter = PageListFragment.this.getListAdapter()) == null) {
                return false;
            }
            for (int i = 0; i < listAdapter.getCount(); i++) {
                if (!listAdapter.getItem(i).isValid()) {
                    listView.smoothScrollToPosition(i);
                    return true;
                }
            }
            return true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1256ij f5203i;

    public static PageListFragment newInstance(InspectionKey inspectionKey, String str, int i) {
        PageListFragment pageListFragment = new PageListFragment();
        pageListFragment.setArguments(C1256ij.m5555a(inspectionKey, str, i));
        return pageListFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5203i = new C1256ij((InspectionFragment) getParentFragment(), this, getArguments(), bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ListView listView = getListView();
        this.f5203i.mo8570a(listView);
        view.setBackgroundColor(getResources().getColor(C1352R.color.vw_bg_gray));
        view.setBackgroundColor(getResources().getColor(C1352R.color.vw_bg_gray));
        this.f5203i.f4412g = getActivity().getLayoutInflater().inflate(C1352R.layout.ins3_footer, listView, false);
        listView.addFooterView(this.f5203i.f4412g, (Object) null, false);
        setListAdapter(new C1615a());
        this.f5203i.mo8575c();
        this.f5203i.f4406a.registerObserver(this.f5202aj);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f5203i.mo8569a(menu, menuInflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f5203i.mo8568a(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f5203i.mo8573a((PageFragment) this, menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f5203i.mo8567a(bundle);
    }

    public void onDestroyView() {
        this.f5203i.f4406a.unregisterObserver(this.f5202aj);
        getListAdapter().changeCursor((Cursor) null);
        super.onDestroyView();
    }

    public InspectionItemConstants.ItemCursor getItem(long j) {
        return getListAdapter().mo10050a(j);
    }

    public InspectionKey getKey() {
        return this.f5203i.f4408c;
    }

    public String getTitle() {
        return this.f5203i.f4409d;
    }

    public int getPosition() {
        return this.f5203i.f4410e;
    }

    public String toString() {
        String listFragment = super.toString();
        return this.f5203i == null ? listFragment : this.f5203i.mo8566a(listFragment);
    }

    public C1615a getListAdapter() {
        return (C1615a) super.getListAdapter();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageListFragment$a */
    final class C1615a extends CursorAdapter {

        /* renamed from: b */
        private final LayoutInflater f5207b;

        public C1615a() {
            super(PageListFragment.this.getActivity(), PageListFragment.this.f5203i.f4408c.getItems(true), 0);
            this.f5207b = PageListFragment.this.getActivity().getLayoutInflater();
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            switch (getItemViewType(cursor.getPosition())) {
                case 0:
                    return this.f5207b.inflate(C1352R.layout.category, viewGroup, false);
                default:
                    ItemView itemView = (ItemView) this.f5207b.inflate(C1352R.layout.ins3_item_view, viewGroup, false);
                    itemView.setObserver(PageListFragment.this.f5203i.f4413h);
                    return itemView;
            }
        }

        public void bindView(View view, Context context, Cursor cursor) {
            switch (getItemViewType(cursor.getPosition())) {
                case 0:
                    ((TextView) view.findViewById(16908308)).setText(((InspectionItemConstants.HeaderCursor) cursor).getTitle());
                    return;
                default:
                    InspectionItemConstants.ItemCursor itemCursor = (InspectionItemConstants.ItemCursor) cursor;
                    ((ItemView) view).setInspectionItem(PageListFragment.this.f5203i.f4408c, itemCursor, PageListFragment.this.f5203i.mo8571a(), PageListFragment.this.f5203i.mo8574b(), PageListFragment.this.f5203i.mo8572a(itemCursor));
                    return;
            }
        }

        public int getViewTypeCount() {
            return 2;
        }

        public int getItemViewType(int i) {
            switch (getItem(i).getRecordType()) {
                case DUMMY_HEADER:
                case HEADER:
                    return 0;
                default:
                    return 1;
            }
        }

        /* renamed from: a */
        public InspectionItemConstants.ItemCursor getItem(int i) {
            return (InspectionItemConstants.ItemCursor) super.getItem(i);
        }

        /* renamed from: a */
        public InspectionItemConstants.ItemCursor getCursor() {
            return (InspectionItemConstants.ItemCursor) super.getCursor();
        }

        /* renamed from: a */
        public InspectionItemConstants.ItemCursor mo10050a(long j) {
            InspectionItemConstants.ItemCursor a = getCursor();
            int i = 0;
            while (a != null && a.moveToPosition(i)) {
                if (a.getId() == j) {
                    return a;
                }
                i++;
            }
            return null;
        }
    }
}
