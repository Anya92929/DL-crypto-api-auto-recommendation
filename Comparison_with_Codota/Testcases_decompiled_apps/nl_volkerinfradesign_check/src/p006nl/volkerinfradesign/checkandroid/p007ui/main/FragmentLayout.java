package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.ListFragment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;
import java.util.Map;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspections.ClosedFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspections.OpenFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.tasks.TasksFragment;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.FragmentLayout */
public class FragmentLayout extends FrameLayout {

    /* renamed from: a */
    private MainActivity f5432a;

    /* renamed from: b */
    private final HashMap<String, Fragment.SavedState> f5433b = new HashMap<>();

    public FragmentLayout(Context context) {
        super(context);
        m6307a(context);
    }

    public FragmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6307a(context);
    }

    public FragmentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6307a(context);
    }

    public MainActivity getActivity() {
        return this.f5432a;
    }

    public Fragment switchFragment(DrawerItem drawerItem) {
        String name = drawerItem.name();
        FragmentManager supportFragmentManager = this.f5432a.getSupportFragmentManager();
        Fragment findFragmentById = supportFragmentManager.findFragmentById(getId());
        if (findFragmentById != null && findFragmentById.getTag().equals(name)) {
            return findFragmentById;
        }
        try {
            Fragment a = m6306a(drawerItem);
            if (findFragmentById != null) {
                this.f5433b.put(findFragmentById.getTag(), supportFragmentManager.saveFragmentInstanceState(findFragmentById));
            }
            a.setInitialSavedState(this.f5433b.get(name));
            supportFragmentManager.beginTransaction().replace(getId(), a, name).commit();
            return a;
        } catch (BadParcelableException e) {
            Fragment a2 = m6306a(drawerItem);
            supportFragmentManager.beginTransaction().replace(getId(), a2, name).commit();
            return a2;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("fragment_layout:layout_state"));
        bundle.remove("fragment_layout:layout_state");
        for (String str : bundle.keySet()) {
            this.f5433b.put(str, (Fragment.SavedState) bundle.getParcelable(str));
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("fragment_layout:layout_state", super.onSaveInstanceState());
        for (Map.Entry next : this.f5433b.entrySet()) {
            bundle.putParcelable((String) next.getKey(), (Parcelable) next.getValue());
        }
        return bundle;
    }

    /* renamed from: a */
    private Fragment m6306a(DrawerItem drawerItem) {
        switch (drawerItem) {
            case B_NEW_FORM:
                return new FormFinderFragment();
            case D_FINISHED_FORMS:
                return new ClosedFragment();
            case C_OPEN_FORMS:
                return new OpenFragment();
            case E_TODOS:
                return new TasksFragment();
            default:
                return new EmptyFragment();
        }
    }

    /* renamed from: a */
    private void m6307a(Context context) {
        this.f5432a = (MainActivity) context;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.FragmentLayout$EmptyFragment */
    public static class EmptyFragment extends ListFragment {
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            setEmptyText(getActivity().getString(C1352R.string.noContent));
        }
    }
}
