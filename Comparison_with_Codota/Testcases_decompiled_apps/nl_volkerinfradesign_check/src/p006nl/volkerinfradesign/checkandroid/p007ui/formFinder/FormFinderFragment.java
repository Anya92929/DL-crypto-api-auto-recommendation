package p006nl.volkerinfradesign.checkandroid.p007ui.formFinder;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.OnBackPressedObservable;
import p006nl.volkerinfradesign.checkandroid.background.CheckService;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.Folder;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormRef;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;
import p006nl.volkerinfradesign.checkandroid.p007ui.main.MainActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.FixedViewPager;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager.Path;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager.ViewTreeAdapter;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment */
public class FormFinderFragment extends Fragment {
    public static final String PARCELLED_STATE = "form_finder:parcelled_state";
    public static final String PREFERENCE_STORED_STATE = "form_finder:preference_stored_state";

    /* renamed from: a */
    private final OnBackPressedObservable.OnBackPressedObserver f5031a = new OnBackPressedObservable.OnBackPressedObserver() {
        public boolean onActivityBackPressed() {
            int currentItem = FormFinderFragment.this.getViewPager().getCurrentItem();
            switch (currentItem) {
                case 0:
                    return false;
                default:
                    FormFinderFragment.this.getViewPager().setCurrentItem(currentItem - 1);
                    return true;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1552a f5032b = new C1552a();

    /* renamed from: c */
    private final DataSetObserver f5033c = new DataSetObserver() {
        public void onChanged() {
            Folder a;
            super.onChanged();
            TreeAdapter pagerAdapter = FormFinderFragment.this.getPagerAdapter();
            if (pagerAdapter != null) {
                ArrayList arrayList = new ArrayList();
                Root loadRoot = ((App) FormFinderFragment.this.getActivity().getApplication()).loadRoot(true);
                Iterator it = pagerAdapter.getPath().iterator();
                while (it.hasNext() && (a = m6072a(loadRoot, ((Folder) it.next()).getServerId())) != null) {
                    arrayList.add(a);
                }
                pagerAdapter.getPath().setContent(arrayList);
            }
            FormFinderFragment.this.getContainer().finishProgress();
        }

        /* renamed from: a */
        private Folder m6072a(Folder folder, long j) {
            if (folder.getServerId() == j) {
                return folder;
            }
            if (folder.hasChildren()) {
                for (Folder a : folder.getChildren()) {
                    Folder a2 = m6072a(a, j);
                    if (a2 != null) {
                        return a2;
                    }
                }
            }
            return null;
        }
    };

    /* renamed from: d */
    private FormActionListener f5034d;

    /* renamed from: e */
    private ViewPager f5035e;

    /* renamed from: f */
    private TreeAdapter f5036f;

    /* renamed from: g */
    private Company f5037g;

    /* renamed from: h */
    private Long f5038h;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment$FormActionListener */
    public interface FormActionListener {
        void onFormClick(Company company, FormRef formRef);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment$FormFinderActivity */
    public interface FormFinderActivity {
        void finishProgress();

        void showProgress(MenuItem menuItem, boolean z);
    }

    public FormFinderActivity getContainer() {
        return (FormFinderActivity) getActivity();
    }

    public FormActionListener getOnFormClickListener() {
        return this.f5034d;
    }

    public TreeAdapter getPagerAdapter() {
        return this.f5036f;
    }

    public Company getSelectedCompany() {
        if (this.f5037g == null && this.f5038h != null) {
            Iterator it = new ArrayList(m6071l().getRoot().getAllCompanies()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Company company = (Company) it.next();
                if (company.getServerId() == this.f5038h.longValue()) {
                    this.f5037g = company;
                    break;
                }
            }
        }
        return this.f5037g;
    }

    public ViewPager getViewPager() {
        if (this.f5035e == null) {
            Drawable drawable = getResources().getDrawable(C1352R.C1353drawable.drawer_shadow);
            this.f5035e = new FixedViewPager(getActivity());
            this.f5035e.setId(544);
            this.f5035e.setPageMarginDrawable(drawable);
            this.f5035e.setPageMargin(drawable.getIntrinsicWidth());
            this.f5035e.setPageTransformer(true, new ViewPager.PageTransformer() {
                public void transformPage(View view, float f) {
                    if (f >= 1.0f) {
                        view.setTranslationX(((float) view.getWidth()) * f);
                        view.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    } else if (f >= BitmapDescriptorFactory.HUE_RED && f < 1.0f) {
                        view.setTranslationX(-0.5f * ((float) view.getWidth()) * f);
                        view.setAlpha(1.0f - f);
                    }
                }
            });
        }
        return this.f5035e;
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("selected_company_server_id")) {
            this.f5038h = Long.valueOf(bundle.getLong("selected_company_server_id"));
        }
        ((MainActivity) getActivity()).registerOnBackPressedObserver(this.f5031a);
        if (bundle != null || m6071l().getRoot() == null) {
            this.f5036f = new TreeAdapter();
        } else {
            this.f5036f = new TreeAdapter(m6071l().getRoot());
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.form_finder_options, menu);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return getViewPager();
    }

    public void onDestroyView() {
        ((App) getActivity().getApplication()).unregisterDataSetObserver(this.f5033c);
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        FragmentActivity activity = getActivity();
        if (menuItem.getItemId() != C1352R.C1354id.downloadStructure) {
            return super.onOptionsItemSelected(menuItem);
        }
        App app = (App) activity.getApplication();
        CheckService.Intents intents = CheckService.getIntents();
        Context applicationContext = activity.getApplicationContext();
        activity.startService(intents.downloadStructure(applicationContext));
        activity.startService(intents.downloadTasks(applicationContext));
        getContainer().showProgress(menuItem, false);
        Toast.makeText(activity, "Het downloaden gebeurt op de achtergrond. U kunt ondertussen doorwerken.", 1).show();
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f5038h != null) {
            bundle.putLong("selected_company_server_id", this.f5038h.longValue());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getViewPager().setAdapter(getPagerAdapter());
        ((App) getActivity().getApplication()).registerDataSetObserver(this.f5033c);
        getActivity().setProgressBarIndeterminateVisibility(false);
        if (bundle == null) {
            getViewPager().setCurrentItem(getPagerAdapter().getCount() - 1, true);
        }
    }

    public void setOnFormClickListener(FormActionListener formActionListener) {
        this.f5034d = formActionListener;
    }

    public void setSelectedCompany(Company company) {
        this.f5038h = Long.valueOf(company.getServerId());
        this.f5037g = company;
    }

    /* renamed from: l */
    private App m6071l() {
        return (App) getActivity().getApplication();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment$TreeAdapter */
    public class TreeAdapter extends ViewTreeAdapter<Folder> {
        public TreeAdapter() {
        }

        public TreeAdapter(List<Folder> list) {
            getPath().setContent(list);
        }

        public TreeAdapter(Root root) {
            if (root != null) {
                getPath().setRoot(root);
            }
        }

        public void destroyItem(ViewGroup viewGroup, int i, View view) {
            FoldersView foldersView = (FoldersView) view;
            unregisterDataSetObserver(foldersView.f5023a);
            foldersView.setOnItemClickListener((AdapterView.OnItemClickListener) null);
        }

        public float getPageWidth(int i) {
            return 1.0f;
        }

        public View instantiateItem(ViewGroup viewGroup, Folder folder, int i) {
            FoldersView foldersView = new FoldersView(FormFinderFragment.this, i);
            registerDataSetObserver(foldersView.f5023a);
            foldersView.setId(i + 1);
            foldersView.setOnItemClickListener(FormFinderFragment.this.f5032b);
            return foldersView;
        }

        public Collection<Folder> restorePath(Bundle bundle) {
            boolean z;
            App app = (App) FormFinderFragment.this.getActivity().getApplication();
            TreeMap treeMap = new TreeMap();
            ArrayList arrayList = new ArrayList();
            for (String str : bundle.keySet()) {
                treeMap.put(Integer.valueOf(Integer.parseInt(str)), Long.valueOf(bundle.getLong(str)));
            }
            if (treeMap.isEmpty()) {
                arrayList.add(app.getRoot());
            } else {
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (((Integer) entry.getKey()).intValue() == 0) {
                        arrayList.add(app.getRoot());
                    } else {
                        Iterator<Folder> it = ((Folder) arrayList.get(((Integer) entry.getKey()).intValue() - 1)).getChildren().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            Folder next = it.next();
                            if (next.getServerId() == ((Long) entry.getValue()).longValue()) {
                                arrayList.add(next);
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            break;
                        }
                    }
                }
            }
            return arrayList;
        }

        public void savePath(Bundle bundle, Path<Folder> path) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < path.size()) {
                    bundle.putLong(Integer.valueOf(i2).toString(), path.get(i2).getServerId());
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: protected */
        public boolean refreshPage(View view, Folder folder) {
            return false;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment$a */
    class C1552a implements AdapterView.OnItemClickListener {
        private C1552a() {
        }

        /* JADX WARNING: type inference failed for: r6v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onItemClick(android.widget.AdapterView<?> r6, android.view.View r7, int r8, long r9) {
            /*
                r5 = this;
                android.widget.Adapter r0 = r6.getAdapter()
                java.lang.Object r0 = r0.getItem(r8)
                nl.volkerinfradesign.checkandroid.data.tree.Folder r0 = (p006nl.volkerinfradesign.checkandroid.data.tree.Folder) r0
                boolean r1 = r0 instanceof p006nl.volkerinfradesign.checkandroid.data.tree.Company
                if (r1 == 0) goto L_0x0045
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment r2 = p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.this
                r1 = r0
                nl.volkerinfradesign.checkandroid.data.tree.Company r1 = (p006nl.volkerinfradesign.checkandroid.data.tree.Company) r1
                r2.setSelectedCompany(r1)
            L_0x0016:
                boolean r1 = r0.hasChildren()
                if (r1 == 0) goto L_0x0044
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment r1 = p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.this
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment$TreeAdapter r1 = r1.getPagerAdapter()
                nl.volkerinfradesign.checkandroid.ui.widgets.treepager.Path r1 = r1.getPath()
                nl.volkerinfradesign.checkandroid.ui.widgets.treepager.TreeItem r6 = (p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager.TreeItem) r6
                int r2 = r6.getPagePostion()
                r1.append((int) r2, r0)
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment r0 = p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.this
                android.support.v4.view.ViewPager r0 = r0.getViewPager()
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment r1 = p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.this
                android.support.v4.view.ViewPager r1 = r1.getViewPager()
                int r1 = r1.getCurrentItem()
                int r1 = r1 + 1
                r0.setCurrentItem(r1)
            L_0x0044:
                return
            L_0x0045:
                boolean r1 = r0 instanceof p006nl.volkerinfradesign.checkandroid.data.tree.Hyperlink
                if (r1 == 0) goto L_0x006c
                r1 = r0
                nl.volkerinfradesign.checkandroid.data.tree.Hyperlink r1 = (p006nl.volkerinfradesign.checkandroid.data.tree.Hyperlink) r1
                java.lang.String r1 = r1.getHyperlink()
                android.content.Intent r2 = new android.content.Intent
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment r3 = p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.this
                android.support.v4.app.FragmentActivity r3 = r3.getActivity()
                java.lang.Class<nl.volkerinfradesign.checkandroid.ui.browser.BrowserActivity> r4 = p006nl.volkerinfradesign.checkandroid.p007ui.browser.BrowserActivity.class
                r2.<init>(r3, r4)
                java.lang.String r3 = "url"
                r2.putExtra(r3, r1)
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment r1 = p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.this
                android.support.v4.app.FragmentActivity r1 = r1.getActivity()
                r1.startActivity(r2)
                goto L_0x0016
            L_0x006c:
                boolean r1 = r0 instanceof p006nl.volkerinfradesign.checkandroid.data.tree.FormRef
                if (r1 == 0) goto L_0x0016
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment r1 = p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.this
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment$FormActionListener r1 = r1.getOnFormClickListener()
                nl.volkerinfradesign.checkandroid.ui.formFinder.FoldersView r6 = (p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FoldersView) r6
                r2 = 0
                r6.setItemChecked(r8, r2)
                if (r1 == 0) goto L_0x0044
                nl.volkerinfradesign.checkandroid.ui.formFinder.FormFinderFragment r2 = p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.this
                nl.volkerinfradesign.checkandroid.data.tree.Company r2 = r2.getSelectedCompany()
                nl.volkerinfradesign.checkandroid.data.tree.FormRef r0 = (p006nl.volkerinfradesign.checkandroid.data.tree.FormRef) r0
                r1.onFormClick(r2, r0)
                goto L_0x0044
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment.C1552a.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
        }
    }
}
