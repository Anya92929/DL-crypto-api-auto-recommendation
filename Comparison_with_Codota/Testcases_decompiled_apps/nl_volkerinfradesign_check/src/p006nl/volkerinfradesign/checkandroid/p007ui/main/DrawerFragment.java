package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.p007ui.help.HelpActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.AccountActivity;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.DrawerFragment */
public class DrawerFragment extends Fragment implements View.OnClickListener, DrawerObserver {

    /* renamed from: a */
    private View f5403a;

    /* renamed from: aj */
    private DrawerFragmentParent f5404aj;

    /* renamed from: b */
    private View f5405b;

    /* renamed from: c */
    private View f5406c;

    /* renamed from: d */
    private View f5407d;

    /* renamed from: e */
    private TextView f5408e;

    /* renamed from: f */
    private TextView f5409f;

    /* renamed from: g */
    private TextView f5410g;

    /* renamed from: h */
    private TextView f5411h;

    /* renamed from: i */
    private DrawerItem f5412i;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.DrawerFragment$DrawerFragmentParent */
    public interface DrawerFragmentParent {
        void onDrawerItemClicked(DrawerItem drawerItem);

        void onLogoutClicked();

        void setDrawerObserver(DrawerObserver drawerObserver);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("selected")) {
            this.f5412i = DrawerItem.valueOf(bundle.getString("selected"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.drawer_content, viewGroup, false);
        this.f5403a = inflate.findViewById(C1352R.C1354id.newForm);
        this.f5405b = inflate.findViewById(C1352R.C1354id.openForms);
        this.f5406c = inflate.findViewById(C1352R.C1354id.sentForms);
        this.f5407d = inflate.findViewById(C1352R.C1354id.tasks);
        this.f5408e = (TextView) inflate.findViewById(C1352R.C1354id.user);
        this.f5409f = (TextView) inflate.findViewById(C1352R.C1354id.logout);
        this.f5410g = (TextView) inflate.findViewById(C1352R.C1354id.help);
        this.f5411h = (TextView) inflate.findViewById(C1352R.C1354id.footer);
        this.f5403a.setTag(DrawerItem.B_NEW_FORM);
        this.f5405b.setTag(DrawerItem.C_OPEN_FORMS);
        this.f5406c.setTag(DrawerItem.D_FINISHED_FORMS);
        this.f5407d.setTag(DrawerItem.E_TODOS);
        this.f5403a.setOnClickListener(this);
        this.f5405b.setOnClickListener(this);
        this.f5406c.setOnClickListener(this);
        this.f5407d.setOnClickListener(this);
        this.f5408e.setOnClickListener(this);
        this.f5409f.setOnClickListener(this);
        this.f5410g.setOnClickListener(this);
        try {
            this.f5411h.setText("versie: " + m6295l().getPackageManager().getPackageInfo(m6295l().getPackageName(), 0).versionName);
        } catch (Exception e) {
            this.f5411h.setText((CharSequence) null);
        }
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m6296m();
        m6297n().setDrawerObserver(this);
        notifyDataSetChanged();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f5412i != null) {
            bundle.putString("selected", this.f5412i.name());
        }
    }

    public void onDestroyView() {
        m6297n().setDrawerObserver((DrawerObserver) null);
        super.onDestroyView();
    }

    /* renamed from: l */
    private App m6295l() {
        return (App) getActivity().getApplication();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C1352R.C1354id.newForm) {
            setCheckedDrawerItem(DrawerItem.B_NEW_FORM);
            m6297n().onDrawerItemClicked(DrawerItem.B_NEW_FORM);
        } else if (id == C1352R.C1354id.openForms) {
            setCheckedDrawerItem(DrawerItem.C_OPEN_FORMS);
            m6297n().onDrawerItemClicked(DrawerItem.C_OPEN_FORMS);
        } else if (id == C1352R.C1354id.sentForms) {
            setCheckedDrawerItem(DrawerItem.D_FINISHED_FORMS);
            m6297n().onDrawerItemClicked(DrawerItem.D_FINISHED_FORMS);
        } else if (id == C1352R.C1354id.tasks) {
            setCheckedDrawerItem(DrawerItem.E_TODOS);
            m6297n().onDrawerItemClicked(DrawerItem.E_TODOS);
        } else if (id == C1352R.C1354id.user) {
            getActivity().startActivity(new Intent(getActivity(), AccountActivity.class));
        } else if (id == C1352R.C1354id.logout) {
            m6297n().onLogoutClicked();
        } else if (id == C1352R.C1354id.help) {
            getActivity().startActivity(new Intent(getActivity(), HelpActivity.class));
        }
    }

    public void setCheckedDrawerItem(DrawerItem drawerItem) {
        this.f5412i = drawerItem;
        m6296m();
    }

    public DrawerItem getCheckedDrawerItem() {
        return this.f5412i;
    }

    public void notifyDataSetChanged() {
        int i;
        for (Pair pair : new Pair[]{new Pair((TextView) this.f5405b.findViewById(16908304), Integer.valueOf(Schema.getInspectionData().getOpenCount(false))), new Pair((TextView) this.f5406c.findViewById(16908304), Integer.valueOf(Schema.getInspectionData().getPendingCount(false))), new Pair((TextView) this.f5407d.findViewById(16908304), Integer.valueOf(m6295l().getModel().getTasks().getCount()))}) {
            TextView textView = (TextView) pair.first;
            int intValue = ((Integer) pair.second).intValue();
            textView.setText(Integer.toString(intValue));
            if (intValue > 0) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    /* renamed from: m */
    private void m6296m() {
        boolean z;
        for (View view : new View[]{this.f5403a, this.f5405b, this.f5406c, this.f5407d}) {
            DrawerItem drawerItem = (DrawerItem) view.getTag();
            if (drawerItem == null || drawerItem != this.f5412i) {
                z = false;
            } else {
                z = true;
            }
            view.setActivated(z);
        }
    }

    /* renamed from: n */
    private DrawerFragmentParent m6297n() {
        if (this.f5404aj == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null) {
                parentFragment = getActivity();
            }
            this.f5404aj = (DrawerFragmentParent) parentFragment;
        }
        return this.f5404aj;
    }
}
