package p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.treepager.ViewTreeAdapter */
public abstract class ViewTreeAdapter<T> extends PagerAdapter implements C1294iu<T> {

    /* renamed from: a */
    private final C1288it<T> f5658a = new C1288it<>(this);

    /* renamed from: b */
    private final SparseArray<View> f5659b = new SparseArray<>();

    /* renamed from: c */
    private final SparseArray<SparseArray<Parcelable>> f5660c = new SparseArray<>();

    public abstract void destroyItem(ViewGroup viewGroup, int i, View view);

    public abstract View instantiateItem(ViewGroup viewGroup, T t, int i);

    public abstract boolean refreshPage(View view, T t);

    public abstract Collection<T> restorePath(Bundle bundle);

    public abstract void savePath(Bundle bundle, Path<T> path);

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        SparseArray sparseArray = new SparseArray();
        view.saveHierarchyState(sparseArray);
        this.f5660c.put(i, sparseArray);
        this.f5659b.remove(i);
        viewGroup.removeView(view);
        destroyItem(viewGroup, i, view);
    }

    public int getCount() {
        return this.f5658a.size();
    }

    public int getItemPosition(Object obj) {
        int pagePostion = ((TreeItem) obj).getPagePostion();
        if (!(this.f5658a.size() > pagePostion && pagePostion >= 0)) {
            return -2;
        }
        return refreshPage((View) obj, this.f5658a.get(pagePostion)) ? -2 : -1;
    }

    public Path<T> getPath() {
        return this.f5658a;
    }

    public final View instantiateItem(ViewGroup viewGroup, int i) {
        View instantiateItem = instantiateItem(viewGroup, getPath().get(i), i);
        SparseArray sparseArray = this.f5660c.get(i);
        if (sparseArray != null) {
            instantiateItem.restoreHierarchyState(sparseArray);
        }
        this.f5659b.put(i, instantiateItem);
        viewGroup.addView(instantiateItem);
        return instantiateItem;
    }

    public boolean isNotifyOnChange() {
        return this.f5658a.mo8650a();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Bundle bundle = (Bundle) parcelable;
        Bundle bundle2 = bundle.getBundle("treepager:saved_view_states");
        Collection restorePath = restorePath(bundle.getBundle("treepager:saved_path"));
        for (String str : bundle2.keySet()) {
            this.f5660c.put(Integer.parseInt(str), bundle2.getSparseParcelableArray(str));
        }
        if (restorePath != null) {
            this.f5658a.addAll(restorePath);
        }
        super.restoreState(bundle.getParcelable("treepager:saved_instance_state"), classLoader);
    }

    public final Parcelable saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        savePath(bundle2, this.f5658a);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getPath().size()) {
                SparseArray sparseArray = this.f5660c.get(i2);
                if (sparseArray == null) {
                    SparseArray sparseArray2 = new SparseArray();
                    if (this.f5659b.get(i2) != null) {
                        this.f5659b.get(i2).saveHierarchyState(sparseArray2);
                    }
                    sparseArray = sparseArray2;
                }
                bundle3.putSparseParcelableArray(Integer.toString(i2), sparseArray);
                i = i2 + 1;
            } else {
                bundle.putParcelable("treepager:saved_instance_state", super.saveState());
                bundle.putBundle("treepager:saved_view_states", bundle3);
                bundle.putBundle("treepager:saved_path", bundle2);
                return bundle;
            }
        }
    }

    public void setNotifyOnChange(boolean z) {
        this.f5658a.mo8649a(z);
    }
}
