package p006nl.volkerinfradesign.checkandroid.data.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p006nl.volkerinfradesign.checkandroid.database.ProjectsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Company */
public class Company extends Folder {
    private static final long serialVersionUID = 8351717821705107204L;

    /* renamed from: b */
    private transient ArrayList<Project> f4712b;

    Company(String str, String str2, long j) {
        super(str, str2, j);
    }

    public List<Project> getProjects() {
        if (this.f4712b == null) {
            ViTaCursor query = Schema.getProjects().query((String[]) null, "company_server_id = ?", new String[]{Long.toString(getServerId())}, (String) null, (String) null, (String) null);
            this.f4712b = new ArrayList<>();
            for (int i = 0; query.moveToPosition(i); i++) {
                this.f4712b.add(new Project(query.getString(query.getColumnIndex("title")), query.getLong(query.getColumnIndex("server_id")), query.getString(query.getColumnIndex(ProjectsTable.CODE))));
            }
        }
        return Collections.unmodifiableList(this.f4712b);
    }
}
