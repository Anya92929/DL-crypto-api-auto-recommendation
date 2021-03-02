package p006nl.volkerinfradesign.checkandroid.p007ui.login;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.Account;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.ChiefWrapper;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.AccountUpdateDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.ChiefFragment;
import p006nl.volkerinfradesign.checkandroid.util.SimpleTextWatcher;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.login.AccountFragment */
public final class AccountFragment extends Fragment implements AccountUpdateDialog.AccountUpdateDialogParent, ChiefFragment.PersonInChargeFragmentParent {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final DateFormat f5331a = SimpleDateFormat.getDateInstance();

    /* renamed from: aj */
    private EditText f5332aj;

    /* renamed from: ak */
    private EditText f5333ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public Button f5334al;

    /* renamed from: am */
    private Button f5335am;

    /* renamed from: an */
    private Button f5336an;

    /* renamed from: ao */
    private Button f5337ao;

    /* renamed from: ap */
    private AccountFragmentParent f5338ap;

    /* renamed from: b */
    private final TextWatcher f5339b = new SimpleTextWatcher() {
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            AccountFragment.this.m6260o().setFirstName(editable.toString().trim());
        }
    };

    /* renamed from: c */
    private final TextWatcher f5340c = new SimpleTextWatcher() {
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            AccountFragment.this.m6260o().setMiddleName(editable.toString().trim());
        }
    };

    /* renamed from: d */
    private final TextWatcher f5341d = new SimpleTextWatcher() {
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            AccountFragment.this.m6260o().setLastName(editable.toString().trim());
        }
    };

    /* renamed from: e */
    private final TextWatcher f5342e = new SimpleTextWatcher() {
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            AccountFragment.this.m6260o().setVcaNumber(editable.toString().trim());
        }
    };

    /* renamed from: f */
    private final TextWatcher f5343f = new SimpleTextWatcher() {
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            AccountFragment.this.m6260o().setPhoneMobile(editable.toString().trim());
        }
    };

    /* renamed from: g */
    private EditText f5344g;

    /* renamed from: h */
    private EditText f5345h;

    /* renamed from: i */
    private EditText f5346i;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.login.AccountFragment$AccountFragmentParent */
    public interface AccountFragmentParent {
        void onAccountEditingCancelled();

        void onAccountEditingFinished();
    }

    public static AccountFragment newInstance(boolean z) {
        AccountFragment accountFragment = new AccountFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("initial_update_account", z);
        accountFragment.setArguments(bundle);
        return accountFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.account_details, menu);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.account_details, viewGroup, false);
        this.f5344g = (EditText) inflate.findViewById(C1352R.C1354id.firstName);
        this.f5345h = (EditText) inflate.findViewById(C1352R.C1354id.middleName);
        this.f5346i = (EditText) inflate.findViewById(C1352R.C1354id.lastName);
        this.f5332aj = (EditText) inflate.findViewById(C1352R.C1354id.vcaNumber);
        this.f5333ak = (EditText) inflate.findViewById(C1352R.C1354id.phoneMobile);
        this.f5334al = (Button) inflate.findViewById(C1352R.C1354id.birthDay);
        this.f5335am = (Button) inflate.findViewById(C1352R.C1354id.confirm);
        this.f5336an = (Button) inflate.findViewById(C1352R.C1354id.cancel);
        this.f5337ao = (Button) inflate.findViewById(C1352R.C1354id.personInCharge);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        m6257l();
        if (bundle == null && getArguments() != null && getArguments().getBoolean("initial_update_account", false)) {
            m6251a(true, false);
        }
    }

    /* renamed from: l */
    private void m6257l() {
        this.f5344g.removeTextChangedListener(this.f5339b);
        this.f5345h.removeTextChangedListener(this.f5340c);
        this.f5346i.removeTextChangedListener(this.f5341d);
        this.f5332aj.removeTextChangedListener(this.f5342e);
        this.f5333ak.removeTextChangedListener(this.f5343f);
        this.f5344g.getText().clear();
        if (m6260o().hasFirstName()) {
            this.f5344g.append(m6260o().getFirstName());
        }
        this.f5345h.getText().clear();
        if (m6260o().hasMiddleName()) {
            this.f5345h.append(m6260o().getMiddleName());
        }
        this.f5346i.getText().clear();
        if (m6260o().hasLastName()) {
            this.f5346i.append(m6260o().getLastName());
        }
        this.f5332aj.getText().clear();
        if (m6260o().hasVcaNumber()) {
            this.f5332aj.append(m6260o().getVcaNumber());
        }
        this.f5333ak.getText().clear();
        if (m6260o().hasPhoneMobile()) {
            this.f5333ak.append(m6260o().getPhoneMobile());
        }
        if (m6260o().hasBirthDay()) {
            this.f5334al.setText(this.f5331a.format(m6260o().getBirthDay().getTime()));
        } else {
            this.f5334al.setText("Geboortedatum");
        }
        this.f5337ao.setText(m6260o().hasChief() ? m6260o().getChief().getName() : "Selecteer leidinggevende");
        this.f5344g.addTextChangedListener(this.f5339b);
        this.f5345h.addTextChangedListener(this.f5340c);
        this.f5346i.addTextChangedListener(this.f5341d);
        this.f5332aj.addTextChangedListener(this.f5342e);
        this.f5333ak.addTextChangedListener(this.f5343f);
        this.f5334al.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AccountFragment.this.m6259n();
            }
        });
        this.f5337ao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AccountFragment.this.m6258m();
            }
        });
        this.f5335am.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AccountFragment.this.m6251a(false, true);
            }
        });
        this.f5336an.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AccountFragment.this.m6262q().onAccountEditingCancelled();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m6258m() {
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("person_in_charge_tag");
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        new ChiefFragment().show(beginTransaction, "person_in_charge_tag");
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            m6262q().onAccountEditingCancelled();
            return true;
        } else if (itemId == C1352R.C1354id.confirmAccount) {
            m6251a(false, true);
            return true;
        } else if (itemId != C1352R.C1354id.cancelAccount) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m6262q().onAccountEditingCancelled();
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6251a(boolean z, boolean z2) {
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("account_details_fragment:dialog_tag");
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        AccountUpdateDialog.newInstance(z, z2).show(beginTransaction, "account_details_fragment:dialog_tag");
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6259n() {
        Calendar calendar;
        if (m6260o().hasBirthDay()) {
            calendar = m6260o().getBirthDay();
        } else {
            Calendar instance = Calendar.getInstance();
            instance.set(1, instance.get(1) - 30);
            calendar = instance;
        }
        new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(0);
                instance.set(1, i);
                instance.set(2, i2);
                instance.set(5, i3);
                AccountFragment.this.m6260o().setBirthDay(instance);
                AccountFragment.this.f5334al.setText(AccountFragment.this.f5331a.format(instance.getTime()));
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public Account m6260o() {
        return m6261p().getModel().getAccount();
    }

    /* renamed from: p */
    private App m6261p() {
        return (App) getActivity().getApplication();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public AccountFragmentParent m6262q() {
        if (this.f5338ap == null) {
            Object parentFragment = getParentFragment();
            if (this.f5338ap == null) {
                parentFragment = getActivity();
            }
            this.f5338ap = (AccountFragmentParent) parentFragment;
        }
        return this.f5338ap;
    }

    public void personInChargeSelected(ChiefWrapper chiefWrapper) {
        m6261p().getModel().getAccount().setChief(chiefWrapper);
        this.f5337ao.setText(chiefWrapper.getName());
    }

    public void onAccountUpdated(boolean z) {
        m6257l();
        if (z) {
            m6262q().onAccountEditingFinished();
        }
    }
}
