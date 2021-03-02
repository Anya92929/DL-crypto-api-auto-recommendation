package p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.CompaniesFragment */
public class CompaniesFragment extends ListFragment {

    /* renamed from: a */
    private final View.OnClickListener f5544a = new View.OnClickListener() {
        public void onClick(View view) {
            CompaniesFragment.this.m6395b().setCompaniesHintVisibility(false);
            CompaniesFragment.this.f5546c.getCloseButton().setOnClickListener((View.OnClickListener) null);
            CompaniesFragment.this.getListView().removeHeaderView(CompaniesFragment.this.f5546c);
            CompaniesHeader unused = CompaniesFragment.this.f5546c = null;
        }
    };

    /* renamed from: b */
    private final C1715b f5545b = new C1715b();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CompaniesHeader f5546c;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.CompaniesFragment$CompaniesActivity */
    public interface CompaniesActivity {
        Root getRoot();

        boolean isCompaniesHintVisible();

        void onCompanySelected(Company company);

        void setCompaniesHintVisibility(boolean z);
    }

    public C1714a getListAdapter() {
        return (C1714a) super.getListAdapter();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof InitActivity)) {
            throw new IllegalStateException("The activity must implement the CompaniesFragment.CompaniesActivity interface!");
        }
    }

    public App getApp() {
        return (App) getActivity().getApplication();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.volker_link_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(C1352R.C1354id.search).getActionView();
        searchView.setOnQueryTextListener(this.f5545b);
        searchView.setOnCloseListener(this.f5545b);
        searchView.setOnQueryTextFocusChangeListener(this.f5545b);
        m6394a(searchView);
        m6397b(searchView);
    }

    /* renamed from: a */
    private void m6394a(SearchView searchView) {
        try {
            Field declaredField = SearchView.class.getDeclaredField("mCloseButton");
            declaredField.setAccessible(true);
            ((ImageView) declaredField.get(searchView)).setImageResource(C1352R.C1353drawable.ic_action_cancel);
            Field declaredField2 = SearchView.class.getDeclaredField("mSearchButton");
            declaredField2.setAccessible(true);
            ((ImageView) declaredField2.get(searchView)).setImageResource(C1352R.C1353drawable.ic_action_search);
        } catch (NoSuchFieldException e) {
            AppState.getInstance().log().mo8930e("Error in CompaniesFragment", e);
        } catch (IllegalAccessException e2) {
            AppState.getInstance().log().mo8930e("Error in CompaniesFragment", e2);
        }
    }

    /* renamed from: b */
    private void m6397b(SearchView searchView) {
        EditText editText = (EditText) searchView.findViewById(searchView.getContext().getResources().getIdentifier("android:id/search_src_text", (String) null, (String) null));
        editText.setTextColor(getActivity().getResources().getColor(C1352R.color.vw_text_white));
        editText.setImeOptions(3);
    }

    public void onDestroyView() {
        if (this.f5546c != null) {
            this.f5546c.getCloseButton().setOnClickListener((View.OnClickListener) null);
        }
        super.onDestroyView();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        m6395b().onCompanySelected((Company) getListAdapter().getItem(i - listView.getHeaderViewsCount()));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (m6395b().isCompaniesHintVisible()) {
            this.f5546c = (CompaniesHeader) getActivity().getLayoutInflater().inflate(C1352R.layout.volker_link_header, getListView(), false);
            this.f5546c.getCloseButton().setOnClickListener(this.f5544a);
            getListView().addHeaderView(this.f5546c, (Object) null, false);
        }
        setEmptyText("Geen bedrijven aanwezig!");
        setListAdapter(new C1714a());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<Company> m6391a() {
        TreeSet treeSet = new TreeSet(new Comparator<Company>() {
            /* renamed from: a */
            public int compare(Company company, Company company2) {
                return company.getTitle().compareToIgnoreCase(company2.getTitle());
            }
        });
        treeSet.addAll(m6395b().getRoot().getAllCompanies());
        return new ArrayList(treeSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public CompaniesActivity m6395b() {
        return (CompaniesActivity) getActivity();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.CompaniesFragment$a */
    class C1714a extends ArrayAdapter<Company> {

        /* renamed from: b */
        private final LayoutInflater f5550b = LayoutInflater.from(CompaniesFragment.this.getActivity());

        public C1714a() {
            super(CompaniesFragment.this.getActivity(), 17367063, CompaniesFragment.this.m6391a());
        }

        public long getItemId(int i) {
            if (m6400a(i)) {
                return ((Company) getItem(i)).getServerId();
            }
            return Long.MIN_VALUE;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f5550b.inflate(C1352R.layout.simple_list_item_activated_2, viewGroup, false);
            }
            Company company = (Company) getItem(i);
            ((TextView) view.findViewById(16908308)).setText(company.getTitle());
            ((TextView) view.findViewById(16908309)).setText(company.getDescription());
            return view;
        }

        public boolean hasStableIds() {
            return true;
        }

        /* renamed from: a */
        private boolean m6400a(int i) {
            return i >= 0 && i < getCount();
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.CompaniesFragment$b */
    class C1715b implements View.OnFocusChangeListener, SearchView.OnCloseListener, SearchView.OnQueryTextListener {
        private C1715b() {
        }

        public boolean onClose() {
            m6401a((String) null);
            return true;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                m6401a((String) null);
            }
        }

        public boolean onQueryTextChange(String str) {
            m6401a(str);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            m6401a(str);
            return false;
        }

        /* renamed from: a */
        private void m6401a(String str) {
            C1714a listAdapter = CompaniesFragment.this.getListAdapter();
            if (listAdapter != null) {
                listAdapter.getFilter().filter(str);
            }
        }
    }
}
