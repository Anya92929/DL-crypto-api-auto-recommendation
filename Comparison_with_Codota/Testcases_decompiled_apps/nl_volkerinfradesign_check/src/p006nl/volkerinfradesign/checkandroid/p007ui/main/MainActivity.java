package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Observable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentTransaction;
import android.support.p001v4.widget.DrawerLayout;
import android.support.p004v7.app.ActionBarDrawerToggle;
import android.support.p004v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.io.File;
import java.util.HashSet;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.OnBackPressedObservable;
import p006nl.volkerinfradesign.checkandroid.background.AllInService;
import p006nl.volkerinfradesign.checkandroid.background.CheckService;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormRef;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.p007ui.formFinder.FormFinderFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspections.ClosedFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspections.InspectionsListener;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.LoginActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.main.DrawerFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.tasks.TasksFragment;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.MainActivity */
public class MainActivity extends AppCompatActivity implements OnBackPressedObservable, FormFinderFragment.FormFinderActivity, ClosedFragment.ClosedInspectionsActivity, DrawerFragment.DrawerFragmentParent, TasksFragment.TasksActivity {
    protected static final String FORM_SERVER_IDS = null;
    public final InspectionsListener inspectionClickListener = new InspectionsListener() {
        public void onInspectionDeleted(InspectionsTable.DataCursor dataCursor, int i, long j) {
            MainActivity.this.m6321b().mo10228b();
        }

        @Deprecated
        public void onOpenInspectionClicked(InspectionsTable.DataCursor dataCursor, int i, long j) {
            Toast.makeText(MainActivity.this, "Dit is niet meer beschikbaar!", 0).show();
            AppState.getInstance().log().mo8930e("Error in MainActivity: Dit is niet meer beschikbaar!", new Throwable("Dit is niet meer beschikbaar!"));
        }

        public void uploadInspections() {
            Toast.makeText(MainActivity.this, "De gegevens worden gesynchroniseerd. U kunt ondertussen doorgaan.", 0).show();
            MainActivity.this.uploadInspections();
        }
    };

    /* renamed from: k */
    private final C1679a f5447k = new C1679a();

    /* renamed from: l */
    private DrawerLayout f5448l;

    /* renamed from: m */
    private C1682d f5449m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f5450n = false;

    /* renamed from: o */
    private final FormFinderFragment.FormActionListener f5451o = new FormFinderFragment.FormActionListener() {
        public void onFormClick(Company company, FormRef formRef) {
            Intent intent;
            if (Schema.getInspectionData().hasOpen(formRef)) {
                FragmentTransaction beginTransaction = MainActivity.this.getSupportFragmentManager().beginTransaction();
                Fragment findFragmentByTag = MainActivity.this.getSupportFragmentManager().findFragmentByTag("check:select_inspection_dialog");
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
                beginTransaction.addToBackStack((String) null);
                SelectInspectionFragment.newInstance(company, formRef).show(beginTransaction, "check:select_inspection_dialog");
                return;
            }
            if (formRef.hasForm()) {
                intent = InspectionActivity.getIntent((Context) MainActivity.this, formRef.newInstance(company), false);
            } else {
                intent = InspectionActivity.getIntent((Context) MainActivity.this, formRef, company);
            }
            MainActivity.this.startActivityForResult(intent, 933);
        }
    };

    /* renamed from: p */
    private FragmentLayout f5452p;

    /* renamed from: q */
    private final C1681c f5453q = new C1681c();

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.MainActivity$StorageState */
    public interface StorageState {
        File getPicturesDir();

        boolean isAvailable();

        boolean isStorageReadable();

        boolean isStorageWritable();
    }

    public void finishProgress() {
        setProgressBarIndeterminateVisibility(false);
        m6321b().mo10228b();
    }

    public App getApp() {
        return (App) getApplication();
    }

    public void onBackPressed() {
        if (m6322c().isDrawerOpen(3)) {
            m6322c().closeDrawer(3);
        } else if (this.f5447k.onActivityBackPressed()) {
        } else {
            if (!this.f5450n) {
                Toast.makeText(this, "Druk nogmaals om de applicatie af te sluiten", 0).show();
                new C1680b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6323d().onConfigurationChanged(configuration);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (m6323d().onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void registerOnBackPressedObserver(OnBackPressedObservable.OnBackPressedObserver onBackPressedObserver) {
        this.f5447k.registerObserver(onBackPressedObserver);
    }

    public void showInspection(InspectionKey inspectionKey, boolean z) {
        startActivityForResult(InspectionActivity.getIntent((Context) this, inspectionKey, z), 933);
    }

    public void showProgress(MenuItem menuItem, boolean z) {
        setProgressBarIndeterminateVisibility(true);
        if (z) {
            startService(CheckService.getIntents().downloadForms(getApplicationContext(), getApp().getRoot().getForms(), true));
        }
    }

    public void unregisterOnBackPressedObserver(OnBackPressedObservable.OnBackPressedObserver onBackPressedObserver) {
        this.f5447k.unregisterObserver(onBackPressedObserver);
    }

    public boolean uploadInspections() {
        InspectionsTable inspectionData = Schema.getInspectionData();
        if (inspectionData.setPending() <= 0 && !inspectionData.hasPending(false)) {
            return false;
        }
        ((App) getApplication()).notifyDataSetChanged();
        m6321b().mo10228b();
        AllInService.start(getApplicationContext());
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 933:
                if (i2 == -1 && intent.getBooleanExtra(InspectionActivity.RESULT_UPLOAD_INSPECTIONS, false)) {
                    uploadInspections();
                }
                try {
                    m6321b().mo10228b();
                    ((App) getApplication()).notifyDataSetChanged();
                    return;
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    return;
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    return;
                }
            case 3408:
                App app = (App) getApplication();
                if (i2 == -1) {
                    C1681c b = m6321b();
                    startService(CheckService.getIntents().downloadStructure(getApplicationContext()));
                    if (b != null) {
                        b.mo10228b();
                        return;
                    }
                    return;
                }
                finish();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        super.onCreate(bundle);
        App app = (App) getApplication();
        IntentFilter intentFilter = new IntentFilter();
        setTheme(app.getModel().getCustomTheme().getMainStyle());
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        if (!getApp().getModel().getAccountState().isFinished() || !getApp().getModel().hasAccount()) {
            Intent intent = new Intent(this, LoginActivity.class);
            AppState.getInstance().setSID((String) null);
            intent.setFlags(335544320);
            startActivity(intent);
        } else {
            if (app.isTasksUpdateTime()) {
                startService(CheckService.getIntents().downloadTasks(getApplicationContext()));
            }
            if (app.isUpdateAccountInfoTime()) {
            }
            if (app.isStructureUpdateTime()) {
                startService(CheckService.getIntents().downloadStructure(this));
            }
        }
        if (AppState.getInstance().getPublishState() != AppState.PublishState.BETA) {
            new C1283iq(this).executeOnExecutor(C1283iq.SERIAL_EXECUTOR, new String[]{getPackageName()});
        }
        new ActionBarCompat(this).setDisplayHomeAsUpEnabled(true);
        setContentView(C1352R.layout.main_layout);
        m6322c().setDrawerListener(m6323d());
        m6322c().setDrawerShadow(C1352R.C1353drawable.drawer_shadow, 3);
        if (bundle == null) {
            m6321b().mo10227a(DrawerItem.B_NEW_FORM);
            onDrawerItemClicked(DrawerItem.B_NEW_FORM);
            uploadInspections();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean z = getPreferences(0).getBoolean("check:first_drawer_usage", true);
        DrawerItem a = m6321b().mo10226a();
        m6323d().syncState();
        if (a != null) {
            m6318a(a);
        }
        if (z) {
            m6322c().openDrawer(3);
        }
        if (z || FileSystem.get().getStructuresDir().isEmpty()) {
            startService(CheckService.getIntents().downloadStructure(getApplicationContext()));
            Toast.makeText(this, "De boomstructuur wordt gedownload...", 1).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(DrawerItem.B_NEW_FORM.name());
        if (findFragmentByTag != null && (findFragmentByTag instanceof FormFinderFragment)) {
            ((FormFinderFragment) findFragmentByTag).setOnFormClickListener(this.f5451o);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10213a(FormRef formRef, Company company) {
        Intent intent = InspectionActivity.getIntent((Context) this, formRef, company);
        m6321b().mo10228b();
        startActivityForResult(intent, 933);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public C1681c m6321b() {
        return this.f5453q;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public DrawerLayout m6322c() {
        if (this.f5448l != null) {
            return this.f5448l;
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(C1352R.C1354id.drawer_layout);
        this.f5448l = drawerLayout;
        return drawerLayout;
    }

    /* renamed from: d */
    private C1682d m6323d() {
        if (this.f5449m != null) {
            return this.f5449m;
        }
        C1682d dVar = new C1682d();
        this.f5449m = dVar;
        return dVar;
    }

    /* renamed from: e */
    private FragmentLayout m6324e() {
        if (this.f5452p != null) {
            return this.f5452p;
        }
        FragmentLayout fragmentLayout = (FragmentLayout) findViewById(16908312);
        this.f5452p = fragmentLayout;
        return fragmentLayout;
    }

    /* renamed from: a */
    private void m6318a(DrawerItem drawerItem) {
        getSupportActionBar();
        ActionBarCompat actionBarCompat = new ActionBarCompat(this);
        actionBarCompat.setTitle(drawerItem.getText(this));
        actionBarCompat.setDisplayShowTitleEnabled(true);
    }

    public void onDrawerItemClicked(DrawerItem drawerItem) {
        Fragment switchFragment = m6324e().switchFragment(drawerItem);
        if (switchFragment instanceof FormFinderFragment) {
            ((FormFinderFragment) switchFragment).setOnFormClickListener(this.f5451o);
        }
        m6322c().closeDrawer(3);
        m6318a(drawerItem);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.MainActivity$c */
    final class C1681c {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public DrawerObserver f5461b;

        private C1681c() {
        }

        /* renamed from: a */
        public void mo10227a(DrawerItem drawerItem) {
            if (this.f5461b != null) {
                this.f5461b.setCheckedDrawerItem(drawerItem);
            }
        }

        /* renamed from: a */
        public DrawerItem mo10226a() {
            if (this.f5461b != null) {
                return this.f5461b.getCheckedDrawerItem();
            }
            return null;
        }

        /* renamed from: b */
        public void mo10228b() {
            if (this.f5461b != null) {
                this.f5461b.notifyDataSetChanged();
            }
        }
    }

    public void setDrawerObserver(DrawerObserver drawerObserver) {
        DrawerObserver unused = this.f5453q.f5461b = drawerObserver;
    }

    public void onLogoutClicked() {
        final ProgressDialog show = ProgressDialog.show(this, "Afmelden", "Applicatie is bezig met het afmelden van " + getApp().getModel().getAccount().getEmail(), true);
        getApp().getModel().logout(new Model.LogoutFinishedCallback() {
            public void logoutFinished() {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), LoginActivity.class);
                intent.setFlags(335544320);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
                show.dismiss();
            }
        });
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.MainActivity$a */
    class C1679a extends Observable<OnBackPressedObservable.OnBackPressedObserver> implements OnBackPressedObservable.OnBackPressedObserver {
        private C1679a() {
        }

        public boolean onActivityBackPressed() {
            HashSet hashSet = new HashSet();
            synchronized (this.mObservers) {
                for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                    hashSet.add(Boolean.valueOf(((OnBackPressedObservable.OnBackPressedObserver) this.mObservers.get(size)).onActivityBackPressed()));
                }
            }
            return hashSet.contains(true);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.MainActivity$b */
    class C1680b extends AsyncTask<Void, Void, Void> {
        private C1680b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                Thread.sleep(1200);
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            boolean unused = MainActivity.this.f5450n = false;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = MainActivity.this.f5450n = true;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.MainActivity$d */
    class C1682d extends ActionBarDrawerToggle {
        public C1682d() {
            super(MainActivity.this, MainActivity.this.m6322c(), C1352R.string.drawerOpen, C1352R.string.drawerClosed);
        }

        public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);
            MainActivity.this.getPreferences(0).edit().putBoolean("check:first_drawer_usage", false).apply();
        }
    }
}
