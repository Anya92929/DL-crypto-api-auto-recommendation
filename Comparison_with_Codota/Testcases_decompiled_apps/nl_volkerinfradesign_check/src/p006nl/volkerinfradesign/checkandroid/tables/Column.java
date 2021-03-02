package p006nl.volkerinfradesign.checkandroid.tables;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.Column */
public interface Column {
    String getDefaultValue();

    String getName();

    Table getTable();

    DataType getType();

    boolean isAutoIncrement();

    boolean isImportable();

    boolean isNotNull();

    boolean isPrimaryKey();

    boolean isUnique();

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.Column$DataType */
    public enum DataType {
        INTEGER,
        REAL,
        TEXT,
        BLOB;

        /* renamed from: a */
        static DataType m6033a(int i) {
            switch (i) {
                case 1:
                    return INTEGER;
                case 2:
                    return REAL;
                case 3:
                    return TEXT;
                case 4:
                    return BLOB;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
