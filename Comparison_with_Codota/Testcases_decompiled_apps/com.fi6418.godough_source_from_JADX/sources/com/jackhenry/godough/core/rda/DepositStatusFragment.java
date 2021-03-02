package com.jackhenry.godough.core.rda;

import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.DepositTransaction;
import com.jackhenry.godough.core.p038e.C1582k;
import com.jackhenry.godough.core.p038e.C1586o;
import com.jackhenry.godough.core.widgets.ActionButton;

public class DepositStatusFragment extends C1802r implements View.OnClickListener {
    public static final String PARAM_DEPOSIT_TRANSACTION = "depositTransaction";

    /* renamed from: a */
    DepositTransaction f6637a;

    /* renamed from: b */
    private ActionButton f6638b;

    public void onClick(View view) {
        ((C1877t) getActivity()).onViewCheck(this.f6637a);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f6637a = (DepositTransaction) getActivity().getIntent().getSerializableExtra("depositTransaction");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.deposit_status_fragment, viewGroup);
        this.f6638b = (ActionButton) inflate.findViewById(C1494ai.btn_view_check);
        this.f6638b.setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(C1494ai.header);
        TableLayout tableLayout = (TableLayout) inflate.findViewById(C1494ai.table);
        textView.setText(getString(C1506am.lbl_check_deposit));
        C1586o.m6198a((LayerDrawable) textView.getBackground());
        C1582k.m6160a(C1506am.lbl_transid, this.f6637a.getTransactionId(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_deposit_to_account, this.f6637a.getAccountNickname(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_date, this.f6637a.getSubmittedDateFormatted(), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_check_amount, C1364k.m5586a((double) this.f6637a.getEnteredAmount()), tableLayout, layoutInflater);
        C1582k.m6160a(C1506am.lbl_status, this.f6637a.getDetailedStatus(), tableLayout, layoutInflater);
        return inflate;
    }
}
