package com.jackhenry.godough.core.accounts;

import android.os.Bundle;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.accounts.p033a.C1419a;
import com.jackhenry.godough.core.model.Account;
import java.util.Locale;

public class AccountsFragment extends C1802r implements C1469x {

    /* renamed from: a */
    RelativeLayout f5829a;

    /* renamed from: b */
    private ItemTouchHelper f5830b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1465t f5831c;

    /* renamed from: d */
    private boolean f5832d = true;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9553a(View view) {
        if (getView() != null) {
            view = getView();
        }
        view.findViewById(C1494ai.progress_bar).setVisibility(0);
        C1430j jVar = new C1430j(this, this, new C1428h(this));
        if (getActivity().getSupportLoaderManager().getLoader(0) == null) {
            getActivity().getSupportLoaderManager().initLoader(0, (Bundle) null, jVar);
        } else {
            getActivity().getSupportLoaderManager().restartLoader(0, (Bundle) null, jVar);
        }
    }

    public void onClick(int i) {
        Account b = this.f5831c.mo9667b(i);
        if (b.getAccountType().toUpperCase(Locale.US).equals("OTHER")) {
            ((AbstractActivity) getActivity()).showDialog(getString(C1506am.account_no_transactions_title), getString(C1506am.account_no_transactions));
        } else {
            ((C1431k) getActivity()).onAccountSelected(b);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5831c = new C1465t(getActivity(), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5829a = (RelativeLayout) layoutInflater.inflate(C1496ak.accounts_fragment, viewGroup);
        setHasOptionsMenu(true);
        return this.f5829a;
    }

    public void onDragStart(RecyclerView.ViewHolder viewHolder) {
        this.f5830b.startDrag(viewHolder);
    }

    public void onEditModeStart() {
        getActivity().invalidateOptionsMenu();
        Toast.makeText(getActivity(), "Press DONE to stop reordering", 1).show();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C1494ai.menu_done) {
            return false;
        }
        this.f5831c.mo9668b();
        getActivity().invalidateOptionsMenu();
        return true;
    }

    public void onPause() {
        super.onPause();
        this.f5832d = true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(C1494ai.menu_done).setVisible(this.f5831c.mo9669c());
        menu.findItem(C1494ai.menu_logout).setVisible(!this.f5831c.mo9669c());
    }

    public void onResume() {
        super.onResume();
        if (this.f5832d) {
            mo9553a(getView());
            this.f5832d = false;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) this.f5829a.findViewById(C1494ai.account_recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(this.f5831c);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mo9553a((View) this.f5829a);
        this.f5832d = false;
        this.f5830b = new ItemTouchHelper(new C1419a(this.f5831c));
        this.f5830b.attachToRecyclerView(recyclerView);
    }
}
