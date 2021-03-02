package p006nl.volkerinfradesign.checkandroid.p007ui.inspections;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.app.ListFragment;
import android.support.p001v4.app.LoaderManager;
import android.support.p001v4.content.AsyncTaskLoader;
import android.support.p001v4.content.Loader;
import android.support.p001v4.widget.CursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.util.Iterator;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.Project;
import p006nl.volkerinfradesign.checkandroid.database.ProjectsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity */
public class ProjectsActivity extends FragmentActivity {
    public static final String PROJECT_SERVER_ID = "project_server_id";

    /* renamed from: k */
    private ProjectsFragment f5300k;

    public static Intent getIntent(Context context, Company company, Project project) {
        Intent intent = new Intent(context, ProjectsActivity.class);
        intent.putExtra("company_server_id", company.getServerId());
        if (project != null) {
            intent.putExtra("project_server_id", project.getServerId());
        }
        return intent;
    }

    public void onProjectSelected(long j) {
        Intent intent = new Intent();
        intent.putExtra("project_server_id", j);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f5300k = ProjectsFragment.m6237b(getIntent().getLongExtra("company_server_id", Long.MIN_VALUE), getIntent().getExtras().containsKey("project_server_id") ? Long.valueOf(getIntent().getLongExtra("project_server_id", Long.MIN_VALUE)) : null, true);
            getSupportFragmentManager().beginTransaction().add(16908290, this.f5300k, "projects_fragment_tag").commit();
            return;
        }
        this.f5300k = (ProjectsFragment) getSupportFragmentManager().findFragmentByTag("projects_fragment_tag");
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment */
    public static final class ProjectsFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {

        /* renamed from: aj */
        private Company f5301aj;

        /* renamed from: ak */
        private Long f5302ak;

        /* renamed from: al */
        private final View.OnFocusChangeListener f5303al = new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    String unused = ProjectsFragment.this.f5305an = null;
                    ProjectsFragment.this.getListAdapter().changeCursor(ProjectsFragment.this.m6231a(ProjectsFragment.this.f5305an));
                }
            }
        };

        /* renamed from: am */
        private final SearchView.OnQueryTextListener f5304am = new SearchView.OnQueryTextListener() {
            public boolean onQueryTextChange(String str) {
                String unused = ProjectsFragment.this.f5305an = str;
                ProjectsFragment.this.getListAdapter().changeCursor(ProjectsFragment.this.m6231a(str));
                return true;
            }

            public boolean onQueryTextSubmit(String str) {
                return false;
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: an */
        public String f5305an;

        /* renamed from: ao */
        private Long f5306ao;

        /* renamed from: i */
        private final SearchView.OnCloseListener f5307i = new SearchView.OnCloseListener() {
            public boolean onClose() {
                String unused = ProjectsFragment.this.f5305an = null;
                ProjectsFragment.this.getListAdapter().changeCursor(ProjectsFragment.this.m6231a(ProjectsFragment.this.f5305an));
                return true;
            }
        };

        /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$ProjectsEventActivity */
        public interface ProjectsEventActivity {
            void onProjectSelected(long j);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static ProjectsFragment m6237b(long j, Long l, boolean z) {
            ProjectsFragment projectsFragment = new ProjectsFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("company_server_id", j);
            bundle.putBoolean("download_on_init", z);
            if (l != null) {
                bundle.putLong("project_server_id", l.longValue());
            }
            projectsFragment.setArguments(bundle);
            return projectsFragment;
        }

        public ProjectsAdapter getListAdapter() {
            return (ProjectsAdapter) super.getListAdapter();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            new ActionBarCompat(getActivity()).setDisplayHomeAsUpEnabled(true);
            setListAdapter(new ProjectsAdapter());
            if (bundle == null) {
                boolean z = getArguments().getBoolean("download_on_init");
                long j = getArguments().getLong("project_server_id", Long.MIN_VALUE);
                if (j != Long.MIN_VALUE) {
                    this.f5306ao = Long.valueOf(j);
                }
                if (z) {
                    m6238l();
                }
            }
        }

        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            setHasOptionsMenu(true);
        }

        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            App app = (App) getActivity().getApplication();
            final Company m = m6239m();
            return new AsyncTaskLoader<Cursor>(getActivity()) {
                /* renamed from: b */
                public Cursor loadInBackground() {
                    try {
                        Project.downloadProjects(m, -1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return ProjectsFragment.this.m6231a(ProjectsFragment.this.f5305an);
                }
            };
        }

        public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
            super.onCreateOptionsMenu(menu, menuInflater);
            menuInflater.inflate(C1352R.C1355menu.projects_menu, menu);
            SearchView searchView = (SearchView) menu.findItem(C1352R.C1354id.search).getActionView();
            searchView.setOnQueryTextListener(this.f5304am);
            searchView.setOnCloseListener(this.f5307i);
            searchView.setOnQueryTextFocusChangeListener(this.f5303al);
        }

        public void onDestroy() {
            super.onDestroy();
            getListAdapter().changeCursor((Cursor) null);
        }

        public void onListItemClick(ListView listView, View view, int i, long j) {
            super.onListItemClick(listView, view, i, j);
            ((ProjectsActivity) getActivity()).onProjectSelected(j);
        }

        public void onLoaderReset(Loader<Cursor> loader) {
        }

        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            getLoaderManager().destroyLoader(23);
            getListAdapter().changeCursor(cursor);
        }

        public boolean onOptionsItemSelected(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == 16908332) {
                getActivity().onBackPressed();
                return true;
            } else if (itemId == C1352R.C1354id.downloadProjects) {
                m6238l();
                return true;
            } else if (itemId != C1352R.C1354id.uploadProject) {
                return super.onOptionsItemSelected(menuItem);
            } else {
                m6240n();
                return true;
            }
        }

        public void onResume() {
            super.onResume();
            getListView().setChoiceMode(1);
            if (this.f5306ao != null) {
                Cursor cursor = getListAdapter().getCursor();
                for (int i = 0; cursor.moveToPosition(i); i++) {
                    if (this.f5306ao.equals(Long.valueOf(cursor.getLong(cursor.getColumnIndex("server_id"))))) {
                        getListView().setItemChecked(i, true);
                        return;
                    }
                }
            }
        }

        /* renamed from: l */
        private void m6238l() {
            Loader loader = getLoaderManager().getLoader(23);
            if (loader == null) {
                loader = getLoaderManager().initLoader(23, (Bundle) null, this);
            } else {
                getLoaderManager().restartLoader(23, (Bundle) null, this);
            }
            loader.forceLoad();
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public Company m6239m() {
            if (this.f5302ak == null) {
                this.f5302ak = Long.valueOf(getArguments().getLong("company_server_id", Long.MIN_VALUE));
                if (this.f5302ak.longValue() == Long.MIN_VALUE) {
                    throw new IllegalStateException("The companyServerId is not specified");
                }
            }
            if (this.f5301aj == null) {
                Iterator<Company> it = ((App) getActivity().getApplication()).getRoot().getAllCompanies().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Company next = it.next();
                    if (this.f5302ak.equals(Long.valueOf(next.getServerId()))) {
                        this.f5301aj = next;
                        break;
                    }
                }
            }
            return this.f5301aj;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public synchronized Cursor m6231a(String str) {
            String[] strArr;
            String str2;
            if (this.f5302ak == null) {
                this.f5302ak = Long.valueOf(getArguments().getLong("company_server_id", Long.MIN_VALUE));
                if (this.f5302ak.longValue() == Long.MIN_VALUE) {
                    throw new IllegalStateException("The companyServerId is not specified");
                }
            }
            if (str != null) {
                if (str.length() != 0) {
                    str2 = ("company_server_id = ? AND " + "title LIKE '%" + str + "%' OR ") + "code LIKE '%" + str + "%'";
                    strArr = new String[]{this.f5302ak.toString()};
                }
            }
            str2 = "company_server_id = ?";
            strArr = new String[]{this.f5302ak.toString()};
            return Schema.getProjects().query((String[]) null, str2, strArr, (String) null, (String) null, (String) null);
        }

        /* renamed from: n */
        private void m6240n() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.add_project, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(16908308);
            final TextView textView2 = (TextView) inflate.findViewById(16908309);
            builder.setTitle("Project toevoegen");
            builder.setIcon(C1352R.C1353drawable.ic_action_edit);
            builder.setView(inflate);
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.setPositiveButton("Verzenden", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    String trim = textView.getText().toString().trim();
                    String trim2 = textView2.getText().toString().trim();
                    new C1629a().executeOnExecutor(C1629a.SERIAL_EXECUTOR, new Object[]{trim, trim2, Long.valueOf(ProjectsFragment.this.m6239m().getServerId())});
                }
            });
            builder.show();
        }

        /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$ProjectsAdapter */
        public class ProjectsAdapter extends CursorAdapter {
            private ProjectsAdapter() {
                super((Context) ProjectsFragment.this.getActivity(), ProjectsFragment.this.m6231a((String) null), 0);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((TextView) view.findViewById(16908308)).setText(cursor.getString(cursor.getColumnIndex("title")));
                ((TextView) view.findViewById(16908309)).setText(cursor.getString(cursor.getColumnIndex(ProjectsTable.CODE)));
            }

            public long getItemId(int i) {
                Cursor cursor = getCursor();
                if (cursor == null || !cursor.moveToPosition(i)) {
                    return Long.MIN_VALUE;
                }
                return cursor.getLong(cursor.getColumnIndex("server_id"));
            }

            public boolean hasStableIds() {
                return true;
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return ProjectsFragment.this.getActivity().getLayoutInflater().inflate(17367063, viewGroup, false);
            }
        }

        /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$a */
        class C1629a extends AsyncTask<Object, Void, C1630b> {
            private C1629a() {
            }

            /* JADX WARNING: type inference failed for: r2v22, types: [java.net.URLConnection] */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public p006nl.volkerinfradesign.checkandroid.p007ui.inspections.ProjectsActivity.ProjectsFragment.C1630b doInBackground(java.lang.Object... r13) {
                /*
                    r12 = this;
                    r3 = 1
                    r11 = 0
                    java.nio.charset.Charset r2 = org.apache.commons.p009io.Charsets.UTF_8
                    r2.name()
                    r2 = 0
                    r4 = r13[r2]
                    java.lang.String r4 = (java.lang.String) r4
                    r5 = r13[r3]
                    java.lang.String r5 = (java.lang.String) r5
                    r2 = 2
                    r2 = r13[r2]
                    r8 = r2
                    java.lang.Long r8 = (java.lang.Long) r8
                    nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment r2 = p006nl.volkerinfradesign.checkandroid.p007ui.inspections.ProjectsActivity.ProjectsFragment.this
                    android.support.v4.app.FragmentActivity r2 = r2.getActivity()
                    android.app.Application r2 = r2.getApplication()
                    nl.volkerinfradesign.checkandroid.App r2 = (p006nl.volkerinfradesign.checkandroid.App) r2
                    com.google.gson.GsonBuilder r2 = new com.google.gson.GsonBuilder     // Catch:{ Exception -> 0x00ca }
                    r2.<init>()     // Catch:{ Exception -> 0x00ca }
                    com.google.gson.GsonBuilder r2 = r2.setPrettyPrinting()     // Catch:{ Exception -> 0x00ca }
                    com.google.gson.Gson r3 = r2.create()     // Catch:{ Exception -> 0x00ca }
                    com.google.gson.JsonObject r6 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x00ca }
                    r6.<init>()     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r2 = "session"
                    nl.volkerinfradesign.checkandroid.AppState r7 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x00ca }
                    com.google.gson.JsonObject r7 = r7.getSIDJSON()     // Catch:{ Exception -> 0x00ca }
                    r6.add(r2, r7)     // Catch:{ Exception -> 0x00ca }
                    com.google.gson.JsonObject r2 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x00ca }
                    r2.<init>()     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r7 = "companyId"
                    r2.addProperty((java.lang.String) r7, (java.lang.Number) r8)     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r7 = "projectName"
                    r2.addProperty((java.lang.String) r7, (java.lang.String) r4)     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r7 = "projectNumber"
                    r2.addProperty((java.lang.String) r7, (java.lang.String) r5)     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r7 = "params"
                    r6.add(r7, r2)     // Catch:{ Exception -> 0x00ca }
                    nl.volkerinfradesign.checkandroid.AppState r2 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x00ca }
                    java.net.URL r2 = r2.getProjectPUTUrl()     // Catch:{ Exception -> 0x00ca }
                    java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x00ca }
                    r0 = r2
                    java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00ca }
                    r11 = r0
                    r2 = 10000(0x2710, float:1.4013E-41)
                    r11.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r2 = "Content-Type"
                    java.lang.String r7 = "text/json; charset=utf-8"
                    r11.setRequestProperty(r2, r7)     // Catch:{ Exception -> 0x00ca }
                    r2 = 1
                    r11.setDoInput(r2)     // Catch:{ Exception -> 0x00ca }
                    r2 = 1
                    r11.setDoOutput(r2)     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r2 = "POST"
                    r11.setRequestMethod(r2)     // Catch:{ Exception -> 0x00ca }
                    com.google.gson.stream.JsonWriter r2 = new com.google.gson.stream.JsonWriter     // Catch:{ Exception -> 0x00ca }
                    java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00ca }
                    java.io.OutputStream r9 = r11.getOutputStream()     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r10 = "UTF-8"
                    r7.<init>(r9, r10)     // Catch:{ Exception -> 0x00ca }
                    r2.<init>(r7)     // Catch:{ Exception -> 0x00ca }
                    r3.toJson((com.google.gson.JsonElement) r6, (com.google.gson.stream.JsonWriter) r2)     // Catch:{ Exception -> 0x00ca }
                    r2.close()     // Catch:{ Exception -> 0x00ca }
                    com.google.gson.JsonParser r2 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x00ca }
                    r2.<init>()     // Catch:{ Exception -> 0x00ca }
                    java.io.InputStream r3 = r11.getInputStream()     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r3 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r3)     // Catch:{ Exception -> 0x00ca }
                    com.google.gson.JsonElement r2 = r2.parse((java.lang.String) r3)     // Catch:{ Exception -> 0x00ca }
                    r0 = r2
                    com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x00ca }
                    r6 = r0
                    nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$b r2 = new nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$b     // Catch:{ Exception -> 0x00ca }
                    nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment r3 = p006nl.volkerinfradesign.checkandroid.p007ui.inspections.ProjectsActivity.ProjectsFragment.this     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r7 = "id"
                    com.google.gson.JsonElement r6 = r6.get(r7)     // Catch:{ Exception -> 0x00ca }
                    long r6 = r6.getAsLong()     // Catch:{ Exception -> 0x00ca }
                    long r8 = r8.longValue()     // Catch:{ Exception -> 0x00ca }
                    r10 = 0
                    r2.<init>(r4, r5, r6, r8)     // Catch:{ Exception -> 0x00ca }
                    if (r11 == 0) goto L_0x00c9
                    r11.disconnect()
                L_0x00c9:
                    return r2
                L_0x00ca:
                    r2 = move-exception
                    r3 = r2
                    nl.volkerinfradesign.checkandroid.AppState r2 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x0100 }
                    r2.invalidateLogin(r11)     // Catch:{ all -> 0x0100 }
                    java.io.InputStream r2 = r11.getErrorStream()     // Catch:{ Exception -> 0x00ee }
                    java.lang.String r4 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r2)     // Catch:{ Exception -> 0x00ee }
                    nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$b r2 = new nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$b     // Catch:{ Exception -> 0x00ee }
                    nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment r5 = p006nl.volkerinfradesign.checkandroid.p007ui.inspections.ProjectsActivity.ProjectsFragment.this     // Catch:{ Exception -> 0x00ee }
                    java.io.IOException r6 = new java.io.IOException     // Catch:{ Exception -> 0x00ee }
                    r6.<init>(r4)     // Catch:{ Exception -> 0x00ee }
                    r4 = 0
                    r2.<init>(r6)     // Catch:{ Exception -> 0x00ee }
                    if (r11 == 0) goto L_0x00c9
                    r11.disconnect()
                    goto L_0x00c9
                L_0x00ee:
                    r2 = move-exception
                    r2.printStackTrace()     // Catch:{ all -> 0x0100 }
                    nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$b r2 = new nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$b     // Catch:{ all -> 0x0100 }
                    nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment r4 = p006nl.volkerinfradesign.checkandroid.p007ui.inspections.ProjectsActivity.ProjectsFragment.this     // Catch:{ all -> 0x0100 }
                    r5 = 0
                    r2.<init>(r3)     // Catch:{ all -> 0x0100 }
                    if (r11 == 0) goto L_0x00c9
                    r11.disconnect()
                    goto L_0x00c9
                L_0x0100:
                    r2 = move-exception
                    if (r11 == 0) goto L_0x0106
                    r11.disconnect()
                L_0x0106:
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.p007ui.inspections.ProjectsActivity.ProjectsFragment.C1629a.doInBackground(java.lang.Object[]):nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$b");
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(C1630b bVar) {
                super.onPostExecute(bVar);
                ProjectsAdapter listAdapter = ProjectsFragment.this.getListAdapter();
                if (bVar.f5321d != null) {
                    Toast.makeText(ProjectsFragment.this.getActivity(), "Kon het project niet registreren op de server: " + bVar.toString(), 1).show();
                } else {
                    Schema.getProjects().putProject(bVar.f5320c.longValue(), bVar.f5322e, bVar.f5323f, bVar.f5319b.longValue());
                }
                if (listAdapter != null) {
                    listAdapter.changeCursor(ProjectsFragment.this.m6231a(ProjectsFragment.this.f5305an));
                }
            }
        }

        /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.ProjectsActivity$ProjectsFragment$b */
        class C1630b {
            /* access modifiers changed from: private */

            /* renamed from: b */
            public final Long f5319b;
            /* access modifiers changed from: private */

            /* renamed from: c */
            public final Long f5320c;
            /* access modifiers changed from: private */

            /* renamed from: d */
            public final Exception f5321d;
            /* access modifiers changed from: private */

            /* renamed from: e */
            public final String f5322e;
            /* access modifiers changed from: private */

            /* renamed from: f */
            public final String f5323f;

            private C1630b(Exception exc) {
                this.f5321d = exc;
                this.f5322e = null;
                this.f5323f = null;
                this.f5320c = null;
                this.f5319b = null;
            }

            private C1630b(String str, String str2, long j, long j2) {
                this.f5321d = null;
                this.f5322e = str;
                this.f5323f = str2;
                this.f5320c = Long.valueOf(j);
                this.f5319b = Long.valueOf(j2);
            }
        }
    }
}
