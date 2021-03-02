package com.jackhenry.godough.core.transfers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.TransferToAccount;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.transfers.t */
class C1915t extends ArrayAdapter<TransferToAccount> {

    /* renamed from: a */
    final /* synthetic */ TransfersFragment f6841a;

    /* renamed from: b */
    private LayoutInflater f6842b;

    /* renamed from: c */
    private int f6843c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1915t(TransfersFragment transfersFragment, Context context, int i, List<TransferToAccount> list, int i2) {
        super(context, i, list);
        this.f6841a = transfersFragment;
        this.f6842b = LayoutInflater.from(context);
        this.f6843c = i2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6842b.inflate(C1496ak.list_item_2_single_choice, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(C1494ai.text1);
        TextView textView2 = (TextView) view.findViewById(C1494ai.text2);
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(C1494ai.radiobutton1);
        Account account = ((TransferToAccount) getItem(i)).getAccount();
        checkedTextView.setChecked(i == this.f6843c);
        textView.setText(account.getName());
        if (account.isShowBalance()) {
            textView2.setText(getContext().getString(C1506am.balance_value, new Object[]{account.getFiDefinedBalanceFormatted()}));
            textView2.setVisibility(0);
        } else {
            textView2.setText("");
            textView2.setVisibility(8);
        }
        return view;
    }
}
