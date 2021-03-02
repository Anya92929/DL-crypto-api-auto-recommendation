package p006nl.volkerinfradesign.checkandroid.p007ui.formFinder;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.List;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.Folder;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormRef;
import p006nl.volkerinfradesign.checkandroid.data.tree.Hyperlink;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager.Path;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager.TreeItem;

@SuppressLint({"ViewConstructor"})
/* renamed from: nl.volkerinfradesign.checkandroid.ui.formFinder.FoldersView */
public class FoldersView extends ListView implements TreeItem {

    /* renamed from: a */
    final DataSetObserver f5023a = new DataSetObserver() {
        public void onChanged() {
            super.onChanged();
            if (FoldersView.this.getAdapter() != null) {
                FoldersView.this.getAdapter().notifyDataSetChanged();
            }
        }

        public void onInvalidated() {
            super.onInvalidated();
            if (FoldersView.this.getAdapter() != null) {
                FoldersView.this.getAdapter().notifyDataSetInvalidated();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final FormFinderFragment f5024b;

    /* renamed from: c */
    private boolean f5025c = false;

    /* renamed from: d */
    private final int f5026d;

    FoldersView(FormFinderFragment formFinderFragment, int i) {
        super(formFinderFragment.getActivity());
        this.f5024b = formFinderFragment;
        this.f5026d = i;
        setChoiceMode(1);
        setBackgroundColor(getResources().getColor(C1352R.color.vw_bg_gray));
        setAdapter((ListAdapter) new FoldersAdapter());
        this.f5025c = true;
    }

    public FoldersAdapter getAdapter() {
        ListAdapter adapter = super.getAdapter();
        if (adapter instanceof WrapperListAdapter) {
            return (FoldersAdapter) ((WrapperListAdapter) adapter).getWrappedAdapter();
        }
        return (FoldersAdapter) adapter;
    }

    public int getPagePostion() {
        return this.f5026d;
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.f5025c) {
            throw new IllegalStateException();
        }
        super.setAdapter(listAdapter);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.formFinder.FoldersView$FoldersAdapter */
    public class FoldersAdapter extends BaseAdapter {

        /* renamed from: b */
        private final List<Object> f5029b;

        /* renamed from: c */
        private final int f5030c;

        private FoldersAdapter() {
            this.f5029b = new ArrayList();
            m6068a();
            TypedArray obtainStyledAttributes = FoldersView.this.getContext().obtainStyledAttributes(new int[]{C1352R.attr.activatedBackgroundIndicator});
            this.f5030c = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public int getCount() {
            return this.f5029b.size();
        }

        public Object getItem(int i) {
            return this.f5029b.get(i);
        }

        public long getItemId(int i) {
            if (m6069a(i)) {
                return -1;
            }
            if (getItem(i) instanceof Folder) {
                return ((Folder) getItem(i)).getServerId();
            }
            return (long) i;
        }

        public int getItemViewType(int i) {
            if (m6069a(i)) {
                return -1;
            }
            Object item = getItem(i);
            if (item instanceof Hyperlink) {
                return 1;
            }
            if (item instanceof Company) {
                return 2;
            }
            if (item instanceof FormRef) {
                return 4;
            }
            if (item instanceof Folder) {
                return 3;
            }
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                switch (itemViewType) {
                    case 1:
                        view2 = View.inflate(FoldersView.this.getContext(), C1352R.layout.structure_hyperlink, (ViewGroup) null);
                        break;
                    case 2:
                        view2 = View.inflate(FoldersView.this.getContext(), C1352R.layout.structure_company, (ViewGroup) null);
                        break;
                    case 3:
                        view2 = View.inflate(FoldersView.this.getContext(), C1352R.layout.structure_folder, (ViewGroup) null);
                        break;
                    case 4:
                        view2 = View.inflate(FoldersView.this.getContext(), C1352R.layout.structure_form_ref, (ViewGroup) null);
                        break;
                    default:
                        view2 = View.inflate(FoldersView.this.getContext(), C1352R.layout.category, (ViewGroup) null);
                        break;
                }
            } else {
                view2 = view;
            }
            if (itemViewType == 0) {
                ((TextView) view2).setText((CharSequence) getItem(i));
            } else {
                Folder folder = (Folder) getItem(i);
                ((TextView) view2.findViewById(16908308)).setText(folder.getTitle());
                ((TextView) view2.findViewById(16908309)).setText(folder.getDescription());
                if (itemViewType == 3) {
                    if (!folder.hasChildren()) {
                        view2.setBackgroundColor(FoldersView.this.getResources().getColor(17170432));
                    } else {
                        view2.setBackgroundResource(this.f5030c);
                    }
                }
            }
            return view2;
        }

        public int getViewTypeCount() {
            return 5;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isEnabled(int i) {
            if (m6069a(i)) {
                return false;
            }
            Object item = getItem(i);
            return (item instanceof FormRef) || (item instanceof Hyperlink) || ((item instanceof Folder) && ((Folder) item).hasChildren());
        }

        public void notifyDataSetChanged() {
            if (m6068a()) {
                super.notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

        public void notifyDataSetInvalidated() {
            this.f5029b.clear();
            super.notifyDataSetInvalidated();
        }

        /* renamed from: a */
        private boolean m6068a() {
            Path path = FoldersView.this.f5024b.getPagerAdapter().getPath();
            this.f5029b.clear();
            if (path.size() <= FoldersView.this.getPagePostion()) {
                return false;
            }
            Folder folder = (Folder) FoldersView.this.f5024b.getPagerAdapter().getPath().get(FoldersView.this.getPagePostion());
            if (folder != null) {
                if (folder.hasHyperlinks()) {
                    this.f5029b.add("referenties");
                    this.f5029b.addAll(folder.getHyperlinks());
                }
                if (folder.hasCompanies()) {
                    this.f5029b.add("bedrijven");
                    this.f5029b.addAll(folder.getCompanies());
                }
                if (folder.hasFolders()) {
                    this.f5029b.add("folders");
                    this.f5029b.addAll(folder.getFolders());
                }
                if (folder.hasForms()) {
                    this.f5029b.add("formulieren");
                    this.f5029b.addAll(folder.getForms());
                }
            }
            return true;
        }

        /* renamed from: a */
        private boolean m6069a(int i) {
            return i < 0 || i >= this.f5029b.size();
        }
    }
}
