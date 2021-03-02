package com.jackhenry.godough.core.accounts;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.accounts.p033a.C1420b;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.AccountGroup;
import com.jackhenry.godough.core.model.AccountGroupList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.jackhenry.godough.core.accounts.t */
public class C1465t extends RecyclerView.Adapter<C1426f> implements C1420b {

    /* renamed from: a */
    C1427g f5925a = new C1466u(this);

    /* renamed from: b */
    private ArrayList<Account> f5926b = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1469x f5927c;

    /* renamed from: d */
    private Context f5928d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f5929e = false;

    public C1465t(Context context, C1469x xVar) {
        this.f5927c = xVar;
        this.f5928d = context;
    }

    /* renamed from: d */
    private void m5900d() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f5928d).edit();
        try {
            JSONArray jSONArray = new JSONArray("[]");
            Iterator<Account> it = this.f5926b.iterator();
            while (it.hasNext()) {
                Account next = it.next();
                jSONArray.put(next.getId() != null ? next.getId() : next.getAccountType());
            }
            edit.putString("accounts_order", jSONArray.toString());
            edit.commit();
        } catch (JSONException e) {
        }
    }

    /* renamed from: e */
    private JSONArray m5901e() {
        try {
            return new JSONArray(PreferenceManager.getDefaultSharedPreferences(this.f5928d).getString("accounts_order", "[]"));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: f */
    private HashMap m5902f() {
        HashMap hashMap = new HashMap();
        JSONArray e = m5901e();
        for (int i = 0; i < e.length(); i++) {
            try {
                hashMap.put(e.get(i).toString(), Integer.valueOf(i));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public C1426f onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate;
        switch (i) {
            case 0:
                inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1496ak.list_item_account_header, viewGroup, false);
                break;
            default:
                inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1496ak.list_item_account, viewGroup, false);
                break;
        }
        return new C1426f(inflate, i, this.f5925a);
    }

    /* renamed from: a */
    public void mo9663a() {
        this.f5926b.clear();
    }

    /* renamed from: a */
    public void onBindViewHolder(C1426f fVar, int i) {
        boolean z = false;
        Account b = mo9667b(i);
        if (!mo9666a(i)) {
            fVar.f5854k.setText(b.getName());
            fVar.f5855l.setVisibility(8);
            if (!this.f5929e) {
                fVar.f5857n.setVisibility(8);
                fVar.f5858o.setVisibility(0);
                if (b.isShowBalance()) {
                    String fiDefinedBalanceFormatted = b.getFiDefinedBalanceFormatted();
                    fVar.f5856m.setText(fiDefinedBalanceFormatted);
                    fVar.f5856m.setVisibility(0);
                    if (fiDefinedBalanceFormatted.contains("(") || b.getAccountType().toLowerCase(Locale.US).trim().equals("loan")) {
                        fVar.f5856m.setTextColor(ContextCompat.getColor(this.f5928d, C1491af.black70));
                    } else {
                        fVar.f5856m.setTextColor(ContextCompat.getColor(this.f5928d, C1491af.green));
                    }
                } else {
                    fVar.f5856m.setVisibility(8);
                }
            } else {
                fVar.f5856m.setVisibility(8);
                fVar.f5858o.setVisibility(8);
                fVar.f5857n.setVisibility(0);
                fVar.f5857n.setOnTouchListener(new C1467v(this, fVar));
            }
            if (!this.f5929e) {
                z = mo9670d(i);
            }
            fVar.mo9571a(z);
            return;
        }
        fVar.f5859p.setText(b.getAccountType());
    }

    /* renamed from: a */
    public void mo9665a(AccountGroupList accountGroupList) {
        HashMap f = m5902f();
        for (AccountGroup next : accountGroupList.getAccountGroups()) {
            List<Account> accounts = next.getAccounts();
            Collections.sort(accounts, new C1468w(this, f));
            for (Account accountType : accounts) {
                accountType.setAccountType(next.getName());
            }
            Account account = new Account();
            account.setAccountType(next.getName());
            this.f5926b.add(account);
            this.f5926b.addAll(accounts);
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public boolean mo9666a(int i) {
        return mo9667b(i).getName() == null && mo9667b(i).getId() == null;
    }

    /* renamed from: a */
    public boolean mo9561a(int i, int i2) {
        if (!mo9667b(i).getAccountType().equals(mo9667b(i2).getAccountType())) {
            return false;
        }
        Collections.swap(this.f5926b, i, i2);
        notifyItemMoved(i, i2);
        m5900d();
        return true;
    }

    /* renamed from: b */
    public Account mo9667b(int i) {
        return this.f5926b.get(i);
    }

    /* renamed from: b */
    public void mo9668b() {
        this.f5929e = false;
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public void mo9562c(int i) {
        this.f5926b.remove(i);
        notifyItemRemoved(i);
    }

    /* renamed from: c */
    public boolean mo9669c() {
        return this.f5929e;
    }

    /* renamed from: d */
    public boolean mo9670d(int i) {
        return i == this.f5926b.size() + -1 || mo9666a(i + 1);
    }

    public int getItemCount() {
        return this.f5926b.size();
    }

    public int getItemViewType(int i) {
        return mo9666a(i) ? 0 : 1;
    }
}
