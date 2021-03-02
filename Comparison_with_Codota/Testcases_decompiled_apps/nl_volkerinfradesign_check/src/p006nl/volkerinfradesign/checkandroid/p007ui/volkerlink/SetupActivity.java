package p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.app.FragmentTransaction;
import android.support.p001v4.util.LongSparseArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink.CompaniesFragment;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.SetupActivity */
public class SetupActivity extends FragmentActivity implements CompaniesFragment.CompaniesActivity, InitActivity {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f5604k;

    /* renamed from: l */
    private Root f5605l;

    /* renamed from: m */
    private SetupState f5606m;

    /* renamed from: n */
    private LongSparseArray<String> f5607n;

    public long getFormId() {
        long longExtra = getIntent().getLongExtra("formInspectionId", 0);
        if (longExtra != 0) {
            return longExtra;
        }
        if (AppState.getInstance().isDebugable()) {
            Toast.makeText(this, "The Intent should contain a formId", 1).show();
            return 0;
        }
        throw new IllegalStateException("The Intent should contain a formId");
    }

    public Root getRoot() {
        if (this.f5605l == null) {
            this.f5605l = mo10375b().getRoot();
            if (this.f5605l == null) {
                this.f5605l = mo10375b().loadRoot(true);
            }
        }
        return this.f5605l;
    }

    public SetupState getState() {
        if (this.f5606m == null) {
            if (mo10375b().getModel().getAccount() == null) {
                this.f5606m = SetupState.NO_USER;
            } else if (!hasForm()) {
                this.f5606m = SetupState.DOWNLOAD_FORM;
            } else if (!hasCompanies()) {
                this.f5606m = SetupState.DOWNLOAD_COMPANIES;
            } else {
                this.f5606m = SetupState.FINISHED;
            }
        }
        return this.f5606m;
    }

    public boolean hasCompanies() {
        return !getRoot().getAllCompanies().isEmpty();
    }

    public boolean hasForm() {
        return FileSystem.get().getFormsDir().hasForm(getFormId());
    }

    public boolean isCompaniesHintVisible() {
        return getPreferences(0).getBoolean("companies_hint_visibility", true);
    }

    public void notifyDownloadFinished(Set<Company> set) {
        CompaniesFragment.C1714a listAdapter;
        CompaniesFragment companiesFragment = (CompaniesFragment) getFragmentManager().findFragmentByTag("check:companies_fragment_tag");
        if (set.size() == 1) {
            onCompanySelected(((Company[]) set.toArray(new Company[set.size()]))[0]);
        } else if (companiesFragment != null && (listAdapter = companiesFragment.getListAdapter()) != null) {
            listAdapter.clear();
            listAdapter.addAll(set);
        }
    }

    public void notifyRootChanged() {
        this.f5605l = mo10375b().loadRoot(true);
    }

    public void onCompanySelected(final Company company) {
        if (hasForm()) {
            startActivity(InspectionActivity.getIntent(this, FileSystem.get().getFormsDir().loadForm(getFormId()).newInstance(company, m6442c(), m6443d()), false, C1352R.C1353drawable.ic_launcher_volker_link));
            finish();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(C1352R.C1353drawable.ic_action_warning);
        builder.setTitle("Formulier ontbreekt");
        builder.setMessage("Kan het formulier niet vinden. Wilt u hem nu downloaden?");
        builder.setNegativeButton(17039369, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039379, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!SetupActivity.this.f5604k) {
                    new AsyncTask<Long, Void, C1287is>() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public C1287is doInBackground(Long... lArr) {
                            try {
                                return new C1287is(Form.download(ArrayUtils.toPrimitive(lArr)));
                            } catch (Exception e) {
                                Exception exc = e;
                                exc.printStackTrace();
                                return new C1287is(exc);
                            }
                        }

                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public void onPostExecute(C1287is isVar) {
                            super.onPostExecute(isVar);
                            boolean unused = SetupActivity.this.f5604k = false;
                            SetupActivity.this.showProgress(SetupActivity.this.f5604k);
                            if (isVar.mo8646c()) {
                                Toast.makeText(SetupActivity.this, isVar.mo8644a().toString(), 1).show();
                            } else if (isVar.mo8647d()) {
                                isVar.mo8645b().save();
                                if (SetupActivity.this.hasForm()) {
                                    SetupActivity.this.onCompanySelected(company);
                                } else {
                                    Toast.makeText(SetupActivity.this, "Het formulier is niet (meer) beschikbaar.", 1).show();
                                }
                            } else {
                                Toast.makeText(SetupActivity.this, "Het formulier kan niet gedownload worden.", 1).show();
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            super.onPreExecute();
                            boolean unused = SetupActivity.this.f5604k = true;
                            SetupActivity.this.showProgress(true);
                        }
                    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Long[]{Long.valueOf(SetupActivity.this.getFormId())});
                }
            }
        }).show();
    }

    public void onInitDialogCancelled() {
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onSelectCompanyClicked() {
        getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).replace(16908290, new CompaniesFragment(), "check:companies_fragment_tag").commit();
    }

    public void setCompaniesHintVisibility(boolean z) {
        getPreferences(0).edit().putBoolean("companies_hint_visibility", z).apply();
    }

    public void setState(SetupState setupState) {
        this.f5606m = setupState;
    }

    public void showProgress(boolean z) {
        setProgressBarIndeterminateVisibility(z);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        setTheme(mo10375b().getModel().getCustomTheme().getMainStyle());
        super.onCreate(bundle);
        ActionBarCompat actionBarCompat = new ActionBarCompat(this);
        actionBarCompat.setDisplayHomeAsUpEnabled(true);
        if (getIntent() == null || !getIntent().hasExtra("formTitle")) {
            actionBarCompat.setTitle("Klantcontant");
        } else {
            actionBarCompat.setTitle(getIntent().getStringExtra("formTitle"));
        }
        if (getState() == SetupState.FINISHED && getRoot() != null && getRoot().getAllCompanies() != null && getRoot().getAllCompanies().size() == 1) {
            Set<Company> allCompanies = getRoot().getAllCompanies();
            onCompanySelected(((Company[]) allCompanies.toArray(new Company[allCompanies.size()]))[0]);
        } else if (bundle == null) {
            FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(16908290, new CompaniesFragment(), "check:companies_fragment_tag");
            beginTransaction.commit();
            if (getState() != SetupState.FINISHED) {
                android.app.FragmentTransaction beginTransaction2 = fragmentManager.beginTransaction();
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag("check:init_total_fragment_tag");
                if (findFragmentByTag != null) {
                    beginTransaction2.remove(findFragmentByTag);
                }
                new InitTotalFragment().show(beginTransaction2, "dialog");
            }
        } else {
            this.f5606m = SetupState.valueOf(bundle.getString("check:saved_state"));
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("check:saved_state", getState().name());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public App mo10375b() {
        return (App) getApplication();
    }

    /* renamed from: c */
    private LongSparseArray<String> m6442c() {
        if (this.f5607n == null) {
            this.f5607n = new LongSparseArray<>();
            Iterator<JsonElement> it = new JsonParser().parse(getIntent().getStringExtra("answers")).getAsJsonArray().iterator();
            while (it.hasNext()) {
                JsonObject asJsonObject = it.next().getAsJsonObject();
                this.f5607n.put(asJsonObject.get("formInspectionItemId").getAsLong(), asJsonObject.get("answer").getAsString());
            }
        }
        return this.f5607n;
    }

    /* renamed from: d */
    private InspectionsTable.InitialLocation m6443d() {
        Intent intent = getIntent();
        if (!intent.hasExtra("geoLat") || !intent.hasExtra("geoLong")) {
            return null;
        }
        final double doubleExtra = intent.getDoubleExtra("geoLat", 0.0d);
        final double doubleExtra2 = intent.getDoubleExtra("geoLong", 0.0d);
        return new InspectionsTable.InitialLocation() {
            public double getLat() {
                return doubleExtra;
            }

            public double getlong() {
                return doubleExtra2;
            }
        };
    }
}
