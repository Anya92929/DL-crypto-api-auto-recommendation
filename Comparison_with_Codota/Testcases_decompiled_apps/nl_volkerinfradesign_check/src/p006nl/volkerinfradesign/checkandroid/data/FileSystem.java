package p006nl.volkerinfradesign.checkandroid.data;

import java.io.File;

/* renamed from: nl.volkerinfradesign.checkandroid.data.FileSystem */
public final class FileSystem {

    /* renamed from: a */
    private static FileSystem f4702a;

    /* renamed from: b */
    private FormsDir f4703b;

    /* renamed from: c */
    private final File f4704c;

    /* renamed from: d */
    private StructuresDir f4705d;

    public static FileSystem get() {
        if (f4702a != null) {
            return f4702a;
        }
        throw new IllegalStateException("The FileSystem is not yet initialized");
    }

    public static void init(File file, int i) {
        if (f4702a != null) {
            return;
        }
        if (!file.isDirectory() || !file.exists()) {
            throw new IllegalArgumentException("The directory you provided is not valid!");
        }
        f4702a = new FileSystem(file, i);
    }

    private FileSystem(File file, int i) {
        this.f4704c = new File(file, "v" + i);
    }

    public FormsDir getFormsDir() {
        if (this.f4703b != null) {
            return this.f4703b;
        }
        FormsDir formsDir = new FormsDir(m5832a());
        this.f4703b = formsDir;
        return formsDir;
    }

    public StructuresDir getStructuresDir() {
        if (this.f4705d != null) {
            return this.f4705d;
        }
        StructuresDir structuresDir = new StructuresDir(m5832a());
        this.f4705d = structuresDir;
        return structuresDir;
    }

    /* renamed from: a */
    private File m5832a() {
        if (!this.f4704c.exists()) {
            this.f4704c.mkdirs();
        }
        return this.f4704c;
    }
}
