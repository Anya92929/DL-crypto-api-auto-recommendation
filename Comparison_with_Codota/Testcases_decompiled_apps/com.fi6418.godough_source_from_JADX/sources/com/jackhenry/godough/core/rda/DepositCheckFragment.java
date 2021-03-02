package com.jackhenry.godough.core.rda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.android.widget.quickactionmenu.ActionItem;
import com.jackhenry.android.widget.quickactionmenu.QuickAction;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.Deposit;
import com.jackhenry.godough.core.model.DepositAccount;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.p038e.C1585n;
import com.jackhenry.godough.core.rda.imagecapture.CheckCaptureCameraActivity;
import com.jackhenry.godough.core.rda.registration.RDAVelocityFragmentActivity;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.DollarAmountEditText;
import java.io.File;
import java.util.List;

public class DepositCheckFragment extends C1802r implements View.OnClickListener, DollarAmountEditText.OnValueChanged {
    public static final int DIALOG_DEPOSIT_FAILED = 5019;
    public static final int DIALOG_DEPOSIT_SUCCESS = 5018;

    /* renamed from: a */
    private ActionButton f6615a;

    /* renamed from: aj */
    private TextView f6616aj;

    /* renamed from: ak */
    private ImageView f6617ak;

    /* renamed from: al */
    private View f6618al;

    /* renamed from: am */
    private RelativeLayout f6619am;

    /* renamed from: an */
    private Bitmap f6620an = null;

    /* renamed from: ao */
    private Bitmap f6621ao = null;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public int f6622ap = 1;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public List<DepositAccount> f6623aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public DepositAccount f6624ar;
    /* access modifiers changed from: private */

    /* renamed from: as */
    public C1810af f6625as;

    /* renamed from: b */
    private ActionButton f6626b;

    /* renamed from: c */
    private View f6627c;

    /* renamed from: d */
    private View f6628d;

    /* renamed from: e */
    private ImageView f6629e;

    /* renamed from: f */
    private ImageView f6630f;

    /* renamed from: g */
    private TextView f6631g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public DollarAmountEditText f6632h;

    /* renamed from: i */
    private TextView f6633i;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6674a(int i) {
        if (this.f6622ap == 0) {
            this.f6620an = C1809ae.m6713a(this.f6620an, i);
            this.f6629e.setImageBitmap(this.f6620an);
        } else if (this.f6622ap == 1) {
            this.f6621ao = C1809ae.m6713a(this.f6621ao, i);
            this.f6630f.setImageBitmap(this.f6621ao);
        }
    }

    /* renamed from: a */
    private void m6675a(View view) {
        int i = this.f6622ap + 1;
        if ((checkImagesExists(getActivity()) & i) != i) {
            m6679b(this.f6622ap);
            return;
        }
        ActionItem actionItem = new ActionItem(1, getString(C1506am.btn_action_retake_image), getResources().getDrawable(C1493ah.ic_action_camera));
        ActionItem actionItem2 = new ActionItem(2, getString(C1506am.btn_action_view_image), getResources().getDrawable(C1493ah.ic_action_view));
        ActionItem actionItem3 = new ActionItem(3, getString(C1506am.btn_action_rotate_left), getResources().getDrawable(C1493ah.ic_action_rotate_left));
        ActionItem actionItem4 = new ActionItem(4, getString(C1506am.btn_action_rotate_right), getResources().getDrawable(C1493ah.ic_action_rotate_right));
        QuickAction quickAction = new QuickAction(getActivity(), true);
        quickAction.addActionItem(actionItem);
        quickAction.addActionItem(actionItem2);
        quickAction.addActionItem(actionItem3);
        quickAction.addActionItem(actionItem4);
        quickAction.sendDismissNotification(-1);
        quickAction.setOnActionItemClickListener(new C1833j(this));
        quickAction.show(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6679b(int i) {
        Intent intent = new Intent(getActivity(), CheckCaptureCameraActivity.class);
        intent.putExtra("CHECK_FACE", i);
        startActivityForResult(intent, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6688n() {
        if (getResources().getConfiguration().hardKeyboardHidden == 2 && getResources().getConfiguration().keyboardHidden == 1 && getResources().getConfiguration().orientation == 2) {
            this.f6632h.setHint(this.f6632h.hasFocus() ? getString(C1506am.lbl_amount) : "");
        } else {
            this.f6632h.setHint(getString(C1506am.amount_hint));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6689o() {
        C1836m mVar = new C1836m(this, this, new C1817h(this));
        if (getActivity().getSupportLoaderManager().getLoader(0) == null) {
            getActivity().getSupportLoaderManager().initLoader(0, (Bundle) null, mVar);
        } else {
            getActivity().getSupportLoaderManager().restartLoader(0, (Bundle) null, mVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m6690p() {
        if (this.f6624ar == null) {
            this.f6631g.setText(getString(C1506am.tap_select));
            this.f6631g.setTextColor(getResources().getColor(C1491af.tapTextViewColor));
            return;
        }
        this.f6631g.setText(this.f6624ar.toString());
        this.f6631g.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* renamed from: q */
    private void m6691q() {
        this.f6629e.setImageResource(C1493ah.ic_camera);
        this.f6630f.setImageResource(C1493ah.ic_camera);
        if (this.f6620an != null) {
            this.f6620an = null;
        }
        if (this.f6621ao != null) {
            this.f6621ao = null;
        }
        new C1585n(GoDoughApp.getApp()).mo9814e((String) null);
        GoDoughApp.wipeRDACodes();
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m6692r() {
        ((C1840q) getActivity()).onFragmentNavigate(this.f6622ap == 0 ? C1839p.VIEW_FRONT : C1839p.VIEW_BACK);
    }

    /* renamed from: s */
    private synchronized void m6693s() {
        int i;
        m6694t();
        if (this.f6623aq != null && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), C1496ak.selection_dialog_list_item, this.f6623aq);
            arrayAdapter.setDropDownViewResource(C1496ak.selection_dialog_list_item);
            if (this.f6624ar != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f6623aq.size()) {
                        break;
                    } else if (this.f6623aq.get(i2).equals(this.f6624ar)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            i = -1;
            C1512c cVar = new C1512c();
            cVar.mo9713b(getString(C1506am.select_account));
            cVar.mo9712a(arrayAdapter, i, new C1834k(this));
            cVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* renamed from: t */
    private void m6694t() {
        if (this.f6619am != null) {
            this.f6619am.requestFocus();
        }
    }

    public int checkImagesExists(Context context) {
        int i = 0;
        int i2 = new File(new StringBuilder().append(context.getFilesDir()).append("/").append(C1805aa.m6703a(0)).toString()).exists() ? 1 : 0;
        if (new File(context.getFilesDir() + "/" + C1805aa.m6703a(1)).exists()) {
            i = 2;
        }
        return i2 + i;
    }

    public void depositAnother() {
        m6691q();
        this.f6624ar = null;
        this.f6632h.setText("");
        m6690p();
        m6694t();
        updateControls();
    }

    public long getCheckAmount() {
        return this.f6632h.getCents();
    }

    public DepositAccount getDepositAccount() {
        return this.f6624ar;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 || i == 1) {
            ((GodoughTransactionActivity) getActivity()).setResetFields(false);
            reloadThumbnails();
        }
    }

    public void onClick(View view) {
        if (view == this.f6615a.getButton()) {
            submitData();
        } else if (view == this.f6626b.getButton()) {
            ((C1840q) getActivity()).onFragmentNavigate(C1839p.FINISH);
        } else if (view == this.f6633i || view == this.f6629e || view == this.f6627c) {
            this.f6622ap = 0;
            m6675a((View) this.f6629e);
        } else if (view == this.f6616aj || view == this.f6630f || view == this.f6628d) {
            this.f6622ap = 1;
            m6675a((View) this.f6630f);
        } else if (view == this.f6618al) {
            m6693s();
        } else if (view == this.f6617ak) {
            startActivity(new Intent(getActivity(), RDAVelocityFragmentActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6620an = null;
        this.f6621ao = null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6619am = (RelativeLayout) layoutInflater.inflate(C1496ak.deposit_check_fragment, viewGroup);
        this.f6626b = (ActionButton) this.f6619am.findViewById(C1494ai.btn_cancel);
        this.f6615a = (ActionButton) this.f6619am.findViewById(C1494ai.btn_deposit);
        this.f6632h = (DollarAmountEditText) this.f6619am.findViewById(C1494ai.amount_edit);
        this.f6631g = (TextView) this.f6619am.findViewById(C1494ai.account);
        this.f6633i = (TextView) this.f6619am.findViewById(C1494ai.check_front);
        this.f6616aj = (TextView) this.f6619am.findViewById(C1494ai.check_back);
        this.f6617ak = (ImageView) this.f6619am.findViewById(C1494ai.info);
        this.f6627c = this.f6619am.findViewById(C1494ai.front_panel);
        this.f6628d = this.f6619am.findViewById(C1494ai.back_panel);
        this.f6629e = (ImageView) this.f6619am.findViewById(C1494ai.check_front_thumbnail);
        this.f6630f = (ImageView) this.f6619am.findViewById(C1494ai.check_back_thumbnail);
        this.f6615a.setEnabled(false);
        this.f6626b.setOnClickListener(this);
        this.f6615a.setOnClickListener(this);
        this.f6627c.setOnClickListener(this);
        this.f6628d.setOnClickListener(this);
        this.f6633i.setOnClickListener(this);
        this.f6616aj.setOnClickListener(this);
        this.f6617ak.setOnClickListener(this);
        if (GoDoughApp.getUserSettings().getRdaVerificationStatusResponse().getVelocity() == null || !GoDoughApp.getUserSettings().getRdaVerificationStatusResponse().getVelocity().isVelocityValid()) {
            this.f6617ak.setVisibility(8);
        }
        this.f6618al = this.f6619am.findViewById(C1494ai.account_zone);
        this.f6618al.setOnClickListener(this);
        m6688n();
        this.f6632h.setOnValueChanged(this);
        this.f6632h.setOnFocusChangeListener(new C1814e(this, this.f6632h.getOnFocusChangeListener()));
        this.f6632h.setOnBackKeyPressedListener(new C1815f(this));
        this.f6632h.setOnEditorActionListener(new C1816g(this));
        updateControls();
        if (this.f6624ar != null) {
            this.f6631g.setText(this.f6624ar.getName());
            this.f6631g.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        updateControls();
        m6689o();
        return this.f6619am;
    }

    public void onDestroy() {
        m6691q();
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
        if (this.f6625as == null) {
            if (this.f6620an == null || this.f6621ao == null) {
                reloadThumbnails();
            } else {
                this.f6629e.setImageBitmap(this.f6620an);
                this.f6630f.setImageBitmap(this.f6621ao);
            }
            updateControls();
        } else if (this.f6625as == null || !this.f6625as.mo10926c()) {
            mo10986b(getString(C1506am.ellipse_payment_processing));
        } else if (this.f6625as.mo10929e()) {
            this.f6625as.mo10922a().mo9589a(this.f6625as.mo10927d());
        } else {
            this.f6625as.mo10922a().mo9588a(this.f6625as.mo10925b());
        }
    }

    public void onValueChanged(DollarAmountEditText dollarAmountEditText) {
        updateControls();
    }

    public void reloadThumbnails() {
        C1879v.m6836a(getActivity(), 0);
        C1879v.m6836a(getActivity(), 1);
    }

    public void setImageView(Bitmap bitmap, int i) {
        switch (i) {
            case 0:
                this.f6620an = bitmap;
                this.f6629e.setImageBitmap(this.f6620an);
                return;
            case 1:
                this.f6621ao = bitmap;
                this.f6630f.setImageBitmap(this.f6621ao);
                return;
            default:
                return;
        }
    }

    public void submitData() {
        Deposit deposit = new Deposit();
        deposit.setAccount(getDepositAccount());
        deposit.setAmount(getCheckAmount());
        mo10986b(getString(C1506am.ellipse_depositing_check));
        this.f6625as = new C1810af(deposit, new C1837n(this, this, new C1835l(this)));
        this.f6625as.execute(new Void[0]);
    }

    public void updateControls() {
        long cents = this.f6632h.getCents();
        if (checkImagesExists(getActivity()) != 3 || cents <= 0 || this.f6624ar == null) {
            this.f6615a.setEnabled(false);
        } else {
            this.f6615a.setEnabled(true);
        }
    }
}
