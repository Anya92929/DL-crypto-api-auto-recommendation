package p006nl.volkerinfradesign.checkandroid.data.tree;

import java.io.IOException;
import p006nl.volkerinfradesign.checkandroid.database.Schema;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Project */
public class Project extends Item {
    private static final long serialVersionUID = 1281220377286777072L;

    /* renamed from: a */
    private final String f4750a;

    public static void downloadProjects(Company company, int i) throws IOException {
        downloadProjects(company.getServerId(), i);
    }

    public static void downloadProjects(long j, int i) throws IOException {
        Schema.getProjects().update(j, i);
    }

    public Project(String str, long j, String str2) {
        super(str, (String) null, j);
        this.f4750a = str2;
    }

    public String getCode() {
        return this.f4750a;
    }

    public String toString() {
        return getTitle() + " #" + getServerId();
    }
}
