package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.p001v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormRef;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspections.InspectionsAdapter;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.SelectInspectionFragment */
public class SelectInspectionFragment extends DialogFragment {

    /* renamed from: aj */
    private static final SimpleDateFormat f5463aj = new SimpleDateFormat("HH:mm dd-MM-yyyy", Locale.ROOT);

    /* renamed from: ak */
    private final View.OnClickListener f5464ak = new View.OnClickListener() {
        /* renamed from: a */
        public Company mo10231a() {
            long j = SelectInspectionFragment.this.getArguments().getLong("check:company_server_id");
            for (Company next : ((App) SelectInspectionFragment.this.getActivity().getApplication()).getRoot().getAllCompanies()) {
                if (next.getServerId() == j) {
                    return next;
                }
            }
            return null;
        }

        /* renamed from: b */
        public FormRef mo10232b() {
            long j = SelectInspectionFragment.this.getArguments().getLong("check:form_server_id");
            for (FormRef next : ((App) SelectInspectionFragment.this.getActivity().getApplication()).getRoot().getAllFormRefs()) {
                if (next.getServerId() == j) {
                    return next;
                }
            }
            return null;
        }

        public void onClick(View view) {
            ((MainActivity) SelectInspectionFragment.this.getActivity()).mo10213a(mo10232b(), mo10231a());
            SelectInspectionFragment.this.dismiss();
        }
    };

    /* renamed from: al */
    private final AdapterView.OnItemClickListener f5465al = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ((MainActivity) SelectInspectionFragment.this.getActivity()).showInspection(((InspectionsAdapter) adapterView.getAdapter()).getItem(i).getKey(), false);
            SelectInspectionFragment.this.dismiss();
        }
    };

    /* renamed from: am */
    private ListView f5466am;

    /* renamed from: an */
    private View f5467an;

    public static SelectInspectionFragment newInstance(Company company, FormRef formRef) {
        SelectInspectionFragment selectInspectionFragment = new SelectInspectionFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("check:form_server_id", formRef.getServerId());
        bundle.putLong("check:company_server_id", company.getServerId());
        selectInspectionFragment.setArguments(bundle);
        return selectInspectionFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.select_inspection, viewGroup, false);
        this.f5466am = (ListView) inflate.findViewById(16908298);
        this.f5466am.setEmptyView(inflate.findViewById(16908292));
        this.f5467an = inflate.findViewById(16908313);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getListView().setAdapter(new InspectionsAdapter(getActivity(), Schema.getInspectionData().getOpen(getArguments().getLong("check:form_server_id"), false)));
        getListView().setOnItemClickListener(this.f5465al);
        getNewButton().setOnClickListener(this.f5464ak);
    }

    public void onDestroyView() {
        getListView().setOnItemClickListener((AdapterView.OnItemClickListener) null);
        getNewButton().setOnClickListener((View.OnClickListener) null);
        super.onDestroyView();
    }

    public ListView getListView() {
        if (this.f5466am != null) {
            return this.f5466am;
        }
        throw new IllegalStateException("Content view not yet created");
    }

    public View getNewButton() {
        return this.f5467an;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setTitle("Openstaande");
        return onCreateDialog;
    }
}
