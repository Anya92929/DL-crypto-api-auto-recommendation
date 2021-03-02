package p006nl.volkerinfradesign.checkandroid.data;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;

/* renamed from: nl.volkerinfradesign.checkandroid.data.FormsDir */
public class FormsDir {

    /* renamed from: a */
    private final File f4706a;

    FormsDir(File file) {
        this.f4706a = new File(file, "forms");
        this.f4706a.mkdirs();
    }

    public Set<Long> getFormIds() {
        String[] list = this.f4706a.list();
        HashSet hashSet = new HashSet();
        if (list != null) {
            for (String str : list) {
                hashSet.add(Long.valueOf(str.substring(0, str.length() - 4)));
            }
        }
        return hashSet;
    }

    public boolean hasForm(long j) {
        File file = new File(this.f4706a, j + ".ser");
        return file.exists() && file.isFile() && file.length() > 0;
    }

    public Form loadForm(long j) {
        return (Form) SystemUtils.load(Form.class, new File(this.f4706a, j + ".ser"));
    }

    public void saveForm(Form form) {
        SystemUtils.save(form, new File(this.f4706a, form.getServerId() + ".ser"));
    }
}
