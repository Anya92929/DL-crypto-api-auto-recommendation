package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p001v4.app.ListFragment;
import android.support.p001v4.widget.CursorAdapter;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.lang.reflect.Field;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Project;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.ProjectsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.util.SimpleTextWatcher;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2 */
public class ProjectsFragment2 extends ListFragment {

    /* renamed from: aj */
    private Boolean f5165aj;

    /* renamed from: ak */
    private ProjectsParent f5166ak;

    /* renamed from: i */
    private InspectionKey f5167i;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$ProjectsParent */
    public interface ProjectsParent {
        void onProjectSelected(InspectionKey inspectionKey, long j);
    }

    public static final ProjectsFragment2 newInstance(InspectionKey inspectionKey, boolean z) {
        ProjectsFragment2 projectsFragment2 = new ProjectsFragment2();
        Bundle bundle = new Bundle();
        bundle.putParcelable("projects_fragment:inspection_key", inspectionKey);
        bundle.putBoolean("projects_fragment:is_preview", z);
        projectsFragment2.setArguments(bundle);
        return projectsFragment2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setListAdapter(new C1603a());
        if (bundle == null) {
            new C1604b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{Long.valueOf(m6166l().getCompanyServerId())});
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setEmptyText("Geen projecten beschikbaar");
        getListView().setChoiceMode(m6167m() ? 0 : 1);
        getListView().setTextFilterEnabled(true);
        getListAdapter().setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence charSequence) {
                return ProjectsFragment2.this.m6166l().getFilteredProjects(charSequence);
            }
        });
        if (bundle == null) {
            int p = m6170p();
            switch (p) {
                case -1:
                    return;
                default:
                    getListView().setItemChecked(p, true);
                    return;
            }
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.projects_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(C1352R.C1354id.search).getActionView();
        C1603a listAdapter = getListAdapter();
        searchView.setOnQueryTextListener(listAdapter);
        searchView.setOnCloseListener(listAdapter);
        searchView.setOnQueryTextFocusChangeListener(listAdapter);
        m6163a(searchView);
        m6164b(searchView);
        menu.findItem(C1352R.C1354id.uploadProject).setVisible(!m6167m());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            getActivity().onBackPressed();
            return true;
        } else if (itemId == C1352R.C1354id.downloadProjects) {
            new C1604b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{Long.valueOf(m6166l().getCompanyServerId())});
            return true;
        } else if (itemId != C1352R.C1354id.uploadProject) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m6168n();
            return true;
        }
    }

    public C1603a getListAdapter() {
        return (C1603a) super.getListAdapter();
    }

    /* renamed from: a */
    private void m6163a(SearchView searchView) {
        try {
            Field declaredField = SearchView.class.getDeclaredField("mCloseButton");
            declaredField.setAccessible(true);
            ((ImageView) declaredField.get(searchView)).setImageResource(C1352R.C1353drawable.ic_action_cancel);
            Field declaredField2 = SearchView.class.getDeclaredField("mSearchButton");
            declaredField2.setAccessible(true);
            ((ImageView) declaredField2.get(searchView)).setImageResource(C1352R.C1353drawable.ic_action_search);
        } catch (Exception e) {
            AppState.getInstance().log().mo8930e("Error in ProjectsFragment", e);
        }
    }

    /* renamed from: b */
    private void m6164b(SearchView searchView) {
        EditText editText = (EditText) searchView.findViewById(searchView.getContext().getResources().getIdentifier("android:id/search_src_text", (String) null, (String) null));
        editText.setTextColor(getActivity().getResources().getColor(C1352R.color.vw_text_white));
        editText.setImeOptions(3);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public InspectionKey m6166l() {
        if (this.f5167i != null) {
            return this.f5167i;
        }
        InspectionKey inspectionKey = (InspectionKey) getArguments().getParcelable("projects_fragment:inspection_key");
        this.f5167i = inspectionKey;
        return inspectionKey;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean m6167m() {
        if (this.f5165aj == null) {
            this.f5165aj = Boolean.valueOf(getArguments().getBoolean("projects_fragment:is_preview", false));
        }
        return this.f5165aj.booleanValue();
    }

    /* renamed from: n */
    private void m6168n() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.add_project, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(16908308);
        final EditText editText2 = (EditText) inflate.findViewById(16908309);
        editText.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                editText.setError(StringUtils.isBlank(editable.toString().trim()) ? "Naam mag niet leeg zijn!" : null);
            }
        });
        editText2.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                editText2.setError(StringUtils.isBlank(editable.toString().trim()) ? "Code mag niet leeg zijn!" : null);
            }
        });
        builder.setTitle("Project toevoegen");
        builder.setIcon(C1352R.C1353drawable.ic_action_add);
        builder.setView(inflate);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton("Verzenden", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String trim = editText.getText().toString().trim();
                String trim2 = editText2.getText().toString().trim();
                if (StringUtils.isBlank(trim)) {
                    Toast.makeText(ProjectsFragment2.this.getActivity(), "Naam mag niet leeg zijn!", 1).show();
                } else if (StringUtils.isBlank(trim2)) {
                    Toast.makeText(ProjectsFragment2.this.getActivity(), "Code mag niet leeg zijn!", 1).show();
                } else {
                    new C1605c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{trim, trim2, Long.valueOf(ProjectsFragment2.this.m6166l().getCompanyServerId())});
                }
            }
        });
        builder.show();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        m6169o().onProjectSelected(m6166l(), getListAdapter().getItem(i).getServerId());
    }

    /* renamed from: o */
    private ProjectsParent m6169o() {
        if (this.f5166ak == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null || !(parentFragment instanceof ProjectsParent)) {
                parentFragment = getActivity();
            }
            this.f5166ak = (ProjectsParent) parentFragment;
        }
        return this.f5166ak;
    }

    /* renamed from: p */
    private int m6170p() {
        C1603a listAdapter;
        Long selectedProjectId = m6166l().getSelectedProjectId();
        if (!(selectedProjectId == null || (listAdapter = getListAdapter()) == null)) {
            ProjectsTable.ProjectsCursor a = listAdapter.getCursor();
            for (int i = 0; a.moveToPosition(i); i++) {
                if (a.getServerId() == selectedProjectId.longValue()) {
                    return a.getPosition();
                }
            }
        }
        return -1;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$a */
    class C1603a extends CursorAdapter implements View.OnFocusChangeListener, SearchView.OnCloseListener, SearchView.OnQueryTextListener {

        /* renamed from: b */
        private final LayoutInflater f5177b = ProjectsFragment2.this.getActivity().getLayoutInflater();

        public C1603a() {
            super((Context) ProjectsFragment2.this.getActivity(), (Cursor) ProjectsFragment2.this.m6166l().getProjects(), 2);
        }

        public void bindView(View view, Context context, Cursor cursor) {
            ProjectsTable.ProjectsCursor projectsCursor = (ProjectsTable.ProjectsCursor) cursor;
            ((TextView) view.findViewById(16908308)).setText(projectsCursor.getTitle());
            ((TextView) view.findViewById(16908309)).setText(projectsCursor.getCode());
        }

        /* renamed from: a */
        public ProjectsTable.ProjectsCursor getCursor() {
            return (ProjectsTable.ProjectsCursor) super.getCursor();
        }

        /* renamed from: a */
        public ProjectsTable.ProjectsCursor getItem(int i) {
            return (ProjectsTable.ProjectsCursor) super.getItem(i);
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return this.f5177b.inflate(C1352R.layout.simple_list_item_activated_2, viewGroup, false);
        }

        public boolean areAllItemsEnabled() {
            return !ProjectsFragment2.this.m6167m();
        }

        public boolean isEnabled(int i) {
            return !ProjectsFragment2.this.m6167m();
        }

        public boolean onClose() {
            getFilter().filter((CharSequence) null);
            notifyDataSetChanged();
            return true;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                getFilter().filter((CharSequence) null);
                notifyDataSetChanged();
            }
        }

        public boolean onQueryTextChange(String str) {
            getFilter().filter(str);
            notifyDataSetChanged();
            return true;
        }

        public boolean onQueryTextSubmit(String str) {
            getFilter().filter(str);
            notifyDataSetChanged();
            return true;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$b */
    class C1604b extends AsyncTask<Object, Void, Exception> {
        private C1604b() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Exception doInBackground(Object... objArr) {
            IOException e = null;
            try {
                Project.downloadProjects(objArr[0].longValue(), -1);
            } catch (IOException e2) {
                e = e2;
                AppState.getInstance().log().mo8930e("Error in ProjectsFragment", e);
            }
            return e;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Exception exc) {
            super.onPostExecute(exc);
            if (exc != null) {
                Toast.makeText(ProjectsFragment2.this.getActivity(), exc.toString(), 1).show();
                return;
            }
            C1603a listAdapter = ProjectsFragment2.this.getListAdapter();
            if (listAdapter != null) {
                listAdapter.changeCursor(ProjectsFragment2.this.m6166l().getProjects());
            }
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$c */
    class C1605c extends AsyncTask<Object, Void, C1606d> {
        private C1605c() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX WARNING: type inference failed for: r2v18, types: [java.net.URLConnection] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p006nl.volkerinfradesign.checkandroid.p007ui.inspection.ProjectsFragment2.C1606d doInBackground(java.lang.Object... r13) {
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
                com.google.gson.GsonBuilder r2 = new com.google.gson.GsonBuilder     // Catch:{ IOException -> 0x00d9 }
                r2.<init>()     // Catch:{ IOException -> 0x00d9 }
                com.google.gson.GsonBuilder r2 = r2.setPrettyPrinting()     // Catch:{ IOException -> 0x00d9 }
                com.google.gson.Gson r3 = r2.create()     // Catch:{ IOException -> 0x00d9 }
                com.google.gson.JsonObject r6 = new com.google.gson.JsonObject     // Catch:{ IOException -> 0x00d9 }
                r6.<init>()     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r2 = "session"
                nl.volkerinfradesign.checkandroid.AppState r7 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ IOException -> 0x00d9 }
                com.google.gson.JsonObject r7 = r7.getSIDJSON()     // Catch:{ IOException -> 0x00d9 }
                r6.add(r2, r7)     // Catch:{ IOException -> 0x00d9 }
                com.google.gson.JsonObject r2 = new com.google.gson.JsonObject     // Catch:{ IOException -> 0x00d9 }
                r2.<init>()     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r7 = "companyId"
                r2.addProperty((java.lang.String) r7, (java.lang.Number) r8)     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r7 = "projectName"
                r2.addProperty((java.lang.String) r7, (java.lang.String) r4)     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r7 = "projectNumber"
                r2.addProperty((java.lang.String) r7, (java.lang.String) r5)     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r7 = "params"
                r6.add(r7, r2)     // Catch:{ IOException -> 0x00d9 }
                nl.volkerinfradesign.checkandroid.AppState r2 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ IOException -> 0x00d9 }
                java.net.URL r2 = r2.getProjectPUTUrl()     // Catch:{ IOException -> 0x00d9 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00d9 }
                r0 = r2
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x00d9 }
                r11 = r0
                r2 = 10000(0x2710, float:1.4013E-41)
                r11.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r2 = "Content-Type"
                java.lang.String r7 = "text/json; charset=utf-8"
                r11.setRequestProperty(r2, r7)     // Catch:{ IOException -> 0x00d9 }
                r2 = 1
                r11.setDoInput(r2)     // Catch:{ IOException -> 0x00d9 }
                r2 = 1
                r11.setDoOutput(r2)     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r2 = "POST"
                r11.setRequestMethod(r2)     // Catch:{ IOException -> 0x00d9 }
                com.google.gson.stream.JsonWriter r2 = new com.google.gson.stream.JsonWriter     // Catch:{ IOException -> 0x00d9 }
                java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00d9 }
                java.io.OutputStream r9 = r11.getOutputStream()     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r10 = "UTF-8"
                r7.<init>(r9, r10)     // Catch:{ IOException -> 0x00d9 }
                r2.<init>(r7)     // Catch:{ IOException -> 0x00d9 }
                r3.toJson((com.google.gson.JsonElement) r6, (com.google.gson.stream.JsonWriter) r2)     // Catch:{ IOException -> 0x00d9 }
                r2.close()     // Catch:{ IOException -> 0x00d9 }
                com.google.gson.JsonParser r2 = new com.google.gson.JsonParser     // Catch:{ IOException -> 0x00d9 }
                r2.<init>()     // Catch:{ IOException -> 0x00d9 }
                java.io.InputStream r3 = r11.getInputStream()     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r3 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r3)     // Catch:{ IOException -> 0x00d9 }
                com.google.gson.JsonElement r2 = r2.parse((java.lang.String) r3)     // Catch:{ IOException -> 0x00d9 }
                boolean r3 = r2.isJsonObject()     // Catch:{ IOException -> 0x00d9 }
                if (r3 == 0) goto L_0x00c4
                com.google.gson.JsonObject r6 = r2.getAsJsonObject()     // Catch:{ IOException -> 0x00d9 }
                nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d r2 = new nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d     // Catch:{ IOException -> 0x00d9 }
                nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2 r3 = p006nl.volkerinfradesign.checkandroid.p007ui.inspection.ProjectsFragment2.this     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r7 = "id"
                com.google.gson.JsonElement r6 = r6.get(r7)     // Catch:{ IOException -> 0x00d9 }
                long r6 = r6.getAsLong()     // Catch:{ IOException -> 0x00d9 }
                long r8 = r8.longValue()     // Catch:{ IOException -> 0x00d9 }
                r10 = 0
                r2.<init>(r4, r5, r6, r8)     // Catch:{ IOException -> 0x00d9 }
                if (r11 == 0) goto L_0x00c3
                r11.disconnect()
            L_0x00c3:
                return r2
            L_0x00c4:
                nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d r2 = new nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d     // Catch:{ IOException -> 0x00d9 }
                nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2 r3 = p006nl.volkerinfradesign.checkandroid.p007ui.inspection.ProjectsFragment2.this     // Catch:{ IOException -> 0x00d9 }
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x00d9 }
                java.lang.String r5 = "Project already exists!"
                r4.<init>(r5)     // Catch:{ IOException -> 0x00d9 }
                r5 = 0
                r2.<init>(r4)     // Catch:{ IOException -> 0x00d9 }
                if (r11 == 0) goto L_0x00c3
                r11.disconnect()
                goto L_0x00c3
            L_0x00d9:
                r2 = move-exception
                r3 = r2
                nl.volkerinfradesign.checkandroid.AppState r2 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x010f }
                r2.invalidateLogin(r11)     // Catch:{ all -> 0x010f }
                java.io.InputStream r2 = r11.getErrorStream()     // Catch:{ Exception -> 0x00fd }
                java.lang.String r4 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r2)     // Catch:{ Exception -> 0x00fd }
                nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d r2 = new nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d     // Catch:{ Exception -> 0x00fd }
                nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2 r5 = p006nl.volkerinfradesign.checkandroid.p007ui.inspection.ProjectsFragment2.this     // Catch:{ Exception -> 0x00fd }
                java.io.IOException r6 = new java.io.IOException     // Catch:{ Exception -> 0x00fd }
                r6.<init>(r4)     // Catch:{ Exception -> 0x00fd }
                r4 = 0
                r2.<init>(r6)     // Catch:{ Exception -> 0x00fd }
                if (r11 == 0) goto L_0x00c3
                r11.disconnect()
                goto L_0x00c3
            L_0x00fd:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ all -> 0x010f }
                nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d r2 = new nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d     // Catch:{ all -> 0x010f }
                nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2 r4 = p006nl.volkerinfradesign.checkandroid.p007ui.inspection.ProjectsFragment2.this     // Catch:{ all -> 0x010f }
                r5 = 0
                r2.<init>(r3)     // Catch:{ all -> 0x010f }
                if (r11 == 0) goto L_0x00c3
                r11.disconnect()
                goto L_0x00c3
            L_0x010f:
                r2 = move-exception
                if (r11 == 0) goto L_0x0115
                r11.disconnect()
            L_0x0115:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.p007ui.inspection.ProjectsFragment2.C1605c.doInBackground(java.lang.Object[]):nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C1606d dVar) {
            super.onPostExecute(dVar);
            if (dVar.f5183d != null) {
                Toast.makeText(ProjectsFragment2.this.getActivity(), "Kon het project niet registreren op de server: " + dVar.f5183d.toString(), 1).show();
                return;
            }
            Schema.getProjects().putProject(dVar.f5182c.longValue(), dVar.f5184e, dVar.f5185f, dVar.f5181b.longValue());
            ProjectsFragment2.this.getListAdapter().changeCursor(ProjectsFragment2.this.m6166l().getProjects());
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ProjectsFragment2$d */
    class C1606d {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Long f5181b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final Long f5182c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Exception f5183d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final String f5184e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public final String f5185f;

        private C1606d(Exception exc) {
            this.f5183d = exc;
            this.f5184e = null;
            this.f5185f = null;
            this.f5182c = null;
            this.f5181b = null;
        }

        private C1606d(String str, String str2, long j, long j2) {
            this.f5183d = null;
            this.f5184e = str;
            this.f5185f = str2;
            this.f5182c = Long.valueOf(j);
            this.f5181b = Long.valueOf(j2);
        }
    }
}
