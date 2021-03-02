package p006nl.volkerinfradesign.checkandroid.p007ui.inspections;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.collections4.map.ListOrderedMap;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.main.MainActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.SupportExpandableListFragment;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ClosedFragment */
public class ClosedFragment extends SupportExpandableListFragment {
    protected static final int REQUEST_CODE_SHOW_ITEM = 9473;

    /* renamed from: a */
    static final SimpleDateFormat f5282a = new SimpleDateFormat("HH:mm dd-MM-yyyy", Locale.ROOT);

    /* renamed from: aj */
    private final DataSetObserver f5283aj = new DataSetObserver() {
        public void onChanged() {
            super.onChanged();
            ClosedAdapter expandableListAdapter = ClosedFragment.this.getExpandableListAdapter();
            if (expandableListAdapter != null) {
                expandableListAdapter.notifyDataSetChanged();
            }
        }

        public void onInvalidated() {
            super.onInvalidated();
            ClosedAdapter expandableListAdapter = ClosedFragment.this.getExpandableListAdapter();
            if (expandableListAdapter != null) {
                expandableListAdapter.notifyDataSetInvalidated();
            }
        }
    };

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ClosedFragment$ClosedInspectionsActivity */
    public interface ClosedInspectionsActivity {
        boolean uploadInspections();
    }

    public ClosedAdapter getExpandableListAdapter() {
        return (ClosedAdapter) super.getExpandableListAdapter();
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        startActivity(InspectionActivity.getIntent((Context) getActivity(), getExpandableListAdapter().getChild(i, i2).f5290d, true));
        return true;
    }

    /* JADX INFO: finally extract failed */
    public boolean onContextItemSelected(MenuItem menuItem) {
        ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo) menuItem.getMenuInfo();
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListContextMenuInfo.packedPosition);
        int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListContextMenuInfo.packedPosition);
        InspectionsTable.DataCursor byId = Schema.getInspectionData().getById(getExpandableListAdapter().getChild(packedPositionGroup, packedPositionChild).f5289c);
        try {
            int itemId = menuItem.getItemId();
            if (itemId == C1352R.C1354id.deleteInspection) {
                if (byId.moveToFirst()) {
                    byId.delete();
                    getExpandableListAdapter().notifyDataSetChanged();
                    ((MainActivity) getActivity()).inspectionClickListener.onInspectionDeleted(byId, 0, byId.getId());
                }
                byId.close();
                return true;
            } else if (itemId == C1352R.C1354id.showInspection) {
                if (byId.moveToFirst()) {
                    startActivity(InspectionActivity.getIntent((Context) getActivity(), getExpandableListAdapter().getChild(packedPositionGroup, packedPositionChild).f5290d, true));
                }
                byId.close();
                return true;
            } else {
                boolean onContextItemSelected = super.onContextItemSelected(menuItem);
                byId.close();
                return onContextItemSelected;
            }
        } catch (Throwable th) {
            byId.close();
            throw th;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo) contextMenuInfo;
        if (ExpandableListView.getPackedPositionType(expandableListContextMenuInfo.packedPosition) == 1) {
            C1621a child = getExpandableListAdapter().getChild(ExpandableListView.getPackedPositionGroup(expandableListContextMenuInfo.packedPosition), ExpandableListView.getPackedPositionChild(expandableListContextMenuInfo.packedPosition));
            getActivity().getMenuInflater().inflate(C1352R.C1355menu.open_inspection_context, contextMenu);
            contextMenu.setHeaderTitle(child.f5292f);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.inspections_options, menu);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1352R.layout.closed_inspections_list_content, viewGroup, false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C1352R.C1354id.uploadInspections) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((ClosedInspectionsActivity) getActivity()).uploadInspections();
        return true;
    }

    public void onPause() {
        ((App) getActivity().getApplication()).unregisterDataSetObserver(this.f5283aj);
        super.onPause();
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (((App) getActivity().getApplication()).getRoot() != null) {
            menu.findItem(C1352R.C1354id.uploadInspections).setVisible(Schema.getInspectionData().hasPending(false));
        }
    }

    public void onResume() {
        super.onResume();
        setListAdapter(new ClosedAdapter());
        onContentChanged();
        getActivity().invalidateOptionsMenu();
        ((App) getActivity().getApplication()).registerDataSetObserver(this.f5283aj);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        registerForContextMenu(getExpandableListView());
        getExpandableListView().setDividerHeight(0);
        getExpandableListView().setEmptyView(view.findViewById(16908292));
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ClosedFragment$ClosedAdapter */
    public class ClosedAdapter extends BaseExpandableListAdapter {

        /* renamed from: b */
        private final ListOrderedMap<String, List<C1621a>> f5286b;

        private ClosedAdapter() {
            this.f5286b = new ListOrderedMap<>();
            m6222a();
        }

        public C1621a getChild(int i, int i2) {
            return (C1621a) this.f5286b.getValue(i).get(i2);
        }

        public long getChildId(int i, int i2) {
            return getChild(i, i2).f5288b;
        }

        public int getChildrenCount(int i) {
            return this.f5286b.getValue(i).size();
        }

        public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ClosedFragment.this.getActivity().getLayoutInflater().inflate(C1352R.layout.inspections_item, viewGroup, false);
            }
            C1621a child = getChild(i, i2);
            ProgressBar progressBar = (ProgressBar) view.findViewById(16908301);
            ((TextView) view.findViewById(16908308)).setText(child.f5292f);
            ((TextView) view.findViewById(16908309)).setText(child.f5293g);
            ((TextView) view.findViewById(16908304)).setText(ClosedFragment.f5282a.format(Long.valueOf(child.f5287a.getTime())));
            switch (i) {
                case 0:
                    progressBar.setVisibility(0);
                    progressBar.setProgress((int) (child.f5291e * ((float) progressBar.getMax())));
                    break;
                case 1:
                    progressBar.setVisibility(8);
                    break;
            }
            return view;
        }

        public String getGroup(int i) {
            return this.f5286b.get(i);
        }

        public int getGroupCount() {
            return this.f5286b.size();
        }

        public long getGroupId(int i) {
            return (long) i;
        }

        public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ClosedFragment.this.getActivity().getLayoutInflater().inflate(C1352R.layout.simple_expandable_list_item_2, viewGroup, false);
            }
            int childrenCount = getChildrenCount(i);
            TextView textView = (TextView) view.findViewById(16908309);
            ((TextView) view.findViewById(16908308)).setText(getGroup(i));
            switch (childrenCount) {
                case 1:
                    textView.setText("1 formulier");
                    break;
                default:
                    textView.setText(childrenCount + " formulieren");
                    break;
            }
            return view;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isChildSelectable(int i, int i2) {
            return true;
        }

        public void notifyDataSetChanged() {
            if (m6222a()) {
                super.notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private boolean m6222a() {
            Root root = ((App) ClosedFragment.this.getActivity().getApplication()).getRoot();
            this.f5286b.clear();
            if (root == null) {
                return false;
            }
            InspectionsTable.DataCursor pending = Schema.getInspectionData().getPending(false);
            InspectionsTable.DataCursor closed = Schema.getInspectionData().getClosed(false);
            try {
                this.f5286b.put("Outbox", C1621a.m6223a(pending, true));
                this.f5286b.put("Verzonden", C1621a.m6223a(closed, true));
                pending.close();
                closed.close();
                return true;
            } catch (Throwable th) {
                pending.close();
                closed.close();
                throw th;
            }
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ClosedFragment$a */
    static class C1621a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Date f5287a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long f5288b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final long f5289c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final InspectionKey f5290d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final float f5291e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public final String f5292f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final String f5293g;

        /* renamed from: a */
        public static List<C1621a> m6223a(InspectionsTable.DataCursor dataCursor, boolean z) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (dataCursor.moveToPosition(i)) {
                try {
                    arrayList.add(new C1621a(dataCursor));
                    i++;
                } finally {
                    if (z) {
                        dataCursor.close();
                    }
                }
            }
            return arrayList;
        }

        private C1621a(InspectionsTable.DataCursor dataCursor) {
            this.f5290d = dataCursor.getKey();
            this.f5288b = dataCursor.getFormServerId();
            this.f5292f = dataCursor.getTitle();
            this.f5293g = dataCursor.hasProjectServerId() ? Schema.getProjects().getProjectName(dataCursor.getProjectServerId().longValue()) : dataCursor.getDescription();
            this.f5287a = dataCursor.getCreationDate();
            this.f5289c = dataCursor.getId();
            this.f5291e = dataCursor.getVirtualProgress();
        }
    }
}
