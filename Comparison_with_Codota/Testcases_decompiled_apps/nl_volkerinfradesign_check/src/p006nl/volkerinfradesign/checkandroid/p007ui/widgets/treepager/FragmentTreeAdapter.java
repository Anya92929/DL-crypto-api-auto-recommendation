package p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentStatePagerAdapter;
import java.util.Collection;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.treepager.FragmentTreeAdapter */
public abstract class FragmentTreeAdapter<T> extends FragmentStatePagerAdapter implements C1294iu<T> {

    /* renamed from: a */
    private final C1288it<T> f5657a = new C1288it<>(this);

    public abstract Fragment getItem(int i, T t);

    /* access modifiers changed from: protected */
    public abstract boolean refreshPage(Fragment fragment, T t);

    public abstract Collection<T> restorePath(Bundle bundle);

    public abstract void savePath(Bundle bundle, Path<T> path);

    public FragmentTreeAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public final int getCount() {
        return this.f5657a.size();
    }

    public final Fragment getItem(int i) {
        return getItem(i, this.f5657a.get(i));
    }

    public final int getItemPosition(Object obj) {
        int pagePostion = ((TreeItem) obj).getPagePostion();
        if (!(this.f5657a.size() > pagePostion && pagePostion >= 0)) {
            return -2;
        }
        return refreshPage((Fragment) obj, this.f5657a.get(pagePostion)) ? -2 : -1;
    }

    public Path<T> getPath() {
        return this.f5657a;
    }

    public boolean isNotifyOnChange() {
        return this.f5657a.mo8650a();
    }

    public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Bundle bundle = (Bundle) parcelable;
        Parcelable parcelable2 = bundle.getParcelable("treepager:saved_instance_state");
        this.f5657a.addAll(restorePath((Bundle) bundle.getParcelable("treepager:saved_path")));
        super.restoreState(parcelable2, classLoader);
    }

    public final Parcelable saveState() {
        Bundle bundle = new Bundle(2);
        Bundle bundle2 = new Bundle();
        savePath(bundle2, this.f5657a);
        bundle.putParcelable("treepager:saved_path", bundle2);
        bundle.putParcelable("treepager:saved_instance_state", super.saveState());
        return bundle;
    }

    public void setNotifyOnChange(boolean z) {
        this.f5657a.mo8649a(z);
    }
}
