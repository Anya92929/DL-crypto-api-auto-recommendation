package p006nl.volkerinfradesign.checkandroid.p007ui.inspections;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.p001v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.main.MainActivity;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.OpenFragment */
public class OpenFragment extends ListFragment {

    /* renamed from: i */
    private final DataSetObserver f5298i = new DataSetObserver() {
        public void onChanged() {
            super.onChanged();
            InspectionsAdapter listAdapter = OpenFragment.this.getListAdapter();
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }

        public void onInvalidated() {
            super.onInvalidated();
            InspectionsAdapter listAdapter = OpenFragment.this.getListAdapter();
            if (listAdapter != null) {
                listAdapter.notifyDataSetInvalidated();
            }
        }
    };

    public InspectionsAdapter getListAdapter() {
        return (InspectionsAdapter) super.getListAdapter();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (getListAdapter() != null) {
            getListAdapter().changeCursor(Schema.getInspectionData().getOpen(false));
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        InspectionsTable.DataCursor item = getListAdapter().getItem(adapterContextMenuInfo.position);
        int itemId = menuItem.getItemId();
        if (itemId == C1352R.C1354id.deleteInspection) {
            item.delete();
            getListAdapter().changeCursor(Schema.getInspectionData().getOpen(false));
            ((MainActivity) getActivity()).inspectionClickListener.onInspectionDeleted(item, adapterContextMenuInfo.position, adapterContextMenuInfo.id);
            return true;
        } else if (itemId != C1352R.C1354id.showInspection) {
            return super.onContextItemSelected(menuItem);
        } else {
            startActivityForResult(InspectionActivity.getIntent((Context) getActivity(), item.getKey(), false), 8008);
            return true;
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
        InspectionsTable.DataCursor item = getListAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        getActivity().getMenuInflater().inflate(C1352R.C1355menu.open_inspection_context, contextMenu);
        contextMenu.setHeaderTitle(item.getTitle());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.inspections_options, menu);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1352R.layout.open_inspections_list_content, viewGroup, false);
    }

    public void onDestroyView() {
        unregisterForContextMenu(getListView());
        super.onDestroyView();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        startActivityForResult(InspectionActivity.getIntent((Context) getActivity(), getListAdapter().getItem(i).getKey(), false), 8008);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C1352R.C1354id.uploadInspections) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((MainActivity) getActivity()).inspectionClickListener.uploadInspections();
        getListAdapter().changeCursor(Schema.getInspectionData().getOpen(false));
        return true;
    }

    public void onPause() {
        super.onPause();
        ((App) getActivity().getApplication()).unregisterDataSetObserver(this.f5298i);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (((App) getActivity().getApplication()).getRoot() != null) {
            menu.findItem(C1352R.C1354id.uploadInspections).setVisible(Schema.getInspectionData().hasUploadable());
        }
    }

    public void onResume() {
        super.onResume();
        setListAdapter(new InspectionsAdapter(getActivity(), Schema.getInspectionData().getOpen(false)));
        getActivity().invalidateOptionsMenu();
        ((App) getActivity().getApplication()).registerDataSetObserver(this.f5298i);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        registerForContextMenu(getListView());
        getListView().setDividerHeight(0);
        getListView().setEmptyView(view.findViewById(16908292));
    }
}
