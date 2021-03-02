package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.OverviewController;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.SubFormDownloadDialog;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.OverviewFragment */
public class OverviewFragment extends ListFragment implements OverviewController.Observer, SubFormDownloadDialog.SubFormDownloadParent {

    /* renamed from: i */
    private OverviewController f5149i;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.OverviewFragment$OverviewFragmentParent */
    public interface OverviewFragmentParent {
        void showSubInspection(OverviewController overviewController, OverviewController.OverviewItemController overviewItemController);
    }

    public static Fragment newInstance(InspectionItemConstants.ItemCursor itemCursor, int i, boolean z) {
        OverviewController overviewController = new OverviewController(itemCursor, i);
        OverviewFragment overviewFragment = new OverviewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("overview_fragment_controller", overviewController);
        bundle.putBoolean("overview_fragment_show_invalid", z);
        overviewFragment.setArguments(bundle);
        return overviewFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6158m().onCreate(this);
        setListAdapter(new C1594a());
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setEmptyText("Er zijn geen regels beschikbaar. Druk rechtsboven op '+' om een regel toe te voegen");
    }

    public void onDestroy() {
        m6158m().onDestroy();
        this.f5149i = null;
        setListAdapter((ListAdapter) null);
        super.onDestroy();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.overview_options, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            getActivity().onBackPressed();
        } else if (itemId == C1352R.C1354id.addSubInspection) {
            if (!m6158m().addInspection()) {
                C1254ii.m5553a(this, m6158m().itemKey, m6158m().getPosition());
            }
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public C1594a getListAdapter() {
        return (C1594a) super.getListAdapter();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6153a(int i) {
        final OverviewController.OverviewItemController item = m6158m().getItem(i);
        new AlertDialog.Builder(getActivity()).setIcon(C1352R.C1353drawable.ic_action_delete_light).setTitle("Verwijderen").setMessage("Weet u zeker dat u " + item.getTitle() + " wilt verwijderen?").setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                item.delete();
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public OverviewFragmentParent m6157l() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || !(parentFragment instanceof OverviewFragmentParent)) {
            return (OverviewFragmentParent) getActivity();
        }
        return (OverviewFragmentParent) parentFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public OverviewController m6158m() {
        if (this.f5149i == null) {
            this.f5149i = (OverviewController) getArguments().getParcelable("overview_fragment_controller");
        }
        return this.f5149i;
    }

    public void onSubInspectionsChanged() {
        C1594a listAdapter = getListAdapter();
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m6159n() {
        return getArguments().getBoolean("overview_fragment_show_invalid", false);
    }

    public void onSubFormDownloaded(InspectionItemKey inspectionItemKey, int i) {
        m6158m().addInspection();
    }

    public App getApp() {
        return (App) getActivity().getApplication();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.OverviewFragment$a */
    final class C1594a extends BaseAdapter {

        /* renamed from: b */
        private final LayoutInflater f5153b;

        private C1594a() {
            this.f5153b = OverviewFragment.this.getActivity().getLayoutInflater();
        }

        public int getCount() {
            return OverviewFragment.this.m6158m().getCount();
        }

        /* renamed from: a */
        public OverviewController.OverviewItemController getItem(int i) {
            return OverviewFragment.this.m6158m().getItem(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1595b bVar;
            OverviewController.OverviewItemController a = getItem(i);
            if (view == null) {
                view = this.f5153b.inflate(C1352R.layout.overview_item, viewGroup, false);
                bVar = new C1595b(view);
                view.setTag(bVar);
            } else {
                bVar = (C1595b) view.getTag();
            }
            bVar.mo9993a(a);
            return view;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.OverviewFragment$b */
    final class C1595b {

        /* renamed from: b */
        private final View f5155b;

        /* renamed from: c */
        private final TextView f5156c;

        /* renamed from: d */
        private final TextView f5157d;

        /* renamed from: e */
        private final ImageButton f5158e;

        public C1595b(View view) {
            this.f5155b = view;
            this.f5156c = (TextView) view.findViewById(16908308);
            this.f5157d = (TextView) view.findViewById(16908309);
            this.f5158e = (ImageButton) view.findViewById(C1352R.C1354id.options);
        }

        /* renamed from: a */
        public void mo9993a(OverviewController.OverviewItemController overviewItemController) {
            final int position = overviewItemController.getPosition();
            this.f5155b.setBackgroundResource((!OverviewFragment.this.m6159n() || overviewItemController.isValid()) ? 17170445 : C1352R.color.invalid_card_red);
            this.f5156c.setText(overviewItemController.getTitle());
            this.f5157d.setText(overviewItemController.getDescription());
            this.f5155b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OverviewController a = OverviewFragment.this.m6158m();
                    OverviewFragment.this.m6157l().showSubInspection(a, a.getItem(position));
                }
            });
            this.f5155b.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    OverviewFragment.this.m6153a(position);
                    return true;
                }
            });
            this.f5158e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OverviewFragment.this.m6153a(position);
                }
            });
        }
    }
}
